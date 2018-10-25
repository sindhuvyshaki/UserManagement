package com.um.Api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.um.Management.config.ManagementConfig;

@Configuration
@Import({ ManagementConfig.class })
public class ApiConfig {
//    @Bean
//    public RepresentationToModelConverter representationToModelConverter() {
//        return new RepresentationToModelConverter();
//    }
}
