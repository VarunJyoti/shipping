package com.shore.dao.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@MappedSuperclass
public abstract class BaseOrder {

  protected static final long serialVersionUID = 1L;

  @Column(name = "order_number")
  protected String orderNumber;

  @Column(name = "country_id")
  protected Integer countryId;
  @Column(name = "city_id")
  protected Integer cityId;
  @Column(name = "port_id")
  protected Integer portId;

  @Formula("(select c.name from countries c where country_id=c.id)")
  protected String countryName;

  @Formula("(select c.name from cities c where city_id=c.id)")
  protected String cityName;

  @Formula("(select p.name from ports p where port_id=p.id)")
  protected String portName;

  @Transient
  protected Countries country;
  @Transient
  protected Cities city;
  @Transient
  protected Ports port;

  @Column(name = "ship_id")
  protected Integer shipId;
  @Transient
  protected CatererShips ship;

  @Column(name = "caterer_id")
  protected Integer catererId;

  @Transient
  protected Caterers caterer;

  @Column(name = "client_id")
  protected Integer clientId;

  @Transient
  protected CatererClients client;

  @Column(name = "created_on")
  protected Date createdOn;
  @Column(name = "modified_on")
  protected Date modifiedOn;
  @Column(name = "expected_delivery_date")
  protected Date expectedDeliveryDate;
  @Column(name = "delivered_on")
  protected Date deliveredOn;
  @Column(name = "ship_comments")
  protected String shipComments;
  @Column(name = "caterer_comments")
  protected String catererComments;
  @Column(name = "supplier_comments")
  protected String supplierComments;
  @Column(name = "delivery_comments")
  protected String deliveryComments;
  @Column(name = "rejection_comments")
  protected String rejectionComments;

  @ManyToOne
  @JoinColumn(name = "status", insertable = false, updatable = false)
  protected OrderStatus status;

  @Column(name = "status")
  protected Integer statusId;

}
