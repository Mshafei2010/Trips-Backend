package com.example.Backend.Admin;

import javax.persistence.*;

@Entity
@Table
public class admin {
    @Id
    @SequenceGenerator(
            name="admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    private long id;
    private String name;
    private String email;
    private String password;
    public admin(String name,String email , String password) {
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public admin() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
