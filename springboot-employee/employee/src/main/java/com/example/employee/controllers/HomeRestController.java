package com.example.employee.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.employee.models.Employee;
import com.example.employee.models.EmployeeModelImpl;

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
	EmployeeModelImpl employeeModelImpl;
	// @RequestMapping("/rest/getEmployees")
	// @RequestMapping(value="/rest/getEmployees", method =
	// RequestMethod.DELETE)
	@GetMapping("/rest/employee")
	List<Employee> defaultPage(Model model) {
		return employeeModelImpl.selectEmployees();
	}

	@PostMapping(value="/rest/employee",produces={"application/x-www-form-urlencoded","application/json"})
	Employee addEmployee(@RequestBody Employee emp) {
		return employeeModelImpl.insertEmployee(emp);
		//return emp;
	}

	@DeleteMapping("/rest/employee/{empId}")
	ResponseEntity deleteEmployee(@PathVariable("empId") int empId, Model model) {
		if (employeeModelImpl.deleteEmployee(empId)) 
			return new ResponseEntity<>(empId, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
