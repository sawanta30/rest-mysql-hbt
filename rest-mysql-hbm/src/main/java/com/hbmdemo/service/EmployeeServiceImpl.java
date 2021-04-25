package com.hbmdemo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.hbmdemo.dao.EmployeeRepository;
import com.hbmdemo.entities.Employee;
import com.hbmdemo.exception.EmployeeNotFoundException;

@Component
@Transactional(isolation = Isolation.SERIALIZABLE,timeout = 10,rollbackFor = {SQLException.class})
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
		
			Employee emp = employeeRepository.findById(eid)
											.orElseThrow(()->
			new EmployeeNotFoundException(10011, eid,"Error occured while getting employee details","Employee not present in database"));
			emp = setPeristentEmployee(emp, employee);
			return employeeRepository.save(emp);
		
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
	
	private Employee setPeristentEmployee(Employee dbObject,Employee newObject) {
		dbObject.getAddress().setAddressLine(newObject.getAddress().getAddressLine());
		dbObject.getAddress().setDistrict(newObject.getAddress().getDistrict());
		dbObject.getAddress().setState(newObject.getAddress().getState());
		dbObject.getAddress().setCountry(newObject.getAddress().getCountry());
		dbObject.getAddress().setPincode(newObject.getAddress().getPincode());
		
		dbObject.getSalary().setSalary(newObject.getSalary().getSalary());
		dbObject.getSalary().setSlab(newObject.getSalary().getSlab());
		
		dbObject.setFirstname(newObject.getFirstname());
		dbObject.setLastname(newObject.getLastname());
		dbObject.setDateOfBirth(newObject.getDateOfBirth());
		dbObject.setDateOfJoining(newObject.getDateOfJoining());
		dbObject.setEmail(newObject.getEmail());
		dbObject.setPan(newObject.getPan());
		dbObject.setMobile(newObject.getMobile());
		
		return dbObject;
	}

	
}
