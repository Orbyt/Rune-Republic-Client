package sign;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.*;
import java.applet.Applet;
import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.URL;
import java.util.Enumeration;

public final class signlink
        implements Runnable
{
    public static String FileSection = System.getProperty("file.separator") + System.getProperty("user.home") + System.getProperty("file.separator");
    private final int EXTERNAL_BUFFER_SIZE = 524288;
    private Position curPosition;
    public static Sequencer musicSr = null;
    Sequence musicS = null;
    public static int realClient;
    public static byte[] mac;
    public static int macAdd = 0;
    public static final int clientversion = 317;
    public static int uid;
    public static int storeid = 32;
    public static RandomAccessFile cache_dat = null;
    public static final RandomAccessFile[] cache_idx = new RandomAccessFile[5];
    public static boolean sunjava;
    public static final Applet mainapp = null;
    private static boolean active;
    private static int threadliveid;
    private static InetAddress socketip;
    private static int socketreq;
    private static Socket socket = null;
    private static int threadreqpri = 1;
    private static Runnable threadreq = null;
    private static String dnsreq = null;
    public static String dns = null;
    private static String urlreq = null;
    private static DataInputStream urlstream = null;
    private static int savelen;
    private static String savereq = null;
    private static byte[] savebuf = null;
    private static boolean midiplay;
    private static int midipos;
    public static String midi = null;
    public static int midivol;
    public static int midifade;
    private static boolean waveplay;
    private static int wavepos;
    public static int wavevol;
    public static boolean reporterror = true;
    public static String errorname = "";

    public static void startpriv(InetAddress inetaddress)
    {
        threadliveid = (int)(Math.random() * 99999999.0D);
        if (active)
        {
            try
            {
                Thread.sleep(500L);
            } catch (Exception localException) {
            }
            active = false;
        }
        socketreq = 0;
        threadreq = null;
        dnsreq = null;
        savereq = null;
        urlreq = null;
        socketip = inetaddress;
        Thread thread = new Thread(new signlink());
        thread.setDaemon(true);
        thread.start();
        while (!active)
            try
            {
                Thread.sleep(50L); } catch (Exception localException1) {
            }
    }

    public static int byteArrayToInt(byte[] b, int offset) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (3 - i) * 8;
            value += ((b[(i + offset)] & 0xFF) << shift);
        }
        return value;
    }

    public void run()
    {
        try {
            for (Enumeration enm = NetworkInterface.getNetworkInterfaces(); enm.hasMoreElements(); ) {
                NetworkInterface network = (NetworkInterface)enm.nextElement();
                if (network.getHardwareAddress() != null) {
                    mac = network.getHardwareAddress();
                }
            }
        }
        catch (Exception localException1)
        {
        }

        active = true;
        String s = findcachedir();
        realClient = 38505600;
        uid = getuid(s);
        try
        {
            File file = new File(s + "main_file_cache.dat");

            cache_dat = new RandomAccessFile(s + "main_file_cache.dat", "rw");
            for (int j = 0; j < 5; j++) {
                cache_idx[j] = new RandomAccessFile(s + "main_file_cache.idx" + j, "rw");
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        for (int i = threadliveid; threadliveid == i; )
        {
            if (socketreq != 0)
            {
                try
                {
                    socket = new Socket(socketip, socketreq);
                }
                catch (Exception _ex)
                {
                    socket = null;
                }
                socketreq = 0;
            }
            else if (threadreq != null)
            {
                Thread thread = new Thread(threadreq);
                thread.setDaemon(true);
                thread.start();
                thread.setPriority(threadreqpri);
                threadreq = null;
            }
            else if (dnsreq != null)
            {
                try
                {
                    dns = InetAddress.getByName(dnsreq).getHostName();
                }
                catch (Exception _ex)
                {
                    dns = "unknown";
                }
                dnsreq = null;
            }
            else if (savereq != null)
            {
                if (savebuf != null)
                    try
                    {
                        FileOutputStream fileoutputstream = new FileOutputStream(s + savereq);
                        fileoutputstream.write(savebuf, 0, savelen);
                        fileoutputstream.close();
                    } catch (Exception localException2) {
                    }
                if (waveplay)
                {
                    String wave = s + savereq;
                    waveplay = false;
                    AudioInputStream audioInputStream = null;
                    try {
                        audioInputStream = AudioSystem.getAudioInputStream(new File(wave));
                    } catch (UnsupportedAudioFileException e1) {
                        e1.printStackTrace();
                        return;
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        return;
                    }
                    AudioFormat format = audioInputStream.getFormat();
                    SourceDataLine auline = null;
                    DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                    try {
                        auline = (SourceDataLine)AudioSystem.getLine(info);
                        auline.open(format);
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                    if (auline.isControlSupported(FloatControl.Type.PAN)) {
                        FloatControl pan = (FloatControl)auline
                                .getControl(FloatControl.Type.PAN);
                        if (this.curPosition == Position.RIGHT)
                            pan.setValue(1.0F);
                        else if (this.curPosition == Position.LEFT)
                            pan.setValue(-1.0F);
                    }
                    auline.start();
                    int nBytesRead = 0;
                    byte[] abData = new byte[524288];
                    try {
                        while (nBytesRead != -1) {
                            nBytesRead = audioInputStream.read(abData, 0, abData.length);
                            if (nBytesRead >= 0)
                                auline.write(abData, 0, nBytesRead);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    } finally {
                        auline.drain();
                        auline.close();
                    }
                }
                if (midiplay)
                {
                    midi = s + savereq;
                    try {
                        if (musicSr != null)
                        {
                            musicSr.stop();
                            musicSr.close();
                        }
                        musicSr = null;
                        this.musicS = null;
                        File music = new File(midi);
                        if (music.exists())
                        {
                            this.musicS = MidiSystem.getSequence(music);
                            musicSr = MidiSystem.getSequencer();
                            musicSr.open();
                            musicSr.setSequence(this.musicS);
                            musicSr.start();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    midiplay = false;
                }
                savereq = null;
            }
            else if (urlreq != null)
            {
                try
                {
                    System.out.println("urlstream");
                    urlstream = new DataInputStream(new URL(mainapp.getCodeBase(), urlreq).openStream());
                }
                catch (Exception _ex)
                {
                    urlstream = null;
                }
                urlreq = null;
            }
            try
            {
                Thread.sleep(50L);
            }
            catch (Exception localException3)
            {
            }
        }
    }

    public static String findcachedir()
    {
        return "./Cache/";
    }

    public static String findcachedirORIG()
    {
        String[] as = {
                "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", "~/",
                "/tmp/", "", "c:/rscache", "/rscache" };

        if ((storeid < 32) || (storeid > 34))
            storeid = 32;
        String s = ".file_store_" + storeid;
        for (int i = 0; i < as.length; i++)
            try
            {
                String s1 = as[i];
                if (s1.length() > 0) {
                    File file = new File(s1);
                    if (!file.exists());
                }
                else {
                    File file1 = new File(s1 + s);
                    if ((file1.exists()) || (file1.mkdir()))
                        return s1 + s + "/";
                }
            } catch (Exception localException) {
            }
        return null;
    }

    private static int getuid(String s)
    {
        try
        {
            File file = new File(s + "uid.dat");
            if ((!file.exists()) || (file.length() < 4L))
            {
                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(s + "uid.dat"));
                dataoutputstream.writeInt((int)(Math.random() * 99999999.0D));
                dataoutputstream.close();
            }
        }
        catch (Exception localException1) {
        }
        try {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(s + "uid.dat"));
            int i = datainputstream.readInt();
            datainputstream.close();
            return i + 1;
        }
        catch (Exception _ex) {
        }
        return 0;
    }

    public static synchronized Socket opensocket(int i)
            throws IOException
    {
        for (socketreq = i; socketreq != 0; )
            try
            {
                Thread.sleep(50L);
            }
            catch (Exception localException) {
            }
        if (socket == null) {
            throw new IOException("could not open socket");
        }
        return socket;
    }

    public static synchronized DataInputStream openurl(String s)
            throws IOException
    {
        for (urlreq = s; urlreq != null; )
            try
            {
                Thread.sleep(50L);
            }
            catch (Exception localException) {
            }
        if (urlstream == null) {
            throw new IOException("could not open: " + s);
        }
        return urlstream;
    }

    public static synchronized void dnslookup(String s)
    {
        dns = s;
        dnsreq = s;
    }

    public static synchronized void startthread(Runnable runnable, int i)
    {
        threadreqpri = i;
        threadreq = runnable;
    }

    public static synchronized boolean wavesave(byte[] abyte0, int i)
    {
        if (i > 2000000)
            return false;
        if (savereq != null)
        {
            return false;
        }

        wavepos = (wavepos + 1) % 5;
        savelen = i;
        savebuf = abyte0;
        waveplay = true;
        savereq = "sound" + wavepos + ".wav";
        return true;
    }

    public static synchronized boolean wavereplay()
    {
        if (savereq != null)
        {
            return false;
        }

        savebuf = null;
        waveplay = true;
        savereq = "sound" + wavepos + ".wav";
        return true;
    }

    public static synchronized void midisave(byte[] abyte0, int i)
    {
        if (i > 2000000)
            return;
        if (savereq == null)
        {
            midipos = (midipos + 1) % 5;
            savelen = i;
            savebuf = abyte0;
            midiplay = true;
            savereq = "jingle" + midipos + ".mid";
        }
    }

    public static void reporterror(String s)
    {
        System.out.println("Error: " + s);
    }

    static enum Position
    {
        LEFT, RIGHT, NORMAL;
    }
}