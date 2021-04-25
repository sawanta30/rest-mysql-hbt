package com.hbmdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbmdemo.dao.EmployeeRepository;
import com.hbmdemo.entities.Employee;
import com.hbmdemo.exception.EmployeeNotFoundException;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long eid) {
		
		return employeeRepository.findById(eid).orElseThrow(()->new EmployeeNotFoundException(10011, eid,"Error occured while getting employee details","Employee not present in database"));
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Long eid, Employee employee) {
		if (employeeRepository.existsById(eid)) {
			employee.setEid(eid);
			return employeeRepository.save(employee);
		}else {
			throw new EmployeeNotFoundException(10012, eid,"Error occured while updating employee details","Employee not present in database");
		}
	}

	@Override
	public void deleteEmployeeById(Long eid) {
		if (employeeRepository.existsById(eid)) 
			employeeRepository.deleteById(eid);
		else
			throw new EmployeeNotFoundException(10013, eid,"Error occured while deleting employee details","Employee not present in database");
	}

	@Override
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
		
	}

	
}
