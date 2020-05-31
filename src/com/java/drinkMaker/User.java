package com.java.drinkMaker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {

	public static void main(String[] args) {
		ApplicationContext app = new AnnotationConfigApplicationContext(JavaConfig.class);
		Sugar sugar = app.getBean("sugar",Sugar.class);	
		System.out.println(sugar.addSuger());
		
		sugar = app.getBean("sugarFromBean",Sugar.class);	
		System.out.println(sugar.addSuger());
		System.out.println(sugar.getSugarCane().addSugarCaneJuice());
		
	}
}
