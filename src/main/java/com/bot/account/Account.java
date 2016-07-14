package com.bot.account;

import java.util.List;

import com.database.model.EigenesDorf;


public class Account {
	public List<EigenesDorf> liste;
	public String name;
	public Rohstofflager lager;
	
	public Account(List<EigenesDorf> liste, String name, Rohstofflager lager) {
		super();
		this.liste = liste;
		this.name = name;
		this.lager = lager;
	}
	public List<EigenesDorf> getListe() {
		return liste;
	}
	public String getName() {
		return name;
	}
	public Rohstofflager getLager() {
		return lager;
	}
	
	
	
	
}
