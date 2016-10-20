package com.shore.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shore.dao.vo.OrderStatus;

/**
 * @author harpreet.billing
 * @since Oct 10, 2016
 */
@Repository
public class OrderStatusDaoImpl extends com.shore.dao.BaseDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderStatusDaoImpl.class);
	
	@Transactional(readOnly = true)
	public OrderStatus findById(java.lang.Integer id) {
		LOGGER.debug("getting OrderStatus instance with id: " + id);
		try {
			OrderStatus instance = (OrderStatus) getHibernateTemplate().get(
          "com.shore.dao.vo.OrderStatus", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
}
