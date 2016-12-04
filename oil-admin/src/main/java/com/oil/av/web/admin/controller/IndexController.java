package com.oil.av.web.admin.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oil.framework.user.CustomModel;
import com.oil.framework.user.SexEnum;

@Controller
public class IndexController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Map<String, Object> modelMap) {
		CustomModel model=new CustomModel(1l, "1001", "admin", true, SexEnum.MAN, new Date());
		modelMap.put("user", model);
		return "index";
	}
}
