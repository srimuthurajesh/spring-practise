package com.example.employee.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDaoJpaRepository extends JpaRepository<Employee, Integer> {
    /**
     *  
     * These function automatically get implemented no need to write logic  
     * public boolean deleteById(int empId);
        public List<Employee> findAll(); 
        public void save(Employee emp);
    	public Employee findById();
     */
}