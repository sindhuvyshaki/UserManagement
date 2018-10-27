package com.um.Api.controller;

import org.springframework.web.bind.annotation.RequestBody;

import com.um.Api.representation.UserRepresentation;

public interface UserController {

    public UserRepresentation get(Integer id);

    public UserRepresentation put(Integer id, @RequestBody UserRepresentation userRepresentation);

    public void delete(Integer id);
}
