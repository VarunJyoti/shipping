package com.shore.dao.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItems extends BaseOrderItem implements java.io.Serializable {
  private static final long serialVersionUID = 1L;

  @Embeddable
  public static class OrderItemsId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "item_id")
    private Integer itemId;

    public OrderItemsId() {
    }

    public OrderItemsId(String orderId, Integer itemId) {
      super();
      this.orderId = orderId;
      this.itemId = itemId;
    }

    public Integer getItemId() {
      return this.itemId;
    }

    public String getOrderId() {
      return orderId;
    }

    public void setOrderId(String orderId) {
      this.orderId = orderId;
    }

    public void setItemId(Integer itemId) {
      this.itemId = itemId;
    }
  }

  @EmbeddedId
  private OrderItemsId orderItemsId;

  public OrderItems() {
  }

  public OrderItems(String orderId, Integer itemId) {
    this.orderId = orderId;
    this.itemId = itemId;
  }

  public OrderItemsId getOrderItemsId() {
    return orderItemsId;
  }

  public void setOrderItemsId(OrderItemsId orderItemsId) {
    this.orderItemsId = orderItemsId;
  }

}
