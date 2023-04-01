package com.springboot.demo.mocky;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.mocky.EmployeeTest.EmployeeTest;
import com.springboot.demo.mocky.EmployeeTest.EmployeeTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * comment other controller autowired component dependencies
 */
@WebMvcTest
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeTestService employeeTestService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception {

        // given - precondition or setup
        EmployeeTest employeeTest = EmployeeTest.builder().firstName("Ramesh").lastName("Fadatare").email("ramesh@gmail.com").build();
        given(employeeTestService.saveEmployeeTest(any(EmployeeTest.class))).willAnswer((invocation) -> invocation.getArgument(0));

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/api/employees").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(employeeTest)));

        // then - verify the result or output using assert statements
        response.andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.firstName", is(employeeTest.getFirstName()))).andExpect(jsonPath("$.lastName", is(employeeTest.getLastName()))).andExpect(jsonPath("$.email", is(employeeTest.getEmail())));
    }

    // JUnit test for Get All employees REST API
    @Test
    public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception {
        // given - precondition or setup
        List<EmployeeTest> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(EmployeeTest.builder().firstName("Ramesh").lastName("Fadatare").email("ramesh@gmail.com").build());
        listOfEmployees.add(EmployeeTest.builder().firstName("Tony").lastName("Stark").email("tony@gmail.com").build());
        given(employeeTestService.getAllEmployeesTest()).willReturn(listOfEmployees);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/employees"));

        // then - verify the output
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(listOfEmployees.size())));
    }

    // positive scenario - valid employee id
    // JUnit test for GET employee by id REST API
    @Test
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject() throws Exception {
        // given - precondition or setup
        long employeeId = 1L;
        EmployeeTest employeeTest = EmployeeTest.builder().firstName("Ramesh").lastName("Fadatare").email("ramesh@gmail.com").build();
        given(employeeTestService.getEmployeeTestById(employeeId)).willReturn(Optional.of(employeeTest));

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/employees/{id}", employeeId));

        // then - verify the output
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.firstName", is(employeeTest.getFirstName()))).andExpect(jsonPath("$.lastName", is(employeeTest.getLastName()))).andExpect(jsonPath("$.email", is(employeeTest.getEmail())));

    }

    // negative scenario - valid employee id
    // JUnit test for GET employee by id REST API
    @Test
    public void givenInvalidEmployeeId_whenGetEmployeeById_thenReturnEmpty() throws Exception {
        // given - precondition or setup
        long employeeId = 1L;
        EmployeeTest employee = EmployeeTest.builder().firstName("Ramesh").lastName("Fadatare").email("ramesh@gmail.com").build();
        given(employeeTestService.getEmployeeTestById(employeeId)).willReturn(Optional.empty());

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/employees/{id}", employeeId));

        // then - verify the output
        response.andExpect(status().isNotFound()).andDo(print());

    }

    // JUnit test for update employee REST API - positive scenario
    @Test
    public void givenUpdatedEmployee_whenUpdateEmployee_thenReturnUpdateEmployeeObject() throws Exception {
        // given - precondition or setup
        long employeeId = 1L;
        EmployeeTest savedEmployee = EmployeeTest.builder().firstName("Ramesh").lastName("Fadatare").email("ramesh@gmail.com").build();

        EmployeeTest updatedEmployee = EmployeeTest.builder().firstName("Ram").lastName("Jadhav").email("ram@gmail.com").build();
        given(employeeTestService.getEmployeeTestById(employeeId)).willReturn(Optional.of(savedEmployee));
        given(employeeTestService.updateEmployeeTest(any(EmployeeTest.class))).willAnswer((invocation) -> invocation.getArgument(0));

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(updatedEmployee)));


        // then - verify the output
        response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.firstName", is(updatedEmployee.getFirstName()))).andExpect(jsonPath("$.lastName", is(updatedEmployee.getLastName()))).andExpect(jsonPath("$.email", is(updatedEmployee.getEmail())));
    }

    // JUnit test for update employee REST API - negative scenario
    @Test
    public void givenUpdatedEmployee_whenUpdateEmployee_thenReturn404() throws Exception {
        // given - precondition or setup
        long employeeId = 1L;
        EmployeeTest savedEmployee = EmployeeTest.builder().firstName("Ramesh").lastName("Fadatare").email("ramesh@gmail.com").build();

        EmployeeTest updatedEmployee = EmployeeTest.builder().firstName("Ram").lastName("Jadhav").email("ram@gmail.com").build();
        given(employeeTestService.getEmployeeTestById(employeeId)).willReturn(Optional.empty());
        given(employeeTestService.updateEmployeeTest(any(EmployeeTest.class))).willAnswer((invocation) -> invocation.getArgument(0));

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(updatedEmployee)));

        // then - verify the output
        response.andExpect(status().isNotFound()).andDo(print());
    }

    // JUnit test for delete employee REST API
    @Test
    public void givenEmployeeId_whenDeleteEmployee_thenReturn200() throws Exception {
        // given - precondition or setup
        long employeeId = 1L;
        willDoNothing().given(employeeTestService).deleteEmployeeTest(employeeId);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/api/employees/{id}", employeeId));

        // then - verify the output
        response.andExpect(status().isOk()).andDo(print());
    }

}
