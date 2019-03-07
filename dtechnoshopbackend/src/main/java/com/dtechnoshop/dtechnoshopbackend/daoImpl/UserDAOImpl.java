package com.dtechnoshop.dtechnoshopbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtechnoshop.dtechnoshopbackend.dao.UserDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.ProductModel;
import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	// Add user
	public boolean addUser(UserModel user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.getTransaction();
			t.begin();
			session.persist(user);
			t.commit();
			session.close();
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Update user
	public boolean updateUser(UserModel user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.getTransaction();
			t.begin();
			session.update(user);
			t.commit();
			session.close();
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Delete user
	public boolean deleteUser(UserModel user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.getTransaction();
			t.begin();
			session.delete(user);
			t.commit();
			session.close();
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Get single user
	public UserModel getSingleUser(int id) {
		return sessionFactory.openSession().get(UserModel.class, id);
	}

	
	// Get all users
	public List<UserModel> getAllUser() {
		return sessionFactory.openSession().createQuery("FROM UserModel").getResultList();
	}

	
	// Get user login
	public UserModel getUserLogin(String email) {
		try {
			String queryString = "FROM UserModel WHERE email = :email";
			Query query = sessionFactory.openSession().createQuery(queryString);
			query.setParameter("email", email);
			
			return (UserModel) query.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}

	
	// Get searched user
	public List<UserModel> getSearchedUser(int userId) {	
		UserModel user = sessionFactory.openSession().get(UserModel.class, userId);
		
		if (user != null) {
			List<UserModel> users = new ArrayList<UserModel>();
			users.add(user);
			return users;
		}
		
		return null;
	}
}
