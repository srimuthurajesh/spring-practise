package models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

public class EmployeeModelImpl {

	public void insertEmployee(Employee emp) {
		HibernateConn hibernateConn = new HibernateConn();
		Session session = hibernateConn.getHibernateSession();

		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}

	public List<Employee> selectEmployees() {
		HibernateConn hibernateConn = new HibernateConn();
		Session session = hibernateConn.getHibernateSession();

		session.beginTransaction();
		List<Employee> employees = session.createQuery("from Employee").setCacheable(true).list();

		// to perform second level cache
		/*
		 * Employee emp = session.get(Employee.class,1); List<Employee>
		 * employees = new ArrayList<>(); employees.add(emp);
		 */

		session.getTransaction().commit();
		session.close();
		return employees;
	}

	public boolean deleteEmployee(int empId) {
		HibernateConn hibernateConn = new HibernateConn();
		Session session = hibernateConn.getHibernateSession();
		try {
			Employee employee = new Employee();
			employee.setEmpid(empId);
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			session.close();
		}
	}
}
