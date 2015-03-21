import java.io.*;
import java.util.zip.GZIPInputStream;

import sign.signlink;

public class ModelDecompressor {

	public static void unpackModels(String name) {
		try {
			GZIPInputStream gzipDataFile = new GZIPInputStream(new FileInputStream(signlink.findcachedir() + name + ".dat"));
			DataInputStream dataFile = new DataInputStream(gzipDataFile);
			GZIPInputStream gzipIndexFile = new GZIPInputStream(new FileInputStream(signlink.findcachedir() + name + ".idx"));
			DataInputStream indexFile = new DataInputStream(gzipIndexFile);
			int length = indexFile.readInt();
			for (int i = 0; i < length; i++) {
				int id = indexFile.readInt();
				int invlength = indexFile.readInt();
				byte[] data = new byte[invlength];
				dataFile.readFully(data);
				Model.method460(data, id);
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public static void loadFrames()
	{
		Stream stream = new Stream(FileOperations.ReadFile(signlink.findcachedir()+"main_file_cache.anims"));
		int numAnims = stream.g2();
		animationData = new byte[numAnims][];
		for(int i = 0; i < numAnims; i++)
		{
			int fileID = stream.g2();
			int compressedSize = stream.g4();
			byte[] compressedData = stream.getData(new byte[compressedSize]);
			byte[] decompressedData = decompress(compressedData);
			animationData[fileID] = decompressedData;
		}
	}*/
	
	public static byte[] decompress(byte[] data) {
		try {
			GZIPInputStream gZip = new GZIPInputStream(new ByteArrayInputStream(data));
			ByteArrayOutputStream bytes = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length;
			while ((length = gZip.read(buffer)) > 0) {
				bytes.write(buffer, 0, length);
			}
			gZip.close();
			bytes.close();
			return bytes.toByteArray();
		} catch (Exception failed) {
			failed.printStackTrace();
			return null;
		}
	}
}