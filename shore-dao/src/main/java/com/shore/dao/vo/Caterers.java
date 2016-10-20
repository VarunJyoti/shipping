package com.shore.dao.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "caterers")
public class Caterers extends BasicContactInfo implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "code")
  private String catererCode;

  public String getCatererCode() {
    return catererCode;
  }

  public void setCatererCode(String catererCode) {
    this.catererCode = catererCode;
  }

}
