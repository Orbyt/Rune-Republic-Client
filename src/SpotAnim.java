// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class SpotAnim {

	public static void unpackConfig(StreamLoader streamLoader) {
		Stream stream = new Stream(FileOperations.ReadFile("Cache/Animations/602spotanim.dat"));
		Stream stream2 = new Stream(streamLoader.getDataForName("spotanim.dat"));
		int length = stream.readUnsignedWord();
		int length2 = stream2.readUnsignedWord();
		if (cache == null)
			cache = new SpotAnim[length + length2];
		for (int j = 0; j < (length + length2); j++) {
			if (cache[j] == null)
				cache[j] = new SpotAnim();
			cache[j].anInt404 = j;
			if (j < length)
				cache[j].readValues(stream);
			else
				cache[j].readValues2(stream2);
			if (j == 1247) {
				cache[j].anInt405 = 60776;
				cache[j].aAnimation_407 = Animation.anims[4001];
			}
			if (j == 1248) {
				cache[j].anInt405 = 60776;
				cache[j].aAnimation_407 = Animation.anims[4002];
			}
		}

	}
	
	public void readValues2(Stream buffer) {
		for (;;) {
			int opcode = buffer.readUnsignedByte();
			if (opcode == 0) {
				break;
			}
			if (opcode == 1) {
				anInt405 = buffer.readUnsignedWord();
				if (anInt404 >= 2617 && anInt405 <= 29191 && anInt405 != -1)
					anInt405 = anInt405 + 70000;
			} else if (opcode == 2) {
				anInt406 = buffer.readUnsignedWord();
				if (Animation.anims != null) {
					aAnimation_407 = Animation.anims[anInt406];
				}
			} else if (opcode == 4) {
				anInt410 = buffer.readUnsignedWord();
			} else if (opcode == 5) {
				anInt411 = buffer.readUnsignedWord();
			} else if (opcode == 6) {
				anInt412 = buffer.readUnsignedWord();
			} else if (opcode == 7) {
				anInt413 = buffer.readUnsignedByte();
			} else if (opcode == 8) {
				anInt414 = buffer.readUnsignedByte();
			} else if (opcode >= 40 && opcode < 50) {
				anIntArray408[opcode - 40] = buffer.readUnsignedWord();
			} else if (opcode >= 50 && opcode < 60) {
				anIntArray409[opcode - 50] = buffer.readUnsignedWord();
			} else {
				System.out.println("Error unrecognised spotanim config code: " + opcode);
			}
		}
	}

	public void readValues(Stream stream) {
		do {
			anInt406 = stream.readUnsignedWord();
			anInt405 = stream.readUnsignedWord();
			// leechModel(anInt405); <-- NEVER EVER RUN THIS DERP
			if (Animation.anims != null && anInt406 != 65535 && anInt406 != -1)
				aAnimation_407 = Animation.anims[anInt406];
			anInt410 = stream.readUnsignedByte();
			anInt411 = stream.readUnsignedByte();
			int j = stream.readUnsignedWord();
			if (j != 65535) {
				for (int k = 0; k < j; k++)
					anIntArray409[k] = stream.readUnsignedWord();
				for (int k = 0; k < j; k++)
					anIntArray408[k] = stream.readUnsignedWord();
			}
			break;
		} while (true);
	}

	public static int getCorrectColours(int i) {
		String s = Integer.toHexString(i).toUpperCase();
		String str;
		if (s.length() > 4) {
			str = s.substring(4);
		} else {
			str = s;
		}
		int i2 = Integer.parseInt(str, 16);
		return i2;
	}

	public Model getModel() {
		Model model = (Model) aMRUNodes_415.insertFromCache(anInt404);
		if (model != null)
			return model;
		model = Model.method462(anInt405);
		if (model == null)
			return null;
		for (int i = 0; i < 6; i++)
			if (anIntArray408[0] != 0)
				model.method476(anIntArray408[i], anIntArray409[i]);

		aMRUNodes_415.removeFromCache(model, anInt404);
		return model;
	}

	public SpotAnim() {
		anInt400 = 9;
		anInt406 = -1;
		anIntArray408 = new int[6];
		anIntArray409 = new int[6];
		anInt410 = 128;
		anInt411 = 128;
	}

	public final int anInt400;
	public static SpotAnim cache[];
	public int anInt404;
	public int anInt405;
	public int anInt406;
	public Animation aAnimation_407;
	public final int[] anIntArray408;
	public final int[] anIntArray409;
	public int anInt410;
	public int anInt411;
	public int anInt412;
	public int anInt413;
	public int anInt414;
	public static MRUNodes aMRUNodes_415 = new MRUNodes(30);

}