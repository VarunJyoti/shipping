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
import com.shore.dao.vo.CategoriesItems;
import com.shore.dao.vo.SubCategories;

/**
 * @author harpreet.billing
 * @since Oct 10, 2016
 */
@Repository
public class CategoryItemsDaoImpl extends BaseDao{
  private static final Logger LOGGER = LoggerFactory.getLogger(CategoryItemsDaoImpl.class);
	
	@Transactional(readOnly = true)
	public CategoriesItems findById(java.lang.Integer id) {
		LOGGER.debug("getting CategoriesItems instance with id: " + id);
		try {
			CategoriesItems instance = (CategoriesItems) getHibernateTemplate().get(
          "com.shore.dao.vo.CategoriesItems", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
	
	@Transactional(readOnly = true)
	public List<CategoriesItems> getAllBySubCategory(SubCategories subCategory) {
		LOGGER.debug("getting all Categories");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(CategoriesItems.class);
			
			Criterion byCategory=Restrictions.eq("subCategoryId", subCategory.getId());
			criteria.add(byCategory);
			
			@SuppressWarnings("unchecked")
			List<CategoriesItems> instance =  (List<CategoriesItems>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}


}
