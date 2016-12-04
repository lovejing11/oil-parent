package com.oil.av.service.platform.config;

import java.util.List;
import java.util.Map;

import com.oil.av.vo.platform.config.ConfigCompanyVo;
import com.oil.framework.common.page.Pagination;

public interface ConfigCompanyService {

	/**
     * 根据id取得运营管理-企业管理表
     * @param  id
     * @return
     */
     public ConfigCompanyVo getConfigCompanyVoById(String id);

	/**
     * 根据id取得运营管理-企业管理表
     * @param  id
     * @return
     */
     public List<ConfigCompanyVo> getAll();

	/**
     * 根据ConfigCompanyVo对象分页查询
     * @param  configCompanyVo
     * @return
     */
     public Pagination<Map<String, Object>> getConfigCompanyVoListByConditions(Pagination<Map<String, Object>> pager);
    
    /**
     * 保存运营管理-企业管理表
     * @param  configCompanyVo
     * @return
     */
     public Long addConfigCompanyVo(ConfigCompanyVo configCompanyVo);
     
     /**
     * 更新运营管理-企业管理表
     * @param  configCompanyVo
     * @return
     */
     public Integer updateConfigCompanyVo(ConfigCompanyVo configCompanyVo);
     
     /**
     * 根据id删除运营管理-企业管理表
     * @param  id
     * @return
     */
     public Integer  deleteConfigCompanyVo(String id);
}