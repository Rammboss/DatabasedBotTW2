package com.database.model;

import java.awt.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bot.settings.Utils;

@Entity
@Table(name = "DORF")
public abstract class Dorf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "POSITION", nullable = false)
	private Point position;

	@Column(name = "NAME", nullable = false)
	private String name;

	public Dorf(int x, int y, String n) {

		this.position = new Point(x, y);
		this.name = n;
	}

	public Dorf() {
		super();
	}

	public Dorf(int x, int y) {
		this.position = new Point(x, y);
		this.name = "DefaultDorf";
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	public double getDistance() {
		return Math.sqrt(Math.pow(this.getPosition().getX() - Utils.CURRENT.getPosition().getX(), 2)
				+ Math.pow(this.getPosition().getY() - Utils.CURRENT.getPosition().getY(), 2));
	}

}
