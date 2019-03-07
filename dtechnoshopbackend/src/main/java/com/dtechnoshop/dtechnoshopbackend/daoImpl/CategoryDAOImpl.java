package com.dtechnoshop.dtechnoshopbackend.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtechnoshop.dtechnoshopbackend.dao.CategoryDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.CategoryModel;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// Add category
	public boolean addCategory(CategoryModel categoryModel) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.getTransaction();
			t.begin();
			session.persist(categoryModel);
			t.commit();
			session.close();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// Update category
	public boolean updateCategory(CategoryModel categoryModel) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.getTransaction();
			t.begin();
			session.update(categoryModel);
			t.commit();
			session.close();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// Delete category
	public boolean deleteCategory(CategoryModel categoryModel) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.getTransaction();
			t.begin();
			session.delete(categoryModel);
			t.commit();
			session.close();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// Get single category
	public CategoryModel getSingleCategory(int id) {
		return sessionFactory.openSession().get(CategoryModel.class, id);
	}

	// Get all categories
	public List<CategoryModel> getAllCategory() {
		return sessionFactory.openSession().createQuery("FROM CategoryModel").getResultList();
	}

	// Get all active categories
	public List<CategoryModel> getAllActiveCategory() {
		String queryString = "FROM CategoryModel WHERE is_active = :isActive";

		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setParameter("isActive", true);

		return query.getResultList();
	}
}
