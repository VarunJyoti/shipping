package com.shore.dao.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_order_items")
public class SupplierOrderItems extends BaseOrderItem implements java.io.Serializable {
  private static final long serialVersionUID = 1L;

  @Embeddable
  public static class SupplierOrderItemsId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "supplier_id")
    private Integer supplierId;

    public SupplierOrderItemsId() {
    }

    public SupplierOrderItemsId(String orderId, Integer itemId, Integer supplierId) {
      super();
      this.orderId = orderId;
      this.itemId = itemId;
      this.supplierId = supplierId;
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
  private SupplierOrderItemsId supplierOrderItemsId;

  public SupplierOrderItemsId getSupplierOrderItemsId() {
    return supplierOrderItemsId;
  }

  public void setSupplierOrderItemsId(SupplierOrderItemsId supplierOrderItemsId) {
    this.supplierOrderItemsId = supplierOrderItemsId;
  }

}
