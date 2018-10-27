package com.um.Api.controller.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.um.Api.controller.UserController;
import com.um.Api.representation.UserRepresentation;
import com.um.Api.utils.RepresentationToModelConverter;
import com.um.Management.model.User;
import com.um.Management.repository.UserRepository;

//www.um.com/api/vi
@RestController
@RequestMapping(value = "/api/user")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RepresentationToModelConverter converter;

    @GetMapping(value = "/{id}")
    public UserRepresentation get(@PathVariable Integer id) {
        Optional<User> oUser = userRepo.findById(id);
        return oUser.isPresent() ? new UserRepresentation(oUser.get()) : null;
    }

    @PutMapping(value = "/{id}")
    public UserRepresentation put(@PathVariable Integer id, @RequestBody UserRepresentation userRepresentation) {
        User updatedUser = userRepo.save(converter.convertToUser(id, userRepresentation));
        return new UserRepresentation(updatedUser);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        userRepo.deleteById(id);
    }
}
