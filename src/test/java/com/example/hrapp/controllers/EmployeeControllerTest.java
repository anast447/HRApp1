package com.example.hrapp.controllers;

import com.example.hrapp.model.Employee;
import com.example.hrapp.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc(addFilters = false)
public class EmployeeControllerTest {
    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public EmployeeService employeeService;

    @Autowired
    public ObjectMapper objectMapper;

    @Test
    public void testCreateEmployee() throws Exception {
        Employee e = new Employee();
        e.setPersonnelNumber("1005");
        e.setLastName("TestLastName");

        when(employeeService.create(any(Employee.class))).thenReturn(e);

        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(e)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName").value("TestLastName"));

        verify(employeeService, times(1)).create(any(Employee.class));
    }
    @Test
    public void testUpdateEmployee() throws Exception {
        Employee e = new Employee();
        e.setId(1L);
        e.setPersonnelNumber("1005");
        e.setLastName("UpdatedLastName");

        when(employeeService.update(eq(1L), any(Employee.class))).thenReturn(e);

        mockMvc.perform(put("/api/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(e)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName").value("UpdatedLastName"));

        verify(employeeService, times(1)).update(eq(1L), any(Employee.class));
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        doNothing().when(employeeService).delete(1L);

        mockMvc.perform(delete("/api/employees/1"))
                .andExpect(status().isOk());

        verify(employeeService, times(1)).delete(1L);
    }
}
