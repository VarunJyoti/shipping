package com.shore.dao.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "caterer_ships")
public class CatererShips implements java.io.Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "caterer_id")
  private Integer catererId;

  @Column(name = "caterer_client_id")
  private Integer catererClientId;

  @Column(name = "code")
  private String shipCode;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "added_on")
  private Date addedOn;

  @Column(name = "status")
  private String status;

  @Transient
  private Caterers caterers;

  @Transient
  private CatererClients catererClient;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCatererId() {
    return catererId;
  }

  public void setCatererId(Integer catererId) {
    this.catererId = catererId;
  }

  public Integer getCatererClientId() {
    return catererClientId;
  }

  public void setCatererClientId(Integer catererClientId) {
    this.catererClientId = catererClientId;
  }

  public String getShipCode() {
    return shipCode;
  }

  public void setShipCode(String shipCode) {
    this.shipCode = shipCode;
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

  public Caterers getCaterers() {
    return caterers;
  }

  public void setCaterers(Caterers caterers) {
    this.caterers = caterers;
  }

  public CatererClients getCatererClient() {
    return catererClient;
  }

  public void setCatererClient(CatererClients catererClient) {
    this.catererClient = catererClient;
  }

}
