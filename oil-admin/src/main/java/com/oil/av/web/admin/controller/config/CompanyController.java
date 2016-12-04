package com.oil.av.web.admin.controller.config;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oil.av.service.platform.config.ConfigCompanyService;
import com.oil.av.vo.platform.config.ConfigCompanyVo;
import com.oil.framework.common.page.Pagination;
import com.oil.framework.common.tuple.BeanTransMap;

@Controller
@RequestMapping(value = "/platform/config/company")
public class CompanyController {
	
	@Resource
	public ConfigCompanyService configCompanyService;

	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	    public String list(Map<String, Object> modelMap) {
	        return "config/company/company_list";
	    }
	 
	 @ResponseBody
	 @RequestMapping(value = "/list", method = RequestMethod.POST)
	    public Pagination<Map<String, Object>> list(ConfigCompanyVo vo) {
				 Pagination<Map<String, Object>> pager = new Pagination<Map<String, Object>>();
		         pager.setStartIndex(vo.getStart());
		         pager.setPageSize(vo.getLength());
		         pager.setDraw(vo.getDraw());
		         Map<String, Object> map = BeanTransMap.transBean2Map(vo);
		         pager.setCondition(map);
		         pager = configCompanyService.getConfigCompanyVoListByConditions(pager);
	        return pager;
	    }
}
