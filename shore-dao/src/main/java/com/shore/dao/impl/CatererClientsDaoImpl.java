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
import com.shore.dao.vo.CatererClients;

@Repository
public class CatererClientsDaoImpl extends BaseDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(CatererClientsDaoImpl.class);

  @Transactional(readOnly = true)
  public CatererClients findById(java.lang.Integer id) {
    LOGGER.debug("getting CatererClients instance with id: " + id);
    try {
      CatererClients instance = (CatererClients) getHibernateTemplate().get("com.ship.dao.vo.CatererClients", id);
      return instance;
    } catch (RuntimeException re) {
      LOGGER.error("get failed", re);
      throw re;
    }
  }

  @Transactional(readOnly = true)
  public List<CatererClients> getAll() {
    LOGGER.debug("getting all CatererClients");
    try {
      DetachedCriteria criteria = DetachedCriteria.forClass(CatererClients.class);
      criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

      Order orderBy = Order.asc("id");
      criteria.addOrder(orderBy);

      @SuppressWarnings("unchecked")
      List<CatererClients> instance = (List<CatererClients>) getHibernateTemplate().findByCriteria(criteria);
      return instance;
    } catch (RuntimeException re) {
      LOGGER.error("get failed", re);
      throw re;
    }
  }


}
