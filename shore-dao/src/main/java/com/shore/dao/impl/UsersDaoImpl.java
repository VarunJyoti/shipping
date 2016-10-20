package com.shore.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shore.dao.BaseDao;
import com.shore.dao.vo.Users;

/**
 * @author harpreet.billing
 * @since Oct 10, 2016
 */
@Repository
public class UsersDaoImpl extends BaseDao{
  private static final Logger LOGGER = LoggerFactory.getLogger(UsersDaoImpl.class);
	
	@Transactional(readOnly = true)
	public Users findById(java.lang.Integer id) {
		LOGGER.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) getHibernateTemplate().get(
          "com.shore.dao.vo.Users", id);
			return instance;
		} catch (RuntimeException re) {
			LOGGER.error("get failed", re);
			throw re;
		}
	}

}
