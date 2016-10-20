package com.shore.dao.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_order_extra_items")
public class SupplierOrderExtraItems extends BaseOrderExtraItem implements Serializable {
  private static final long serialVersionUID = 1L;


  @Embeddable
  public static class SupplierOrderExtraItemsId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "item_name")
    private String name;
    @Column(name = "supplier_id")
    private Integer supplierId;

    public SupplierOrderExtraItemsId() {
    }

    public SupplierOrderExtraItemsId(String orderId, String name, Integer supplierId) {
      this.orderId = orderId;
      this.name = name;
      this.supplierId = supplierId;
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
  private SupplierOrderExtraItemsId supplierOrderExtraItemsId;

  public SupplierOrderExtraItemsId getSupplierOrderExtraItemsId() {
    return supplierOrderExtraItemsId;
  }

  public void setSupplierOrderExtraItemsId(SupplierOrderExtraItemsId supplierOrderExtraItemsId) {
    this.supplierOrderExtraItemsId = supplierOrderExtraItemsId;
  }

}
