package com.shore.dao.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cities")
public class Cities implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "country_id")
  private Integer countryId;

  @Transient
  private Countries countries;

  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "cityId", fetch = FetchType.EAGER)
  private Set<Ports> ports = new HashSet<Ports>(0);

  @Transient
  private Set<Suppliers> supplierses = new HashSet<Suppliers>(0);

  @Transient
  private Set<Orders> orderses = new HashSet<Orders>(0);

  public Cities() {
  }

  public Cities(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Cities(Integer id, Countries countries, String name, Set<Suppliers> supplierses, Set<Ports> portses, Set<Orders> orderses) {
    this.id = id;
    this.countries = countries;
    this.name = name;
    this.supplierses = supplierses;
    this.ports = portses;
    this.orderses = orderses;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Countries getCountries() {
    return this.countries;
  }

  public void setCountries(Countries countries) {
    this.countries = countries;
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

  public Set<Ports> getPorts() {
    return this.ports;
  }

  public void setPortses(Set<Ports> ports) {
    this.ports = ports;
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

}
