package com.shore.dao.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class Users implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "phone")
  private String phone;

  @Column(name = "type")
  private String type;

  @Column(name = "country_id")
  private Integer countryId;

  @Column(name = "caterer_id")
  private Integer catererId;

  @Column(name = "supplier_id")
  private Integer supplierId;

  @Column(name = "status")
  private String status;

  @Transient
  protected Countries country;

  @Transient
  protected Caterers caterer;

  @Transient
  protected Suppliers suppliers;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
  }

  public Integer getCatererId() {
    return catererId;
  }

  public void setCatererId(Integer catererId) {
    this.catererId = catererId;
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Countries getCountry() {
    return country;
  }

  public void setCountry(Countries country) {
    this.country = country;
  }

  public Caterers getCaterer() {
    return caterer;
  }

  public void setCaterer(Caterers caterer) {
    this.caterer = caterer;
  }

  public Suppliers getSuppliers() {
    return suppliers;
  }

  public void setSuppliers(Suppliers suppliers) {
    this.suppliers = suppliers;
  }

}
