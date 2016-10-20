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
@Table(name = "countries")
public class Countries implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "code")
  private String countryCode;
  @Column(name = "name")
  private String name;

  @OneToMany(mappedBy = "countryId", fetch = FetchType.EAGER)
  private Set<Cities> cities = new HashSet<Cities>(0);
  @Transient
  private Set<Ports> portses = new HashSet<Ports>(0);
  @Transient
  private Set<Suppliers> supplierses = new HashSet<Suppliers>(0);

  public Countries() {
  }

  public Countries(Integer id) {
    this.id = id;
  }

  public Countries(Integer id, String countryCode, String name) {
    this.id = id;
    this.countryCode = countryCode;
    this.name = name;
  }

  public Countries(Integer id, String countryCode, String name, Set<Cities> citieses, Set<Ports> portses, Set<Suppliers> supplierses) {
    this.id = id;
    this.countryCode = countryCode;
    this.name = name;
    this.cities = citieses;
    this.portses = portses;
    this.supplierses = supplierses;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCountryCode() {
    return this.countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Cities> getCities() {
    return cities;
  }

  public void setCities(Set<Cities> cities) {
    this.cities = cities;
  }

  public Set<Ports> getPortses() {
    return this.portses;
  }

  public void setPortses(Set<Ports> portses) {
    this.portses = portses;
  }

  public Set<Suppliers> getSupplierses() {
    return this.supplierses;
  }

  public void setSupplierses(Set<Suppliers> supplierses) {
    this.supplierses = supplierses;
  }

}
