package com.example.cueyshop.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class User_roles {
    @Id
    @Column(name = "ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "User_ID",referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "Role_ID",referencedColumnName = "id")
    private Role role;
    public User_roles() {
        super();
    }
    public User_roles(int id, User user, Role role) {
        super();
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
