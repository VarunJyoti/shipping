package com.shore.dao.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sub_categories")
public class SubCategories implements java.io.Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "category_id")
  private Integer categoryId;

  @Transient
  private Categories category;

  @Column(name = "name")
  private String name;

  @Column(name = "active")
  private boolean active;

  @Column(name = "caterer_id")
  private Integer catererId;

  @Transient
  private Caterers caterers;

  @OneToMany(mappedBy = "subCategoryId", fetch = FetchType.EAGER)
  @OrderBy("name asc")
  private List<CategoriesItems> categoriesItemses = new ArrayList<CategoriesItems>();

  public SubCategories() {
  }

  public SubCategories(Integer id, Integer categoryId, String name, boolean active, Integer catererId) {
    this.id = id;
    this.categoryId = categoryId;
    this.catererId = categoryId;
    this.name = name;
    this.active = active;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Categories getCategory() {
    return this.category;
  }

  public void setCategory(Categories category) {
    this.category = category;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isActive() {
    return this.active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public List<CategoriesItems> getCategoriesItemses() {
    return this.categoriesItemses;
  }

  public void setCategoriesItemses(List<CategoriesItems> categoriesItemses) {
    this.categoriesItemses = categoriesItemses;
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
