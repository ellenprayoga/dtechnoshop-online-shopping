package com.dtechnoshop.dtechnoshopbackend.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtechnoshop.dtechnoshopbackend.dao.ProductDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.ProductModel;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	// Add new product
	public boolean addProduct(ProductModel productModel) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.getTransaction();
			t.begin();
			session.persist(productModel);
			t.commit();
			session.close();
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Update product
	public boolean updateProduct(ProductModel productModel) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.getTransaction();
			t.begin();
			session.update(productModel);
			t.commit();
			session.close();
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Delete product
	public boolean deleteProduct(ProductModel productModel) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.getTransaction();
			t.begin();
			session.delete(productModel);
			t.commit();
			session.close();
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Get single product
	public ProductModel getSingleProduct(int productId) {
		return sessionFactory.openSession().get(ProductModel.class, productId);
	}

	
	// Get all products
	public List<ProductModel> getAllProducts() {
		return sessionFactory.openSession().createQuery("FROM ProductModel").getResultList();
	}

	
	// Get all active products
	public List<ProductModel> getAllActiveProducts() {
		String queryString = "FROM ProductModel WHERE isActive = :isActive";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setParameter("isActive", true);
		
		return query.getResultList();
	}

	
	// Get all products by category
	public List<ProductModel> getAllProductByCategory(int categoryId) {
		String queryString = "FROM ProductModel WHERE isActive = :isActive AND categoryId = :categoryId";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setParameter("isActive", true);
		query.setParameter("categoryId", categoryId);
		
		return query.getResultList();
	}
	
	
	// Get all products with fixed number
	public List<ProductModel> getAllProductByFixedNumber(int id, int number) {
		String queryString = "FROM ProductModel WHERE isActive = :isActive AND categoryId = :categoryId";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setParameter("isActive", true);
		query.setParameter("categoryId", id);
		query.setMaxResults(number);
		
		return query.getResultList();
	}

	
	// Get searched products
	public List<ProductModel> getSearchedProducts(String keyWords) {
		Criteria criteria = sessionFactory.openSession().createCriteria(ProductModel.class);
		criteria.add(Restrictions.eq("isActive", true));
		criteria.add(Restrictions.like("productName", "%" + keyWords + "%"));
		
		return criteria.list();
	}

	
	// Get quantity of single product
	public int getProductQuantity(int productId) {
		String queryString = "SELECT quantity FROM ProductModel WHERE id = :productId";
		
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setParameter("productId", productId);
		
		return (Integer) query.getSingleResult();
	}


	// Get data management searched product
	public List<ProductModel> getDataManagemnetSearchedProduct(String key) {
		Criteria criteria = sessionFactory.openSession().createCriteria(ProductModel.class);
		criteria.add(Restrictions.like("productName", "%" + key + "%"));
		
		return criteria.list();
	}
	
	
}
