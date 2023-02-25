package com.springboot.demo.Common;

import com.springboot.demo.Model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy(false)
@Slf4j
public class ApplicationBeans {
    public static String name;

    public ApplicationBeans() {
        name = "ApplicationBeans";
        log.info("Constructor called for class :: {}", name);
    }

    @Bean(name = "person")
    public Person personBean() {
        log.debug("personBean called !!");
        name = "Hello";
        return Person.builder()
                .name("Unknown")
                .age(26)
                .build();
    }

    @Bean(name = "data")
    public String data() {
        log.info("data called !!");
        return name;
    }
}
