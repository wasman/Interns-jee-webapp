package com.dio.interns.jsf.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.dio.interns.dao.Department;

@ManagedBean
@ViewScoped
public class DepartmentBean implements Serializable {
	private static final long serialVersionUID = -533640901568886954L;

	private Long id;
	private String name;
	private String description;
	private Department department;
	
	public String saveDepartment() {
		return "success";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
