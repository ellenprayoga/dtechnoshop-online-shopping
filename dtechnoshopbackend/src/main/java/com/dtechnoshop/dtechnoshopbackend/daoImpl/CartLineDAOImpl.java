package com.dtechnoshop.dtechnoshopbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtechnoshop.dtechnoshopbackend.dao.CartLineDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.CartLineModel;
import com.dtechnoshop.dtechnoshopbackend.dto.CartModel;
import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;

@Repository("cartLinedAO")
public class CartLineDAOImpl implements CartLineDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// Add cart line
	public boolean addCartLine(CartLineModel cartLine) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(cartLine);
			session.getTransaction().commit();
			session.close();

			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// Update cart line
	public boolean updateCartLine(CartLineModel cartLine) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(cartLine);
			session.getTransaction().commit();
			session.close();

			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// Delete cart line
	public boolean deleteCartLine(CartLineModel cartLine) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(cartLine);
			session.getTransaction().commit();
			session.close();

			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// Get single cart line
	public CartLineModel getSingleCartLine(int cartLineId) {
		return sessionFactory.openSession().get(CartLineModel.class, cartLineId);
	}

	// Get cart line by cart id
	public List<CartLineModel> getCartLine(int cartId) {
		String queryString = "FROM CartLineModel WHERE cartId = :cartId AND status = :status";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setParameter("cartId", cartId);
		query.setParameter("status", "");

		return query.getResultList();
	}

	// Get all cart line
	public List<CartLineModel> getAllCartLine() {
		String queryString = "FROM CartLineModel WHERE status != :status ORDER BY orderDate DESC";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setParameter("status", "");

		return query.getResultList();
	}

	
	// Get searched cart line
	public List<CartLineModel> getSearchedCartLine(int key) {
		CartLineModel cartLine = sessionFactory.openSession().get(CartLineModel.class, key);
		
		if (cartLine != null) {
			List<CartLineModel> cartLines = new ArrayList<CartLineModel>();
			cartLines.add(cartLine);
			return cartLines;
		}
		
		return null;
		
		
	}

	
	// Get cart line with specific status
	public List<CartLineModel> getSpecificCartLine(String status) {
		String queryString = "FROM CartLineModel WHERE status = :status ORDER BY orderDate DESC";
		
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setParameter("status", status);
		
		return query.getResultList();
	}

	
}
