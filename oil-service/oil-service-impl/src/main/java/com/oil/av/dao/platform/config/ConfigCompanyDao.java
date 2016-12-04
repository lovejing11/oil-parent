package com.oil.av.dao.platform.config;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oil.av.entity.platform.config.ConfigCompanyEntity;
import com.oil.framework.common.page.Pagination;
public interface ConfigCompanyDao {
 
 	/**
     * 根据id取得运营管理-企业管理表
     * @param  configCompanyEntityId
     * @return
     */
	ConfigCompanyEntity get(java.lang.String id);
	
	/**
     * 查询全部ConfigCompanyEntity对象
     * @param  configCompanyEntityId
     * @return
     */
	List<ConfigCompanyEntity> getAll();

	/**
     * 根据Map<String,Object>对象查询符合条件的总数据数
     * @param  Map对象
     * @return
     */
	Long getConfigCompanyEntityCountsByConditions(@Param("params") Map<String, Object> params);
	
	/**
     * 根据Map<String,Object>分页查询
     * @param  Map对象
     * @return
     */
	List<ConfigCompanyEntity> getConfigCompanyEntityListByConditions(@Param("pager") Pagination<Map<String, Object>> pager, @Param("params") Map<String, Object> params);
		
	/**
     * 保存运营管理-企业管理表
     * @param  configCompanyEntity
     * @return
     */
	Long insert(ConfigCompanyEntity configCompanyEntity);
	
	/**
     * 更新运营管理-企业管理表
     * @param  configCompanyEntity
     * @return
     */
	 Integer update(ConfigCompanyEntity configCompanyEntity);
	
	/**
     * 根据configCompanyEntityID删除运营管理-企业管理表
     * @param  configCompanyEntity
     * @return
     */
	Integer delete(java.lang.String id);
}