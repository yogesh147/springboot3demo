package com.springboot.demo.Controller;

import com.springboot.demo.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    @GetMapping
    public String homePage() {
        return """
                <html>
                <head>
                <title>WELCOME TO SPRINGBOOT DEMO APP</title>
                <link rel="icon" type="image/ico" href="/favicon.ico">
                </head>
                <body>
                <h1 style='color:#7abe22'>WELCOME TO SPRINGBOOT DEMO APP</h1>
                <p><a href="http://localhost:8080/student" target="_blank">Go to Student page!</a></p>
                <p>Project Id: <b>12.02.2023.16.15</b></p>
                <p>Java version: <b>17.0.4.1 2022-08-18 LTS</b></p>
                <p>Spring Framework version: <b>6.0.4</b></p>
                <p>Spring Boot version: <b>3.0.2 </b></p>
                <p>Apache Maven version: <b>3.8.2</b></p>
                <p>Apache Tomcat version: <b>10.1.5</b></p>
                <p>IntelliJ IDEA version: <b>2022.3.2 (Community Edition)</b></p>
                </body>
                </html>
                """;
    }

    @GetMapping("student")
    public List<Student> getEmployees() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("ABC", 1));
        return studentList;
    }

}
