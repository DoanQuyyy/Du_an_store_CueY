package com.example.cueyshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "Categories_ID")
    private int id;
    @Column(name = "Category_name")
    private String categoryName;
    @Column(name = "Parent_ID")
    private Integer parentId;
    public Category() {
        super();
    }
    public Category(int id, String categoryName, int parentId) {
        super();
        this.id = id;
        this.categoryName = categoryName;
        this.parentId = parentId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
