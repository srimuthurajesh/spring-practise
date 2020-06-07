package com.example.employee.models;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Transactional
	public void save(Employee emp) {
		Session session = entityManager.unwrap(Session.class);
		session.save(emp);
	}
	@Transactional
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Employee> employees = session.createQuery("from Employee").list();
		return employees;
	}
	@Transactional
	public boolean deleteById(int empId) {
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

	@Override
	public Employee findById() {
		// TODO Auto-generated method stub
		return null;
	}
}
