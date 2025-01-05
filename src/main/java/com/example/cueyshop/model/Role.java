package com.example.cueyshop.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @OneToMany(mappedBy = "role")
    private Set<User_roles> roleUser;
    public Role() {
        super();
    }
    public Role(int id, String name, Set<User_roles> roleUser) {
        super();
        this.id = id;
        this.name = name;
        this.roleUser = roleUser;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<User_roles> getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(Set<User_roles> roleUser) {
        this.roleUser = roleUser;
    }
}
