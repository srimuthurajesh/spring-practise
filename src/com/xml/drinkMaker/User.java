package com.xml.drinkMaker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appObj = new ClassPathXmlApplicationContext("beans.xml");
		
		/*we can use interface name*/
		//Beverage coke = (Beverage)appObj.getBean("coke");
		
		/*we can use implemented class name*/
		//Coke coke = (Coke)appObj.getBean("coke");
		
		
		/*can use 2nd paramter and avoid typcasting*/
		Beverage beverage = appObj.getBean("coke",Beverage.class);
		printBeverage(beverage);
		
		beverage = appObj.getBean("rasna",Beverage.class);
		printBeverage(beverage);
		beverage.printSugarObjj();
		
		beverage = appObj.getBean("rasna2",Beverage.class);
		printBeverage(beverage);
	
		beverage = appObj.getBean("rasna3",Beverage.class);
		printBeverage(beverage);
		
		
	}
	public static void printBeverage(Beverage beverage){
		System.out.println(beverage.getClass());
		System.out.println(beverage.getColor());
		System.out.println(beverage.getSoda());
		System.out.println(beverage.getSugarObj().addSuger());
	}

}
