package com.springboot.demo;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses( { DepartmentControllerTest.class } )
@IncludeTags("current")
public class JunitTestSuite {
}
