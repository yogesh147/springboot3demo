package com.springboot.demo.BeanValidation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

import java.util.Set;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
@Slf4j
public class BeanValidationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanValidationDemoApplication.class, args);
        System.out.println(":::::::::::::::::::::::::::::: Bean Validation Demo App Started on http://localhost:8081/ :::::::::::::::::::::::::::::::::::");

        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<User>> violations = validator.validate(user);
            for (ConstraintViolation<User> violation : violations) {
                log.error(violation.getMessage());
            }
        } catch (Exception e) {
            log.error("Error while calling Validator Factory");
        }
    }

}
