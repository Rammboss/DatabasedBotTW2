package com.bot.factories;

import com.bot.common.AuftragslisteInterface;
import com.bot.common.auftraege.NothingToDo;

public class AnalyseMapFactory {
private static AnalyseMapFactory singelton;
	
	private AuftragslisteInterface liste;
	
	
	
	
	private AnalyseMapFactory(){
		super();
	}
	
	private AnalyseMapFactory(AuftragslisteInterface liste){
		this.liste = liste;
		singelton = this;
	}
	public static AnalyseMapFactory getAnalyseMapFactory(AuftragslisteInterface liste){
		if(singelton == null){
			return new AnalyseMapFactory(liste);
		}else return singelton;
	}
	
	public void check(){
		if(liste.countsAuftraege("AnalyseMapFactory") < 1)
			liste.add(new NothingToDo(0));
	}

}
