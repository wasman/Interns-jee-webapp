package com.dio.interns.jsf.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dio.interns.dao.Faculty;
import com.dio.interns.service.FacultyService;

@Controller
@ManagedBean(name="facultyList")
@NoneScoped
public class FacultyList implements Serializable {
	private static final long serialVersionUID = 6818476597199952688L;

	@Autowired
	private FacultyService facultyService;

	public List<Faculty> getFaculties() {
		return facultyService.getFacultiesList();
	}

	public FacultyService getFacultyService() {
		return facultyService;
	}

	public void setFacultyService(FacultyService facultyService) {
		this.facultyService = facultyService;
	}
}
