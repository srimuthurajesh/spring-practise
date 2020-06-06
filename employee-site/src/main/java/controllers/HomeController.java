package controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import models.Employee;
import models.EmployeeModelImpl;

@Controller
public class HomeController {
	
	@RequestMapping("/addEmployee")
	String addEmployee(@RequestParam("empName") String empName, @RequestParam("empAge") int age, @RequestParam("empDept") String dept){
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
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	String deleteEmployee(@RequestParam("empId") int empId, Model model){
		new EmployeeModelImpl().deleteEmployee(empId);
		return "redirect:";
	}
}
