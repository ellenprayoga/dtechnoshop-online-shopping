package com.dtechnoshop.dtechnoshopbackend.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtechnoshop.dtechnoshopbackend.dao.ProvinceCitySubdistrictDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.ProvinceCitySubdistrictModel;

@Repository("provinceCitySubdistrictDAO")
public class ProvinceCitySubdistrictDAOImpl implements ProvinceCitySubdistrictDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	// Add province, city and subdistrict
	public boolean addProvinceCitySubdistrict(ProvinceCitySubdistrictModel model) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(model);
			session.getTransaction().commit();
			session.close();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Update province, city and subdistrict
	public boolean updateProvinceCitySubdistrict(ProvinceCitySubdistrictModel model) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(model);
			session.getTransaction().commit();
			session.close();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Delete province, city and subdistrict
	public boolean deleteProvinceCitySubdistrict(ProvinceCitySubdistrictModel model) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(model);
			session.getTransaction().commit();
			session.close();

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	// Get all provinces, cities and subdistricts
	public List<ProvinceCitySubdistrictModel> getProvinceCitySubdistrict() {
		return sessionFactory.openSession().createQuery("FROM ProvinceCitySubdistrictModel").getResultList();
	}

	
	// Get all provinces
	public List<String> getAllProvince() {
		String queryString = "SELECT distinct province FROM ProvinceCitySubdistrictModel";

		Query query = sessionFactory.openSession().createQuery(queryString);
		return query.getResultList();
	}

	
	// Get all cities
	public List<String> getAllCity(String province) {
		String queryString = "SELECT distinct city FROM ProvinceCitySubdistrictModel WHERE province = :province";

		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setParameter("province", province);

		return query.getResultList();
	}

	
	// Get all subdistricts
	public List<String> getAllSubdistrict(String city) {
		String queryString = "SELECT distinct subdistrict FROM ProvinceCitySubdistrictModel WHERE city = :city";

		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setParameter("city", city);

		return query.getResultList();
	}
}
