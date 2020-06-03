package controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import models.Employee;
import models.EmployeeModelImpl;

@Controller
public class HomeController {
	
	@RequestMapping("/addEmployee")
	String homePage(@RequestParam("empName") String empName, @RequestParam("empAge") int age, @RequestParam("empDept") String dept){
		System.out.println(empName);
		Employee emp = new Employee();
		emp.setEmpName(empName);emp.setAge(age);emp.setDept(dept);
		new EmployeeModelImpl().insertEmployee(emp);
		return "redirect:";
	}
	
	
	@RequestMapping("/")
	String defaultPage(Model model){
		//new EmployeeModelImpl().selectEmployees();
		List<Employee> employees = new EmployeeModelImpl().selectEmployees();
		model.addAttribute("empModel", employees);
		return "index";
	}
}
