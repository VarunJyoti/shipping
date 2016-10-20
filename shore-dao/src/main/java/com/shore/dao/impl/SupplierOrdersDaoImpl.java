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
import com.shore.dao.vo.SupplierOrders;

@Repository
public class SupplierOrdersDaoImpl extends BaseDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(SupplierOrdersDaoImpl.class);

  @Transactional(readOnly = true)
  public SupplierOrders findById(java.lang.Integer id) {
    LOGGER.debug("getting SupplierOrders instance with id: " + id);
    try {
      SupplierOrders instance = (SupplierOrders) getHibernateTemplate().get("com.ship.dao.vo.SupplierOrders", id);
      return instance;
    } catch (RuntimeException re) {
      LOGGER.error("get failed", re);
      throw re;
    }
  }

  @Transactional(readOnly = true)
  public List<SupplierOrders> getAll() {
    LOGGER.debug("getting all CatererClients");
    try {
      DetachedCriteria criteria = DetachedCriteria.forClass(SupplierOrders.class);
      criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

      Order orderBy = Order.asc("id");
      criteria.addOrder(orderBy);

      @SuppressWarnings("unchecked")
      List<SupplierOrders> instance = (List<SupplierOrders>) getHibernateTemplate().findByCriteria(criteria);
      return instance;
    } catch (RuntimeException re) {
      LOGGER.error("get failed", re);
      throw re;
    }
  }
}
