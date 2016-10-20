package com.shore.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shore.common.OrderStatuses;
import com.shore.dao.BaseDao;
import com.shore.dao.vo.Orders;

/**
 * @author harpreet.billing
 * @since Oct 10, 2016
 */
@Repository
public class OrdersDaoImpl extends BaseDao{
  private static final Logger LOGGER = LoggerFactory.getLogger(OrdersDaoImpl.class);
	
	@Transactional(readOnly = true)
	public Orders findById(java.lang.String id) {
		LOGGER.debug("getting Orders instance with id: " + id);
		try {
			Orders instance = (Orders) getHibernateTemplate().get(
          "com.shore.dao.vo.Orders", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	@Transactional(readOnly = true)
	public List<Orders> getAll() {
		LOGGER.debug("getting all Orders");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Orders.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			Order orderBy=Order.desc("modifiedOn");
			criteria.addOrder(orderBy);
			
			@SuppressWarnings("unchecked")
			List<Orders> instance =  (List<Orders>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
	@Transactional(readOnly = true)
	public List<Orders> getOrdersFromDate(Date date) {
		LOGGER.debug("getting all Orders");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Orders.class);
			criteria.setProjection(Projections.distinct(
				    Projections.projectionList()
				      .add(Projections.id())
				      .add(Projections.property("modifiedOn"))
				      .add(Projections.property("status"))
				      .add(Projections.property("orderNumber"))
				      .add(Projections.property("portName"))
				      .add(Projections.property("expectedDeliveryDate"))
				      .add(Projections.property("deliveredOn"))
				      
				  ));
			
			Criterion date_search=Restrictions.ge("createdOn", date);
			criteria.add(date_search);
			
			Order orderBy=Order.desc("modifiedOn");
			criteria.addOrder(orderBy);
			
			@SuppressWarnings("unchecked")
			List<Orders> instance =  (List<Orders>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
	
	@Transactional(readOnly = true)
	public List<Orders> getSentOrdersFromDate(Date date) {
		LOGGER.debug("getting all Orders");
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Orders.class);
			criteria.setProjection(Projections.distinct(
				    Projections.projectionList()
				      .add(Projections.id())
				      .add(Projections.property("modifiedOn"))
				      .add(Projections.property("status"))
				      .add(Projections.property("orderNumber"))
				      .add(Projections.property("portName"))
				      .add(Projections.property("expectedDeliveryDate"))
				      .add(Projections.property("deliveredOn"))
				      
				  ));
			
			Criterion date_search=Restrictions.ge("createdOn", date);
			criteria.add(date_search);
			
			Criterion status=Restrictions.ne("statusId", OrderStatuses.DRAFT);
			criteria.add(status);
			
			Order orderBy=Order.desc("modifiedOn");
			criteria.addOrder(orderBy);
			
			@SuppressWarnings("unchecked")
			List<Orders> instance =  (List<Orders>) getHibernateTemplate().findByCriteria(criteria);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
	
	
	public void deleteItemsByOrderId(java.lang.String id) {
		LOGGER.debug("Deleting OrdersItems by order id : " + id);
		try {
			String queryString = "delete from OrderItems where orderItemsId.orderId='"+id+"'";
			getHibernateTemplate().bulkUpdate(queryString);
			LOGGER.debug("Delete successfull. OrdersItems by order id :  " + id);
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

	public void deleteExtraItemsByOrderId(java.lang.String id) {
		LOGGER.debug("Deleting OrderExtraItems by order id : " + id);
		try {
			String queryString = "delete from OrderExtraItems where orderExtraItemsId.orderId='"+id+"'";
			getHibernateTemplate().bulkUpdate(queryString);
			LOGGER.debug("Delete successfull. OrderExtraItems by order id :  " + id);
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}
	
}
