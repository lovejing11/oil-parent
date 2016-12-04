package com.oil.framework.user;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.oil.framework.common.util.DateUtils;


/**自定义用户信息
 * @Version: 1.0
 * @ProjectName:aikxian-framework-web
 * @Filename:  CustomModel.java
 * @PackageName: com.aikxian.framework.base.model
 * @Author: songchunlong 宋春龙
 * @Email: songchunlong@aikxian.com
 * @Date:2016年4月18日下午7:46:59
 * @Copyright (c) 2016, dev@aikxian.com.com All Rights Reserved.
 */
public class CustomModel implements Serializable {
				/**
				 * Comment for <code>serialVersionUID</code>
				 */
				private static final long serialVersionUID = 8488593471441983045L;
				private Long id;
				private String userCode;
				private String name;
				private Boolean isEnable;
				private SexEnum sex;
				private Set<String> permission;
				private Map<String,Object> menuMap;
				private String createTime;
				private String phone;

				/**
				 * @return Returns the permission
				 */
				public Set<String> getPermission() {
								return permission;
				}

				/**
				 * @param permission
				 * The permission to set.
				 */
				public void setPermission(Set<String> permission) {
								this.permission = permission;
				}

				/**
				 * @return Returns the isEnable
				 */
				public Boolean getIsEnable() {
								return isEnable;
				}

				/**
				 * @param isEnable
				 * The isEnable to set.
				 */
				public void setIsEnable(Boolean isEnable) {
								this.isEnable = isEnable;
				}

				/**
				 * @return Returns the sex
				 */
				public SexEnum getSex() {
								return sex;
				}

				/**
				 * @param sex
				 * The sex to set.
				 */
				public void setSex(SexEnum sex) {
								this.sex = sex;
				}

				/**
				 * 用户id
				 * @return 用户id
				 */
				public Long getId() {
								return id;
				}

				public CustomModel(Long id, String userCode, String name, Boolean isEnable, SexEnum sex,Date creaeteTime,String phone) {
								super();
								this.id = id;
								this.userCode = userCode;
								this.name = name;
								this.isEnable = isEnable;
								this.sex = sex;
								this.createTime = DateUtils.formatDateTime(creaeteTime);
								this.phone = phone;
				}
				
				public CustomModel(Long id, String userCode, String name, Boolean isEnable, SexEnum sex,Date creaeteTime) {
					super();
					this.id = id;
					this.userCode = userCode;
					this.name = name;
					this.isEnable = isEnable;
					this.sex = sex;
					this.createTime = DateUtils.formatDateTime(creaeteTime);
	}

				/**
				 * @return Returns the userCode
				 */
				public String getUserCode() {
								return userCode;
				}

				/**
				 * @param userCode
				 * The userCode to set.
				 */
				public void setUserCode(String userCode) {
								this.userCode = userCode;
				}

				/**
				 * @return Returns the name
				 */
				public String getName() {
								return name;
				}

				/**
				 * @param name
				 * The name to set.
				 */
				public void setName(String name) {
								this.name = name;
				}

				/**
				 * @param id
				 * The id to set.
				 */
				public void setId(Long id) {
								this.id = id;
				}

				/**
				 * @return
				 * @see java.lang.Object#toString()
				 */
				@Override
				public String toString() {
								return "CustomModel [id=" + id + ", userCode=" + userCode + ", name=" + name + "]";
				}

                public Map<String, Object> getMenuMap() {
                    return menuMap;
                }

                public void setMenuMap(Map<String, Object> menuMap) {
                    this.menuMap = menuMap;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

				public String getPhone() {
					return phone;
				}

				public void setPhone(String phone) {
					this.phone = phone;
				}

                
               
}
