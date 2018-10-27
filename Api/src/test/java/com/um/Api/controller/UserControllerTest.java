package com.um.Api.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.um.Api.controller.impl.UserControllerImpl;
import com.um.Api.representation.UserRepresentation;
import com.um.Api.utils.RepresentationToModelConverter;
import com.um.Management.model.User;
import com.um.Management.repository.UserRepository;

public class UserControllerTest {

    @InjectMocks
    UserController testme = new UserControllerImpl();

    @Mock
    UserRepository mockUserRepo;

    @Mock
    RepresentationToModelConverter mockConverter;

    @Mock
    UserRepresentation mockUserRepresentation;

    private List<User> mockUsers;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockUsers = new ArrayList<>();
        mockUsers.add(User.getBuilder().id(1).name("name1").email("email1").address("address1").build());
        mockUsers.add(User.getBuilder().id(2).name("name2").email("email2").address("address2").build());
    }

    @Test
    public void testGet() {
        when(mockUserRepo.findById(1)).thenReturn(Optional.of(mockUsers.get(0)));
        UserRepresentation got = new UserRepresentation(mockUsers.get(0));
        testme.get(mockUsers.get(0).getId());
        verify(mockUserRepo, times(1)).findById(1);
        assertEquals(mockUsers.get(0).getAddress(), got.getAddress());
        assertEquals(mockUsers.get(0).getEmail(), got.getEmail());
        assertEquals(mockUsers.get(0).getId(), got.getId());
        assertEquals(mockUsers.get(0).getName(), got.getName());
    }

    @Test
    public void testPut() {
        when(mockConverter.convertToUser(1, mockUserRepresentation)).thenReturn(mockUsers.get(0));
        when(mockUserRepo.save(mockUsers.get(0))).thenReturn(mockUsers.get(0));
        UserRepresentation got = testme.put(1, mockUserRepresentation);
        verify(mockConverter, times(1)).convertToUser(1, mockUserRepresentation);
        verify(mockUserRepo, times(1)).save(mockUsers.get(0));
        assertEquals(mockUsers.get(0).getAddress(), got.getAddress());
        assertEquals(mockUsers.get(0).getEmail(), got.getEmail());
        assertEquals(mockUsers.get(0).getId(), got.getId());
        assertEquals(mockUsers.get(0).getName(), got.getName());
    }

    @Test
    public void testDelete() {
        doNothing().when(mockUserRepo).deleteById(1);
        testme.delete(1);
        verify(mockUserRepo, times(1)).deleteById(1);
    }

}
