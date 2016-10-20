package com.shore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shore.dao.BaseDao;
import com.shore.dao.vo.Categories;

/**
 * @author harpreet.billing
 * @since Oct 10, 2016
 */
@Repository
public class CategoriesDaoImpl extends BaseDao{
  private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesDaoImpl.class);
	
	@Transactional(readOnly = true)
	public Categories findById(java.lang.Integer id) {
		LOGGER.debug("getting Categories instance with id: " + id);
		try {
			Categories instance = (Categories) getHibernateTemplate().get(
					"com.ship.dao.vo.Categories", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	
	@Transactional(readOnly = true)
	public List<Categories> getAll() {
		LOGGER.debug("getting all Categories");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Categories.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			Order orderBy=Order.asc("id");
			criteria.addOrder(orderBy);
			
			@SuppressWarnings("unchecked")
			List<Categories> instance =  (List<Categories>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
}
