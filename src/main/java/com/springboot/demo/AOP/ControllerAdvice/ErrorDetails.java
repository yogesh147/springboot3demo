package com.springboot.demo.AOP.ControllerAdvice;

import java.util.Date;

public record ErrorDetails(Date timestamp, String message, String details) {
}
