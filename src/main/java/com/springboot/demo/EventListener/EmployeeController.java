package com.springboot.demo.EventListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

    @Autowired
    EmailPublisher emailPublisher;

    @GetMapping("/notify/event/{id}")
    public void publishEvent(@PathVariable("id") Long id) throws InterruptedException {
        Thread.sleep(id);
        emailPublisher.publishEmailEvent(new EmailEvent("Employee added. " + LocalDate.now() + " " + id));
        emailPublisher.publishMsgEvent("Exception occurred. " + LocalDate.now() + " " + id);
    }
}
