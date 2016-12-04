package com.oil.av.web.admin.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oil.av.service.platform.config.ConfigCompanyService;
import com.oil.av.vo.platform.config.ConfigCompanyVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:conf/spring-context.xml"})
public class TestController {

	@Resource
	public ConfigCompanyService configCompanyService;
	@Test
	public void test1(){
		ConfigCompanyVo vo=configCompanyService.getConfigCompanyVoById("1");
		System.out.println(vo.getAddress());
	}
	
}
