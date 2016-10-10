package com.database;

import org.joda.time.LocalDateTime;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.database.configuration.AppConfig;
import com.database.model.Analyser;
import com.database.model.Dorf;
import com.database.service.AnalyserService;
import com.database.service.DorfService;


public class TestDatabase {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 
        AnalyserService service = (AnalyserService) context.getBean("analyserService");
        
        
       // service.saveDorf(new Dorf(412, 422, "Babarendorf", new LocalDateTime()));
//        Dorf d = (Dorf) service.findById(3);
//        d.setX(413);
//        service.updateDorf(d);
        
        Analyser a = service.findById(1);
        a.setX(412);
        a.setY(422);
        a.setBreite(1);
        a.setRichtung(1);
        a.setRichtungscounter(0);
        service.updateAnalyser(a);
        context.close();

	}

}
