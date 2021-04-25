package com.hbmdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hbmdemo.entities.Employee;
import com.hbmdemo.service.EmployeeService;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/{eid}")
	public Employee updateEmployee(@PathVariable("eid") Long eid, @RequestBody Employee employee){
		return employeeService.updateEmployee(eid, employee);
	}
	
	@GetMapping("/{eid}")
	public Employee getEmployeeById(@PathVariable("eid") Long eid){
		return employeeService.getEmployeeById(eid);
	}
	
	@DeleteMapping("/{eid}")
	public void deleteEployeeById(@PathVariable("eid") Long eid){
		employeeService.deleteEmployeeById(eid);
	}
	
	@DeleteMapping
	public void deleteAllEmployees(){
		employeeService.deleteAllEmployees();
	}
}
