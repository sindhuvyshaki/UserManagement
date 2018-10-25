package com.um.application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementApplicationTests {

    @Autowired
    private Environment env;

	@Test
	public void contextLoads() {
	    String serverPort = env.getProperty("server.port");
	    assertEquals("9000",  serverPort);
	}

}
