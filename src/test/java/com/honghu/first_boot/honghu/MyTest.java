package com.honghu.first_boot.honghu;

import com.honghu.first_boot.BaseTest;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MyTest extends BaseTest{
    @Test
    public void getTest() throws Exception{
        mockMvc.perform(get("/queryGirls").param("age","14"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addGirl() throws Exception{
        JSONObject obj = new org.json.JSONObject();
        obj.put("age","22");
        obj.put("cupSize","G");
        mockMvc.perform(post("/girl_add").content(obj.toString()).header("Content-Type","application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void utilTest() throws Exception{
        mockMvc.perform(get("/test/enum"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}