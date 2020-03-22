package com.waes.scalableweb.contoller;

import com.waes.scalableweb.config.ScalableWebApplication;
import com.waes.scalableweb.controller.DiffController;
import com.waes.scalableweb.controller.response.DiffDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest(classes = ScalableWebApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class DiffControllerIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private DiffController controller;

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.controller).build();
    }

    @Test
    public void saveDiffLeftIT() throws Exception {
        DiffDto value = new DiffDto(1, "WAES Lelft", null);

        mockMvc.perform(post("/v1/diff/" + value.getId() + "/left")
                .content(Base64.getEncoder().encode(value.getLeft().getBytes()))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(value.getId())))
                .andExpect(jsonPath("$.left", is(value.getLeft())))
                .andExpect(jsonPath("$.right", is(value.getRight())));
    }

    @Test
    public void saveDiffRightIT() throws Exception {
        DiffDto value = new DiffDto(2, null, "WAES Right");

        mockMvc.perform(post("/v1/diff/" + value.getId() + "/right")
                .content(Base64.getEncoder().encode(value.getRight().getBytes()))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(value.getId())))
                .andExpect(jsonPath("$.right", is(value.getRight())))
                .andExpect(jsonPath("$.left", is(value.getLeft())));
    }

}
