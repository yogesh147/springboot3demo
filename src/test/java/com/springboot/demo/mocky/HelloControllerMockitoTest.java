package com.springboot.demo.mocky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // To start using Mockito in JUnit tests
public class HelloControllerMockitoTest {

    @Mock // for mock service
    private HelloService helloService;

    @InjectMocks // tells Mockito to inject all mock objects into the test class
    private HelloController helloController;

    @BeforeEach
    void setMockOutput() {
        when(helloService.getWelcomeMessage()).thenReturn("Hello Mockito Test");
    }

    @Test
    @Tag("current")
    public void shouldReturnDefaultMessage() {
        String response = helloController.greeting();
        assertThat(response).isEqualTo("Hello Mockito Test");
    }
}