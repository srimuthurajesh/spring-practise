package com.example.employee.models;

import java.util.List;

public interface EmployeeDao {
    public boolean deleteById(int empId);
    public List<Employee> findAll(); 
    public void save(Employee emp);
	public Employee findById();
}