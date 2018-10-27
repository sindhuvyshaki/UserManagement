package com.um.Api.controller.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.um.Api.controller.UserController;
import com.um.Api.representation.UserRepresentation;
import com.um.Api.utils.RepresentationToModelConverter;
import com.um.Management.model.User;
import com.um.Management.repository.UserRepository;

public class UserControllerImpl implements UserController {

    @Autowired private UserRepository userRepo;

    @Autowired private RepresentationToModelConverter converter;

    public UserRepresentation get(Integer id) {
        Optional<User> oUser = userRepo.findById(id);
        return oUser.isPresent() ? new UserRepresentation(oUser.get()) : null;
    }

    public UserRepresentation put(Integer id, UserRepresentation userRepresentation) {
        User updatedUser = userRepo.save(converter.convertToUser(id, userRepresentation));
        return new UserRepresentation(updatedUser);
    }

    public void delete(@PathVariable Integer id) {
        userRepo.deleteById(id);
    }
}
