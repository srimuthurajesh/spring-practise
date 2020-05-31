package com.xml.drinkMaker;

public class Rasna implements Beverage{
	//@Value("${rasna.color}")
	private String color;
	//@Value("yes")
	private String soda;
	Sugar sugarObj;
	Sugar sugarObjj;
	
	public Rasna(Sugar sugarObj){
		this.sugarObj=sugarObj;
	}
	
	public void setSugarObjj(Sugar sugarObjj) {
		this.sugarObjj = sugarObjj;
	}

	
	
	public void printSugarObjj(){
		System.out.println(this.sugarObjj.addSuger()+" from sugarobjj");
	}
	public void setColor(String color) {
		this.color = color;
	}

	public void setSoda(String soda) {
		this.soda = soda;
	}

	
	public void setSugarObj(Sugar sugarObj) {
		this.sugarObj = sugarObj;
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
		return this.sugarObj;
	}

}
