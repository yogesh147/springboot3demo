package com.springboot.demo.MethodReplacerDemo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
@Slf4j
public class MethodReplacerDemoApplication {

	public static ObjectMapper oMapper = new ObjectMapper();

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(MethodReplacerDemoApplication.class, args);
		System.out.println(":::::::::::::::::::::::::::::: MethodReplacer Demo App Started on http://localhost:8081/ :::::::::::::::::::::::::::::::::::");

		Car.design();
//		Car.breaks();
		final Method breaks = Car.class.getMethod("breaks");

		ReImplement reImplement = new ReImplement();
		Map<String, String> map = new HashMap<>();
		map.put("0", "Z");
		final Object reImplementObj = reImplement.reimplement(map, breaks, new Object[]{"A"});
		Map<String, String> reImplementMap = oMapper.convertValue(reImplementObj, new TypeReference<>() {
		});
		log.info("reImplementMap :: {}", reImplementMap);
	}

}
