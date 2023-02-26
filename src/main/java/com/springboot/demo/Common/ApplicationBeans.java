package com.springboot.demo.Common;

import com.springboot.demo.Model.Person;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

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
    @Scope("singleton")
    public Person personBean() {
        log.debug("personBean called !!");
        name = "Hello";
        return Person.builder()
                .name("Unknown")
                .age(26)
                .build();
    }

    @Bean(name = "data")
    @Scope("singleton")
    public String data() {
        log.info("data called !!");
        return name;
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Bean ApplicationBeans has been instantiated and I'm the init() method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Container has been closed and I'm the destroy() method");
    }
}
