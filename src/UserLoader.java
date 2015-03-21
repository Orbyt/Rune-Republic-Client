/*
 * UserLoader.java
 * 
 * Version 0.05
 *
 * Created on 21 October 2008 edited on 30 October 2008 =)
 * 
 * load and save user settings
 *
 */

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class UserLoader extends client {
//
//	public static String userName = "";
//	public static String password = "";
//	public static int newHitSplat = 1;
//	public static int newHpBars = 1;
//	public static int hpAboveHeads = 0;
//	public static int chateffectmove = 0;
//	public static boolean charFileFound = false;
//	public static int chatdetail = 1;
//
//	public static void saveuser() {
//		BufferedWriter userSettings = null;
//		try {
//			userSettings = new BufferedWriter(new FileWriter(
//					"./Settings/usersets.txt"));
//			saveValue(userSettings, "[ACCOUNT]", "nothing", false);
//			userSettings.write("character-username = ", 0, 21);
//			userSettings.write(myUsername, 0, myUsername.length());
//			userSettings.newLine();
//			userSettings.write("character-password = ", 0, 21);
//			userSettings.write(myPassword, 0, myPassword.length());
//			userSettings.newLine();
//			userSettings.write("character-newhitsplat = ", 0, 24);
//			userSettings.write(Integer.toString(newHitSplat), 0, Integer
//					.toString(newHitSplat).length());
//			userSettings.newLine();
//			userSettings.write("character-newhpbars = ", 0, 22);
//			userSettings.write(Integer.toString(newHpBars), 0, Integer
//					.toString(newHpBars).length());
//			userSettings.newLine();
//			userSettings.write("character-hpaboveheads = ", 0, 25);
//			userSettings.write(Integer.toString(hpAboveHeads), 0, Integer
//					.toString(hpAboveHeads).length());
//			userSettings.newLine();
//			saveValue(userSettings, "[PRAYERS]", "nothing", false);
//			String stringSave = "";
//			for (int i = 0; i < quickPrayers.length; i++) {
//				stringSave = stringSave + quickPrayers[i] + "\t";
//			}
//			saveValue(userSettings, "prayer", stringSave, true);
//
//			saveValue(userSettings, "[CURSES]", "nothing", false);
//			stringSave = "";
//			for (int i = 0; i < quickCurses.length; i++) {
//				stringSave = stringSave + quickCurses[i] + "\t";
//			}
//			saveValue(userSettings, "curse", stringSave, true);
//
//			// Ends
//			userSettings.newLine();
//			userSettings.write("[EOF]", 0, 5);
//			userSettings.close();
//		} catch (IOException ioexception) {
//
//		}
//	}
//
//	public static void loaduser() {
//		String line = "";
//		String token = "";
//		String token2 = "";
//		int ReadMode = 0;
//		boolean EndOfFile = false;
//		String[] token3 = new String[30];
//		BufferedReader details = null;
//		try {
//			details = new BufferedReader(new FileReader(
//					"./Settings/usersets.txt"));
//			try {
//				line = details.readLine();
//			} catch (IOException ioexception) {
//				System.out.println("Error reading details2.ini");
//			}
//			while (EndOfFile == false && line != null) {
//				line = line.trim();
//				int spot = line.indexOf("=");
//				if (spot > -1) {
//					token = line.substring(0, spot);
//					token = token.trim();
//					token2 = line.substring(spot + 1);
//					token2 = token2.trim();
//					token3 = token2.split("\t");
//					switch (ReadMode) {
//					case 1:
//						if (token.equals("character-username")) {
//							userName = token2;
//						}
//						if (token.equals("character-password")) {
//							password = token2;
//						}
//						if (token.equals("character-newhitsplat")) {
//							newHitSplat = Integer.parseInt(token2);
//							if (newHitSplat != 0 && newHitSplat != 1) {
//								newHitSplat = 1;
//							}
//						}
//						if (token.equals("character-newhpbars")) {
//							newHpBars = Integer.parseInt(token2);
//							if (newHpBars != 0 && newHpBars != 1) {
//								newHpBars = 1;
//							}
//						}
//						if (token.equals("character-hpaboveheads")) {
//							hpAboveHeads = Integer.parseInt(token2);
//							if (hpAboveHeads != 0 && hpAboveHeads != 1) {
//								hpAboveHeads = 1;
//							}
//						}
//						break;
//					case 2:
//						if (token.equals("prayer")) {
//							for (int j = 0; j < token3.length; j++) {
//								quickPrayers[j] = Integer.parseInt(token3[j]);
//							}
//						}
//						break;
//					case 3:
//						if (token.equals("curse")) {
//							for (int j = 0; j < token3.length; j++) {
//								quickCurses[j] = Integer.parseInt(token3[j]);
//							}
//						}
//						break;
//
//					}
//				} else {
//					if (line.equals("[ACCOUNT]"))
//						ReadMode = 1;
//					else if (line.equals("[PRAYERS]"))
//						ReadMode = 2;
//					else if (line.equals("[CURSES]"))
//						ReadMode = 3;
//					if (line.equals("[EOF]"))
//						try {
//							details.close();
//						} catch (IOException ioexception) {
//							ioexception.printStackTrace();
//						}
//				}
//				try {
//					line = details.readLine();
//				} catch (IOException ioexception1) {
//					EndOfFile = true;
//				}
//			}
//		} catch (FileNotFoundException file) {
//			System.out.println("Couldn't find details2.ini");
//		}
//		try {
//			if (details != null)
//				details.close();
//		} catch (NullPointerException ex) {
//			ex.printStackTrace();
//		} catch (IOException ioexception) {
//			ioexception.printStackTrace();
//		}
//	}
//
//	/*
//	 * public static void loaduser(){ long start = System.currentTimeMillis();
//	 * String line = ""; String token = ""; String token2 = ""; String[] token3
//	 * = new String[30]; boolean EndOfFile = false; int ReadMode = 0;
//	 * BufferedReader userSettings = null; try { userSettings = new
//	 * BufferedReader(new FileReader("./Settings/usersets.txt")); charFileFound
//	 * = true; } catch (FileNotFoundException fileex1) { } if (charFileFound ==
//	 * false) { System.out.println("File could not be found."); saveuser();
//	 * return; } while ((EndOfFile == false) && (line != null)) { line =
//	 * line.trim(); int spot = line.indexOf("="); if (spot > -1) { token =
//	 * line.substring(0, spot); token = token.trim(); token2 =
//	 * line.substring(spot + 1); token2 = token2.trim(); token3 =
//	 * token2.split("\t"); switch (ReadMode) { case 1: if
//	 * (token.equals("character-username")) { userName = token2; } if
//	 * (token.equals("character-password")) { password = token2; } if
//	 * (token.equals("character-newhitsplat")) { newHitSplat =
//	 * Integer.parseInt(token2); if(newHitSplat != 0 && newHitSplat != 1){
//	 * newHitSplat = 1; } } if (token.equals("character-newhpbars")) { newHpBars
//	 * = Integer.parseInt(token2); if(newHpBars != 0 && newHpBars != 1){
//	 * newHpBars = 1; } } if (token.equals("character-hpaboveheads")) {
//	 * hpAboveHeads = Integer.parseInt(token2); if(hpAboveHeads != 0 &&
//	 * hpAboveHeads != 1){ hpAboveHeads = 1; } } break; case 2: if
//	 * (token.equals("prayer")) { for (int j = 0; j < token3.length; j++) {
//	 * quickPrayers[j] = Integer.parseInt(token3[j]); } } break; case 3: if
//	 * (token.equals("curse")) { for (int j = 0; j < token3.length; j++) {
//	 * quickCurses[j] = Integer.parseInt(token3[j]); } } break; }
//	 * 
//	 * } else { if(line.equals("[ACCOUNT]")) ReadMode = 1; else
//	 * if(line.equals("[PRAYERS]")) ReadMode = 2; else
//	 * if(line.equals("[CURSES]")) ReadMode = 3; if(line.equals("[EOF]")) try {
//	 * userSettings.close(); } catch(IOException ioexception) {
//	 * ioexception.printStackTrace(); } } try { line = userSettings.readLine();
//	 * } catch (IOException ioexception1) { EndOfFile = true; } } try {
//	 * userSettings.close(); } catch (IOException ioexception) {
//	 * System.out.println(""); }
//	 * 
//	 * 
//	 * }
//	 */
//
//	public static void finalload() {
//		detail();
//		myUsername = userName;
//		myPassword = password;
//		if (hpAboveHeads == 1) {
//			client.hpH = true;
//		} else {
//			client.hpH = false;
//		}
//		if (newHpBars == 1) {
//			client.newHpBar = true;
//		} else {
//			client.newHpBar = false;
//		}
//		if (newHitSplat == 1) {
//			client.newHits = true;
//		} else {
//			client.newHits = false;
//		}
//	}
//}