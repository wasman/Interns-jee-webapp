package com.dio.interns.jsf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dio.interns.dao.Faculty;

@ManagedBean(name="facultyList")
@SessionScoped
public class FacultyList implements Serializable {
	private static final long serialVersionUID = 6818476597199952688L;

	private List<Faculty> faculties = new ArrayList<Faculty>();

	public String addFaculty() {
		Faculty org = new Faculty();
		
		org.setId(new Long(faculties.size() + 1));
		org.setName("Faculty # " + String.valueOf(faculties.size() + 1));
		org.setDescription("Description for Faculty # " + String.valueOf(faculties.size() + 1));
		
		faculties.add(org);
		return "success";
	}
	
	public String editFaculty(int id) {
		Faculty org = faculties.get(id -1);
		
		org.setDescription("Edited Description");
		
		return "success";
	}

	public List<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}
}
