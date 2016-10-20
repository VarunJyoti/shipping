package com.shore.dao.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "supplier_orders")
public class SupplierOrders extends BaseOrder implements Serializable {
  private static final long serialVersionUID = 1L;

  @Embeddable
  public static class SupplierOrderId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "supplier_id")
    private Integer suppierId;

    public SupplierOrderId() {
    }

    public SupplierOrderId(String orderId, Integer suppierId) {
      super();
      this.orderId = orderId;
      this.suppierId = suppierId;
    }

    public String getOrderId() {
      return orderId;
    }

    public void setOrderId(String orderId) {
      this.orderId = orderId;
    }

    public Integer getSuppierId() {
      return suppierId;
    }

    public void setSuppierId(Integer suppierId) {
      this.suppierId = suppierId;
    }
  }

  @EmbeddedId
  private SupplierOrderId supplierOrderId;

  @Transient
  // @OneToMany(mappedBy = "supplierOrderExtraItemsId.orderId", fetch = FetchType.EAGER)
  // @OrderBy("supplierOrderExtraItemsId.name asc")
  private Set<SupplierOrderExtraItems> supplierOrderExtraItemses = new HashSet<SupplierOrderExtraItems>(0);

  @Transient
  // @OneToMany(mappedBy = "supplierOrderHistoryId.orderId", fetch = FetchType.EAGER)
  // @OrderBy("supplierOrderHistoryId.eventDate desc")
  private Set<SupplierOrderHistory> supplierOrderHistories = new HashSet<SupplierOrderHistory>(0);

  @Transient
  // @OneToMany(mappedBy = "supplierOrderItemsId.orderId", fetch = FetchType.EAGER)
  // @OrderBy("categoryId, subCategoryId, supplierOrderItemsId.itemId asc")
  private Set<SupplierOrderItems> supplierOrderItemses = new HashSet<SupplierOrderItems>(0);

  public SupplierOrderId getSupplierOrderId() {
    return supplierOrderId;
  }

  public void setSupplierOrderId(SupplierOrderId supplierOrderId) {
    this.supplierOrderId = supplierOrderId;
  }

}
