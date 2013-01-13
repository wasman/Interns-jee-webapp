package com.dio.interns.dao;

import java.util.List;

public interface FacultyDao {
	public List<Faculty> getFacultiesList();
	public Faculty getFaculty(Integer id);
	public void saveFaculty(Faculty faculty);
}
