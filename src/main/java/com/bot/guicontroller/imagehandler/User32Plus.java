package com.bot.guicontroller.imagehandler;

import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.W32APIOptions;

/**
 * Additions to standard User32 API's.
 */
public interface User32Plus extends User32 {
	class HDESK extends PointerType {
		public HDESK() {
		}

		public HDESK(Pointer pointer) {
			super(pointer);
		}
	}

	class HWINSTA extends PointerType {
		public HWINSTA() {
		}

		public HWINSTA(Pointer pointer) {
			super(pointer);
		}
	}

	class SECURITY_ATTRIBUTES extends Structure {
		boolean inheritHandle;
		int length;
		Pointer securityDescriptor;
		@Override
		protected List getFieldOrder() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	User32Plus INSTANCE = (User32Plus) Native.loadLibrary(User32Plus.class, W32APIOptions.UNICODE_OPTIONS);

	boolean CloseDesktop(HDESK hDesktop);

	HDESK CreateDesktop(String desktop, String device, Pointer devmode, int flags, int desiredAccess,
			SECURITY_ATTRIBUTES securityAttributes);

	HWINSTA CreateWindowStation(String winsta, int flags, int desiredAccess, SECURITY_ATTRIBUTES securityAttributes);

	WinDef.HWND GetDesktopWindow();

	int GetLastError();

	HWINSTA GetProcessWindowStation();

	HDESK GetThreadDesktop(int threadId);

	boolean IsIconic(HWND hwnd);

	boolean PrintWindow(WinDef.HWND hwnd, WinDef.HDC hdcBlt, int nFlags);

	boolean SetProcessWindowStation(HWINSTA windowStation);

	boolean SetThreadDesktop(HDESK desktop);

	boolean SwitchDesktop(HDESK desktop);
}
