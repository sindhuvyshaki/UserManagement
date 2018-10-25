package com.um.Management.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.um.Management.model.User;

@Configuration
@EntityScan(basePackageClasses = { User.class} )
@EnableJpaRepositories({ "com.um.Management.repository" })
public class ManagementConfig {
}
