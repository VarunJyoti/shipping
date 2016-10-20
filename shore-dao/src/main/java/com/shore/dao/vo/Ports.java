package com.shore.dao.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ports")
public class Ports implements java.io.Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "country_id")
  private Integer countryId;

  @Column(name = "city_id")
  private Integer cityId;

  @Transient
  private Countries country;
  @Transient
  private Cities city;

  @Column(name = "name")
  private String name;

  @Transient
  private Set<Suppliers> supplierses = new HashSet<Suppliers>(0);
  @Transient
  private Set<Orders> orderses = new HashSet<Orders>(0);

  public Ports() {
  }

  public Ports(Integer id, Countries country, Cities city) {
    this.id = id;
    this.country = country;
    this.city = city;
  }

  public Ports(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Ports(Integer id, Countries country, Cities city, String name, Set<Suppliers> supplierses, Set<Orders> orderses) {
    this.id = id;
    this.country = country;
    this.city = city;
    this.name = name;
    this.supplierses = supplierses;
    this.orderses = orderses;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Countries getCountry() {
    return this.country;
  }

  public void setCountry(Countries country) {
    this.country = country;
  }

  public Cities getCity() {
    return this.city;
  }

  public void setCity(Cities city) {
    this.city = city;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Suppliers> getSupplierses() {
    return this.supplierses;
  }

  public void setSupplierses(Set<Suppliers> supplierses) {
    this.supplierses = supplierses;
  }

  public Set<Orders> getOrderses() {
    return this.orderses;
  }

  public void setOrderses(Set<Orders> orderses) {
    this.orderses = orderses;
  }

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

}
