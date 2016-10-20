package com.shore.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_history")
public class OrderHistory extends BaseOrderHistory implements Serializable {
  private static final long serialVersionUID = 1L;

  @Embeddable
  public static class OrderHistoryId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "event_date")
    private Date eventDate;

    public OrderHistoryId() {
    }

    public OrderHistoryId(String orderId, Date eventDate) {
      super();
      this.orderId = orderId;
      this.eventDate = eventDate;
    }

    public String getOrderId() {
      return orderId;
    }

    public void setOrderId(String orderId) {
      this.orderId = orderId;
    }

    public Date getEventDate() {
      return eventDate;
    }

    public void setEventDate(Date eventDate) {
      this.eventDate = eventDate;
    }
  }

  @EmbeddedId
  private OrderHistoryId orderHistoryId;

  public OrderHistory() {
  }

  public OrderHistoryId getOrderHistoryId() {
    return orderHistoryId;
  }

  public void setOrderHistoryId(OrderHistoryId orderHistoryId) {
    this.orderHistoryId = orderHistoryId;
  }

}
