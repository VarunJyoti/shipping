package com.shore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shore.dao.BaseDao;
import com.shore.dao.vo.Suppliers;

/**
 * @author harpreet.billing
 * @since Oct 10, 2016
 */
@Repository
public class SuppliersDaoImpl extends BaseDao{
  private static final Logger LOGGER = LoggerFactory.getLogger(SuppliersDaoImpl.class);
	

	@Transactional(readOnly = true)
	public Suppliers findById(java.lang.Integer id) {
		LOGGER.debug("getting Suppliers instance with id: " + id);
		try {
			Suppliers instance = (Suppliers) getHibernateTemplate().get(
          "com.shore.dao.vo.Suppliers", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	
	@Transactional(readOnly = true)
	public List<Suppliers> getAll() {
		LOGGER.debug("getting all Suppliers");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Suppliers.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			@SuppressWarnings("unchecked")
			List<Suppliers> instance =  (List<Suppliers>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	
	@Transactional(readOnly = true)
	public List<Suppliers> getByPort(Integer portId) {
		LOGGER.debug("getting all Suppliers");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Suppliers.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			Criterion port_search=Restrictions.eq("portId", portId);
			criteria.add(port_search);
			
			@SuppressWarnings("unchecked")
			List<Suppliers> instance =  (List<Suppliers>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
}
