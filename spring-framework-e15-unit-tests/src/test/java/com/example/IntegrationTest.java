package com.example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // now you will have a bean MocMvc type
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProductTest() throws Exception{
        mockMvc.perform(
                get("/product/{name}", "Pizza"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Pizza"))
                .andExpect(jsonPath("$.price").value(10.0));
    }
}
/**
 * Integration Test: if you test more than one component it is integration test.
   - there is no clear argument in the boundary of integration test ,
        how far to test? should we mock the database? or use in-memory database?
 */
