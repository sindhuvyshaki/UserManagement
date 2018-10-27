package com.um.Api.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.um.Api.controller.impl.UserCollectionControllerImpl;
import com.um.Api.representation.UserRepresentation;
import com.um.Api.utils.RepresentationToModelConverter;
import com.um.Management.model.User;
import com.um.Management.repository.UserRepository;

public class UserCollectionControllerTest {

    @InjectMocks
    UserCollectionController testme = new UserCollectionControllerImpl();
    
    @Mock
    UserRepository mockUserRepo;

    @Mock
    RepresentationToModelConverter mockConverter;

    @Mock
    UserRepresentation mockUserRepresentation;

    List<User> mockUsers;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockUsers = new ArrayList<>();
        mockUsers.add(User.getBuilder().id(1).name("name1").email("email1").address("address1").build());
        mockUsers.add(User.getBuilder().id(2).name("name2").email("email2").address("address2").build());
    }

    @Test
    public void testGetAll() {
        when(mockUserRepo.findAll()).thenReturn(mockUsers);
        Collection<UserRepresentation> out = testme.getAll();
        verify(mockUserRepo, times(1)).findAll();
        assertEquals(2, out.size());
    }

    @Test
    public void testPost() {
        when(mockConverter.convertToUser(mockUserRepresentation)).thenReturn(mockUsers.get(0));
        when(mockUserRepo.save(mockUsers.get(0))).thenReturn(mockUsers.get(0));
        UserRepresentation newUserRepresentation = testme.post(mockUserRepresentation);
        verify(mockUserRepo, times(1)).save(mockUsers.get(0));
        assertEquals(mockUsers.get(0).getAddress(), newUserRepresentation.getAddress());
        assertEquals(mockUsers.get(0).getEmail(), newUserRepresentation.getEmail());
        assertEquals(mockUsers.get(0).getId(), newUserRepresentation.getId());
        assertEquals(mockUsers.get(0).getName(), newUserRepresentation.getName());
    }

}
