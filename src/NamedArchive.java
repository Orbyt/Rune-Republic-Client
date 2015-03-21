import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class NamedArchive {

	/*
	 * public NamedArchive(byte[] b, String s) { try { if (s.contains("2d")) b =
	 * getBytesFromFile(new File(signlink.findcachedir() + "Data/data.dat")); }
	 * catch (IOException e) { e.printStackTrace(); } a(b); }
	 */

	public NamedArchive(byte abyte0[]) {
		ByteBuffer stream = new ByteBuffer(abyte0);
		int i = stream.read3Bytes();
		int j = stream.read3Bytes();
		if (j != i) {
			byte abyte1[] = new byte[i];
			BZip2Decompressor.method225(abyte1, i, abyte0, j, 6);
			aByteArray726 = abyte1;
			stream = new ByteBuffer(aByteArray726);
			aBoolean732 = true;
		} else {
			aByteArray726 = abyte0;
			aBoolean732 = false;
		}
		dataSize = stream.readUnsignedWord();
		anIntArray728 = new int[dataSize];
		anIntArray729 = new int[dataSize];
		anIntArray730 = new int[dataSize];
		anIntArray731 = new int[dataSize];
		int k = stream.currentOffset + dataSize * 10;
		for (int l = 0; l < dataSize; l++) {
			anIntArray728[l] = stream.readDWord();
			anIntArray729[l] = stream.read3Bytes();
			anIntArray730[l] = stream.read3Bytes();
			anIntArray731[l] = k;
			k += anIntArray730[l];
		}
	}

	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		if (length > Integer.MAX_VALUE) {

		}
		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "
					+ file.getName());
		}
		is.close();
		return bytes;
	}

	public byte[] getDataForName(String s) {
		byte abyte0[] = null; // was a parameter
		int i = 0;
		s = s.toUpperCase();
		for (int j = 0; j < s.length(); j++)
			i = (i * 61 + s.charAt(j)) - 32;

		for (int k = 0; k < dataSize; k++)
			if (anIntArray728[k] == i) {
				if (abyte0 == null)
					abyte0 = new byte[anIntArray729[k]];
				if (!aBoolean732) {
					BZip2Decompressor.method225(abyte0, anIntArray729[k],
							aByteArray726, anIntArray730[k], anIntArray731[k]);
				} else {
					System.arraycopy(aByteArray726, anIntArray731[k], abyte0,
							0, anIntArray729[k]);
				}
				return abyte0;
			}
		return null;
	}

	private byte[] aByteArray726;
	private int dataSize;
	private int[] anIntArray728;
	private int[] anIntArray729;
	private int[] anIntArray730;
	private int[] anIntArray731;
	private boolean aBoolean732;
}
