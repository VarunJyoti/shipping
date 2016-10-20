package com.shore.dao.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_measurement_unit")
public class ItemMeasurementUnit implements java.io.Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;

  public ItemMeasurementUnit() {
  }

  public ItemMeasurementUnit(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
