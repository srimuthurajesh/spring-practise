package com.java.drinkMaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sugar")   //component name is optional, default is Classname with smallcase first letter
public class Sugar {
	//if we using function inside @Configuration, then @Autowired not needed
	@Autowired
	private SugarCane sugarCane;
	
	public SugarCane getSugarCane() {
		return sugarCane;
	}
	public void setSugarCane(SugarCane sugarCane) {
		this.sugarCane = sugarCane;
	}
	public Sugar(SugarCane sugarCane){
		this.sugarCane = sugarCane;
	}
	 String addSuger(){
		 return "sugar added 1 time";
	 }
}
