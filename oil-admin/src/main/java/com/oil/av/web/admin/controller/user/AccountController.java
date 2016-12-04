package com.oil.av.web.admin.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user/account")
public class AccountController {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String  list(){
		return "index";
	}
}
