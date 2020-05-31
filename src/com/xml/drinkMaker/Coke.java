package com.xml.drinkMaker;

public class Coke implements Beverage{
	private String color;
	private String soda;
	Sugar sugarObj;
	Sugar sugarObjj;
	
	/*set by constructor*/
	public Coke(String soda){
		this.soda=soda;
	}
	
	/*set by setter method*/
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getSoda() {
		return soda;
	}

	@Override
	public String getColor() {
		return color;
	}
	
	public Sugar getSugarObj() {
		return sugarObj;
	}

	public void setSugarObj(Sugar sugarObj) {
		this.sugarObj = sugarObj;
	}
	public void setSugarObjj(Sugar sugarObjj) {
		this.sugarObjj=sugarObjj;
	}

	@Override
	public void printSugarObjj() {
		// TODO Auto-generated method stub
		
	}
}
