package com.shore.dao.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "categories")
public class Categories implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "active")
  private Boolean active;

  @Column(name = "caterer_id")
  private Integer catererId;

  @Transient
  private Caterers caterers;

  @Transient
  private Set<CategoriesItems> categoriesItemses = new HashSet<CategoriesItems>(0);

  @Transient
  private Set<Orders> orderses = new HashSet<Orders>(0);

  @OneToMany(mappedBy = "categoryId", fetch = FetchType.EAGER)
  @OrderBy("name asc")
  private Set<SubCategories> subCategorieses = new HashSet<SubCategories>(0);

  public Categories() {
  }

  public Categories(Integer id) {
    this.id = id;
  }

  public Categories(Integer id, String name, Boolean active, Integer catererId, Set<CategoriesItems> categoriesItemses, Set<Orders> orderses, Set<SubCategories> subCategorieses) {
    this.id = id;
    this.name = name;
    this.active = active;
    this.catererId = catererId;
    this.categoriesItemses = categoriesItemses;
    this.orderses = orderses;
    this.subCategorieses = subCategorieses;
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

  public Boolean getActive() {
    return this.active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Set<CategoriesItems> getCategoriesItemses() {
    return this.categoriesItemses;
  }

  public void setCategoriesItemses(Set<CategoriesItems> categoriesItemses) {
    this.categoriesItemses = categoriesItemses;
  }

  public Set<Orders> getOrderses() {
    return this.orderses;
  }

  public void setOrderses(Set<Orders> orderses) {
    this.orderses = orderses;
  }

  public Set<SubCategories> getSubCategorieses() {
    return this.subCategorieses;
  }

  public void setSubCategorieses(Set<SubCategories> subCategorieses) {
    this.subCategorieses = subCategorieses;
  }

  public Integer getCatererId() {
    return catererId;
  }

  public void setCatererId(Integer catererId) {
    this.catererId = catererId;
  }

  public Caterers getCaterers() {
    return caterers;
  }

  public void setCaterers(Caterers caterers) {
    this.caterers = caterers;
  }

}
