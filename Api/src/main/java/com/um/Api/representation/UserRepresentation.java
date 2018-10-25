package com.um.Api.representation;

import com.um.Management.model.User;

public class UserRepresentation {

    private Integer id;
    private String name;
    private String email;
    private String address;

    public UserRepresentation() {
    }

    public UserRepresentation(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public UserRepresentation(User user) {
        this(user.getName(), user.getEmail(), user.getAddress());
        this.id = user.getId();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
