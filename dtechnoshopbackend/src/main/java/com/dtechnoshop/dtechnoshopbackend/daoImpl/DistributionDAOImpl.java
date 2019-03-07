package com.dtechnoshop.dtechnoshopbackend.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dtechnoshop.dtechnoshopbackend.dao.DistributionDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.DistributionModel;

@Repository("distributionDAO")
public class DistributionDAOImpl implements DistributionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addDistribution(DistributionModel distribution) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(distribution);
			session.getTransaction().commit();
			session.close();
			
			return true;
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public List<DistributionModel> getAllDistribution() {
		return sessionFactory.openSession().createQuery("FROM DistributionModel ORDER BY orderDate DESC").getResultList();
	}

}
