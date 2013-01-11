package com.dio.interns.service;

import java.util.List;

import com.dio.interns.dao.Faculty;

public interface FacultyService {
	public List<Faculty> getFacultiesList();
	public Faculty getFaculty(Integer id);
	public void saveFaculty(Faculty faculty);

}
