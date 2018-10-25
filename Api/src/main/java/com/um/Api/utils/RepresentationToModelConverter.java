package com.um.Api.utils;

import org.springframework.stereotype.Component;

import com.um.Api.representation.UserRepresentation;
import com.um.Management.model.User;

@Component
public class RepresentationToModelConverter {

    public User convertToUser(UserRepresentation userRepresentation) {
        return User.getBuilder().name(userRepresentation.getName()).address(userRepresentation.getAddress())
                .email(userRepresentation.getEmail()).build();
    }
    
    public User convertToUser(Integer id, UserRepresentation userRepresentation) {
        return User.getBuilder().id(id).name(userRepresentation.getName()).address(userRepresentation.getAddress())
                .email(userRepresentation.getEmail()).build();
    }
}
