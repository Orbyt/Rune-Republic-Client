import sign.signlink;
public final class ItemDef {

	public static void nullLoader() {
		mruNodes2 = null;
		mruNodes1 = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public boolean method192(int j) {
		int k = anInt175;
		int l = anInt166;
		if (j == 1) {
			k = anInt197;
			l = anInt173;
		}
		if (k == -1)
			return true;
		boolean flag = true;
		if (!Model.method463(k))
			flag = false;
		if (l != -1 && !Model.method463(l))
			flag = false;
		return flag;
	}

	public Model method194(int j) {
		int k = anInt175;
		int l = anInt166;
		if (j == 1) {
			k = anInt197;
			l = anInt173;
		}
		if (k == -1)
			return null;
		Model model = Model.method462(k);
		if (l != -1) {
			Model model_1 = Model.method462(l);
			Model models[] = { model, model_1 };
			model = new Model(2, models);
		}
		if (editedModelColor != null) {
			for (int i1 = 0; i1 < editedModelColor.length; i1++)
				model.method476(editedModelColor[i1], newModelColor[i1]);
		}
		return model;
	}

	public boolean method195(int j) {
		int k = anInt165;
		int l = anInt188;
		int i1 = anInt185;
		if (j == 1) {
			k = anInt200;
			l = anInt164;
			i1 = anInt162;
		}
		if (k == -1)
			return true;
		boolean flag = true;
		if (!Model.method463(k))
			flag = false;
		if (l != -1 && !Model.method463(l))
			flag = false;
		if (i1 != -1 && !Model.method463(i1))
			flag = false;
		return flag;
	}

	public Model method196(int i) {
		int j = anInt165;
		int k = anInt188;
		int l = anInt185;
		if (i == 1) {
			j = anInt200;
			k = anInt164;
			l = anInt162;
		}
		if (j == -1)
			return null;
		Model model = Model.method462(j);
		if (k != -1)
			if (l != -1) {
				Model model_1 = Model.method462(k);
				Model model_3 = Model.method462(l);
				Model model_1s[] = { model, model_1, model_3 };
				model = new Model(3, model_1s);
			} else {
				Model model_2 = Model.method462(k);
				Model models[] = { model, model_2 };
				model = new Model(2, models);
			}
		if (i == 0 && aByte205 != 0)
			model.method475(0, aByte205, 0);
		if (i == 1 && aByte154 != 0)
			model.method475(0, aByte154, 0);
		if (editedModelColor != null) {
			for (int i1 = 0; i1 < editedModelColor.length; i1++)
				model.method476(editedModelColor[i1], newModelColor[i1]);
		}
		return model;
	}

	public void setDefaults() {
		modelID = 0;
		name = null;
		description = null;
		editedModelColor = null;
		newModelColor = null;
		modelZoom = 2000;
		modelRotation1 = 0;
		modelRotation2 = 0;
		anInt204 = 0;
		modelOffset1 = 0;
		modelOffset2 = 0;
		stackable = false;
		value = 1;
		membersObject = false;
		groundActions = null;
		actions = null;
		anInt165 = -1;
		anInt188 = -1;
		aByte205 = 0;
		anInt200 = -1;
		anInt164 = -1;
		aByte154 = 0;
		anInt185 = -1;
		anInt162 = -1;
		anInt175 = -1;
		anInt166 = -1;
		anInt197 = -1;
		anInt173 = -1;
		stackIDs = null;
		stackAmounts = null;
		certID = -1;
		certTemplateID = -1;
		anInt167 = 128;
		anInt192 = 128;
		anInt191 = 128;
		anInt196 = 0;
		anInt184 = 0;
		team = 0;
		lendID = -1;
		lentItemID = -1;
	}

	public static void unpackConfig(StreamLoader streamLoader) {
		stream = new Stream(streamLoader.getDataForName("obj.dat"));
		Stream stream = new Stream(streamLoader.getDataForName("obj.idx"));
		totalItems = stream.readUnsignedWord();
		streamIndices = new int[totalItems + 100000];
		int i = 2;
		for (int j = 0; j < totalItems; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}
		cache = new ItemDef[10];
		for (int k = 0; k < 10; k++)
			cache[k] = new ItemDef();

	}

	public static ItemDef forID(int i) {
		for (int j = 0; j < 10; j++)
			if (cache[j].id == i)
				return cache[j];
		cacheIndex = (cacheIndex + 1) % 10;
		ItemDef itemDef = cache[cacheIndex];
		stream.currentOffset = streamIndices[i];
		itemDef.id = i;
		itemDef.setDefaults();
		itemDef.readValues(stream);
		if (itemDef.certTemplateID != -1)
			itemDef.toNote();
		ItemDef_1.boltsAndArrows(i);
		ItemDef_2.stuff(i);
		if (itemDef.lentItemID != -1)
			itemDef.toLend();
		if (!isMembers && itemDef.membersObject) {
			itemDef.name = "Members Object";
			itemDef.description = "Login to a members' server to use this object.";
			itemDef.groundActions = null;
			itemDef.actions = null;
			itemDef.team = 0;
		}
		itemDef.aByte154 = 0;
			if (itemDef.id == 20100 || itemDef.name.contains("bow")
					|| itemDef.name.contains("whip")
					|| itemDef.name.contains("flail")
					|| itemDef.name.toLowerCase().contains("staff")
					|| itemDef.name.contains("hammer")
					|| itemDef.name.contains("axe")
					|| itemDef.name.contains("cross")
					|| itemDef.name.contains("spear"))
				itemDef.aByte154 = -11;
			if (itemDef.name.toLowerCase().contains("glove"))
				itemDef.aByte154 = -12;
			if (itemDef.name.toLowerCase().contains("katana"))
				itemDef.aByte154 = -12;
			if (itemDef.name.contains("shield"))
				itemDef.aByte205 = -11;
			if (itemDef.name.contains("godsword")) {
				itemDef.aByte205 = -1;
				itemDef.aByte154 = -11;
			}
			if (itemDef.name.contains("boot")) {
				itemDef.aByte154 = -11;
				itemDef.aByte205 = -11;
			}
			if (itemDef.id == 11726) {
				itemDef.aByte205 = -6;
				itemDef.aByte154 = -6;
			}
		if (i == 995)
			itemDef.actions = new String[] { null, null, null, null, "Drop" };

		if (i == 13653) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[5];
			itemDef.newModelColor = new int[5];
			itemDef.modelID = 3288;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 500;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = -6;
			itemDef.modelOffset2 = 1;
			itemDef.anInt204 = 14;
			itemDef.anInt165 = 3287;
			itemDef.anInt200 = 3287;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Death Cape";
			itemDef.description = "The cape worn by masters of PKing.";
		}
		if (i == 7890) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[4];
			itemDef.newModelColor = new int[4];
			itemDef.editedModelColor[0] = 57280;
			itemDef.editedModelColor[1] = 54503;
			itemDef.editedModelColor[2] = 54183;
			itemDef.editedModelColor[3] = 11200;
			itemDef.newModelColor[0] = 9152;
			itemDef.newModelColor[1] = 7104;
			itemDef.newModelColor[2] = 7104;
			itemDef.newModelColor[3] = 796;
			itemDef.modelID = 40121;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 500;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 14;
			itemDef.modelOffset1 = -6;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 40122;
			itemDef.anInt200 = 40122;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			// itemdef.anint199 = -1;
			itemDef.name = "Respected Donator Cape"; // made by nathanr87
			itemDef.description = "A special cape for players who have supported Rune Republic extensively";
		}

