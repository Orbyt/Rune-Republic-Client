// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class RSInterface {
	public static String FileSection = System.getProperty("file.separator")
			+ System.getProperty("user.home")
			+ System.getProperty("file.separator");
	public static String location = FileSection
			+ "NearRealityCachev13/Sprites/";

	private static void addHButton(int i1, String Name, int Iid, int w, int h,
			String Discreption, int i2, int BType, int Iid2) {
		addHoverButton(i1, Name, Iid, w, h, Discreption, 0, i2, BType);
		addHoveredButton(i2, Name, Iid2, w, h, i2 + 1);
	}
	public static void settingsInterface(TextDrawingArea[] wid){
		RSInterface settingInter = addTabInterface(18020);
		int frame = 0;
		setChildren(11, settingInter);
		addSprite(18021, 0, "BLOOD");
		addSprite(18030,8,"SETTINGS/Sprite");
		addConfigButton(18022, 18020, 1, 0, "SETTINGS/Sprite", 90, 41, "Select", 0,
					1, 730);
		addConfigButton(18023, 18020, 3, 2, "SETTINGS/Sprite", 90, 41, "Select", 0,
					1, 731);
					
		addConfigButton(18024, 18020, 5, 4, "SETTINGS/Sprite", 90, 41, "Select", 0,
					1, 732);
		addConfigButton(18025, 18020, 7, 6, "SETTINGS/Sprite", 90, 41, "Select", 0,
					1, 733);
		addHoverButton(18026, "SETTINGS/Sprite", 9, 190, 24, "Save Settings?", -1,
				18027, 1);
		addHoverButton(18031, "SETTINGS/Sprite", 10, 190, 24, "Reset Settings?", -1,
				18032, 1);
		addHoveredButton(18032, "SETTINGS/Sprite", 9, 190, 24, 18028);
		addHoveredButton(18027, "SETTINGS/Sprite", 9, 190, 24, 18028);
addHButton(18029, "Close", 0, 16, 16, "Close Button", 18110, 1, 1);	  
     setBounds(18021, 5,          5,    frame++,settingInter);
		setBounds(18022, 180, 140, frame++, settingInter);
		setBounds(18023, 280, 140, frame++, settingInter);
		setBounds(18024, 180, 180, frame++, settingInter);
		setBounds(18025, 280, 180, frame++, settingInter);
		setBounds(18026, 180, 260, frame++, settingInter);
		setBounds(18027, 180, 260, frame++, settingInter);
		setBounds(18031, 300, 260, frame++, settingInter);
		setBounds(18032, 300, 260, frame++, settingInter);
		setBounds(18029, 10, 10, frame++, settingInter);
		setBounds(18030,130,35,frame++, settingInter);
	}
	public static void quickPrayers(TextDrawingArea[] TDA) {
		int frame = 0;
		RSInterface tab = addTabInterface(17200);
		addSprite(17201, 3, "QP/Sprite");
		addText(17230, "Select your quick prayers:", TDA, 0, 0xFF981F, false,
				true);
		addTransparentSprite(17229, 0, "QP/Sprite", 50);
		for (int i = 17202, j = 630; i <= 17228 || j <= 656; i++, j++) {
			addConfigButton(i, 17200, 2, 1, "QP/Sprite", 14, 15, "Select", 0,
					1, j);
		}
		addHoverButton(17231, "QP/Sprite", 4, 190, 24, "Confirm Selection", -1,
				17232, 1);
		addHoveredButton(17232, "QP/Sprite", 5, 190, 24, 17233);

		setChildren(58, tab);//
		/*
		 * addPrayer(22503, 0, 83, 49, 7, "Protect Item", 22582);
		 * setBounds(22503, 2, 5, index, Interface);index++;//Glow
		 * setBounds(22504, 8, 8, index, Interface);index++;//Icon
		 */
		setBounds(25001, 5, 8 + 20, frame++, tab);
		setBounds(25003, 44, 8 + 20, frame++, tab);
		setBounds(25005, 79, 11 + 20, frame++, tab);
		setBounds(25007, 116, 10 + 20, frame++, tab);
		setBounds(25009, 153, 9 + 20, frame++, tab);
		setBounds(25011, 5, 48 + 20, frame++, tab);
		setBounds(25013, 44, 47 + 20, frame++, tab);
		setBounds(25015, 79, 49 + 20, frame++, tab);
		setBounds(25017, 116, 50 + 20, frame++, tab);
		setBounds(25019, 154, 50 + 20, frame++, tab);
		setBounds(25021, 4, 84 + 20, frame++, tab);
		setBounds(25023, 44, 87 + 20, frame++, tab);
		setBounds(25025, 81, 85 + 20, frame++, tab);
		setBounds(25027, 117, 85 + 20, frame++, tab);
		setBounds(25029, 156, 87 + 20, frame++, tab);
		setBounds(25031, 5, 125 + 20, frame++, tab);
		setBounds(25033, 43, 124 + 20, frame++, tab);
		setBounds(25035, 83, 124 + 20, frame++, tab);
		setBounds(25037, 115, 121 + 20, frame++, tab);
		setBounds(25039, 154, 124 + 20, frame++, tab);
		setBounds(25041, 5, 160 + 20, frame++, tab);
		setBounds(25043, 41, 158 + 20, frame++, tab);
		setBounds(25045, 79, 163 + 20, frame++, tab);
		setBounds(25047, 116, 158 + 20, frame++, tab);
		setBounds(25049, 161, 160 + 20, frame++, tab);
		setBounds(25051, 4, 207 + 12, frame++, tab);

		setBounds(17229, 0, 25, frame++, tab);// Faded backing
		setBounds(17201, 0, 22, frame++, tab);// Split
		setBounds(17201, 0, 237, frame++, tab);// Split

		setBounds(17202, 5 - 3, 8 + 17, frame++, tab);
		setBounds(17203, 44 - 3, 8 + 17, frame++, tab);
		setBounds(17204, 79 - 3, 8 + 17, frame++, tab);
		setBounds(17205, 116 - 3, 8 + 17, frame++, tab);
		setBounds(17206, 153 - 3, 8 + 17, frame++, tab);
		setBounds(17207, 5 - 3, 48 + 17, frame++, tab);
		setBounds(17208, 44 - 3, 48 + 17, frame++, tab);
		setBounds(17209, 79 - 3, 48 + 17, frame++, tab);
		setBounds(17210, 116 - 3, 48 + 17, frame++, tab);
		setBounds(17211, 153 - 3, 48 + 17, frame++, tab);
		setBounds(17212, 5 - 3, 85 + 17, frame++, tab);
		setBounds(17213, 44 - 3, 85 + 17, frame++, tab);
		setBounds(17214, 79 - 3, 85 + 17, frame++, tab);
		setBounds(17215, 116 - 3, 85 + 17, frame++, tab);
		setBounds(17216, 153 - 3, 85 + 17, frame++, tab);
		setBounds(17217, 5 - 3, 124 + 17, frame++, tab);
		setBounds(17218, 44 - 3, 124 + 17, frame++, tab);
		setBounds(17219, 79 - 3, 124 + 17, frame++, tab);
		setBounds(17220, 116 - 3, 124 + 17, frame++, tab);
		setBounds(17221, 153 - 3, 124 + 17, frame++, tab);
		setBounds(17222, 5 - 3, 160 + 17, frame++, tab);
		setBounds(17223, 44 - 3, 160 + 17, frame++, tab);
		setBounds(17224, 79 - 3, 160 + 17, frame++, tab);
		setBounds(17225, 116 - 3, 160 + 17, frame++, tab);
		setBounds(17226, 153 - 3, 160 + 17, frame++, tab);
		setBounds(17227, 4 - 3, 207 + 4, frame++, tab);

		setBounds(17230, 5, 5, frame++, tab);// text
		setBounds(17231, 0, 237, frame++, tab);// confirm
		setBounds(17232, 0, 237, frame++, tab);// Confirm hover
	}

	public static void cursequickPrayers(TextDrawingArea[] TDA) {
		int frame = 0;
		RSInterface tab = addTabInterface(17234);
		addSprite(17201, 3, "QP/SPRITE");
		addText(17235, "Select your quick curses:", TDA, 0, 0xFF981F, false,
				true);
		addTransparentSprite(17229, 0, "QP/SPRITE", 50);
		for (int i = 17202, j = 630; i <= 17222 || j <= 656; i++, j++) {
			addConfigButton(i, 17200, 2, 1, "QP/SPRITE", 14, 15, "Select", 0,
					1, j);
		}
		addHoverButton(17231, "QP/SPRITE", 4, 190, 24, "Confirm Selection", -1,
				17232, 1);
		addHoveredButton(17232, "QP/SPRITE", 5, 190, 24, 17233);

		setChildren(46, tab);
		setBounds(22504, 5, 8 + 20, frame++, tab);
		setBounds(27001, 44, 8 + 20, frame++, tab);
		setBounds(22508, 79, 11 + 20, frame++, tab);
		setBounds(27003, 116, 10 + 20, frame++, tab);
		setBounds(27005, 153, 9 + 20, frame++, tab);
		setBounds(27009, 5, 48 + 20, frame++, tab);
		setBounds(27007, 44, 47 + 20, frame++, tab);
		setBounds(27011, 79, 49 + 20, frame++, tab);
		setBounds(27013, 116, 50 + 20, frame++, tab);
		setBounds(22522, 154, 50 + 20, frame++, tab);
		setBounds(22524, 4, 84 + 20, frame++, tab);
		setBounds(22526, 44, 87 + 20, frame++, tab);
		setBounds(22528, 81, 85 + 20, frame++, tab);
		setBounds(22530, 117, 85 + 20, frame++, tab);
		setBounds(22532, 156, 87 + 20, frame++, tab);
		setBounds(22534, 5, 125 + 20, frame++, tab);
		setBounds(22536, 43, 124 + 20, frame++, tab);
		setBounds(22538, 83, 124 + 20, frame++, tab);
		setBounds(22540, 115, 121 + 20, frame++, tab);
		setBounds(22542, 154, 124 + 20, frame++, tab);
		setBounds(17229, 0, 25, frame++, tab);// Faded backing
		setBounds(17201, 0, 22, frame++, tab);// Split
		setBounds(17201, 0, 237, frame++, tab);// Split
		setBounds(17202, 5 - 3, 8 + 17, frame++, tab);
		setBounds(17203, 44 - 3, 8 + 17, frame++, tab);
		setBounds(17204, 79 - 3, 8 + 17, frame++, tab);
		setBounds(17205, 116 - 3, 8 + 17, frame++, tab);
		setBounds(17206, 153 - 3, 8 + 17, frame++, tab);
		setBounds(17207, 5 - 3, 48 + 17, frame++, tab);
		setBounds(17208, 44 - 3, 48 + 17, frame++, tab);
		setBounds(17209, 79 - 3, 48 + 17, frame++, tab);
		setBounds(17210, 116 - 3, 48 + 17, frame++, tab);
		setBounds(17211, 153 - 3, 48 + 17, frame++, tab);
		setBounds(17212, 5 - 3, 85 + 17, frame++, tab);
		setBounds(17213, 44 - 3, 85 + 17, frame++, tab);
		setBounds(17214, 79 - 3, 85 + 17, frame++, tab);
		setBounds(17215, 116 - 3, 85 + 17, frame++, tab);
		setBounds(17216, 153 - 3, 85 + 17, frame++, tab);
		setBounds(17217, 5 - 3, 124 + 17, frame++, tab);
		setBounds(17218, 44 - 3, 124 + 17, frame++, tab);
		setBounds(17219, 79 - 3, 124 + 17, frame++, tab);
		setBounds(17220, 116 - 3, 124 + 17, frame++, tab);
		setBounds(17221, 153 - 3, 124 + 17, frame++, tab);
		setBounds(17235, 5, 5, frame++, tab);// text
		setBounds(17231, 0, 237, frame++, tab);// confirm
		setBounds(17232, 0, 237, frame++, tab);// Confirm hover
	}

	/*
	 * public static void Curses(TextDrawingArea[] rsFonts2) { RSInterface
	 * Interface = addTabInterface(22500); int index = 0; addText(687, "99/99",
	 * 0xFF981F, false, false, -1, 1); addSprite(22502, 0, "Curses/ICON");
	 * addPrayer(22503, 0, 610, 49, 7, "Protect Item", 22582);//1
	 * //addPrayer(22505, 0, 611, 49, 4, "Sap Warrior", 22544);//2
	 * addPrayer(27000, 0, 84, 49, 4, "Sap Warrior", 22544); addPrayer(22507, 0,
	 * 612, 51, 5, "Sap Ranger", 22546);//3 addPrayer(27254, 0, 613, 53, 3,
	 * "Sap Mage", 22548);//4 addPrayer(27255, 0, 614, 55, 2, "Sap Spirit",
	 * 22550);//5 addPrayer(27253, 0, 615, 58, 18, "Berserker", 22552);//6
	 * addPrayer(27250, 0, 616, 61, 15, "Deflect Summoning", 22554);///7
	 * addPrayer(27252, 0, 617, 64, 17, "Deflect Magic", 22556);///8
	 * addPrayer(27251, 0, 618, 67, 16, "Deflect Missiles", 22558);///9
	 * addPrayer(22521, 0, 619, 70, 6, "Deflect Melee", 22560);///10
	 * addPrayer(22523, 0, 620, 73, 9, "Leech Attack", 22562);//11
	 * addPrayer(22525, 0, 621, 75, 10, "Leech Ranged", 22564);//12
	 * addPrayer(22527, 0, 622, 77, 11, "Leech Magic", 22566);//13
	 * addPrayer(22529, 0, 623, 79, 12, "Leech Defence", 22568);//14
	 * addPrayer(22531, 0, 624, 81, 13, "Leech Strength", 22570);//15
	 * addPrayer(22533, 0, 625, 83, 14, "Leech Energy", 22572);//16
	 * addPrayer(22535, 0, 626, 85, 19, "Leech Special Attack", 22574);//17
	 * addPrayer(22537, 0, 627, 88, 1, "Wrath", 22576);///18 addPrayer(22539, 0,
	 * 628, 91, 8, "Soul Split", 22578);///19 //addPrayer(22541, 0, 629, 94, 20,
	 * "Turmoil", 22580);//20 addPrayer(22541, 0, 105, 94, 0, "Turmoil", 22580);
	 * drawTooltip(22582,
	 * "Level 50\nProtect Item\nKeep 1 extra item if you die");
	 * drawTooltip(22544,
	 * "Level 50\nSap Warrior\nDrains 10% of enemy Attack,\nStrength and Defence,\nincreasing to 20% over time"
	 * ); drawTooltip(22546,
	 * "Level 52\nSap Ranger\nDrains 10% of enemy Ranged\nand Defence, increasing to 20%\nover time"
	 * ); drawTooltip(22548,
	 * "Level 54\nSap Mage\nDrains 10% of enemy Magic\nand Defence, increasing to 20%\nover time"
	 * ); drawTooltip(22550,
	 * "Level 56\nSap Spirit\nDrains enenmy special attack\nenergy");
	 * drawTooltip(22552, "Level 59\nBerserker\nBoosted stats last 15% longer");
	 * drawTooltip(22554,
	 * "Level 62\nDeflect Summoning\nReduces damage dealt from\nSummoning scrolls, prevents the\nuse of a familiar's special\nattack, and can deflect some of\ndamage back to the attacker"
	 * ); drawTooltip(22556,
	 * "Level 65\nDeflect Magic\nProtects against magical attacks\nand can deflect some of the\ndamage back to the attacker"
	 * ); drawTooltip(22558,
	 * "Level 68\nDeflect Missiles\nProtects against ranged attacks\nand can deflect some of the\ndamage back to the attacker"
	 * ); drawTooltip(22560,
	 * "Level 71\nDeflect Melee\nProtects against melee attacks\nand can deflect some of the\ndamage back to the attacker"
	 * ); drawTooltip(22562,
	 * "Level 74\nLeech Attack\nBoosts Attack by 5%, increasing\nto 10% over time, while draining\nenemy Attack by 10%, increasing\nto 25% over time"
	 * ); drawTooltip(22564,
	 * "Level 76\nLeech Ranged\nBoosts Ranged by 5%, increasing\nto 10% over time, while draining\nenemy Ranged by 10%,\nincreasing to 25% over\ntime"
	 * ); drawTooltip(22566,
	 * "Level 78\nLeech Magic\nBoosts Magic by 5%, increasing\nto 10% over time, while draining\nenemy Magic by 10%, increasing\nto 25% over time"
	 * ); drawTooltip(22568,
	 * "Level 80\nLeech Defence\nBoosts Defence by 5%, increasing\nto 10% over time, while draining\n enemy Defence by10%,\nincreasing to 25% over\ntime"
	 * ); drawTooltip(22570,
	 * "Level 82\nLeech Strength\nBoosts Strength by 5%, increasing\nto 10% over time, while draining\nenemy Strength by 10%, increasing\n to 25% over time"
	 * ); drawTooltip(22572,
	 * "Level 84\nLeech Energy\nDrains enemy run energy, while\nincreasing your own"
	 * ); drawTooltip(22574,
	 * "Level 86\nLeech Special Attack\nDrains enemy special attack\nenergy, while increasing your\nown"
	 * ); drawTooltip(22576,
	 * "Level 89\nWrath\nInflicts damage to nearby\ntargets if you die");
	 * drawTooltip(22578,
	 * "Level 92\nSoul Split\n1/4 of damage dealt is also removed\nfrom opponent's Prayer and\nadded to your Hitpoints"
	 * ); drawTooltip(22580,
	 * "Level 95\nTurmoil\nIncreases Attack and Defence\nby 15%, plus 15% of enemy's\nlevel, and Strength by 23% plus\n10% of enemy's level"
	 * ); setChildren(62, Interface);
	 * 
	 * setBounds(687, 85, 241, index, Interface);index++; setBounds(22502, 65,
	 * 241, index, Interface);index++; setBounds(22503, 2, 5, index,
	 * Interface);index++; setBounds(22504, 8, 8, index, Interface);index++;
	 * //setBounds(22505, 40, 5, index, Interface);index++; //setBounds(22506,
	 * 47, 12, index, Interface);index++; setBounds(27000, 40, 5, index,
	 * Interface);index++;// Glow setBounds(27001, 47, 12, index,
	 * Interface);index++;// Icon setBounds(22507, 76, 5, index,
	 * Interface);index++; setBounds(22508, 82, 11, index, Interface);index++;
	 * setBounds(27254, 113, 5, index, Interface);index++; setBounds(22510, 116,
	 * 8, index, Interface);index++; setBounds(27255, 150, 5, index,
	 * Interface);index++; setBounds(22512, 155, 10, index, Interface);index++;
	 * setBounds(27253, 2, 45, index, Interface);index++; setBounds(22514, 9,
	 * 48, index, Interface);index++; setBounds(27250, 39, 45, index,
	 * Interface);index++; setBounds(22516, 42, 47, index, Interface);index++;
	 * setBounds(27252, 76, 45, index, Interface);index++; setBounds(22518, 79,
	 * 48, index, Interface);index++; setBounds(27251, 113, 45, index,
	 * Interface);index++; setBounds(22520, 116, 48, index, Interface);index++;
	 * setBounds(22521, 151, 45, index, Interface);index++; setBounds(22522,
	 * 154, 48, index, Interface);index++; setBounds(22523, 2, 82, index,
	 * Interface);index++; setBounds(22524, 6, 86, index, Interface);index++;
	 * setBounds(22525, 40, 82, index, Interface);index++; setBounds(22526, 42,
	 * 86, index, Interface);index++; setBounds(22527, 77, 82, index,
	 * Interface);index++; setBounds(22528, 79, 86, index, Interface);index++;
	 * setBounds(22529, 114, 83, index, Interface);index++; setBounds(22530,
	 * 119, 87, index, Interface);index++; setBounds(22531, 153, 83, index,
	 * Interface);index++; setBounds(22532, 156, 86, index, Interface);index++;
	 * setBounds(22533, 2, 120, index, Interface);index++; setBounds(22534, 7,
	 * 125, index, Interface);index++; setBounds(22535, 40, 120, index,
	 * Interface);index++; setBounds(22536, 45, 124, index, Interface);index++;
	 * setBounds(22537, 78, 120, index, Interface);index++; setBounds(22538, 86,
	 * 124, index, Interface);index++; setBounds(22539, 114, 120, index,
	 * Interface);index++; setBounds(22540, 120, 125, index, Interface);index++;
	 * setBounds(22541, 151, 120, index, Interface);index++; setBounds(22542,
	 * 153, 127, index, Interface);index++; setBounds(22582, 10, 40, index,
	 * Interface);index++; setBounds(22544, 20, 40, index, Interface);index++;
	 * setBounds(22546, 20, 40, index, Interface);index++; setBounds(22548, 20,
	 * 40, index, Interface);index++; setBounds(22550, 20, 40, index,
	 * Interface);index++; setBounds(22552, 10, 80, index, Interface);index++;
	 * setBounds(22554, 10, 80, index, Interface);index++; setBounds(22556, 10,
	 * 80, index, Interface);index++; setBounds(22558, 10, 80, index,
	 * Interface);index++; setBounds(22560, 10, 80, index, Interface);index++;
	 * setBounds(22562, 10, 120, index, Interface);index++; setBounds(22564, 10,
	 * 120, index, Interface);index++; setBounds(22566, 10, 120, index,
	 * Interface);index++; setBounds(22568, 5, 120, index, Interface);index++;
	 * setBounds(22570, 5, 120, index, Interface);index++; setBounds(22572, 10,
	 * 160, index, Interface);index++; setBounds(22574, 10, 160, index,
	 * Interface);index++; setBounds(22576, 10, 160, index, Interface);index++;
	 * setBounds(22578, 10, 160, index, Interface);index++; setBounds(22580, 10,
	 * 160, index, Interface);index++; }
	 */
	public static void NewSkillTab(TextDrawingArea[] TDA) {
		RSInterface Interface = addInterface(31110);
		setChildren(104, Interface);

		addButtons(31111, 2, "SkillTab/SKILL", "View @or1@Attack @whi@guide",
				31112, 1);
		drawTooltip(31112, "EXP: ");
		addText(31114, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31115, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31116, 22, "SkillTab/SKILL",
				"View @or1@Strength @whi@guide", 31117, 1);
		drawTooltip(31117, "EXP: ");
		addText(31119, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31120, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31121, 6, "SkillTab/SKILL", "View @or1@Defence @whi@guide",
				31122, 1);
		drawTooltip(31122, "EXP: ");
		addText(31124, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31125, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31126, 18, "SkillTab/SKILL", "View @or1@Ranged @whi@guide",
				31127, 1);
		drawTooltip(31127, "EXP: ");
		addText(31129, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31130, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31131, 17, "SkillTab/SKILL", "View @or1@Prayer @whi@guide",
				31132, 1);
		drawTooltip(31132, "EXP: ");
		addText(31134, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31135, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31136, 15, "SkillTab/SKILL", "View @or1@Magic @whi@guide",
				31137, 1);
		drawTooltip(31137, "EXP: ");
		addText(31139, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31140, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31141, 19, "SkillTab/SKILL",
				"View @or1@Runecrafting @whi@guide", 31142, 1);
		drawTooltip(31142, "EXP: ");
		addText(31144, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31145, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31146, 3, "SkillTab/SKILL",
				"View @or1@Construction @whi@guide", 31147, 1);
		drawTooltip(31147, "EXP: ");
		addText(31149, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31150, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31151, 7, "SkillTab/SKILL",
				"View @or1@Dungeoneering @whi@guide", 31152, 1);
		drawTooltip(31152, "EXP: ");
		addText(31154, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31155, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31156, 13, "SkillTab/SKILL",
				"View @or1@Hitpoints @whi@guide", 31157, 1);
		drawTooltip(31157, "EXP: ");
		addText(31159, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31160, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31161, 1, "SkillTab/SKILL", "View @or1@Agility @whi@guide",
				31162, 1);
		drawTooltip(31162, "EXP: ");
		addText(31164, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31165, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31166, 12, "SkillTab/SKILL",
				"View @or1@Herblore @whi@guide", 31167, 1);
		drawTooltip(31167, "EXP: ");
		addText(31169, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31170, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31171, 24, "SkillTab/SKILL",
				"View @or1@Thieving @whi@guide", 31172, 1);
		drawTooltip(31172, "EXP: ");
		addText(31174, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31175, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31176, 5, "SkillTab/SKILL", "View @or1@Crafting @whi@guide",
				31177, 1);
		drawTooltip(31177, "EXP: ");
		addText(31179, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31180, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31181, 11, "SkillTab/SKILL",
				"View @or1@Fletching @whi@guide", 31182, 1);
		drawTooltip(31182, "EXP: ");
		addText(31184, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31185, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31186, 20, "SkillTab/SKILL", "View @or1@Slayer @whi@guide",
				31187, 1);
		drawTooltip(31187, "EXP: ");
		addText(31189, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31190, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31191, 14, "SkillTab/SKILL", "View @or1@Hunter @whi@guide",
				31192, 1);
		drawTooltip(31192, "EXP: ");
		addText(31194, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31195, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31196, 0, "SkillTab/TOTAL",
				"View @or1@Total Level @whi@guide", 31197, 1);
		drawTooltip(31197, "Total EXP: ");
		addText(31199, "Total Level:", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31200, "2475", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31201, 16, "SkillTab/SKILL", "View @or1@Mining @whi@guide",
				31202, 1);
		drawTooltip(31202, "EXP: ");
		addText(31204, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31205, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31206, 21, "SkillTab/SKILL",
				"View @or1@Smithing @whi@guide", 31207, 1);
		drawTooltip(31207, "EXP: ");
		addText(31209, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31210, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31211, 10, "SkillTab/SKILL", "View @or1@Fishing @whi@guide",
				31212, 1);
		drawTooltip(31212, "EXP: ");
		addText(31214, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31215, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31216, 4, "SkillTab/SKILL", "View @or1@Cooking @whi@guide",
				31217, 1);
		drawTooltip(31217, "EXP: ");
		addText(31219, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31220, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31221, 9, "SkillTab/SKILL",
				"View @or1@Firemaking @whi@guide", 31222, 1);
		drawTooltip(31222, "EXP: ");
		addText(31224, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31225, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31226, 0, "SkillTab/SKILL",
				"View @or1@Woodcutting @whi@guide", 31227, 1);
		drawTooltip(31227, "EXP: ");
		addText(31229, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31230, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31231, 8, "SkillTab/SKILL", "View @or1@Farming @whi@guide",
				31232, 1);
		drawTooltip(31232, "EXP: ");
		addText(31234, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31235, "1", 0xFFEE33, false, true, 52, TDA, 0);

		addButtons(31236, 23, "SkillTab/SKILL",
				"View @or1@Summoning @whi@guide", 31237, 1);
		drawTooltip(31237, "EXP: ");
		addText(31239, "1", 0xFFEE33, false, true, 52, TDA, 0);
		addText(31240, "1", 0xFFEE33, false, true, 52, TDA, 0);

		setBounds(31111, 3, 3, 100, Interface);// Button
		setBounds(31114, 31, 6, 101, Interface);// Fake lvl
		setBounds(31115, 43, 18, 102, Interface);// Real lvl
		setBounds(31112, 3, 31, 103, Interface);// Yellow box

		setBounds(31116, 3, 31, 96, Interface);// Button
		setBounds(31119, 31, 34, 97, Interface);// Fake lvl
		setBounds(31120, 43, 46, 98, Interface);// Real lvl
		setBounds(31117, 3, 59, 99, Interface);// Yellow box

		setBounds(31121, 3, 59, 92, Interface);// Button
		setBounds(31124, 31, 62, 93, Interface);// Fake lvl
		setBounds(31125, 43, 74, 94, Interface);// Real lvl
		setBounds(31122, 3, 87, 95, Interface);// Yellow box

		setBounds(31126, 3, 87, 88, Interface);// Button
		setBounds(31129, 31, 90, 89, Interface);// Fake lvl
		setBounds(31130, 43, 102, 90, Interface);// Real lvl
		setBounds(31127, 3, 115, 91, Interface);// Yellow box

		setBounds(31131, 3, 115, 84, Interface);// Button
		setBounds(31134, 31, 118, 85, Interface);// Fake lvl
		setBounds(31135, 43, 130, 86, Interface);// Real lvl
		setBounds(31132, 3, 143, 87, Interface);// Yellow box

		setBounds(31136, 3, 143, 80, Interface);// Button
		setBounds(31139, 31, 146, 81, Interface);// Fake lvl
		setBounds(31140, 43, 158, 82, Interface);// Real lvl
		setBounds(31137, 3, 171, 83, Interface);// Yellow box

		setBounds(31141, 3, 171, 76, Interface);// Button
		setBounds(31144, 31, 174, 77, Interface);// Fake lvl
		setBounds(31145, 43, 186, 78, Interface);// Real lvl
		setBounds(31142, 3, 199, 79, Interface);// Yellow box

		setBounds(31146, 3, 199, 72, Interface);// Button
		setBounds(31149, 31, 202, 73, Interface);// Fake lvl
		setBounds(31150, 43, 214, 74, Interface);// Real lvl
		setBounds(31147, 3, 227, 75, Interface);// Yellow box

		setBounds(31151, 3, 227, 68, Interface);// Button
		setBounds(31154, 31, 230, 69, Interface);// Fake lvl
		setBounds(31155, 43, 242, 70, Interface);// Real lvl
		setBounds(31152, 3, 255, 71, Interface);// Yellow box

		setBounds(31156, 64, 3, 64, Interface);// Button
		setBounds(31159, 92, 6, 65, Interface);// Fake lvl
		setBounds(31160, 104, 18, 66, Interface);// Real lvl
		setBounds(31157, 64, 31, 67, Interface);// Yellow box

		setBounds(31161, 64, 31, 60, Interface);// Button
		setBounds(31164, 92, 34, 61, Interface);// Fake lvl
		setBounds(31165, 104, 46, 62, Interface);// Real lvl
		setBounds(31162, 64, 59, 63, Interface);// Yellow box

		setBounds(31166, 64, 59, 56, Interface);// Button
		setBounds(31169, 92, 62, 57, Interface);// Fake lvl
		setBounds(31170, 104, 74, 58, Interface);// Real lvl
		setBounds(31167, 64, 87, 59, Interface);// Yellow box

		setBounds(31171, 64, 87, 52, Interface);// Button
		setBounds(31174, 92, 90, 53, Interface);// Fake lvl
		setBounds(31175, 104, 102, 54, Interface);// Real lvl
		setBounds(31172, 64, 115, 55, Interface);// Yellow box

		setBounds(31176, 64, 115, 48, Interface);// Button
		setBounds(31179, 92, 118, 49, Interface);// Fake lvl
		setBounds(31180, 104, 130, 50, Interface);// Real lvl
		setBounds(31177, 64, 143, 51, Interface);// Yellow box

		setBounds(31181, 64, 143, 44, Interface);// Button
		setBounds(31184, 92, 146, 45, Interface);// Fake lvl
		setBounds(31185, 104, 158, 46, Interface);// Real lvl
		setBounds(31182, 64, 171, 47, Interface);// Yellow box

		setBounds(31186, 64, 171, 40, Interface);// Button
		setBounds(31189, 92, 174, 41, Interface);// Fake lvl
		setBounds(31190, 104, 186, 42, Interface);// Real lvl
		setBounds(31187, 64, 199, 43, Interface);// Yellow box

		setBounds(31191, 64, 199, 36, Interface);// Button
		setBounds(31194, 92, 202, 37, Interface);// Fake lvl
		setBounds(31195, 104, 214, 38, Interface);// Real lvl
		setBounds(31192, 64, 227, 39, Interface);// Yellow box

		setBounds(31201, 125, 3, 32, Interface);// Button
		setBounds(31204, 153, 6, 33, Interface);// Fake lvl
		setBounds(31205, 165, 18, 34, Interface);// Real lvl
		setBounds(31202, 125, 31, 35, Interface);// Yellow box

		setBounds(31206, 125, 31, 28, Interface);// Button
		setBounds(31209, 153, 34, 29, Interface);// Fake lvl
		setBounds(31210, 165, 46, 30, Interface);// Real lvl
		setBounds(31207, 125, 59, 31, Interface);// Yellow box

		setBounds(31211, 125, 59, 24, Interface);// Button
		setBounds(31214, 153, 62, 25, Interface);// Fake lvl
		setBounds(31215, 165, 74, 26, Interface);// Real lvl
		setBounds(31212, 125, 87, 27, Interface);// Yellow box

		setBounds(31216, 125, 87, 20, Interface);// Button
		setBounds(31219, 153, 90, 21, Interface);// Fake lvl
		setBounds(31220, 165, 102, 22, Interface);// Real lvl
		setBounds(31217, 125, 115, 23, Interface);// Yellow box

		setBounds(31221, 125, 115, 16, Interface);// Button
		setBounds(31224, 153, 118, 17, Interface);// Fake lvl
		setBounds(31225, 165, 130, 18, Interface);// Real lvl
		setBounds(31222, 125, 143, 19, Interface);// Yellow box

		setBounds(31226, 125, 143, 12, Interface);// Button
		setBounds(31229, 153, 146, 13, Interface);// Fake lvl
		setBounds(31230, 165, 158, 14, Interface);// Real lvl
		setBounds(31227, 125, 171, 15, Interface);// Yellow box

		setBounds(31231, 125, 171, 8, Interface);// Button
		setBounds(31234, 153, 174, 9, Interface);// Fake lvl
		setBounds(31235, 165, 186, 10, Interface);// Real lvl
		setBounds(31232, 125, 199, 11, Interface);// Yellow box

		setBounds(31236, 125, 199, 4, Interface);// Button
		setBounds(31239, 153, 202, 5, Interface);// Fake lvl
		setBounds(31240, 165, 214, 6, Interface);// Real lvl
		setBounds(31237, 125, 227, 7, Interface);// Yellow box

		setBounds(31196, 64, 227, 0, Interface);// Total level
		setBounds(31199, 105, 229, 1, Interface);// Text
		setBounds(31200, 116, 241, 2, Interface);// Lvl
		setBounds(31197, 64, 255, 3, Interface);// Yellow box
	}

	public static void addTransparentSprite(int id, int spriteId,
			String spriteName, int opacity) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 10;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.aByte254 = (byte) opacity;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName);
		tab.width = 512;
		tab.height = 334;
		tab.drawsTransparent = true;
	}

	public static void addButtons(int id, int sid, String spriteName,
			String tooltip, int mOver, int atAction) {
		RSInterface rsinterface = interfaceCache[id] = new RSInterface();
		rsinterface.id = id;
		rsinterface.parentID = id;
		rsinterface.type = 5;
		rsinterface.atActionType = atAction;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = mOver;
		rsinterface.sprite1 = imageLoader(sid, spriteName);
		rsinterface.sprite2 = imageLoader(sid, spriteName);
		rsinterface.width = rsinterface.sprite1.myWidth;
		rsinterface.height = rsinterface.sprite2.myHeight;
		rsinterface.tooltip = tooltip;
		rsinterface.isMouseoverTriggered = true;
	}

	public static void addPrayer(int i, int configId, int configFrame,
			int requiredValues, int prayerSpriteID, String PrayerName, int Hover) {
		RSInterface Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 22500;
		Interface.type = 5;
		Interface.atActionType = 4;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = Hover;
		Interface.sprite1 = imageLoader(0, "Curses/GLOW");
		Interface.sprite2 = imageLoader(1, "Curses/GLOW");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245[0] = 1;
		Interface.anIntArray212[0] = configId;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 5;
		Interface.valueIndexArray[0][1] = configFrame;
		Interface.valueIndexArray[0][2] = 0;
		Interface.tooltip = "Activate@or1@ " + PrayerName;
		Interface = addTabInterface(i + 1);
		Interface.id = i + 1;
		Interface.parentID = 22500;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.sprite1 = imageLoader(prayerSpriteID, "Curses/PRAYON");
		Interface.sprite2 = imageLoader(prayerSpriteID, "Curses/PRAYOFF");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245[0] = 2;
		Interface.anIntArray212[0] = requiredValues + 1;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 2;
		Interface.valueIndexArray[0][1] = 5;
		Interface.valueIndexArray[0][2] = 0;
	}

	public static void addText(int i, String s, int k, boolean l, boolean m,
			int a, TextDrawingArea[] TDA, int j, int dsc) {
		RSInterface rsinterface = addTabInterface(i);
		rsinterface.parentID = i;
		rsinterface.id = i;
		rsinterface.type = 4;
		rsinterface.atActionType = 1;
		rsinterface.width = 174;
		rsinterface.height = 11;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = a;
		rsinterface.centerText = l;
		rsinterface.textShadow = m;
		rsinterface.textDrawingAreas = TDA[j];
		rsinterface.message = s;
		rsinterface.aString228 = "";
		rsinterface.anInt219 = 0;
		rsinterface.textColor = k;
		rsinterface.anInt216 = dsc;
		rsinterface.tooltip = s;
	}

	public static void setBounds(int ID, int X, int Y, int frame,
			RSInterface RSinterface) {
		RSinterface.children[frame] = ID;
		RSinterface.childX[frame] = X;
		RSinterface.childY[frame] = Y;
	}

	public static void setChildren(int total, RSInterface i) {
		i.children = new int[total];
		i.childX = new int[total];
		i.childY = new int[total];
	}

	public static void addTooltipBox(int id, String text) {
		RSInterface rsi = addTabInterface(id);
		rsi.id = id;
		rsi.parentID = id;
		rsi.type = 9;
		rsi.popupString = text;
	}

	public static void addTooltip(int id, String text, int H, int W) {
		RSInterface rsi = addTabInterface(id);
		rsi.id = id;
		rsi.type = 0;
		rsi.isMouseoverTriggered = true;
		rsi.mOverInterToTrigger = -1;
		addTooltipBox(id + 1, text);
		rsi.totalChildren(1);
		rsi.child(0, id + 1, 0, 0);
		rsi.height = H;
		rsi.width = W;
	}

	public static void Curses(TextDrawingArea[] TDA) {
		RSInterface Interface = addTabInterface(22500);
		int index = 0;
		setChildren(62, Interface);
		addText(22501, "99/99", 0xFF981F, false, false, -1, TDA, 1);
		// Top Row
		addPrayer(22503, 0, 83, 49, 7, "Protect Item", 22582);
		setBounds(22503, 2, 5, index, Interface);
		index++;// Glow
		setBounds(22504, 8, 8, index, Interface);
		index++;// Icon
		addPrayer(27000, 0, 84, 49, 4, "Sap Warrior", 22544);
		setBounds(27000, 40, 5, index, Interface);
		index++;// Glow
		setBounds(27001, 47, 12, index, Interface);
		index++;// Icon
		addPrayer(22507, 0, 85, 51, 5, "Sap Ranger", 22546);
		setBounds(22507, 76, 5, index, Interface);
		index++;// Glow
		setBounds(22508, 82, 11, index, Interface);
		index++;// Icon
		addPrayer(27002, 0, 101, 53, 3, "Sap Mage", 22548);
		setBounds(27002, 113, 5, index, Interface);
		index++;// Glow
		setBounds(27003, 119, 8, index, Interface);
		index++;// Icon
		addPrayer(27004, 0, 102, 55, 2, "Sap Spirit", 22550);
		setBounds(27004, 150, 5, index, Interface);
		index++;// Glow
		setBounds(27005, 155, 10, index, Interface);
		index++;// Icon
		// 2nd Row
		addPrayer(27008, 0, 86, 58, 18, "Berserker", 22552);
		setBounds(27008, 2, 45, index, Interface);
		index++;// Glow
		setBounds(27009, 9, 48, index, Interface);
		index++;// Icon
		addPrayer(27006, 0, 87, 61, 15, "Deflect Summoning", 22554);
		setBounds(27006, 39, 45, index, Interface);
		index++;// Glow
		setBounds(27007, 42, 47, index, Interface);
		index++;// Icon
		addPrayer(27010, 0, 88, 64, 17, "Deflect Magic", 22556);
		setBounds(27010, 76, 45, index, Interface);
		index++;// Glow
		setBounds(27011, 79, 48, index, Interface);
		index++;// Icon
		addPrayer(27012, 0, 89, 67, 16, "Deflect Missiles", 22558);
		setBounds(27012, 113, 45, index, Interface);
		index++;// Glow
		setBounds(27013, 116, 48, index, Interface);
		index++;// Icon
		addPrayer(22521, 0, 90, 70, 6, "Deflect Melee", 22560);
		setBounds(22521, 151, 45, index, Interface);
		index++;// Glow
		setBounds(22522, 154, 48, index, Interface);
		index++;// Icon
		// 3rd Row
		addPrayer(22523, 0, 91, 73, 9, "Leech Attack", 22562);
		setBounds(22523, 2, 82, index, Interface);
		index++;// Glow
		setBounds(22524, 6, 86, index, Interface);
		index++;// Icon
		addPrayer(22525, 0, 103, 75, 10, "Leech Ranged", 22564);
		setBounds(22525, 40, 82, index, Interface);
		index++;// Glow
		setBounds(22526, 44, 86, index, Interface);
		index++;// Icon
		addPrayer(22527, 0, 104, 77, 11, "Leech Magic", 22566);
		setBounds(22527, 77, 82, index, Interface);
		index++;// Glow
		setBounds(22528, 79, 86, index, Interface);
		index++;// Icon
		addPrayer(22529, 0, 92, 79, 12, "Leech Defence", 22568);
		setBounds(22529, 114, 83, index, Interface);
		index++;// Glow
		setBounds(22530, 119, 87, index, Interface);
		index++;// Icon
		addPrayer(22531, 0, 93, 81, 13, "Leech Strength", 22570);
		setBounds(22531, 153, 83, index, Interface);
		index++;// Glow
		setBounds(22532, 156, 86, index, Interface);
		index++;// Icon
		// Bottom Row
		addPrayer(22533, 0, 94, 83, 14, "Leech Energy", 22572);
		setBounds(22533, 2, 120, index, Interface);
		index++;// Glow
		setBounds(22534, 7, 125, index, Interface);
		index++;// Icon
		addPrayer(22535, 0, 95, 85, 19, "Leech Special Attack", 22574);
		setBounds(22535, 40, 120, index, Interface);
		index++;// Glow
		setBounds(22536, 45, 124, index, Interface);
		index++;// Icon
		addPrayer(22537, 0, 96, 88, 1, "Wrath", 22576);
		setBounds(22537, 78, 120, index, Interface);
		index++;// Glow
		setBounds(22538, 86, 124, index, Interface);
		index++;// Icon
		addPrayer(22539, 0, 97, 91, 8, "Soul Split", 22578);
		setBounds(22539, 114, 120, index, Interface);
		index++;// Glow
		setBounds(22540, 120, 125, index, Interface);
		index++;// Icon
		addPrayer(22541, 0, 105, 94, 0, "Turmoil", 22580);
		setBounds(22541, 151, 120, index, Interface);
		index++;// Glow
		setBounds(22542, 153, 127, index, Interface);
		index++;// Icon
		// Prayer Icon/Text
		addSprite(22502, 0, "Curses/ICON");
		setBounds(22501, 85, 241, index, Interface);
		index++;// Text
		setBounds(22502, 65, 241, index, Interface);
		index++;// Icon
		// Tooltips/Hover Boxes
		addTooltipC(22543,
				"Level 50\nProtect Item\nKeep 1 extra item if you die", 100,
				150);
		addTooltipC(
				22544,
				"Level 50\nSap Warrior\nDrains 10% of enemy Attack,\nStrength and Defence,\nincreasing to 20% over time",
				100, 150);
		addTooltipC(
				22546,
				"Level 52\nSap Ranger\nDrains 10% of enemy Ranged\nand Defence, increasing to 20%\nover time",
				100, 175);
		addTooltipC(
				22548,
				"Level 54\nSap Mage\nDrains 10% of enemy Magic\nand Defence, increasing to 20%\nover time",
				100, 175);
		addTooltipC(22550,
				"Level 56\nSap Spirit\nDrains enenmy special attack\nenergy",
				100, 175);
		addTooltipC(22552,
				"Level 59\nBerserker\nBoosted stats last 15% longer", 100, 175);
		addTooltipC(
				22554,
				"Level 62\nDeflect Summoning\nReduces damage dealt from\nSummoning scrolls, prevents the\nuse of a familiar's special\nattack, and can deflect some of\ndamage back to the attacker",
				125, 175);
		addTooltipC(
				22556,
				"Level 65\nDeflect Magic\nProtects against magical attacks\nand can deflect some of the\ndamage back to the attacker",
				100, 175);
		addTooltipC(
				22558,
				"Level 68\nDeflect Missiles\nProtects against ranged attacks\nand can deflect some of the\ndamage back to the attacker",
				100, 175);
		addTooltipC(
				22560,
				"Level 71\nDeflect Melee\nProtects against melee attacks\nand can deflect some of the\ndamage back to the attacker",
				100, 175);
		addTooltipC(
				22562,
				"Level 74\nLeech Attack\nBoosts Attack by 5%, increasing\nto 10% over time, while draining\nenemy Attack by 10%,\nincreasing to 25% over time",
				100, 175);
		addTooltipC(
				22564,
				"Level 76\nLeech Ranged\nBoosts Ranged by 5%, increasing\nto 10% over time,\nwhile draining enemy Ranged by\n10%, increasing to 25% over\ntime",
				113, 175);
		addTooltipC(
				22566,
				"Level 78\nLeech Magic\nBoosts Magic by 5%, increasing\nto 10% over time, while draining\nenemy Magic by 10%, increasing\nto 25% over time",
				100, 175);
		addTooltipC(
				22568,
				"Level 80\nLeech Defence\nBoosts Defence by 5%, increasing\nto 10% over time,\nwhile draining enemy Defence by\n10%, increasing to 25% over\ntime",
				113, 180);
		addTooltipC(
				22570,
				"Level 82\nLeech Strength\nBoosts Strength by 5%, increasing\nto 10% over time,\nwhile draining enemy Strength by\n10%, increasing to 25% over\ntime",
				113, 180);
		addTooltipC(
				22572,
				"Level 84\nLeech Energy\nDrains enemy run energy, while\nincreasing your own",
				113, 180);
		addTooltipC(
				22574,
				"Level 86\nLeech Special Attack\nDrains enemy special attack\nenergy, while increasing your\nown",
				113, 180);
		addTooltipC(
				22576,
				"Level 89\nWrath\nInflicts damage to nearby\ntargets if you die",
				113, 180);
		addTooltipC(
				22578,
				"Level 92\nSoul Split\n1/4 of damage dealt is\nalso removed from\nopponent's Prayer and added to\nyour Hitpoints",
				113, 180);
		addTooltipC(
				22580,
				"Level 95\nTurmoil\nIncreases Attack and Defence\nby 15%, plus 15% of enemy's\nlevel, and Strength by 23% plus\n10% of enemy's level",
				113, 180);
		setBounds(22543, 10, 40, index, Interface);
		index++;
		setBounds(22544, 20, 40, index, Interface);
		index++;
		setBounds(22546, 20, 40, index, Interface);
		index++;
		setBounds(22548, 20, 40, index, Interface);
		index++;
		setBounds(22550, 20, 40, index, Interface);
		index++;
		setBounds(22552, 10, 80, index, Interface);
		index++;
		setBounds(22554, 10, 80, index, Interface);
		index++;
		setBounds(22556, 10, 80, index, Interface);
		index++;
		setBounds(22558, 10, 80, index, Interface);
		index++;
		setBounds(22560, 10, 80, index, Interface);
		index++;
		setBounds(22562, 10, 120, index, Interface);
		index++;
		setBounds(22564, 10, 120, index, Interface);
		index++;
		setBounds(22566, 10, 120, index, Interface);
		index++;
		setBounds(22568, 5, 120, index, Interface);
		index++;
		setBounds(22570, 5, 120, index, Interface);
		index++;
		setBounds(22572, 10, 160, index, Interface);
		index++;
		setBounds(22574, 10, 160, index, Interface);
		index++;
		setBounds(22576, 10, 160, index, Interface);
		index++;
		setBounds(22578, 10, 160, index, Interface);
		index++;
		setBounds(22580, 10, 160, index, Interface);
		index++;
	}

	// AddClickableText(11203, "Number 2", "Label", wid, 1, 0xFFA500, 63, 20);
	public static void AddClickableText(int id, String text, String tooltip,
			TextDrawingArea tda[], int idx, int color, int width, int height) {
		RSInterface tab = addTabInterface(id);
		tab.parentID = id;
		tab.id = id;
		tab.type = 4;
		tab.atActionType = 1;
		tab.width = width;
		tab.height = height;
		tab.contentType = 0;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = -1;
		tab.textDrawingAreas = tda[idx];
		tab.message = text;
		tab.aString228 = "";
		tab.textColor = color;
		tab.anInt219 = 0;
		tab.anInt216 = 0xffffff;
		tab.anInt239 = 0;
		tab.tooltip = tooltip;
	}

	public static void topPK(TextDrawingArea[] wid) {
		RSInterface inttopPK = addTabInterface(11200);
		inttopPK.children = new int[16];
		inttopPK.childX = new int[16];
		inttopPK.childY = new int[16];
		// Main interface
		inttopPK.children[0] = 11201;
		inttopPK.childX[0] = 4;
		inttopPK.childY[0] = 16;
		// No main interface image.
		// Control 1 of main interface (Image)
		inttopPK.children[1] = 11202;
		inttopPK.childX[1] = 4;
		inttopPK.childY[1] = 16;
		addSprite(11202, 0, "BLOOD");
		// Control 2 of main interface (ClickableLabel)
		inttopPK.children[2] = 11203;
		inttopPK.childX[2] = 215;
		inttopPK.childY[2] = 130;
		AddClickableText(11203, "Number 2", "Label", wid, 1, 0xFFA500, 63, 20);
		// Control 3 of main interface (ClickableLabel)
		inttopPK.children[3] = 11204;
		inttopPK.childX[3] = 215;
		inttopPK.childY[3] = 149;
		AddClickableText(11204, "Number 3", "Label", wid, 1, 0xFFA500, 62, 20);
		// Control 4 of main interface (ClickableLabel)
		inttopPK.children[4] = 11205;
		inttopPK.childX[4] = 215;
		inttopPK.childY[4] = 168;
		AddClickableText(11205, "Number 4", "Label", wid, 1, 0xFFA500, 62, 20);
		// Control 5 of main interface (ClickableLabel)
		inttopPK.children[5] = 11206;
		inttopPK.childX[5] = 215;
		inttopPK.childY[5] = 186;
		AddClickableText(11206, "Number 5", "Label", wid, 1, 0xFFA500, 62, 20);
		// Control 6 of main interface (ClickableLabel)
		inttopPK.children[6] = 11207;
		inttopPK.childX[6] = 215;
		inttopPK.childY[6] = 204;
		AddClickableText(11207, "Number 6", "Label", wid, 1, 0xFFA500, 63, 20);
		// Control 7 of main interface (ClickableLabel)
		inttopPK.children[7] = 11208;
		inttopPK.childX[7] = 215;
		inttopPK.childY[7] = 221;
		AddClickableText(11208, "Number 7", "Label", wid, 1, 0xFFA500, 61, 20);
		// Control 8 of main interface (ClickableLabel)
		inttopPK.children[8] = 11209;
		inttopPK.childX[8] = 215;
		inttopPK.childY[8] = 239;
		AddClickableText(11209, "Number 8", "Label", wid, 1, 0xFFA500, 63, 20);
		// Control 9 of main interface (ClickableLabel)
		inttopPK.children[9] = 11210;
		inttopPK.childX[9] = 215;
		inttopPK.childY[9] = 256;
		AddClickableText(11210, "Number 9", "Label", wid, 1, 0xFFA500, 63, 20);
		// Control 10 of main interface (ClickableLabel)
		inttopPK.children[10] = 11211;
		inttopPK.childX[10] = 215;
		inttopPK.childY[10] = 273;
		AddClickableText(11211, "Number 10", "Label", wid, 1, 0xFFA500, 69, 20);
		// Control 11 of main interface (Image)
		inttopPK.children[11] = 11212;
		inttopPK.childX[11] = 102;
		inttopPK.childY[11] = 26;
		addSprite(11212, 0, "TOP");
		// Control 12 of main interface (ClickableLabel)
		inttopPK.children[12] = 11213;
		inttopPK.childX[12] = 215;
		inttopPK.childY[12] = 110;
		AddClickableText(11213, "Number 1", "Label", wid, 1, 0xFFA500, 61, 20);
		// Control 13 of main interface (ClickableLabel)
		inttopPK.children[13] = 11214;
		inttopPK.childX[13] = 215;
		inttopPK.childY[13] = 110;
		AddClickableText(11214, "Number 1", "Label", wid, 1, 0xFFA500, 61, 20);
		inttopPK.children[14] = 11215;
		inttopPK.childX[14] = 1;
		inttopPK.childY[14] = 1;
		addHButton(11215, "Close", 0, 16, 16, "Close Button", 14513, 3, 1);
		inttopPK.children[15] = 11216;
		inttopPK.childX[15] = 215;
		inttopPK.childY[15] = 290;
		AddClickableText(11216, "Number 10", "Label", wid, 1, 0xFFA500, 69, 20);
	}

	public static void NRInfo(TextDrawingArea[] TDA) {
		RSInterface intNRInfo = addTabInterface(20000);
		intNRInfo.children = new int[9];
		intNRInfo.childX = new int[9];
		intNRInfo.childY = new int[9];
		// Main interface
		intNRInfo.children[0] = 20001;
		intNRInfo.childX[0] = 4;
		intNRInfo.childY[0] = 16;
		// AddInterfaceImage(20001, "NRInfo", "achievetip.png");
		addSprite(20001, 0, "NRINFO");
		// Control 1 of main interface (Label)
		intNRInfo.children[1] = 20002;
		intNRInfo.childX[1] = 90;
		intNRInfo.childY[1] = 22;
		// AddInterfaceLabel(20002, "Rune Republic Achievements", wid, 1,
		// 0xFFA500);
		addText(20002, "Rune Republic", 0xFFA500, false, true, 1,
				TDA, 0);
		// Control 2 of main interface (Labael)
		intNRInfo.children[2] = 20003;
		intNRInfo.childX[2] = 25;
		intNRInfo.childY[2] = 66;
		addText(20003, "Unbelievable", 0xFFA500, false, true, 1, TDA, 0);
		// AddInterfaceLabel(20003, , wid, 1, 0xFFA500);
		// Control 3 of main interface (Label)
		intNRInfo.children[3] = 20004;
		intNRInfo.childX[3] = 25;
		intNRInfo.childY[3] = 101;
		// AddInterfaceLabel(20004, "Kill 3 people in //n2 mins", wid, 1,
		// 0xFFA500);
		addText(20004, "Kill 3 people in //n2 mins", 0xFFA500, false, true, 1,
				TDA, 0);
		// Control 4 of main interface (Label)
		intNRInfo.children[4] = 20005;
		intNRInfo.childX[4] = 136;
		intNRInfo.childY[4] = 156;
		// AddInterfaceLabel(20005, "Completed?", wid, 1, 0xFFA500);
		addText(20005, "@red@Completed", 0xFFA500, false, true, 2, TDA, 0);
		// Control 5 of main interface (Label)
		intNRInfo.children[5] = 20006;
		intNRInfo.childX[5] = 136;
		intNRInfo.childY[5] = 176;
		// AddInterfaceLabel(20006, "KBD - 0/100", wid, 1, 0xFFA500);
		addText(20006, "KBF - 0 / 100", 0xFFA500, false, true, 1, TDA, 0);
		// Control 6 of main interface (Label)
		intNRInfo.children[6] = 20007;
		intNRInfo.childX[6] = 136;
		intNRInfo.childY[6] = 196;
		// AddInterfaceLabel(20007, "Red - 0 / 100", wid, 1, 0xFFA500);
		addText(20007, "Red - 0 / 100", 0xFFA500, false, true, 1, TDA, 0);
		// Control 7 of main interface (Label)
		intNRInfo.children[7] = 20008;
		intNRInfo.childX[7] = 136;
		intNRInfo.childY[7] = 216;
		// AddInterfaceLabel(20008, "test - 0 / 100", wid, 1, 0xFFA500);
		addText(20008, "test - 0 / 100", 0xFFA500, false, true, 1, TDA, 0);
		intNRInfo.children[8] = 20009;
		intNRInfo.childX[8] = 6;
		intNRInfo.childY[8] = 20;
		addHButton(20009, "Close", 0, 16, 16, "Close Button", 14513, 1, 1);
	}

	public static void questTab(TextDrawingArea[] TDA) {
		RSInterface Interface = addTabInterface(638);
		setChildren(7, Interface);
		addText(19155, "Character Info", 0xFF981F, false, true, 52, TDA, 2);
		addButton(19156, 1, "Bank/QUEST", "Achievement Diary");
		addSprite(19157, 0, "Bank/QUEST");
		addSprite(19158, 4, "Bank/QUEST");
		addText(19159, "PK Points", 0xFF981F, false, true, 52, TDA, 0);
		setBounds(19155, 4, 2, 0, Interface);
		setBounds(19156, 170, 2, 1, Interface);
		setBounds(19157, 0, 24, 2, Interface);
		setBounds(19158, 0, 22, 3, Interface);
		setBounds(19158, 0, 242, 4, Interface);
		setBounds(19159, 4, 246, 5, Interface);
		setBounds(19160, 0, 24, 6, Interface);
		Interface = addTabInterface(19160);
		Interface.scrollMax = 1700;
		Interface.height = 218;
		Interface.width = 174;
		setChildren(107, Interface);
		addText(19161, "Player Kills", 0xFF981F, false, true, 52, TDA, 2);
		addText(19162, "None", 0xFF0000, false, true, -1, TDA, 1, 0xFFFFFF);
		addText(19163, "Player Deaths", 0xFF981F, false, true, 52, TDA, 2);
		addText(19164, "None", 0xFF0000, false, true, -1, TDA, 1, 0xFFFFFF);
		addText(19165, "Player K/D Ratio", 0xFF981F, false, true, 52, TDA, 2);
		addText(19166, "None", 0xFF0000, false, true, -1, TDA, 1, 0xFFFFFF);
		setBounds(19161, 4, 4, 0, Interface);
		setBounds(19162, 8, 20, 1, Interface);
		setBounds(19163, 4, 35, 2, Interface);
		setBounds(19164, 8, 51, 3, Interface);
		setBounds(19165, 4, 67, 4, Interface);
		setBounds(19166, 8, 83, 5, Interface);
		setBounds(663, 4, 99, 6, Interface);
		int Y = 115;
		int frame = 7;
		for (int i = 16026; i <= 16125; i++) {
			addText(i, "Rune Republic", 0xFF0000, false, true, -1,
					TDA, 2, 0xFFFFFF);
			setBounds(i, 8, Y, frame, Interface);
			frame++;
			Y += 15;
			Y++;
		}
		Interface = addTabInterface(19265);
		try {
			setChildren(6, Interface);
			addText(19266, "Achievements", 0xFF981F, false, true, -1, TDA, 2);
			addButton(19267, 2, "Bank/QUEST", "Quest Diary");
			addSprite(19269, 0, "Bank/QUEST");
			addSprite(19296, 4, "Bank/QUEST");
			setBounds(19266, 4, 2, 0, Interface);
			setBounds(19267, 170, 2, 1, Interface);
			setBounds(19269, 0, 24, 2, Interface);
			setBounds(19296, 0, 22, 3, Interface);
			setBounds(19296, 0, 242, 4, Interface);
			setBounds(19268, 0, 24, 5, Interface);
			Interface = addTabInterface(19268);
			Interface.height = 218;
			Interface.width = 174;
			Interface.scrollMax = 500;
			setChildren(27, Interface);
			addText(19300, "Free Play Tasks", 0xFF981F, false, true, -1, TDA, 2);
			addText(19270, "Lumbridge/Draynor", 0x00FF00, false, true, -1, TDA,
					0);
			addText(19271, "Easy", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			addText(19272, "Medium", 0xFF0000, false, true, -1, TDA, 0,
					0xFFFFFF);
			addText(19273, "Hard", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			setBounds(19300, 12, 4, 0, Interface);
			setBounds(19270, 12, 20, 1, Interface);
			setBounds(19271, 18, 34, 2, Interface);
			setBounds(19272, 18, 48, 3, Interface);
			setBounds(19273, 18, 62, 4, Interface);
			addText(19274, "Members' Tasks", 0xFF981F, false, true, -1, TDA, 2);
			addText(19275, "Falador", 0x00FF00, false, true, -1, TDA, 0);
			addText(19276, "Easy", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			addText(19277, "Medium", 0xFF0000, false, true, -1, TDA, 0,
					0xFFFFFF);
			addText(19278, "Hard", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			setBounds(19274, 12, 80, 5, Interface);
			setBounds(19275, 12, 96, 6, Interface);
			setBounds(19276, 18, 110, 7, Interface);
			setBounds(19277, 18, 124, 8, Interface);
			setBounds(19278, 18, 138, 9, Interface);
			addText(19279, "Fremennik", 0x00FF00, false, true, -1, TDA, 0);
			addText(19280, "Easy", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			addText(19281, "Medium", 0xFF0000, false, true, -1, TDA, 0,
					0xFFFFFF);
			addText(19282, "Hard", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			setBounds(19279, 12, 167, 10, Interface);
			setBounds(19280, 18, 183, 11, Interface);
			setBounds(19281, 18, 197, 12, Interface);
			setBounds(19282, 18, 211, 13, Interface);
			addText(19283, "Karamja", 0x00FF00, false, true, -1, TDA, 0);
			addText(19284, "Easy", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			addText(19285, "Medium", 0xFF0000, false, true, -1, TDA, 0,
					0xFFFFFF);
			addText(19286, "Hard", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			setBounds(19283, 12, 237, 14, Interface);
			setBounds(19284, 18, 253, 15, Interface);
			setBounds(19285, 18, 267, 16, Interface);
			setBounds(19286, 18, 281, 17, Interface);
			addText(19287, "Seers Village", 0x00FF00, false, true, -1, TDA, 0);
			addText(19288, "Easy", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			addText(19289, "Medium", 0xFF0000, false, true, -1, TDA, 0,
					0xFFFFFF);
			addText(19290, "Hard", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			setBounds(19287, 12, 306, 18, Interface);
			setBounds(19288, 18, 322, 19, Interface);
			setBounds(19289, 18, 336, 20, Interface);
			setBounds(19290, 18, 350, 21, Interface);
			addText(19291, "Varrock", 0x00FF00, false, true, -1, TDA, 0);
			addText(19292, "Easy", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			addText(19293, "Medium", 0xFF0000, false, true, -1, TDA, 0,
					0xFFFFFF);
			addText(19294, "Hard", 0xFF0000, false, true, -1, TDA, 0, 0xFFFFFF);
			setBounds(19291, 12, 375, 22, Interface);
			setBounds(19292, 18, 391, 23, Interface);
			setBounds(19293, 18, 405, 24, Interface);
			setBounds(19294, 18, 419, 25, Interface);
			addText(19295, "More coming soon...", 0xFF0000, false, true, -1,
					TDA, 0, 0xFFFFFF);
			setBounds(19295, 12, 444, 26, Interface);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Trade(TextDrawingArea[] TDA) {
		RSInterface Interface = addTabInterface(3323);
		setChildren(15, Interface);
		addSprite(3324, 6, "Bank/TRADE");
		addHover(3442, 3, 0, 3325, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(3325, 2, "Bank/BANK", 17, 17, 3326);
		addText(3417, "Trading With:", 0xFF9933, true, true, 52, TDA, 2);
		addText(3418, "Trader's Offer", 0xFF9933, false, true, 52, TDA, 1);
		addText(3419, "Your Offer", 0xFF9933, false, true, 52, TDA, 1);
		addText(3421, "Accept", 0x00C000, true, true, 52, TDA, 1);
		addText(3423, "Decline", 0xC00000, true, true, 52, TDA, 1);
		addText(3431, "Waiting For Other Player", 0xFFFFFF, true, true, 52,
				TDA, 1);
		addHover(3420, 1, 0, 3327, 5, "Bank/TRADE", 65, 32, "Accept");
		addHovered(3327, 2, "Bank/TRADE", 65, 32, 3328);
		addHover(3422, 3, 0, 3329, 5, "Bank/TRADE", 65, 32, "Close Window");
		addHovered(3329, 2, "Bank/TRADE", 65, 32, 3330);
		setBounds(3324, 0, 16, 0, Interface);
		setBounds(3442, 485, 24, 1, Interface);
		setBounds(3325, 485, 24, 2, Interface);
		setBounds(3417, 258, 25, 3, Interface);
		setBounds(3418, 355, 51, 4, Interface);
		setBounds(3419, 68, 51, 5, Interface);
		setBounds(3420, 223, 120, 6, Interface);
		setBounds(3327, 223, 120, 7, Interface);
		setBounds(3422, 223, 160, 8, Interface);
		setBounds(3329, 223, 160, 9, Interface);
		setBounds(3421, 256, 127, 10, Interface);
		setBounds(3423, 256, 167, 11, Interface);
		setBounds(3431, 256, 272, 12, Interface);
		setBounds(3415, 12, 64, 13, Interface);
		setBounds(3416, 321, 64, 14, Interface);
		Interface = addTabInterface(3443);
		setChildren(15, Interface);
		addSprite(3444, 3, "Bank/TRADE");
		addButton(3546, 2, "Bank/SHOP", "Accept");
		addButton(3548, 2, "Bank/SHOP", "Decline");
		addText(3547, "Accept", 0x00C000, true, true, 52, TDA, 1);
		addText(3549, "Decline", 0xC00000, true, true, 52, TDA, 1);
		addText(3450, "Trading With:", 0x00FFFF, true, true, 52, TDA, 2);
		addText(3451, "Yourself", 0x00FFFF, true, true, 52, TDA, 2);
		setBounds(3444, 12, 20, 0, Interface);
		setBounds(3442, 470, 32, 1, Interface);
		setBounds(3325, 470, 32, 2, Interface);
		setBounds(3535, 130, 28, 3, Interface);
		setBounds(3536, 105, 47, 4, Interface);
		setBounds(3546, 189, 295, 5, Interface);
		setBounds(3548, 258, 295, 6, Interface);
		setBounds(3547, 220, 299, 7, Interface);
		setBounds(3549, 288, 299, 8, Interface);
		setBounds(3557, 71, 87, 9, Interface);
		setBounds(3558, 315, 87, 10, Interface);
		setBounds(3533, 64, 70, 11, Interface);
		setBounds(3534, 297, 70, 12, Interface);
		setBounds(3450, 95, 289, 13, Interface);
		setBounds(3451, 95, 304, 14, Interface);
	}

	public static void bloodlustMembers(TextDrawingArea[] wid) {
		RSInterface intbloodlustMembers = addTabInterface(14500);
		intbloodlustMembers.children = new int[12];
		intbloodlustMembers.childX = new int[12];
		intbloodlustMembers.childY = new int[12];
		// Main interface
		intbloodlustMembers.children[0] = 14501;
		intbloodlustMembers.childX[0] = 4;
		intbloodlustMembers.childY[0] = 16;
		addSprite(14501, 0, "BLOOD");
		// Control 1 of main interface (Label)
		intbloodlustMembers.children[1] = 14502;
		intbloodlustMembers.childX[1] = 207;
		intbloodlustMembers.childY[1] = 25;
		addText(14502, "Rune Republic", wid, 2, 0x32CD32, false, false);
		// Control 2 of main interface (Label)
		intbloodlustMembers.children[2] = 14503;
		intbloodlustMembers.childX[2] = 178;
		intbloodlustMembers.childY[2] = 83;
		addText(14503, "Team Name - *Name*", wid, 2, 0xFF0000, false, false);
		// Control 3 of main interface (Label)
		intbloodlustMembers.children[3] = 14504;
		intbloodlustMembers.childX[3] = 187;
		intbloodlustMembers.childY[3] = 103;
		addText(14504, "Team Leader -  *#1*", wid, 1, 0xFFA500, false, false);
		// Control 4 of main interface (Label)
		intbloodlustMembers.children[4] = 14505;
		intbloodlustMembers.childX[4] = 187;
		intbloodlustMembers.childY[4] = 123;
		addText(14505, "Team Member - *#7*", wid, 1, 0xFFA500, false, false);
		// Control 5 of main interface (Image)
		intbloodlustMembers.children[5] = 14506;
		intbloodlustMembers.childX[5] = 140;
		intbloodlustMembers.childY[5] = 25;
		addSprite(14506, 5, "BLOOD");
		// Control 6 of main interface (Label)
		intbloodlustMembers.children[6] = 14507;
		intbloodlustMembers.childX[6] = 187;
		intbloodlustMembers.childY[6] = 143;
		addText(14507, "Team Member - *#7*", wid, 1, 0xFFA500, false, false);
		// Control 7 of main interface (Label)
		intbloodlustMembers.children[7] = 14508;
		intbloodlustMembers.childX[7] = 187;
		intbloodlustMembers.childY[7] = 163;
		addText(14508, "Team Member - *#7*", wid, 1, 0xFFA500, false, false);
		// Control 8 of main interface (Label)
		intbloodlustMembers.children[8] = 14509;
		intbloodlustMembers.childX[8] = 187;
		intbloodlustMembers.childY[8] = 183;
		addText(14509, "Team Member - *#7*", wid, 1, 0xFFA500, false, false);
		// Control 9 of main interface (Label)
		intbloodlustMembers.children[9] = 14510;
		intbloodlustMembers.childX[9] = 187;
		intbloodlustMembers.childY[9] = 203;
		addText(14510, "Team Member - *#7*", wid, 1, 0xFFA500, false, false);
		// Control 10 of main interface (Label)
		intbloodlustMembers.children[10] = 14511;
		intbloodlustMembers.childX[10] = 187;
		intbloodlustMembers.childY[10] = 223;
		addText(14511, "Team Member - *#7*", wid, 1, 0xFFA500, false, false);
		intbloodlustMembers.children[11] = 14512;
		intbloodlustMembers.childX[11] = 3;
		intbloodlustMembers.childY[11] = 1;
		addHButton(14512, "close", 0, 16, 16, "Close Button", 14513, 3, 1);
	}

	public static void BloodLustTeams(TextDrawingArea[] wid) {
		RSInterface intBloodLustTeams = addTabInterface(12800);
		intBloodLustTeams.children = new int[17];
		intBloodLustTeams.childX = new int[17];
		intBloodLustTeams.childY = new int[17];
		// Main interface
		intBloodLustTeams.children[0] = 12801;
		intBloodLustTeams.childX[0] = 4;
		intBloodLustTeams.childY[0] = 16;
		addSprite(12801, 0, "BLOOD");
		// Control 1 of main interface (Label)
		intBloodLustTeams.children[1] = 12802;
		intBloodLustTeams.childX[1] = 207;
		intBloodLustTeams.childY[1] = 25;
		addText(12802, "Rune Republic", wid, 2, 0x32CD32, false, false);
		// Control 2 of main interface (Label)
		intBloodLustTeams.children[2] = 12803;
		intBloodLustTeams.childX[2] = 213;
		intBloodLustTeams.childY[2] = 83;
		addText(12803, "Team List", wid, 2, 0xB22222, false, false);
		// Control 3 of main interface (Label)
		intBloodLustTeams.children[3] = 12804;
		intBloodLustTeams.childX[3] = 187;
		intBloodLustTeams.childY[3] = 128;
		addText(12804, "Team Name - *Name*", wid, 1, 0xFFA500, false, false);
		// Control 4 of main interface (Label)
		intBloodLustTeams.children[4] = 12805;
		intBloodLustTeams.childX[4] = 180;
		intBloodLustTeams.childY[4] = 168;
		addText(12805, "Team Deaths *Deaths*", wid, 1, 0xFFA500, false, false);
		// Control 5 of main interface (Label)
		intBloodLustTeams.children[5] = 12806;
		intBloodLustTeams.childX[5] = 180;
		intBloodLustTeams.childY[5] = 188;
		addText(12806, "Team Rating - *Rating*", wid, 1, 0xFFA500, false, false);
		// Control 6 of main interface (Label)
		intBloodLustTeams.children[6] = 12807;
		intBloodLustTeams.childX[6] = 89;
		intBloodLustTeams.childY[6] = 208;
		// addText(14807,
		// "To View Members Of This Team Type ::showmembers *ID* ", wid, 1,
		// 0xFFA500, false, false);
		// Control 7 of main interface (Label)
		intBloodLustTeams.children[7] = 12808;
		intBloodLustTeams.childX[7] = 195;
		intBloodLustTeams.childY[7] = 148;
		addText(12808, "Team Kills - *Kills*", wid, 1, 0xFFA500, false, false);
		// Control 8 of main interface (Image)
		intBloodLustTeams.children[8] = 12809;
		intBloodLustTeams.childX[8] = 147;
		intBloodLustTeams.childY[8] = 25;
		addSprite(12809, 5, "BLOOD");
		// Control 9 of main interface (Button)
		intBloodLustTeams.children[9] = 12841;
		intBloodLustTeams.childX[9] = 106;
		intBloodLustTeams.childY[9] = 247;
		addButton(12841, 4, "Blood", "View Previous Team");
		// Control 10 of main interface (Label)
		intBloodLustTeams.children[10] = 12842;
		intBloodLustTeams.childX[10] = 106;
		intBloodLustTeams.childY[10] = 259;
		addText(12842, "Previous Team", wid, 2, 0xFFA500, false, false);
		// Control 11 of main interface (Label)
		intBloodLustTeams.children[11] = 12812;
		intBloodLustTeams.childX[11] = 213;
		intBloodLustTeams.childY[11] = 111;
		addText(12812, "Team ID -  *ID*", wid, 1, 0xFFA500, false, false);
		// Control 12 of main interface (Button)
		intBloodLustTeams.children[12] = 12814;
		intBloodLustTeams.childX[12] = 347;
		intBloodLustTeams.childY[12] = 247;
		addButton(12814, 4, "Blood", "View Next Team");
		// Control 13 of main interface (Label)
		intBloodLustTeams.children[13] = 12815;
		intBloodLustTeams.childX[13] = 360;
		intBloodLustTeams.childY[13] = 259;
		addText(12815, "Next Team", wid, 2, 0xFFA500, false, false);
		intBloodLustTeams.children[14] = 12818;
		intBloodLustTeams.childX[14] = 227;
		intBloodLustTeams.childY[14] = 247;
		addButton(12818, 4, "Blood", "View Members");

		// Control 14 of main interface (Label)
		intBloodLustTeams.children[15] = 12819;
		intBloodLustTeams.childX[15] = 227;
		intBloodLustTeams.childY[15] = 259;
		addText(12819, "Show Members", wid, 2, 0xFFA500, false, false);
		intBloodLustTeams.children[16] = 12020;
		intBloodLustTeams.childX[16] = 3;
		intBloodLustTeams.childY[16] = 1;
		addHButton(12020, "close", 0, 16, 16, "Close Button", 14021, 3, 1);
	}

	public static void bloodluststart(TextDrawingArea[] TDA) {
		RSInterface intbloodluststart = addTabInterface(14000);
		intbloodluststart.children = new int[11];
		intbloodluststart.childX = new int[11];
		intbloodluststart.childY = new int[11];
		// Main interface
		intbloodluststart.children[10] = 14011;
		intbloodluststart.childX[10] = 3;
		intbloodluststart.childY[10] = 1;
		addHButton(14011, "close", 0, 16, 16, "Close Button", 14012, 3, 1);
		intbloodluststart.children[0] = 14001;
		intbloodluststart.childX[0] = 4;
		intbloodluststart.childY[0] = 16;
		addSprite(14001, 0, "BLOOD");
		// Control 1 of main interface (Image)
		intbloodluststart.children[1] = 14002;
		intbloodluststart.childX[1] = 98;
		intbloodluststart.childY[1] = 41;
		addSprite(14002, 2, "BLOOD");
		// Control 2 of main interface (Image)
		intbloodluststart.children[2] = 14003;
		intbloodluststart.childX[2] = 390;
		intbloodluststart.childY[2] = 125;
		addSprite(14003, 1, "BLOOD");
		// Control 3 of main interface (Image)
		intbloodluststart.children[3] = 14004;
		intbloodluststart.childX[3] = 16;
		intbloodluststart.childY[3] = 125;
		addSprite(14004, 3, "BLOOD");
		// Control 4 of main interface (TextButton)
		intbloodluststart.children[4] = 14005;
		intbloodluststart.childX[4] = 214;
		intbloodluststart.childY[4] = 194;
		// Control 5B of main interface (TextButton)
		intbloodluststart.children[5] = 14006;
		intbloodluststart.childX[5] = 223;
		intbloodluststart.childY[5] = 205;
		addText(14006, "Join Team", TDA, 2, 0x00FF00, false, false);
		addButton(14005, 4, "Blood", "Join Team");
		// Control 6 of main interface (TextButton)
		intbloodluststart.children[6] = 14007;
		intbloodluststart.childX[6] = 214;
		intbloodluststart.childY[6] = 138;
		// Control 7B of main interface (TextButton)
		intbloodluststart.children[7] = 14008;
		intbloodluststart.childX[7] = 218;
		intbloodluststart.childY[7] = 149;
		addText(14008, "Show Teams", TDA, 2, 0xDCDCDC, false, false);
		addButton(14007, 4, "Blood", "Show Team");
		// Control 8 of main interface (TextButton)
		intbloodluststart.children[8] = 14009;
		intbloodluststart.childX[8] = 214;
		intbloodluststart.childY[8] = 249;
		// Control 9B of main interface (TextButton)
		intbloodluststart.children[9] = 14010;
		intbloodluststart.childX[9] = 219;
		intbloodluststart.childY[9] = 260;
		addText(14010, "Leave Team", TDA, 2, 0xFF0000, false, false);
		;
		addButton(14009, 4, "Blood", "Leave Team");
		;
	}

	public static void Shop(TextDrawingArea[] TDA) {
		RSInterface Interface = addTabInterface(3824);
		setChildren(8, Interface);
		addSprite(3825, 0, "Bank/SHOP");
		addHover(3902, 3, 0, 3826, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(3826, 2, "Bank/BANK", 17, 17, 3827);
		addText(19679, "Main Stock", 0xFF981F, false, true, 52, TDA, 1);// 3628////19679
		addText(19680, "Store Info", 0xBF751D, false, true, 52, TDA, 1);// 3629//19680
		addButton(19681, 2, "Bank/SHOP", "Store Information");// 3630//19681
		setBounds(3825, 12, 12, 0, Interface);
		setBounds(3902, 471, 22, 1, Interface);
		setBounds(3826, 471, 22, 2, Interface);
		setBounds(3900, 60, 85, 3, Interface);
		setBounds(3901, 240, 21, 4, Interface);
		setBounds(19679, 42, 54, 5, Interface);
		setBounds(19680, 150, 54, 6, Interface);
		setBounds(19681, 129, 50, 7, Interface);
		Interface = interfaceCache[3900];
		Interface.invSpritePadX = 8;
		Interface.width = 10;
		Interface.height = 4;
		Interface.invSpritePadY = 19;
		Interface = addTabInterface(19682);
		addSprite(19683, 1, "Bank/SHOP");
		addText(19684, "Main Stock", 0xBF751D, false, true, 52, TDA, 1);
		addText(19685, "Store Info", 0xFF981F, false, true, 52, TDA, 1);
		addButton(19686, 2, "Bank/SHOP", "Main Stock");
		setChildren(7, Interface);
		setBounds(19683, 12, 12, 0, Interface);
		setBounds(3901, 240, 21, 1, Interface);
		setBounds(19684, 42, 54, 2, Interface);
		setBounds(19685, 150, 54, 3, Interface);
		setBounds(19686, 23, 50, 4, Interface);
		setBounds(3902, 471, 22, 5, Interface);
		setBounds(3826, 60, 85, 6, Interface);
	}

	public static void Bank() {
		// int interfaceID, int actionType, int hoverid, int spriteId, String
		// NAME, int Width, int Height, String Tooltip, int hoverId2, int
		// hoverSpriteId, String hoverSpriteName, int hoverId3, String
		// hoverDisabledText, int X, int Y){
		RSInterface Interface = addTabInterface(5292);
		setChildren(19, Interface);
		addSprite(5293, 0, "Bank/BANK");
		setBounds(5293, 13, 13, 0, Interface);
		addHover(5384, 3, 0, 5380, 1, "Bank/BANK", 17, 17, "Close Window");
		addHovered(5380, 2, "Bank/BANK", 17, 17, 5379);
		setBounds(5384, 476, 16, 3, Interface);
		setBounds(5380, 476, 16, 4, Interface);
		addHover(5294, 4, 0, 5295, 88, "Bank/BANK", 1, 1, "Set A Bank PIN");
		addHovered(5295, 4, "Bank/BANK", 114, 25, 5296);
		setBounds(5294, 110, 285, 5, Interface);
		setBounds(5295, 110, 285, 6, Interface);
		addBankHover(21000, 4, 21001, 5, 8, "Bank/BANK", 35, 25, 304, 1,
				"Swap Withdraw Mode", 21002, 7, 6, "Bank/BANK", 21003,
				"Switch to insert items \nmode",
				"Switch to swap items \nmode.", 12, 20);
		setBounds(21000, 25, 285, 7, Interface);
		setBounds(21001, 10, 225, 8, Interface);
		addBankHover(21004, 4, 21005, 34, 33, "Bank/BANK", 1, 1, 0, 1,
				"Search", 21006, 14, 16, "Bank/BANK", 21007,
				"Click here to search your \nbank",
				"Click here to search your \nbank", 12, 20);
		setBounds(21004, 65, 285, 9, Interface);
		setBounds(21005, 50, 225, 10, Interface);
		addBankHover(21008, 4, 21009, 9, 11, "Bank/BANK", 35, 25, 115, 1,
				"Notes", 21010, 10, 12, "Bank/BANK", 21011,
				"Switch to note withdrawal \nmode",
				"Switch to item withdrawal \nmode", 12, 20);
		setBounds(21008, 240, 285, 11, Interface);
		setBounds(21009, 225, 225, 12, Interface);
		addBankHover1(21012, 5, 21013, 17, "Bank/BANK", 35, 25,
				"Deposit carried tems", 21014, 18, "Bank/BANK", 21015,
				"Empty your backpack into\nyour bank", 0, 20);
		setBounds(21012, 375, 285, 13, Interface);
		setBounds(21013, 360, 225, 14, Interface);
		addBankHover1(21016, 5, 21017, 19, "Bank/BANK", 35, 25,
				"Deposit worn items", 21018, 20, "Bank/BANK", 21019,
				"Empty the items your are\nwearing into your bank", 0, 20);
		setBounds(21016, 415, 285, 15, Interface);
		setBounds(21017, 400, 225, 16, Interface);
		addBankHover1(21020, 5, 21021, 40, "Bank/BANK", 1, 1, "", 21022, 22,
				"Bank/BANK", 21023, "", 0, 20);
		setBounds(21020, 455, 285, 17, Interface);
		setBounds(21021, 440, 225, 18, Interface);
		setBounds(5383, 170, 15, 1, Interface);
		setBounds(5385, -4, 74, 2, Interface);
		Interface = interfaceCache[5385];
		Interface.height = 206;
		Interface.width = 480;
		Interface = interfaceCache[5382];
		Interface.width = 10;
		Interface.invSpritePadX = 12;
		Interface.height = 35;
	}

	public static void itemsKeptOnDeath(TextDrawingArea[] tda) {
		RSInterface t = addTabInterface(18100);
		RSInterface scroll = addTabInterface(18111);
		addSprite(18101, 0, "interBack");
		addHButton(18102, "close", 0, 16, 16, "Close Button", 18103, 3, 1);
		addText(18105, "Items Kept on Death", tda, 2, 0xff981f, true, true);
		addText(18106, "Items you will keep on death (if not skulled):", tda,
				1, 0xff981f, false, true);
		addText(18107, "Items you will lose on death (if not skulled):", tda,
				1, 0xff981f, false, true);
		addText(18108, "Information:", tda, 1, 0xff981f, false, true);
		addText(18109, "Max Items Kept on death:", tda, 1, 0xffcc33, false,
				true);
		addText(18110, "~ null ~", tda, 1, 0xffcc33, true, true);

		t.totalChildren(12);
		t.child(0, 18101, 7, 8);
		t.child(1, 18102, 480, 17);
		t.child(2, 18103, 480, 17);
		t.child(3, 18105, 255, 23);
		t.child(4, 18106, 22, 48);
		t.child(5, 18107, 22, 108);
		t.child(6, 18108, 347, 47);
		t.child(7, 18109, 349, 270);
		t.child(8, 18110, 398, 298);
		t.child(9, 18111, 348, 64); // Scrollbar
		t.child(10, 10494, 26, 74);
		t.child(11, 10600, 26, 133);
		/**
		 * Scroll Interface
		 **/
		for (int i = 18112; i <= 18132; i++) {
			addText(i, "Line id: " + i + "", tda, 0, 0xff981f, false, false);
		}
		scroll.totalChildren(21);
		int Id = 0;
		int y = 2;
		for (int i = 18112; i <= 18132; i++) {
			scroll.child(Id, i, 1, y);
			Id++;
			y += 12;
		}
		scroll.scrollMax = 280;
		scroll.width = 130;
		scroll.height = 197;
	}

	public static void KillCount(TextDrawingArea[] wid) {
		RSInterface KC = addTabInterface(18050);
		KC.children = new int[9];
		KC.childX = new int[9];
		KC.childY = new int[9];
		KC.children[0] = 18051;
		KC.childX[0] = 395;
		KC.childY[0] = 20;
		addText(18051, "Killcounts", wid, 0, 0xFF9040, true, true);
		KC.children[1] = 18052;
		KC.childX[1] = 370;
		KC.childY[1] = 35;
		addText(18052, "Armadyl Kills:", wid, 0, 0xFF9040, true, true);
		KC.children[2] = 18053;
		KC.childX[2] = 370;
		KC.childY[2] = 50;
		addText(18053, "Bandos Kills:", wid, 0, 0xFF9040, true, true);
		KC.children[3] = 18054;
		KC.childX[3] = 370;
		KC.childY[3] = 65;
		addText(18054, "Saradomin Kills: ", wid, 0, 0xFF9040, true, true);
		KC.children[4] = 18055;
		KC.childX[4] = 370;
		KC.childY[4] = 80;
		addText(18055, "Zamorak Kills:", wid, 0, 0xFF9040, true, true);
		KC.children[5] = 18056;
		KC.childX[5] = 470;
		KC.childY[5] = 35;
		addText(18056, "0", wid, 0, 0x00FFFF, true, true);
		KC.children[6] = 18057;
		KC.childX[6] = 470;
		KC.childY[6] = 50;
		addText(18057, "0", wid, 0, 0x00FFFF, true, true);
		KC.children[7] = 18058;
		KC.childX[7] = 470;
		KC.childY[7] = 65;
		addText(18058, "0", wid, 0, 0x00FFFF, true, true);
		KC.children[8] = 18059;
		KC.childX[8] = 470;
		KC.childY[8] = 80;
		addText(18059, "0", wid, 0, 0x00FFFF, true, true);
	}

	public static void addBankHover(int interfaceID, int actionType,
			int hoverid, int spriteId, int spriteId2, String NAME, int Width,
			int Height, int configFrame, int configId, String Tooltip,
			int hoverId2, int hoverSpriteId, int hoverSpriteId2,
			String hoverSpriteName, int hoverId3, String hoverDisabledText,
			String hoverEnabledText, int X, int Y) {
		RSInterface hover = addTabInterface(interfaceID);
		hover.id = interfaceID;
		hover.parentID = interfaceID;
		hover.type = 5;
		hover.atActionType = actionType;
		hover.contentType = 0;
		hover.aByte254 = 0;
		hover.mOverInterToTrigger = hoverid;
		hover.sprite1 = imageLoader(spriteId, NAME);
		hover.sprite2 = imageLoader(spriteId2, NAME);
		hover.width = Width;
		hover.tooltip = Tooltip;
		hover.height = Height;
		hover.anIntArray245 = new int[1];
		hover.anIntArray212 = new int[1];
		hover.anIntArray245[0] = 1;
		hover.anIntArray212[0] = configId;
		hover.valueIndexArray = new int[1][3];
		hover.valueIndexArray[0][0] = 5;
		hover.valueIndexArray[0][1] = configFrame;
		hover.valueIndexArray[0][2] = 0;
		hover = addTabInterface(hoverid);
		hover.parentID = hoverid;
		hover.id = hoverid;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width = 550;
		hover.height = 334;
		hover.isMouseoverTriggered = true;
		hover.mOverInterToTrigger = -1;
		addSprite(hoverId2, hoverSpriteId, hoverSpriteId2, hoverSpriteName,
				configId, configFrame);
		addHoverBox(hoverId3, interfaceID, hoverDisabledText, hoverEnabledText,
				configId, configFrame);
		setChildren(2, hover);
		setBounds(hoverId2, 15, 60, 0, hover);
		setBounds(hoverId3, X, Y, 1, hover);
	}

	public static void addBankHover1(int interfaceID, int actionType,
			int hoverid, int spriteId, String NAME, int Width, int Height,
			String Tooltip, int hoverId2, int hoverSpriteId,
			String hoverSpriteName, int hoverId3, String hoverDisabledText,
			int X, int Y) {
		RSInterface hover = addTabInterface(interfaceID);
		hover.id = interfaceID;
		hover.parentID = interfaceID;
		hover.type = 5;
		hover.atActionType = actionType;
		hover.contentType = 0;
		hover.aByte254 = 0;
		hover.mOverInterToTrigger = hoverid;
		hover.sprite1 = imageLoader(spriteId, NAME);
		hover.width = Width;
		hover.tooltip = Tooltip;
		hover.height = Height;
		hover = addTabInterface(hoverid);
		hover.parentID = hoverid;
		hover.id = hoverid;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width = 550;
		hover.height = 334;
		hover.isMouseoverTriggered = true;
		hover.mOverInterToTrigger = -1;
		addSprite(hoverId2, hoverSpriteId, hoverSpriteId, hoverSpriteName, 0, 0);
		addHoverBox(hoverId3, interfaceID, hoverDisabledText,
				hoverDisabledText, 0, 0);
		setChildren(2, hover);
		setBounds(hoverId2, 15, 60, 0, hover);
		setBounds(hoverId3, X, Y, 1, hover);
	}

	public static void addHoverBox(int id, int ParentID, String text,
			String text2, int configId, int configFrame) {
		RSInterface rsi = addTabInterface(id);
		rsi.id = id;
		rsi.parentID = ParentID;
		rsi.type = 8;
		rsi.aString228 = text;
		rsi.message = text2;
		rsi.anIntArray245 = new int[1];
		rsi.anIntArray212 = new int[1];
		rsi.anIntArray245[0] = 1;
		rsi.anIntArray212[0] = configId;
		rsi.valueIndexArray = new int[1][3];
		rsi.valueIndexArray[0][0] = 5;
		rsi.valueIndexArray[0][1] = configFrame;
		rsi.valueIndexArray[0][2] = 0;
	}

	public static void addSprite(int ID, int i, int i2, String name,
			int configId, int configFrame) {
		RSInterface Tab = addTabInterface(ID);
		Tab.id = ID;
		Tab.parentID = ID;
		Tab.type = 5;
		Tab.atActionType = 0;
		Tab.contentType = 0;
		Tab.width = 512;
		Tab.height = 334;
		Tab.aByte254 = (byte) 0;
		Tab.mOverInterToTrigger = -1;
		Tab.anIntArray245 = new int[1];
		Tab.anIntArray212 = new int[1];
		Tab.anIntArray245[0] = 1;
		Tab.anIntArray212[0] = configId;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.sprite1 = imageLoader(i, name);
		Tab.sprite2 = imageLoader(i2, name);
	}

	public static void addHover(int i, int aT, int cT, int hoverid, int sId,
			String NAME, int W, int H, String tip) {
		RSInterface hover = addTabInterface(i);
		hover.id = i;
		hover.parentID = i;
		hover.type = 5;
		hover.atActionType = aT;
		hover.contentType = cT;
		hover.mOverInterToTrigger = hoverid;
		hover.sprite1 = imageLoader(sId, NAME);
		hover.sprite2 = imageLoader(sId, NAME);
		hover.width = W;
		hover.height = H;
		hover.tooltip = tip;
	}

	public static void addHovered(int i, int j, String imageName, int w, int h,
			int IMAGEID) {
		RSInterface hover = addTabInterface(i);
		hover.parentID = i;
		hover.id = i;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width = w;
		hover.height = h;
		hover.isMouseoverTriggered = true;
		hover.mOverInterToTrigger = -1;
		addSprite(IMAGEID, j, imageName);
		setChildren(1, hover);
		setBounds(IMAGEID, 0, 0, 0, hover);
	}

	public static void setBoundsP(int ID, int X, int Y, int frame,
			RSInterface RSinterface) {
		RSinterface.children[frame] = ID;
		RSinterface.childX[frame] = X;
		RSinterface.childY[frame] = Y;
	}

	public static void setChildrenP(int total, RSInterface i) {
		i.children = new int[total];
		i.childX = new int[total];
		i.childY = new int[total];
	}

	public static void addSpriteP(int id, int spriteId, String spriteName) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName);
		tab.width = 512;
		tab.height = 334;
	}

	private static Sprite loadSprite(int i, String s) {

		Sprite sprite;
		try {
			sprite = new Sprite(s + " " + i);
			if (sprite != null) {
				return sprite;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		return sprite;
	}

	public Sprite loadSprite(String s, int i) {
		Sprite sprite;
		try {
			sprite = new Sprite(s + " " + i);
			if (sprite != null) {
				return sprite;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		return null;
	}

	public static void Prayer(TextDrawingArea[] TDA) {
		RSInterface Interface = addTabInterface(5608);
		int index = 0;
		int prayIndex = 0;
		setChildrenP(80, Interface);
		addText(25104, "99/99", 0xFF981F, false, false, -1, TDA, 1);
		addSpriteP(25105, 0, "PRAYERICO");
		addPrayer(25000, 0, 83, 0, prayIndex, 25052, "Thick Skin");
		prayIndex++;
		setBoundsP(25000, 2, 5, index, Interface);
		index++;// Glow
		setBoundsP(25001, 5, 8, index, Interface);
		index++;// Icon
		addPrayer(25002, 0, 84, 3, prayIndex, 25054, "Burst of Strength");
		prayIndex++;
		setBoundsP(25002, 40, 5, index, Interface);
		index++;// Glow
		setBoundsP(25003, 44, 8, index, Interface);
		index++;// Icon
		addPrayer(25004, 0, 85, 6, prayIndex, 25056, "Clarity of Thought");
		prayIndex++;
		setBoundsP(25004, 76, 5, index, Interface);
		index++;// Glow
		setBoundsP(25005, 79, 11, index, Interface);
		index++;// Icon
		addPrayer(25006, 0, 101, 7, prayIndex, 25058, "Sharp Eye");
		prayIndex++;
		setBoundsP(25006, 113, 5, index, Interface);
		index++;// Glow
		setBoundsP(25007, 116, 10, index, Interface);
		index++;// Icon
		addPrayer(25008, 0, 102, 8, prayIndex, 25060, "Mystic Will");
		prayIndex++;
		setBoundsP(25008, 150, 5, index, Interface);
		index++;// Glow
		setBoundsP(25009, 153, 9, index, Interface);
		index++;// Icon
		addPrayer(25010, 0, 86, 9, prayIndex, 25062, "Rock Skin");
		prayIndex++;
		setBoundsP(25010, 2, 45, index, Interface);
		index++;// Glow
		setBoundsP(25011, 5, 48, index, Interface);
		index++;// Icon
		addPrayer(25012, 0, 87, 12, prayIndex, 25064, "Superhuman Strength");
		prayIndex++;
		setBoundsP(25012, 39, 45, index, Interface);
		index++;// Glow
		setBoundsP(25013, 44, 47, index, Interface);
		index++;// Icon
		addPrayer(25014, 0, 88, 15, prayIndex, 25066, "Improved Reflexes");
		prayIndex++;
		setBoundsP(25014, 76, 45, index, Interface);
		index++;// Glow
		setBoundsP(25015, 79, 49, index, Interface);
		index++;// Icon
		addPrayer(25016, 0, 89, 18, prayIndex, 25068, "Rapid Restore");
		prayIndex++;
		setBoundsP(25016, 113, 45, index, Interface);
		index++;// Glow
		setBoundsP(25017, 116, 50, index, Interface);
		index++;// Icon
		addPrayer(25018, 0, 90, 21, prayIndex, 25070, "Rapid Heal");
		prayIndex++;
		setBoundsP(25018, 151, 45, index, Interface);
		index++;// Glow
		setBoundsP(25019, 154, 50, index, Interface);
		index++;// Icon
		addPrayer(25020, 0, 91, 24, prayIndex, 25072, "Protect Item");
		prayIndex++;
		setBoundsP(25020, 2, 82, index, Interface);
		index++;// Glow
		setBoundsP(25021, 4, 84, index, Interface);
		index++;// Icon
		addPrayer(25022, 0, 103, 25, prayIndex, 25074, "Hawk Eye");
		prayIndex++;
		setBoundsP(25022, 40, 82, index, Interface);
		index++;// Glow
		setBoundsP(25023, 42, 86, index, Interface);
		index++;// Icon
		addPrayer(25024, 0, 104, 26, prayIndex, 25076, "Mystic Lore");
		prayIndex++;
		setBoundsP(25024, 77, 82, index, Interface);
		index++;// Glow
		setBoundsP(25025, 79, 84, index, Interface);
		index++;// Icon
		addPrayer(25026, 0, 92, 27, prayIndex, 25078, "Steel Skin");
		prayIndex++;
		setBoundsP(25026, 114, 83, index, Interface);
		index++;// Glow
		setBoundsP(25027, 117, 85, index, Interface);
		index++;// Icon
		addPrayer(25028, 0, 93, 30, prayIndex, 25080, "Ultimate Strength");
		prayIndex++;
		setBoundsP(25028, 153, 83, index, Interface);
		index++;// Glow
		setBoundsP(25029, 156, 87, index, Interface);
		index++;// Icon
		addPrayer(25030, 0, 94, 33, prayIndex, 25082, "Incredible Reflexes");
		prayIndex++;
		setBoundsP(25030, 2, 120, index, Interface);
		index++;// Glow
		setBoundsP(25031, 5, 125, index, Interface);
		index++;// Icon
		addPrayer(25032, 0, 95, 36, prayIndex, 25084, "Protect from Magic");
		prayIndex++;
		setBoundsP(25032, 40, 120, index, Interface);
		index++;// Glow
		setBoundsP(25033, 43, 124, index, Interface);
		index++;// Icon
		addPrayer(25034, 0, 96, 39, prayIndex, 25086, "Protect from Missiles");
		prayIndex++;
		setBoundsP(25034, 78, 120, index, Interface);
		index++;// Glow
		setBoundsP(25035, 83, 124, index, Interface);
		index++;// Icon
		addPrayer(25036, 0, 97, 42, prayIndex, 25088, "Protect from Melee");
		prayIndex++;
		setBoundsP(25036, 114, 120, index, Interface);
		index++;// Glow
		setBoundsP(25037, 115, 121, index, Interface);
		index++;// Icon
		addPrayer(25038, 0, 105, 43, prayIndex, 25090, "Eagle Eye");
		prayIndex++;
		setBoundsP(25038, 151, 120, index, Interface);
		index++;// Glow
		setBoundsP(25039, 153, 124, index, Interface);
		index++;// Icon
		addPrayer(25040, 0, 106, 44, prayIndex, 25092, "Mystic Might");
		prayIndex++;
		setBoundsP(25040, 2, 158, index, Interface);
		index++;// Glow
		setBoundsP(25041, 4, 160, index, Interface);
		index++;// Icon
		addPrayer(25042, 0, 98, 45, prayIndex, 25094, "Retribution");
		prayIndex++;
		setBoundsP(25042, 39, 158, index, Interface);
		index++;// Glow
		setBoundsP(25043, 41, 158, index, Interface);
		index++;// Icon
		addPrayer(25044, 0, 99, 48, prayIndex, 25096, "Redemption");
		prayIndex++;
		setBoundsP(25044, 76, 158, index, Interface);
		index++;// Glow
		setBoundsP(25045, 78, 162, index, Interface);
		index++;// Icon
		addPrayer(25046, 0, 100, 51, prayIndex, 25098, "Smite");
		prayIndex++;
		setBoundsP(25046, 114, 158, index, Interface);
		index++;// Glow
		setBoundsP(25047, 116, 158, index, Interface);
		index++;// Icon
		addPrayer(25048, 0, 107, 59, prayIndex, 25100, "Chivalry");
		prayIndex++;
		setBoundsP(25048, 153, 158, index, Interface);
		index++;// Glow
		setBoundsP(25049, 160, 159, index, Interface);
		index++;// Icon
		addPrayer(25050, 0, 108, 69, prayIndex, 25102, "Piety");
		prayIndex++;
		setBoundsP(25050, 2, 199, index, Interface);
		index++;// Glow
		setBoundsP(25051, 3, 210, index, Interface);
		index++;// Icon
		setBoundsP(25052, 12, 42, index, Interface);
		index++;// Hover Thick Skin
		setBoundsP(25054, 8, 42, index, Interface);
		index++;// Hover Burst of Strength
		setBoundsP(25056, 20, 42, index, Interface);
		index++;// Hover
		setBoundsP(25058, 12, 42, index, Interface);
		index++;// Hover
		setBoundsP(25060, 24, 42, index, Interface);
		index++;// Hover
		setBoundsP(25062, 2, 80, index, Interface);
		index++;// Hover Column 2
		setBoundsP(25064, 2, 80, index, Interface);
		index++;// Hover
		setBoundsP(25066, 6, 80, index, Interface);
		index++;// Hover
		setBoundsP(25068, 6, 80, index, Interface);
		index++;// Hover
		setBoundsP(25070, 50, 80, index, Interface);
		index++;// Hover
		setBoundsP(25072, 6, 118, index, Interface);
		index++;// Hover Column 3
		setBoundsP(25074, 6, 118, index, Interface);
		index++;// Hover
		setBoundsP(25076, 10, 118, index, Interface);
		index++;// Hover
		setBoundsP(25078, 6, 118, index, Interface);
		index++;// Hover
		setBoundsP(25080, 6, 118, index, Interface);
		index++;// Hover
		setBoundsP(25082, 5, 150, index, Interface);
		index++;// Hover Column 4
		setBoundsP(25084, 5, 150, index, Interface);
		index++;// Hover
		setBoundsP(25086, 5, 150, index, Interface);
		index++;// Hover
		setBoundsP(25088, 5, 150, index, Interface);
		index++;// Hover
		setBoundsP(25090, 5, 150, index, Interface);
		index++;// Hover
		setBoundsP(25092, 18, 105, index, Interface);
		index++;// Hover Column 5
		setBoundsP(25094, 28, 80, index, Interface);
		index++;// Hover
		setBoundsP(25096, 28, 65, index, Interface);
		index++;// Hover
		setBoundsP(25098, 50, 65, index, Interface);
		index++;// Hover
		setBoundsP(25100, 1, 65, index, Interface);
		index++;// Hover
		setBoundsP(25102, 1, 110, index, Interface);
		index++;// Hover
		setBoundsP(25104, 85, 241, index, Interface);
		index++;// Text
		setBoundsP(25105, 65, 241, index, Interface);
		index++;// Icon
	}

	public static void addPrayerWithTooltip(int i, int configId,
			int configFrame, int requiredValues, int prayerSpriteID, int Hover,
			String tooltip) {
		RSInterface Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 5608;
		Interface.type = 5;
		Interface.atActionType = 4;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = Hover;
		Interface.sprite1 = imageLoader(0, "PRAYERGLOW");
		Interface.sprite2 = imageLoader(1, "PRAYERGLOW");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245[0] = 1;
		Interface.anIntArray212[0] = configId;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 5;
		Interface.valueIndexArray[0][1] = configFrame;
		Interface.valueIndexArray[0][2] = 0;
		Interface.tooltip = tooltip;
		Interface = addTabInterface(i + 1);
		Interface.id = i + 1;
		Interface.parentID = 5608;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.sprite1 = imageLoader(prayerSpriteID, "PRAYERON");
		Interface.sprite2 = imageLoader(prayerSpriteID, "PRAYEROFF");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245[0] = 1;
		Interface.anIntArray212[0] = requiredValues + 1;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 2;
		Interface.valueIndexArray[0][1] = 5;
		Interface.valueIndexArray[0][2] = 0;
	}

	public static void prayerMenu(TextDrawingArea[] TDA) {
		RSInterface prayerMenu = addInterface(5608);
		int index = 0;
		int prayIndex = 0;
		int firstRowXPos = 10;
		int firstRowYPos = 50;
		int secondRowXPos = 10;
		int secondRowYPos = 86;
		int thirdRowXPos = 10;
		int thirdRowYPos = 122;
		int fourthRowXPos = 10;
		int fourthRowYPos = 159;
		int fifthRowXPos = 10;
		int fifthRowYPos = 86;
		int sixthRowXPos = 1;
		int sixthRowYPos = 52;
		addText(687, "", 0xff981f, false, true, -1, 1);
		addSprite(25105, 0, "PRAYERICON");
		addPrayerWithTooltip(25000, 0, 83, 0, prayIndex, 25052,
				"Activate @lre@Thick Skin");
		prayIndex++;
		addPrayerWithTooltip(25002, 0, 84, 3, prayIndex, 25054,
				"Activate @lre@Burst of Strength");
		prayIndex++;
		addPrayerWithTooltip(25004, 0, 85, 6, prayIndex, 25056,
				"Activate @lre@Clarity of Thought");
		prayIndex++;
		addPrayerWithTooltip(25006, 0, 101, 7, prayIndex, 25058,
				"Activate @lre@Sharp Eye");
		prayIndex++;
		addPrayerWithTooltip(25008, 0, 102, 8, prayIndex, 25060,
				"Activate @lre@Mystic Will");
		prayIndex++;
		addPrayerWithTooltip(25010, 0, 86, 9, prayIndex, 25062,
				"Activate @lre@Rock Skin");
		prayIndex++;
		addPrayerWithTooltip(25012, 0, 87, 12, prayIndex, 25064,
				"Activate @lre@Superhuman Strength");
		prayIndex++;
		addPrayerWithTooltip(25014, 0, 88, 15, prayIndex, 25066,
				"Activate @lre@Improved Reflexes");
		prayIndex++;
		addPrayerWithTooltip(25016, 0, 89, 18, prayIndex, 25068,
				"Activate @lre@Rapid Restore");
		prayIndex++;
		addPrayerWithTooltip(25018, 0, 90, 21, prayIndex, 25070,
				"Activate @lre@Rapid Heal");
		prayIndex++;
		addPrayerWithTooltip(25020, 0, 91, 24, prayIndex, 25072,
				"Activate @lre@Protect Item");
		prayIndex++;
		addPrayerWithTooltip(25022, 0, 103, 25, prayIndex, 25074,
				"Activate @lre@Hawk Eye");
		prayIndex++;
		addPrayerWithTooltip(25024, 0, 104, 26, prayIndex, 25076,
				"Activate @lre@Mystic Lore");
		prayIndex++;
		addPrayerWithTooltip(25026, 0, 92, 27, prayIndex, 25078,
				"Activate @lre@Steel Skin");
		prayIndex++;
		addPrayerWithTooltip(25028, 0, 93, 30, prayIndex, 25080,
				"Activate @lre@Ultimate Strength");
		prayIndex++;
		addPrayerWithTooltip(25030, 0, 94, 33, prayIndex, 25082,
				"Activate @lre@Incredible Reflexes");
		prayIndex++;
		addPrayerWithTooltip(25032, 0, 95, 36, prayIndex, 25084,
				"Activate @lre@Protect from Magic");
		prayIndex++;
		addPrayerWithTooltip(25034, 0, 96, 39, prayIndex, 25086,
				"Activate @lre@Protect from Missles");
		prayIndex++;
		addPrayerWithTooltip(25036, 0, 97, 42, prayIndex, 25088,
				"Activate @lre@Protect from Melee");
		prayIndex++;
		addPrayerWithTooltip(25038, 0, 105, 43, prayIndex, 25090,
				"Activate @lre@Eagle Eye");
		prayIndex++;
		addPrayerWithTooltip(25040, 0, 106, 44, prayIndex, 25092,
				"Activate @lre@Mystic Might");
		prayIndex++;
		addPrayerWithTooltip(25042, 0, 98, 45, prayIndex, 25094,
				"Activate @lre@Retribution");
		prayIndex++;
		addPrayerWithTooltip(25044, 0, 99, 48, prayIndex, 25096,
				"Activate @lre@Redemption");
		prayIndex++;
		addPrayerWithTooltip(25046, 0, 100, 51, prayIndex, 25098,
				"Activate @lre@Smite");
		prayIndex++;
		addPrayerWithTooltip(25048, 0, 107, 59, prayIndex, 25100,
				"Activate @lre@Chivalry");
		prayIndex++;
		addPrayerWithTooltip(25050, 0, 108, 69, prayIndex, 25102,
				"Activate @lre@Piety");
		prayIndex++;
		addTooltip(25052, "Level 01\nThick Skin\nIncreases your Defence by 5%");
		addTooltip(25054,
				"Level 04\nBurst of Strength\nIncreases your Strength by 5%");
		addTooltip(25056,
				"Level 07\nClarity of Thought\nIncreases your Attack by 5%");
		addTooltip(25058, "Level 08\nSharp Eye\nIncreases your Ranged by 5%");
		addTooltip(25060, "Level 09\nMystic Will\nIncreases your Magic by 5%");
		addTooltip(25062, "Level 10\nRock Skin\nIncreases your Defence by 10%");
		addTooltip(25064,
				"Level 13\nSuperhuman Strength\nIncreases your Strength by 10%");
		addTooltip(25066,
				"Level 16\nImproved Reflexes\nIncreases your Attack by 10%");
		addTooltip(
				25068,
				"Level 19\nRapid Restore\n2x restore rate for all stats\nexcept Hitpoints, Summoning\nand Prayer");
		addTooltip(25070,
				"Level 22\nRapid Heal\n2x restore rate for the\nHitpoints stat");
		addTooltip(25072,
				"Level 25\nProtect Item\nKeep 1 extra item if you die");
		addTooltip(25074, "Level 26\nHawk Eye\nIncreases your Ranged by 10%");
		addTooltip(25076, "Level 27\nMystic Lore\nIncreases your Magic by 10%");
		addTooltip(25078, "Level 28\nSteel Skin\nIncreases your Defence by 15%");
		addTooltip(25080,
				"Level 31\nUltimate Strength\nIncreases your Strength by 15%");
		addTooltip(25082,
				"Level 34\nIncredible Reflexes\nIncreases your Attack by 15%");
		addTooltip(25084,
				"Level 37\nProtect from Magic\nProtection from magical attacks");
		addTooltip(25086,
				"Level 40\nProtect from Missles\nProtection from ranged attacks");
		addTooltip(25088,
				"Level 43\nProtect from Melee\nProtection from melee attacks");
		addTooltip(25090, "Level 44\nEagle Eye\nIncreases your Ranged by 15%");
		addTooltip(25092, "Level 45\nMystic Might\nIncreases your Magic by 15%");
		addTooltip(25094,
				"Level 46\nRetribution\nInflicts damage to nearby\ntargets if you die");
		addTooltip(25096,
				"Level 49\nRedemption\nHeals you when damaged\nand Hitpoints falls\nbelow 10%");
		addTooltip(25098,
				"Level 52\nSmite\n1/4 of damage dealt is\nalso removed from\nopponent's Prayer");
		addTooltip(
				25100,
				"Level 60\nChivalry\nIncreases your Defence by 20%,\nStrength by 18%, and Attack by\n15%");
		addTooltip(
				25102,
				"Level 70\nPiety\nIncreases your Defence by 25%,\nStrength by 23%, and Attack by\n20%");
		setChildren(80, prayerMenu);
		setBounds(687, 85, 241, index, prayerMenu);
		index++;
		setBounds(25105, 65, 241, index, prayerMenu);
		index++;
		setBounds(25000, 2, 5, index, prayerMenu);
		index++;
		setBounds(25001, 5, 8, index, prayerMenu);
		index++;
		setBounds(25002, 40, 5, index, prayerMenu);
		index++;
		setBounds(25003, 44, 8, index, prayerMenu);
		index++;
		setBounds(25004, 76, 5, index, prayerMenu);
		index++;
		setBounds(25005, 79, 11, index, prayerMenu);
		index++;
		setBounds(25006, 113, 5, index, prayerMenu);
		index++;
		setBounds(25007, 116, 10, index, prayerMenu);
		index++;
		setBounds(25008, 150, 5, index, prayerMenu);
		index++;
		setBounds(25009, 153, 9, index, prayerMenu);
		index++;
		setBounds(25010, 2, 45, index, prayerMenu);
		index++;
		setBounds(25011, 5, 48, index, prayerMenu);
		index++;
		setBounds(25012, 39, 45, index, prayerMenu);
		index++;
		setBounds(25013, 44, 47, index, prayerMenu);
		index++;
		setBounds(25014, 76, 45, index, prayerMenu);
		index++;
		setBounds(25015, 79, 49, index, prayerMenu);
		index++;
		setBounds(25016, 113, 45, index, prayerMenu);
		index++;
		setBounds(25017, 116, 50, index, prayerMenu);
		index++;
		setBounds(25018, 151, 45, index, prayerMenu);
		index++;
		setBounds(25019, 154, 50, index, prayerMenu);
		index++;
		setBounds(25020, 2, 82, index, prayerMenu);
		index++;
		setBounds(25021, 4, 84, index, prayerMenu);
		index++;
		setBounds(25022, 40, 82, index, prayerMenu);
		index++;
		setBounds(25023, 44, 87, index, prayerMenu);
		index++;
		setBounds(25024, 77, 82, index, prayerMenu);
		index++;
		setBounds(25025, 81, 85, index, prayerMenu);
		index++;
		setBounds(25026, 114, 83, index, prayerMenu);
		index++;
		setBounds(25027, 117, 85, index, prayerMenu);
		index++;
		setBounds(25028, 153, 83, index, prayerMenu);
		index++;
		setBounds(25029, 156, 87, index, prayerMenu);
		index++;
		setBounds(25030, 2, 120, index, prayerMenu);
		index++;
		setBounds(25031, 5, 125, index, prayerMenu);
		index++;
		setBounds(25032, 40, 120, index, prayerMenu);
		index++;
		setBounds(25033, 43, 124, index, prayerMenu);
		index++;
		setBounds(25034, 78, 120, index, prayerMenu);
		index++;
		setBounds(25035, 83, 124, index, prayerMenu);
		index++;
		setBounds(25036, 114, 120, index, prayerMenu);
		index++;
		setBounds(25037, 115, 121, index, prayerMenu);
		index++;
		setBounds(25038, 151, 120, index, prayerMenu);
		index++;
		setBounds(25039, 154, 124, index, prayerMenu);
		index++;
		setBounds(25040, 2, 158, index, prayerMenu);
		index++;
		setBounds(25041, 5, 160, index, prayerMenu);
		index++;
		setBounds(25042, 39, 158, index, prayerMenu);
		index++;
		setBounds(25043, 41, 158, index, prayerMenu);
		index++;
		setBounds(25044, 76, 158, index, prayerMenu);
		index++;
		setBounds(25045, 79, 163, index, prayerMenu);
		index++;
		setBounds(25046, 114, 158, index, prayerMenu);
		index++;
		setBounds(25047, 116, 158, index, prayerMenu);
		index++;
		setBounds(25048, 153, 158, index, prayerMenu);
		index++;
		setBounds(25049, 161, 160, index, prayerMenu);
		index++;
		setBounds(25050, 2, 196, index, prayerMenu);
		index++;
		setBounds(25051, 4, 207, index, prayerMenu);
		index++;
		// Tooltips
		/* Row one *//**
		 * Thick Skin, Burst of Strength, Clarity of Thought, Sharp
		 * eye, Mystic Will
		 */
		setBoundry(index, 25052, firstRowXPos - 2, firstRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25054, firstRowXPos - 5, firstRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25056, firstRowXPos, firstRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25058, firstRowXPos, firstRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25060, firstRowXPos, firstRowYPos, prayerMenu);
		index++;
		/* Row two *//**
		 * Rock Skin, Superhuman Strength, Improved Reflexes, Rapid
		 * Restore, Rapid Heal
		 */
		setBoundry(index, 25062, secondRowXPos - 9, secondRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25064, secondRowXPos - 11, secondRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25066, secondRowXPos, secondRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25068, secondRowXPos, secondRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25070, secondRowXPos + 25, secondRowYPos, prayerMenu);
		index++;
		/* Row three *//**
		 * Protect Item, Hawk Eye, Mystic Lore, Steel Skin,
		 * Ultimate Strength
		 */
		setBoundry(index, 25072, thirdRowXPos, thirdRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25074, thirdRowXPos - 2, thirdRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25076, thirdRowXPos, thirdRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25078, thirdRowXPos - 7, thirdRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25080, thirdRowXPos - 10, thirdRowYPos, prayerMenu);
		index++;
		/* Row four *//**
		 * Incredible Reflexes, Protect from Magic, Protect from
		 * Missles, Protect from Melee, Eagle Eye
		 */
		setBoundry(index, 25082, fourthRowXPos, fourthRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25084, fourthRowXPos - 8, fourthRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25086, fourthRowXPos - 7, fourthRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25088, fourthRowXPos - 2, fourthRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25090, fourthRowXPos - 2, fourthRowYPos, prayerMenu);
		index++;
		/* Row five *//** Mystic Might, Redemption, Retribution, Smite, Chivalry */
		setBoundry(index, 25092, fifthRowXPos, fifthRowYPos, prayerMenu);
		index++;
		setBoundry(index, 25094, fifthRowXPos, fifthRowYPos - 20, prayerMenu);
		index++;
		setBoundry(index, 25096, fifthRowXPos, fifthRowYPos - 25, prayerMenu);
		index++;
		setBoundry(index, 25098, fifthRowXPos + 15, fifthRowYPos - 25,
				prayerMenu);
		index++;
		setBoundry(index, 25100, fifthRowXPos - 12, fifthRowYPos - 20,
				prayerMenu);
		index++;
		/* Row six *//** Piety */
		setBoundry(index, 25102, sixthRowXPos - 2, sixthRowYPos, prayerMenu);
		index++;
	}

	public static void addPrayer(int i, int configId, int configFrame,
			int requiredValues, int prayerSpriteID, int hoverID,
			String PrayerName) {
		RSInterface Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 5608;
		Interface.type = 5;
		Interface.atActionType = 4;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = -1;
		Interface.sprite1 = loadSprite(0, "PRAYERGLOW");
		Interface.sprite2 = loadSprite(1, "PRAYERGLOW");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245[0] = 1;
		Interface.anIntArray212[0] = configId;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 5;
		Interface.valueIndexArray[0][1] = configFrame;
		Interface.valueIndexArray[0][2] = 0;
		Interface.tooltip = "Activate@or1@ " + PrayerName;
		Interface = addTabInterface(i + 1);
		Interface.id = i + 1;
		Interface.parentID = 5608;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = hoverID;
		Interface.sprite2 = loadSprite(prayerSpriteID, "PRAYEROFF");
		Interface.sprite1 = loadSprite(prayerSpriteID, "PRAYERON");
		Interface.width = 34;
		Interface.height = 34;
		Interface.anIntArray245 = new int[1];
		Interface.anIntArray212 = new int[1];
		Interface.anIntArray245[0] = 1;
		Interface.anIntArray212[0] = requiredValues + 1;
		Interface.valueIndexArray = new int[1][3];
		Interface.valueIndexArray[0][0] = 2;
		Interface.valueIndexArray[0][1] = 5;
		Interface.valueIndexArray[0][2] = 0;
		Interface = addTabInterface(hoverID);
		Interface.id = hoverID;
		Interface.parentID = 5608;
		Interface.type = 0;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = -1;
		Interface.width = 512;
		Interface.height = 334;
		Interface.isMouseoverTriggered = true;
		addSpriteP(hoverID + 1, prayerSpriteID, "PRAYERHOVER");
		setChildrenP(1, Interface);
		setBoundsP(hoverID + 1, 3, 5, 0, Interface);
	}

	private static Sprite LoadSprite(int i, String s) {
		long l = (TextClass.method585(s) << 8) + (long) i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null) {
			return sprite;
		}
		try {
			sprite = new Sprite(location + s + " " + i + ".PNG");
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception exception) {
			System.out.println(exception);
			return null;
		}
		return sprite;
	}

	private static Sprite CustomSpriteLoader(int id, String s) {
		long l = (TextClass.method585(s) << 8) + (long) id;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null) {
			return sprite;
		}
		try {
			sprite = new Sprite(location + id + s + ".png");
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception exception) {
			return null;
		}
		return sprite;
	}

	private static Sprite imageLoaderA(int i, String s) {
		long l = (TextClass.method585(s) << 8) + (long) i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null)
			return sprite;
		try {
			sprite = new Sprite(i + s);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception exception) {
			return null;
		}
		return sprite;
	}

	private static Sprite imageLoader(int i, String s) {
		long l = (TextClass.method585(s) << 8) + (long) i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null)
			return sprite;
		try {
			sprite = new Sprite(s + " " + i);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception exception) {
			return null;
		}
		return sprite;
	}

	public static void editClan(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(17250);
		addSprite(17251, 1, "CLAN");
		addHoverButton(17252, "BUTTON", 1, 150, 50, "Set name", -1, 17253, 1);
		addHoveredButton(17253, "BUTTON", 2, 150, 50, 17254);
		addHoverButton(17255, "BUTTON", 1, 150, 50, "Anyone", -1, 17256, 1);
		addHoveredButton(17256, "BUTTON", 2, 150, 50, 17257);
		addHoverButton(17258, "BUTTON", 1, 150, 50, "Anyone", -1, 17259, 1);
		addHoveredButton(17259, "BUTTON", 2, 150, 50, 17260);
		addHoverButton(17261, "BUTTON", 1, 150, 50, "Corporal+", -1, 17262, 1);
		addHoveredButton(17262, "BUTTON", 2, 150, 50, 17263);
		addHoverButton(17264, "BUTTON", 1, 150, 50, "No-one", -1, 17265, 1);
		addHoveredButton(17265, "BUTTON", 2, 150, 50, 17266);
		addHoverButton(17267, "CLOSE", 3, 50, 50, "Close", -1, 17268, 1);
		addHoveredButton(17268, "CLOSE", 4, 40, 50, 17269);
		addText(17800, "Clan name:", tda, 0, 0xff981f, false, true);
		addText(17801, "Who can enter chat?", tda, 0, 0xff981f, false, true);
		addText(17812, "Who can talk on chat?", tda, 0, 0xff981f, false, true);
		addText(17813, "Who can kick on chat?", tda, 0, 0xff981f, false, true);
		addText(17814, "Who can share loot?", tda, 0, 0xff981f, false, true);
		tab.totalChildren(19);
		tab.child(0, 17251, 15, 15);
		tab.child(1, 17252, 25, 47);
		tab.child(2, 17253, 25, 47);
		tab.child(3, 17255, 25, 87);
		tab.child(4, 17256, 25, 87);
		tab.child(5, 17258, 25, 128);
		tab.child(6, 17259, 25, 128);
		tab.child(7, 17261, 25, 168);
		tab.child(8, 17262, 25, 168);
		tab.child(9, 17264, 25, 209);
		tab.child(10, 17265, 25, 209);
		tab.child(11, 17800, 73, 54);
		tab.child(12, 17801, 53, 95);
		tab.child(13, 14000, 0, 94);
		tab.child(14, 17812, 53, 136);
		tab.child(15, 17813, 53, 177);
		tab.child(16, 17814, 53, 218);
		tab.child(17, 17267, 476, 23);
		tab.child(18, 17268, 476, 23);
		tab = addTabInterface(14000);
		tab.width = 474;
		tab.height = 213;
		tab.scrollMax = 305;
		for (int i = 14001; i <= 14030; i++) {
			addText(i, "", tda, 1, 0xffffff, false, true);
		}
		tab.totalChildren(30);
		int Child = 0;
		int Y = 5;
		for (int i = 14001; i <= 14030; i++) {
			tab.child(Child, i, 248, Y);
			Child++;
			Y += 13;
		}
	}

	public void setChildren(int total) {
		children = new int[total];
		childX = new int[total];
		childY = new int[total];
	}

	public static void addTooltip(int id, String text) {
		RSInterface rsi = addInterface(id);
		rsi.id = id;
		rsi.type = 0;
		rsi.isMouseoverTriggered = true;
		rsi.mOverInterToTrigger = -1;
		addTooltipBox(id + 1, text);
		rsi.totalChildren(1);
		rsi.child(0, id + 1, 0, 0);
	}

	public static void addTooltipC(int id, String text, int H, int W) {
		RSInterface rsi = addTabInterface(id);
		rsi.id = id;
		rsi.type = 0;
		rsi.isMouseoverTriggered = true;
		rsi.mOverInterToTrigger = -1;
		addTooltipBox(id + 1, text);
		rsi.totalChildren(1);
		rsi.child(0, id + 1, 0, 0);
		rsi.height = H;
		rsi.width = W;
	}

	public static void drawTooltip(int id, String text) {
		RSInterface rsi = addInterface(id);
		rsi.id = id;
		rsi.type = 0;
		rsi.isMouseoverTriggered = true;
		rsi.mOverInterToTrigger = -1;
		addTooltipBox(id + 1, text);
		rsi.totalChildren(1);
		rsi.child(0, id + 1, 0, 0);
	}

	public static void setBoundry(int frame, int ID, int X, int Y,
			RSInterface RSinterface) {
		RSinterface.children[frame] = ID;
		RSinterface.childX[frame] = X;
		RSinterface.childY[frame] = Y;
	}

	public static TextDrawingArea[] fonts;

	public static void addLText(int i, String s, int k, boolean l, boolean m,
			int a, int j) {
		RSInterface rsinterface = addInterface(i);
		rsinterface.parentID = i;
		rsinterface.id = i;
		rsinterface.type = 4;
		rsinterface.atActionType = 0;
		rsinterface.width = 0;
		rsinterface.height = 0;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = a;
		rsinterface.centerText = l;
		rsinterface.textShadow = m;
		rsinterface.textDrawingAreas = RSInterface.fonts[j];
		rsinterface.message = s;
		rsinterface.textColor = k;
	}

	public static void addLunarSprite(int i, int j, String name) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.id = i;
		RSInterface.parentID = i;
		RSInterface.type = 5;
		RSInterface.atActionType = 0;
		RSInterface.contentType = 0;
		RSInterface.aByte254 = 0;
		RSInterface.mOverInterToTrigger = 52;
		RSInterface.sprite1 = imageLoader(j, name);
		RSInterface.width = 500;
		RSInterface.height = 500;
		RSInterface.tooltip = "";
	}

	public static void drawRune(int i, int id, String runeName) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.type = 5;
		RSInterface.atActionType = 0;
		RSInterface.contentType = 0;
		RSInterface.aByte254 = 0;
		RSInterface.mOverInterToTrigger = 52;
		RSInterface.sprite1 = loadSprite(id, "RUNE");
		RSInterface.width = 500;
		RSInterface.height = 500;
	}

	public static void addRuneText(int ID, int runeAmount, int RuneID,
			TextDrawingArea[] font) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 4;
		rsInterface.atActionType = 0;
		rsInterface.contentType = 0;
		rsInterface.width = 0;
		rsInterface.height = 14;
		rsInterface.aByte254 = 0;
		rsInterface.mOverInterToTrigger = -1;
		rsInterface.anIntArray245 = new int[1];
		rsInterface.anIntArray212 = new int[1];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = runeAmount;
		rsInterface.valueIndexArray = new int[1][4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = RuneID;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.centerText = true;
		rsInterface.textDrawingAreas = font[0];
		rsInterface.textShadow = true;
		rsInterface.message = "%1/" + runeAmount + "";
		rsInterface.aString228 = "";
		rsInterface.textColor = 12582912;
		rsInterface.anInt219 = 49152;
	}

	public static void homeTeleport() {
		RSInterface RSInterface = addInterface(30000);
		RSInterface.tooltip = "Cast @gre@Lunar Home Teleport";
		RSInterface.id = 30000;
		RSInterface.parentID = 30000;
		RSInterface.type = 5;
		RSInterface.atActionType = 5;
		RSInterface.contentType = 0;
		RSInterface.aByte254 = 0;
		RSInterface.mOverInterToTrigger = 30001;
		RSInterface.sprite1 = loadSprite(1, "SPRITE");
		RSInterface.width = 20;
		RSInterface.height = 20;
		RSInterface hover = addInterface(30001);
		hover.mOverInterToTrigger = -1;
		hover.isMouseoverTriggered = true;
		setChildren(1, hover);
		addLunarSprite(30002, 0, "SPRITE");
		setBounds(30002, 0, 0, 0, hover);
	}

	public static void addLunar2RunesSmallBox(int ID, int r1, int r2, int ra1,
			int ra2, int rune1, int lvl, String name, String descr,
			TextDrawingArea[] TDA, int sid, int suo, int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast On";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[3];
		rsInterface.anIntArray212 = new int[3];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = lvl;
		rsInterface.valueIndexArray = new int[3][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[3];
		rsInterface.valueIndexArray[2][0] = 1;
		rsInterface.valueIndexArray[2][1] = 6;
		rsInterface.valueIndexArray[2][2] = 0;
		rsInterface.sprite2 = loadSprite(sid, "LUNARON");
		rsInterface.sprite1 = loadSprite(sid, "LUNAROFF");
		RSInterface hover = addInterface(ID + 1);
		hover.mOverInterToTrigger = -1;
		hover.isMouseoverTriggered = true;
		setChildren(7, hover);
		addLunarSprite(ID + 2, 0, "BOX");
		setBounds(ID + 2, 0, 0, 0, hover);
		addLText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true,
				true, 52, 1);
		setBounds(ID + 3, 90, 4, 1, hover);
		addLText(ID + 4, descr, 0xAF6A1A, true, true, 52, 0);
		setBounds(ID + 4, 90, 19, 2, hover);
		setBounds(30016, 37, 35, 3, hover);// Rune
		setBounds(rune1, 112, 35, 4, hover);// Rune
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 50, 66, 5, hover);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 123, 66, 6, hover);

	}

	public static void addLunar3RunesSmallBox(int ID, int r1, int r2, int r3,
			int ra1, int ra2, int ra3, int rune1, int rune2, int lvl,
			String name, String descr, TextDrawingArea[] TDA, int sid, int suo,
			int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = loadSprite(sid, "LUNARON");
		rsInterface.sprite1 = loadSprite(sid, "LUNAROFF");
		RSInterface hover = addInterface(ID + 1);
		hover.mOverInterToTrigger = -1;
		hover.isMouseoverTriggered = true;
		setChildren(9, hover);
		addLunarSprite(ID + 2, 0, "BOX");
		setBounds(ID + 2, 0, 0, 0, hover);
		addLText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true,
				true, 52, 1);
		setBounds(ID + 3, 90, 4, 1, hover);
		addLText(ID + 4, descr, 0xAF6A1A, true, true, 52, 0);
		setBounds(ID + 4, 90, 19, 2, hover);
		setBounds(30016, 14, 35, 3, hover);
		setBounds(rune1, 74, 35, 4, hover);
		setBounds(rune2, 130, 35, 5, hover);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 26, 66, 6, hover);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 87, 66, 7, hover);
		addRuneText(ID + 7, ra3 + 1, r3, TDA);
		setBounds(ID + 7, 142, 66, 8, hover);
	}

	public static void addLunar3RunesBigBox(int ID, int r1, int r2, int r3,
			int ra1, int ra2, int ra3, int rune1, int rune2, int lvl,
			String name, String descr, TextDrawingArea[] TDA, int sid, int suo,
			int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = loadSprite(sid, "LUNARON");
		rsInterface.sprite1 = loadSprite(sid, "LUNAROFF");
		RSInterface hover = addInterface(ID + 1);
		hover.mOverInterToTrigger = -1;
		hover.isMouseoverTriggered = true;
		setChildren(9, hover);
		addLunarSprite(ID + 2, 1, "BOX");
		setBounds(ID + 2, 0, 0, 0, hover);
		addLText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true,
				true, 52, 1);
		setBounds(ID + 3, 90, 4, 1, hover);
		addLText(ID + 4, descr, 0xAF6A1A, true, true, 52, 0);
		setBounds(ID + 4, 90, 21, 2, hover);
		setBounds(30016, 14, 48, 3, hover);
		setBounds(rune1, 74, 48, 4, hover);
		setBounds(rune2, 130, 48, 5, hover);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 26, 79, 6, hover);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 87, 79, 7, hover);
		addRuneText(ID + 7, ra3 + 1, r3, TDA);
		setBounds(ID + 7, 142, 79, 8, hover);
	}

	public static void addLunar3RunesLargeBox(int ID, int r1, int r2, int r3,
			int ra1, int ra2, int ra3, int rune1, int rune2, int lvl,
			String name, String descr, TextDrawingArea[] TDA, int sid, int suo,
			int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = loadSprite(sid, "LUNARON");
		rsInterface.sprite1 = loadSprite(sid, "LUNAROFF");
		RSInterface hover = addInterface(ID + 1);
		hover.isMouseoverTriggered = true;
		hover.mOverInterToTrigger = -1;
		setChildren(9, hover);
		addLunarSprite(ID + 2, 2, "BOX");
		setBounds(ID + 2, 0, 0, 0, hover);
		addLText(ID + 3, "Level " + (lvl + 1) + ": " + name, 0xFF981F, true,
				true, 52, 1);
		setBounds(ID + 3, 90, 4, 1, hover);
		addLText(ID + 4, descr, 0xAF6A1A, true, true, 52, 0);
		setBounds(ID + 4, 90, 34, 2, hover);
		setBounds(30016, 14, 61, 3, hover);
		setBounds(rune1, 74, 61, 4, hover);
		setBounds(rune2, 130, 61, 5, hover);
		addRuneText(ID + 5, ra1 + 1, r1, TDA);
		setBounds(ID + 5, 26, 92, 6, hover);
		addRuneText(ID + 6, ra2 + 1, r2, TDA);
		setBounds(ID + 6, 87, 92, 7, hover);
		addRuneText(ID + 7, ra3 + 1, r3, TDA);
		setBounds(ID + 7, 142, 92, 8, hover);
	}

	public static void configureLunar(TextDrawingArea[] TDA) {
		homeTeleport();
		drawRune(30003, 1, "Fire");
		drawRune(30004, 2, "Water");
		drawRune(30005, 3, "Air");
		drawRune(30006, 4, "Earth");
		drawRune(30007, 5, "Mind");
		drawRune(30008, 6, "Body");
		drawRune(30009, 7, "Death");
		drawRune(30010, 8, "Nature");
		drawRune(30011, 9, "Chaos");
		drawRune(30012, 10, "Law");
		drawRune(30013, 11, "Cosmic");
		drawRune(30014, 12, "Blood");
		drawRune(30015, 13, "Soul");
		drawRune(30016, 14, "Astral");
		addLunar3RunesSmallBox(30017, 9075, 554, 555, 0, 4, 3, 30003, 30004,
				64, "Bake Pie", "Bake pies without a stove", TDA, 0, 16, 2);
		addLunar2RunesSmallBox(30025, 9075, 557, 0, 7, 30006, 65, "Cure Plant",
				"Cure disease on farming patch", TDA, 1, 4, 2);
		addLunar3RunesBigBox(30032, 9075, 564, 558, 0, 0, 0, 30013, 30007, 65,
				"Monster Examine",
				"Detect the combat statistics of a\\nmonster", TDA, 2, 2, 2);
		addLunar3RunesSmallBox(30040, 9075, 564, 556, 0, 0, 1, 30013, 30005,
				66, "NPC Contact", "Speak with varied NPCs", TDA, 3, 0, 2);
		addLunar3RunesSmallBox(30048, 9075, 563, 557, 0, 0, 9, 30012, 30006,
				67, "Cure Other", "Cure poisoned players", TDA, 4, 8, 2);
		addLunar3RunesSmallBox(30056, 9075, 555, 554, 0, 2, 0, 30004, 30003,
				67, "Humidify", "fills certain vessels with water", TDA, 5, 0,
				5);
		addLunar3RunesSmallBox(30064, 9075, 563, 557, 1, 0, 1, 30012, 30006,
				68, "Varrock Teleport", "Teleports you to Varrock", TDA, 6, 0,
				5);
		addLunar3RunesBigBox(30075, 9075, 563, 557, 1, 0, 3, 30012, 30006, 69,
				"Lumbridge Teleport", "Teleports you to Lumbridge", TDA, 7, 0,
				5);
		addLunar3RunesSmallBox(30083, 9075, 563, 557, 1, 0, 5, 30012, 30006,
				70, "Falador Teleport", "Teleports you to Falador", TDA, 8, 0,
				5);
		addLunar3RunesSmallBox(30091, 9075, 564, 563, 1, 1, 0, 30013, 30012,
				70, "Cure Me", "Cures Poison", TDA, 9, 0, 5);
		addLunar2RunesSmallBox(30099, 9075, 557, 1, 1, 30006, 70, "Hunter Kit",
				"Get a kit of hunting gear", TDA, 10, 0, 5);
		addLunar3RunesSmallBox(30106, 9075, 563, 555, 1, 0, 0, 30012, 30004,
				71, "Waterbirth Teleport",
				"Teleports you to Waterbirth island", TDA, 11, 0, 5);
		addLunar3RunesBigBox(30114, 9075, 563, 555, 1, 0, 4, 30012, 30004, 72,
				"Camelot Teleport", "Teleports players to Camelot", TDA, 12, 0,
				5);
		addLunar3RunesSmallBox(30122, 9075, 564, 563, 1, 1, 1, 30013, 30012,
				73, "Cure Group", "Cures Poison on players", TDA, 13, 0, 5);
		addLunar3RunesBigBox(30130, 9075, 564, 559, 1, 1, 4, 30013, 30008, 74,
				"Stat Spy",
				"Cast on another player to see their\\nskill levels", TDA, 14,
				8, 2);
		addLunar3RunesBigBox(30138, 9075, 563, 554, 1, 1, 2, 30012, 30003, 74,
				"Barbarian Teleport",
				"Teleports you to the Barbarian\\noutpost", TDA, 15, 0, 5);
		addLunar3RunesBigBox(30146, 9075, 563, 554, 1, 1, 5, 30012, 30003, 75,
				"Ardougne Teleport", "Teleports players to Ardougne", TDA, 16,
				0, 5);
		addLunar3RunesSmallBox(30154, 9075, 554, 556, 1, 5, 9, 30003, 30005,
				76, "Superglass Make", "Make glass without a furnace", TDA, 17,
				16, 2);
		addLunar3RunesSmallBox(30162, 9075, 563, 555, 1, 1, 3, 30012, 30004,
				77, "Watchtowner Teleport", "Teleports you to the Watchtower",
				TDA, 18, 0, 5);
		addLunar3RunesSmallBox(30170, 9075, 563, 555, 1, 1, 7, 30012, 30004,
				78, "Special Teleports", "Teleports players to various places",
				TDA, 19, 0, 5);
		addLunar3RunesBigBox(30178, 9075, 564, 559, 1, 0, 4, 30013, 30008, 78,
				"Dream", "Take a rest and restore hitpoints 3\\n times faster",
				TDA, 20, 0, 5);
		addLunar3RunesSmallBox(30186, 9075, 557, 555, 1, 9, 4, 30006, 30004,
				79, "String Jewellery", "String amulets without wool", TDA, 21,
				0, 5);
		addLunar3RunesLargeBox(30194, 9075, 557, 555, 1, 9, 9, 30006, 30004,
				80, "Stat Restore Pot\\nShare",
				"Share a potion with up to 4 nearby\\nplayers", TDA, 22, 0, 5);
		addLunar3RunesSmallBox(30202, 9075, 554, 555, 1, 6, 6, 30003, 30004,
				81, "Magic Imbue", "Combine runes without a talisman", TDA, 23,
				0, 5);
		addLunar3RunesBigBox(30210, 9075, 561, 557, 2, 1, 14, 30010, 30006, 82,
				"Fertile Soil",
				"Fertilise a farming patch with super\\ncompost", TDA, 24, 4, 2);
		addLunar3RunesBigBox(30218, 9075, 557, 555, 2, 11, 9, 30006, 30004, 83,
				"Boost Potion Share",
				"Shares a potion with up to 4 nearby\\nplayers", TDA, 25, 0, 5);
		addLunar3RunesSmallBox(30226, 9075, 563, 555, 2, 2, 9, 30012, 30004,
				84, "Fishing Guild Teleport",
				"Teleports you to the fishing guild", TDA, 26, 0, 5);
		addLunar3RunesLargeBox(30234, 9075, 563, 555, 1, 2, 13, 30012, 30004,
				85, "Canifis Teleport", "Teleports players to Canifis", TDA, 27,
				0, 5);
		addLunar3RunesSmallBox(30242, 9075, 557, 561, 2, 14, 0, 30006, 30010,
				85, "Plank Make", "Turn Logs into planks", TDA, 28, 16, 5);
		/******** Cut Off Limit **********/
		addLunar3RunesSmallBox(30250, 9075, 563, 555, 2, 2, 9, 30012, 30004,
				86, "Varrock Dungeon Teleport",
				"Teleports you to Varrock Dungeon", TDA, 29, 0, 5);
		addLunar3RunesSmallBox(30258, 9075, 563, 555, 2, 2, 14, 30012, 30004,
				87, "Taverly Teleport", "Teleports players to Taverly", TDA,
				30, 0, 5);
		addLunar3RunesSmallBox(30266, 9075, 563, 555, 2, 2, 7, 30012, 30004,
				88, "Ice Plateau Teleport", "Teleports you to Ice Plateau",
				TDA, 31, 0, 5);
		addLunar3RunesBigBox(30274, 9075, 563, 555, 2, 2, 15, 30012, 30004, 89,
				"Wildy Rune Rock Teleport",
				"Teleports players to Wild Rune Rocks", TDA, 32, 0, 5);
		addLunar3RunesBigBox(
				30282,
				9075,
				563,
				561,
				2,
				1,
				0,
				30012,
				30010,
				90,
				"Energy Transfer",
				"Spend hitpoints and SA Energy to\\n give another player hitpoints and run energy",
				TDA, 33, 8, 2);
		addLunar3RunesBigBox(30290, 9075, 563, 565, 2, 2, 0, 30012, 30014, 91,
				"Heal Other",
				"Transfer up to 75% of hitpoints\\n to another player", TDA,
				34, 8, 2);
		addLunar3RunesBigBox(30298, 9075, 560, 557, 2, 1, 9, 30009, 30006, 92,
				"Vengeance Other",
				"Allows another player to rebound\\ndamage to an opponent",
				TDA, 35, 8, 2);
		addLunar3RunesSmallBox(30306, 9075, 560, 557, 3, 1, 9, 30009, 30006,
				93, "Vengeance", "Rebound damage to an opponent", TDA, 36, 0, 5);
		addLunar3RunesBigBox(30314, 9075, 565, 563, 3, 2, 5, 30014, 30012, 94,
				"Heal Group", "Transfer up to 75% of hitpoints to a group",
				TDA, 37, 0, 5);
		addLunar3RunesBigBox(30322, 9075, 564, 563, 2, 1, 0, 30013, 30012, 95,
				"Spellbook Swap",
				"Change to another spellbook for 1\\nspell cast", TDA, 38, 0, 5);
	}

	public static void constructLunar() {
		RSInterface Interface = addInterface(29999);
		setChildren(80, Interface);
		setBounds(30000, 11, 10, 0, Interface);
		setBounds(30017, 40, 9, 1, Interface);
		setBounds(30025, 71, 12, 2, Interface);
		setBounds(30032, 103, 10, 3, Interface);
		setBounds(30040, 135, 12, 4, Interface);
		setBounds(30048, 165, 10, 5, Interface);
		setBounds(30056, 8, 38, 6, Interface);
		setBounds(30064, 39, 39, 7, Interface);
		setBounds(30075, 71, 39, 8, Interface);
		setBounds(30083, 103, 39, 9, Interface);
		setBounds(30091, 135, 39, 10, Interface);
		setBounds(30099, 165, 37, 11, Interface);
		setBounds(30106, 12, 68, 12, Interface);
		setBounds(30114, 42, 68, 13, Interface);
		setBounds(30122, 71, 68, 14, Interface);
		setBounds(30130, 103, 68, 15, Interface);
		setBounds(30138, 135, 68, 16, Interface);
		setBounds(30146, 165, 68, 17, Interface);
		setBounds(30154, 14, 97, 18, Interface);
		setBounds(30162, 42, 97, 19, Interface);
		setBounds(30170, 71, 97, 20, Interface);
		setBounds(30178, 101, 97, 21, Interface);
		setBounds(30186, 135, 98, 22, Interface);
		setBounds(30194, 168, 98, 23, Interface);
		setBounds(30202, 11, 125, 24, Interface);
		setBounds(30210, 42, 124, 25, Interface);
		setBounds(30218, 74, 125, 26, Interface);
		setBounds(30226, 103, 125, 27, Interface);
		setBounds(30234, 135, 125, 28, Interface);
		setBounds(30242, 164, 126, 29, Interface);
		setBounds(30250, 10, 155, 30, Interface);
		setBounds(30258, 42, 155, 31, Interface);
		setBounds(30266, 71, 155, 32, Interface);
		setBounds(30274, 103, 155, 33, Interface);
		setBounds(30282, 136, 155, 34, Interface);
		setBounds(30290, 165, 155, 35, Interface);
		setBounds(30298, 13, 185, 36, Interface);
		setBounds(30306, 42, 185, 37, Interface);
		setBounds(30314, 71, 184, 38, Interface);
		setBounds(30322, 104, 184, 39, Interface);
		setBounds(30001, 6, 184, 40, Interface);// hover
		setBounds(30018, 5, 176, 41, Interface);// hover
		setBounds(30026, 5, 176, 42, Interface);// hover
		setBounds(30033, 5, 163, 43, Interface);// hover
		setBounds(30041, 5, 176, 44, Interface);// hover
		setBounds(30049, 5, 176, 45, Interface);// hover
		setBounds(30057, 5, 176, 46, Interface);// hover
		setBounds(30065, 5, 176, 47, Interface);// hover
		setBounds(30076, 5, 163, 48, Interface);// hover
		setBounds(30084, 5, 176, 49, Interface);// hover
		setBounds(30092, 5, 176, 50, Interface);// hover
		setBounds(30100, 5, 176, 51, Interface);// hover
		setBounds(30107, 5, 176, 52, Interface);// hover
		setBounds(30115, 5, 163, 53, Interface);// hover
		setBounds(30123, 5, 176, 54, Interface);// hover
		setBounds(30131, 5, 163, 55, Interface);// hover
		setBounds(30139, 5, 163, 56, Interface);// hover
		setBounds(30147, 5, 163, 57, Interface);// hover
		setBounds(30155, 5, 176, 58, Interface);// hover
		setBounds(30163, 5, 176, 59, Interface);// hover
		setBounds(30171, 5, 176, 60, Interface);// hover
		setBounds(30179, 5, 163, 61, Interface);// hover
		setBounds(30187, 5, 176, 62, Interface);// hover
		setBounds(30195, 5, 149, 63, Interface);// hover
		setBounds(30203, 5, 176, 64, Interface);// hover
		setBounds(30211, 5, 163, 65, Interface);// hover
		setBounds(30219, 5, 163, 66, Interface);// hover
		setBounds(30227, 5, 176, 67, Interface);// hover
		setBounds(30235, 5, 149, 68, Interface);// hover
		setBounds(30243, 5, 176, 69, Interface);// hover
		setBounds(30251, 5, 5, 70, Interface);// hover
		setBounds(30259, 5, 5, 71, Interface);// hover
		setBounds(30267, 5, 5, 72, Interface);// hover
		setBounds(30275, 5, 5, 73, Interface);// hover
		setBounds(30283, 5, 5, 74, Interface);// hover
		setBounds(30291, 5, 5, 75, Interface);// hover
		setBounds(30299, 5, 5, 76, Interface);// hover
		setBounds(30307, 5, 5, 77, Interface);// hover
		setBounds(30323, 5, 5, 78, Interface);// hover
		setBounds(30315, 5, 5, 79, Interface);// hover
	}

	public static void addText(int i, String s, int k, boolean l, boolean m,
			int a, TextDrawingArea[] TDA, int j) {
		RSInterface rsinterface = addInterface(i);
		rsinterface.parentID = i;
		rsinterface.id = i;
		rsinterface.type = 4;
		rsinterface.atActionType = 0;
		rsinterface.width = 0;
		rsinterface.height = 0;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = a;
		rsinterface.centerText = l;
		rsinterface.textShadow = m;
		rsinterface.textDrawingAreas = TDA[j];
		rsinterface.message = s;
		rsinterface.textColor = k;
	}

	public static void addText(int i, String s, int k, boolean l, boolean m,
			int a, int j) {
		RSInterface rsinterface = addTabInterface(i);
		rsinterface.parentID = i;
		rsinterface.id = i;
		rsinterface.type = 4;
		rsinterface.atActionType = 0;
		rsinterface.width = 0;
		rsinterface.height = 0;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = a;
		rsinterface.centerText = l;
		rsinterface.textShadow = m;
		// rsinterface.textDrawingAreas = TDA[j];
		rsinterface.textDrawingAreas = RSInterface.fonts[j];
		rsinterface.message = s;
		rsinterface.textColor = k;
	}

	public static RSInterface addInterface(int ID) {
		RSInterface Tab = RSInterface.interfaceCache[ID] = new RSInterface();
		Tab.id = ID;
		Tab.parentID = ID;
		Tab.type = 0;
		Tab.atActionType = 0;
		Tab.contentType = 0;
		Tab.width = 511;
		Tab.height = 334;
		Tab.aByte254 = (byte) 0;
		Tab.mOverInterToTrigger = 0;
		return Tab;
	}

	public static void addCacheSprite(int id, int sprite1, int sprite2,
			String sprites) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.sprite1 = method207(sprite1, aClass44, sprites);
		rsi.sprite2 = method207(sprite2, aClass44, sprites);
		rsi.parentID = id;
		rsi.id = id;
		rsi.type = 5;
	}

	public static void sprite1(int id, int sprite) {
		RSInterface class9 = interfaceCache[id];
		class9.sprite1 = imageLoaderA(sprite, "");
	}

	public static void addActionButton(int id, int sprite, int sprite2,
			int width, int height, String s) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.sprite1 = imageLoaderA(sprite, "");
		if (sprite2 == sprite)
			rsi.sprite2 = imageLoaderA(sprite, "a");
		else
			rsi.sprite2 = imageLoaderA(sprite2, "");
		rsi.tooltip = s;
		rsi.contentType = 0;
		rsi.atActionType = 1;
		rsi.width = width;
		rsi.mOverInterToTrigger = 52;
		rsi.parentID = id;
		rsi.id = id;
		rsi.type = 5;
		rsi.height = height;
	}

	public static void addToggleButton(int id, int sprite, int setconfig,
			int width, int height, String s) {
		RSInterface rsi = addInterface(id);
		rsi.sprite1 = imageLoaderA(sprite, "");
		rsi.sprite2 = imageLoaderA(sprite, "a");
		rsi.anIntArray212 = new int[1];
		rsi.anIntArray212[0] = 1;
		rsi.anIntArray245 = new int[1];
		rsi.anIntArray245[0] = 1;
		rsi.valueIndexArray = new int[1][3];
		rsi.valueIndexArray[0][0] = 5;
		rsi.valueIndexArray[0][1] = setconfig;
		rsi.valueIndexArray[0][2] = 0;
		rsi.atActionType = 4;
		rsi.width = width;
		rsi.mOverInterToTrigger = -1;
		rsi.parentID = id;
		rsi.id = id;
		rsi.type = 5;
		rsi.height = height;
		rsi.tooltip = s;
	}

	public static void removeSomethingS(int id) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
	}

	public void totalChildrenS(int id, int x, int y) {
		children = new int[id];
		childX = new int[x];
		childY = new int[y];
	}

	public void specialBar(int id) // 7599
	{
		/*
		 * addActionButton(ID, SpriteOFF, SpriteON, Width, Height,
		 * "SpriteText");
		 */
		addActionButton(id - 12, 7587, -1, 150, 26, "Use @gre@Special Attack");
		/* removeSomething(ID); */
		for (int i = id - 11; i < id; i++)
			removeSomethingS(i);

		RSInterface rsi = interfaceCache[id - 12];
		rsi.width = 150;
		rsi.height = 26;

		rsi = interfaceCache[id];
		rsi.width = 150;
		rsi.height = 26;

		rsi.child(0, id - 12, 0, 0);

		rsi.child(12, id + 1, 3, 7);

		rsi.child(23, id + 12, 16, 8);

		for (int i = 13; i < 23; i++) {
			rsi.childY[i] -= 1;
		}

		rsi = interfaceCache[id + 1];
		rsi.type = 5;
		rsi.sprite1 = imageLoaderA(7600, "");

		for (int i = id + 2; i < id + 12; i++) {
			rsi = interfaceCache[i];
			rsi.type = 5;
		}
		sprite1(id + 2, 7601);
		sprite1(id + 3, 7602);
		sprite1(id + 4, 7603);
		sprite1(id + 5, 7604);
		sprite1(id + 6, 7605);
		sprite1(id + 7, 7606);
		sprite1(id + 8, 7607);
		sprite1(id + 9, 7608);
		sprite1(id + 10, 7609);
		sprite1(id + 11, 7610);
	}

	public static void Sidebar0(TextDrawingArea[] tda) {
		/*
		 * Sidebar0a(id, id2, id3, "text1", "text2", "text3", "text4", str1x,
		 * str1y, str2x, str2y, str3x, str3y, str4x, str4y, img1x, img1y, img2x,
		 * img2y, img3x, img3y, img4x, img4y, tda);
		 */
		Sidebar0a(1698, 1701, 7499, "Chop", "Hack", "Smash", "Block", 42, 75,
				127, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0a(2276, 2279, 7574, "Stab", "Lunge", "Slash", "Block", 43, 75,
				124, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0a(2423, 2426, 7599, "Chop", "Slash", "Lunge", "Block", 42, 75,
				125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0a(3796, 3799, 7624, "Pound", "Pummel", "Spike", "Block", 39,
				75, 121, 75, 41, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40,
				103, tda);
		Sidebar0a(4679, 4682, 7674, "Lunge", "Swipe", "Pound", "Block", 40, 75,
				124, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0a(4705, 4708, 7699, "Chop", "Slash", "Smash", "Block", 42, 75,
				125, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		Sidebar0a(5570, 5573, 7724, "Spike", "Impale", "Smash", "Block", 41,
				75, 123, 75, 39, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40,
				103, tda);
		Sidebar0a(7762, 7765, 7800, "Chop", "Slash", "Lunge", "Block", 42, 75,
				125, 75, 40, 128, 125, 128, 122, 103, 40, 50, 122, 50, 40, 103,
				tda);
		/*
		 * Sidebar0b(id, id2, "text1", "text2", "text3", "text4", str1x, str1y,
		 * str2x, str2y, str3x, str3y, str4x, str4y, img1x, img1y, img2x, img2y,
		 * img3x, img3y, img4x, img4y, tda);
		 */
		Sidebar0b(776, 779, "Reap", "Chop", "Jab", "Block", 42, 75, 126, 75,
				46, 128, 125, 128, 122, 103, 122, 50, 40, 103, 40, 50, tda);
		/*
		 * Sidebar0c(id, id2, id3, "text1", "text2", "text3", str1x, str1y,
		 * str2x, str2y, str3x, str3y, img1x, img1y, img2x, img2y, img3x, img3y,
		 * tda);
		 */
		Sidebar0c(425, 428, 7474, "Pound", "Pummel", "Block", 39, 75, 121, 75,
				42, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(1749, 1752, 7524, "Accurate", "Rapid", "Longrange", 33, 75,
				125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(1764, 1767, 7549, "Accurate", "Rapid", "Longrange", 33, 75,
				125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(4446, 4449, 7649, "Accurate", "Rapid", "Longrange", 33, 75,
				125, 75, 29, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(5855, 5857, 7749, "Punch", "Kick", "Block", 40, 75, 129, 75,
				42, 128, 40, 50, 122, 50, 40, 103, tda);
		Sidebar0c(6103, 6132, 6117, "Bash", "Pound", "Block", 43, 75, 124, 75,
				42, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(8460, 8463, 8493, "Jab", "Swipe", "Fend", 46, 75, 124, 75,
				43, 128, 40, 103, 40, 50, 122, 50, tda);
		Sidebar0c(12290, 12293, 12323, "Flick", "Lash", "Deflect", 44, 75, 127,
				75, 36, 128, 40, 50, 40, 103, 122, 50, tda);
		/*
		 * Sidebar0d(id, id2, "text1", "text2", "text3", str1x, str1y, str2x,
		 * str2y, str3x, str3y, img1x, img1y, img2x, img2y, img3x, img3y, tda);
		 */
		Sidebar0d(328, 331, "Bash", "Pound", "Focus", 42, 66, 39, 101, 41, 136,
				40, 120, 40, 50, 40, 85, tda);

		RSInterface rsi = addInterface(19300);
		/* textSize(ID, wid, Size); */
		textSize(3983, tda, 0);
		/* addToggleButton(id, sprite, config, width, height, wid); */
		addToggleButton(150, 150, 172, 150, 44, "Auto Retaliate");

		rsi.totalChildrenS(2, 2, 2);
		rsi.child(0, 3983, 52, 25); // combat level
		rsi.child(1, 150, 21, 153); // auto retaliate

		rsi = interfaceCache[3983];
		rsi.centerText = true;
		rsi.textColor = 0xff981f;
	}

	public static void Sidebar0a(int id, int id2, int id3, String text1,
			String text2, String text3, String text4, int str1x, int str1y,
			int str2x, int str2y, int str3x, int str3y, int str4x, int str4y,
			int img1x, int img1y, int img2x, int img2y, int img3x, int img3y,
			int img4x, int img4y, TextDrawingArea[] tda) // 4button spec
	{
		RSInterface rsi = addInterface(id); // 2423
		/* addText(ID, "Text", tda, Size, Colour, Centered); */
		addText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addText(id2 + 11, text1, tda, 0, 0xff981f, false);
		addText(id2 + 12, text2, tda, 0, 0xff981f, false);
		addText(id2 + 13, text3, tda, 0, 0xff981f, false);
		addText(id2 + 14, text4, tda, 0, 0xff981f, false);
		/* specialBar(ID); */
		rsi.specialBar(id3); // 7599

		rsi.width = 190;
		rsi.height = 261;

		int last = 15;
		int frame = 0;
		rsi.totalChildrenS(last, last, last);

		rsi.child(frame, id2 + 3, 21, 46);
		frame++; // 2429
		rsi.child(frame, id2 + 4, 104, 99);
		frame++; // 2430
		rsi.child(frame, id2 + 5, 21, 99);
		frame++; // 2431
		rsi.child(frame, id2 + 6, 105, 46);
		frame++; // 2432

		rsi.child(frame, id2 + 7, img1x, img1y);
		frame++; // bottomright 2433
		rsi.child(frame, id2 + 8, img2x, img2y);
		frame++; // topleft 2434
		rsi.child(frame, id2 + 9, img3x, img3y);
		frame++; // bottomleft 2435
		rsi.child(frame, id2 + 10, img4x, img4y);
		frame++; // topright 2436

		rsi.child(frame, id2 + 11, str1x, str1y);
		frame++; // chop 2437
		rsi.child(frame, id2 + 12, str2x, str2y);
		frame++; // slash 2438
		rsi.child(frame, id2 + 13, str3x, str3y);
		frame++; // lunge 2439
		rsi.child(frame, id2 + 14, str4x, str4y);
		frame++; // block 2440

		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon 2426
		rsi.child(frame, id3, 21, 205);
		frame++; // special attack 7599

		for (int i = id2 + 3; i < id2 + 7; i++) { // 2429 - 2433
			rsi = interfaceCache[i];
			rsi.sprite1 = imageLoaderA(19301, "");
			rsi.sprite2 = imageLoaderA(19301, "a");
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0b(int id, int id2, String text1, String text2,
			String text3, String text4, int str1x, int str1y, int str2x,
			int str2y, int str3x, int str3y, int str4x, int str4y, int img1x,
			int img1y, int img2x, int img2y, int img3x, int img3y, int img4x,
			int img4y, TextDrawingArea[] tda) // 4button nospec
	{
		RSInterface rsi = addInterface(id); // 2423
		/* addText(ID, "Text", tda, Size, Colour, Centered); */
		addText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addText(id2 + 11, text1, tda, 0, 0xff981f, false);
		addText(id2 + 12, text2, tda, 0, 0xff981f, false);
		addText(id2 + 13, text3, tda, 0, 0xff981f, false);
		addText(id2 + 14, text4, tda, 0, 0xff981f, false);

		rsi.width = 190;
		rsi.height = 261;

		int last = 14;
		int frame = 0;
		rsi.totalChildrenS(last, last, last);

		rsi.child(frame, id2 + 3, 21, 46);
		frame++; // 2429
		rsi.child(frame, id2 + 4, 104, 99);
		frame++; // 2430
		rsi.child(frame, id2 + 5, 21, 99);
		frame++; // 2431
		rsi.child(frame, id2 + 6, 105, 46);
		frame++; // 2432

		rsi.child(frame, id2 + 7, img1x, img1y);
		frame++; // bottomright 2433
		rsi.child(frame, id2 + 8, img2x, img2y);
		frame++; // topleft 2434
		rsi.child(frame, id2 + 9, img3x, img3y);
		frame++; // bottomleft 2435
		rsi.child(frame, id2 + 10, img4x, img4y);
		frame++; // topright 2436

		rsi.child(frame, id2 + 11, str1x, str1y);
		frame++; // chop 2437
		rsi.child(frame, id2 + 12, str2x, str2y);
		frame++; // slash 2438
		rsi.child(frame, id2 + 13, str3x, str3y);
		frame++; // lunge 2439
		rsi.child(frame, id2 + 14, str4x, str4y);
		frame++; // block 2440

		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon 2426

		for (int i = id2 + 3; i < id2 + 7; i++) { // 2429 - 2433
			rsi = interfaceCache[i];
			rsi.sprite1 = imageLoaderA(19301, "");
			rsi.sprite2 = imageLoaderA(19301, "a");
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0c(int id, int id2, int id3, String text1,
			String text2, String text3, int str1x, int str1y, int str2x,
			int str2y, int str3x, int str3y, int img1x, int img1y, int img2x,
			int img2y, int img3x, int img3y, TextDrawingArea[] tda) // 3button
																	// spec
	{
		RSInterface rsi = addInterface(id); // 2423
		/* addText(ID, "Text", tda, Size, Colour, Centered); */
		addText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addText(id2 + 9, text1, tda, 0, 0xff981f, false);
		addText(id2 + 10, text2, tda, 0, 0xff981f, false);
		addText(id2 + 11, text3, tda, 0, 0xff981f, false);
		/* specialBar(ID); */
		rsi.specialBar(id3); // 7599

		rsi.width = 190;
		rsi.height = 261;

		int last = 12;
		int frame = 0;
		rsi.totalChildrenS(last, last, last);

		rsi.child(frame, id2 + 3, 21, 99);
		frame++;
		rsi.child(frame, id2 + 4, 105, 46);
		frame++;
		rsi.child(frame, id2 + 5, 21, 46);
		frame++;

		rsi.child(frame, id2 + 6, img1x, img1y);
		frame++; // topleft
		rsi.child(frame, id2 + 7, img2x, img2y);
		frame++; // bottomleft
		rsi.child(frame, id2 + 8, img3x, img3y);
		frame++; // topright

		rsi.child(frame, id2 + 9, str1x, str1y);
		frame++; // chop
		rsi.child(frame, id2 + 10, str2x, str2y);
		frame++; // slash
		rsi.child(frame, id2 + 11, str3x, str3y);
		frame++; // lunge

		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon
		rsi.child(frame, id3, 21, 205);
		frame++; // special attack 7599

		for (int i = id2 + 3; i < id2 + 6; i++) {
			rsi = interfaceCache[i];
			rsi.sprite1 = imageLoaderA(19301, "");
			rsi.sprite2 = imageLoaderA(19301, "a");
			rsi.width = 68;
			rsi.height = 44;
		}
	}

	public static void Sidebar0d(int id, int id2, String text1, String text2,
			String text3, int str1x, int str1y, int str2x, int str2y,
			int str3x, int str3y, int img1x, int img1y, int img2x, int img2y,
			int img3x, int img3y, TextDrawingArea[] tda) // 3button nospec
															// (magic intf)
	{
		RSInterface rsi = addInterface(id); // 2423
		/* addText(ID, "Text", tda, Size, Colour, Centered); */
		addText(id2, "-2", tda, 3, 0xff981f, true); // 2426
		addText(id2 + 9, text1, tda, 0, 0xff981f, false);
		addText(id2 + 10, text2, tda, 0, 0xff981f, false);
		addText(id2 + 11, text3, tda, 0, 0xff981f, false);

		addText(353, "Spell", tda, 0, 0xff981f, false);
		addText(354, "Spell", tda, 0, 0xff981f, false);

		addCacheSprite(337, 19, 0, "combaticons");
		addCacheSprite(338, 13, 0, "combaticons2");
		addCacheSprite(339, 14, 0, "combaticons2");

		/* addToggleButton(id, sprite, config, width, height, tooltip); */
		addToggleButton(349, 349, 108, 68, 44, "Select");
		addToggleButton(350, 350, 108, 68, 44, "Select");

		rsi.width = 190;
		rsi.height = 261;

		int last = 15;
		int frame = 0;
		rsi.totalChildrenS(last, last, last);

		rsi.child(frame, id2 + 3, 20, 115);
		frame++;
		rsi.child(frame, id2 + 4, 20, 80);
		frame++;
		rsi.child(frame, id2 + 5, 20, 45);
		frame++;

		rsi.child(frame, id2 + 6, img1x, img1y);
		frame++; // topleft
		rsi.child(frame, id2 + 7, img2x, img2y);
		frame++; // bottomleft
		rsi.child(frame, id2 + 8, img3x, img3y);
		frame++; // topright

		rsi.child(frame, id2 + 9, str1x, str1y);
		frame++; // bash
		rsi.child(frame, id2 + 10, str2x, str2y);
		frame++; // pound
		rsi.child(frame, id2 + 11, str3x, str3y);
		frame++; // focus

		rsi.child(frame, 349, 105, 46);
		frame++; // spell1
		rsi.child(frame, 350, 104, 106);
		frame++; // spell2

		rsi.child(frame, 353, 125, 74);
		frame++; // spell
		rsi.child(frame, 354, 125, 134);
		frame++; // spell

		rsi.child(frame, 19300, 0, 0);
		frame++; // stuffs
		rsi.child(frame, id2, 94, 4);
		frame++; // weapon
	}

	public static void clanChatTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(18128);
		addHoverButton(18129, "SPRITE", 6, 72, 32, "Join Chat", 550, 18130, 1);
		addHoveredButton(18130, "SPRITE", 7, 72, 32, 18131);
		addHoverButton(18132, "SPRITE", 6, 72, 32, "Clan Chat Setup", -1,
				18133, 5);
		addHoveredButton(18133, "SPRITE", 7, 72, 32, 18134);
		addText(18135, "Join Chat", tda, 0, 0xff9b00, true, true);
		addText(18136, "Clan Setup", tda, 0, 0xff9b00, true, true);
		addSprite(18137, 37, "SPRITE");
		addText(18138, "Clan Chat", tda, 1, 0xff9b00, true, true);
		addText(18139, "Talking in: Not in chat", tda, 0, 0xff9b00, false, true);
		addText(18140, "Owner: None", tda, 0, 0xff9b00, false, true);
		tab.totalChildren(13);
		tab.child(0, 16126, 0, 221);
		tab.child(1, 16126, 0, 59);
		tab.child(2, 18137, 0, 62);
		tab.child(3, 18143, 0, 62);
		tab.child(4, 18129, 15, 226);
		tab.child(5, 18130, 15, 226);
		tab.child(6, 18132, 103, 226);
		tab.child(7, 18133, 103, 226);
		tab.child(8, 18135, 51, 237);
		tab.child(9, 18136, 139, 237);
		tab.child(10, 18138, 95, 1);
		tab.child(11, 18139, 10, 23);
		tab.child(12, 18140, 25, 38);
		/* Text area */
		RSInterface list = addTabInterface(18143);
		list.totalChildren(100);
		for (int i = 18144; i <= 18244; i++) {
			addText(i, "", tda, 0, 0xffffff, false, true);
		}
		for (int id = 18144, i = 0; id <= 18243 && i <= 99; id++, i++) {
			list.children[i] = id;
			list.childX[i] = 5;
			for (int id2 = 18144, i2 = 1; id2 <= 18243 && i2 <= 99; id2++, i2++) {
				list.childY[0] = 2;
				list.childY[i2] = list.childY[i2 - 1] + 14;
			}
		}
		list.height = 158;
		list.width = 174;
		list.scrollMax = 1405;
	}

	public static void emoteTab() {
		RSInterface tab = addTabInterface(147);
		RSInterface scroll = addTabInterface(148);
		tab.totalChildren(1);
		tab.child(0, 148, 0, 1);
		addButton(168, 0, "EMOTE", "Yes");
		addButton(169, 1, "EMOTE", "No");
		addButton(164, 2, "EMOTE", "Bow");
		addButton(165, 3, "EMOTE", "Angry");
		addButton(162, 4, "EMOTE", "Think");
		addButton(163, 5, "EMOTE", "Wave");
		addButton(13370, 6, "EMOTE", "Shrug");
		addButton(171, 7, "EMOTE", "Cheer");
		addButton(167, 8, "EMOTE", "Beckon");
		addButton(170, 9, "EMOTE", "Laugh");
		addButton(13366, 10, "EMOTE", "Jump for Joy");
		addButton(13368, 11, "EMOTE", "Yawn");
		addButton(166, 12, "EMOTE", "Dance");
		addButton(13363, 13, "EMOTE", "Jig");
		addButton(13364, 14, "EMOTE", "Spin");
		addButton(13365, 15, "EMOTE", "Headbang");
		addButton(161, 16, "EMOTE", "Cry");
		addButton(11100, 17, "EMOTE", "Blow kiss");
		addButton(13362, 18, "EMOTE", "Panic");
		addButton(13367, 19, "EMOTE", "Raspberry");
		addButton(172, 20, "EMOTE", "Clap");
		addButton(13369, 21, "EMOTE", "Salute");
		addButton(13383, 22, "EMOTE", "Goblin Bow");
		addButton(13384, 23, "EMOTE", "Goblin Salute");
		addButton(667, 24, "EMOTE", "Glass Box");
		addButton(6503, 25, "EMOTE", "Climb Rope");
		addButton(6506, 26, "EMOTE", "Lean On Air");
		addButton(666, 27, "EMOTE", "Glass Wall");
		addButton(18464, 28, "EMOTE", "Zombie Walk");
		addButton(18465, 29, "EMOTE", "Zombie Dance");
		addButton(15166, 30, "EMOTE", "Scared");
		addButton(18686, 31, "EMOTE", "Rabbit Hop");
		addButton(154, 32, "EMOTE", "Skillcape Emote");
		scroll.totalChildren(33);
		scroll.child(0, 168, 10, 7);
		scroll.child(1, 169, 54, 7);
		scroll.child(2, 164, 98, 14);
		scroll.child(3, 165, 137, 7);
		scroll.child(4, 162, 9, 56);
		scroll.child(5, 163, 48, 56);
		scroll.child(6, 13370, 95, 56);
		scroll.child(7, 171, 137, 56);
		scroll.child(8, 167, 7, 105);
		scroll.child(9, 170, 51, 105);
		scroll.child(10, 13366, 95, 104);
		scroll.child(11, 13368, 139, 105);
		scroll.child(12, 166, 6, 154);
		scroll.child(13, 13363, 50, 154);
		scroll.child(14, 13364, 90, 154);
		scroll.child(15, 13365, 135, 154);
		scroll.child(16, 161, 8, 204);
		scroll.child(17, 11100, 51, 203);
		scroll.child(18, 13362, 99, 204);
		scroll.child(19, 13367, 137, 203);
		scroll.child(20, 172, 10, 253);
		scroll.child(21, 13369, 53, 253);
		scroll.child(22, 13383, 88, 258);
		scroll.child(23, 13384, 138, 252);
		scroll.child(24, 667, 2, 303);
		scroll.child(25, 6503, 49, 302);
		scroll.child(26, 6506, 93, 302);
		scroll.child(27, 666, 137, 302);
		scroll.child(28, 18464, 9, 352);
		scroll.child(29, 18465, 50, 352);
		scroll.child(30, 15166, 94, 356);
		scroll.child(31, 18686, 141, 353);
		scroll.child(32, 154, 5, 401);
		scroll.width = 173;
		scroll.height = 258;
		scroll.scrollMax = 450;
	}

	public static void achievement(TextDrawingArea[] wid) {
		RSInterface intachievement = addTabInterface(26600);
		RSInterface pnl0 = addTabInterface(26601);
		RSInterface pnl1 = addTabInterface(26602);
		RSInterface pnl2 = addTabInterface(26603);
		intachievement.totalChildren(5);
		// intachievement.child(0, 25999, 6, 6);//exit
		intachievement.child(1, 26604, 4, 16);
		intachievement.child(2, 26601, 7, 9);
		intachievement.child(3, 26602, 7, 84);
		intachievement.child(4, 26603, 157, 90);
		// addHButton(25999, "Close", 0, 16, 16, "Close Button", 14513, 6, 6);
		// tab.child(4, 6605, 4, 16);
		addSprite(26604, 0, "BLOOD");
		pnl0.totalChildren(2);
		pnl0.child(0, 26605, 7, 9);
		pnl0.child(1, 25999, 4, 10);
		pnl0.width = 485;
		pnl0.height = 75;
		addSprite(26605, 0, "TITLE");
		addHButton(25999, "Close", 0, 16, 16, "Close Button", 14513, 4, 10);

		pnl1.totalChildren(5);
		pnl1.child(0, 26606, 4, 102);
		pnl1.child(1, 26607, 4, 59);
		pnl1.child(2, 26608, 4, 139);
		pnl1.child(3, 26609, 4, 170);
		pnl1.child(4, 26610, 4, 16);
		pnl1.width = 150;
		pnl1.height = 210;
		addButton(26606, 1, "monsterk", "Yes");
		addButton(26607, 1, "misc", "Yes");
		addButton(26608, 1, "pking", "Yes");
		addButton(26609, 1, "skilling", "Yes");
		addButton(26610, 1, "combat", "Yes");

		for (int i = 26612; i <= 26712; i++) {
			// addText(i, "Line id: "+i+"", wid, 0, 0xff981f, false, false);
			addButton(i, 5, "combat", "Yes");
		}
		for (int i = 26713; i <= 26813; i++) {

			addText(i, "", wid, 2, 0xff981f, false, false);
		}
		for (int i = 26814; i <= 26914; i++) {

			addText(i, "", wid, 1, 0xff981f, false, false);
		}

		for (int i = 27115; i <= 27215; i++) {

			addText(i, "", wid, 2, 0xff981f, false, false);
		}
		pnl2.totalChildren(404);
		int Id = 0;
		int y = 2;
		int x = 15;
		int q = 30;
		int z = 30;
		for (int i = 26612; i <= 26712; i++) {
			pnl2.child(Id, i, 0, y);
			Id++;
			y += 53;
		}

		for (int i = 26713; i <= 26813; i++) {
			pnl2.child(Id, i, 120, x);
			Id++;
			x += 53;
		}
		for (int i = 26814; i <= 26914; i++) {
			pnl2.child(Id, i, 115, q);
			Id++;
			q += 53;
		}
		for (int i = 27115; i <= 27215; i++) {
			pnl2.child(Id, i, 305, z);
			Id++;
			z += 53;
		}
		pnl2.scrollMax = 1165;
		pnl2.width = 325;
		pnl2.height = 210;

	}

	public static void optionTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(904);
		RSInterface energy = interfaceCache[149];
		energy.textColor = 0xff9933;
		addSprite(905, 9, "SPRITE");
		addSprite(907, 18, "SPRITE");
		addSprite(909, 29, "SPRITE");
		addSprite(951, 32, "SPRITE");
		addSprite(953, 33, "SPRITE");
		addSprite(955, 34, "SPRITE");
		addSprite(947, 36, "SPRITE");
		addSprite(949, 35, "SPRITE");
		addConfigButton(152, 904, 30, 31, "SPRITE", 40, 40, "Toggle-run", 1, 5,
				173);
		addConfigButton(906, 904, 10, 14, "SPRITE", 32, 16, "Dark", 1, 5, 166);
		addConfigButton(908, 904, 11, 15, "SPRITE", 32, 16, "Normal", 2, 5, 166);
		addConfigButton(910, 904, 12, 16, "SPRITE", 32, 16, "Bright", 3, 5, 166);
		addConfigButton(912, 904, 13, 17, "SPRITE", 32, 16, "Very Bright", 4,
				5, 166);
		addConfigButton(930, 904, 19, 24, "SPRITE", 26, 16, "Music Off", 4, 5,
				168);
		addConfigButton(931, 904, 20, 25, "SPRITE", 26, 16, "Music Level-1", 3,
				5, 168);
		addConfigButton(932, 904, 21, 26, "SPRITE", 26, 16, "Music Level-2", 2,
				5, 168);
		addConfigButton(933, 904, 22, 27, "SPRITE", 26, 16, "Music Level-3", 1,
				5, 168);
		addConfigButton(934, 904, 23, 28, "SPRITE", 24, 16, "Music Level-4", 0,
				5, 168);
		addConfigButton(941, 904, 19, 24, "SPRITE", 26, 16,
				"Sound Effects Off", 4, 5, 169);
		addConfigButton(942, 904, 20, 25, "SPRITE", 26, 16,
				"Sound Effects Level-1", 3, 5, 169);
		addConfigButton(943, 904, 21, 26, "SPRITE", 26, 16,
				"Sound Effects Level-2", 2, 5, 169);
		addConfigButton(944, 904, 22, 27, "SPRITE", 26, 16,
				"Sound Effects Level-3", 1, 5, 169);
		addConfigButton(945, 904, 23, 28, "SPRITE", 24, 16,
				"Sound Effects Level-4", 0, 5, 169);
		addConfigButton(913, 904, 30, 31, "SPRITE", 40, 40,
				"Toggle-Mouse Buttons", 0, 5, 170);
		addConfigButton(915, 904, 30, 31, "SPRITE", 40, 40,
				"Toggle-Chat Effects", 0, 5, 171);
		addConfigButton(957, 904, 30, 31, "SPRITE", 40, 40,
				"Toggle-Split Private Chat", 1, 5, 287);
		addConfigButton(12464, 904, 30, 31, "SPRITE", 40, 40,
				"Toggle-Accept Aid", 0, 5, 427);
		tab.totalChildren(28);
		int x = 0;
		int y = 2;
		tab.child(0, 905, 13 + x, 10 + y);
		tab.child(1, 906, 48 + x, 18 + y);
		tab.child(2, 908, 80 + x, 18 + y);
		tab.child(3, 910, 112 + x, 18 + y);
		tab.child(4, 912, 144 + x, 18 + y);
		tab.child(5, 907, 14 + x, 55 + y);
		tab.child(6, 930, 49 + x, 61 + y);
		tab.child(7, 931, 75 + x, 61 + y);
		tab.child(8, 932, 101 + x, 61 + y);
		tab.child(9, 933, 127 + x, 61 + y);
		tab.child(10, 934, 151 + x, 61 + y);
		tab.child(11, 909, 13 + x, 99 + y);
		tab.child(12, 941, 49 + x, 104 + y);
		tab.child(13, 942, 75 + x, 104 + y);
		tab.child(14, 943, 101 + x, 104 + y);
		tab.child(15, 944, 127 + x, 104 + y);
		tab.child(16, 945, 151 + x, 104 + y);
		tab.child(17, 913, 15, 153);
		tab.child(18, 955, 19, 159);
		tab.child(19, 915, 75, 153);
		tab.child(20, 953, 79, 160);
		tab.child(21, 957, 135, 153);
		tab.child(22, 951, 139, 159);
		tab.child(23, 12464, 15, 208);
		tab.child(24, 949, 20, 213);
		tab.child(25, 152, 75, 208);
		tab.child(26, 947, 87, 212);
		tab.child(27, 149, 80, 231);
	}

	public static void addConfigButton(int ID, int pID, int bID, int bID2,
			String bName, int width, int height, String tT, int configID,
			int aT, int configFrame) {
		RSInterface Tab = addTabInterface(ID);
		Tab.parentID = pID;
		Tab.id = ID;
		Tab.type = 5;
		Tab.atActionType = aT;
		Tab.contentType = 0;
		Tab.width = width;
		Tab.height = height;
		Tab.aByte254 = 0;
		Tab.mOverInterToTrigger = -1;
		Tab.anIntArray245 = new int[1];
		Tab.anIntArray212 = new int[1];
		Tab.anIntArray245[0] = 1;
		Tab.anIntArray212[0] = configID;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.sprite1 = imageLoader(bID, bName);
		Tab.sprite2 = imageLoader(bID2, bName);
		Tab.tooltip = tT;
	}

	public static void addChar(int ID) {
		RSInterface t = interfaceCache[ID] = new RSInterface();
		t.id = ID;
		t.parentID = ID;
		t.type = 6;
		t.atActionType = 0;
		t.contentType = 669;
		t.width = 136;
		t.height = 168;
		t.aByte254 = 0;
		t.mOverInterToTrigger = 0;
		t.anInt269 = 560;
		t.modelRotation1 = 150;
		t.modelRotation2 = 0;
		t.anInt257 = -1;
		t.anInt258 = -1;
	}

	public static void textColor(int id, int color) {
		RSInterface rsi = interfaceCache[id];
		rsi.textColor = color;
	}

	public static void textSize(int id, TextDrawingArea tda[], int idx) {
		RSInterface rsi = interfaceCache[id];
		rsi.textDrawingAreas = tda[idx];
	}

	public static void EquipmentTab(TextDrawingArea[] tda) {
		RSInterface tab = interfaceCache[1644];
		addHoverButton(15201, "CUSTOM", 1, 40, 40, "Show Equipment Screen", 0,
				15202, 1);
		addHoveredButton(15202, "CUSTOM", 5, 40, 40, 15203);
		addHoverButton(15204, "CUSTOM", 2, 40, 40, "Items Kept on Death", 0,
				15205, 1);
		addHoveredButton(15205, "CUSTOM", 4, 40, 40, 15206);
		addHoverButton(15207, "CUSTOM", 3, 40, 40, "Experience Lock", 0, 15208,
				1);
		addHoveredButton(15208, "CUSTOM", 6, 40, 40, 15209);
		addText(15226, "@whi@(Unlocked)", tda, 0, 0xff981f, true, true);

		// removeSomething(15109);

		tab.child(23, 15201, 21, 210);
		tab.child(1, 15226, 95, 250);
		tab.child(24, 15202, 21, 210);
		tab.child(25, 15204, 129, 210);
		tab.child(26, 15205, 129, 210);
		tab.child(0, 15207, 75, 210);
		tab.child(2, 15208, 75, 210);
		/* tab.child(3, 15109, 41+39+30, 212); */
	}

	public static void EquipmentScreen(TextDrawingArea[] wid) {
		RSInterface tab = addTabInterface(15106);
		addSprite(15107, 7, "CUSTOM");
		addHoverButton(15210, "CUSTOM", 8, 21, 21, "Close", 250, 15211, 3);
		addHoveredButton(15211, "CUSTOM", 9, 21, 21, 15212);
		addText(15111, "Equip Your Character...", wid, 2, 0xe4a146, false, true);
		addText(15112, "Attack bonus", wid, 2, 0xe4a146, false, true);
		addText(15113, "Defence bonus", wid, 2, 0xe4a146, false, true);
		addText(15114, "Other bonuses", wid, 2, 0xe4a146, false, true);
		for (int i = 1675; i <= 1684; i++) {
			textSize(i, wid, 1);
		}
		textSize(1686, wid, 1);
		textSize(1687, wid, 1);
		addChar(15125);
		tab.totalChildren(44);
		tab.child(0, 15107, 4, 20);
		tab.child(1, 15210, 476, 29);
		tab.child(2, 15211, 476, 29);
		tab.child(3, 15111, 14, 30);
		int Child = 4;
		int Y = 69;
		for (int i = 1675; i <= 1679; i++) {
			tab.child(Child, i, 20, Y);
			Child++;
			Y += 14;
		}
		tab.child(9, 1680, 20, 161);
		tab.child(10, 1681, 20, 177);
		tab.child(11, 1682, 20, 192);
		tab.child(12, 1683, 20, 207);
		tab.child(13, 1684, 20, 221);
		tab.child(14, 1686, 20, 262);
		tab.child(17, 1687, 20, 276);
		tab.child(15, 15125, 170, 200);
		tab.child(16, 15112, 16, 55);
		tab.child(18, 15113, 16, 147);
		tab.child(19, 15114, 16, 248);
		tab.child(20, 1645, 104 + 295, 149 - 52);
		tab.child(21, 1646, 399, 163);
		tab.child(22, 1647, 399, 163);
		tab.child(23, 1648, 399, 58 + 146);
		tab.child(24, 1649, 26 + 22 + 297 - 2, 110 - 44 + 118 - 13 + 5);
		tab.child(25, 1650, 321 + 22, 58 + 154);
		tab.child(26, 1651, 321 + 134, 58 + 118);
		tab.child(27, 1652, 321 + 134, 58 + 154);
		tab.child(28, 1653, 321 + 48, 58 + 81);
		tab.child(29, 1654, 321 + 107, 58 + 81);
		tab.child(30, 1655, 321 + 58, 58 + 42);
		tab.child(31, 1656, 321 + 112, 58 + 41);
		tab.child(32, 1657, 321 + 78, 58 + 4);
		tab.child(33, 1658, 321 + 37, 58 + 43);
		tab.child(34, 1659, 321 + 78, 58 + 43);
		tab.child(35, 1660, 321 + 119, 58 + 43);
		tab.child(36, 1661, 321 + 22, 58 + 82);
		tab.child(37, 1662, 321 + 78, 58 + 82);
		tab.child(38, 1663, 321 + 134, 58 + 82);
		tab.child(39, 1664, 321 + 78, 58 + 122);
		tab.child(40, 1665, 321 + 78, 58 + 162);
		tab.child(41, 1666, 321 + 22, 58 + 162);
		tab.child(42, 1667, 321 + 134, 58 + 162);
		tab.child(43, 1688, 50 + 297 - 2, 110 - 13 + 5);
		for (int i = 1675; i <= 1684; i++) {
			RSInterface rsi = interfaceCache[i];
			rsi.textColor = 0xe4a146;
			rsi.centerText = false;
		}
		for (int i = 1686; i <= 1687; i++) {
			RSInterface rsi = interfaceCache[i];
			rsi.textColor = 0xe4a146;
			rsi.centerText = false;
		}
	}

	public static void ancientMagicTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(40000);
		addButton(35010, 1, "MAGIC", "Cast @gre@Home Teleport");
		RSInterface homeButton = interfaceCache[35010];
		homeButton.mOverInterToTrigger = 1196;
		int[] itfChildren = { 35010, 12939, 12987, 13035, 12901, 12861, 13045,
				12963, 13011, 13053, 12919, 12881, 13061, 12951, 12999, 13069,
				12911, 12871, 13079, 12975, 13023, 13087, 12929, 12891, 13095,
				1196, 12940, 12988, 13036, 12902, 12862, 13046, 12964, 13012,
				13054, 12920, 12882, 13062, 12952, 13000, 13070, 12912, 12872,
				13080, 12976, 13024, 13088, 12930, 12892, 13096 };
		tab.totalChildren(itfChildren.length);
		for (int i1 = 0, xPos = 18, yPos = 8; i1 < itfChildren.length; i1++, xPos += 45) {
			if (xPos > 175) {
				xPos = 18;
				yPos += 28;
			}
			if (i1 < 25)
				tab.child(i1, itfChildren[i1], xPos, yPos);
			if (i1 > 24) {
				yPos = i1 < 41 ? 181 : 1;
				tab.child(i1, itfChildren[i1], 4, yPos);
			}
		}
	}

	public static void magicTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(1151);
		RSInterface homeHover = addTabInterface(1196);
		RSInterface spellButtons = interfaceCache[12424];
		spellButtons.scrollMax = 0;
		spellButtons.height = 260;
		spellButtons.width = 190;
		int[] spellButton = { 1196, 1199, 1206, 1215, 1224, 1231, 1240, 1249,
				1258, 1267, 1274, 1283, 1573, 1290, 1299, 1308, 1315, 1324,
				1333, 1340, 1349, 1358, 1367, 1374, 1381, 1388, 1397, 1404,
				1583, 12038, 1414, 1421, 1430, 1437, 1446, 1453, 1460, 1469,
				15878, 1602, 1613, 1624, 7456, 1478, 1485, 1494, 1503, 1512,
				1521, 1530, 1544, 1553, 1563, 1593, 1635, 12426, 12436, 12446,
				12456, 6004, 18471 };
		tab.totalChildren(63);
		tab.child(0, 12424, 13, 24);
		for (int i1 = 0; i1 < spellButton.length; i1++) {
			int yPos = i1 > 34 ? 8 : 183;
			tab.child(1, 1195, 13, 24);
			tab.child(i1 + 2, spellButton[i1], 5, yPos);
			addButton(1195, 1, "MAGIC", "Cast @gre@Home Teleport");
			RSInterface homeButton = interfaceCache[1195];
			homeButton.mOverInterToTrigger = 1196;
		}
		for (int i2 = 0; i2 < spellButton.length; i2++) {
			if (i2 < 60)
				spellButtons.childX[i2] = spellButtons.childX[i2] + 24;
			if (i2 == 6 || i2 == 12 || i2 == 19 || i2 == 35 || i2 == 41
					|| i2 == 44 || i2 == 49 || i2 == 51)
				spellButtons.childX[i2] = 0;
			spellButtons.childY[6] = 24;
			spellButtons.childY[12] = 48;
			spellButtons.childY[19] = 72;
			spellButtons.childY[49] = 96;
			spellButtons.childY[44] = 120;
			spellButtons.childY[51] = 144;
			spellButtons.childY[35] = 170;
			spellButtons.childY[41] = 192;
		}
		homeHover.isMouseoverTriggered = true;
		addText(1197, "Level 0: Home Teleport", tda, 1, 0xFE981F, true, true);
		RSInterface homeLevel = interfaceCache[1197];
		homeLevel.width = 174;
		homeLevel.height = 68;
		addText(1198, "A teleport which requires no", tda, 0, 0xAF6A1A, true,
				true);
		addText(18998, "runes and no required level that", tda, 0, 0xAF6A1A,
				true, true);
		addText(18999, "teleports you to the main land.", tda, 0, 0xAF6A1A,
				true, true);
		homeHover.totalChildren(4);
		homeHover.child(0, 1197, 3, 4);
		homeHover.child(1, 1198, 91, 23);
		homeHover.child(2, 18998, 91, 34);
		homeHover.child(3, 18999, 91, 45);

	}

	public static void teleport(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(176);
		addSprite(17651, 10, "CLICK");
		addHoverButton(17652, "CLICK", 2, 200, 30, "Which Zone?", -1, 17653, 1);
		addHoveredButton(17653, "CLICK", 2, 200, 30, 17654);
		addHoverButton(17655, "CLICK", 3, 200, 30, "Which Zone?", -1, 17656, 1);
		addHoveredButton(17656, "CLICK", 3, 200, 30, 17657);
		addHoverButton(17658, "CLICK", 3, 200, 30, "Which Zone?", -1, 17659, 1);
		addHoveredButton(17659, "CLICK", 3, 200, 30, 17660);
		addHoverButton(17661, "CLICK", 3, 200, 30, "Which Zone?", -1, 17662, 1);
		addHoveredButton(17662, "CLICK", 3, 200, 30, 17663);
		addHoverButton(17664, "CLICK", 3, 200, 30, "Which Zone?", -1, 17665, 1);
		addHoveredButton(17665, "CLICK", 3, 200, 30, 17666);
		addHoverButton(17667, "CLICK", 3, 200, 30, "Which Zone?", -1, 17668, 1);
		addHoveredButton(17668, "CLICK", 3, 200, 30, 17669);
		addHoverButton(17670, "CLICK", 3, 200, 30, "Which Zone?", -1, 17671, 1);
		addHoveredButton(17671, "CLICK", 3, 200, 30, 17672);
		addHoverButton(17673, "CLICK", 1, 200, 30, "Which Zone?", -1, 17674, 1);
		addHoveredButton(17674, "CLICK", 1, 200, 30, 17675);
		addText(22804, "Mage Bank", tda, 0, 0xff981f, false, true);
		addText(22808, "Castle Dragons", tda, 0, 0xff981f, false, true);
		addText(22812, "Varrock Dragons", tda, 0, 0xff981f, false, true);
		addText(22816, "Greater Demons", tda, 0, 0xff981f, false, true);
		addText(22820, "Graveyard Dragons", tda, 0, 0xff981f, false, true);
		addText(22824, "Varrock Multi", tda, 0, 0xff981f, false, true);
		addText(22828, "Edgeville Dungeon", tda, 0, 0xff981f, false, true);
		addText(22800, "", tda, 0, 0xff981f, false, true);
		tab.totalChildren(25);
		tab.child(0, 17651, 0, 0);
		tab.child(1, 17652, 12, 40);
		tab.child(2, 17653, 11, 40);
		tab.child(3, 17655, 12, 65);
		tab.child(4, 17656, 11, 65);
		tab.child(5, 22800, 68, 78);
		tab.child(6, 17658, 12, 90);
		tab.child(7, 17659, 11, 90);
		tab.child(8, 17661, 12, 115);
		tab.child(9, 17662, 11, 115);
		tab.child(10, 17664, 12, 143);
		tab.child(11, 17665, 11, 143);
		tab.child(12, 17667, 12, 168);
		tab.child(13, 17668, 11, 168);
		tab.child(14, 17670, 12, 193);
		tab.child(15, 17671, 11, 193);
		tab.child(16, 17673, 38, 236);
		tab.child(17, 17674, 38, 236);
		tab.child(18, 22804, 38, 45);
		tab.child(19, 22808, 38, 70);
		tab.child(20, 22812, 38, 95);
		tab.child(21, 22816, 38, 120);
		tab.child(22, 22820, 38, 147);
		tab.child(23, 22824, 38, 174);
		tab.child(24, 22828, 38, 201);
		tab = addTabInterface(14000);
		tab.width = 474;
		tab.height = 213;
		tab.scrollMax = 305;
		for (int i = 14001; i <= 14030; i++) {
			addText(i, "", tda, 1, 0xffffff, false, true);
		}
		tab.totalChildren(30);
		int Child = 0;
		int Y = 5;
		for (int i = 14001; i <= 14030; i++) {
			tab.child(Child, i, 248, Y);
			Child++;
			Y += 13;
		}
	}

	public static void addHoverButton(int i, String imageName, int j,
			int width, int height, String text, int contentType, int hoverOver,
			int aT) {// hoverable button
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = aT;
		tab.contentType = contentType;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = hoverOver;
		tab.sprite1 = imageLoader(j, imageName);
		tab.sprite2 = imageLoader(j, imageName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = text;
	}

	public static void addHoveredButton(int i, String imageName, int j, int w,
			int h, int IMAGEID) {// hoverable button
		RSInterface tab = addTabInterface(i);
		tab.parentID = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.isMouseoverTriggered = true;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = -1;
		tab.scrollMax = 0;
		addHoverImage(IMAGEID, j, j, imageName);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}

	public static void addHoverImage(int i, int j, int k, String name) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(j, name);
		tab.sprite2 = imageLoader(k, name);
	}

	public static void friendsTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(5065);
		RSInterface list = interfaceCache[5066];
		addText(5067, "Friends List", tda, 1, 0xff9933, true, true);
		addText(5070, "Add Friend", tda, 0, 0xff9933, false, true);
		addText(5071, "Delete Friend", tda, 0, 0xff9933, false, true);
		addSprite(16126, 4, "SPRITE");
		addSprite(16127, 8, "SPRITE");
		addHoverButton(5068, "SPRITE", 6, 72, 32, "Add Friend", 201, 5072, 1);
		addHoveredButton(5072, "SPRITE", 7, 72, 32, 5073);
		addHoverButton(5069, "SPRITE", 6, 72, 32, "Delete Friend", 202, 5074, 1);
		addHoveredButton(5074, "SPRITE", 7, 72, 32, 5075);
		tab.totalChildren(11);
		tab.child(0, 5067, 95, 4);
		tab.child(1, 16127, 0, 25);
		tab.child(2, 16126, 0, 221);
		tab.child(3, 5066, 0, 24);
		tab.child(4, 16126, 0, 22);
		tab.child(5, 5068, 15, 226);
		tab.child(6, 5072, 15, 226);
		tab.child(7, 5069, 103, 226);
		tab.child(8, 5074, 103, 226);
		tab.child(9, 5070, 25, 237);
		tab.child(10, 5071, 106, 237);
		list.height = 196;
		list.width = 174;
		for (int id = 5092, i = 0; id <= 5191 && i <= 99; id++, i++) {
			list.children[i] = id;
			list.childX[i] = 3;
			list.childY[i] = list.childY[i] - 7;
		}
		for (int id = 5192, i = 100; id <= 5291 && i <= 199; id++, i++) {
			list.children[i] = id;
			list.childX[i] = 131;
			list.childY[i] = list.childY[i] - 7;
		}
	}

	public static void ignoreTab(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(5715);
		RSInterface list = interfaceCache[5716];
		addText(5717, "Ignore List", tda, 1, 0xff9933, true, true);
		addText(5720, "Add Name", tda, 0, 0xff9933, false, true);
		addText(5721, "Delete Name", tda, 0, 0xff9933, false, true);
		addHoverButton(5718, "SPRITE", 6, 72, 32, "Add Name", 501, 5722, 1);
		addHoveredButton(5722, "SPRITE", 7, 72, 32, 5723);
		addHoverButton(5719, "SPRITE", 6, 72, 32, "Delete Name", 502, 5724, 1);
		addHoveredButton(5724, "SPRITE", 7, 72, 32, 5725);
		tab.totalChildren(11);
		tab.child(0, 5717, 95, 4);
		tab.child(1, 16127, 0, 25);
		tab.child(2, 16126, 0, 221);
		tab.child(3, 5716, 0, 24);
		tab.child(4, 16126, 0, 22);
		tab.child(5, 5718, 15, 226);
		tab.child(6, 5722, 15, 226);
		tab.child(7, 5719, 103, 226);
		tab.child(8, 5724, 103, 226);
		tab.child(9, 5720, 27, 237);
		tab.child(10, 5721, 108, 237);
		list.height = 196;
		list.width = 174;
		for (int id = 5742, i = 0; id <= 5841 && i <= 99; id++, i++) {
			list.children[i] = id;
			list.childX[i] = 3;
			list.childY[i] = list.childY[i] - 7;
		}
	}

	public void swapInventoryItems(int i, int j) {
		int k = inv[i];
		inv[i] = inv[j];
		inv[j] = k;
		k = invStackSizes[i];
		invStackSizes[i] = invStackSizes[j];
		invStackSizes[j] = k;
	}

	public static void cornerText(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(16128);
		addText(16129, "EP: 100%", tda, 1, 0xFF0000, true, true);
		addText(16130, "126 - 126", tda, 1, 0xFF0000, true, true);
		tab.totalChildren(2);
		tab.child(0, 16129, 481, 304);
		tab.child(1, 16130, 480, 317);
	}

	public static void unpack(StreamLoader streamLoader,
			TextDrawingArea textDrawingAreas[], StreamLoader streamLoader_1) {
		aMRUNodes_238 = new MRUNodes(50000);
		Stream stream = new Stream(streamLoader.getDataForName("data"));
		int i = -1;
		int j = stream.readUnsignedWord();
		interfaceCache = new RSInterface[j + 80000];
		while (stream.currentOffset < stream.buffer.length) {
			int k = stream.readUnsignedWord();
			if (k == 65535) {
				i = stream.readUnsignedWord();
				k = stream.readUnsignedWord();
			}
			RSInterface rsInterface = interfaceCache[k] = new RSInterface();
			rsInterface.id = k;
			rsInterface.parentID = i;
			rsInterface.type = stream.readUnsignedByte();
			rsInterface.atActionType = stream.readUnsignedByte();
			rsInterface.contentType = stream.readUnsignedWord();
			rsInterface.width = stream.readUnsignedWord();
			rsInterface.height = stream.readUnsignedWord();
			rsInterface.aByte254 = (byte) stream.readUnsignedByte();
			rsInterface.mOverInterToTrigger = stream.readUnsignedByte();
			if (rsInterface.mOverInterToTrigger != 0)
				rsInterface.mOverInterToTrigger = (rsInterface.mOverInterToTrigger - 1 << 8)
						+ stream.readUnsignedByte();
			else
				rsInterface.mOverInterToTrigger = -1;
			int i1 = stream.readUnsignedByte();
			if (i1 > 0) {
				rsInterface.anIntArray245 = new int[i1];
				rsInterface.anIntArray212 = new int[i1];
				for (int j1 = 0; j1 < i1; j1++) {
					rsInterface.anIntArray245[j1] = stream.readUnsignedByte();
					rsInterface.anIntArray212[j1] = stream.readUnsignedWord();
				}
			}
			int k1 = stream.readUnsignedByte();
			if (k1 > 0) {
				rsInterface.valueIndexArray = new int[k1][];
				for (int l1 = 0; l1 < k1; l1++) {
					int i3 = stream.readUnsignedWord();
					rsInterface.valueIndexArray[l1] = new int[i3];
					for (int l4 = 0; l4 < i3; l4++)
						rsInterface.valueIndexArray[l1][l4] = stream
								.readUnsignedWord();

				}

			}
			if (rsInterface.type == 0) {
				rsInterface.drawsTransparent = false;
				rsInterface.scrollMax = stream.readUnsignedWord();
				rsInterface.isMouseoverTriggered = stream.readUnsignedByte() == 1;
				int i2 = stream.readUnsignedWord();
				rsInterface.children = new int[i2];
				rsInterface.childX = new int[i2];
				rsInterface.childY = new int[i2];
				for (int j3 = 0; j3 < i2; j3++) {
					rsInterface.children[j3] = stream.readUnsignedWord();
					rsInterface.childX[j3] = stream.readSignedWord();
					rsInterface.childY[j3] = stream.readSignedWord();
				}
			}
			if (rsInterface.type == 1) {
				stream.readUnsignedWord();
				stream.readUnsignedByte();
			}
			if (rsInterface.type == 2) {
				rsInterface.inv = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.aBoolean259 = stream.readUnsignedByte() == 1;
				rsInterface.isInventoryInterface = stream.readUnsignedByte() == 1;
				rsInterface.usableItemInterface = stream.readUnsignedByte() == 1;
				rsInterface.aBoolean235 = stream.readUnsignedByte() == 1;
				rsInterface.invSpritePadX = stream.readUnsignedByte();
				rsInterface.invSpritePadY = stream.readUnsignedByte();
				rsInterface.spritesX = new int[20];
				rsInterface.spritesY = new int[20];
				rsInterface.sprites = new Sprite[20];
				for (int j2 = 0; j2 < 20; j2++) {
					int k3 = stream.readUnsignedByte();
					if (k3 == 1) {
						rsInterface.spritesX[j2] = stream.readSignedWord();
						rsInterface.spritesY[j2] = stream.readSignedWord();
						String s1 = stream.readString();
						if (streamLoader_1 != null && s1.length() > 0) {
							int i5 = s1.lastIndexOf(",");
							rsInterface.sprites[j2] = method207(Integer
									.parseInt(s1.substring(i5 + 1)),
									streamLoader_1, s1.substring(0, i5));
						}
					}
				}

				rsInterface.actions = new String[5];
				for (int l3 = 0; l3 < 5; l3++) {
					rsInterface.actions[l3] = stream.readString();
					if (rsInterface.parentID == 1644)
						rsInterface.actions[2] = "Operate";
					if (rsInterface.parentID == 3824)
						rsInterface.actions[4] = "Buy X";
					if (rsInterface.parentID == 3822)
						rsInterface.actions[4] = "Sell X";
					if (rsInterface.actions[l3].length() == 0)
						rsInterface.actions[l3] = null;
				}

			}
			if (rsInterface.type == 3)
				rsInterface.aBoolean227 = stream.readUnsignedByte() == 1;
			if (rsInterface.type == 4 || rsInterface.type == 1) {
				rsInterface.centerText = stream.readUnsignedByte() == 1;
				int k2 = stream.readUnsignedByte();
				if (textDrawingAreas != null)
					rsInterface.textDrawingAreas = textDrawingAreas[k2];
				rsInterface.textShadow = stream.readUnsignedByte() == 1;
			}
			if (rsInterface.type == 4) {
				rsInterface.message = stream.readString();
				rsInterface.aString228 = stream.readString();
			}
			if (rsInterface.type == 1 || rsInterface.type == 3
					|| rsInterface.type == 4)
				rsInterface.textColor = stream.readDWord();
			if (rsInterface.type == 3 || rsInterface.type == 4) {
				rsInterface.anInt219 = stream.readDWord();
				rsInterface.anInt216 = stream.readDWord();
				rsInterface.anInt239 = stream.readDWord();
			}
			if (rsInterface.type == 5) {
				rsInterface.drawsTransparent = false;
				String s = stream.readString();
				if (streamLoader_1 != null && s.length() > 0) {
					int i4 = s.lastIndexOf(",");
					rsInterface.sprite1 = method207(Integer.parseInt(s
							.substring(i4 + 1)), streamLoader_1, s.substring(0,
							i4));
				}
				s = stream.readString();
				if (streamLoader_1 != null && s.length() > 0) {
					int j4 = s.lastIndexOf(",");
					rsInterface.sprite2 = method207(Integer.parseInt(s
							.substring(j4 + 1)), streamLoader_1, s.substring(0,
							j4));
				}
			}
			if (rsInterface.type == 6) {
				int l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.anInt233 = 1;
					rsInterface.mediaID = (l - 1 << 8)
							+ stream.readUnsignedByte();
				}
				l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.anInt255 = 1;
					rsInterface.anInt256 = (l - 1 << 8)
							+ stream.readUnsignedByte();
				}
				l = stream.readUnsignedByte();
				if (l != 0)
					rsInterface.anInt257 = (l - 1 << 8)
							+ stream.readUnsignedByte();
				else
					rsInterface.anInt257 = -1;
				l = stream.readUnsignedByte();
				if (l != 0)
					rsInterface.anInt258 = (l - 1 << 8)
							+ stream.readUnsignedByte();
				else
					rsInterface.anInt258 = -1;
				rsInterface.anInt269 = stream.readUnsignedWord();
				rsInterface.modelRotation1 = stream.readUnsignedWord();
				rsInterface.modelRotation2 = stream.readUnsignedWord();
			}
			if (rsInterface.type == 7) {
				rsInterface.inv = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.centerText = stream.readUnsignedByte() == 1;
				int l2 = stream.readUnsignedByte();
				if (textDrawingAreas != null)
					rsInterface.textDrawingAreas = textDrawingAreas[l2];
				rsInterface.textShadow = stream.readUnsignedByte() == 1;
				rsInterface.textColor = stream.readDWord();
				rsInterface.invSpritePadX = stream.readSignedWord();
				rsInterface.invSpritePadY = stream.readSignedWord();
				rsInterface.isInventoryInterface = stream.readUnsignedByte() == 1;
				rsInterface.actions = new String[5];
				for (int k4 = 0; k4 < 5; k4++) {
					rsInterface.actions[k4] = stream.readString();
					if (rsInterface.actions[k4].length() == 0)
						rsInterface.actions[k4] = null;
				}

			}
			if (rsInterface.atActionType == 2 || rsInterface.type == 2) {
				rsInterface.selectedActionName = stream.readString();
				rsInterface.spellName = stream.readString();
				rsInterface.spellUsableOn = stream.readUnsignedWord();
			}

			if (rsInterface.type == 8)
				rsInterface.message = stream.readString();

			if (rsInterface.atActionType == 1 || rsInterface.atActionType == 4
					|| rsInterface.atActionType == 5
					|| rsInterface.atActionType == 6) {
				rsInterface.tooltip = stream.readString();
				if (rsInterface.tooltip.length() == 0) {
					if (rsInterface.atActionType == 1)
						rsInterface.tooltip = "Ok";
					if (rsInterface.atActionType == 4)
						rsInterface.tooltip = "Select";
					if (rsInterface.atActionType == 5)
						rsInterface.tooltip = "Select";
					if (rsInterface.atActionType == 6)
						rsInterface.tooltip = "Continue";
				}
			}
		}
		aClass44 = streamLoader;
		cornerText(textDrawingAreas);
		//NewSkillTab(textDrawingAreas);
		itemsKeptOnDeath(textDrawingAreas);
		Bank();
		KillCount(textDrawingAreas);
		questTab(textDrawingAreas);
		Shop(textDrawingAreas);
		Sidebar0(textDrawingAreas);
		editClan(textDrawingAreas);
		configureLunar(textDrawingAreas);
		constructLunar();
		teleport(textDrawingAreas);
		emoteTab();
		settingsInterface(textDrawingAreas);
		clanChatTab(textDrawingAreas);
		optionTab(textDrawingAreas);
		EquipmentScreen(textDrawingAreas);
		EquipmentTab(textDrawingAreas);
		magicTab(textDrawingAreas);
		bloodluststart(textDrawingAreas);
		bloodlustMembers(textDrawingAreas);
		NRInfo(textDrawingAreas);
		BloodLustTeams(textDrawingAreas);
		topPK(textDrawingAreas);
		achievement(textDrawingAreas);
		Curses(textDrawingAreas);
		ancientMagicTab(textDrawingAreas);
		friendsTab(textDrawingAreas);
		ignoreTab(textDrawingAreas);
		Prayer(textDrawingAreas);
		quickPrayers(textDrawingAreas);
		cursequickPrayers(textDrawingAreas);
		skillTab602();
		aMRUNodes_238 = null;
	}
	
	public static void skillTab602() {
		RSInterface skill = addTabInterface(3917);
		String[] spriteNames = { "Attack", "HP", "Mine", "Strength", "Agility", "Smith", "Defence", "Herblore", "Fish", "Range", "Thief", "Cook", "Prayer", "Craft", "Fire", "Mage", "Fletch", "Wood", "Rune", "Slay", "Farm", "Construction", "Hunter", "Summon", "Dungeon" };
		int[] buttons = { 8654, 8655, 8656, 8657, 8658, 8659, 8660, 8861, 8662, 8663, 8664, 8665, 8666, 8667, 8668, 8669, 8670, 8671, 8672, 12162, 13928, 18177, 18178, 18179, 18180 };
		int[] hovers = { 4040, 4076, 4112, 4046, 4082, 4118, 4052, 4088, 4124, 4058, 4094, 4130, 4064, 4100, 4136, 4070, 4106, 4142, 4160, 2832, 13917, 18173, 18174, 18175, 18176 };
		int[][] text = { { 4004, 4005 }, { 4016, 4017 }, { 4028, 4029 }, { 4006, 4007 }, { 4018, 4019 }, { 4030, 4031 }, { 4008, 4009 }, { 4020, 4021 }, { 4032, 4033 }, { 4010, 4011 }, { 4022, 4023 }, { 4034, 4035 }, { 4012, 4013 }, { 4024, 4025 }, { 4036, 4037 }, { 4014, 4015 }, { 4026, 4027 }, { 4038, 4039 }, { 4152, 4153 }, { 12166, 12167 }, { 13926, 13927 }, { 18165, 18169 }, { 18166, 18170 }, { 18167, 18171 }, { 18168, 18172 } };
		int[] icons = { 3965, 3966, 3967, 3968, 3969, 3970, 3971, 3972, 3973, 3974, 3975, 3976, 3977, 3978, 3979, 3980, 3981, 3982, 4151, 12165, 13925, 18181, 18182, 18183, 18184 };
		int[][] buttonCoords = { { 4, 4 }, { 66, 4 }, { 128, 4 }, { 4, 32 }, { 66, 32 }, { 128, 32 }, { 4, 60 }, { 66, 60 }, { 128, 60 }, { 4, 88 }, { 66, 88 }, { 128, 88 }, { 4, 116 }, { 66, 116 }, { 128, 116 }, { 4, 144 }, { 66, 144 }, { 128, 144 }, { 4, 172 }, { 66, 172 }, { 128, 172 }, { 4, 200 }, { 66, 200 }, { 128, 200 }, { 4, 229 } };
		int[][] iconCoords = { { 6, 6 }, { 69, 7 }, { 131, 6 }, { 9, 34 }, { 68, 33 }, { 131, 36 }, { 9, 64 }, { 67, 63 }, { 131, 61 }, { 7, 91 }, { 68, 94 }, { 133, 90 }, { 6, 118 }, { 70, 120 }, { 130, 118 }, { 6, 147 }, { 69, 146 }, { 132, 146 }, { 6, 173 }, { 69, 173 }, { 130, 174 }, { 6, 202 }, { 69, 201 }, { 131, 202 }, { 6, 230 } };
		int[][] textCoords = { { 31, 7, 44, 18 }, { 93, 7, 106, 18 }, { 155, 7, 168, 18 }, { 31, 35, 44, 46 }, { 93, 35, 106, 46 }, { 155, 35, 168, 46 }, { 31, 63, 44, 74 }, { 93, 63, 106, 74 }, { 155, 63, 168, 74 }, { 31, 91, 44, 102 }, { 93, 91, 106, 102 }, { 155, 91, 168, 102 }, { 31, 119, 44, 130 }, { 93, 119, 106, 130 }, { 155, 119, 168, 130 }, { 31, 147, 44, 158 }, { 93, 147, 106, 158 }, { 155, 147, 168, 158 }, { 31, 175, 44, 186 }, { 93, 175, 106, 186 }, { 155, 175, 168, 186 }, { 31, 203, 44, 214 }, { 93, 203, 106, 214 }, { 155, 203, 168, 214 }, { 31, 231, 44, 242 } };
		int[][] newText = { { 18165, 18166, 18167, 18168 }, { 18169, 18170, 18171, 18172 } };
		for (int i = 0; i < hovers.length; i++) {
			createSkillHover(hovers[i], 205 + i);
			addSkillButton(buttons[i]);
			addImage(icons[i], "Skill/" + spriteNames[i]);
		}
		int[] logoutID = { 2450, 2451, 2452 };
		int[] logoutID2 = { 2458 };
		for (int i : logoutID) {
			RSInterface Logout = interfaceCache[i];
			Logout.textColor = 0xFF981F;
			Logout.contentType = 0;
		}
		for (int i : logoutID2) {
			RSInterface Logout = interfaceCache[i];
			Logout.contentType = 0;
		}
		for (int i = 0; i < 4; i++) {
			addSkillText(newText[0][i], false, i + 21);
			addSkillText(newText[1][i], true, i + 21);
		}
		skill.children(icons.length + (text.length * 2) + hovers.length + buttons.length + 1);
		int frame = 0;
		RSInterface totalLevel = interfaceCache[3984];
		totalLevel.message = "Total level: %1";
		totalLevel.textDrawingAreas = fonts[2];
		skill.child(frame, 3984, 70, 237); frame++;
		for (int i = 0; i < buttons.length; i++) {
			skill.child(frame, buttons[i], buttonCoords[i][0], buttonCoords[i][1]); frame++;
		}
		for (int i = 0; i < icons.length; i++) {
			skill.child(frame, icons[i], iconCoords[i][0], iconCoords[i][1]); frame++;
		}
		for (int i = 0; i < text.length; i++) {
			skill.child(frame, text[i][0], textCoords[i][0], textCoords[i][1]); frame++;
		}
		for (int i = 0; i < text.length; i++) {
			skill.child(frame, text[i][1], textCoords[i][2], textCoords[i][3]); frame++;
		}
		for (int i = 0; i < hovers.length; i++) {
			skill.child(frame, hovers[i], buttonCoords[i][0], buttonCoords[i][1]); frame++;
		}
	}
	
	public void children(int total) {
		children = new int[total];
		childX = new int[total];
		childY = new int[total];
	}

	public static void createSkillHover(int id, int x) {
		RSInterface hover = addTabInterface(id);
		hover.type = 11;
		hover.message = "TESTING!";
		hover.contentType = x;
		hover.width = 60;
		hover.height = 28;
		hover.inventoryhover = true;
	}
	
	public boolean inventoryhover;

	public static void addSkillText(int id, boolean max, int skill) {
		RSInterface text = addTabInterface(id);
		text.id = id;
		text.parentID = id;
		text.type = 4;
		text.atActionType = 0;
		text.width = 15;
		text.height = 12;
		text.textDrawingAreas = fonts[0];
		text.textShadow = true;
		text.centerText = true;
		text.textColor = 16776960;
		if (!max) {
			text.valueIndexArray = new int[1][];
			text.valueIndexArray[0] = new int[3];
			text.valueIndexArray[0][0] = 1;
			text.valueIndexArray[0][1] = skill;
			text.valueIndexArray[0][2] = 0;
		} else {
			text.valueIndexArray = new int[2][];
			text.valueIndexArray[0] = new int[3];
			text.valueIndexArray[0][0] = 1;
			text.valueIndexArray[0][1] = skill;
			text.valueIndexArray[0][2] = 0;
			text.valueIndexArray[1] = new int[1];
			text.valueIndexArray[1][0] = 0;
		}
		text.message = "%1";
	}

	public static void addSkillButton(int id) {
		RSInterface button = addTabInterface(id);
		button.type = 5;
		button.atActionType = 5;
		button.contentType = 0;
		button.width = 60;
		button.height = 27;
		button.sprite1 = getSprite("Skill/Button");
		button.tooltip = "View";
	}

	public static void addImage(int id, String s) {
		RSInterface image = addTabInterface(id);
		image.type = 5;
		image.atActionType = 0;
		image.contentType = 0;
		image.width = 100;
		image.height = 100;
		image.sprite1 = getSprite(s);
	}

	public static Sprite getSprite(String s) {
		Sprite image;
		try {
			image = new Sprite(s);
			if (image != null) {
				return image;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return image;
	}

	public static void addText(int id, String text, TextDrawingArea tda[],
			int idx, int color, boolean centered) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		if (centered)
			rsi.centerText = true;
		rsi.textShadow = true;
		rsi.textDrawingAreas = tda[idx];
		rsi.message = text;
		rsi.textColor = color;
		rsi.id = id;
		rsi.type = 4;
	}

	public static void addText(int id, String text, TextDrawingArea tda[],
			int idx, int color, boolean center, boolean shadow) {
		RSInterface tab = addTabInterface(id);
		tab.parentID = id;
		tab.id = id;
		tab.type = 4;
		tab.atActionType = 0;
		tab.width = 0;
		tab.height = 11;
		tab.contentType = 0;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = -1;
		tab.centerText = center;
		tab.textShadow = shadow;
		tab.textDrawingAreas = tda[idx];
		tab.message = text;
		tab.aString228 = "";
		tab.textColor = color;
		tab.anInt219 = 0;
		tab.anInt216 = 0;
		tab.anInt239 = 0;
	}

	public static void addButton(int id, int sid, String spriteName,
			String tooltip) {
		// addButton(19156, 1, "Bank/QUEST", 18, 18, "Achievement Diary", 1);
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite1.myHeight;
		tab.tooltip = tooltip;
	}

	public static void addSprite(int id, int spriteId, String spriteName) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName);
		tab.width = 512;
		tab.height = 334;
	}

	public static void addTransparentSprite(int id, int spriteId,
			String spriteName) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName);
		tab.width = 512;
		tab.height = 334;
		tab.drawsTransparent = true;
	}

	public static RSInterface addScreenInterface(int id) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 0;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = 0;
		return tab;
	}

	public static RSInterface addTabInterface(int id) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;// 250
		tab.parentID = id;// 236
		tab.type = 0;// 262
		tab.atActionType = 0;// 217
		tab.contentType = 0;
		tab.width = 512;// 220
		tab.height = 700;// 267
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = -1;// Int 230
		return tab;
	}

	public void child(int id, int interID, int x, int y) {
		children[id] = interID;
		childX[id] = x;
		childY[id] = y;
	}

	public void setBounds(int ID, int X, int Y, int frame) {
		children[frame] = ID;
		childX[frame] = X;
		childY[frame] = Y;
	}

	public void totalChildren(int t) {
		children = new int[t];
		childX = new int[t];
		childY = new int[t];
	}

	private Model method206(int i, int j) {
		Model model = (Model) aMRUNodes_264.insertFromCache((i << 16) + j);
		if (model != null)
			return model;
		if (i == 1)
			model = Model.method462(j);
		if (i == 2)
			model = EntityDef.forID(j).method160();
		if (i == 3)
			model = client.myPlayer.method453();
		if (i == 4)
			model = ItemDef.forID(j).method202(50);
		if (i == 5)
			model = null;
		if (model != null)
			aMRUNodes_264.removeFromCache(model, (i << 16) + j);
		return model;
	}

	private static Sprite method207(int i, StreamLoader streamLoader, String s) {
		long l = (TextClass.method585(s) << 8) + (long) i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null)
			return sprite;
		try {
			sprite = new Sprite(streamLoader, s, i);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception _ex) {
			return null;
		}
		return sprite;
	}

	public static void method208(boolean flag, Model model) {
		int i = 0;// was parameter
		int j = 5;// was parameter
		if (flag)
			return;
		aMRUNodes_264.unlinkAll();
		if (model != null && j != 4)
			aMRUNodes_264.removeFromCache(model, (j << 16) + i);
	}

	public Model method209(int j, int k, boolean flag) {
		Model model;
		if (flag)
			model = method206(anInt255, anInt256);
		else
			model = method206(anInt233, mediaID);
		if (model == null)
			return null;
		if (k == -1 && j == -1 && model.anIntArray1640 == null)
			return model;
		Model model_1 = new Model(true, Class36.method532(k)
				& Class36.method532(j), false, model);
		if (k != -1 || j != -1)
			model_1.method469();
		if (k != -1)
			model_1.method470(k);
		if (j != -1)
			model_1.method470(j);
		model_1.method479(64, 768, -50, -10, -50, true);
		return model_1;
	}

	public RSInterface() {
	}

	public static StreamLoader aClass44;
	public boolean drawsTransparent;
	public Sprite sprite1;
	public int anInt208;
	public Sprite sprites[];
	public static RSInterface interfaceCache[];
	public int anIntArray212[];
	public int contentType;// contentType
	public int spritesX[];
	public int anInt216;
	public int atActionType;
	public String spellName;
	public int anInt219;
	public int width;
	public String tooltip;
	public String selectedActionName;
	public boolean centerText;
	public int scrollPosition;
	public String actions[];
	public int valueIndexArray[][];
	public boolean aBoolean227;
	public String aString228;
	public int mOverInterToTrigger;
	public int invSpritePadX;
	public int textColor;
	public int anInt233;
	public int mediaID;
	public boolean aBoolean235;
	public int parentID;
	public int spellUsableOn;
	private static MRUNodes aMRUNodes_238;
	public int anInt239;
	public int children[];
	public int childX[];
	public boolean usableItemInterface;
	public TextDrawingArea textDrawingAreas;
	public int invSpritePadY;
	public int anIntArray245[];
	public int anInt246;
	public int spritesY[];
	public String message;
	public boolean isInventoryInterface;
	public int id;
	public int invStackSizes[];
	public int inv[];
	public byte aByte254;
	private int anInt255;
	private int anInt256;
	public int anInt257;
	public int anInt258;
	public boolean aBoolean259;
	public Sprite sprite2;
	public int scrollMax;
	public int type;
	public int anInt263;
	private static final MRUNodes aMRUNodes_264 = new MRUNodes(30);
	public int anInt265;
	public boolean isMouseoverTriggered;
	public int height;
	public boolean textShadow;
	public int anInt269;
	public int modelRotation1;
	public int modelRotation2;
	public int childY[];
	public String popupString;

}
