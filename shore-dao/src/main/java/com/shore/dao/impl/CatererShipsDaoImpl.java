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
import com.shore.dao.vo.CatererShips;

@Repository
public class CatererShipsDaoImpl extends BaseDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(CatererShipsDaoImpl.class);

  @Transactional(readOnly = true)
  public CatererShips findById(java.lang.Integer id) {
    LOGGER.debug("getting CatererShips instance with id: " + id);
    try {
      CatererShips instance = (CatererShips) getHibernateTemplate().get("com.ship.dao.vo.CatererShips", id);
      return instance;
    } catch (RuntimeException re) {
      LOGGER.error("get failed", re);
      throw re;
    }
  }

  @Transactional(readOnly = true)
  public List<CatererShips> getAll() {
    LOGGER.debug("getting all CatererClients");
    try {
      DetachedCriteria criteria = DetachedCriteria.forClass(CatererShips.class);
      criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

      Order orderBy = Order.asc("id");
      criteria.addOrder(orderBy);

      @SuppressWarnings("unchecked")
      List<CatererShips> instance = (List<CatererShips>) getHibernateTemplate().findByCriteria(criteria);
      return instance;
    } catch (RuntimeException re) {
      LOGGER.error("get failed", re);
      throw re;
    }
  }
}
