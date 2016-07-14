package com.database;

import org.joda.time.LocalDateTime;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.database.configuration.AppConfig;
import com.database.model.Dorf;
import com.database.service.DorfService;


public class TestDatabase {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 
        DorfService service = (DorfService) context.getBean("dorfService");
        
        
       // service.saveDorf(new Dorf(412, 422, "Babarendorf", new LocalDateTime()));
        Dorf d = (Dorf) service.findById(3);
        d.setX(413);
        service.updateDorf(d);
        context.close();

	}

}
