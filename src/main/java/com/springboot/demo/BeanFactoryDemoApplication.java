package com.springboot.demo;

import com.springboot.demo.Common.ApplicationBeans;
import com.springboot.demo.Common.SpringContainer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Objects;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
public class BeanFactoryDemoApplication {

    public static void main(String[] args) {

        final ConfigurableApplicationContext app = SpringApplication.run(DemoApplication.class, args);
        final String arg = String.join(" ", args);

        System.out.println(":::::::::::::::::::::::::::::: " + arg + " App Started on http://localhost:8080/ :::::::::::::::::::::::::::::::::::");

        String data = ApplicationBeans.name;
        if (Objects.isNull(data)) {
            BeanFactory factory = SpringContainer.getBeanFactory();
            factory.getBean("person");
            data = (String) factory.getBean("data");
        }

        System.out.println(data);
       // app.close();
    }
}
