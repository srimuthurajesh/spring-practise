package com.java.drinkMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
		
		try{  
			Class.forName("org.h2.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:h2:~/test", "sa","sa");  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from emp");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
			}
		catch(Exception e){ System.out.println(e);}  
		
	}
}
