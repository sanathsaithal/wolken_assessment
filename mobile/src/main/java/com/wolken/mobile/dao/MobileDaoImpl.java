package com.wolken.mobile.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wolken.mobile.entity.MobileEntity;

@Component
public class MobileDaoImpl implements MobileDao {

	@Autowired
	SessionFactory factory;
	Session session = null;
	Logger logger = Logger.getLogger(MobileDaoImpl.class);

	public String save(MobileEntity entity) {
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return null;

	}

	public List getByBrand(String bName) {
		Session session = null;
		List<MobileEntity> list = null;
		try {
			session = factory.openSession();
			Query<MobileEntity> query = session.createNamedQuery("getByBrandName");
			query.setParameter("name", bName);
			list = query.list();

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return list;
	}

	public List getByPrice(int price) {
		Session session = null;
		List<MobileEntity> list = null;
		try {
			session = factory.openSession();
			Query<MobileEntity> query = session.createNamedQuery("getByPrice");
			query.setParameter("price", price);
			list = query.list();

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return list;
	}

	public MobileEntity updateAvailabilityByModelName(String modelName, Boolean availability) {
		Session session = null;

		MobileEntity entity = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Query<MobileEntity> query = session.createNamedQuery("updateAvailability");
			query.setParameter("availability", availability);
			query.setParameter("modelName", modelName);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return entity;
	}

	public MobileEntity updatePriceByModelNo(String modelNo, int price) {
		Session session = null;

		MobileEntity entity = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Query<MobileEntity> query = session.createNamedQuery("updatePrice");
			query.setParameter("price", price);
			query.setParameter("modelNo", modelNo);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			session.close();
		}
		return entity;
	}

}
