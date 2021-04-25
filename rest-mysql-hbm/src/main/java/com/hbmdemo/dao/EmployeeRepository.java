package com.hbmdemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hbmdemo.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
