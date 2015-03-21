public final class Class36 {

	public static Class36 animationDataList[][];

	public static Class36 method531(int j) {
		try {
			if (animationDataList == null)
				return null;
			String hex = Integer.toHexString(j);
			int animationDataID = Integer.parseInt(hex.substring(0, (hex.length() - 4)), 16);
			int animationFrames = Integer.parseInt(hex.substring((hex.length() - 4)), 16);
			if (animationDataList[animationDataID].length == 0) {
				if (animationDataID == 3155) {
					readSplit(animationDataID);
				} else if (animationDataID == 3403 || animationDataID == 3353 || animationDataID == 3502 || animationDataID == 1208 || animationDataID == 1773) {
					readCustomFile(animationDataID);
				} else {
					client.instance.onDemandFetcher.method558(1, animationDataID);
				}
				//return animationDataList[animationDataID][animationFrames];
			}
			return animationDataList[animationDataID][animationFrames];
		} catch (Exception ex) {
		}
		return null;
	}
	
	public static void readSplit(int file) {
		try {
			Stream stream = new Stream(FileOperations.ReadFile("Cache/Animations/Frames/" + file + ".dat"));
			Stream stream1 = new Stream(FileOperations.ReadFile("Cache/Animations/Skins/" + file + ".dat"));
			Class18 class18 = new Class18(stream1, 0);
			int k1 = stream.readUnsignedWord();
			animationDataList[file] = new Class36[k1];
			int ai[] = new int[500];
			int ai1[] = new int[500];
			int ai2[] = new int[500];
			int ai3[] = new int[500];
			for (int l1 = 0; l1 < k1; l1++) {
				int i2 = stream.readUnsignedWord();
				Class36 class36 = animationDataList[file][i2] = new Class36();
				class36.aClass18_637 = class18;
				int j2 = stream.readUnsignedByte();
				int l2 = 0;
				int k2 = -1;
				for (int i3 = 0; i3 < j2; i3++) {
					int j3 = stream.readUnsignedByte();
					if (j3 > 0) {
						if (class18.anIntArray342[i3] != 0) {
							for (int l3 = i3 - 1; l3 > k2; l3--) {
								if (class18.anIntArray342[l3] != 0)
									continue;
								ai[l2] = l3;
								ai1[l2] = 0;
								ai2[l2] = 0;
								ai3[l2] = 0;
								l2++;
								break;
							}
						}
						ai[l2] = i3;
						short c = 0;
						if (class18.anIntArray342[i3] == 3)
							c = (short) 128;
						if ((j3 & 1) != 0)
							ai1[l2] = (short) stream.readShort2();
						else
							ai1[l2] = c;
						if ((j3 & 2) != 0)
							ai2[l2] = stream.readShort2();
						else
							ai2[l2] = c;
						if ((j3 & 4) != 0)
							ai3[l2] = stream.readShort2();
						else
							ai3[l2] = c;
						/*if (class18.anIntArray342[i3] == 2 || class18.anIntArray342[i3] == 9) {
							if((j3 & 1) != 0)
								ai1[l2] = (short) (ai1[l2] / 16);
							if((j3 & 2) != 0)
								ai2[l2] = (short) (ai2[l2] / 16);
							if((j3 & 4) != 0)
								ai3[l2] = (short) (ai3[l2] / 16);
						} else if (class18.anIntArray342[i3] == 1){
							if((j3 & 1) != 0)
								ai1[l2] = (short) (ai1[l2] / 4);
							if((j3 & 2) != 0)
								ai2[l2] = (short) (ai2[l2] / 4);
							if((j3 & 4) != 0)
								ai3[l2] = (short) (ai3[l2] / 4);
						}*/
						k2 = i3;
						l2++;
					}
				}
				class36.anInt638 = l2;
				class36.anIntArray639 = new int[l2];
				class36.anIntArray640 = new int[l2];
				class36.anIntArray641 = new int[l2];
				class36.anIntArray642 = new int[l2];
				for (int k3 = 0; k3 < l2; k3++) {
					class36.anIntArray639[k3] = ai[k3];
					class36.anIntArray640[k3] = ai1[k3];
					class36.anIntArray641[k3] = ai2[k3];
					class36.anIntArray642[k3] = ai3[k3];
				}
			}
		} catch (Exception exception) {
		}
	}

	public static void nullLoader() {
		animationDataList = null;
	}

	public static boolean method532(int i) {
		return i == -1;
	}

	public static void readCacheFile(byte animationData[], int animationDataID) {
		try {
			Stream buffer = new Stream(animationData);
			Class18 skins = new Class18(buffer, 0);
			int k1 = buffer.readUnsignedWord();
			animationDataList[animationDataID] = new Class36[k1];
			// System.out.println(animationDataID);
			int ai[] = new int[500];
			int ai1[] = new int[500];
			int ai2[] = new int[500];
			int ai3[] = new int[500];
			for (int l1 = 0; l1 < k1; l1++) {
				int i2 = buffer.readUnsignedWord();
				Class36 animation = animationDataList[animationDataID][i2] = new Class36();
				animation.aClass18_637 = skins;
				int j2 = buffer.readUnsignedByte();
				int l2 = 0;
				int k2 = -1;
				for (int i3 = 0; i3 < j2; i3++) {
					int j3 = buffer.readUnsignedByte();
					if (j3 > 0) {
						if (skins.anIntArray342[i3] != 0) {
							for (int l3 = i3 - 1; l3 > k2; l3--) {
								if (skins.anIntArray342[l3] != 0)
									continue;
								ai[l2] = l3;
								ai1[l2] = 0;
								ai2[l2] = 0;
								ai3[l2] = 0;
								l2++;
								break;
							}
						}
						ai[l2] = i3;
						short c = 0;
						if (skins.anIntArray342[i3] == 3)
							c = (short) 128;
						if ((j3 & 1) != 0)
							ai1[l2] = (short) buffer.readShort2();
						else
							ai1[l2] = c;
						if ((j3 & 2) != 0)
							ai2[l2] = buffer.readShort2();
						else
							ai2[l2] = c;
						if ((j3 & 4) != 0)
							ai3[l2] = buffer.readShort2();
						else
							ai3[l2] = c;
						/*if (skins.anIntArray342[i3] == 2 || skins.anIntArray342[i3] == 9) {
							if((j3 & 1) != 0)
								ai1[l2] = (short) (ai1[l2] / 16);
							if((j3 & 2) != 0)
								ai2[l2] = (short) (ai2[l2] / 16);
							if((j3 & 4) != 0)
								ai3[l2] = (short) (ai3[l2] / 16);
						} else if (skins.anIntArray342[i3] == 1){
							if((j3 & 1) != 0)
								ai1[l2] = (short) (ai1[l2] / 4);
							if((j3 & 2) != 0)
								ai2[l2] = (short) (ai2[l2] / 4);
							if((j3 & 4) != 0)
								ai3[l2] = (short) (ai3[l2] / 4);
						}*/
						k2 = i3;
						l2++;
					}
				}
				animation.anInt638 = l2;
				animation.anIntArray639 = new int[l2];
				animation.anIntArray640 = new int[l2];
				animation.anIntArray641 = new int[l2];
				animation.anIntArray642 = new int[l2];
				for (int k3 = 0; k3 < l2; k3++) {
					animation.anIntArray639[k3] = ai[k3];
					animation.anIntArray640[k3] = ai1[k3];
					animation.anIntArray641[k3] = ai2[k3];
					animation.anIntArray642[k3] = ai3[k3];
				}
			}
		} catch (Exception exception) {
		}
	}

	public static void readCustomFile(int animationDataID) {
		try {
			Stream buffer = new Stream(FileOperations
					.ReadFile("./Cache/Animations/" + animationDataID + ".dat"));
			Class18 skins = new Class18(buffer, 0);
			int k1 = buffer.readUnsignedWord();
			animationDataList[animationDataID] = new Class36[k1];
			int ai[] = new int[500];
			int ai1[] = new int[500];
			int ai2[] = new int[500];
			int ai3[] = new int[500];
			for (int l1 = 0; l1 < k1; l1++) {
				int i2 = buffer.readUnsignedWord();
				Class36 animation = animationDataList[animationDataID][i2] = new Class36();
				animation.aClass18_637 = skins;
				int j2 = buffer.readUnsignedByte();
				int l2 = 0;
				int k2 = -1;
				for (int i3 = 0; i3 < j2; i3++) {
					int j3 = buffer.readUnsignedByte();
					if (j3 > 0) {
						if (skins.anIntArray342[i3] != 0) {
							for (int l3 = i3 - 1; l3 > k2; l3--) {
								if (skins.anIntArray342[l3] != 0)
									continue;
								ai[l2] = l3;
								ai1[l2] = 0;
								ai2[l2] = 0;
								ai3[l2] = 0;
								l2++;
								break;
							}
						}
						ai[l2] = i3;
						short c = 0;
						if (skins.anIntArray342[i3] == 3)
							c = (short) 128;
						if ((j3 & 1) != 0)
							ai1[l2] = (short) buffer.readShort2();
						else
							ai1[l2] = c;
						if ((j3 & 2) != 0)
							ai2[l2] = buffer.readShort2();
						else
							ai2[l2] = c;
						if ((j3 & 4) != 0)
							ai3[l2] = buffer.readShort2();
						else
							ai3[l2] = c;
						/*if (skins.anIntArray342[i3] == 2 || skins.anIntArray342[i3] == 9) {
							if((j3 & 1) != 0)
								ai1[l2] = (short) (ai1[l2] / 16);
							if((j3 & 2) != 0)
								ai2[l2] = (short) (ai2[l2] / 16);
							if((j3 & 4) != 0)
								ai3[l2] = (short) (ai3[l2] / 16);
						} else if (skins.anIntArray342[i3] == 1){
							if((j3 & 1) != 0)
								ai1[l2] = (short) (ai1[l2] / 4);
							if((j3 & 2) != 0)
								ai2[l2] = (short) (ai2[l2] / 4);
							if((j3 & 4) != 0)
								ai3[l2] = (short) (ai3[l2] / 4);
						}*/
						k2 = i3;
						l2++;
					}
				}
				animation.anInt638 = l2;
				animation.anIntArray639 = new int[l2];
				animation.anIntArray640 = new int[l2];
				animation.anIntArray641 = new int[l2];
				animation.anIntArray642 = new int[l2];
				for (int k3 = 0; k3 < l2; k3++) {
					animation.anIntArray639[k3] = ai[k3];
					animation.anIntArray640[k3] = ai1[k3];
					animation.anIntArray641[k3] = ai2[k3];
					animation.anIntArray642[k3] = ai3[k3];
				}
			}
		} catch (Exception exception) {
		}
	}

	public static void method528(int i) {
		animationDataList = new Class36[i][0];
	}

	public int anInt636;
	public Class18 aClass18_637;
	public int anInt638;
	public int anIntArray639[];
	public int anIntArray640[];
	public int anIntArray641[];
	public int anIntArray642[];

	public Class36() {
	}
}