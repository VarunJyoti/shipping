package com.shore.dao.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BasicContactInfo {

  @Id
  @Column(name = "id")
  protected Integer id;

  @Column(name = "name")
  protected String name;

  @Column(name = "email")
  protected String email;

  @Column(name = "phone1")
  protected String phone1;

  @Column(name = "phone2")
  protected String phone2;

  @Column(name = "address1")
  protected String address1;

  @Column(name = "address2")
  protected String address2;

  @Column(name = "city")
  protected String city;

  @Column(name = "country_id")
  protected Integer countryId;

  @Column(name = "pin")
  protected String pin;

  @Column(name = "added_on")
  protected Date addedOn;

  @Column(name = "status")
  protected String status;

  @Transient
  private Countries countries;

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

  public String getPhone1() {
    return phone1;
  }

  public void setPhone1(String phone1) {
    this.phone1 = phone1;
  }

  public String getPhone2() {
    return phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public Date getAddedOn() {
    return addedOn;
  }

  public void setAddedOn(Date addedOn) {
    this.addedOn = addedOn;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Countries getCountries() {
    return countries;
  }

  public void setCountries(Countries countries) {
    this.countries = countries;
  }

}
