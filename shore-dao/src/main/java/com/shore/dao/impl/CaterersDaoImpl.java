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
import com.shore.dao.vo.Caterers;

@Repository
public class CaterersDaoImpl extends BaseDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(CaterersDaoImpl.class);

  @Transactional(readOnly = true)
  public Caterers findById(java.lang.Integer id) {
    LOGGER.debug("getting Caterers instance with id: " + id);
    try {
      Caterers instance = (Caterers) getHibernateTemplate().get("com.ship.dao.vo.Caterers", id);
      return instance;
    } catch (RuntimeException re) {
      LOGGER.error("get failed", re);
      throw re;
    }
  }

  @Transactional(readOnly = true)
  public List<Caterers> getAll() {
    LOGGER.debug("getting all Caterers");
    try {
      DetachedCriteria criteria = DetachedCriteria.forClass(Caterers.class);
      criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

      Order orderBy = Order.asc("id");
      criteria.addOrder(orderBy);

      @SuppressWarnings("unchecked")
      List<Caterers> instance = (List<Caterers>) getHibernateTemplate().findByCriteria(criteria);
      return instance;
    } catch (RuntimeException re) {
      LOGGER.error("get failed", re);
      throw re;
    }
  }
}