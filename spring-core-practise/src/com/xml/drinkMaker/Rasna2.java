package com.xml.drinkMaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Rasna2 implements Beverage{
	//@Value("red")
	private String color;
	//@Value("${rasna.soda}")
	private String soda;
	
	@Autowired
	Sugar sugarObj;
	/*there is not getter setter needed, if Autowired add before dependency declaration*/
	
	
	/*can autowired add before setter, if spring need to call our own setter, otherwise wont call setter, directly assign*/
	//@Autowired
	public void setSugarObj(Sugar sugarObj) {
		this.sugarObj = sugarObj;
	}
	public void printSugarObjj(){
		System.out.println(this.sugarObj.addSuger()+" from sugarobjj");
	}
	public void setColor(String color) {
		this.color = color;
	}

	public void setSoda(String soda) {
		this.soda = soda;
	}

	
	@Override
	public String getColor() {
		return color;
	}

	@Override
	public String getSoda() {
		return soda;
	}
	@Override
	public Sugar getSugarObj() {
		
		return sugarObj;
	}

	
}
