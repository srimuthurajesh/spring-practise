package models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

public class EmployeeModelImpl {
	
	public void insertEmployee(Employee emp){
		HibernateConn hibernateConn = new HibernateConn();
		Session session = hibernateConn.getHibernateSession();
		
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		hibernateConn.closeFactory();
	}
	
	public List<Employee> selectEmployees(){
		HibernateConn hibernateConn = new HibernateConn();
		Session session = hibernateConn.getHibernateSession();
		
		session.beginTransaction();
		List<Employee> employees = session.createQuery("from Employee").setCacheable(true).list();
		
		//to perform second level cache
		/*Employee emp = session.get(Employee.class,1);
		List<Employee> employees = new ArrayList<>();
		employees.add(emp);*/
	    
	    session.getTransaction().commit();
		
	    /*
		System.out.println("\n\nStudents whose email ends with gmail.com");			
		for (Employee emp : employees) {
			System.out.println(emp.getEmpName());
		}
		
		*/
		hibernateConn.closeFactory();
		return employees;
	}
	
	 /*@Override
	    protected void finalize() throws Throwable {
	        try{
	        	hibernateConn.closeFactory();
	        }finally{        
	            super.finalize();
	        }
	    } */


}
