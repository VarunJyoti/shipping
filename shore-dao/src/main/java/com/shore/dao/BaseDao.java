package com.shore.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author harpreet.billing
 */
public abstract class BaseDao extends HibernateDaoSupport {
  private static final Logger LOGGER = LoggerFactory.getLogger(BaseDao.class);
	
	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}

	@Transactional(readOnly = true)
	public <T>  List<T> findByExample(T persistentObject) {
		LOGGER.debug("finding instance by example");
		try {
			List<T> results = getHibernateTemplate().findByExample(persistentObject);
			LOGGER.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			LOGGER.error("find by example failed", re);
			throw re;
		}
	}

	@Transactional
	public <T> void save(T transientInstance) {
		LOGGER.debug("saving instance");
		try {
			getHibernateTemplate().save(transientInstance);
			LOGGER.debug("save successful");
		} catch (RuntimeException re) {
			LOGGER.error("save failed. "+ re.getMessage());
			throw re;
		}
	}
	@Transactional
	public <T> void saveOrUpdate(T transientInstance) {
		LOGGER.debug("saving instance");
		try {
			getHibernateTemplate().saveOrUpdate(transientInstance);
			LOGGER.debug("save/update successful");
		} catch (RuntimeException re) {
			LOGGER.error("save/update failed. "+ re.getMessage());
			throw re;
		}
	}
	@Transactional
	public <T> void delete(T persistentInstance) {
		LOGGER.debug("deleting instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			LOGGER.debug("delete successful");
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}

	
	@Transactional
	public <T> void deleteAll(Collection <T> persistentInstances) {
		LOGGER.debug("deleting instance");
		try {
			
				getHibernateTemplate().delete(persistentInstances);
				LOGGER.debug("delete successful");
			
			
		} catch (RuntimeException re) {
			LOGGER.error("delete failed", re);
			throw re;
		}
	}



}
