package com.dio.interns.jsf.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dio.interns.dao.Department;
import com.dio.interns.dao.Faculty;
import com.dio.interns.service.FacultyService;

@ManagedBean(name="facultyBean")
@NoneScoped
@Controller
public class FacultyBean implements Serializable {
	private static final long serialVersionUID = 7308905908070795847L;

	private Integer id;
	private String name;
	private String description;
	private Faculty faculty;
	private List<Department> departments;
	
	@Autowired
	FacultyService facultyService;

	public void editFaculty() {
		if (faculty == null) {
			faculty = new Faculty();
		}
		
		faculty.setName(getName());
		faculty.setDescription(getDescription());
		
		//TODO save to DB
		facultyService.saveFaculty(faculty);
	}
	
	public void cancelFaculty() {
		setName(faculty == null ? "" : faculty.getName());
		setDescription(faculty == null ? "" : faculty.getDescription());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		System.out.println("Sets id to the form. ID = " + id);
		this.id = id;
		
		if (id != null) {
			facultyService.getFaculty(id);
		}
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

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public FacultyService getFacultyService() {
		return facultyService;
	}

	public void setFacultyService(FacultyService facultyService) {
		this.facultyService = facultyService;
	}
}
