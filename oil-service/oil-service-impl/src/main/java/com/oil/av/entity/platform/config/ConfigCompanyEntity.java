package com.oil.av.entity.platform.config;

import java.io.Serializable;
import com.oil.framework.base.entity.BaseEntity;
/**
 * 运营管理-企业管理表
 * <p>Table: <strong>po_config_company_t</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *     <th nowrap>属性名</th><th nowrap>属性类型</th><th nowrap>字段名</th><th nowrap>字段类型</th><th nowrap>说明</th>
 *   </tr>
 *   <tr><td>id</td><td>{@link java.lang.String}</td><td>id</td><td>varchar</td><td>主键id</td></tr>
 *   <tr><td>name</td><td>{@link java.lang.String}</td><td>name</td><td>varchar</td><td>公司名称</td></tr>
 *   <tr><td>address</td><td>{@link java.lang.String}</td><td>address</td><td>varchar</td><td>公司地址</td></tr>
 *   <tr><td>isEnable</td><td>{@link java.lang.Boolean}</td><td>is_enable</td><td>tinyint</td><td>是否启用</td></tr>
 *   <tr><td>createTime</td><td>{@link java.util.Date}</td><td>create_time</td><td>datetime</td><td>创建时间</td></tr>
 *   <tr><td>createUser</td><td>{@link java.lang.String}</td><td>create_user</td><td>varchar</td><td>创建人</td></tr>
 *   <tr><td>modifyTime</td><td>{@link java.util.Date}</td><td>modify_time</td><td>datetime</td><td>修改时间</td></tr>
 *   <tr><td>modifyUser</td><td>{@link java.lang.String}</td><td>modify_user</td><td>varchar</td><td>修改人</td></tr>
 * </table>
 */
public class ConfigCompanyEntity extends BaseEntity implements Serializable {
 
 	
 		private java.lang.String id;
 		/**
	     * 获取主键id
	     */
 		public java.lang.String getId(){
 			return this.id;
 		}
 		
 		/**
	     * 设置主键id
	     */
 		public void setId(java.lang.String id){
 			this.id = id;
 		} 				
 		
 		private java.lang.String name;
 		/**
	     * 获取公司名称
	     */
 		public java.lang.String getName(){
 			return this.name;
 		}
 		
 		/**
	     * 设置公司名称
	     */
 		public void setName(java.lang.String name){
 			this.name = name;
 		} 				
 		
 		private java.lang.String address;
 		/**
	     * 获取公司地址
	     */
 		public java.lang.String getAddress(){
 			return this.address;
 		}
 		
 		/**
	     * 设置公司地址
	     */
 		public void setAddress(java.lang.String address){
 			this.address = address;
 		} 				
 		
 		private java.lang.Boolean isEnable;
 		/**
	     * 获取是否启用
	     */
 		public java.lang.Boolean getIsEnable(){
 			return this.isEnable;
 		}
 		
 		/**
	     * 设置是否启用
	     */
 		public void setIsEnable(java.lang.Boolean isEnable){
 			this.isEnable = isEnable;
 		} 				
 		
 		private java.util.Date createTime;
 		/**
	     * 获取创建时间
	     */
 		public java.util.Date getCreateTime(){
 			return this.createTime;
 		}
 		
 		/**
	     * 设置创建时间
	     */
 		public void setCreateTime(java.util.Date createTime){
 			this.createTime = createTime;
 		} 				
 		
 		private java.lang.String createUser;
 		/**
	     * 获取创建人
	     */
 		public java.lang.String getCreateUser(){
 			return this.createUser;
 		}
 		
 		/**
	     * 设置创建人
	     */
 		public void setCreateUser(java.lang.String createUser){
 			this.createUser = createUser;
 		} 				
 		
 		private java.util.Date modifyTime;
 		/**
	     * 获取修改时间
	     */
 		public java.util.Date getModifyTime(){
 			return this.modifyTime;
 		}
 		
 		/**
	     * 设置修改时间
	     */
 		public void setModifyTime(java.util.Date modifyTime){
 			this.modifyTime = modifyTime;
 		} 				
 		
 		private java.lang.String modifyUser;
 		/**
	     * 获取修改人
	     */
 		public java.lang.String getModifyUser(){
 			return this.modifyUser;
 		}
 		
 		/**
	     * 设置修改人
	     */
 		public void setModifyUser(java.lang.String modifyUser){
 			this.modifyUser = modifyUser;
 		} 				
 		
 }