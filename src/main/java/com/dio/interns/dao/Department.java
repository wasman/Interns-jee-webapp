package com.dio.interns.dao;

import java.io.Serializable;

public class Department implements Serializable {
	private static final long serialVersionUID = -8946944426465353412L;

	private Long id;
	private String name;
	private String description;
	
	private Faculty faculty;
	
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
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
}
