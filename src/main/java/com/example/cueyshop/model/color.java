package com.example.cueyshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "color")
public class color {
    @Id
    @Column(name = "Color_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Color_name")
    private String colorName;
    public color() {
        super();
    }
    public color(String colorName , int id) {
        super();
        this.colorName = colorName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
