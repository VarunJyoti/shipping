package com.shore.dao.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "suppliers")
public class Suppliers extends BasicContactInfo implements java.io.Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "caterer_id")
  private Integer catererId;

  @Column(name = "code")
  private String suplierCode;

  @Transient
  private Caterers caterers;

  public Integer getCatererId() {
    return catererId;
  }

  public void setCatererId(Integer catererId) {
    this.catererId = catererId;
  }

  public String getSuplierCode() {
    return suplierCode;
  }

  public void setSuplierCode(String suplierCode) {
    this.suplierCode = suplierCode;
  }

  public Caterers getCaterers() {
    return caterers;
  }

  public void setCaterers(Caterers caterers) {
    this.caterers = caterers;
  }

}
