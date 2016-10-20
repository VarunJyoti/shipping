package com.shore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shore.dao.BaseDao;
import com.shore.dao.vo.Countries;

/**
 * @author harpreet.billing
 * @since Oct 10, 2016
 */
@Repository
public class CountriesDaoImpl extends BaseDao{
  private static final Logger LOGGER = LoggerFactory.getLogger(CountriesDaoImpl.class);
	
	@Transactional(readOnly = true)
	public Countries findById(java.lang.Integer id) {
		LOGGER.debug("getting Countries instance with id: " + id);
		try {
			Countries instance = (Countries) getHibernateTemplate().get(
          "com.shore.dao.vo.Countries", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	
	@Transactional(readOnly = true)
	public List<Countries> getAll() {
		LOGGER.debug("getting all Countries");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Countries.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			@SuppressWarnings("unchecked")
			List<Countries> instance =  (List<Countries>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
}
