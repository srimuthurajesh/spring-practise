package com.example.employee.controllers;

import java.util.List;

import com.example.employee.models.Employee;
import com.example.employee.models.EmployeeDaoFactory;
import com.example.employee.models.EmployeeDaoImpl;
import com.example.employee.models.EmployeeDaoJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

	@Autowired
	EmployeeDaoJpaRepository employeeDaoImpl;
	//EmployeeDaoImpl employeeDaoImpl;
	@GetMapping("/rest/employee")
	List<Employee> defaultPage(Model model) {
		return employeeDaoImpl.findAll();
	}

	@PostMapping(value="/rest/employee")
	Employee save(@RequestBody Employee emp) {
		return emp; 
	}

	@DeleteMapping("/rest/employee/{empId}")
	ResponseEntity deleteEmployee(@PathVariable("empId") int empId, Model model) {
		employeeDaoImpl.deleteById(empId);	
		return new ResponseEntity<>(empId, HttpStatus.OK);
	}
}
