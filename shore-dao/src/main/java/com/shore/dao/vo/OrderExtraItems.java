package com.shore.dao.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_extra_items")
public class OrderExtraItems extends BaseOrderExtraItem implements java.io.Serializable {
  private static final long serialVersionUID = 1L;

  @Embeddable
  public static class OrderExtraItemsId implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "item_name")
    private String name;

    public OrderExtraItemsId() {
    }

    public OrderExtraItemsId(String orderId, String name) {
      this.orderId = orderId;
      this.name = name;
    }

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
  }

  @EmbeddedId
  OrderExtraItemsId orderExtraItemsId;

  public OrderExtraItems() {
  }

  public OrderExtraItems(String orderId) {
    this.orderId = orderId;
  }

  public OrderExtraItemsId getOrderExtraItemsId() {
    return orderExtraItemsId;
  }

  public void setOrderExtraItemsId(OrderExtraItemsId orderExtraItemsId) {
    this.orderExtraItemsId = orderExtraItemsId;
  }
}
