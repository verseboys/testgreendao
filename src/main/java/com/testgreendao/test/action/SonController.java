package com.testgreendao.test.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testgreendao.test.pojo.Father;
import com.testgreendao.test.pojo.Son;
import com.testgreendao.test.service.FatherService;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class SonController {
	
	@Autowired
	private FatherService fatherService;
	
	
	
	@RequestMapping(value="info/{fateherId}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String findSonById(@PathVariable Integer fateherId){
		
		
		Father father=fatherService.findById(fateherId);
		String array=JSON.toJSONString(father);
		
		
		return array;
		
	}

}
