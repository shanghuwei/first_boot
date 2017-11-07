package com.honghu.first_boot;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FirstBootApplicationTests extends BaseTest{
	@Test
	public void test() throws Exception{
		JSONObject girl = new JSONObject();
		girl.put("age",14);
		girl.put("cupSize" ,"F");
		girl.put("honghu34" ,"54");
		mockMvc.perform(post("/girl_add").content(girl.toJSONString()).header("Content-Type", "application/json;charset=UTF-8"))
		.andDo(print())
		.andExpect(status().isOk());
	}


}
