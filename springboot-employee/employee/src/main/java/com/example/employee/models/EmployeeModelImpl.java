package com.example.employee.models;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeModelImpl {

	private EntityManager entityManager;
		
	@Autowired
	public EmployeeModelImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Transactional
	public Employee insertEmployee(Employee emp) {
		Session session = entityManager.unwrap(Session.class);
		session.save(emp);
		return session.get(Employee.class, emp.getEmpid());
	}
	@Transactional
	public List<Employee> selectEmployees() {
		Session session = entityManager.unwrap(Session.class);
		List<Employee> employees = session.createQuery("from Employee").list();
		return employees;
	}
	@Transactional
	public boolean deleteEmployee(int empId) {
		Session session = entityManager.unwrap(Session.class);
		try {
			Employee employee = new Employee();
			employee.setEmpid(empId);
			session.delete(employee);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
}
