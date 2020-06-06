package controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.Employee;
import models.EmployeeModelImpl;

@RestController
public class HomeRestController {

	// @RequestMapping("/rest/getEmployees")
	// @RequestMapping(value="/rest/getEmployees", method =
	// RequestMethod.DELETE)
	@GetMapping("/rest/getEmployees")
	List<Employee> defaultPage(Model model) {
		return new EmployeeModelImpl().selectEmployees();
	}

	@PostMapping(value="/rest/addEmployee",produces={"application/x-www-form-urlencoded","application/json"})
	Employee addEmployee(@RequestBody Employee emp) {
			new EmployeeModelImpl().insertEmployee(emp);
		return emp;
	}

	@DeleteMapping("/rest/deleteEmployee/{empId}")
	ResponseEntity deleteEmployee(@PathVariable("empId") int empId, Model model) {
		if (new EmployeeModelImpl().deleteEmployee(empId)) 
			return new ResponseEntity<>(empId, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
