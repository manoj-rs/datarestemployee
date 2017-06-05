package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@Controller
public class EmployeeWebUIController {
	private EmployeeService empService;

	public EmployeeWebUIController(EmployeeService empService) {
		this.empService = empService;
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/getEmployees")
	public String findAllEmployees(ModelMap model) {

		model.put("employees", empService.findAll());
		return "employees";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "add_employee";
	}

	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute Employee employee, ModelMap model) {
		model.put("employees", empService.insert(employee));
		return "employees";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id, ModelMap model) {
		model.put("employees", empService.delete(id));
		return "employees";
	}

	@GetMapping("/updateEmployee/{id}")
	public String editEmployee(@PathVariable Long id, Model model) {
		model.addAttribute("employee", empService.findByEmpId(id));
		return "edit_employee";
	}

	@PostMapping("/updateEmployee")
	public String editEmployee(@ModelAttribute Employee employee, ModelMap model) {
		model.put("employees", empService.save(employee));
		return "employees";
	}

}