		if (i == 7979) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[4];
			itemDef.newModelColor = new int[4];
			itemDef.editedModelColor[0] = 57280;
			itemDef.editedModelColor[1] = 54503;
			itemDef.editedModelColor[2] = 54183;
			itemDef.editedModelColor[3] = 11200;
			itemDef.newModelColor[0] = 9152;
			itemDef.newModelColor[1] = 7104;
			itemDef.newModelColor[2] = 7104;
			itemDef.newModelColor[3] = 796;
			itemDef.modelID = 42789;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 500;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 14;
			itemDef.modelOffset1 = -6;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 42790;
			itemDef.anInt200 = 42790;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			// itemdef.anint199 = -1;
			itemDef.name = "Donator Cape"; // made by nathanr87
			itemDef.description = "A special cape for players who have supported Rune Republic.";
		}

		if (i == 13655) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.name = "Dragon kiteshield";
			itemDef.description = "A rare, protective kiteshield.";
			itemDef.modelID = 13701;
			itemDef.modelZoom = 1560;
			itemDef.modelRotation1 = 344;
			itemDef.modelRotation2 = 1104;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -6;
			itemDef.modelOffset2 = -14;
			itemDef.anInt165 = 13700;
			itemDef.anInt200 = 13700;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
		}
		switch (i) {
		case 10000:
			itemDef.certTemplateID = 799;
			itemDef.certID = 3840;
			break;
		case 10001:
			itemDef.certTemplateID = 799;
			itemDef.certID = 3842;
			break;
		case 10002:
			itemDef.certTemplateID = 799;
			itemDef.certID = 3844;
			break;
		case 7453:
			itemDef.name = "Gloves";
			itemDef.description = "A pair of leather gloves.";
			break;
		case 7454:
			itemDef.description = "A pair of bronze gloves.";
			itemDef.name = "Bronze gloves";
			break;
		case 7455:
			itemDef.description = "A pair of iron gloves.";
			itemDef.name = "Iron gloves";
			break;
		case 7456:
			itemDef.description = "A pair of steel gloves.";
			itemDef.name = "Steel gloves";
			break;
		case 7457:
			itemDef.description = "A pair of black gloves.";
			itemDef.name = "Black gloves";
			break;
		case 7458:
			itemDef.description = "A pair of mithril gloves.";
			itemDef.name = "Mithril gloves";
			break;
		case 7459:
			itemDef.description = "A pair of adamant gloves.";
			itemDef.name = "Adamant gloves";
			break;
		case 7460:
			itemDef.description = "A pair of rune gloves.";
			itemDef.name = "Rune gloves";
			break;
		case 7461:
			itemDef.description = "A pair of dragon gloves.";
			itemDef.name = "Dragon gloves";
			break;
		case 7462:
			itemDef.description = "A pair of barrows gloves.";
			itemDef.name = "Barrows gloves";
			break;
		case 91:
			itemDef.name = "Guam potion (unf)";
			break;
		case 92:
			itemDef.name = "Guam potion (unf)";
			break;
		case 93:
			itemDef.name = "Marrentil potion (unf)";
			break;
		case 94:
			itemDef.name = "Marrentil potion (unf)";
			break;
		case 95:
			itemDef.name = "Tarromin potion (unf)";
			break;
		case 96:
			itemDef.name = "Tarromin potion (unf)";
			break;
		case 97:
			itemDef.name = "Harralander potion (unf)";
			break;
		case 98:
			itemDef.name = "Harralander potion (unf)";
			break;
		case 99:
			itemDef.name = "Ranarr potion (unf)";
			break;
		case 100:
			itemDef.name = "Ranarr potion (unf)";
			break;
		case 101:
			itemDef.name = "Irit potion (unf)";
			break;
		case 102:
			itemDef.name = "Irit potion (unf)";
			break;
		case 103:
			itemDef.name = "Avantoe potion (unf)";
			break;
		case 104:
			itemDef.name = "Avantoe potion (unf)";
			break;
		case 105:
			itemDef.name = "Kwuarm potion (unf)";
			break;
		case 106:
			itemDef.name = "Kwuarm potion (unf)";
			break;
		case 107:
			itemDef.name = "Cadantine potion (unf)";
			break;
		case 108:
			itemDef.name = "Cadantine potion (unf)";
			break;
		case 109:
			itemDef.name = "Dwarf weed potion (unf)";
			break;
		case 110:
			itemDef.name = "Dwarf weed potion (unf)";
			break;
		case 111:
			itemDef.name = "Torstol potion (unf)";
			break;
		case 2483:
			itemDef.name = "Lantadyme potion (unf)";
			break;
		case 2484:
			itemDef.name = "Lantadyme potion (unf)";
			break;
		case 3002:
			itemDef.name = "Toadflax potion (unf)";
			break;
		case 3003:
			itemDef.name = "Toadflax potion (unf)";
			break;
		case 3004:
			itemDef.name = "Snapdragon potion (unf)";
			break;
		case 3005:
			itemDef.name = "Snapdragon potion (unf)";
			break;
		case 20115:
			itemDef.modelID = 62694;
			itemDef.name = "Ancient ceremonial hood";
			itemDef.modelZoom = 980;
			itemDef.modelRotation1 = 208;
			itemDef.modelRotation2 = 220;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -18;
			itemDef.anInt165 = 62737;
			itemDef.anInt200 = 62753;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			itemDef.anInt175 = 62730;
			itemDef.anInt197 = 62730;
			break;

		case 20116:
			itemDef.modelID = 62705;
			itemDef.name = "Ancient ceremonial top";
			itemDef.modelZoom = 1316;
			itemDef.modelRotation1 = 477;
			itemDef.modelRotation2 = 9;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 13;
			itemDef.anInt165 = 62745;
			itemDef.anInt200 = 62763;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			itemDef.anInt204 = 54;
			break;

		case 20117:
			itemDef.modelID = 62707;
			itemDef.name = "Ancient ceremonial legs";
			itemDef.modelZoom = 1828;
			itemDef.modelRotation1 = 539;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 62740;
			itemDef.anInt200 = 62759;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			itemDef.anInt204 = 40;
			itemDef.anInt196 = 30;
			itemDef.anInt184 = 100;
			break;

		case 20118:
			itemDef.modelID = 62697;
			itemDef.name = "Ancient ceremonial gloves";
			itemDef.modelZoom = 548;
			itemDef.modelRotation1 = 618;
			itemDef.modelRotation2 = 1143;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -5;
			itemDef.anInt165 = 62735;
			itemDef.anInt200 = 62752;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			break;

		case 20119:
			itemDef.modelID = 62696;
			itemDef.name = "Ancient ceremonial boots";
			itemDef.modelZoom = 676;
			itemDef.modelRotation1 = 63;
			itemDef.modelRotation2 = 106;
			itemDef.modelOffset1 = 5;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = 62734;
			itemDef.anInt200 = 62751;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			break;

		case 20120:
			itemDef.modelID = 57037;
			itemDef.name = "Frozen key";
			itemDef.modelZoom = 1184;
			itemDef.modelRotation1 = 384;
			itemDef.modelRotation2 = 162;
			itemDef.modelOffset1 = -8;
			itemDef.modelOffset2 = -14;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Check-uses";
			itemDef.actions[4] = "Destroy";
			break;

		case 20121:
			itemDef.modelID = 52559;
			itemDef.name = "Frozen key piece (armadyl)";
			itemDef.description = "Frozen key piece (armadyl)";
			itemDef.modelZoom = 925;
			itemDef.modelRotation1 = 553;
			itemDef.modelRotation2 = 131;
			itemDef.modelOffset1 = 12;
			itemDef.modelOffset2 = -8;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Assemble";
			itemDef.actions[4] = "Drop";
			itemDef.anInt167 = 260;
			itemDef.anInt192 = 260;
			itemDef.anInt191 = 260;
			break;

		case 20122:
			itemDef.modelID = 52562;
			itemDef.name = "Frozen key piece (bandos)";
			itemDef.description = "Frozen key piece (bandos)";
			itemDef.modelZoom = 720;
			itemDef.modelRotation1 = 600;
			itemDef.modelRotation2 = 223;
			itemDef.modelOffset1 = -7;
			itemDef.modelOffset2 = 2;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Assemble";
			itemDef.actions[4] = "Drop";
			itemDef.anInt167 = 260;
			itemDef.anInt192 = 260;
			itemDef.anInt191 = 260;
			break;

		case 20123:
			itemDef.modelID = 52564;
			itemDef.name = "Frozen key piece (zamorak)";
			itemDef.description = "Frozen key piece (zamorak)";
			itemDef.modelZoom = 457;
			itemDef.modelRotation1 = 387;
			itemDef.modelRotation2 = 95;
			itemDef.modelOffset1 = 26;
			itemDef.modelOffset2 = -34;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Assemble";
			itemDef.actions[4] = "Drop";
			itemDef.anInt167 = 260;
			itemDef.anInt192 = 260;
			itemDef.anInt191 = 260;
			break;

		case 20124:
			itemDef.modelID = 52561;
			itemDef.name = "Frozen key piece (saradomin)";
			itemDef.description = "Frozen key piece (saradomin)";
			itemDef.modelZoom = 541;
			itemDef.modelRotation1 = 444;
			itemDef.modelRotation2 = 32;
			itemDef.modelOffset1 = 16;
			itemDef.modelOffset2 = -47;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Assemble";
			itemDef.actions[4] = "Drop";
			itemDef.anInt167 = 260;
			itemDef.anInt192 = 260;
			itemDef.anInt191 = 260;
			break;

		case 20135:
			itemDef.modelID = 62714;
			itemDef.name = "Torva full helm";
			itemDef.description = "Torva full helm";
			itemDef.modelZoom = 672;
			itemDef.modelRotation1 = 85;
			itemDef.modelRotation2 = 1867;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -3;
			itemDef.anInt165 = 62738;
			itemDef.anInt200 = 62754;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			itemDef.anInt175 = 62729;
			itemDef.anInt197 = 62729;
			break;

		case 20139:
			itemDef.modelID = 62699;
			itemDef.name = "Torva platebody";
			itemDef.description = "Torva platebody";
			itemDef.modelZoom = 1506;
			itemDef.modelRotation1 = 473;
			itemDef.modelRotation2 = 2042;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 62746;
			itemDef.anInt200 = 62762;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			break;

		case 20143:
			itemDef.modelID = 62701;
			itemDef.name = "Torva platelegs";
			itemDef.description = "Torva platelegs";
			itemDef.modelZoom = 1740;
			itemDef.modelRotation1 = 474;
			itemDef.modelRotation2 = 2045;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -5;
			itemDef.anInt165 = 62743;
			itemDef.anInt200 = 62760;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			break;

		case 20147:
			itemDef.modelID = 62693;
			itemDef.name = "Pernix cowl";
			itemDef.description = "Pernix cowl";
			itemDef.modelZoom = 800;
			itemDef.modelRotation1 = 532;
			itemDef.modelRotation2 = 14;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 62739;
			itemDef.anInt200 = 62756;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			itemDef.anInt175 = 62731;
			itemDef.anInt197 = 62727;
			break;

		case 20151:
			itemDef.modelID = 62709;
			itemDef.name = "Pernix body";
			itemDef.description = "Pernix body";
			itemDef.modelZoom = 1378;
			itemDef.modelRotation1 = 485;
			itemDef.modelRotation2 = 2042;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 7;
			itemDef.anInt165 = 62744;
			itemDef.anInt200 = 62765;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			break;

		case 20155:
			itemDef.modelID = 62695;
			itemDef.name = "Pernix chaps";
			itemDef.description = "Pernix chaps";
			itemDef.modelZoom = 1740;
			itemDef.modelRotation1 = 504;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 4;
			itemDef.modelOffset2 = 3;
			itemDef.anInt165 = 62741;
			itemDef.anInt200 = 62757;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			break;

		case 20159:
			itemDef.modelID = 62710;
			itemDef.name = "Virtus mask";
			itemDef.description = "Virtus mask";
			itemDef.modelZoom = 928;
			itemDef.modelRotation1 = 406;
			itemDef.modelRotation2 = 2041;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = -5;
			itemDef.anInt165 = 62736;
			itemDef.anInt200 = 62755;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			itemDef.anInt175 = 62728;
			itemDef.anInt197 = 62728;
			break;

		case 20163:
			itemDef.modelID = 62704;
			itemDef.name = "Virtus robe top";
			itemDef.description = "Virtus robe top";
			itemDef.modelZoom = 1122;
			itemDef.modelRotation1 = 488;
			itemDef.modelRotation2 = 3;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 62748;
			itemDef.anInt200 = 62764;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			break;

		case 20167:
			itemDef.modelID = 62700;
			itemDef.name = "Virtus robe legs";
			itemDef.description = "Virtus robe legs";
			itemDef.modelZoom = 1740;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 2045;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 4;
			itemDef.anInt165 = 62742;
			itemDef.anInt200 = 62758;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			break;

		case 20171:
			itemDef.modelID = 62692;
			itemDef.name = "Zaryte bow";
			itemDef.description = "Zaryte bow";
			itemDef.modelZoom = 1703;
			itemDef.modelRotation1 = 221;
			itemDef.modelRotation2 = 404;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -13;
			itemDef.anInt165 = 62750;
			itemDef.anInt200 = 62750;
			itemDef.aByte154 = -11;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.actions[2] = "Check-charges";
			itemDef.actions[4] = "Drop";
			break;

		case 20175:
			itemDef.modelID = 57921;
			itemDef.name = "Trollheim tablet";
			itemDef.modelZoom = 465;
			itemDef.modelRotation1 = 373;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -1;
			itemDef.value = 1;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[0] = "Break";
			itemDef.actions[4] = "Drop";
			break;
		case 7774:
			itemDef.name = "Lottery Ticket";
			itemDef.description = "Type ::lottery to enter the lottery.";
			break;
		case 1464:
			itemDef.name = "Vote Ticket";
			itemDef.description = "Redeem for prizes!";
			break;
		case 7776:
			itemDef.name = "Cash Bond (10M)";
			itemDef.description = "Sell to the General store for 10M";
			break;
		case 13395:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 55991;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 2434;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 458;
			itemDef.modelOffset1 = -3;
			itemDef.anInt165 = 55991;
			itemDef.modelID = 54253;
			itemDef.anInt164 = -1;
			itemDef.name = "Primal kiteshield";
			itemDef.description = "Its a Primal kiteshield";
			break;
		case 13393:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 56515;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 1447;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 485;
			itemDef.modelOffset1 = 0;
			itemDef.anInt165 = 55851;
			itemDef.modelID = 54126;
			itemDef.anInt164 = -1;
			itemDef.name = "Primal platebody";
			itemDef.description = "Its a Primal platebody";
			break;
		case 13511:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 51968;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 720;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 512;
			itemDef.modelOffset1 = 0;
			itemDef.anInt165 = 51962;
			itemDef.modelID = 51952;
			itemDef.name = "Royal amulet";
			itemDef.description = "Its a royal amulet";
			break;
		case 13509:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 51966;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 592;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 240;
			itemDef.modelOffset1 = 0;
			itemDef.anInt165 = 51960;
			itemDef.modelID = 51951;
			itemDef.name = "Royal crown";
			itemDef.description = "Its a royal crown";
			break;
		case 13507:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 51964;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 1360;
			itemDef.modelRotation2 = 51;
			itemDef.modelRotation1 = 237;
			itemDef.modelOffset1 = 0;
			itemDef.anInt165 = 51964;
			itemDef.modelID = 51950;
			itemDef.name = "Royal sceptre";
			itemDef.description = "Its a royal sceptre";
			itemDef.aByte205 = -10;
			itemDef.aByte154 = -10;
			break;
		case 13505:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 51967;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 1872;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 512;
			itemDef.modelOffset1 = 0;
			itemDef.anInt165 = 51961;
			itemDef.modelID = 51953;
			itemDef.name = "Royal leggings";
			itemDef.description = "Its are Royal leggings";
			break;
		case 13503:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = 51959;
			itemDef.anInt200 = 51969;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 1360;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 512;
			itemDef.modelOffset1 = 0;
			itemDef.anInt165 = 51963;
			itemDef.modelID = 51949;
			itemDef.anInt164 = 51965;
			itemDef.name = "Royal shirt";
			itemDef.description = "Its a Royal shirt";
			break;
		case 13391:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 56046;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 1840;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 1300;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.modelRotation2 = 1552;
			itemDef.anInt165 = 56046;
			itemDef.modelID = 54373;
			itemDef.anInt164 = -1;
			itemDef.name = "Primal 2h sword";
			itemDef.description = "Its a Primal 2h sword";
			break;

		case 13389:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 56434;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 921;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 121;
			itemDef.modelOffset1 = 0;
			itemDef.anInt165 = 55770;
			itemDef.modelID = 54164;
			itemDef.anInt164 = -1;
			itemDef.name = "Primal full helm";
			itemDef.description = "Its a Primal full helm";
			break;
		case 13387:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 56478;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 1730;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 525;
			itemDef.modelOffset1 = 7;
			itemDef.anInt165 = 55815;
			itemDef.modelID = 54175;
			itemDef.anInt164 = -1;
			itemDef.name = "Primal platelegs";
			itemDef.description = "It are Primal platelegs";
			break;
		case 13385:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 56460;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 1711;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 488;
			itemDef.modelOffset1 = -1;
			itemDef.anInt165 = 55804;
			itemDef.modelID = 54068;
			itemDef.anInt164 = -1;
			itemDef.name = "Primal plateskirt";
			itemDef.description = "A Primal plateskirt";
			break;
		case 13383:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 56353;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 789;
			itemDef.modelRotation2 = 156;
			itemDef.modelRotation1 = 164;
			itemDef.modelOffset1 = 0;
			itemDef.anInt165 = 55673;
			itemDef.modelID = 54062;
			itemDef.anInt164 = -1;
			itemDef.name = "Primal boots";
			itemDef.description = "A pair of Primal boots";
			break;
		case 13381:
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 56417;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 930;
			itemDef.modelRotation2 = 828;
			itemDef.modelRotation1 = 420;
			itemDef.modelOffset1 = 3;
			itemDef.anInt165 = 55728;
			itemDef.modelID = 54037;
			itemDef.anInt164 = -1;
			itemDef.name = "Primal gauntlets";
			itemDef.description = "A pair of Primal gauntlets";
			break;
		}
		if (i == 10000) {
			itemDef.certTemplateID = 799;
			itemDef.certID = 3840;
		}
		if (i == 10001) {
			itemDef.certTemplateID = 799;
			itemDef.certID = 3842;
		}
		if (i == 10002) {
			itemDef.certTemplateID = 799;
			itemDef.certID = 3844;
		}

		if (i == 4221)// model ID
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 63007;// drop/inventory model
			itemDef.modelZoom = 1957;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 484;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = 63004;// male equip
			itemDef.anInt200 = 63004;// female equip
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Saradomin godbow";
			itemDef.description = "A saradomin godbow, once used by Saradomin himself.";
		}
		if (i == 10100) {
			itemDef.actions = new String[5];
			itemDef.modelID = 48728;
			itemDef.modelZoom = 1300;
			itemDef.modelRotation1 = 376;
			itemDef.modelRotation2 = 216;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = 0;
			itemDef.name = "Raw Rocktail";
			itemDef.description = "Its a fish";
		}

		if (i == 10102) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Eat";
			itemDef.modelID = 48725;
			itemDef.modelZoom = 1300;
			itemDef.modelRotation1 = 376;
			itemDef.modelRotation2 = 216;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = 0;
			itemDef.name = "Rocktail";
			itemDef.description = "Its a fish";
		}
			if (i == 20888) {
			itemDef.modelID = 9001;
			itemDef.name = "Rainbow Partyhat";
			itemDef.description = "Rainbow Partyhat";
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 1845;
			itemDef.modelRotation2 = 121;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 9000;
			itemDef.anInt200 = 9002;
			itemDef.groundActions = new String[5];
			itemDef.groundActions[2] = "Take";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
		}
		if (i == 13486) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 11359;
			itemDef.anInt165 = 11360;
			itemDef.anInt200 = 11360;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.modelZoom = 1600;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 1600;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.name = "Staff of light";
			itemDef.description = "Humming with power.";
		}
		if (i == 4222)// model ID
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 63200;// drop/inventory model
			itemDef.modelZoom = 1957;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 484;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = 63201;// male equip
			itemDef.anInt200 = 63201;// female equip
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Zamorak godbow";
			itemDef.description = "A zamorak godbow, once used by Zamorak himself.";
		}
		if (i == 4223)// model ID
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 31312;// drop/inventory model
			itemDef.modelZoom = 1957;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 484;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = 13323;// male equip
			itemDef.anInt200 = 13323;// female equip
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Bandos godbow";
			itemDef.description = "A bandos godbow, once used by Bandos himself.";
		}
		if (i == 13039) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 47369;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 919;
			itemDef.modelRotation2 = 225;
			itemDef.modelRotation1 = 184;
			itemDef.modelOffset1 = -1;
			itemDef.anInt165 = 47396;
			itemDef.modelID = 47763;
			itemDef.anInt164 = -1;
			itemDef.name = "Lord marshal cap";
			itemDef.description = "Its a lord marshal cap";
		}

		if (i == 13040) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 47372;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 1373;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 526;
			itemDef.modelOffset1 = 0;
			itemDef.anInt165 = 47400;
			itemDef.modelID = 47732;
			itemDef.anInt164 = -1;
			itemDef.name = "Lord marshal top";
			itemDef.description = "Its a lord marshal top";
		}

		if (i == 13041) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 47352;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 1697;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 444;
			itemDef.modelOffset1 = 1;
			itemDef.anInt165 = 47383;
			itemDef.modelID = 47731;
			itemDef.anInt164 = -1;
			itemDef.name = "Lord marshal trousers";
			itemDef.description = "Its a lord marshal trousers";
		}

		if (i == 13042) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 47354;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 1697;
			itemDef.modelRotation2 = 0;
			itemDef.modelRotation1 = 444;
			itemDef.modelOffset1 = 1;
			itemDef.anInt165 = 47381;
			itemDef.modelID = 47751;
			itemDef.anInt164 = -1;
			itemDef.name = "Lord marshal skirt";
			itemDef.description = "Its a lord marshal skirt";
		}

		if (i == 13043) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 47360;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 810;
			itemDef.modelRotation2 = 194;
			itemDef.modelRotation1 = 207;
			itemDef.modelOffset1 = 4;
			itemDef.anInt165 = 47388;
			itemDef.modelID = 47720;
			itemDef.anInt164 = -1;
			itemDef.name = "Lord marshal boots";
			itemDef.description = "Its a lord marshal boots";
		}
		if (i == 6665) {
			itemDef.name = "Priflash";
			itemDef.description = "It's Priflash! Make sure you pm taha for one!";
		}
		if (i == 13044) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 47366;
			itemDef.modelOffset2 = 0;
			itemDef.modelZoom = 779;
			itemDef.modelRotation2 = 828;
			itemDef.modelRotation1 = 420;
			itemDef.modelOffset1 = 0;
			itemDef.anInt165 = 47390;
			itemDef.modelID = 47743;
			itemDef.anInt164 = -1;
			itemDef.name = "Lord marshal gloves";
			itemDef.description = "Its a lord marshal gloves";
		}
		if (i == 4220)// model ID
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 1201;// drop/inventory model
			itemDef.modelZoom = 1957;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 484;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = 1200;// male equip
			itemDef.anInt200 = 1200;// female equip
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Armadyl godbow";
			itemDef.description = "An armadyl godbow, once used by Armadyl himself.";
		}

		if (i == 13600) {
			itemDef.name = "Amulet of ranging";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 12212;
			itemDef.anInt165 = 12213;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.modelRotation2 = 147;
			itemDef.modelZoom = 988;
			itemDef.anInt200 = 12214;
			itemDef.anInt164 = -1;
			itemDef.modelOffset1 = -4;
			itemDef.modelOffset2 = -79;
			itemDef.anInt164 = -1;
			itemDef.modelRotation1 = 231;
			itemDef.description = "This will increase a rangers abilitys.";
		}
		if (i == 7959) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 35084;
			itemDef.anInt165 = 35085;
			itemDef.anInt200 = 35085;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.modelZoom = 1400;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 1300;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.name = "Chaotic rapier";
			itemDef.description = "A weapon of amazing speed.";
			itemDef.aByte205 = -11;
			itemDef.aByte154 = -11;
		}
		if (i == 7962) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 35086;
			itemDef.anInt165 = 35087;
			itemDef.anInt200 = 35087;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.modelZoom = 1300;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 1300;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.name = "Chaotic longsword";
			itemDef.description = "A weapon of incredible accuracy.";
			itemDef.aByte205 = -11;
			itemDef.aByte154 = -11;
		}
		if (i == 7961) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.aByte205 = -10;
			itemDef.aByte154 = -10;
			itemDef.modelID = 35088;
			itemDef.modelZoom = 1360;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 354;
			itemDef.modelOffset1 = 4;
			itemDef.modelOffset2 = 2;
			itemDef.anInt165 = 35089;
			itemDef.anInt200 = 35089;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.name = "Chaotic maul";
			itemDef.description = "A weapon of brute strength.";
		}
		if (i == 10143) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 9933;
			itemDef.modelZoom = 570;
			itemDef.modelRotation1 = 348;
			itemDef.modelRotation2 = 1776;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 2;
			itemDef.modelOffset2 = -6;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Warrior ring (i)";
			itemDef.description = "A enchanted warrior ring.";
		}
		if (i == 10142) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 9930;
			itemDef.modelZoom = 630;
			itemDef.modelRotation1 = 332;
			itemDef.modelRotation2 = 1904;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 4;
			itemDef.modelOffset2 = -14;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Archer ring (i)";
			itemDef.description = "A enchanted archer ring.";
		}
		if (i == 10141) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 9932;
			itemDef.modelZoom = 620;
			itemDef.modelRotation1 = 340;
			itemDef.modelRotation2 = 1940;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 3;
			itemDef.modelOffset2 = -13;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Seers ring (i)";
			itemDef.description = "A enchanted seers ring.";
		}
		if (i == 10140) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 9931;
			itemDef.modelZoom = 600;
			itemDef.modelRotation1 = 324;
			itemDef.modelRotation2 = 1916;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 3;
			itemDef.modelOffset2 = -15;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Berserker ring (i)";
			itemDef.description = "A enchanted berserker ring.";
		}
		if (i == 13601) {
			itemDef.name = "Fighter Hat";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			itemDef.modelID = 49246;
			itemDef.anInt165 = 49246;
			itemDef.anInt200 = 40506;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.modelZoom = 724;
			itemDef.modelRotation1 = 69;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.description = "Worn By Fighter's";
		}
		if (i == 13665) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 57300;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Pink Whip";
			itemDef.description = "A weapon from the abyss.";
		}
		if (i == 13671) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 0;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Black Whip";
			itemDef.description = "A weapon from the abyss.";
		}
		if (i == 13670) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 9583;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "White Whip";
			itemDef.description = "A weapon from the abyss.";
		}
		if (i == 13664) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 33;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Iron Whip";
			itemDef.description = "A weapon from the abyss.";
		}
		if (i == 13660) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 21662;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Adamant Whip";
			itemDef.description = "A weapon from the abyss.";
		}
		if (i == 13661) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 43297;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Mithril Whip";
			itemDef.description = "a weapon from the abyss";
		}

		if (i == 13669) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 49823;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Elemental Whip";
			itemDef.description = "a weapon from the abyss";
		}

		if (i == 7901) {

			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 17350;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Lime Whip";
			itemDef.description = "A weapon from the abyss.";
		}
		if (i == 13662) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 43072;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Steel Whip";
			itemDef.description = "A weapon from the abyss.";
		}

		if (i == 13663) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 86933;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Green Whip";
			itemDef.description = "A weapon from the abyss.";
		}
		if (i == 13666) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 36133;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Rune Whip";
			itemDef.description = "A weapon from the abyss.";
		}
		if (i == 13667) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 926;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Dragon Whip";
			itemDef.description = "A weapon from the abyss.";
		}
		if (i == 13668) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 7833;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Barrows Whip";
			itemDef.description = "A weapon from the abyss.";
		}

		if (i == 9500) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 926;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.stackable = false;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.anInt197 = 87;
			itemDef.name = "Dragon Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 9501) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 17350;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.stackable = false;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.anInt197 = 87;
			itemDef.name = "Lime Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 9502) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 7833;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.stackable = false;
			itemDef.anInt175 = 29;
			itemDef.anInt197 = 87;
			itemDef.name = "Barrows Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 9503) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 36133;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.stackable = false;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.anInt197 = 87;
			itemDef.name = "Rune Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 9504) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 86933;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.stackable = false;
			itemDef.anInt197 = 87;
			itemDef.name = "Green Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 9505) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 43072;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.stackable = false;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.anInt197 = 87;
			itemDef.name = "Steel Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 9506) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 49823;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.stackable = false;
			itemDef.anInt197 = 87;
			itemDef.name = "Elemntal Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 9507) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 43297;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.stackable = false;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.anInt197 = 87;
			itemDef.name = "Mith Party Hat";
			itemDef.description = "A Party Hat.";
		}

		
		if (i == 9520) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 21662;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.stackable = false;
			itemDef.anInt197 = 87;
			itemDef.name = "Adamant Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 9508) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 0;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.stackable = false;
			itemDef.anInt197 = 87;
			itemDef.name = "Black Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 9510) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 57300;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.anInt197 = 87;
			itemDef.stackable = false;
			itemDef.name = "Pink Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 9518) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 933;
			itemDef.newModelColor[0] = 36133;
			itemDef.modelID = 2537;
			itemDef.modelZoom = 540;
			itemDef.modelRotation1 = 72;
			itemDef.modelRotation2 = 136;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -3;
			itemDef.anInt165 = 189;
			itemDef.anInt200 = 366;
			itemDef.anInt175 = 69;
			itemDef.anInt197 = 127;
			itemDef.stackable = false;
			itemDef.name = "Rune Santa hat";
			itemDef.description = "A gift from santa";
		}

		if (i == 9512) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 933;
			itemDef.newModelColor[0] = 57300;
			itemDef.modelID = 2537;
			itemDef.modelZoom = 540;
			itemDef.modelRotation1 = 72;
			itemDef.modelRotation2 = 136;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -3;
			itemDef.anInt165 = 189;
			itemDef.anInt200 = 366;
			itemDef.anInt175 = 69;
			itemDef.anInt197 = 127;
			itemDef.stackable = false;
			itemDef.name = "Pink Santa hat";
			itemDef.description = "A gift from santa";
		}

		if (i == 9516) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 933;
			itemDef.newModelColor[0] = 0;
			itemDef.modelID = 2537;
			itemDef.modelZoom = 540;
			itemDef.modelRotation1 = 72;
			itemDef.modelRotation2 = 136;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -3;
			itemDef.anInt165 = 189;
			itemDef.anInt200 = 366;
			itemDef.anInt175 = 69;
			itemDef.stackable = false;
			itemDef.anInt197 = 127;
			itemDef.name = "Black Santa hat";
			itemDef.description = "A gift from santa";
		}

		if (i == 9514) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 933;
			itemDef.newModelColor[0] = 21662;
			itemDef.modelID = 2537;
			itemDef.modelZoom = 540;
			itemDef.modelRotation1 = 72;
			itemDef.modelRotation2 = 136;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -3;
			itemDef.anInt165 = 189;
			itemDef.anInt200 = 366;
			itemDef.anInt175 = 69;
			itemDef.stackable = false;
			itemDef.anInt197 = 127;
			itemDef.name = "Adamant Santa hat";
			itemDef.description = "A gift from santa";
		}


		if (i == 9220) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 689484;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.anInt197 = 87;
			itemDef.stackable = false;
			itemDef.name = "Sky Blue Party Hat";
			itemDef.description = "A Party Hat.";
		}

		if (i == 7821) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 6073;
			itemDef.modelID = 2635;
			itemDef.modelZoom = 440;
			itemDef.modelRotation1 = 76;
			itemDef.modelRotation2 = 1850;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 187;
			itemDef.anInt200 = 363;
			itemDef.anInt175 = 29;
			itemDef.anInt197 = 87;
			itemDef.name = "Lava Party Hat";
			itemDef.description = "A Party Hat.";
		}
		if (i == 7822) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 528;
			itemDef.newModelColor[0] = 6073;
			itemDef.modelID = 5412;
			itemDef.modelZoom = 840;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.anInt165 = 5409;
			itemDef.anInt200 = 5409;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Lava Whip";
			itemDef.description = "A weapon from the abyss.";
		}

		if (i == 9000) {
			itemDef.name = "Vesta's Longsword (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42597;
			itemDef.modelZoom = 1744;
			itemDef.modelRotation1 = 738;
			itemDef.modelRotation2 = 1985;
			itemDef.modelOffset2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42615;
			itemDef.anInt200 = 42615;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 9001) {
			itemDef.name = "Vesta's Chainbody (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42593;
			itemDef.modelZoom = 1440;
			itemDef.modelRotation1 = 545;
			itemDef.modelRotation2 = 2;
			itemDef.modelOffset2 = 5;
			itemDef.modelOffset1 = 4;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42624;
			itemDef.anInt200 = 42644;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}
		if (i == 9002) {
			itemDef.name = "Vesta's Plateskirt (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42581;
			itemDef.modelZoom = 1753;
			itemDef.modelRotation1 = 562;
			itemDef.modelRotation2 = 1;
			itemDef.modelOffset2 = 11;
			itemDef.modelOffset1 = -3;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42633;
			itemDef.anInt200 = 42647;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 9003) {
			itemDef.name = "Vesta's Spear (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42599;
			itemDef.modelZoom = 2022;
			itemDef.modelRotation1 = 480;
			itemDef.modelRotation2 = 15;
			itemDef.modelOffset2 = 5;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42614;
			itemDef.anInt200 = 42614;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 7845) {
			itemDef.name = "Zuriel's Robe Top";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42591;
			itemDef.modelZoom = 1373;
			itemDef.modelRotation1 = 373;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = -7;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42627;
			itemDef.anInt200 = 42642;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}
		if (i == 9004) {
			itemDef.name = "Zuriel's Robe Bottom (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42588;
			itemDef.modelZoom = 1697;
			itemDef.modelRotation1 = 512;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = -9;
			itemDef.modelOffset1 = 2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42634;
			itemDef.anInt200 = 42645;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 9005) {
			itemDef.name = "Zuriel's Staff (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42595;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 366;
			itemDef.modelRotation2 = 3;
			itemDef.modelOffset2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42617;
			itemDef.anInt200 = 42617;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 9006) {
			itemDef.name = "Zuriel's Hood (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42604;
			itemDef.modelZoom = 720;
			itemDef.modelRotation1 = 28;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.modelOffset1 = 1;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42638;
			itemDef.anInt200 = 42653;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}
		if (i == 9007) {
			itemDef.name = "Zuriel's Robe Top (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42591;
			itemDef.modelZoom = 1373;
			itemDef.modelRotation1 = 373;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = -7;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42627;
			itemDef.anInt200 = 42642;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 9008) {
			itemDef.name = "Morrigan's leather body (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42578;
			itemDef.modelZoom = 1184;
			itemDef.modelRotation1 = 545;
			itemDef.modelRotation2 = 2;
			itemDef.modelOffset2 = 5;
			itemDef.modelOffset1 = 4;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42626;
			itemDef.anInt200 = 42643;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 9009) {
			itemDef.name = "Morrigan's Leather Chaps (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42603;
			itemDef.modelZoom = 1753;
			itemDef.modelRotation1 = 482;
			itemDef.modelRotation2 = 1;
			itemDef.modelOffset2 = 11;
			itemDef.modelOffset1 = -3;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42631;
			itemDef.anInt200 = 42646;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 9010) {
			itemDef.name = "Morrigan's Coif (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42583;
			itemDef.modelZoom = 592;
			itemDef.modelRotation1 = 537;
			itemDef.modelRotation2 = 5;
			itemDef.modelOffset2 = 6;
			itemDef.modelOffset1 = -3;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42636;
			itemDef.anInt200 = 42652;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 9011) {
			itemDef.name = "Statius's Platebody (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42602;
			itemDef.modelZoom = 1312;
			itemDef.modelRotation1 = 272;
			itemDef.modelRotation2 = 2047;
			itemDef.modelOffset2 = 39;
			itemDef.modelOffset1 = -2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42625;
			itemDef.anInt200 = 42641;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 9012) {
			itemDef.name = "Statius's Platelegs (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42590;
			itemDef.modelZoom = 1625;
			itemDef.modelRotation1 = 355;
			itemDef.modelRotation2 = 2046;
			itemDef.modelOffset2 = -11;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42632;
			itemDef.anInt200 = 42649;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}
		if (i == 9013) {
			itemDef.name = "Statius's Full Helm (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42596;
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 96;
			itemDef.modelRotation2 = 2039;
			itemDef.modelOffset2 = -7;
			itemDef.modelOffset1 = 2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42639;
			itemDef.anInt200 = 42655;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}
		if (i == 9014) {
			itemDef.name = "Statius's Warhammer (deg)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42577;
			itemDef.modelZoom = 1360;
			itemDef.modelRotation1 = 507;
			itemDef.modelRotation2 = 27;
			itemDef.modelOffset2 = 6;
			itemDef.modelOffset1 = 7;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42623;
			itemDef.anInt200 = 42623;
			itemDef.description = "This item degrades in combat, and will turn to dust.";
		}

		if (i == 9015) {
			itemDef.name = "Vesta's Longsword (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42597;
			itemDef.modelZoom = 1744;
			itemDef.modelRotation1 = 738;
			itemDef.modelRotation2 = 1985;
			itemDef.modelOffset2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42615;
			itemDef.anInt200 = 42615;
			itemDef.description = "A powerful item.";
		}

		if (i == 9016) {
			itemDef.name = "Vesta's Chainbody (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42593;
			itemDef.modelZoom = 1440;
			itemDef.modelRotation1 = 545;
			itemDef.modelRotation2 = 2;
			itemDef.modelOffset2 = 5;
			itemDef.modelOffset1 = 4;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42624;
			itemDef.anInt200 = 42644;
			itemDef.description = "A powerful item.";
		}
		if (i == 9017) {
			itemDef.name = "Vesta's Plateskirt (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42581;
			itemDef.modelZoom = 1753;
			itemDef.modelRotation1 = 562;
			itemDef.modelRotation2 = 1;
			itemDef.modelOffset2 = 11;
			itemDef.modelOffset1 = -3;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42633;
			itemDef.anInt200 = 42647;
			itemDef.description = "A powerful item.";
		}

		if (i == 9018) {
			itemDef.name = "Vesta's Spear (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42599;
			itemDef.modelZoom = 2022;
			itemDef.modelRotation1 = 480;
			itemDef.modelRotation2 = 15;
			itemDef.modelOffset2 = 5;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42614;
			itemDef.anInt200 = 42614;
			itemDef.description = "A powerful item.";
		}

		if (i == 9019) {
			itemDef.name = "Zuriel's Robe Top (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42591;
			itemDef.modelZoom = 1373;
			itemDef.modelRotation1 = 373;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = -7;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42627;
			itemDef.anInt200 = 42642;
			itemDef.description = "A powerful item.";
		}
		if (i == 9020) {
			itemDef.name = "Zuriel's Robe Bottom (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42588;
			itemDef.modelZoom = 1697;
			itemDef.modelRotation1 = 512;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = -9;
			itemDef.modelOffset1 = 2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42634;
			itemDef.anInt200 = 42645;
			itemDef.description = "A powerful item.";
		}

		if (i == 9021) {
			itemDef.name = "Zuriel's Staff (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42595;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 366;
			itemDef.modelRotation2 = 3;
			itemDef.modelOffset2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42617;
			itemDef.anInt200 = 42617;
			itemDef.description = "A powerful item.";
		}

		if (i == 9022) {
			itemDef.name = "Zuriel's Hood (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42604;
			itemDef.modelZoom = 720;
			itemDef.modelRotation1 = 28;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.modelOffset1 = 1;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42638;
			itemDef.anInt200 = 42653;
			itemDef.description = "A powerful item.";
		}
		if (i == 9023) {
			itemDef.name = "Zuriel's Robe Top (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42591;
			itemDef.modelZoom = 1373;
			itemDef.modelRotation1 = 373;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = -7;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42627;
			itemDef.anInt200 = 42642;
			itemDef.description = "A powerful item.";
		}

		if (i == 9024) {
			itemDef.name = "Morrigan's leather body (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42578;
			itemDef.modelZoom = 1184;
			itemDef.modelRotation1 = 545;
			itemDef.modelRotation2 = 2;
			itemDef.modelOffset2 = 5;
			itemDef.modelOffset1 = 4;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42626;
			itemDef.anInt200 = 42643;
			itemDef.description = "A powerful item.";
		}

		if (i == 9025) {
			itemDef.name = "Morrigan's Leather Chaps (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42603;
			itemDef.modelZoom = 1753;
			itemDef.modelRotation1 = 482;
			itemDef.modelRotation2 = 1;
			itemDef.modelOffset2 = 11;
			itemDef.modelOffset1 = -3;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42631;
			itemDef.anInt200 = 42646;
			itemDef.description = "A powerful item.";
		}

		if (i == 9026) {
			itemDef.name = "Morrigan's Coif (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42583;
			itemDef.modelZoom = 592;
			itemDef.modelRotation1 = 537;
			itemDef.modelRotation2 = 5;
			itemDef.modelOffset2 = 6;
			itemDef.modelOffset1 = -3;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42636;
			itemDef.anInt200 = 42652;
			itemDef.description = "A powerful item.";
		}

		if (i == 9027) {
			itemDef.name = "Statius's Platebody (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42602;
			itemDef.modelZoom = 1312;
			itemDef.modelRotation1 = 272;
			itemDef.modelRotation2 = 2047;
			itemDef.modelOffset2 = 39;
			itemDef.modelOffset1 = -2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42625;
			itemDef.anInt200 = 42641;
			itemDef.description = "A powerful item.";
		}

		if (i == 9028) {
			itemDef.name = "Statius's Platelegs (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42590;
			itemDef.modelZoom = 1625;
			itemDef.modelRotation1 = 355;
			itemDef.modelRotation2 = 2046;
			itemDef.modelOffset2 = -11;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42632;
			itemDef.anInt200 = 42649;
			itemDef.description = "A powerful item.";
		}
		if (i == 9029) {
			itemDef.name = "Statius's Full Helm (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42596;
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 96;
			itemDef.modelRotation2 = 2039;
			itemDef.modelOffset2 = -7;
			itemDef.modelOffset1 = 2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42639;
			itemDef.anInt200 = 42655;
			itemDef.description = "A powerful item.";
		}
		if (i == 9030) {
			itemDef.name = "Statius's Warhammer (corrupt)";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42577;
			itemDef.modelZoom = 1360;
			itemDef.modelRotation1 = 507;
			itemDef.modelRotation2 = 27;
			itemDef.modelOffset2 = 6;
			itemDef.modelOffset1 = 7;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42623;
			itemDef.anInt200 = 42623;
			itemDef.description = "A powerful item.";
		}
		if (i == 9970) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 45003;
			itemDef.modelZoom = 1382;
			itemDef.modelRotation1 = 364;
			itemDef.modelRotation2 = 1145;
			itemDef.modelOffset1 = 7;
			itemDef.modelOffset2 = -12;
			itemDef.anInt165 = 45004;
			itemDef.anInt200 = 45004;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.name = "Dragon pickaxe";
			itemDef.description = "It's a Dragon pickaxe.";
		}
		if (i == 9967) {
			itemDef.actions = new String[5];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor[0] = 0;
			itemDef.editedModelColor[0] = 0;
			itemDef.modelID = 45000;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 100;
			itemDef.modelRotation2 = 2000;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Ruined dragon armour lump";
			itemDef.description = "A badly damaged lump of dragon metal. ";
		}
		if (i == 9968) {
			itemDef.actions = new String[5];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor = new int[1];
			itemDef.modelID = 45002;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 304;
			itemDef.modelRotation2 = 41;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.name = "Ruined armour slice";
			itemDef.description = "A badly damaged slice of dragon metal. ";
		}
		if (i == 9969) {
			itemDef.actions = new String[5];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor = new int[1];
			itemDef.modelID = 45001;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 228;
			itemDef.modelRotation2 = 36;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.name = "Ruined dragon armour shard";
			itemDef.description = "A badly damaged shard of dragon metal. ";
		}
		if (i == 9950) {
			itemDef.actions = new String[5];
			itemDef.modelID = 40914;
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 225;
			itemDef.modelRotation2 = 186;
			itemDef.modelOffset1 = 4;
			itemDef.modelOffset2 = -10;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.name = "Arcane Sigil";
			itemDef.description = "An sigil marked with arcane signs. ";// examine.
		}

		if (i == 9951) {
			itemDef.actions = new String[5];
			itemDef.modelID = 40916;
			itemDef.modelZoom = 848;
			itemDef.modelRotation1 = 267;
			itemDef.modelRotation2 = 138;
			itemDef.modelOffset1 = 5;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.name = "Divine Sigil";
			itemDef.description = "A sigil marked with divine signs.";// examine.
		}
		if (i == 9952) {
			itemDef.actions = new String[5];
			itemDef.modelID = 40917;
			itemDef.modelZoom = 976;
			itemDef.modelRotation1 = 288;
			itemDef.modelRotation2 = 225;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.name = "Elysian Sigil";
			itemDef.description = "A sigil marked with elysian signs.";
		}
		if (i == 9953) {
			itemDef.actions = new String[5];
			itemDef.modelID = 40918;
			itemDef.modelZoom = 976;
			itemDef.modelRotation1 = 267;
			itemDef.modelRotation2 = 1304;
			itemDef.modelOffset1 = -5;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.name = "Spectral Sigil";
			itemDef.description = "A sigil marked with spectral signs.";// examine.
		}
		if (i == 9954) // Holy elixir
		{
			itemDef.actions = new String[5];
			itemDef.modelID = 40949;
			itemDef.modelZoom = 1178;
			itemDef.modelRotation1 = 0;
			itemDef.modelRotation2 = 1881;
			itemDef.modelOffset2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.name = "Holy elixir";
			itemDef.description = "A bottle of holy elixir.";
		}
		if (i == 9955) {
			itemDef.name = "Bandos boots";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.actions[4] = "Drop";
			itemDef.modelID = 28135;
			itemDef.anInt165 = 27737;
			itemDef.anInt188 = -1;
			itemDef.team = 0;
			itemDef.stackable = false;
			itemDef.modelRotation2 = 0;
			itemDef.modelZoom = 724;
			itemDef.value = 25000;
			itemDef.anInt200 = 19951;
			itemDef.anInt164 = -1;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = -7;
			itemDef.certID = 11729;
			itemDef.modelRotation1 = 171;
			itemDef.description = "Some sturdy boots.";
		}
		if (i == 9956) {
			itemDef.actions = new String[5];
			itemDef.modelID = 28146;
			itemDef.modelZoom = 800;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 263;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Bandos hilt";
			itemDef.description = "Brimming with potential.";
		}
		if (i == 9957) {
			itemDef.actions = new String[5];
			itemDef.modelID = 28153;
			itemDef.modelZoom = 800;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 263;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Armadyl hilt";
			itemDef.description = "Brimming with potential.";
		}
		if (i == 9958) {
			itemDef.actions = new String[5];
			itemDef.modelID = 28155;
			itemDef.modelZoom = 900;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 263;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Saradomin hilt";
			itemDef.description = "Brimming with potential.";
		}
		if (i == 9959) {
			itemDef.actions = new String[5];
			itemDef.modelID = 28158;
			itemDef.modelZoom = 900;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 263;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Zamorak hilt";
			itemDef.description = "Brimming with potential.";
		}
		if (i == 9960) {
			itemDef.name = "Godsword shard 1";
			itemDef.actions = new String[5];
			itemDef.actions[4] = "Drop";
			itemDef.modelID = 28152;
			itemDef.team = 0;
			itemDef.stackable = false;
			itemDef.modelRotation2 = 249;
			itemDef.modelZoom = 984;
			itemDef.value = 250000;
			itemDef.modelOffset1 = 3;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.certID = 11711;
			itemDef.modelRotation1 = 549;
			itemDef.description = "Part of the Godsword blade. ";
		}
		if (i == 9961) {
			itemDef.name = "Godsword shard 2";
			itemDef.actions = new String[5];
			itemDef.actions[4] = "Drop";
			itemDef.modelID = 28168;
			itemDef.team = 0;
			itemDef.stackable = false;
			itemDef.modelRotation2 = 249;
			itemDef.modelZoom = 984;
			itemDef.value = 250000;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.certID = 11713;
			itemDef.modelRotation1 = 675;
			itemDef.description = "Part of the Godsword blade. ";
		}
		if (i == 9962) {
			itemDef.name = "Godsword shard 3";
			itemDef.actions = new String[5];
			itemDef.actions[4] = "Drop";
			itemDef.modelID = 28160;
			itemDef.team = 0;
			itemDef.stackable = false;
			itemDef.modelRotation2 = 207;
			itemDef.modelZoom = 984;
			itemDef.value = 250000;
			itemDef.modelOffset1 = 7;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.certID = 11715;
			itemDef.modelRotation1 = 612;
			itemDef.description = "Part of the Godsword blade. ";
		}
		if (i == 9963) {
			itemDef.name = "Godsword shards";
			itemDef.actions = new String[5];
			itemDef.actions[4] = "Drop";
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor[0] = 5652;
			itemDef.editedModelColor[0] = 61;
			itemDef.modelID = 28164;
			itemDef.team = 0;
			itemDef.stackable = false;
			itemDef.modelRotation2 = 249;
			itemDef.modelZoom = 1503;
			itemDef.value = 500000;
			itemDef.modelOffset1 = 8;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = 8;
			itemDef.certID = 11687;
			itemDef.modelRotation1 = 567;
			itemDef.description = "Godsword shards 1 and 2.";
		}
		if (i == 9964) {
			itemDef.name = "Godsword shards";
			itemDef.actions = new String[5];
			itemDef.actions[4] = "Drop";
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor[0] = 5652;
			itemDef.editedModelColor[0] = 61;
			itemDef.modelID = 28145;
			itemDef.team = 0;
			itemDef.stackable = false;
			itemDef.modelRotation2 = 249;
			itemDef.modelZoom = 1632;
			itemDef.value = 500000;
			itemDef.modelOffset1 = 8;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = 8;
			itemDef.certID = 11689;
			itemDef.modelRotation1 = 567;
			itemDef.description = "Godsword shards 2 and 3.";
		}
		if (i == 9966) {
			itemDef.name = "Godsword blade";
			itemDef.actions = new String[5];
			itemDef.actions[4] = "Drop";
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor[0] = 5652;
			itemDef.editedModelColor[0] = 61;
			itemDef.modelID = 28166;
			itemDef.team = 0;
			itemDef.stackable = false;
			itemDef.modelRotation2 = 249;
			itemDef.modelZoom = 1503;
			itemDef.value = 500000;
			itemDef.modelOffset1 = 8;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = 8;
			itemDef.certID = 11691;
			itemDef.modelRotation1 = 567;
			itemDef.description = "The blade for the ultimate weapon.";
		}
		if (i == 9965) {
			itemDef.name = "Godsword shards";
			itemDef.actions = new String[5];
			itemDef.actions[4] = "Drop";
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor[0] = 5652;
			itemDef.editedModelColor[0] = 61;
			itemDef.modelID = 28150;
			itemDef.team = 0;
			itemDef.stackable = false;
			itemDef.modelRotation2 = 263;
			itemDef.modelZoom = 1168;
			itemDef.value = 500000;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = -3;
			itemDef.certID = 11693;
			itemDef.modelRotation1 = 463;
			itemDef.description = "Godsword shards 1 and 3.";
		}

		// Noted Items
		if (i == 8519) {// Noted SS
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7919;// Here is the id of the item you want noted
		}
		if (i == 8501) {// Noted D boots
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7964;// Here is the id of the item you want noted
		}
		if (i == 8502) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7813;// Here is the id of the item you want noted
		}
		if (i == 8503) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7814;// Here is the id of the item you want noted
		}
		if (i == 8504) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7815;// Here is the id of the item you want noted
		}
		if (i == 8505) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7816;// Here is the id of the item you want noted
		}
		if (i == 8506) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7817;// Here is the id of the item you want noted
		}
		if (i == 8507) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7818;// Here is the id of the item you want noted
		}
		if (i == 8508) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7819;// Here is the id of the item you want noted
		}
		if (i == 8509) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7820;// Here is the id of the item you want noted
		}
		if (i == 8510) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7905;// Here is the id of the item you want noted
		}
		if (i == 8511) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7841;// Here is the id of the item you want noted
		}
		if (i == 8512) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7462;// Here is the id of the item you want noted
		}
		if (i == 8513) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7905;// Here is the id of the item you want noted
		}
		if (i == 8514) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7906;// Here is the id of the item you want noted
		}
		if (i == 8515) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7907;// Here is the id of the item you want noted
		}
		if (i == 8516) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7908;// Here is the id of the item you want noted
		}
		if (i == 8517) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7909;// Here is the id of the item you want noted
		}
		if (i == 8518) {
			itemDef.actions = null;// Disables Actions on it. (Wield, etc)
			itemDef.certTemplateID = 799;// Just something jagex added, god
											// knows why. (Dont change)
			itemDef.certID = 7910;// Here is the id of the item you want noted
		}

		// End Noted items

		if (i == 7969) {
			itemDef.actions = new String[5];
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 25238;
			itemDef.newModelColor[0] = -2608;
			itemDef.modelID = 26456;
			itemDef.modelZoom = 1697;
			itemDef.modelOffset1 = -5;
			itemDef.modelRotation1 = 567;
			itemDef.modelRotation2 = 152;
			itemDef.anInt204 = 2047;
			itemDef.modelOffset2 = -5;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.stackable = false;
			itemDef.name = "Draconic visage";
			itemDef.description = "It looks like this could be attached to a shield somehow. ";
		}

		if (i == 13653) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[5];
			itemDef.newModelColor = new int[5];
			itemDef.modelID = 63202;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 500;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = -6;
			itemDef.modelOffset2 = 1;
			itemDef.anInt204 = 14;
			itemDef.anInt165 = 63203;
			itemDef.anInt200 = 63203;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.stackable = false;
			itemDef.name = "Death Cape";
			itemDef.description = "The cape worn by masters of PKing.";
		}
		if (i == 4407) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[4];
			itemDef.newModelColor = new int[4];
			itemDef.editedModelColor[0] = 57280;
			itemDef.editedModelColor[1] = 54503;
			itemDef.editedModelColor[2] = 54183;
			itemDef.editedModelColor[3] = 11200;
			itemDef.newModelColor[0] = 9152;
			itemDef.newModelColor[1] = 9172;
			itemDef.newModelColor[2] = 9172;
			itemDef.newModelColor[3] = 9152;
			itemDef.modelID = 29999;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 500;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 14;
			itemDef.modelOffset1 = -6;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 29999;
			itemDef.anInt200 = 29999;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Patrick's Cape";
			itemDef.description = "A very powerful Cape";
		}

