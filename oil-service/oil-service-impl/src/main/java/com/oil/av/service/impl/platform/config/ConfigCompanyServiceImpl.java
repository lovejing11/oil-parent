package com.oil.av.service.impl.platform.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import com.oil.av.dao.platform.config.ConfigCompanyDao;
import com.oil.av.entity.platform.config.ConfigCompanyEntity;
import com.oil.av.service.platform.config.ConfigCompanyService;
import com.oil.av.vo.platform.config.ConfigCompanyVo;
import com.oil.framework.common.page.Pagination;

@Service
public class ConfigCompanyServiceImpl implements ConfigCompanyService {
	
	@Resource
	private ConfigCompanyDao configCompanyDao;
    
    @Override
    public ConfigCompanyVo getConfigCompanyVoById(String id) {
    	return this.entity2vo(configCompanyDao.get(id));
    }

    @Override
    public List<ConfigCompanyVo> getAll(){
    	List<ConfigCompanyEntity> configCompanyEntityList = configCompanyDao.getAll();
    	List<ConfigCompanyVo> configCompanyVoList = new ArrayList<ConfigCompanyVo>();
    	for(ConfigCompanyEntity entity : configCompanyEntityList){
    		configCompanyVoList.add(this.entity2vo(entity));
    	}
		return configCompanyVoList;
    }

    @Override
    public Pagination<Map<String, Object>> getConfigCompanyVoListByConditions(Pagination<Map<String, Object>> pager) {
		List<ConfigCompanyEntity> configCompanyEntityList = configCompanyDao.getConfigCompanyEntityListByConditions(pager, pager.getCondition());
		Long totalList = configCompanyDao.getConfigCompanyEntityCountsByConditions(pager.getCondition());
    	List<ConfigCompanyVo> configCompanyVoList = new ArrayList<ConfigCompanyVo>();
    	for(ConfigCompanyEntity entity : configCompanyEntityList){
    		configCompanyVoList.add(this.entity2vo(entity));
    	}
    	pager.setData(configCompanyVoList);
    	pager.setRecordsTotal(totalList.intValue());
		return pager;
    }
            
     @Override
     public Long addConfigCompanyVo(ConfigCompanyVo configCompanyVo) {
     	
		return configCompanyDao.insert(this.vo2entity(configCompanyVo));
     }
     
     @Override
     public Integer updateConfigCompanyVo(ConfigCompanyVo configCompanyVo) {
		return configCompanyDao.update(this.vo2entity(configCompanyVo));
     }
     
     @Override
     public Integer deleteConfigCompanyVo(String id) {
		return configCompanyDao.delete(id);
     }
     
     private ConfigCompanyVo entity2vo(ConfigCompanyEntity configCompanyEntity){
     	//TODO 此处需要将entity转换成VO
     	if(configCompanyEntity == null){
     		return null;
     	}
     	ConfigCompanyVo configCompanyVo = new ConfigCompanyVo();
     	BeanUtils.copyProperties(configCompanyEntity, configCompanyVo);
     	return configCompanyVo;
     }
     
     private ConfigCompanyEntity vo2entity(ConfigCompanyVo configCompanyVo){
     	//TODO 此处需要将VO转换成entity
     	if(configCompanyVo == null){
     		return null;
     	}
     	ConfigCompanyEntity configCompanyEntity = new ConfigCompanyEntity();
     	BeanUtils.copyProperties(configCompanyVo, configCompanyEntity);
     	return configCompanyEntity;
     }
}