package com.example.cueyshop.model;

import jakarta.persistence.*;

import java.awt.*;
import java.util.Collection;

@Entity
@Table(name="product")
public class Product {
    @Id
    @Column(name = "Product_ID")
    private int Product_ID;
    @Column(name = "Product_name")
    private String Product_Name;
    @Column(name = "Description")
    private String Description;
    @Column(name = "Image")
    private String Image;
    @Column(name = "Is_Like")
    private boolean Is_Like;
    @Column(name = "Price")
    private double Price;
    @Column(name = "Stock")
    private Integer Stock;
    @Column(name = "Quanlity")
    private double Quanlity;
    @ManyToOne
    @JoinColumn(name = "Categories_ID",referencedColumnName = "Categories_ID")
    private Category Category;
    @ManyToOne
    @JoinColumn(name = "Collection_ID",referencedColumnName = "Collection_ID")
    private Collectionn collectionn;
    @ManyToOne
    @JoinColumn(name = "Color_ID",referencedColumnName = "Color_ID")
    private color clor;
    public Product() {
        super();
    }

    public Product(int product_ID, String product_Name, String description,double Quanlity, String image, boolean is_Like, Integer stock, double price, Category category, Collectionn collectionn, color clor) {
        super();
        Product_ID = product_ID;
        Product_Name = product_Name;
        Description = description;
        Image = image;
        Is_Like = is_Like;
        Stock = stock;
        Price = price;
        Quanlity = Quanlity;
        this.Category = category;
        this.collectionn = collectionn;
        this.clor = clor;
    }

    public double getQuanlity() {
        return Quanlity;
    }

    public void setQuanlity(double quanlity) {
        Quanlity = quanlity;
    }

    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int product_ID) {
        Product_ID = product_ID;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public boolean isIs_Like() {
        return Is_Like;
    }

    public void setIs_Like(boolean is_Like) {
        Is_Like = is_Like;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public com.example.cueyshop.model.Category getCategory() {
        return Category;
    }

    public void setCategory(com.example.cueyshop.model.Category category) {
        Category = category;
    }

    public Collectionn getCollectionn() {
        return collectionn;
    }

    public void setCollectionn(Collectionn collectionn) {
        this.collectionn = collectionn;
    }

    public color getClor() {
        return clor;
    }

    public void setClor(color clor) {
        this.clor = clor;
    }
}
