package com.example.cueyshop.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.Set;

@Entity
@Enabled
@Table(name ="user")
public class User {
    @Id
    @Column(name="ID")
    private int ID;
    @Column(name = "Name" )
    private String name;
    @Column(name = "Password")
    private String password;
    @Column(name = "Address")
    private String address;
    @Column(name = "Email")
    private String email;
    @Column(name ="Phone")
    private String phone;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<User_roles> userRoles;
    public User() {
        super();
    }
    public User(int ID, String name, String password, String address, String email, String phone, Set<User_roles> userRoles) {
        super();
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.userRoles = userRoles;
    }


    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        this.ID = iD;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<User_roles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User_roles> userRoles) {
        this.userRoles = userRoles;
    }
}
