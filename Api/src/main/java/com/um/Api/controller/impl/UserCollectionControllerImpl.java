package com.um.Api.controller.impl;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.um.Api.controller.UserCollectionController;
import com.um.Api.representation.UserRepresentation;
import com.um.Api.utils.RepresentationToModelConverter;
import com.um.Management.model.User;
import com.um.Management.repository.UserRepository;

public class UserCollectionControllerImpl implements UserCollectionController {
    @Autowired private UserRepository userRepo;

    @Autowired private RepresentationToModelConverter converter;

    public Collection<UserRepresentation> getAll() {
        Iterable<User> users = userRepo.findAll();
        Collection<UserRepresentation> userRepresentations = new HashSet<>();
        users.forEach(user -> {
            userRepresentations.add(new UserRepresentation(user));
        });
        return userRepresentations;
    }

    public UserRepresentation post(UserRepresentation userRepresentation) {
        User newUser = userRepo.save(converter.convertToUser(userRepresentation));
        return new UserRepresentation(newUser);
    }
}
