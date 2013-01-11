package com.dio.interns.dao;

import java.util.List;

import org.hibernate.SessionFactory;

public class FacultyDaoImpl implements FacultyDao {
	SessionFactory sessionFactory;

	@Override
	public List<Faculty> getFacultiesList() {
		List<Faculty> result = (List<Faculty>) getSessionFactory().getCurrentSession().createQuery("from Faculty").list();
		return result;
	}

	@Override
	public Faculty getFaculty(Integer id) {
		List<Faculty> result = (List<Faculty>) getSessionFactory().getCurrentSession().createQuery("from Faculty where id=?").setParameter(0, id).list();
		return result == null ? null : result.get(0);
	}

	@Override
	public void saveFaculty(Faculty faculty) {
		getSessionFactory().getCurrentSession().saveOrUpdate(faculty);

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
