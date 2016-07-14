package com.bot.guicontroller;

import java.awt.Point;
import java.io.File;

import com.bot.settings.Utils;


public class Button {

	private Point point;
	private IconInterface icon;

	public Button(int x, int y, String path) {
		super();
		this.point = new Point(x, y);
		this.icon = new Icon(point, new File(Utils.SCREENSHOT_PATH + path));
	}

	public Button(int x, int y) {
		super();
		this.point = new Point(x, y);
	}

	public boolean check() {
		return this.getIcon().check();
	}

	public boolean IsActive(int time) {
		return this.getIcon().isActive(time);
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public IconInterface getIcon() {
		return icon;
	}

	public void setIcon(IconInterface icon) {
		this.icon = icon;
	}

}
