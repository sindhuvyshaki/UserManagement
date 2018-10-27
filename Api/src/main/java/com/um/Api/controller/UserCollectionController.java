package com.um.Api.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.um.Api.representation.UserRepresentation;

// www.um.com/api/vi
@RestController
@RequestMapping(value = "/api/user")
public interface UserCollectionController {

    @GetMapping(value = "/")
    public Collection<UserRepresentation> getAll();

    @PostMapping(value = "/")
    public UserRepresentation post(@RequestBody UserRepresentation userRepresentation);
}
