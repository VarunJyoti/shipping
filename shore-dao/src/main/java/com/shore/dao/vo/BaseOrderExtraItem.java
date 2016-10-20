package com.shore.dao.vo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BaseOrderExtraItem {

  @Transient
  protected String orderId;
  @Transient
  protected String name;
  @Column(name = "ordered_units")
  protected Float orderedUnits;
  @Column(name = "quoted_units")
  protected Float quotedUnits;
  @Column(name = "measurement_id")
  protected String measurementId;
  @Column(name = "unit_price")
  protected Float unitPrice;
  @Column(name = "ship_comments")
  protected String shipComments;
  @Column(name = "caterer_comments")
  protected String catererComments;
  @Column(name = "supplier_comments")
  protected String supplierComments;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getOrderedUnits() {
    return orderedUnits;
  }

  public void setOrderedUnits(Float orderedUnits) {
    this.orderedUnits = orderedUnits;
  }

  public Float getQuotedUnits() {
    return quotedUnits;
  }

  public void setQuotedUnits(Float quotedUnits) {
    this.quotedUnits = quotedUnits;
  }

  public String getMeasurementId() {
    return measurementId;
  }

  public void setMeasurementId(String measurementId) {
    this.measurementId = measurementId;
  }

  public Float getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Float unitPrice) {
    this.unitPrice = unitPrice;
  }

  public String getShipComments() {
    return shipComments;
  }

  public void setShipComments(String shipComments) {
    this.shipComments = shipComments;
  }

  public String getCatererComments() {
    return catererComments;
  }

  public void setCatererComments(String catererComments) {
    this.catererComments = catererComments;
  }

  public String getSupplierComments() {
    return supplierComments;
  }

  public void setSupplierComments(String supplierComments) {
    this.supplierComments = supplierComments;
  }

}
