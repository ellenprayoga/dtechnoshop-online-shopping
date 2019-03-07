package com.dtechnoshop.dtechnoshopbackend.daoImpl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtechnoshop.dtechnoshopbackend.dao.CartDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.CartModel;
import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	// Add cart
	public boolean addCart(CartModel cart) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(cart);
			session.getTransaction().commit();
			session.close();
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Update cart
	public boolean update(CartModel cart) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(cart);
			session.getTransaction().commit();
			session.close();
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Delete cart
	public boolean deleteCart(CartModel cart) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(cart);
			session.getTransaction().commit();
			session.close();
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Get cart
	public CartModel getCart(UserModel user) {
		try {
			String queryString = "FROM CartModel WHERE user = :user";
			Query query = sessionFactory.openSession().createQuery(queryString);
			query.setParameter("user", user);
			
			return (CartModel) query.getSingleResult();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
