package com.springboot.demo.Autowiring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
@Slf4j
public class DependencyInjectionDemoApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext applicationContext = SpringApplication.run(DependencyInjectionDemoApplication.class, args);
		System.out.println(":::::::::::::::::::::::::::::: Autowired Demo App Started on http://localhost:8081/ :::::::::::::::::::::::::::::::::::");

		Driver driver = (Driver) applicationContext.getBean("driver");
		log.info("Autowired On Setter Method for Driver Details :: {}", driver);

		Student student = (Student) applicationContext.getBean("student");
		log.info("Autowired On Field for Student Details :: {}", student);

		User user = (User) applicationContext.getBean("user");
		log.info("Autowired By Constructor for user Details :: {}", user);

		Car car = (Car) applicationContext.getBean("car");
		log.info("Autowired By Type for car Details");
		car.getDetails();

		Season season = (Season) applicationContext.getBean("season");
		log.info("No Any Autowired for season :: {}", season);
	}

}

/*  @Autowired  // 1. Autowired on Property
@Qualifier("student") // if type ambigious issue occur
private Car car;

@Autowired  // 2.  Autowired on Setters
public void setFormatter(Car car) {
	this.car = car;
}

@Autowired  // 3.  Autowired on Constructors
public FooService(Car car) {
	this.car = car;
}

Null response if bean not found but dont break context and In case if bean was found then give result  // 4.  @Autowired(required=false) */
