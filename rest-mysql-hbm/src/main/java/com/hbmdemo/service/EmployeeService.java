package com.hbmdemo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.hbmdemo.entities.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long eid);
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Long eid, Employee employee);
	void deleteEmployeeById(Long eid);
	void deleteAllEmployees();
}
