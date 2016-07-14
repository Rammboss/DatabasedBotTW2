package com.bot.guicontroller;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.bot.settings.Keys;
import com.bot.settings.Utils;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.WPARAM;

public class MouseRobot {

	private HWND hWnd;

	public MouseRobot(HWND hWnd) {
		this.hWnd = hWnd;
	}

	public void click(Button b) {

		WinDef.WPARAM xx = new WinDef.WPARAM(0);

		WinDef.LPARAM yy = new WinDef.LPARAM(b.getPoint().x + (b.getPoint().y << 16));
		User32.INSTANCE.PostMessage(hWnd, Keys.WM_LBUTTONDOWN, xx, yy);

		User32.INSTANCE.PostMessage(hWnd, Keys.WM_LBUTTONUP, xx, yy);

	}
	public void click(int x, int y) {

		WinDef.WPARAM xx = new WinDef.WPARAM(0);

		WinDef.LPARAM yy = new WinDef.LPARAM(x + (y << 16));
		User32.INSTANCE.PostMessage(hWnd, Keys.WM_LBUTTONDOWN, xx, yy);

		User32.INSTANCE.PostMessage(hWnd, Keys.WM_LBUTTONUP, xx, yy);

	}

	public void doubleClick(Button b) {
		click(b);
		wait(Utils.DELAY_TASTENDRUCK);
		click(b);
	}

	public static void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {

		}
	}

	public static void wait(long min, TimeUnit t) {
		try {

			Thread.sleep(t.toMillis(min));
		} catch (InterruptedException e) {
		}
	}

	public void enterKoordinate(int x) {

		switch (x) {
		case 0 - 10:
			switch (x) {
			case 0:
				keyDown(0x0030);
				break;
			case 1:
				keyDown(0x0031);
				break;
			case 2:
				keyDown(0x0032);
				break;
			case 3:
				keyDown(0x0033);
				break;
			case 4:
				keyDown(0x0034);
				break;
			case 5:
				keyDown(0x0035);
				break;
			case 6:
				keyDown(0x0036);
				break;
			case 7:
				keyDown(0x0037);
				break;
			case 8:
				keyDown(0x0038);
				break;
			case 9:
				keyDown(0x0039);
				break;

			default:

				break;
			}
			break;

		default:
			int einer = (x % 100) % 10;
			int zehner = ((x % 100) - einer) / 10;
			int hunderter = (x - zehner - einer) / 100;

			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(hunderter);
			tmp.add(zehner);
			tmp.add(einer);

			for (int i : tmp) {

				switch (i) {
				case 0:
					keyDown(0x0030);
					break;
				case 1:
					keyDown(0x0031);
					break;
				case 2:
					keyDown(0x0032);
					break;
				case 3:
					keyDown(0x0033);
					break;
				case 4:
					keyDown(0x0034);
					break;
				case 5:
					keyDown(0x0035);
					break;
				case 6:
					keyDown(0x0036);
					break;
				case 7:
					keyDown(0x0037);
					break;
				case 8:
					keyDown(0x0038);
					break;
				case 9:
					keyDown(0x0039);
					break;

				default:

					break;
				}

			}

			break;
		}

	}

	private void keyDown(int i) {

		HWND hWnd = User32.INSTANCE.FindWindow(null, Utils.APP_PLAYER_WINDOW_TITLE);

		User32.INSTANCE.PostMessage(hWnd, WinUser.WM_SYSKEYDOWN, new WPARAM(i), new LPARAM(0));

		wait(Utils.DELAY_TASTENDRUCK);

	}

}
