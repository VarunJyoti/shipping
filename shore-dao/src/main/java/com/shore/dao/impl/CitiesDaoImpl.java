package com.shore.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shore.dao.BaseDao;
import com.shore.dao.vo.Cities;
import com.shore.dao.vo.Countries;

/**
 * @author harpreet.billing
 * @since Oct 10, 2016
 */
@Repository
public class CitiesDaoImpl extends BaseDao{
  private static final Logger LOGGER = LoggerFactory.getLogger(CitiesDaoImpl.class);
	
	@Transactional(readOnly = true)
	public Cities findById(java.lang.Integer id) {
		LOGGER.debug("getting Cities instance with id: " + id);
		try {
			Cities instance = (Cities) getHibernateTemplate().get(
          "com.shore.dao.vo.Cities", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
	@Transactional(readOnly = true)
	public List<Cities> getAllByCountry(Countries country) {
		LOGGER.debug("getting all Cities");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Cities.class);
			
			Criterion byCategory=Restrictions.eq("countryId", country.getId());
			criteria.add(byCategory);
			
			@SuppressWarnings("unchecked")
			List<Cities> instance =  (List<Cities>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	

}
