package com.um.Api.controller;

import java.util.Collection;

import com.um.Api.representation.UserRepresentation;

public interface UserCollectionController {

    public Collection<UserRepresentation> getAll();

    public UserRepresentation post(UserRepresentation userRepresentation);
}
