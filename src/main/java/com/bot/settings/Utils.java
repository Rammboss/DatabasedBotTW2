package com.bot.settings;

import java.util.ArrayList;
import java.util.Iterator;

import com.bot.account.Account;
import com.bot.account.Rohstofflager;
import com.bot.model.EigenesDorf;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;

public class Utils {

	public static final String APP_PLAYER_WINDOW_TITLE = "Tribal Wars 2 (1.59) - Mozilla Firefox";
	public static final String SCREENSHOT_PATH = "src\\main\\resources\\Screenshots\\";

	public static Iterator<EigenesDorf> ITER = null;
	public static EigenesDorf CURRENT = null;
	public static Account CURRENT_ACCOUNT = null;

	/**
	 * Radius!
	 */
	public static final int ICON_SIZE = 10;

	public static final int DELAY_TASTENDRUCK = 100;

	public static final HWND HWND = User32.INSTANCE.FindWindow(null, APP_PLAYER_WINDOW_TITLE);

	/**
	 * Für Klasse Icon
	 */
	public static final int MINDEST_ANZAHL_PIXEL_GLEICH = ((ICON_SIZE * 2) * (ICON_SIZE * 2)) - 20;

	/**
	 * Für Klasse Icon
	 */
	public static final int TOLERANZ = 0;
	public static final int PRIO_QUEUE_SIZE = 1000;
	public static boolean RUNNING = true;

	public static Account Rammboss = new Account(new ArrayList<EigenesDorf>(), "DerZurecker",
			new Rohstofflager(413, 423));


	public static final ArrayList<Account> ACCOUNTS = new ArrayList<Account>();

	static {

		Rammboss.liste.add(new EigenesDorf(1, 413, 421, "001"));
		Rammboss.liste.add(new EigenesDorf(1, 415, 418, "002"));
		Rammboss.liste.add(new EigenesDorf(1, 416, 427, "003"));
		Rammboss.liste.add(new EigenesDorf(4, 415, 429, "004"));
		Rammboss.liste.add(new EigenesDorf(2, 415, 427, "005"));
		Rammboss.liste.add(new EigenesDorf(1, 410, 419, "006"));
		Rammboss.liste.add(new EigenesDorf(3, 414, 416, "007"));
		Rammboss.liste.add(new EigenesDorf(1, 416, 420, "008"));
		Rammboss.liste.add(new EigenesDorf(4, 414, 413, "009"));
		Rammboss.liste.add(new EigenesDorf(3, 417, 428, "010"));
		Rammboss.liste.add(new EigenesDorf(3, 411, 421, "011"));
		Rammboss.liste.add(new EigenesDorf(2, 417, 429, "012"));
		Rammboss.liste.add(new EigenesDorf(3, 415, 421, "013"));
		Rammboss.liste.add(new EigenesDorf(2, 420, 429, "014"));
		Rammboss.liste.add(new EigenesDorf(1, 421, 427, "015"));
		Rammboss.liste.add(new EigenesDorf(1, 419, 429, "016"));
		Rammboss.liste.add(new EigenesDorf(1, 408, 423, "017"));
		Rammboss.liste.add(new EigenesDorf(3, 412, 437, "018"));
		Rammboss.liste.add(new EigenesDorf(1, 420, 428, "019"));
		Rammboss.liste.add(new EigenesDorf(4, 419, 430, "020"));


		ACCOUNTS.add(Rammboss);
		

		CURRENT_ACCOUNT = ACCOUNTS.get(0);

		CURRENT = CURRENT_ACCOUNT.getListe().get(0);
		ITER = CURRENT_ACCOUNT.liste.iterator();

	}

}
