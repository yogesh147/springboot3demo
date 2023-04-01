package com.springboot.demo;

import com.springboot.demo.mocky.HelloControllerMockitoTest;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({HelloControllerMockitoTest.class, DepartmentControllerTest.class})
@IncludeTags("current")
public class JunitTestSuite {
}
