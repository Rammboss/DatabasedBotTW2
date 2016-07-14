package com.bot.model;

import com.bot.settings.Utils;


public abstract class Dorf {


	private int id;

	private int x;
	private int y;

	private String name;

	public Dorf(int id, int x, int y, String n) {
		this.x = x;
		this.y = y;
		this.name = n;
		this.id = id;

	}

	public Dorf(int x, int y) {
		this.id = -1;
		this.name = "DefaultDorf";
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dorf other = (Dorf) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public double getDistance() {
		return Math.sqrt(Math.pow(getX() - Utils.CURRENT.getX(), 2) + Math.pow(this.getY() - Utils.CURRENT.getY(), 2));
	}

	@Override
	public String toString() {
		return "Dorf [x=" + x + ", y=" + y + ", name=" + name + "]";
	}
	

}
