package com.shore.dao.vo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseOrderHistory {

  @Column(name = "event")
  private String event;

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

}
