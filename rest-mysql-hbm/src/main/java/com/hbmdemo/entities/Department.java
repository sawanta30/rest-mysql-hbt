package com.hbmdemo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	private Long id;
	String deptName;
	String buName;
	@OneToMany
	List<Employee> empList;
	
	public Long getDeptId() {
		return id;
	}
	public void setDeptId(Long deptId) {
		this.id = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", buName=" + buName + ", empList=" + empList + "]";
	}
	
	
}
