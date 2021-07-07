package com.training.micro.person;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.training.micro.SpringtrainingApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = SpringtrainingApplication.class)
@AutoConfigureMockMvc
class PersonRestTest {

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() throws Exception {
        MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/test")
                                                                  .content("osman")
                                                                  .accept(MediaType.APPLICATION_JSON))
                                   .andExpect(MockMvcResultMatchers.status()
                                                                   .isOk())
                                   .andReturn();
        String resultDOW = result.getResponse()
                                 .getContentAsString();
        Assertions.assertNotNull(resultDOW);
        Assertions.assertEquals("test",
                                resultDOW);
    }

}
