package com.example.cueyshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "collection")
public class Collectionn {
    @Id
    @Column(name = "Collection_ID")
    private int collectionID;
    @Column(name = "Collection_name")
    private String collectionName;
    @ManyToOne
    @JoinColumn(name = "Categories_ID",referencedColumnName = "Categories_ID")
    private Category category;
    public Collectionn() {
        super();
    }
    public Collectionn(int collectionID, String collectionName, Category category) {
        this.collectionID = collectionID;
        this.collectionName = collectionName;
        this.category = category;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(int collectionID) {
        this.collectionID = collectionID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
