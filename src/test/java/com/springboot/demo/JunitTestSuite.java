package com.springboot.demo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses( { DepartmentControllerTest.class } )
public class JunitTestSuite {
}
