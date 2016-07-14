package com.bot.factories;

import java.util.Date;

import com.bot.common.AuftragslisteInterface;
import com.bot.common.auftraege.CheckRohstofflager;
import com.bot.settings.Utils;


public class RostofflagerFactory {
	private static RostofflagerFactory singelton;
	
	private AuftragslisteInterface liste;
	
	private long lastCheck;
	
	private static boolean USE_ITEM = false;
	
	private static final int INTERVALL = 5;
	
	private RostofflagerFactory(){
		super();
	}
	
	private RostofflagerFactory(AuftragslisteInterface liste){
		this.liste = liste;
		lastCheck = 0;
		singelton = this;
	}
	public static RostofflagerFactory getRohstofflagerFactory(AuftragslisteInterface liste){
		if(singelton == null){
			return new RostofflagerFactory(liste);
		}else return singelton;
	}
	
	public void check(){
		if(new Date().getTime() > lastCheck + (INTERVALL * 60 * 1000)){
			liste.add(new CheckRohstofflager(Utils.CURRENT_ACCOUNT.getLager(), USE_ITEM));
			lastCheck = new Date().getTime();
		}
	}
}