if(i == 13658)
{
	itemDef.actions= new String[5];
	itemDef.actions[1] = "Wear";
	itemDef.modelID = 14091;
	itemDef.modelZoom = 650;
	itemDef.modelRotation1 = 126;
	itemDef.modelRotation2 = 129;
	itemDef.anInt204 = 83;
	itemDef.modelOffset1 = 0;
	itemDef.modelOffset2 = 0;
	itemDef.anInt165 = 14090;
	itemDef.anInt200 = 14090;
	itemDef.anInt188 = -1;
	itemDef.stackable = false;
	itemDef.anInt164 = -1;
	itemDef.anInt175 = -1;
	itemDef.name = "DC hat";
	itemDef.description  = "Nice.";
}

		if (i == 4409) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 9562;
			itemDef.modelZoom = 1150;
			itemDef.modelRotation1 = 400;
			itemDef.modelRotation2 = 1000;
			itemDef.anInt204 = 138;
			// itemDef.anInt199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 21;
			itemDef.anInt165 = 9559;
			itemDef.anInt200 = 9559;
			itemDef.anInt175 = -1;
			itemDef.stackable = false;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Winners Cape(1)";
			itemDef.description = "You won season 1 of BloodLust! Congrats!";
		}
		
		if (i == 4409) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 9562;
			itemDef.modelZoom = 1150;
			itemDef.modelRotation1 = 400;
			itemDef.modelRotation2 = 1000;
			itemDef.anInt204 = 138;
			// itemDef.anInt199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 21;
			itemDef.anInt165 = 9559;
			itemDef.anInt200 = 9559;
			itemDef.anInt175 = -1;
			itemDef.stackable = false;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Winners Cape(1)";
			itemDef.description = "You won season 1 of BloodLust! Congrats!";
		}

		if (i == 4411) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 9562;
			itemDef.modelZoom = 1150;
			itemDef.modelRotation1 = 400;
			itemDef.modelRotation2 = 1000;
			itemDef.anInt204 = 138;
			// itemDef.anInt199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 21;
			itemDef.anInt165 = 9559;
			itemDef.anInt200 = 9559;
			itemDef.anInt175 = -1;
			itemDef.stackable = false;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Winners Cape(2)";
			itemDef.description = "You came in second place for bloodlust!";
		}

		if (i == 4413) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 9562;
			itemDef.modelZoom = 1150;
			itemDef.modelRotation1 = 400;
			itemDef.modelRotation2 = 1000;
			itemDef.anInt204 = 138;
			// itemDef.anInt199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 21;
			itemDef.anInt165 = 9559;
			itemDef.anInt200 = 9559;
			itemDef.anInt175 = -1;
			itemDef.stackable = false;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Winners Cape(3)";
			itemDef.description = "You came in third place!";
		}

		if (i == 7837) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 9583;
			itemDef.modelID = 2438;
			itemDef.modelZoom = 730;
			itemDef.modelRotation1 = 516;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -10;
			itemDef.anInt165 = 3188;
			itemDef.anInt200 = 3192;
			itemDef.name = "White h'ween mask";
			itemDef.description = "A special gift from the Developers for Halloween 2010";
		}
		if (i == 7966) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926;
			itemDef.newModelColor[0] = 689484;
			itemDef.modelID = 2438;
			itemDef.modelZoom = 730;
			itemDef.modelRotation1 = 516;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -10;
			itemDef.anInt165 = 3188;
			itemDef.anInt200 = 3192;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = 1755;
			itemDef.anInt197 = 3187;
			itemDef.name = "Sky Blue h'ween mask";
			itemDef.description = "A special gift from the Developers for donators";
		}

		if (i == 9119) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear"; // this is the new option to equipt,
											// can change to w/e u want
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 926; // original color
			itemDef.newModelColor[0] = 6073; // changed color
			itemDef.modelID = 2438;
			itemDef.modelZoom = 730;
			itemDef.modelRotation1 = 516;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = -10;
			itemDef.anInt165 = 3188;
			itemDef.anInt200 = 3192;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = 1755;
			itemDef.anInt197 = 3187;
			itemDef.name = "Orange h'ween Mask";
			itemDef.description = "Aaaarrrghhh... I'm a monster.";
		}
		if (i == 13655) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.name = "Dragon kiteshield";
			itemDef.description = "A rare, protective kiteshield.";
			itemDef.modelID = 13701;
			itemDef.modelZoom = 1560;
			itemDef.modelRotation1 = 344;
			itemDef.modelRotation2 = 1104;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -6;
			itemDef.modelOffset2 = -14;
			itemDef.anInt165 = 13700;
			itemDef.anInt200 = 13700;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
		}

		if (i == 7963) {
			itemDef.actions = new String[5];
			// itemDef.actions[1] = "Use";
			itemDef.name = "Warrior Guild Token";
			itemDef.modelID = 15343;
			itemDef.modelZoom = 724;
			itemDef.modelRotation1 = 238;
			itemDef.modelRotation2 = 180;
			itemDef.modelOffset2 = -100;
			itemDef.modelOffset1 = 9;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.stackable = true;
			itemDef.description = "Tokens for the Warriors Guild.";
		}
		if (i == 7960) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 10004;
			itemDef.editedModelColor[1] = 5532;
			itemDef.newModelColor[0] = 0;
			itemDef.newModelColor[1] = 0;
			itemDef.modelID = 2649; // Model ID
			itemDef.anInt165 = 179; // Male Wield
			itemDef.anInt200 = 14572; // Female Wield
			itemDef.modelRotation1 = 420;
			itemDef.modelRotation2 = 828;
			itemDef.modelOffset1 = 5;
			itemDef.modelOffset2 = -8;
			itemDef.modelZoom = 930;
			itemDef.anInt204 = 138;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Void Knight gloves";
			itemDef.description = "Gloves as used by the order of the void knights.";
		}
		if (i == 79621) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 0;
			itemDef.newModelColor[0] = 0;
			itemDef.modelID = 15280;
			itemDef.modelZoom = 1308;
			itemDef.modelRotation1 = 402;
			itemDef.anInt204 = 138;
			itemDef.modelOffset2 = -10;
			itemDef.modelRotation2 = 258;
			itemDef.anInt165 = 14580;
			itemDef.anInt188 = -1;
			itemDef.anInt200 = 14579;
			itemDef.anInt185 = 176;
			itemDef.anInt162 = 353;
			itemDef.anInt175 = 56;
			itemDef.anInt197 = 116;
			itemDef.anInt173 = 120;
			itemDef.stackable = false;
			itemDef.name = "Void Knight Mace";
			itemDef.description = "A mace used by the order of the Void knights.";
		}
		if (i == 7902) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.name = "Dagon'hai robe top";
			itemDef.modelID = 44594;
			itemDef.modelZoom = 1697;
			itemDef.modelRotation1 = 536;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = 7;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 43614;
			itemDef.anInt200 = 43689;
			itemDef.anInt188 = 43681;
			itemDef.anInt164 = 43681;
			itemDef.description = "A robe worn by members of the Dagon'hai.";
		}
		if (i == 7904) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.name = "Dagon'hai Hat";
			itemDef.modelID = 44605;
			itemDef.modelZoom = 1373;
			itemDef.modelRotation1 = 98;
			itemDef.modelRotation2 = 1988;
			itemDef.modelOffset2 = -3;
			itemDef.modelOffset1 = 1;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 23926;
			itemDef.anInt200 = 23926;
			itemDef.description = "A Hat worn by members of the Dagon'hai.";
		}
		if (i == 7903) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.name = "Dagon'hai Robe Bottom";
			itemDef.modelID = 63301;
			itemDef.modelZoom = 2216;
			itemDef.modelRotation1 = 572;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = 14;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 63300;
			itemDef.anInt200 = 63300;
			itemDef.description = "A robe worn by members of the Dagon'hai.";
		}
		if (i == 7890) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[4];
			itemDef.newModelColor = new int[4];
			itemDef.editedModelColor[0] = 57280;
			itemDef.editedModelColor[1] = 54503;
			itemDef.editedModelColor[2] = 54183;
			itemDef.editedModelColor[3] = 11200;
			itemDef.newModelColor[0] = 9152;
			itemDef.newModelColor[1] = 7104;
			itemDef.newModelColor[2] = 7104;
			itemDef.newModelColor[3] = 796;
			itemDef.modelID = 40121;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 500;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 14;
			itemDef.modelOffset1 = -6;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 40122;
			itemDef.anInt200 = 40122;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			// itemdef.anint199 = -1;
			itemDef.name = "Respected Donator Cape"; // made by nathanr87
			itemDef.description = "A special cape for players who have supported Rune Republic extensively";
		}

		if (i == 7979) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[4];
			itemDef.newModelColor = new int[4];
			itemDef.editedModelColor[0] = 57280;
			itemDef.editedModelColor[1] = 54503;
			itemDef.editedModelColor[2] = 54183;
			itemDef.editedModelColor[3] = 11200;
			itemDef.newModelColor[0] = 9152;
			itemDef.newModelColor[1] = 7104;
			itemDef.newModelColor[2] = 7104;
			itemDef.newModelColor[3] = 796;
			itemDef.modelID = 42789;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 500;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 14;
			itemDef.modelOffset1 = -6;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 42790;
			itemDef.anInt200 = 42790;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			// itemdef.anint199 = -1;
			itemDef.name = "Donator Cape"; // made by nathanr87
			itemDef.description = "A special cape for players who have supported Rune Republic.";
		}
		if (i == 7929) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 28;
			itemDef.editedModelColor[1] = 74;
			itemDef.newModelColor[0] = 5642;
			itemDef.newModelColor[1] = 5652;
			itemDef.modelID = 4671; // Model ID
			itemDef.modelZoom = 490;
			itemDef.modelRotation1 = 344;
			itemDef.modelRotation2 = 192;
			itemDef.anInt204 = 0;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 20;
			itemDef.anInt165 = 4672; // Male Wield
			itemDef.anInt200 = 4672; // Female Wield
			itemDef.anInt175 = 56;
			itemDef.anInt197 = 116;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Bronze defender";
			itemDef.description = "A defensive weapon.";
		}
		if (i == 7930) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 28;
			itemDef.editedModelColor[1] = 74;
			itemDef.newModelColor[0] = 23;
			itemDef.newModelColor[1] = 33;
			itemDef.modelID = 4671; // Model ID
			itemDef.modelZoom = 490;
			itemDef.modelRotation1 = 344;
			itemDef.modelRotation2 = 192;
			itemDef.anInt204 = 0;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 20;
			itemDef.anInt165 = 4672; // Male Wield
			itemDef.anInt200 = 4672; // Female Wield
			itemDef.anInt175 = 56;
			itemDef.anInt197 = 116;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Iron defender";
			itemDef.description = "A defensive weapon.";
		}
		if (i == 7931) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 28;
			itemDef.editedModelColor[1] = 74;
			itemDef.newModelColor[0] = 43042;
			itemDef.newModelColor[1] = 43072;
			itemDef.modelID = 4671; // Model ID
			itemDef.modelZoom = 490;
			itemDef.modelRotation1 = 344;
			itemDef.modelRotation2 = 192;
			itemDef.anInt204 = 0;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 20;
			itemDef.anInt165 = 4672; // Male Wield
			itemDef.anInt200 = 4672; // Female Wield
			itemDef.anInt175 = 56;
			itemDef.anInt197 = 116;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Steel defender";
			itemDef.description = "A defensive weapon.";
		}
		if (i == 7932) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 28;
			itemDef.editedModelColor[1] = 74;
			itemDef.newModelColor[0] = 0;
			itemDef.newModelColor[1] = 10;
			itemDef.modelID = 4671; // Model ID
			itemDef.modelZoom = 490;
			itemDef.modelRotation1 = 344;
			itemDef.modelRotation2 = 192;
			itemDef.anInt204 = 0;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 20;
			itemDef.anInt165 = 4672; // Male Wield
			itemDef.anInt200 = 4672; // Female Wield
			itemDef.anInt175 = 56;
			itemDef.anInt197 = 116;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Black defender";
			itemDef.description = "A defensive weapon.";
		}
		if (i == 7933) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 28;
			itemDef.editedModelColor[1] = 74;
			itemDef.newModelColor[0] = 43277;
			itemDef.newModelColor[1] = 43297;
			itemDef.modelID = 4671; // Model ID
			itemDef.modelZoom = 490;
			itemDef.modelRotation1 = 344;
			itemDef.modelRotation2 = 192;
			itemDef.anInt204 = 0;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 20;
			itemDef.anInt165 = 4672; // Male Wield
			itemDef.anInt200 = 4672; // Female Wield
			itemDef.anInt175 = 56;
			itemDef.anInt197 = 116;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Mithril defender";
			itemDef.description = "A defensive weapon.";
		}
		if (i == 7970) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 28;
			itemDef.editedModelColor[1] = 74;
			itemDef.newModelColor[0] = 38676;
			itemDef.newModelColor[1] = 38313;
			itemDef.modelID = 15335; // Model ID
			itemDef.modelZoom = 490;
			itemDef.modelRotation1 = 344;
			itemDef.modelRotation2 = 192;
			itemDef.anInt204 = 0;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 20;
			itemDef.anInt165 = 15413; // Male Wield
			itemDef.anInt200 = 15413; // Female Wield
			itemDef.anInt175 = 56;
			itemDef.anInt197 = 116;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Rune defender";
			itemDef.description = "A defensive weapon.";

		}
		if (i == 7934) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 28;
			itemDef.editedModelColor[1] = 74;
			itemDef.newModelColor[0] = 21642;
			itemDef.newModelColor[1] = 21662;
			itemDef.modelID = 4671; // Model ID
			itemDef.modelZoom = 490;
			itemDef.modelRotation1 = 344;
			itemDef.modelRotation2 = 192;
			itemDef.anInt204 = 0;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 20;
			itemDef.anInt165 = 4672; // Male Wield
			itemDef.anInt200 = 4672; // Female Wield
			itemDef.anInt175 = 56;
			itemDef.anInt197 = 116;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Adamant defender";
			itemDef.description = "A defensive weapon.";
		}
		if (i == 7820) {
			itemDef.name = "Vesta's Chainbody";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42593;
			itemDef.modelZoom = 1440;
			itemDef.modelRotation1 = 545;
			itemDef.modelRotation2 = 2;
			itemDef.modelOffset2 = 5;
			itemDef.modelOffset1 = 4;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42624;
			itemDef.anInt200 = 42644;
			itemDef.description = "Vesta's Chainbody, a reward from PVP.";
		}
		if (i == 7842) {
			itemDef.name = "Vesta's Plateskirt";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42581;
			itemDef.modelZoom = 1753;
			itemDef.modelRotation1 = 562;
			itemDef.modelRotation2 = 1;
			itemDef.modelOffset2 = 11;
			itemDef.modelOffset1 = -3;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42633;
			itemDef.anInt200 = 42647;
			itemDef.description = "Vesta's Plateskirt, a reward from PVP.";
		}

		if (i == 7843) {
			itemDef.name = "Vesta's Longsword";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42597;
			itemDef.modelZoom = 1744;
			itemDef.modelRotation1 = 738;
			itemDef.modelRotation2 = 1985;
			itemDef.modelOffset2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42615;
			itemDef.anInt200 = 42615;
			itemDef.description = "Vesta's Longsword, a reward from PVP.";
		}

		if (i == 7844) {
			itemDef.name = "Vesta's Spear";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42599;
			itemDef.modelZoom = 2022;
			itemDef.modelRotation1 = 480;
			itemDef.modelRotation2 = 15;
			itemDef.modelOffset2 = 5;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42614;
			itemDef.anInt200 = 42614;
			itemDef.description = "Vesta's Spear, a reward from PVP.";
		}

		if (i == 7845) {
			itemDef.name = "Zuriel's Robe Top";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42591;
			itemDef.modelZoom = 1373;
			itemDef.modelRotation1 = 373;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = -7;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42627;
			itemDef.anInt200 = 42642;
			itemDef.description = "Zuriel's Robe Top, a reward from PVP.";
		}

		if (i == 7846) {
			itemDef.name = "Zuriel's Robe Bottom";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42588;
			itemDef.modelZoom = 1697;
			itemDef.modelRotation1 = 512;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = -9;
			itemDef.modelOffset1 = 2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42634;
			itemDef.anInt200 = 42645;
			itemDef.description = "Zuriel's Robe Bottom, a reward from PVP.";
		}

		if (i == 7847) {
			itemDef.name = "Zuriel's Staff";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42595;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 366;
			itemDef.modelRotation2 = 3;
			itemDef.modelOffset2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42617;
			itemDef.anInt200 = 42617;
			itemDef.description = "Zuriel's Staff, a reward from PVP.";
		}

		if (i == 7848) {
			itemDef.name = "Zuriel's Hood";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42604;
			itemDef.modelZoom = 720;
			itemDef.modelRotation1 = 28;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.modelOffset1 = 1;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42638;
			itemDef.anInt200 = 42653;
			itemDef.description = "Zuriel's Hood, a reward from PVP.";
		}

		if (i == 7849) {
			itemDef.name = "Morrigan's leather body";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42578;
			itemDef.modelZoom = 1184;
			itemDef.modelRotation1 = 545;
			itemDef.modelRotation2 = 2;
			itemDef.modelOffset2 = 5;
			itemDef.modelOffset1 = 4;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42626;
			itemDef.anInt200 = 42643;
			itemDef.description = "Morrigan's Leather Body, a reward from PVP.";
		}

		if (i == 7850) {
			itemDef.name = "Morrigan's Leather Chaps";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42603;
			itemDef.modelZoom = 1753;
			itemDef.modelRotation1 = 482;
			itemDef.modelRotation2 = 1;
			itemDef.modelOffset2 = 11;
			itemDef.modelOffset1 = -3;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42631;
			itemDef.anInt200 = 42646;
			itemDef.description = "Morrigan's Leather Chaps, a reward from PVP.";
		}

		if (i == 7851) {
			itemDef.name = "Morrigan's Coif";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42583;
			itemDef.modelZoom = 592;
			itemDef.modelRotation1 = 537;
			itemDef.modelRotation2 = 5;
			itemDef.modelOffset2 = 6;
			itemDef.modelOffset1 = -3;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42636;
			itemDef.anInt200 = 42652;
			itemDef.description = "Morrigan's Coif, a reward from PVP.";
		}

		if (i == 7852) {
			itemDef.name = "Statius's Platebody";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42602;
			itemDef.modelZoom = 1312;
			itemDef.modelRotation1 = 272;
			itemDef.modelRotation2 = 2047;
			itemDef.modelOffset2 = 39;
			itemDef.modelOffset1 = -2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42625;
			itemDef.anInt200 = 42641;
			itemDef.description = "Statius's Platebody, a reward from PVP.";
		}

		if (i == 7853) {
			itemDef.name = "Statius's Platelegs";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42590;
			itemDef.modelZoom = 1625;
			itemDef.modelRotation1 = 355;
			itemDef.modelRotation2 = 2046;
			itemDef.modelOffset2 = -11;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42632;
			itemDef.anInt200 = 42649;
			itemDef.description = "Statius's Platelegs, a reward from PVP.";
		}
		if (i == 13659) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[6];
			itemDef.newModelColor = new int[6];
			itemDef.editedModelColor[0] = 22168;
			itemDef.newModelColor[0] = -21864;
			itemDef.editedModelColor[1] = 8070;
			itemDef.newModelColor[1] = -24771;
			itemDef.editedModelColor[2] = 24082;
			itemDef.newModelColor[2] = -24046;
			itemDef.editedModelColor[3] = 22156;
			itemDef.newModelColor[3] = -21876;
			itemDef.editedModelColor[4] = 920;
			itemDef.newModelColor[4] = -25788;
			itemDef.editedModelColor[5] = 912;
			itemDef.newModelColor[5] = -27983;
			itemDef.modelID = 20267;
			itemDef.modelOffset1 = -1;
			itemDef.modelZoom = 848;
			itemDef.modelRotation1 = 387;
			itemDef.modelRotation2 = 1189;
			itemDef.modelOffset2 = 12;
			itemDef.anInt204 = 2047;
			itemDef.anInt165 = 20137;
			itemDef.anInt200 = 20186;
			itemDef.stackable = false;
			itemDef.name = "A powdered wig";
			itemDef.description = "A big do about nothing.";
		}

		if (i == 7814) // ItemID
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 8000;
			itemDef.modelZoom = 1540;
			itemDef.modelRotation1 = 336;
			itemDef.modelRotation2 = 1020;
			itemDef.anInt204 = 97;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 15;
			itemDef.anInt165 = 9000;
			itemDef.anInt200 = 9000;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Divine Spirit Shield";
			itemDef.description = "An ethereal shield with an sigil attached to it.";
		}
		if (i == 13651) // change this if you need to "item number"
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";// New option
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 43072;
			itemDef.newModelColor[0] = 925;
			itemDef.editedModelColor[1] = 4550;
			itemDef.newModelColor[1] = 925;
			itemDef.modelID = 29784; // Model ID
			itemDef.modelZoom = 1330; // zoom increase will make it smaller
			itemDef.modelRotation1 = 310; // model rotate up+down increase to
											// move doen away from you
			itemDef.modelRotation2 = 1800; // model rotate side ways increase to
											// move right in circle
			itemDef.modelOffset1 = 0; // model offset increase to move to the
										// right
			itemDef.modelOffset2 = 1; // model offset increase to move up
			itemDef.anInt165 = 40207;// male wearing
			itemDef.anInt200 = 40207;// female wearing
			itemDef.anInt164 = -1;// Female arms/sleeves
			itemDef.anInt188 = -1;// male arms/sleeves
			itemDef.stackable = false;// Stackable
			itemDef.name = "Dragon platebody";// Name of the new item
			itemDef.description = "Provides excellent protection";// examin info
		}
		
		
		if(i == 13677) {
itemDef.actions = new String[5];
itemDef.actions[1] = "Wear";
itemDef.modelID = 14125; //Inv & Ground
itemDef.modelZoom = 2000; //Zoom
itemDef.modelRotation1 = 572;
itemDef.modelRotation2 = 0;
itemDef.anInt204 = 0;
itemDef.modelOffset1 = 0;
itemDef.modelOffset2 = 1;
itemDef.anInt165 = 14126; //Male
itemDef.anInt200 = 14126; //Female
itemDef.anInt175 = -1;
itemDef.anInt197 = -1;
itemDef.stackable = false;// Stackable
itemDef.name = "Moderator cape";
itemDef.description = "Its A moderator Cape";
}
if(i == 13678) {
itemDef.actions = new String[5];
itemDef.actions[1] = "Wear";
itemDef.modelID = 14127; //Inv & Ground
itemDef.modelZoom = 2000; //Zoom
itemDef.modelRotation1 = 572;
itemDef.modelRotation2 = 0;
itemDef.anInt204 = 0;
itemDef.modelOffset1 = 0;
itemDef.modelOffset2 = 1;
itemDef.anInt165 = 14128; //Male
itemDef.anInt200 = 14128; //Female
itemDef.anInt175 = -1;
itemDef.anInt197 = -1;
itemDef.stackable = false;// Stackable
itemDef.name = "Administrator cape";
itemDef.description = "Its an administrator cape";
}
if(i == 13679) {
itemDef.actions = new String[5];
itemDef.actions[1] = "Wear";
itemDef.modelID = 14129; //Inv & Ground
itemDef.modelZoom = 2000; //Zoom
itemDef.modelRotation1 = 572;
itemDef.modelRotation2 = 0;
itemDef.anInt204 = 0;
itemDef.modelOffset1 = 0;
itemDef.modelOffset2 = 1;
itemDef.anInt165 = 14130; //Male
itemDef.anInt200 = 14130; //Female
itemDef.anInt175 = -1;
itemDef.anInt197 = -1;
itemDef.stackable = false;// Stackable
itemDef.name = "Owner cape";
itemDef.description = "Its an owner cape";
        }
		if (i == 7854) // change this if you need to "item number"
		{
			itemDef.name = "Statius's Full Helm";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 42596;
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 96;
			itemDef.modelRotation2 = 2039;
			itemDef.modelOffset2 = -7;
			itemDef.modelOffset1 = 2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42639;
			itemDef.anInt200 = 42655;
			itemDef.description = "Statius's Full Helm, a reward from PVP.";
		}
		if (i == 7855) // change this if you need to "item number"
		{
			itemDef.name = "Statius's Warhammer";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42577;
			itemDef.modelZoom = 1360;
			itemDef.modelRotation1 = 507;
			itemDef.modelRotation2 = 27;
			itemDef.modelOffset2 = 6;
			itemDef.modelOffset1 = 7;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42623;
			itemDef.anInt200 = 42623;
			itemDef.description = "Statius's Warhammer, a reward from PVP.";
		}

		if (i == 13652) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 13698;
			itemDef.modelZoom = 789; // zoom; increase will make it smaller
			itemDef.modelRotation1 = 240;
			itemDef.modelRotation2 = 60;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -23;
			itemDef.anInt165 = 13699;
			itemDef.anInt200 = 13699;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.name = "Dragon claws";
			itemDef.description = "A set of fighting claws.";
		}

		if (i == 7856) // change this if you need to "item number"
		{
			itemDef.name = "Morrigan's Javelin";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42592;
			itemDef.modelZoom = 1872;
			itemDef.modelRotation1 = 282;
			itemDef.modelRotation2 = 2009;
			itemDef.modelOffset2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42613;
			itemDef.anInt200 = 42613;
			itemDef.description = "Morrigan's Javelin, a reward from PVP.";
		}
		if (i == 7857) // change this if you need to "item number"
		{
			itemDef.name = "Morrigan's Throwing Axe";
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 42582;
			itemDef.modelZoom = 976;
			itemDef.modelRotation1 = 672;
			itemDef.modelRotation2 = 2024;
			itemDef.modelOffset2 = 4;
			itemDef.modelOffset1 = -5;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42611;
			itemDef.anInt200 = 42611;
			itemDef.description = "Morrigan's Throwing Axe, a reward from PVP.";
		}
		if (i == 6656) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[3];
			itemDef.newModelColor = new int[3];
			itemDef.modelID = 10999; // Inv & Ground 19065
			itemDef.modelZoom = 1100; // zoom
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 500;
			itemDef.anInt204 = 300; // Rotate Up-Down
			itemDef.modelOffset1 = 0; // Rotate Left-Right
			itemDef.modelOffset2 = -4; // Up down
			itemDef.anInt165 = 10998; // Male 18951
			itemDef.anInt200 = 10998; // Female 18951
			itemDef.anInt175 = 100; // left-Right move
			itemDef.anInt197 = 100; // Up- down move
			itemDef.name = "Top Hat";
			itemDef.description = "It's the Top Hat!";
		}
		if (i == 7815) // ItemID
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 8001;
			itemDef.modelZoom = 1540;
			itemDef.modelRotation1 = 336;
			itemDef.modelRotation2 = 1020;
			itemDef.anInt204 = 97;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 15;
			itemDef.anInt165 = 9001;
			itemDef.anInt200 = 9001;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Blessed Spirit Shield";
			itemDef.description = "An ethereal shield with an sigil attached to it.";
		}
		if (i == 7816) // ItemID
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 8002;
			itemDef.modelZoom = 1540;
			itemDef.modelRotation1 = 336;
			itemDef.modelRotation2 = 1020;
			itemDef.anInt204 = 97;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 15;

			itemDef.anInt165 = 9002;
			itemDef.anInt200 = 9002;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Elysian Spirit Shield";
			itemDef.description = "An ethereal shield with an sigil attached to it.";
		}
		if (i == 7817) // ItemID
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 8003;
			itemDef.modelZoom = 1540;
			itemDef.modelRotation1 = 336;
			itemDef.modelRotation2 = 1020;
			itemDef.anInt204 = 97;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 15;
			itemDef.anInt165 = 9003;
			itemDef.anInt200 = 9003;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Spirit Shield";
			itemDef.description = "An ethereal shield with an sigil attached to it.";
		}
		if (i == 7818) // ItemID
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 8004;
			itemDef.modelZoom = 1540;
			itemDef.modelRotation1 = 336;
			itemDef.modelRotation2 = 1020;
			itemDef.anInt204 = 97;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 15;
			itemDef.anInt165 = 9004;
			itemDef.anInt200 = 9004;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Arcane Spirit Shield";
			itemDef.description = "An ethereal shield with an sigil attached to it.";
		}
		if (i == 7813) // ItemID
		{
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 8889;
			itemDef.modelZoom = 1540;
			itemDef.modelRotation1 = 336;
			itemDef.modelRotation2 = 1020;
			itemDef.anInt204 = 97;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 15;

			itemDef.anInt165 = 8888;
			itemDef.anInt200 = 8888;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Spectral Spirit Shield";
			itemDef.description = "An ethereal shield with an sigil attached to it.";
		}
		if (i == 7810) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 5916;
			itemDef.newModelColor[0] = 127;
			itemDef.editedModelColor[1] = 4882;
			itemDef.newModelColor[1] = 127;
			itemDef.modelID = 21219;
			itemDef.modelOffset1 = 4;
			itemDef.modelZoom = 415;
			itemDef.modelRotation1 = 282;
			itemDef.modelRotation2 = 73;
			itemDef.modelOffset2 = 100;
			itemDef.anInt204 = 69;
			itemDef.anInt165 = 21147;
			itemDef.anInt200 = 21203;
			itemDef.stackable = false;
			itemDef.name = "Amulet of glory(t)";
			itemDef.description = "A very powerful dragonstone amulet.";

		}
		if (i == 7811) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 5916;
			itemDef.newModelColor[0] = 127;
			itemDef.editedModelColor[1] = 4882;
			itemDef.newModelColor[1] = 127;
			itemDef.modelID = 20226;
			itemDef.modelOffset1 = 5;
			itemDef.modelZoom = 465;
			itemDef.modelRotation1 = 292;
			itemDef.modelRotation2 = 74;
			itemDef.modelOffset2 = 100;
			itemDef.anInt204 = 69;
			itemDef.anInt165 = 20149;
			itemDef.anInt200 = 20205;
			itemDef.stackable = false;
			itemDef.name = "Strength amulet(t)";
			itemDef.description = "An enchanted ruby amulet. ";
		}
		if (i == 7812) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 5916;
			itemDef.newModelColor[0] = 127;
			itemDef.editedModelColor[1] = 4882;
			itemDef.newModelColor[1] = 127;
			itemDef.modelID = 20225;
			itemDef.modelOffset1 = 4;
			itemDef.modelZoom = 400;
			itemDef.modelRotation1 = 284;
			itemDef.modelRotation2 = 90;
			itemDef.modelOffset2 = 100;
			itemDef.anInt204 = 111;
			itemDef.anInt165 = 20148;
			itemDef.anInt200 = 20204;
			itemDef.stackable = false;
			itemDef.name = "Amulet of magic(t)";
			itemDef.description = "An enchanted ruby amulet. ";
		}
		if (i == 7597) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[6];
			itemDef.newModelColor = new int[6];
			itemDef.editedModelColor[0] = 22168;
			itemDef.newModelColor[0] = 664;
			itemDef.editedModelColor[1] = 8070;
			itemDef.newModelColor[1] = 962;
			itemDef.editedModelColor[2] = 24082;
			itemDef.newModelColor[2] = 910;
			itemDef.editedModelColor[3] = 22156;
			itemDef.newModelColor[3] = 652;
			itemDef.editedModelColor[4] = 920;
			itemDef.newModelColor[4] = 962;
			itemDef.editedModelColor[5] = 912;
			itemDef.newModelColor[5] = 1697;
			itemDef.modelID = 20233;
			itemDef.modelOffset1 = 0;
			itemDef.modelZoom = 1100;
			itemDef.modelRotation1 = 572;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 20157;
			itemDef.anInt200 = 20213;
			itemDef.anInt164 = 20121;
			itemDef.anInt188 = 20177;
			itemDef.stackable = false;
			itemDef.name = "Zamorak d'hide";
			itemDef.description = "Zamorak blessed dragonhide chest.";
		}
		if (i == 7598) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[6];
			itemDef.newModelColor = new int[6];
			itemDef.editedModelColor[0] = 22168;
			itemDef.newModelColor[0] = 664;
			itemDef.editedModelColor[1] = 8070;
			itemDef.newModelColor[1] = 962;
			itemDef.editedModelColor[2] = 24082;
			itemDef.newModelColor[2] = 910;
			itemDef.editedModelColor[3] = 22156;
			itemDef.newModelColor[3] = 652;
			itemDef.editedModelColor[4] = 920;
			itemDef.newModelColor[4] = 962;
			itemDef.editedModelColor[5] = 912;
			itemDef.newModelColor[5] = 1697;
			itemDef.modelID = 20230;
			itemDef.modelZoom = 1750;
			itemDef.modelOffset1 = 0;
			itemDef.modelRotation1 = 488;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt188 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.anInt165 = 20139;
			itemDef.anInt200 = 20194;
			itemDef.name = "Zamorak chaps";
			itemDef.description = "Zamorak blessed dragonhide chaps.";
		}
		if (i == 7599) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[6];
			itemDef.newModelColor = new int[6];
			itemDef.editedModelColor[0] = 22168;
			itemDef.newModelColor[0] = 664;
			itemDef.editedModelColor[1] = 8070;
			itemDef.newModelColor[1] = 962;
			itemDef.editedModelColor[2] = 24082;
			itemDef.newModelColor[2] = 910;
			itemDef.editedModelColor[3] = 22156;
			itemDef.newModelColor[3] = 652;
			itemDef.editedModelColor[4] = 920;
			itemDef.newModelColor[4] = 962;
			itemDef.editedModelColor[5] = 912;
			itemDef.newModelColor[5] = 1697;
			itemDef.modelID = 20231;
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 194;
			itemDef.anInt204 = 0;
			itemDef.modelRotation2 = 1784;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -35;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.anInt165 = 20131;
			itemDef.anInt200 = 20184;
			itemDef.stackable = false;
			itemDef.name = "Zamorak coif";
			itemDef.description = "Zamorak blessed dragonhide coif.";
		}
		if (i == 7600) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[3];
			itemDef.newModelColor = new int[3];
			itemDef.editedModelColor[0] = 22156;
			itemDef.newModelColor[0] = 664;
			itemDef.editedModelColor[1] = 912;
			itemDef.newModelColor[1] = 962;
			itemDef.editedModelColor[2] = 22408;
			itemDef.newModelColor[2] = 904;
			itemDef.modelID = 20264;
			itemDef.modelZoom = 740;
			itemDef.modelRotation1 = 196;
			itemDef.modelRotation2 = 1784;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 7;
			itemDef.modelOffset2 = -33;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.anInt165 = 20129;
			itemDef.anInt200 = 20180;
			itemDef.name = "Zamorak bracers";
			itemDef.description = "Zamorak blessed dragonhide vambraces.";
		}
		if (i == 7601) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[6];
			itemDef.newModelColor = new int[6];
			itemDef.editedModelColor[0] = 22168;
			itemDef.newModelColor[0] = -21864;
			itemDef.editedModelColor[1] = 8070;
			itemDef.newModelColor[1] = -24772;
			itemDef.editedModelColor[2] = 24082;
			itemDef.newModelColor[2] = -24046;
			itemDef.editedModelColor[3] = 22156;
			itemDef.newModelColor[3] = -21876;
			itemDef.editedModelColor[4] = 920;
			itemDef.newModelColor[4] = -25788;
			itemDef.editedModelColor[5] = 912;
			itemDef.newModelColor[5] = -27983;
			itemDef.modelID = 20224;
			itemDef.modelOffset1 = 0;
			itemDef.modelZoom = 1100;
			itemDef.modelRotation1 = 572;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 20156;
			itemDef.anInt200 = 20212;
			itemDef.anInt164 = 20121;
			itemDef.anInt188 = 20177;
			itemDef.stackable = false;
			itemDef.name = "Saradomin d'hide";
			itemDef.description = "Saradomin blessed dragonhide chest.";
		}
		if (i == 7602) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[6];
			itemDef.newModelColor = new int[6];
			itemDef.editedModelColor[0] = 22168;
			itemDef.newModelColor[0] = -21864;
			itemDef.editedModelColor[1] = 8070;
			itemDef.newModelColor[1] = -24772;
			itemDef.editedModelColor[2] = 24082;
			itemDef.newModelColor[2] = -24046;
			itemDef.editedModelColor[3] = 22156;
			itemDef.newModelColor[3] = -21876;
			itemDef.editedModelColor[4] = 920;
			itemDef.newModelColor[4] = -25788;
			itemDef.editedModelColor[5] = 912;
			itemDef.newModelColor[5] = -27983;
			itemDef.modelID = 20230;
			itemDef.modelZoom = 1750;
			itemDef.modelOffset1 = 0;
			itemDef.modelRotation1 = 488;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt188 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.anInt165 = 20139;
			itemDef.anInt200 = 20194;
			itemDef.name = "Saradomin chaps";
			itemDef.description = "Saradomin chaps.";
		}
		if (i == 7603) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[6];
			itemDef.newModelColor = new int[6];
			itemDef.editedModelColor[0] = 22168;
			itemDef.newModelColor[0] = -21864;
			itemDef.editedModelColor[1] = 8070;
			itemDef.newModelColor[1] = -24772;
			itemDef.editedModelColor[2] = 24082;
			itemDef.newModelColor[2] = -24046;
			itemDef.editedModelColor[3] = 22156;
			itemDef.newModelColor[3] = -21876;
			itemDef.editedModelColor[4] = 920;
			itemDef.newModelColor[4] = -25788;
			itemDef.editedModelColor[5] = 912;
			itemDef.newModelColor[5] = -27983;
			itemDef.modelID = 20231;
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 194;
			itemDef.anInt204 = 0;
			itemDef.modelRotation2 = 1784;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -35;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.anInt165 = 20131;
			itemDef.anInt200 = 20184;
			itemDef.stackable = false;
			itemDef.name = "Saradomin coif";
			itemDef.description = "Saradomin coif.";
		}
		if (i == 7604) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[3];
			itemDef.newModelColor = new int[3];
			itemDef.editedModelColor[0] = 22156;
			itemDef.newModelColor[0] = -21864;
			itemDef.editedModelColor[1] = 912;
			itemDef.newModelColor[1] = -24772;
			itemDef.editedModelColor[2] = 22408;
			itemDef.newModelColor[2] = -21624;
			itemDef.modelID = 20264;
			itemDef.modelZoom = 740;
			itemDef.modelRotation1 = 196;
			itemDef.modelRotation2 = 1784;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 7;
			itemDef.modelOffset2 = -33;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.anInt165 = 20129;
			itemDef.anInt200 = 20180;
			itemDef.name = "Saradomin bracers";
			itemDef.description = "Saradomin blessed dragonhide vambraces.";
		}
		if (i == 7605) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[3];
			itemDef.newModelColor = new int[3];
			itemDef.editedModelColor[0] = 920;
			itemDef.newModelColor[0] = 27210;
			itemDef.editedModelColor[1] = 912;
			itemDef.newModelColor[1] = 24014;
			itemDef.editedModelColor[2] = 8070;
			itemDef.newModelColor[2] = 19788;
			itemDef.modelID = 20232;
			itemDef.modelOffset1 = 0;
			itemDef.modelZoom = 1100;
			itemDef.modelRotation1 = 572;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 20155;
			itemDef.anInt200 = 20211;
			itemDef.anInt164 = 20121;
			itemDef.anInt188 = 20177;
			itemDef.stackable = false;
			itemDef.name = "Guthix dragonhide";
			itemDef.description = "Guthix blessed dragonhide chest.";

		}
		if (i == 7606) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[3];
			itemDef.newModelColor = new int[3];
			itemDef.editedModelColor[0] = 920;
			itemDef.newModelColor[0] = 27210;
			itemDef.editedModelColor[1] = 912;
			itemDef.newModelColor[1] = 24014;
			itemDef.editedModelColor[2] = 8070;
			itemDef.newModelColor[2] = 19788;
			itemDef.modelID = 20230;
			itemDef.modelZoom = 1750;
			itemDef.modelOffset1 = 0;
			itemDef.modelRotation1 = 488;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt188 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.anInt165 = 20139;
			itemDef.anInt200 = 20194;
			itemDef.name = "Guthix chaps";
			itemDef.description = "Guthix blessed dragonhide chaps.";
		}
		if (i == 7607) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[3];
			itemDef.newModelColor = new int[3];
			itemDef.editedModelColor[0] = 920;
			itemDef.newModelColor[0] = 27210;
			itemDef.editedModelColor[1] = 912;
			itemDef.newModelColor[1] = 24014;
			itemDef.editedModelColor[2] = 8070;
			itemDef.newModelColor[2] = 19788;
			itemDef.modelID = 20231;
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 194;
			itemDef.anInt204 = 0;
			itemDef.modelRotation2 = 1784;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -35;
			itemDef.anInt188 = -1;
			itemDef.anInt165 = 20131;
			itemDef.anInt200 = 20184;
			itemDef.stackable = false;
			itemDef.name = "Guthix coif";
			itemDef.description = "Guthix blessed dragonhide coif.";
		}
		if (i == 7608) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[3];
			itemDef.newModelColor = new int[3];
			itemDef.editedModelColor[0] = 920;
			itemDef.newModelColor[0] = 27210;
			itemDef.editedModelColor[1] = 912;
			itemDef.newModelColor[1] = 24014;
			itemDef.editedModelColor[2] = 8070;
			itemDef.newModelColor[2] = 19788;
			itemDef.modelID = 20264;
			itemDef.modelZoom = 740;
			itemDef.modelRotation1 = 196;
			itemDef.modelRotation2 = 1784;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 7;
			itemDef.modelOffset2 = -33;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.anInt165 = 20129;
			itemDef.anInt200 = 20180;
			itemDef.name = "Guthix bracers";
			itemDef.description = "Guthix blessed dragonhide vambraces.";
		}
		if (i == 553) {
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 7995;
			itemDef.newModelColor[0] = 95802;
			itemDef.modelID = 16999;
			itemDef.modelZoom = 740;
			itemDef.modelRotation1 = 528;
			itemDef.modelRotation2 = 1012;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 16999;
			itemDef.anInt200 = 16999;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Astral rune";
			itemDef.description = "Used for Lunar spells."; // Use Either One of
															// These
		}
		if (i == 6070) // change this if you need to "item number"
		{
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[3];
			itemDef.newModelColor = new int[3];
			itemDef.editedModelColor[0] = 916;
			itemDef.newModelColor[0] = 22420;
			itemDef.editedModelColor[1] = 908;
			itemDef.newModelColor[1] = 22412;
			itemDef.editedModelColor[2] = 307;
			itemDef.newModelColor[2] = 21811;
			itemDef.modelID = 20454;
			itemDef.modelZoom = 976;
			itemDef.modelRotation1 = 567;
			itemDef.modelRotation2 = 1120;
			itemDef.anInt204 = 1923;
			itemDef.modelOffset1 = -4;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = 20423;
			itemDef.anInt200 = 20429;
			itemDef.anInt166 = 63;
			itemDef.anInt173 = 120;
			itemDef.anInt167 = 100;
			itemDef.anInt192 = 100;
			itemDef.anInt191 = 100;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 100;
			itemDef.stackable = false;
			itemDef.name = "Ava's accumulator";
			itemDef.description = "It's Ava's accumulator of course..";

		}
		if (i == 7919) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 22457;
			itemDef.newModelColor[0] = 924;
			itemDef.modelID = 28136;
			itemDef.modelZoom = 2151;
			itemDef.modelRotation1 = 636;
			itemDef.modelRotation2 = 1521;
			itemDef.anInt204 = 144;
			itemDef.modelOffset1 = 3;
			itemDef.modelOffset2 = 3;
			itemDef.anInt165 = 27728;
			itemDef.anInt200 = 27728;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Saradomin sword";
			itemDef.description = "A powerful sword brought to you by the gods";
		}

		if (i == 7936) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[3];
			itemDef.newModelColor = new int[3];
			itemDef.editedModelColor[0] = 5559;
			itemDef.newModelColor[0] = -12871;
			itemDef.editedModelColor[1] = 5665;
			itemDef.newModelColor[1] = -15808;
			itemDef.editedModelColor[2] = 5784;
			itemDef.newModelColor[2] = -15689;
			itemDef.modelID = 13047;
			itemDef.modelZoom = 543;
			itemDef.modelRotation1 = 282;
			itemDef.modelRotation2 = 73;
			itemDef.modelOffset1 = 4;
			itemDef.anInt175 = -1;
			itemDef.modelOffset2 = 100;
			itemDef.anInt197 = -1;
			itemDef.anInt204 = 69;
			itemDef.anInt165 = 13048;
			itemDef.anInt200 = 13049;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.stackable = false;
			itemDef.name = "3rd age amulet";
			itemDef.description = "Fabulously ancient magic protection enchanted in the 3rd age. ";

		}
		if (i == 7906) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 28139;// 28139
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 66;
			itemDef.modelRotation2 = 372;
			itemDef.anInt204 = 144;
			itemDef.modelOffset1 = 9;
			itemDef.modelOffset2 = -4;
			itemDef.anInt165 = 27747;
			itemDef.anInt200 = 27747;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Armadyl helmet";
			itemDef.description = "An Armadyl helmet.";
		}
		if (i == 13654) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 0;
			itemDef.newModelColor[0] = 0;
			itemDef.modelID = 10345;
			itemDef.modelZoom = 1178;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 1840;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;
			itemDef.anInt165 = 10344;
			itemDef.anInt200 = 14561;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.stackable = false;
			itemDef.name = "Slayer Helm";
			itemDef.description = "Its A Slayer Helm!";

		}

		if (i == 7907) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 28141;
			itemDef.modelZoom = 900;
			itemDef.modelRotation1 = 540;
			itemDef.modelRotation2 = 2039;
			// itemdef.anint199 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 27734;
			itemDef.anInt200 = 27752;
			itemDef.anInt175 = -1;
			itemDef.stackable = false;
			itemDef.anInt164 = 27750;
			itemDef.anInt188 = 27758;
			itemDef.stackable = false;
			itemDef.name = "Armadyl chestplate";
			itemDef.description = "An Armadyl Chestplate.";
		}
		if (i == 7908) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 28132; // Model ID
			itemDef.modelZoom = 1957;
			itemDef.modelRotation1 = 555;
			itemDef.modelRotation2 = 2036;
			itemDef.anInt204 = 144;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -3;
			itemDef.anInt165 = 27742;// male wearing
			itemDef.anInt200 = 27756;// female wearing
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Armadyl plateskirt";
			itemDef.description = "An Armadyl Plateskirt.";
		}

		if (i == 7922) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = -22464;
			itemDef.newModelColor[0] = 4550;
			itemDef.modelID = 10050;
			itemDef.modelZoom = 919;
			itemDef.modelRotation1 = 459;
			itemDef.anInt204 = 138;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			itemDef.anInt165 = 10053;
			itemDef.anInt188 = 10051;
			itemDef.anInt200 = 10052;
			itemDef.anInt164 = 10054;
			itemDef.anInt166 = 63;
			itemDef.anInt173 = 120;
			itemDef.name = "Void Knight Top";
			itemDef.description = "It's a Void Knight Top";

		}

		if (i == 7921) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 27164; // Model Drop/inv view
			itemDef.modelZoom = 919;
			itemDef.modelRotation1 = 429;
			itemDef.modelRotation2 = 1660;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 5;
			itemDef.anInt197 = 120;
			itemDef.anInt165 = 27151; // male wearing
			itemDef.anInt200 = 27137; // female wearing
			itemDef.anInt164 = -1; // Female arms/sleeves
			itemDef.anInt188 = -1; // male arms/sleeves
			itemDef.anInt175 = 65;
			itemDef.stackable = false;
			itemDef.name = "Void Mage Helm";
			itemDef.description = "A void knight magic helmet.";
		}
		if (i == 7939) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 27163; // Model Drop/inv view
			itemDef.modelZoom = 620;
			itemDef.modelRotation1 = 88;
			itemDef.modelRotation2 = 188;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = 27150; // male wearing
			itemDef.anInt200 = 27138; // female wearing
			itemDef.anInt164 = -1; // Female arms/sleeves
			itemDef.anInt188 = -1; // male arms/sleeves
			itemDef.anInt175 = 65;
			itemDef.stackable = false;
			itemDef.name = "Void Ranger Helm";
			itemDef.description = "A void knight ranger helmet";
		}
		if (i == 7941) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 27166; // Model Drop/inv view
			itemDef.modelZoom = 620;
			itemDef.modelRotation1 = 88;
			itemDef.modelRotation2 = 188;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 3;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = 27154; // male wearing
			itemDef.anInt200 = 27139; // female wearing
			itemDef.anInt164 = -1; // Female arms/sleeves
			itemDef.anInt188 = -1; // male arms/sleeves
			itemDef.anInt175 = 65;
			itemDef.stackable = false;
			itemDef.name = "Void Melee Helm";
			itemDef.description = "A Void knight melee helmet.";
		}

		if (i == 7938) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = -22464;
			itemDef.newModelColor[0] = 4550;
			itemDef.modelID = 7214;
			itemDef.modelZoom = 2022;
			itemDef.modelRotation1 = 408;
			itemDef.anInt204 = 1979;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			itemDef.anInt165 = 7221;
			itemDef.anInt200 = 7223;
			itemDef.anInt166 = 63;
			itemDef.anInt173 = 120;
			itemDef.name = "Void Knight Bottom";
			itemDef.description = "It's a Void Knight Bottom";
		}
		if (i == 837) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 10083;// 16876
			itemDef.modelZoom = 926;
			itemDef.modelRotation1 = 432;
			itemDef.modelRotation2 = 258;
			itemDef.anInt204 = 83;
			itemDef.modelOffset1 = 3;
			itemDef.modelOffset2 = 3;
			itemDef.anInt165 = 10082;// 16846
			itemDef.anInt200 = 10082;// 16846
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Rune c'bow";
			itemDef.description = "It's powerfull for rune.";
			itemDef.editedModelColor = new int[1];// Start of old colors
			itemDef.editedModelColor[0] = 5656;
			itemDef.newModelColor = new int[1];// Start of new colors
			itemDef.newModelColor[0] = 36133;
		}
		if (i == 4153) {
			itemDef.modelZoom = 2000; // Zoom
		}
		if (i == 6570) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 0;
			itemDef.newModelColor[0] = 0;
			itemDef.modelID = 9631;// item look
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 400;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 2047;
			itemDef.modelOffset1 = -8;
			itemDef.modelOffset2 = 12;
			itemDef.anInt197 = -1;
			itemDef.name = "Fire Cape";
			itemDef.description = "A cape of fire.";
		}

		if (i == 7905) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 26667;
			itemDef.modelZoom = 1670;
			itemDef.modelRotation1 = 336;
			itemDef.modelRotation2 = 64;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 3;
			itemDef.modelOffset2 = 37;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.anInt165 = 26666;
			itemDef.anInt200 = 26666;
			itemDef.name = "Dragon fire shield";
			itemDef.description = "A heavy shield with a snarling, draconic visage.";

		}
		if (i == 7894) {
			itemDef.actions = new String[5];
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 0;
			itemDef.newModelColor[0] = 57280;
			itemDef.modelID = 28154;// // inv/drop -- 19057
			itemDef.anInt165 = 27726;
			itemDef.anInt200 = 27726;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 484;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Bandos GodSword";
			itemDef.description = "A powerful sword Bandos once used.";

		}

		if (i == 7893) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[0];
			itemDef.newModelColor = new int[0];
			itemDef.modelID = 28162;
			itemDef.modelZoom = 1957;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 484;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.anInt165 = 27731;
			itemDef.anInt200 = 27731;
			itemDef.stackable = false;
			itemDef.name = "Armadyl Godsword";
			itemDef.description = "A beautiful, heavy sword.";
		}
		if (i == 7897) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[0];
			itemDef.newModelColor = new int[0];
			itemDef.modelID = 28151;
			itemDef.modelZoom = 1957;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 484;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.anInt165 = 27729;
			itemDef.anInt200 = 27729;
			itemDef.stackable = false;
			itemDef.name = "Saradomin Godsword";
			itemDef.description = "A gracious, heavy sword.";
		}
		if (i == 7895) {
			itemDef.actions = new String[5];
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 0;
			itemDef.newModelColor[0] = 57280;
			itemDef.modelID = 28167;// // inv/drop -- 19057
			itemDef.anInt165 = 27724;
			itemDef.anInt200 = 27724;
			itemDef.modelZoom = 2000;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 484;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			// itemdef.anint199 = 7896;//noteable
			itemDef.name = "Zamorak GodSword";
			itemDef.description = "A powerful sword Zamorak once used.";

		}
		if (i == 430) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 4673;
			itemDef.modelZoom = 1200;
			itemDef.modelRotation1 = 510;
			itemDef.modelRotation2 = 1840;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 5;
			itemDef.anInt165 = 4674;
			itemDef.anInt200 = 4675;
			itemDef.anInt164 = 337;
			itemDef.anInt188 = 156;
			itemDef.stackable = false;
			itemDef.name = "Fighter Torso";
			itemDef.description = "A Penance Fighter torso armour.";
		}
		if (i == 4827) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 26386;
			itemDef.modelZoom = 2128;
			itemDef.modelRotation1 = 591;
			itemDef.modelRotation2 = 1034;
			itemDef.anInt204 = 138;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 8;
			itemDef.modelOffset2 = 11;
			itemDef.anInt165 = 26279;
			itemDef.anInt200 = 26279;
			itemDef.anInt175 = -1;
			itemDef.stackable = false;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Dark bow";
			itemDef.description = "A bow from a darker dimension.";

		}
		if (i == 7964) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 4678;
			itemDef.modelZoom = 595;
			itemDef.modelRotation1 = 0;
			itemDef.modelRotation2 = 0;
			itemDef.anInt204 = 0;
			// itemdef.anint199 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 4679;
			itemDef.anInt200 = 4680;
			itemDef.anInt175 = 56;
			itemDef.anInt197 = 116;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Dragon Boots";
			itemDef.description = "These will protect my feet.";
		}
		if (i == 7909) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 28133;
			itemDef.modelZoom = 984;
			itemDef.modelRotation1 = 500;
			itemDef.anInt204 = 0;
			itemDef.modelRotation2 = 2039;
			// itemdef.anint199 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 27732;
			itemDef.anInt200 = 27753;
			itemDef.anInt164 = 27759;
			itemDef.anInt188 = 27748;
			itemDef.anInt175 = -1;
			itemDef.stackable = false;
			itemDef.name = "Bandos Chestplate";
			itemDef.description = "A sturdy chest plate.";
		}
		if (i == 7910) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 28131;
			itemDef.modelZoom = 854;
			itemDef.modelRotation1 = 540;
			itemDef.modelRotation2 = 2039;
			itemDef.anInt204 = 144;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 9;
			itemDef.modelOffset2 = 5;
			itemDef.anInt165 = 27739;
			itemDef.anInt200 = 27755;
			itemDef.anInt175 = -1;
			itemDef.stackable = false;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Bandos tassets";
			itemDef.description = "A sturdy pair of tassets.";
		}
		if (i == 7841) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 21938; // Model Drop/inv view
			itemDef.modelZoom = 984;
			itemDef.modelRotation1 = 126;
			itemDef.modelRotation2 = 129;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.anInt197 = -1;
			itemDef.anInt204 = 28;
			itemDef.anInt165 = 21873; // male wearing
			itemDef.anInt200 = 21906; // female wearing
			itemDef.anInt164 = -1; // Female arms/sleeves
			itemDef.anInt188 = -1; // male arms/sleeves
			itemDef.anInt175 = -1;
			itemDef.stackable = false;
			itemDef.name = "Helm of neitiznot";
			itemDef.description = "A gift from Neitiznot's Burgher.";
		}
		if (i == 7611) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 26662;
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 135;
			itemDef.modelRotation2 = 123;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt204 = 24;
			itemDef.anInt165 = 26632;
			itemDef.anInt200 = 26658;
			itemDef.anInt175 = -1;
			itemDef.stackable = false;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "Dragon Full Helm";
			itemDef.description = "Looks impressive and protects your head too.";
		}
		if (i == 7913) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7169;
			itemDef.modelZoom = 1200;
			itemDef.modelRotation1 = 572;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 7148;
			itemDef.anInt200 = 7163;
			itemDef.anInt164 = 7152;
			itemDef.anInt188 = 7138;
			itemDef.stackable = false;
			itemDef.name = "3rd age platebody";
			itemDef.description = "Fabulous rare armour beaten from magical silver.";
		}
		if (i == 7915) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7167;
			itemDef.modelZoom = 1740;
			itemDef.modelRotation1 = 572;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 4;
			itemDef.modelOffset2 = 11;
			itemDef.anInt165 = 7145;
			itemDef.anInt200 = 7159;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "3rd age platelegs";
			itemDef.description = "Fabulous rare armour beaten from magical silver.";
		}
		if (i == 7918) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7166;
			itemDef.modelZoom = 720;
			itemDef.modelRotation1 = 28;
			itemDef.modelRotation2 = 1892;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 7142;
			itemDef.anInt200 = 7156;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "3rd age full helm";
			itemDef.description = "Fabulous rare armour beaten from magical silver.";
		}
		if (i == 7926) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7168;
			itemDef.modelZoom = 2030;
			itemDef.modelRotation1 = 364;
			itemDef.modelRotation2 = 56;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 7151;
			itemDef.anInt200 = 7151;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "3rd age kiteshield";
			itemDef.description = "Fabulous ancient armour beaten from magical silver.";
		}
		if (i == 7912) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7172;
			itemDef.modelZoom = 2083;
			itemDef.modelRotation1 = 572;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 7149;
			itemDef.anInt200 = 7164;
			itemDef.anInt164 = 7153;
			itemDef.anInt188 = 7139;
			itemDef.stackable = false;
			itemDef.name = "3rd age robe top";
			itemDef.description = "Fabulously rare mage protection enchanted in the 3rd age.";
		}
		if (i == 7927) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7171;
			itemDef.modelZoom = 2083;
			itemDef.modelRotation1 = 572;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 7146;
			itemDef.anInt200 = 7160;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "3rd age robe";
			itemDef.description = "Fabulously rare mage protection enchanted in the 3rd age.";
		}
		if (i == 7917) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7170;
			itemDef.modelZoom = 917;
			itemDef.modelRotation1 = 212;
			itemDef.modelRotation2 = 1883;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 7143;
			itemDef.anInt200 = 7157;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "3rd age mage hat";
			itemDef.description = "Fabulously rare mage protection enchanted in the 3rd age.";
		}
		if (i == 7911) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7175;
			itemDef.modelZoom = 1200;
			itemDef.modelRotation1 = 572;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 7150;
			itemDef.anInt200 = 7165;
			itemDef.anInt164 = 7154;
			itemDef.anInt188 = 7140;
			itemDef.stackable = false;
			itemDef.name = "3rd age range top";
			itemDef.description = "Fabulously ancient range protection crafted from white dragonhide.";
		}
		if (i == 7914) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7174;
			itemDef.modelZoom = 1827;
			itemDef.modelRotation1 = 572;
			itemDef.modelRotation2 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.anInt165 = 7147;
			itemDef.anInt200 = 7161;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "3rd age range legs";
			itemDef.description = "Fabulously ancient range protection crafted from white dragonhide.";
		}
		if (i == 7960) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[2];
			itemDef.newModelColor = new int[2];
			itemDef.editedModelColor[0] = 10004;
			itemDef.editedModelColor[1] = 5532;
			itemDef.newModelColor[0] = 0;
			itemDef.newModelColor[1] = 0;
			itemDef.modelID = 2649; // Model ID
			itemDef.anInt165 = 179; // Male Wield
			itemDef.anInt200 = 14572; // Female Wield
			itemDef.modelRotation1 = 420;
			itemDef.modelRotation2 = 828;
			itemDef.modelOffset1 = 5;
			itemDef.modelOffset2 = -8;
			itemDef.modelZoom = 930;
			itemDef.anInt204 = 138;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.name = "Void Knight gloves";
			itemDef.description = "Gloves as used by the order of the void knights.";
		}

		if (i == 7922) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = -22464;
			itemDef.newModelColor[0] = 4550;
			itemDef.modelID = 10050;
			itemDef.modelZoom = 919;
			itemDef.modelRotation1 = 459;
			itemDef.anInt204 = 138;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			itemDef.anInt165 = 10053;
			itemDef.anInt188 = 10051;
			itemDef.anInt200 = 10052;
			itemDef.anInt164 = 10054;
			itemDef.anInt166 = 63;
			itemDef.anInt173 = 120;
			itemDef.name = "Void Knight Top";
			itemDef.description = "It's a Void Knight Top";

		}

		if (i == 7921) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 27164; // Model Drop/inv view
			itemDef.modelZoom = 919;
			itemDef.modelRotation1 = 429;
			itemDef.modelRotation2 = 1660;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 5;
			itemDef.anInt197 = 120;
			itemDef.anInt165 = 27151; // male wearing
			itemDef.anInt200 = 27137; // female wearing
			itemDef.anInt164 = -1; // Female arms/sleeves
			itemDef.anInt188 = -1; // male arms/sleeves
			itemDef.anInt175 = 65;
			itemDef.stackable = false;
			itemDef.name = "Void Mage Helm";
			itemDef.description = "A void knight magic helmet.";
		}
		if (i == 7939) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 27163; // Model Drop/inv view
			itemDef.modelZoom = 620;
			itemDef.modelRotation1 = 88;
			itemDef.modelRotation2 = 188;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = 27150; // male wearing
			itemDef.anInt200 = 27138; // female wearing
			itemDef.anInt164 = -1; // Female arms/sleeves
			itemDef.anInt188 = -1; // male arms/sleeves
			itemDef.anInt175 = 65;
			itemDef.stackable = false;
			itemDef.name = "Void Ranger Helm";
			itemDef.description = "A void knight ranger helmet";
		}
		if (i == 7941) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.modelID = 27166; // Model Drop/inv view
			itemDef.modelZoom = 620;
			itemDef.modelRotation1 = 88;
			itemDef.modelRotation2 = 188;
			// itemdef.anint199 = -1;
			itemDef.modelOffset1 = 3;
			itemDef.modelOffset2 = -1;
			itemDef.anInt165 = 27154; // male wearing
			itemDef.anInt200 = 27139; // female wearing
			itemDef.anInt164 = -1; // Female arms/sleeves
			itemDef.anInt188 = -1; // male arms/sleeves
			itemDef.anInt175 = 65;
			itemDef.stackable = false;
			itemDef.name = "Void Melee Helm";
			itemDef.description = "A Void knight melee helmet.";
		}

		if (i == 7938) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = -22464;
			itemDef.newModelColor[0] = 4550;
			itemDef.modelID = 10055;
			itemDef.modelZoom = 2022;
			itemDef.modelRotation1 = 408;
			itemDef.anInt204 = 1979;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			itemDef.anInt165 = 10057;
			itemDef.anInt200 = 10056;
			itemDef.anInt166 = 63;
			itemDef.anInt173 = 120;
			itemDef.name = "Void Knight Bottom";
			itemDef.description = "It's a Void Knight Bottom";
		}
		if (i == 7916) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7173;
			itemDef.modelZoom = 917;
			itemDef.modelRotation1 = 212;
			itemDef.modelRotation2 = 1883;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;
			itemDef.anInt165 = 7144;
			itemDef.anInt200 = 7158;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "3rd age range coif";
			itemDef.description = "Fabulously ancient range protection crafted from white dragonhide.";
		}
		if (i == 7928) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.modelID = 7176;
			itemDef.modelZoom = 740;
			itemDef.modelRotation1 = 196;
			itemDef.modelRotation2 = 1784;
			itemDef.modelOffset1 = 7;
			itemDef.modelOffset2 = -33;
			itemDef.anInt165 = 7141;
			itemDef.anInt200 = 7155;
			itemDef.anInt164 = -1;
			itemDef.anInt188 = -1;
			itemDef.stackable = false;
			itemDef.name = "3rd age vambraces";
			itemDef.description = "Fabulously ancient range protection crafted from white dragonhide.";
		}
		if (i == 7936) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wield";
			itemDef.editedModelColor = new int[3];
			itemDef.newModelColor = new int[3];
			itemDef.editedModelColor[0] = 5559;
			itemDef.newModelColor[0] = -12871;
			itemDef.editedModelColor[1] = 5665;
			itemDef.newModelColor[1] = -15808;
			itemDef.editedModelColor[2] = 5784;
			itemDef.newModelColor[2] = -15689;
			itemDef.modelID = 13047;
			itemDef.modelZoom = 543;
			itemDef.modelRotation1 = 282;
			itemDef.modelRotation2 = 73;
			itemDef.modelOffset1 = 4;
			itemDef.anInt175 = -1;
			itemDef.modelOffset2 = 100;
			itemDef.anInt197 = -1;
			itemDef.anInt204 = 69;
			itemDef.anInt165 = 13048;
			itemDef.anInt200 = 13049;
			itemDef.anInt188 = -1;
			itemDef.anInt164 = -1;
			itemDef.stackable = false;
			itemDef.name = "3rd age amulet";
			itemDef.description = "Fabulously ancient magic protection enchanted in the 3rd age. ";

		}
		if (i == 13654) {
			itemDef.actions = new String[5];
			itemDef.actions[1] = "Wear";
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 0;
			itemDef.newModelColor[0] = 0;
			itemDef.modelID = 10345;
			itemDef.modelZoom = 1178;
			itemDef.modelRotation1 = 498;
			itemDef.modelRotation2 = 1840;
			itemDef.anInt204 = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;
			itemDef.anInt165 = 10344;
			itemDef.anInt200 = 14561;
			itemDef.anInt175 = -1;
			itemDef.anInt197 = -1;
			itemDef.stackable = false;
			itemDef.name = "Slayer Helm";
			itemDef.description = "Its A Slayer Helm!";

		}
		if (itemDef.editedModelColor != null) {
			for (int i2 = 0; i2 < itemDef.editedModelColor.length; i2++) {
				if (itemDef.newModelColor[i2] == 0) {
					itemDef.newModelColor[i2] = 1;
				}
			}
		}
		if (itemDef.id == i && itemDef.editedModelColor == null) {
			itemDef.editedModelColor = new int[1];
			itemDef.newModelColor = new int[1];
			itemDef.editedModelColor[0] = 0;
			itemDef.newModelColor[0] = 1;
		}
		switch (i) {
		case 4708:
			itemDef.modelID = 5419;
			itemDef.name = "Ahrim's hood";
			itemDef.modelZoom = 730;
			itemDef.modelRotation2 = 2036;
			itemDef.value = 13000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 5430;
			itemDef.anInt200 = 5435;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 8741 };
			itemDef.newModelColor = new int[] { 10512 };
			itemDef.anInt175 = 5428;
			itemDef.anInt197 = 5429;
			break;

		case 4709:
			itemDef.modelID = 2429;
			itemDef.name = "Ahrim's hood";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 13000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4708;
			itemDef.certTemplateID = 799;
			break;

		case 4710:
			itemDef.modelID = 6590;
			itemDef.name = "Ahrim's staff";
			itemDef.modelZoom = 1550;
			itemDef.modelRotation1 = 224;
			itemDef.modelRotation2 = 116;
			itemDef.modelOffset1 = -4;
			itemDef.modelOffset2 = -19;
			itemDef.value = 85000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6706;
			itemDef.anInt200 = 6706;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 14503, 14499, 14494, 14490 };
			itemDef.newModelColor = new int[] { 10512, 10508, 10760, 11140 };
			break;

		case 4711:
			itemDef.modelID = 2429;
			itemDef.name = "Ahrim's staff";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 85000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4710;
			itemDef.certTemplateID = 799;
			break;

		case 4712:
			itemDef.modelID = 6578;
			itemDef.name = "Ahrim's robetop";
			itemDef.modelZoom = 1250;
			itemDef.modelRotation1 = 468;
			itemDef.modelOffset2 = 3;
			itemDef.value = 50000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6669;
			itemDef.anInt188 = 170;
			itemDef.anInt200 = 6697;
			itemDef.anInt164 = 348;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 8741, 14490 };
			itemDef.newModelColor = new int[] { 10512, 10512 };
			break;

		case 4713:
			itemDef.modelID = 2429;
			itemDef.name = "Ahrim's robetop";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 50000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4712;
			itemDef.certTemplateID = 799;
			break;

		case 4714:
			itemDef.modelID = 6577;
			itemDef.name = "Ahrim's robeskirt";
			itemDef.modelZoom = 1730;
			itemDef.modelRotation1 = 504;
			itemDef.modelOffset2 = -4;
			itemDef.value = 47000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6659;
			itemDef.anInt200 = 6691;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 14490, 45468 };
			itemDef.newModelColor = new int[] { 10512, 43840 };
			break;

		case 4715:
			itemDef.modelID = 2429;
			itemDef.name = "Ahrim's robeskirt";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 47000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4714;
			itemDef.certTemplateID = 799;
			break;

		case 4716:
			itemDef.modelID = 6580;
			itemDef.name = "Dharok's helm";
			itemDef.modelZoom = 660;
			itemDef.modelRotation1 = 96;
			itemDef.modelRotation2 = 128;
			itemDef.modelOffset1 = 5;
			itemDef.modelOffset2 = -8;
			itemDef.value = 103000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6651;
			itemDef.anInt200 = 6686;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 10388 };
			itemDef.newModelColor = new int[] { 10388, 10508 };
			itemDef.anInt175 = 6569;
			itemDef.anInt197 = 6574;
			break;

		case 4717:
			itemDef.modelID = 2429;
			itemDef.name = "Dharok's helm";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 103000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4716;
			itemDef.certTemplateID = 799;
			break;

		case 4718:
			itemDef.modelID = 6579;
			itemDef.name = "Dharok's greataxe";
			itemDef.modelZoom = 1710;
			itemDef.modelRotation1 = 280;
			itemDef.modelRotation2 = 2004;
			itemDef.modelOffset2 = 51;
			itemDef.value = 208000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6702;
			itemDef.anInt200 = 6702;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
			break;

		case 4719:
			itemDef.modelID = 2429;
			itemDef.name = "Dharok's greataxe";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 208000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4718;
			itemDef.certTemplateID = 799;
			break;

		case 4720:
			itemDef.modelID = 6582;
			itemDef.name = "Dharok's platebody";
			itemDef.modelZoom = 1260;
			itemDef.modelRotation1 = 464;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 4;
			itemDef.value = 280000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6670;
			itemDef.anInt188 = 6639;
			itemDef.anInt200 = 6698;
			itemDef.anInt164 = 6681;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 10291 };
			itemDef.newModelColor = new int[] { 10388, 10508 };
			break;

		case 4721:
			itemDef.modelID = 2429;
			itemDef.name = "Dharok's platebody";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 280000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4720;
			itemDef.certTemplateID = 799;
			break;

		case 4722:
			itemDef.modelID = 6581;
			itemDef.name = "Dharok's platelegs";
			itemDef.modelZoom = 1660;
			itemDef.modelRotation1 = 456;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.value = 275000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6660;
			itemDef.anInt200 = 6692;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 10388 };
			itemDef.newModelColor = new int[] { 10512, 10760 };
			break;

		case 4723:
			itemDef.modelID = 2429;
			itemDef.name = "Dharok's platelegs";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 275000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4722;
			itemDef.certTemplateID = 799;
			break;

		case 4724:
			itemDef.modelID = 6583;
			itemDef.name = "Guthan's helm";
			itemDef.modelZoom = 860;
			itemDef.modelRotation1 = 2012;
			itemDef.modelRotation2 = 188;
			itemDef.modelOffset1 = 17;
			itemDef.value = 103000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6653;
			itemDef.anInt200 = 6687;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 6020 };
			itemDef.newModelColor = new int[] { 10388, 11140 };
			itemDef.anInt175 = 6570;
			itemDef.anInt197 = 6575;
			break;

		case 4725:
			itemDef.modelID = 2429;
			itemDef.name = "Guthan's helm";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 103000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4724;
			itemDef.certTemplateID = 799;
			break;

		case 4726:
			itemDef.modelID = 6598;
			itemDef.name = "Guthan's warspear";
			itemDef.modelZoom = 1470;
			itemDef.modelRotation1 = 176;
			itemDef.modelRotation2 = 116;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = -16;
			itemDef.value = 100000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6709;
			itemDef.anInt200 = 6709;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 14511, 14503, 14494, 21555,
					21563 };
			itemDef.newModelColor = new int[] { 10512, 10508, 10760, 21543,
					21551 };
			break;

		case 4727:
			itemDef.modelID = 2429;
			itemDef.name = "Guthan's warspear";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 100000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4726;
			itemDef.certTemplateID = 799;
			break;

		case 4728:
			itemDef.modelID = 6586;
			itemDef.name = "Guthan's platebody";
			itemDef.modelZoom = 960;
			itemDef.modelRotation1 = 412;
			itemDef.modelOffset2 = 8;
			itemDef.value = 280000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6672;
			itemDef.anInt188 = 6641;
			itemDef.anInt200 = 6699;
			itemDef.anInt164 = 6682;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 10291 };
			itemDef.newModelColor = new int[] { 10388, 10508 };
			break;

		case 4729:
			itemDef.modelID = 2429;
			itemDef.name = "Guthan's platebody";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 280000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4728;
			itemDef.certTemplateID = 799;
			break;

		case 4730:
			itemDef.modelID = 6593;
			itemDef.name = "Guthan's chainskirt";
			itemDef.modelZoom = 1720;
			itemDef.modelRotation1 = 468;
			itemDef.modelOffset2 = 1;
			itemDef.value = 275000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6665;
			itemDef.anInt200 = 6695;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10407, 10394, 10388 };
			itemDef.newModelColor = new int[] { 10512, 10508, 10760 };
			break;

		case 4731:
			itemDef.modelID = 2429;
			itemDef.name = "Guthan's chainskirt";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 275000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4730;
			itemDef.certTemplateID = 799;
			break;

		case 4732:
			itemDef.modelID = 6587;
			itemDef.name = "Karil's coif";
			itemDef.modelZoom = 690;
			itemDef.modelRotation1 = 144;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -3;
			itemDef.value = 13000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6655;
			itemDef.anInt200 = 6688;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 10388, 10514, 10638,
					10762 };
			itemDef.newModelColor = new int[] { 10388, 10512, 10508, 10760,
					11140 };
			itemDef.anInt175 = 6571;
			itemDef.anInt197 = 6571;
			itemDef.anInt166 = 63;
			itemDef.anInt173 = 120;
			break;

		case 4733:
			itemDef.modelID = 2429;
			itemDef.name = "Karil's coif";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 13000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4732;
			itemDef.certTemplateID = 799;
			break;

		case 4734:
			itemDef.modelID = 6604;
			itemDef.name = "Karil's crossbow";
			itemDef.modelZoom = 1160;
			itemDef.modelRotation1 = 288;
			itemDef.modelRotation2 = 888;
			itemDef.modelOffset1 = -4;
			itemDef.modelOffset2 = 39;
			itemDef.value = 160000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6712;
			itemDef.anInt200 = 6712;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10529, 8602, 10520, 8722 };
			itemDef.newModelColor = new int[] { 10388, 10512, 10508, 10760 };
			break;

		case 4735:
			itemDef.modelID = 2429;
			itemDef.name = "Karil's crossbow";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 160000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4734;
			itemDef.certTemplateID = 799;
			break;

		case 4736:
			itemDef.modelID = 6588;
			itemDef.name = "Karil's leathertop";
			itemDef.modelZoom = 1380;
			itemDef.modelRotation1 = 556;
			itemDef.modelOffset1 = 3;
			itemDef.value = 50000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6674;
			itemDef.anInt188 = 6643;
			itemDef.anInt200 = 6700;
			itemDef.anInt164 = 6683;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10413, 10520, 10644, 10768,
					908 };
			itemDef.newModelColor = new int[] { 7510, 10388, 10512, 10508,
					10760 };
			break;

		case 4737:
			itemDef.modelID = 2429;
			itemDef.name = "Karil's leathertop";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 50000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4736;
			itemDef.certTemplateID = 799;
			break;

		case 4738:
			itemDef.modelID = 6589;
			itemDef.name = "Karil's leatherskirt";
			itemDef.modelZoom = 1120;
			itemDef.modelRotation1 = 512;
			itemDef.value = 47000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6664;
			itemDef.anInt200 = 6694;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10413, 14490, 10520, 10644,
					10768, 10892 };
			itemDef.newModelColor = new int[] { 10438, 10388, 10512, 10508,
					10760, 11140 };
			break;

		case 4739:
			itemDef.modelID = 2429;
			itemDef.name = "Karil's leatherskirt";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 47000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4738;
			itemDef.certTemplateID = 799;
			break;

		case 4740:
			itemDef.modelID = 6599;
			itemDef.name = "Bolt rack";
			itemDef.modelZoom = 870;
			itemDef.modelRotation1 = 72;
			itemDef.modelRotation2 = 1776;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.stackable = true;
			itemDef.value = 50;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10529, 8602, 10520, 8722 };
			itemDef.newModelColor = new int[] { 10388, 10512, 10508, 10760 };
			itemDef.stackIDs = new int[] { 4741, 4742, 4743, 4744, 0, 0, 0, 0,
					0, 0 };
			itemDef.stackAmounts = new int[] { 2, 3, 4, 5, 0, 0, 0, 0, 0, 0 };
			break;

		case 4741:
			itemDef.modelID = 6600;
			itemDef.name = "null";
			itemDef.modelZoom = 870;
			itemDef.modelRotation1 = 72;
			itemDef.modelRotation2 = 1776;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.stackable = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10529, 8602, 10520, 8722 };
			itemDef.newModelColor = new int[] { 10388, 10512, 10508, 10760 };
			break;

		case 4742:
			itemDef.modelID = 6601;
			itemDef.name = "null";
			itemDef.modelZoom = 870;
			itemDef.modelRotation1 = 72;
			itemDef.modelRotation2 = 1776;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.stackable = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10529, 8602, 10520, 8722 };
			itemDef.newModelColor = new int[] { 10388, 10512, 10508, 10760 };
			break;

		case 4743:
			itemDef.modelID = 6602;
			itemDef.name = "null";
			itemDef.modelZoom = 870;
			itemDef.modelRotation1 = 72;
			itemDef.modelRotation2 = 1776;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.stackable = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10529, 8602, 10520, 8722 };
			itemDef.newModelColor = new int[] { 10388, 10512, 10508, 10760 };
			break;

		case 4744:
			itemDef.modelID = 6603;
			itemDef.name = "null";
			itemDef.modelZoom = 870;
			itemDef.modelRotation1 = 72;
			itemDef.modelRotation2 = 1776;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 1;
			itemDef.stackable = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10529, 8602, 10520, 8722 };
			itemDef.newModelColor = new int[] { 10388, 10512, 10508, 10760 };
			break;

		case 4745:
			itemDef.modelID = 6592;
			itemDef.name = "Torag's helm";
			itemDef.modelZoom = 660;
			itemDef.modelRotation2 = 212;
			itemDef.modelOffset1 = 11;
			itemDef.value = 103000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6656;
			itemDef.anInt200 = 6689;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 6020 };
			itemDef.newModelColor = new int[] { 10388, 11140 };
			itemDef.anInt175 = 6572;
			itemDef.anInt197 = 6576;
			break;

		case 4746:
			itemDef.modelID = 2429;
			itemDef.name = "Torag's helm";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 103000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4745;
			itemDef.certTemplateID = 799;
			break;

		case 4747:
			itemDef.modelID = 6591;
			itemDef.name = "Torag's hammers";
			itemDef.modelZoom = 1620;
			itemDef.modelRotation1 = 272;
			itemDef.modelRotation2 = 1212;
			itemDef.modelOffset1 = -16;
			itemDef.modelOffset2 = -9;
			itemDef.value = 160000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6707;
			itemDef.anInt200 = 6707;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
			break;

		case 4748:
			itemDef.modelID = 2429;
			itemDef.name = "Torag's hammers";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 160000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4747;
			itemDef.certTemplateID = 799;
			break;

		case 4749:
			itemDef.modelID = 6594;
			itemDef.name = "Torag's platebody";
			itemDef.modelZoom = 1310;
			itemDef.modelRotation1 = 432;
			itemDef.modelOffset1 = 2;
			itemDef.value = 280000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6676;
			itemDef.anInt188 = 6644;
			itemDef.anInt200 = 6701;
			itemDef.anInt164 = 6684;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 10291 };
			itemDef.newModelColor = new int[] { 10388, 10508 };
			break;

		case 4750:
			itemDef.modelID = 2429;
			itemDef.name = "Torag's platebody";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 280000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4749;
			itemDef.certTemplateID = 799;
			break;

		case 4751:
			itemDef.modelID = 6584;
			itemDef.name = "Torag's platelegs";
			itemDef.modelZoom = 1720;
			itemDef.modelRotation1 = 468;
			itemDef.modelOffset2 = 1;
			itemDef.value = 275000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6662;
			itemDef.anInt200 = 6693;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394 };
			itemDef.newModelColor = new int[] { 10388 };
			break;

		case 4752:
			itemDef.modelID = 2429;
			itemDef.name = "Torag's platelegs";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 275000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4751;
			itemDef.certTemplateID = 799;
			break;

		case 4753:
			itemDef.modelID = 6597;
			itemDef.name = "Verac's helm";
			itemDef.modelZoom = 810;
			itemDef.modelRotation1 = 28;
			itemDef.modelRotation2 = 208;
			itemDef.modelOffset1 = 5;
			itemDef.modelOffset2 = 1;
			itemDef.value = 103000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6658;
			itemDef.anInt200 = 6690;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10411, 10403, 10394, 10518,
					10514, 10638 };
			itemDef.newModelColor = new int[] { 10388, 10512, 10508, 10760,
					11140, 11138 };
			itemDef.anInt175 = 6573;
			itemDef.anInt197 = 6573;
			break;

		case 4754:
			itemDef.modelID = 2429;
			itemDef.name = "Verac's helm";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 103000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4753;
			itemDef.certTemplateID = 799;
			break;

		case 4755:
			itemDef.modelID = 6585;
			itemDef.name = "Verac's flail";
			itemDef.modelZoom = 1440;
			itemDef.modelRotation1 = 272;
			itemDef.modelRotation2 = 352;
			itemDef.modelOffset2 = 32;
			itemDef.value = 160000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6704;
			itemDef.anInt200 = 6704;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wield", null, null, "Drop" };
			break;

		case 4756:
			itemDef.modelID = 2429;
			itemDef.name = "Verac's flail";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 160000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4755;
			itemDef.certTemplateID = 799;
			break;

		case 4757:
			itemDef.modelID = 6596;
			itemDef.name = "Verac's brassard";
			itemDef.modelZoom = 1210;
			itemDef.modelRotation1 = 464;
			itemDef.modelRotation2 = 36;
			itemDef.modelOffset1 = 3;
			itemDef.modelOffset2 = 1;
			itemDef.value = 280000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 315;
			itemDef.anInt188 = 6646;
			itemDef.anInt200 = 478;
			itemDef.anInt164 = 6685;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 10518, 10388, 10514,
					10508 };
			itemDef.newModelColor = new int[] { 10388, 10512, 10508, 10760,
					11140 };
			break;

		case 4758:
			itemDef.modelID = 2429;
			itemDef.name = "Verac's brassard";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 280000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4757;
			itemDef.certTemplateID = 799;
			break;

		case 4759:
			itemDef.modelID = 6595;
			itemDef.name = "Verac's plateskirt";
			itemDef.modelZoom = 1060;
			itemDef.modelRotation1 = 504;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -1;
			itemDef.value = 275000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 6667;
			itemDef.anInt200 = 6696;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10398, 10518, 10638 };
			itemDef.newModelColor = new int[] { 10388, 10512, 10508 };
			break;

		case 4760:
			itemDef.modelID = 2429;
			itemDef.name = "Verac's plateskirt";
			itemDef.modelZoom = 760;
			itemDef.modelRotation1 = 552;
			itemDef.modelRotation2 = 28;
			itemDef.modelOffset2 = 2;
			itemDef.stackable = true;
			itemDef.value = 275000;
			itemDef.membersObject = true;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, null, null, null, "Drop" };
			itemDef.certID = 4759;
			itemDef.certTemplateID = 799;
			break;
		case 7454:
			itemDef.modelID = 13631;
			itemDef.name = "Bronze gloves";
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 609;
			itemDef.modelRotation2 = 111;
			itemDef.modelOffset2 = -1;
			itemDef.value = 100;
			itemDef.membersObject = true;
			itemDef.anInt165 = 13307;
			itemDef.anInt200 = 13319;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 8656 };
			itemDef.newModelColor = new int[] { 5652, 7050 };
			break;

		case 7455:
			itemDef.modelID = 13631;
			itemDef.name = "Iron gloves";
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 609;
			itemDef.modelRotation2 = 111;
			itemDef.modelOffset2 = -1;
			itemDef.value = 250;
			itemDef.membersObject = true;
			itemDef.anInt165 = 13307;
			itemDef.anInt200 = 13319;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 8656 };
			itemDef.newModelColor = new int[] { 33, 24 };
			break;

		case 7456:
			itemDef.modelID = 13631;
			itemDef.name = "Steel gloves";
			itemDef.modelZoom = 789;
			itemDef.modelRotation1 = 609;
			itemDef.modelRotation2 = 111;
			itemDef.modelOffset2 = -1;
			itemDef.value = 500;
			itemDef.membersObject = true;
			itemDef.anInt165 = 13307;
			itemDef.anInt200 = 13319;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.actions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.editedModelColor = new int[] { 10394, 8656 };
			itemDef.newModelColor = new int[] { 61, 24 };
			break;
		case 4069:
			itemDef.modelID = 57631;
			itemDef.name = "Basic decorative platebody";
			itemDef.modelZoom = 1378;
			itemDef.modelRotation1 = 527;
			itemDef.modelOffset2 = -1;
			itemDef.value = 2000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 70000;
			itemDef.anInt188 = 38216;
			itemDef.groundActions = new String[] {null, null, "Take", null, null};
			itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
			break;
		case 4070:
			itemDef.modelID = 57630;
			itemDef.name = "Basic decorative platelegs";
			itemDef.modelZoom = 1740;
			itemDef.modelRotation1 = 516;
			itemDef.value = 1000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 70001;
			itemDef.anInt188 = 38179;
			itemDef.groundActions = new String[] {null, null, "Take", null, null};
			itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
			break;

		case 4071:
			itemDef.modelID = 57644;
			itemDef.name = "Basic decorative helm";
			itemDef.modelZoom = 640;
			itemDef.modelRotation1 = 108;
			itemDef.modelRotation2 = 156;
			itemDef.modelOffset2 = -1;
			itemDef.value = 300;
			itemDef.membersObject = true;
			itemDef.anInt165 = 70002;
			itemDef.anInt188 = 28936;
			itemDef.groundActions = new String[] {null, null, "Take", null, null};
			itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
			break;
		

		case 4509:
			itemDef.modelID = 57645;
			itemDef.name = "Intricate decorative platebody";
			itemDef.modelZoom = 1506;
			itemDef.modelRotation1 = 536;
			itemDef.modelRotation2 = 2045;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -2;
			itemDef.value = 200000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 70003;
			itemDef.anInt188 = 38211;
			itemDef.groundActions = new String[] {null, null, "Take", null, null};
			itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
			break;

		case 4510:
			itemDef.modelID = 57648;
			itemDef.name = "Intricate decorative platelegs";
			itemDef.modelZoom = 1740;
			itemDef.modelRotation1 = 516;
			itemDef.value = 100000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 70004;
			itemDef.anInt188 = 38194;
			itemDef.groundActions = new String[] {null, null, "Take", null, null};
			itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
			break;

		case 4511:
			itemDef.modelID = 57637;
			itemDef.name = "Intricate decorative helm";
			itemDef.modelZoom = 768;
			itemDef.modelRotation1 = 48;
			itemDef.modelRotation2 = 135;
			itemDef.value = 30000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 70005;
			itemDef.anInt188 = 28932;
			itemDef.groundActions = new String[] {null, null, "Take", null, null};
			itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
			break;

		case 18706:
			itemDef.modelID = 57652;
			itemDef.name = "Profound decorative platebody";
			itemDef.modelZoom = 1506;
			itemDef.modelRotation1 = 536;
			itemDef.modelRotation2 = 2045;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = -2;
			itemDef.value = 204000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 70006;
			itemDef.anInt188 = 38206;
			itemDef.groundActions = new String[] {null, null, "Take", null, null};
			itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
			break;

		case 18707:
			itemDef.modelID = 57646;
			itemDef.name = "Profound decorative platelegs";
			itemDef.modelZoom = 1740;
			itemDef.modelRotation1 = 516;
			itemDef.value = 104000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 70007;
			itemDef.anInt188 = 38181;
			itemDef.groundActions = new String[] {null, null, "Take", null, null};
			itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
			break;

		case 18708:
			itemDef.modelID = 57621;
			itemDef.name = "Profound decorative helm";
			itemDef.modelZoom = 768;
			itemDef.modelRotation1 = 48;
			itemDef.modelRotation2 = 135;
			itemDef.value = 34000;
			itemDef.membersObject = true;
			itemDef.anInt165 = 70008;
			itemDef.anInt188 = 28935;
			itemDef.groundActions = new String[] {null, null, "Take", null, null};
			itemDef.actions = new String[] {null, "Wear", null, null, "Drop"};
			break;
		
		}
		/*if (itemDef.id >= 11790) {
		itemDef.modelID = (itemDef.modelID <= 29191 ? itemDef.modelID + 50000 : itemDef.modelID);
		itemDef.anInt165 = (itemDef.anInt165 <= 29191 ? itemDef.anInt165 + 50000 : itemDef.anInt165);
		itemDef.anInt188 = (itemDef.anInt188 <= 29191 ? itemDef.anInt188 + 50000 : itemDef.anInt188);
		itemDef.anInt200 = (itemDef.anInt200 <= 29191 ? itemDef.anInt200 + 50000 : itemDef.anInt200);
		itemDef.anInt164 = (itemDef.anInt164 <= 29191 ? itemDef.anInt164 + 50000 : itemDef.anInt164);
		itemDef.anInt185 = (itemDef.anInt185 <= 29191 ? itemDef.anInt185 + 50000 : itemDef.anInt185);
		itemDef.anInt162 = (itemDef.anInt162 <= 29191 ? itemDef.anInt162 + 50000 : itemDef.anInt162);
		itemDef.anInt175 = (itemDef.anInt175 <= 29191 ? itemDef.anInt175 + 50000 : itemDef.anInt175);
		itemDef.anInt197 = (itemDef.anInt197 <= 29191 ? itemDef.anInt197 + 50000 : itemDef.anInt197);
		itemDef.anInt166 = (itemDef.anInt166 <= 29191 ? itemDef.anInt166 + 50000 : itemDef.anInt166);
		itemDef.anInt173 = (itemDef.anInt173 <= 29191 ? itemDef.anInt173 + 50000 : itemDef.anInt173);
	}*/
		return itemDef;
	}

	private void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1) {
				modelID = stream.readUnsignedWord();
				if (id >= 21265 && modelID <= 29191 && modelID != -1)
					modelID = modelID + 70000;
			} else if (i == 2)
				name = stream.readString();
			else if (i == 3)
				description = stream.readString();
			else if (i == 4)
				modelZoom = stream.readUnsignedWord();
			else if (i == 5)
				modelRotation1 = stream.readUnsignedWord();
			else if (i == 6)
				modelRotation2 = stream.readUnsignedWord();
			else if (i == 7) {
				modelOffset1 = stream.readUnsignedWord();
				if (modelOffset1 > 32767)
					modelOffset1 -= 0x10000;
			} else if (i == 8) {
				modelOffset2 = stream.readUnsignedWord();
				if (modelOffset2 > 32767)
					modelOffset2 -= 0x10000;
			} else if (i == 10)
				stream.readUnsignedWord();
			else if (i == 11)
				stackable = true;
			else if (i == 12)
				value = stream.readDWord();
			else if (i == 16)
				membersObject = true;
			else if (i == 23) {
				anInt165 = stream.readUnsignedWord();
				if (id >= 21265 && anInt165 <= 29191 && anInt165 != -1)
					anInt165 = anInt165 + 70000;
				aByte205 = stream.readSignedByte();
			} else if (i == 24)
				anInt188 = stream.readUnsignedWord();
				if (id >= 21265 && anInt188 <= 29191 && anInt188 != -1)
					anInt188 = anInt188 + 70000;
			else if (i == 25) {
				anInt200 = stream.readUnsignedWord();
				if (id >= 21265 && anInt200 <= 29191 && anInt200 != -1)
					anInt200 = anInt200 + 70000;
				aByte154 = stream.readSignedByte();
			} else if (i == 26)
				anInt164 = stream.readUnsignedWord();
				if (id >= 21265 && anInt164 <= 29191 && anInt164 != -1)
					anInt164 = anInt164 + 70000;
			else if (i >= 30 && i < 35) {
				if (groundActions == null)
					groundActions = new String[5];
				groundActions[i - 30] = stream.readString();
				if (groundActions[i - 30].equalsIgnoreCase("hidden"))
					groundActions[i - 30] = null;
			} else if (i >= 35 && i < 40) {
				if (actions == null)
					actions = new String[5];
				actions[i - 35] = stream.readString();
				if (actions[i - 35].equalsIgnoreCase("null"))
					actions[i - 35] = null;
			} else if (i == 40) {
				int j = stream.readUnsignedByte();
				editedModelColor = new int[j];
				newModelColor = new int[j];
				for (int k = 0; k < j; k++) {
					editedModelColor[k] = stream.readUnsignedWord();
					newModelColor[k] = stream.readUnsignedWord();
				}
			} else if (i == 78)
				anInt185 = stream.readUnsignedWord();
				if (id >= 21265 && anInt185 <= 29191 && anInt185 != -1)
					anInt185 = anInt185 + 70000;
			else if (i == 79)
				anInt162 = stream.readUnsignedWord();
				if (id >= 21265 && anInt162 <= 29191 && anInt162 != -1)
					anInt162 = anInt162 + 70000;
			else if (i == 90)
				anInt175 = stream.readUnsignedWord();
				if (id >= 21265 && anInt175 <= 29191 && anInt175 != -1)
					anInt175 = anInt175 + 70000;
			else if (i == 91)
				anInt197 = stream.readUnsignedWord();
				if (id >= 21265 && anInt197 <= 29191 && anInt197 != -1)
					anInt197 = anInt197 + 70000;
			else if (i == 92)
				anInt166 = stream.readUnsignedWord();
				if (id >= 21265 && anInt166 <= 29191 && anInt166 != -1)
					anInt166 = anInt166 + 70000;
			else if (i == 93)
				anInt173 = stream.readUnsignedWord();
				if (id >= 21265 && anInt173 <= 29191 && anInt173 != -1)
					anInt173 = anInt173 + 70000;
			else if (i == 95)
				anInt204 = stream.readUnsignedWord();
			else if (i == 97)
				certID = stream.readUnsignedWord();
			else if (i == 98)
				certTemplateID = stream.readUnsignedWord();
			else if (i >= 100 && i < 110) {
				if (stackIDs == null) {
					stackIDs = new int[10];
					stackAmounts = new int[10];
				}
				stackIDs[i - 100] = stream.readUnsignedWord();
				stackAmounts[i - 100] = stream.readUnsignedWord();
			} else if (i == 110)
				anInt167 = stream.readUnsignedWord();
			else if (i == 111)
				anInt192 = stream.readUnsignedWord();
			else if (i == 112)
				anInt191 = stream.readUnsignedWord();
			else if (i == 113)
				anInt196 = stream.readSignedByte();
			else if (i == 114)
				anInt184 = stream.readSignedByte() * 5;
			else if (i == 115)
				team = stream.readUnsignedByte();
			else if (i == 116)
				lendID = stream.readUnsignedWord();
			else if (i == 117)
				lentItemID = stream.readUnsignedWord();
		} while (true);
	}

	public void toNote() {
		ItemDef itemDef = forID(certTemplateID);
		modelID = itemDef.modelID;
		modelZoom = itemDef.modelZoom;
		modelRotation1 = itemDef.modelRotation1;
		modelRotation2 = itemDef.modelRotation2;
		anInt204 = itemDef.anInt204;
		modelOffset1 = itemDef.modelOffset1;
		modelOffset2 = itemDef.modelOffset2;
		editedModelColor = itemDef.editedModelColor;
		newModelColor = itemDef.newModelColor;
		ItemDef itemDef_1 = forID(certID);
		name = itemDef_1.name;
		membersObject = itemDef_1.membersObject;
		value = itemDef_1.value;
		String s = "a";
		char c = itemDef_1.name.charAt(0);
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
			s = "an";
		description = ("Swap this note at any bank for " + s + " "
				+ itemDef_1.name + ".");
		stackable = true;
	}

	private void toLend() {
		ItemDef itemDef = forID(lentItemID);
		actions = new String[5];
		modelID = itemDef.modelID;
		modelOffset1 = itemDef.modelOffset1;
		modelRotation2 = itemDef.modelRotation2;
		modelOffset2 = itemDef.modelOffset2;
		modelZoom = itemDef.modelZoom;
		modelRotation1 = itemDef.modelRotation1;
		anInt204 = itemDef.anInt204;
		value = 0;
		ItemDef itemDef_1 = forID(lendID);
		anInt166 = itemDef_1.anInt166;
		editedModelColor = itemDef_1.editedModelColor;
		anInt185 = itemDef_1.anInt185;
		anInt188 = itemDef_1.anInt188;
		anInt173 = itemDef_1.anInt173;
		anInt175 = itemDef_1.anInt175;
		groundActions = itemDef_1.groundActions;
		anInt165 = itemDef_1.anInt165;
		name = itemDef_1.name;
		anInt200 = itemDef_1.anInt200;
		membersObject = itemDef_1.membersObject;
		anInt197 = itemDef_1.anInt197;
		anInt164 = itemDef_1.anInt164;
		anInt162 = itemDef_1.anInt162;
		newModelColor = itemDef_1.newModelColor;
		team = itemDef_1.team;
		if (itemDef_1.actions != null) {
			for (int i_33_ = 0; i_33_ < 4; i_33_++)
				actions[i_33_] = itemDef_1.actions[i_33_];
		}
		actions[4] = "Discard";
	}

	public static Sprite getSprite(int i, int j, int k) {
		if (k == 0) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(i);
			if (sprite != null && sprite.anInt1445 != j
					&& sprite.anInt1445 != -1) {
				sprite.unlink();
				sprite = null;
			}
			if (sprite != null)
				return sprite;
		}
		ItemDef itemDef = forID(i);
		if (itemDef.stackIDs == null)
			j = -1;
		if (j > 1) {
			int i1 = -1;
			for (int j1 = 0; j1 < 10; j1++)
				if (j >= itemDef.stackAmounts[j1]
						&& itemDef.stackAmounts[j1] != 0)
					i1 = itemDef.stackIDs[j1];
			if (i1 != -1)
				itemDef = forID(i1);
		}
		Model model = itemDef.method201(1);
		if (model == null)
			return null;
		Sprite sprite = null;
		if (itemDef.certTemplateID != -1) {
			sprite = getSprite(itemDef.certID, 10, -1);
			if (sprite == null)
				return null;
		}
		if (itemDef.lentItemID != -1) {
			sprite = getSprite(itemDef.lendID, 50, 0);
			if (sprite == null)
				return null;
		}
		Sprite sprite2 = new Sprite(32, 32);
		int k1 = Texture.textureInt1;
		int l1 = Texture.textureInt2;
		int ai[] = Texture.anIntArray1472;
		int ai1[] = DrawingArea.pixels;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.bottomX;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.bottomY;
		Texture.aBoolean1464 = false;
		DrawingArea.initDrawingArea(32, 32, sprite2.myPixels);
		DrawingArea.drawPixels(32, 0, 0, 0, 32);
		Texture.method364();
		int k3 = itemDef.modelZoom;
		if (k == -1)
			k3 = (int) ((double) k3 * 1.5D);
		if (k > 0)
			k3 = (int) ((double) k3 * 1.04D);
		int l3 = Texture.anIntArray1470[itemDef.modelRotation1] * k3 >> 16;
		int i4 = Texture.anIntArray1471[itemDef.modelRotation1] * k3 >> 16;
		model.method482(itemDef.modelRotation2, itemDef.anInt204,
				itemDef.modelRotation1, itemDef.modelOffset1, l3
						+ model.modelHeight / 2 + itemDef.modelOffset2, i4
						+ itemDef.modelOffset2);
		for (int i5 = 31; i5 >= 0; i5--) {
			for (int j4 = 31; j4 >= 0; j4--)
				if (sprite2.myPixels[i5 + j4 * 32] == 0)
					if (i5 > 0 && sprite2.myPixels[(i5 - 1) + j4 * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (j4 > 0 && sprite2.myPixels[i5 + (j4 - 1) * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (i5 < 31 && sprite2.myPixels[i5 + 1 + j4 * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
					else if (j4 < 31
							&& sprite2.myPixels[i5 + (j4 + 1) * 32] > 1)
						sprite2.myPixels[i5 + j4 * 32] = 1;
		}
		if (k > 0) {
			for (int j5 = 31; j5 >= 0; j5--) {
				for (int k4 = 31; k4 >= 0; k4--)
					if (sprite2.myPixels[j5 + k4 * 32] == 0)
						if (j5 > 0 && sprite2.myPixels[(j5 - 1) + k4 * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = k;
						else if (k4 > 0
								&& sprite2.myPixels[j5 + (k4 - 1) * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = k;
						else if (j5 < 31
								&& sprite2.myPixels[j5 + 1 + k4 * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = k;
						else if (k4 < 31
								&& sprite2.myPixels[j5 + (k4 + 1) * 32] == 1)
							sprite2.myPixels[j5 + k4 * 32] = k;
			}
		} else if (k == 0) {
			for (int k5 = 31; k5 >= 0; k5--) {
				for (int l4 = 31; l4 >= 0; l4--)
					if (sprite2.myPixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0
							&& sprite2.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0)
						sprite2.myPixels[k5 + l4 * 32] = 0x302020;
			}
		}
		if (itemDef.certTemplateID != -1) {
			int l5 = sprite.anInt1444;
			int j6 = sprite.anInt1445;
			sprite.anInt1444 = 32;
			sprite.anInt1445 = 32;
			sprite.drawSprite(0, 0);
			sprite.anInt1444 = l5;
			sprite.anInt1445 = j6;
		}
		if (itemDef.lentItemID != -1) {
			int l5 = sprite.anInt1444;
			int j6 = sprite.anInt1445;
			sprite.anInt1444 = 32;
			sprite.anInt1445 = 32;
			sprite.drawSprite(0, 0);
			sprite.anInt1444 = l5;
			sprite.anInt1445 = j6;
		}
		if (k == 0)
			mruNodes1.removeFromCache(sprite2, i);
		DrawingArea.initDrawingArea(j2, i2, ai1);
		DrawingArea.setDrawingArea(j3, k2, l2, i3);
		Texture.textureInt1 = k1;
		Texture.textureInt2 = l1;
		Texture.anIntArray1472 = ai;
		Texture.aBoolean1464 = true;
		if (itemDef.stackable)
			sprite2.anInt1444 = 33;
		else
			sprite2.anInt1444 = 32;
		sprite2.anInt1445 = j;
		return sprite2;
	}

	public Model method201(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++)
				if (i >= stackAmounts[k] && stackAmounts[k] != 0)
					j = stackIDs[k];
			if (j != -1)
				return forID(j).method201(1);
		}
		Model model = (Model) mruNodes2.insertFromCache(id);
		if (model != null)
			return model;
		model = Model.method462(modelID);
		if (model == null)
			return null;
		if (anInt167 != 128 || anInt192 != 128 || anInt191 != 128)
			model.method478(anInt167, anInt191, anInt192);
		if (editedModelColor != null) {
			for (int l = 0; l < editedModelColor.length; l++)
				model.method476(editedModelColor[l], newModelColor[l]);
		}
		model.method479(64 + anInt196, 768 + anInt184, -50, -10, -50, true);
		model.aBoolean1659 = true;
		mruNodes2.removeFromCache(model, id);
		return model;
	}

	public Model method202(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++)
				if (i >= stackAmounts[k] && stackAmounts[k] != 0)
					j = stackIDs[k];
			if (j != -1)
				return forID(j).method202(1);
		}
		Model model = Model.method462(modelID);
		if (model == null)
			return null;
		if (editedModelColor != null) {
			for (int l = 0; l < editedModelColor.length; l++)
				model.method476(editedModelColor[l], newModelColor[l]);
		}
		return model;
	}

	public ItemDef() {
		id = -1;
	}

	public byte aByte154;
	public int value;
	public int[] editedModelColor;
	public int id;
	static MRUNodes mruNodes1 = new MRUNodes(100);
	public static MRUNodes mruNodes2 = new MRUNodes(50);
	public int[] newModelColor;
	public boolean membersObject;
	public int anInt162;
	public int certTemplateID;
	public int anInt164;
	public int anInt165;
	public int anInt166;
	public int anInt167;
	public String groundActions[];
	public int modelOffset1;
	public String name;
	public static ItemDef[] cache;
	public int anInt173;
	public int modelID;
	public int anInt175;
	public boolean stackable;
	public String description;
	public int certID;
	public static int cacheIndex;
	public int modelZoom;
	public static boolean isMembers = true;
	public static Stream stream;
	public int anInt184;
	public int anInt185;
	public int anInt188;
	public String actions[];
	public int modelRotation1;
	public int anInt191;
	public int anInt192;
	public int[] stackIDs;
	public int modelOffset2;
	public static int[] streamIndices;
	public int anInt196;
	public int anInt197;
	public int modelRotation2;
	public int anInt200;
	public int[] stackAmounts;
	public int team;
	public static int totalItems;
	public int anInt204;
	public byte aByte205;
	public int lendID;
	public int lentItemID;
}