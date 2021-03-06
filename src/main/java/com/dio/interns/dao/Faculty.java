package com.dio.interns.dao;

import java.io.Serializable;
import java.util.Set;

public class Faculty implements Serializable {
	private static final long serialVersionUID = -4034184535404994684L;

	private Integer id;
	private String name;
	private String description;
	
	private Set<Faculty> departments;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Set<Faculty> getDepartments() {
		return departments;
	}
	public void setDepartments(Set<Faculty> departments) {
		this.departments = departments;
	}
}
