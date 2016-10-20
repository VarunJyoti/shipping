package com.shore.dao.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders extends BaseOrder implements java.io.Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private String id;

  @ManyToOne
  @JoinColumn(name = "delivery_supplier", insertable = false, updatable = false)
  private Suppliers deliverySupplier;
  @ManyToOne
  @JoinColumn(name = "preffered_supplier", insertable = false, updatable = false)
  private Suppliers prefferedSupplier;

  @Column(name = "preffered_supplier")
  private Integer prefferedSupplierId;
  @Column(name = "delivery_supplier")
  private Integer deliverySupplierId;

  @OneToMany(mappedBy = "orderExtraItemsId.orderId", fetch = FetchType.EAGER)
  @OrderBy("orderExtraItemsId.name asc")
  private Set<OrderExtraItems> orderExtraItemses = new HashSet<OrderExtraItems>(0);

  @OneToMany(mappedBy = "orderHistoryId.orderId", fetch = FetchType.EAGER)
  @OrderBy("orderHistoryId.eventDate desc")
  private Set<OrderHistory> orderHistories = new HashSet<OrderHistory>(0);

  @OneToMany(mappedBy = "orderItemsId.orderId", fetch = FetchType.EAGER)
  @OrderBy("categoryId, subCategoryId, orderItemsId.itemId asc")
  private Set<OrderItems> orderItemses = new HashSet<OrderItems>(0);

  public Orders() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Suppliers getDeliverySupplier() {
    return this.deliverySupplier;
  }

  public void setDeliverySupplier(Suppliers deliverySupplier) {
    this.deliverySupplier = deliverySupplier;
  }

  public Suppliers getPrefferedSupplier() {
    return this.prefferedSupplier;
  }

  public void setPrefferedSupplier(Suppliers prefferedSupplier) {
    this.prefferedSupplier = prefferedSupplier;
  }

  public Set<OrderExtraItems> getOrderExtraItemses() {
    return this.orderExtraItemses;
  }

  public void setOrderExtraItemses(Set<OrderExtraItems> orderExtraItemses) {
    this.orderExtraItemses = orderExtraItemses;
  }

  public Set<OrderHistory> getOrderHistories() {
    return this.orderHistories;
  }

  public void setOrderHistories(Set<OrderHistory> orderHistories) {
    this.orderHistories = orderHistories;
  }

  public Set<OrderItems> getOrderItemses() {
    return this.orderItemses;
  }

  public void setOrderItemses(Set<OrderItems> orderItemses) {
    this.orderItemses = orderItemses;
  }

  public Integer getPrefferedSupplierId() {
    if (this.prefferedSupplierId != null && this.prefferedSupplierId == 0) {
      this.prefferedSupplierId = null;
    }
    return prefferedSupplierId;
  }

  public void setPrefferedSupplierId(Integer prefferedSupplierId) {
    this.prefferedSupplierId = prefferedSupplierId;
  }

  public Integer getDeliverySupplierId() {
    return deliverySupplierId;
  }

  public void setDeliverySupplierId(Integer deliverySupplierId) {
    this.deliverySupplierId = deliverySupplierId;
  }

}
