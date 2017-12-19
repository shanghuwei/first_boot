package com.honghu.first_boot.honghu;

import com.honghu.first_boot.BaseTest;
import org.json.JSONArray;
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

    @Test
    public void insertPerson() throws Exception{
        JSONObject object = new JSONObject();
        object.put("name","honghu");
        mockMvc.perform(post("/insert/person").content(object.toString()).header("Content-Type","application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void insertStudent() throws Exception{
        JSONObject object = new JSONObject();
        object.put("name","student1");
        object.put("score",100);
        mockMvc.perform(post("/insert/student").content(object.toString()).header("Content-Type","application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void insertTeacher() throws Exception{
        JSONObject object = new JSONObject();
        object.put("name","teacher1");
        object.put("title","特级");
        mockMvc.perform(post("/insert/teacher").content(object.toString()).header("Content-Type","application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void insertOrder() throws Exception{

        JSONObject item = new JSONObject();
        item.put("price",10);
        item.put("qty",5);
        JSONObject item1 = new JSONObject();
        item1.put("price",20);
        item1.put("qty",2);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(item);
        jsonArray.put(item1);

        JSONObject object = new JSONObject();
        object.put("amount",90.00);
        object.put("orderItems",jsonArray);

        mockMvc.perform(post("/insert/order").content(object.toString()).header("Content-Type","application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
