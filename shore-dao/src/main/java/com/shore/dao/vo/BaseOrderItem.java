package com.shore.dao.vo;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@MappedSuperclass
public abstract class BaseOrderItem {

  @ManyToOne
  @JoinColumn(name = "item_id", insertable = false, updatable = false)
  protected CategoriesItems item;

  @Transient
  protected String orderId;
  @Transient
  protected Integer itemId;

  @Column(name = "category_id")
  protected Integer categoryId;
  @Column(name = "subcategory_id")
  protected Integer subCategoryId;
  @Formula("(select c.name from categories c where category_id=c.id)")
  protected String categoryName;
  @Formula("(select c.name from sub_categories c where subcategory_id=c.id)")
  protected String subCategoryName;

  @Column(name = "seq_number")
  protected Integer seqNumber;
  @Column(name = "order_units")
  protected Float orderUnits;
  @Column(name = "qouted_units")
  protected Float qoutedUnits;
  @Column(name = "unit_price")
  protected Float unitPrice;
  @Column(name = "ship_comments")
  protected String shipComments;
  @Column(name = "caterer_comments")
  protected String catererComments;
  @Column(name = "supplier_comments")
  protected String supplierComments;

  public CategoriesItems getItem() {
    return item;
  }

  public void setItem(CategoriesItems item) {
    this.item = item;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getSubCategoryId() {
    return subCategoryId;
  }

  public void setSubCategoryId(Integer subCategoryId) {
    this.subCategoryId = subCategoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getSubCategoryName() {
    return subCategoryName;
  }

  public void setSubCategoryName(String subCategoryName) {
    this.subCategoryName = subCategoryName;
  }

  public Integer getSeqNumber() {
    return seqNumber;
  }

  public void setSeqNumber(Integer seqNumber) {
    this.seqNumber = seqNumber;
  }

  public Float getOrderUnits() {
    return orderUnits;
  }

  public void setOrderUnits(Float orderUnits) {
    this.orderUnits = orderUnits;
  }

  public Float getQoutedUnits() {
    return qoutedUnits;
  }

  public void setQoutedUnits(Float qoutedUnits) {
    this.qoutedUnits = qoutedUnits;
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
