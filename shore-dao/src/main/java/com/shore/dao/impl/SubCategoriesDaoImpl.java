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
import com.shore.dao.vo.Categories;
import com.shore.dao.vo.SubCategories;

/**
 * @author harpreet.billing
 * @since Oct 10, 2016
 */
@Repository
public class SubCategoriesDaoImpl extends BaseDao{
  private static final Logger LOGGER = LoggerFactory.getLogger(SubCategoriesDaoImpl.class);
	
	@Transactional(readOnly = true)
	public SubCategories findById(java.lang.Integer id) {
		LOGGER.debug("getting SubCategories instance with id: " + id);
		try {
			SubCategories instance = (SubCategories) getHibernateTemplate().get(
          "com.shore.dao.vo.SubCategories", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
	@Transactional(readOnly = true)
	public List<SubCategories> getAllByCategory(Categories category) {
		LOGGER.debug("getting all Categories");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(SubCategories.class);
			
			Criterion byCategory=Restrictions.eq("categoryId", category.getId());
			criteria.add(byCategory);
			
			@SuppressWarnings("unchecked")
			List<SubCategories> instance =  (List<SubCategories>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	

}
