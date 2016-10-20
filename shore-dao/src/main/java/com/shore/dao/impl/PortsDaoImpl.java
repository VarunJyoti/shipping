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
import com.shore.dao.vo.Ports;

/**
 * @author harpreet.billing
 * @since Oct 10, 2016
 */
@Repository
public class PortsDaoImpl extends BaseDao{
  private static final Logger LOGGER = LoggerFactory.getLogger(PortsDaoImpl.class);
	
	@Transactional(readOnly = true)
	public Ports findById(java.lang.Integer id) {
		LOGGER.debug("getting Ports instance with id: " + id);
		try {
			Ports instance = (Ports) getHibernateTemplate().get(
          "com.shore.dao.vo.Ports", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
	
	@Transactional(readOnly = true)
	public List<Ports> getAllByCity(Cities city) {
		LOGGER.debug("getting all Ports");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Ports.class);
			
			Criterion byCategory=Restrictions.eq("cityId", city.getId());
			criteria.add(byCategory);
			
			@SuppressWarnings("unchecked")
			List<Ports> instance =  (List<Ports>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}


}
