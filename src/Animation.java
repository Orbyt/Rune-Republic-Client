// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

public final class Animation {

	public static int length2;

	public static void unpackConfig(StreamLoader streamLoader) {
		Stream stream = new Stream(FileOperations.ReadFile("Cache/Animations/602seq.dat"));
		Stream stream2 = new Stream(streamLoader.getDataForName("seq.dat"));
		int length = stream.readUnsignedWord();
		length2 = stream2.readUnsignedWord();
		if (anims == null)
			anims = new Animation[(length + length2)];
		for (int j = 0; j < (length + length2); j++) {
			if (anims[j] == null)
				anims[j] = new Animation();
			if (j < length)
				anims[j].readValues(stream);
			else
				anims[j].readValues2(stream2);
			switch (j) {
			case 13767:
			anims[j].anInt352 = 16;
			anims[j].anIntArray353 = new int[] {206438549, 206438468, 206438709, 206438704, 206438853, 206438410, 206438653, 206438861, 206438483, 206438864, 206438765, 206438492, 206438900, 206438848, 206438652, 206438609};
			anims[j].anIntArray355 = new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
			anims[j].anInt363 = 0;
			anims[j].anInt364 = 0;
			break;
						case 13768:
			anims[j].anInt352 = 16;
			anims[j].anIntArray353 = new int[] {206438494, 206438916, 206438606, 206438865, 206438858, 206438886, 206438404, 206438538, 206438815, 206438640, 206438789, 206438750, 206438623, 206438541, 206438793, 206438734};
			anims[j].anIntArray355 = new int[] {3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2};
			anims[j].anInt363 = 0;
			anims[j].anInt364 = 0;
			break;
			case 13770:
			anims[j].anInt352 = 32;
			anims[j].anIntArray353 = new int[] {206438772, 206438889, 206438822, 206438810, 206438870, 206438689, 206438876, 206438626, 206438828, 206438803, 206438566, 206438866, 206438556, 206438446, 206438502, 206438585, 206438537, 206438877, 206438510, 206438411, 206438401, 206438466, 206438735, 206438675, 206438584, 206438676, 206438562, 206438693, 206438445, 206438826, 206438578, 206438747};
			anims[j].anIntArray355 = new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
			anims[j].anInt363 = 0;
			anims[j].anInt364 = 0;
			break;
			case 13771: anims[j].anInt352 = 23; anims[j].anIntArray353 = new int[] {206438872, 206438542, 206438426, 206438425, 206438767, 206438835, 206438525, 206438655, 206438607, 206438641, 206438508, 206438602, 206438567, 206438915, 206438588, 206438666, 206438732, 206438455, 206438663, 206438679, 206438505, 206438811, 206438717}; anims[j].anIntArray355 = new int[] {1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1}; anims[j].anInt363 = 0; anims[j].anInt364 = 0; break;
			case 13775:
			anims[j].anInt352 = 21;
			anims[j].anIntArray353 = new int[] {206438685, 206438642, 206438427, 206438637, 206438433, 206438583, 206438837, 206438621, 206438840, 206438891, 206438786, 206438524, 206438754, 206438547, 206438856, 206438550, 206438450, 206438430, 206438902, 206438711, 206438851};
			anims[j].anIntArray355 = new int[] {2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
			anims[j].anInt363 = 0;
			anims[j].anInt364 = 0;
			break;
			}
			if (j == 4000) {
				anims[j].anInt352 = 28;
				anims[j].anIntArray353 = new int[] { 223019263, 223019511,
						223019120, 223019119, 223019242, 223019278, 223019027,
						223019504, 223019417, 223019428, 223019705, 223019087,
						223019664, 223019465, 223019589, 223019707, 223019322,
						223019644, 223019174, 223019574, 223019108, 223019335,
						223019521, 223019401, 223019300, 223019029, 223019276,
						223019115 };
				anims[j].anIntArray355 = new int[] { 3, 2, 2, 2, 3, 3, 3, 3, 3,
						2, 2, 2, 2, 2, 3, 3, 2, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
				anims[j].anInt363 = 0;
				anims[j].anInt364 = 0;
			}
			if (j == 4001) {
				anims[j].anInt352 = 15;
				anims[j].anIntArray353 = new int[] { 219742346, 219742338,
						219742330, 219742335, 219742341, 219742348, 219742322,
						219742325, 219742318, 219742320, 219742323, 219742349,
						219742334, 219742317, 219742347 };
				anims[j].anIntArray355 = new int[] { 9, 3, 3, 3, 3, 3, 2, 2,
						15, 4, 3, 3, 3, 3, 3 };
			}
			if (j == 4002) {
				anims[j].anInt352 = 40;
				anims[j].anIntArray353 = new int[] { 219742278, 219742256,
						219742218, 219742282, 219742223, 219742222, 219742253,
						219742232, 219742300, 219742239, 219742254, 219742252,
						219742245, 219742224, 219742219, 219742294, 219742209,
						219742241, 219742299, 219742230, 219742279, 219742238,
						219742221, 219742214, 219742283, 219742305, 219742312,
						219742280, 219742265, 219742211, 219742210, 219742208,
						219742212, 219742234, 219742314, 219742240, 219742292,
						219742313, 219742267, 219742263 };
				anims[j].anIntArray355 = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3,
						3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
						3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			}
			if (j == 6319) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 24;
				// anims[j].priority = 4;
				anims[j].anIntArray355 = new int[] { 2, 2, 2, 2, 1, 1, 1, 1, 2,
						2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2 };
				anims[j].anIntArray353 = new int[] { 229507415, 229507219,
						229507411, 229507095, 229507202, 229507224, 229507326,
						229507235, 229507337, 229507288, 229507430, 229507317,
						229507239, 229507312, 229507404, 229507121, 229507464,
						229507413, 229507329, 229507378, 229507173, 229507150,
						229507292, 229507308 };
			}
			if (j == 6320) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 32;
				// anims[j].priority = 2;
				anims[j].anIntArray355 = new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3,
						3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
						3, 3, 3, 3, 3 };
				anims[j].anIntArray353 = new int[] { 229507242, 229507350,
						229507403, 229507099, 229507086, 229507365, 229507148,
						229507289, 229507075, 229507246, 229507229, 229507171,
						229507371, 229507296, 229507153, 229507333, 229507310,
						229507198, 229507399, 229507458, 229507344, 229507142,
						229507402, 229507154, 229507393, 229507220, 229507180,
						229507479, 229507133, 229507450, 229507469, 229507204 };
			}
			if (j == 6321) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 53;
				// anims[j].priority = 10;
				anims[j].anIntArray355 = new int[] { 1, 3, 4, 4, 3, 3, 3, 3, 2,
						2, 2, 2, 7, 7, 4, 6, 3, 2, 3, 2, 2, 2, 2, 3, 4, 3, 3,
						3, 2, 6, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
						5, 4, 6, 6, 5, 5, 6, 2 };
				anims[j].anIntArray353 = new int[] { 229507234, 229507100,
						229507316, 229507266, 229507363, 229507217, 229507382,
						229507257, 229507177, 229507092, 229507389, 229507163,
						229507117, 229507354, 229507347, 229507123, 229507111,
						229507081, 229507453, 229507309, 229507390, 229507258,
						229507160, 229507213, 229507162, 229507282, 229507304,
						229507164, 229507098, 229507103, 229507195, 229507103,
						229507195, 229507103, 229507195, 229507103, 229507195,
						229507103, 229507195, 229507103, 229507195, 229507103,
						229507195, 229507103, 229507195, 229507103, 229507195,
						229507174, 229507394, 229507225, 229507376, 229507271,
						229507332 };
			}
			if (j == 6326) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 36;
				// anims[j].priority = 10;
				anims[j].anIntArray355 = new int[] { 1, 3, 3, 4, 3, 3, 3, 3, 4,
						4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 7, 8, 8, 7, 3,
						3, 3, 3, 3, 3, 3, 3, 2, 2 };
				anims[j].anIntArray353 = new int[] { 229507157, 229507156,
						229507446, 229507440, 229507406, 229507431, 229507247,
						229507218, 229507465, 229507474, 229507077, 229507357,
						229507327, 229507482, 229507116, 229507259, 229507129,
						229507275, 229507322, 229507087, 229507102, 229507436,
						229507268, 229507443, 229507361, 229507128, 229507372,
						229507407, 229507185, 229507293, 229507226, 229507323,
						229507255, 229507352, 229507401, 229507159 };
			}
			if (j == 6354) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 25;
				// anims[j].priority = 8;
				anims[j].anIntArray355 = new int[] { 1, 1, 3, 3, 3, 3, 3, 3, 3,
						2, 2, 2, 2, 2, 2, 2, 2, 5, 5, 2, 1, 1, 2, 2, 3 };
				anims[j].anIntArray353 = new int[] { 229507373, 229507203,
						229507097, 229507298, 229507386, 229507264, 229507277,
						229507080, 229507089, 229507481, 229507078, 229507094,
						229507451, 229507384, 229507183, 229507385, 229507209,
						229507414, 229507417, 229507335, 229507270, 229507178,
						229507331, 229507096, 229507260 };
			}
			if (j == 6355) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 36;
				// anims[j].priority = 10;
				anims[j].anIntArray355 = new int[] { 2, 3, 2, 2, 1, 2, 2, 3, 3,
						3, 3, 3, 4, 4, 2, 2, 2, 2, 2, 3, 2, 1, 1, 1, 2, 2, 1,
						2, 2, 3, 6, 5, 3, 1, 1, 1 };
				anims[j].anIntArray353 = new int[] { 229507412, 229507243,
						229507299, 229507483, 229507428, 229507470, 229507113,
						229507122, 229507468, 229507197, 229507251, 229507284,
						229507215, 229507125, 229507447, 229507471, 229507303,
						229507265, 229507093, 229507328, 229507273, 229507283,
						229507346, 229507302, 229507480, 229507141, 229507475,
						229507208, 229507396, 229507172, 229507375, 229507355,
						229507305, 229507387, 229507138, 229507082 };
			}
			if (j == 6948) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 29;
				// anims[j].priority = 10;
				anims[j].anIntArray355 = new int[] { 5, 5, 6, 3, 3, 12, 12, 12,
						12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
						12, 12, 3, 3, 4, 5, 8 };
				anims[j].anIntArray353 = new int[] { 229507301, 229507367,
						229507205, 229507131, 229507132, 229507395, 229507318,
						229507194, 229507462, 229507395, 229507318, 229507194,
						229507462, 229507395, 229507318, 229507194, 229507462,
						229507395, 229507318, 229507194, 229507462, 229507395,
						229507318, 229507194, 229507426, 229507278, 229507147,
						229507236, 229507353 };
			}
			if (j == 6951) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 65;
				// anims[j].priority = 10;
				anims[j].anIntArray355 = new int[] { 4, 4, 3, 3, 4, 6, 5, 5, 8,
						1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
						1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 4, 4,
						8, 6, 5, 1, 1, 1, 1, 3, 3, 3, 3, 3, 5, 6, 6, 6, 6, 36,
						22, 22 };
				anims[j].anIntArray353 = new int[] { 229507307, 229507427,
						229507228, 229507272, 229507422, 229507168, 229507107,
						229507306, 229507249, 229507409, 229507476, 229507294,
						229507250, 229507109, 229507461, 229507211, 229507244,
						229507364, 229507348, 229507237, 229507341, 229507405,
						229507408, 229507090, 229507079, 229507280, 229507290,
						229507398, 229507119, 229507467, 229507330, 229507319,
						229507181, 229507200, 229507112, 229507167, 229507334,
						229507254, 229507340, 229507410, 229507383, 229507106,
						229507377, 229507151, 229507269, 229507429, 229507196,
						229507073, 229507136, 229507311, 229507313, 229507088,
						229507432, 229507388, 229507074, 229507477, 229507456,
						229507188, 229507274, 229507165, 229507212, 229507439,
						229507118, 229507356, 229507438 };
			}
			if (j == 6983) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 32;
				// anims[j].priority = 2;
				anims[j].anIntArray355 = new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2,
						2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
						2, 2, 2, 2, 2 };
				anims[j].anIntArray353 = new int[] { 229507321, 229507140,
						229507338, 229507135, 229507374, 229507419, 229507230,
						229507320, 229507454, 229507392, 229507421, 229507084,
						229507166, 229507444, 229507425, 229507120, 229507201,
						229507459, 229507449, 229507190, 229507435, 229507110,
						229507380, 229507083, 229507420, 229507206, 229507360,
						229507452, 229507297, 229507262, 229507381, 229507104 };
			}
			if (j == 6984) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 25;
				// anims[j].priority = 8;
				anims[j].anIntArray355 = new int[] { 3, 5, 5, 5, 4, 4, 3, 3, 3,
						3, 5, 8, 6, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 3, 3 };
				anims[j].anIntArray353 = new int[] { 229507276, 229507448,
						229507161, 229507325, 229507145, 229507076, 229507416,
						229507351, 229507170, 229507358, 229507418, 229507457,
						229507115, 229507158, 229507473, 229507169, 229507362,
						229507182, 229507287, 229507191, 229507240, 229507434,
						229507279, 229507091, 229507126 };
			}
			if (j == 6985) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 9;
				// anims[j].priority = 10;
				anims[j].anIntArray355 = new int[] { 3, 3, 2, 3, 4, 4, 4, 4, 3 };
				anims[j].anIntArray353 = new int[] { 229507397, 229507424,
						229507186, 229507245, 229507175, 229507248, 229507445,
						229507139, 229507291 };
			}
			if (j == 6986) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 33;
				// anims[j].priority = 6;
				anims[j].anIntArray355 = new int[] { 4, 4, 8, 4, 4, 4, 4, 4, 3,
						2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
						2, 3, 3, 3, 2, 2 };
				anims[j].anIntArray353 = new int[] { 229507149, 229507222,
						229507134, 229507114, 229507130, 229507423, 229507144,
						229507127, 229507227, 229507189, 229507463, 229507101,
						229507263, 229507400, 229507324, 229507267, 229507238,
						229507295, 229507072, 229507342, 229507300, 229507179,
						229507359, 229507281, 229507105, 229507192, 229507343,
						229507370, 229507339, 229507437, 229507146, 229507369,
						229507252 };
			}
			if (j == 6987) {
				// anims[j].fileId = 3502;
				anims[j].anInt352 = 28;
				// anims[j].priority = 6;
				anims[j].anIntArray355 = new int[] { 2, 6, 6, 5, 2, 3, 4, 4, 4,
						4, 4, 2, 2, 3, 3, 2, 2, 3, 2, 4, 4, 3, 3, 3, 3, 2, 3, 2 };
				anims[j].anIntArray353 = new int[] { 229507216, 229507231,
						229507442, 229507315, 229507478, 229507108, 229507193,
						229507472, 229507261, 229507441, 229507460, 229507433,
						229507285, 229507210, 229507155, 229507336, 229507286,
						229507232, 229507366, 229507368, 229507391, 229507124,
						229507253, 229507233, 229507221, 229507345, 229507143,
						229507466 };
			}
		}
	}

	public int method258(int i) {
		int j = anIntArray355[i];
		if (j == 0) {
			Class36 class36 = Class36.method531(anIntArray353[i]);
			if (class36 != null)
				j = anIntArray355[i] = class36.anInt636;
		}
		if (j == 0)
			j = 1;
		return j;
	}

	public void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				break;
			if (i == 1) {
				anInt352 = stream.readUnsignedWord();
				anIntArray353 = new int[anInt352];
				anIntArray354 = new int[anInt352];
				anIntArray355 = new int[anInt352];
				for (int i_ = 0; i_ < anInt352; i_++) {
					anIntArray353[i_] = stream.readDWord();
					anIntArray354[i_] = -1;
				}
				for (int i_ = 0; i_ < anInt352; i_++)
					anIntArray355[i_] = stream.readUnsignedByte();
			} else if (i == 2)
				anInt356 = stream.readUnsignedWord();
			else if (i == 3) {
				int k = stream.readUnsignedByte();
				anIntArray357 = new int[k + 1];
				for (int l = 0; l < k; l++)
					anIntArray357[l] = stream.readUnsignedByte();
				anIntArray357[k] = 0x98967f;
			} else if (i == 4)
				aBoolean358 = true;
			else if (i == 5)
				anInt359 = stream.readUnsignedByte();
			else if (i == 6)
				anInt360 = stream.readUnsignedWord();
			else if (i == 7)
				anInt361 = stream.readUnsignedWord();
			else if (i == 8)
				anInt362 = stream.readUnsignedByte();
			else if (i == 9)
				anInt363 = stream.readUnsignedByte();
			else if (i == 10)
				anInt364 = stream.readUnsignedByte();
			else if (i == 11)
				anInt365 = stream.readUnsignedByte();
			else
				System.out.println("Unrecognized seq.dat config code: " + i);
		} while (true);
		if (anInt352 == 0) {
			anInt352 = 1;
			anIntArray353 = new int[1];
			anIntArray353[0] = -1;
			anIntArray354 = new int[1];
			anIntArray354[0] = -1;
			anIntArray355 = new int[1];
			anIntArray355[0] = -1;
		}
		if (anInt363 == -1)
			if (anIntArray357 != null)
				anInt363 = 2;
			else
				anInt363 = 0;
		if (anInt364 == -1) {
			if (anIntArray357 != null) {
				anInt364 = 2;
				return;
			}
			anInt364 = 0;
		}
	}
	
	public void readValues2(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				break;
			if (i == 1) {
				anInt352 = stream.readUnsignedWord();
				anIntArray353 = new int[anInt352];
				anIntArray354 = new int[anInt352];
				anIntArray355 = new int[anInt352];
				for (int i_ = 0; i_ < anInt352; i_++) {
					anIntArray353[i_] = stream.readDWord();
					anIntArray354[i_] = -1;
					anIntArray355[i_] = stream.readUnsignedByte();
				}
				/*for (int i_ = 0; i_ < anInt352; i_++)
					anIntArray355[i_] = stream.readUnsignedByte();*/
			} else if (i == 2)
				anInt356 = stream.readUnsignedWord();
			else if (i == 3) {
				int k = stream.readUnsignedByte();
				anIntArray357 = new int[k + 1];
				for (int l = 0; l < k; l++)
					anIntArray357[l] = stream.readUnsignedByte();
				anIntArray357[k] = 0x98967f;
			} else if (i == 4)
				aBoolean358 = true;
			else if (i == 5)
				anInt359 = stream.readUnsignedByte();
			else if (i == 6)
				anInt360 = stream.readUnsignedWord();
			else if (i == 7)
				anInt361 = stream.readUnsignedWord();
			else if (i == 8)
				anInt362 = stream.readUnsignedByte();
			else if (i == 9)
				anInt363 = stream.readUnsignedByte();
			else if (i == 10)
				anInt364 = stream.readUnsignedByte();
			else if (i == 11)
				anInt365 = stream.readUnsignedByte();
			else
				System.out.println("Unrecognized seq.dat config code: " + i);
		} while (true);
		if (anInt352 == 0) {
			anInt352 = 1;
			anIntArray353 = new int[1];
			anIntArray353[0] = -1;
			anIntArray354 = new int[1];
			anIntArray354[0] = -1;
			anIntArray355 = new int[1];
			anIntArray355[0] = -1;
		}
		if (anInt363 == -1)
			if (anIntArray357 != null)
				anInt363 = 2;
			else
				anInt363 = 0;
		if (anInt364 == -1) {
			if (anIntArray357 != null) {
				anInt364 = 2;
				return;
			}
			anInt364 = 0;
		}
	}

	public Animation() {
		anInt356 = -1;
		aBoolean358 = false;
		anInt359 = 5;
		anInt360 = -1;
		anInt361 = -1;
		anInt362 = 99;
		anInt363 = -1;
		anInt364 = -1;
		anInt365 = 2;
	}

	public static Animation anims[];
	public int anInt352;
	public int anIntArray353[];
	public int anIntArray354[];
	public int[] anIntArray355;
	public int anInt356;
	public int anIntArray357[];
	public boolean aBoolean358;
	public int anInt359;
	public int anInt360;
	public int anInt361;
	public int anInt362;
	public int anInt363;
	public int anInt364;
	public int anInt365;
	public static int anInt367;
}