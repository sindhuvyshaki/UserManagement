package com.um.Api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.um.Api.representation.UserRepresentation;

//www.um.com/api/vi
@RestController
@RequestMapping(value = "/api/user")
public interface UserController {

    @GetMapping(value = "/{id}")
    public UserRepresentation get(@PathVariable Integer id);

    @PutMapping(value = "/{id}")
    public UserRepresentation put(@PathVariable Integer id, @RequestBody UserRepresentation userRepresentation);

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id);
}
