package com.csit.project.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csit.project.entities.User;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	// save user to the database
	public void save(User user) {
		getSession().save(user);
	}

	// delete user from database
	public void delete(User user) {
		getSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		return getSession().createQuery("from User").list();
	}

	public User getSingleUserByEmail(String email) {
		return (User) getSession().createQuery("from User where email = :email").setParameter("email", email)
				.uniqueResult();
	}

	public User getSingleUserById(int id) {
		return (User) getSession().load(User.class, id);
	}

	public void updateUserData(User user) {
		getSession().update(user);
	}
}
