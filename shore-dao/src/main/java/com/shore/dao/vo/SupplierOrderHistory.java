package com.shore.dao.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_order_history")
public class SupplierOrderHistory extends BaseOrderHistory implements Serializable {
  private static final long serialVersionUID = 1L;

  @Embeddable
  public static class SupplierOrderHistoryId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "event_date")
    private Date eventDate;
    @Column(name = "supplier_id")
    private Integer supplierId;

    public SupplierOrderHistoryId() {
    }

    public SupplierOrderHistoryId(String orderId, Date eventDate, Integer supplierId) {
      super();
      this.orderId = orderId;
      this.eventDate = eventDate;
      this.supplierId = supplierId;
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
  private SupplierOrderHistoryId supplierOrderHistoryId;

  public SupplierOrderHistoryId getSupplierOrderHistoryId() {
    return supplierOrderHistoryId;
  }

  public void setSupplierOrderHistoryId(SupplierOrderHistoryId supplierOrderHistoryId) {
    this.supplierOrderHistoryId = supplierOrderHistoryId;
  }

}
