package com.bot.settings;

import java.util.ArrayList;
import java.util.Iterator;

import com.bot.account.Account;
import com.bot.account.Rohstofflager;
import com.database.model.EigenesDorf;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;

public class Utils {

	public static final String APP_PLAYER_WINDOW_TITLE = "Tribal Wars 2 (1.55) - Mozilla Firefox";
	public static final String SCREENSHOT_PATH = "C:\\Temp\\TW2Bot\\Screenshots\\";

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

	public static Account DerZurecker = new Account(new ArrayList<EigenesDorf>(), "DerZurecker",
			new Rohstofflager(418, 406));

	public static Account Rammboss = new Account(new ArrayList<EigenesDorf>(), "DerZurecker",
			new Rohstofflager(413, 423));

	public static Account DonPorro = new Account(new ArrayList<EigenesDorf>(), "DerZurecker",
			new Rohstofflager(418, 406));

	public static final ArrayList<Account> ACCOUNTS = new ArrayList<Account>();

	static {

		DerZurecker.liste.add(new EigenesDorf(3, 420, 404, "Dorf 001"));
		DerZurecker.liste.add(new EigenesDorf(2, 424, 408, "Dorf 002"));
		DerZurecker.liste.add(new EigenesDorf(3, 418, 403, "Dorf 003"));
		DerZurecker.liste.add(new EigenesDorf(3, 419, 405, "Dorf 004"));
		DerZurecker.liste.add(new EigenesDorf(3, 422, 406, "Dorf 005"));
		DerZurecker.liste.add(new EigenesDorf(2, 422, 407, "Dorf 006"));
		DerZurecker.liste.add(new EigenesDorf(2, 423, 407, "Dorf 007"));
		DerZurecker.liste.add(new EigenesDorf(8, 409, 403, "Dorf 008"));
		DerZurecker.liste.add(new EigenesDorf(3, 415, 403, "Dorf 009"));
		DerZurecker.liste.add(new EigenesDorf(2, 414, 401, "Dorf 010"));
		DerZurecker.liste.add(new EigenesDorf(3, 415, 401, "Dorf 011"));
		DerZurecker.liste.add(new EigenesDorf(3, 414, 402, "Dorf 012"));
		DerZurecker.liste.add(new EigenesDorf(3, 412, 405, "Dorf 013"));
		DerZurecker.liste.add(new EigenesDorf(3, 413, 405, "Dorf 014"));
		DerZurecker.liste.add(new EigenesDorf(3, 426, 404, "Dorf 015"));
		DerZurecker.liste.add(new EigenesDorf(2, 405, 405, "Dorf 016"));
		DerZurecker.liste.add(new EigenesDorf(3, 406, 402, "Dorf 017"));
		DerZurecker.liste.add(new EigenesDorf(3, 406, 403, "Dorf 018"));
		DerZurecker.liste.add(new EigenesDorf(3, 418, 405, "Dorf 019"));
		DerZurecker.liste.add(new EigenesDorf(3, 410, 409, "Mancora"));
		DerZurecker.liste.add(new EigenesDorf(2, 415, 398, "C01"));
		DerZurecker.liste.add(new EigenesDorf(2, 412, 398, "C02"));
		DerZurecker.liste.add(new EigenesDorf(3, 407, 397, "C03"));
		DerZurecker.liste.add(new EigenesDorf(2, 410, 396, "C04"));
		DerZurecker.liste.add(new EigenesDorf(3, 411, 395, "C05"));
		DerZurecker.liste.add(new EigenesDorf(3, 411, 393, "C06"));
		DerZurecker.liste.add(new EigenesDorf(3, 411, 392, "C07"));
		DerZurecker.liste.add(new EigenesDorf(3, 413, 389, "C08"));

		DerZurecker.liste.add(new EigenesDorf(2, 414, 396, "C09"));
		DerZurecker.liste.add(new EigenesDorf(3, 414, 395, "C10"));
		DerZurecker.liste.add(new EigenesDorf(3, 415, 395, "C11"));
		DerZurecker.liste.add(new EigenesDorf(3, 406, 397, "C12"));
		DerZurecker.liste.add(new EigenesDorf(8, 415, 410, "Canoa"));
		DerZurecker.liste.add(new EigenesDorf(8, 412, 408, "Iquitos"));

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

		DonPorro.liste.add(new EigenesDorf(4, 402, 419, "La Habana"));
		DonPorro.liste.add(new EigenesDorf(3, 397, 422, "Trenidad"));
		DonPorro.liste.add(new EigenesDorf(4, 397, 423, "Santa clara"));
		DonPorro.liste.add(new EigenesDorf(3, 406, 412, "Baracuar"));
		DonPorro.liste.add(new EigenesDorf(4, 411, 410, "Bogota"));
		DonPorro.liste.add(new EigenesDorf(3, 411, 411, "Sanata Marta"));
		DonPorro.liste.add(new EigenesDorf(4, 413, 410, "Taganga"));
		DonPorro.liste.add(new EigenesDorf(4, 415, 410, "Canoa"));
		DonPorro.liste.add(new EigenesDorf(3, 409, 410, "Cali"));
		DonPorro.liste.add(new EigenesDorf(3, 410, 411, "Monta Nita"));
		DonPorro.liste.add(new EigenesDorf(3, 412, 408, "Iquitos"));

		ACCOUNTS.add(DerZurecker);
		ACCOUNTS.add(Rammboss);
		ACCOUNTS.add(DonPorro);

		CURRENT_ACCOUNT = ACCOUNTS.get(1);

		CURRENT = CURRENT_ACCOUNT.getListe().get(1);
		ITER = CURRENT_ACCOUNT.liste.iterator();

	}

}
