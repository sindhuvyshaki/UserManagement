package com.um.Management.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.um.Management.model.User.Builder;

public class UserTest {

    @Test
    public void test() {
        Builder builder = User.getBuilder();
        User sindhu = builder.id(1).name("Sindhu").address("El Sobrante").email("myemail@aol.com").build();

        assertEquals("Sindhu", sindhu.getName());
    }

}
