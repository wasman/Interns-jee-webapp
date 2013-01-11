package com.dio.interns.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dio.interns.dao.Faculty;
import com.dio.interns.dao.FacultyDao;

@Transactional(readOnly = true)
public class FacultyServiceImpl implements FacultyService {
	private FacultyDao facultyDao;
	
	@Override
	public List<Faculty> getFacultiesList() {
		return facultyDao.getFacultiesList();
	}

	@Override
	public Faculty getFaculty(Integer id) {
		return facultyDao.getFaculty(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveFaculty(Faculty faculty) {
		facultyDao.saveFaculty(faculty);
	}

	public FacultyDao getFacultyDao() {
		return facultyDao;
	}

	public void setFacultyDao(FacultyDao facultyDao) {
		this.facultyDao = facultyDao;
	}

}
