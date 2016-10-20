package com.shore.dao.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "categories_items")
public class CategoriesItems implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "category_id")
  private Integer categoryId;

  @Column(name = "sub_category_id")
  private Integer subCategoryId;

  @Transient
  private Categories categories;

  @Transient
  private SubCategories subCategories;

  @Column(name = "name")
  private String name;

  @Column(name = "measurement_unit")
  private Integer measurementUnit;

  @Column(name = "active")
  private Boolean active;

  @Column(name = "isMuslim")
  private Boolean isMuslim;

  @Column(name = "search_tags")
  private String searchTags;

  @Column(name = "caterer_id")
  private Integer catererId;

  @Transient
  private Caterers caterers;

  @ManyToOne
  @JoinColumn(name = "measurement_unit", insertable = false, updatable = false)
  private ItemMeasurementUnit unitMeasure;

  public CategoriesItems() {
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Categories getCategories() {
    return this.categories;
  }

  public void setCategories(Categories categories) {
    this.categories = categories;
  }

  public SubCategories getSubCategories() {
    return this.subCategories;
  }

  public void setSubCategories(SubCategories subCategories) {
    this.subCategories = subCategories;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getMeasurementUnit() {
    return this.measurementUnit;
  }

  public void setMeasurementUnit(Integer measurementUnit) {
    this.measurementUnit = measurementUnit;
  }

  public Boolean getActive() {
    return this.active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Boolean getIsMuslim() {
    return this.isMuslim;
  }

  public void setIsMuslim(Boolean isMuslim) {
    this.isMuslim = isMuslim;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getSubCategoryId() {
    return subCategoryId;
  }

  public void setSubCategoryId(Integer subCategoryId) {
    this.subCategoryId = subCategoryId;
  }

  public String getSearchTags() {
    return searchTags;
  }

  public void setSearchTags(String searchTags) {
    this.searchTags = searchTags;
  }

  public ItemMeasurementUnit getUnitMeasure() {
    return unitMeasure;
  }

  public void setUnitMeasure(ItemMeasurementUnit unitMeasure) {
    this.unitMeasure = unitMeasure;
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
