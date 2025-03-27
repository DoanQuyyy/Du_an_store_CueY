package com.example.cueyshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "collection")
public class Collectionn {
    @Id
    @Column(name = "Collection_ID")
    private Integer collectionID;
    @Column(name = "Collection_name")
    private String collectionName;
    @Column(name = "Image")
    private String image;
    @Column(name = "Description")
    private String description;
    public Collectionn() {
        super();
    }
    public Collectionn(Integer collectionID, String collectionName, String image, String description) {
        this.collectionID = collectionID;
        this.collectionName = collectionName;
        this.image = image;
        this.description = description;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Integer getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(Integer collectionID) {
        this.collectionID = collectionID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
