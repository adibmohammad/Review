package com.demo.insuranceproductsstore.reviewservice.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@EnableJpaRepositories(basePackages = {Config.REPOSITORY_PACKAGE})
public class Config {

    public static final String REPOSITORY_PACKAGE = "com.demo.insuranceproductsstore.reviewservice.repository";

    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
