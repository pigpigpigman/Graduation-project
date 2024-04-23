package com.entity.vo;

import com.entity.StoreupEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 *  Collect表
 * 手机端接口return实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public class StoreupVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品id
	 */
	
	private Long refid;
		
	/**
	 * 表名
	 */
	
	private String tablename;
		
	/**
	 *  name
	 */
	
	private String name;
		
	/**
	 *  picture
	 */
	
	private String picture;
		
	/**
	 * 类型(1: Collect,21: praise,22:踩,31:竞拍参与,41:关注)
	 */
	
	private String type;
		
	/**
	 *  Recommended类型
	 */
	
	private String inteltype;
		
	/**
	 * 备注
	 */
	
	private String remark;
				
	
	/**
	 * 设置：商品id
	 */
	 
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	
	/**
	 * 获取：商品id
	 */
	public Long getRefid() {
		return refid;
	}
				
	
	/**
	 * 设置：表名
	 */
	 
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	/**
	 * 获取：表名
	 */
	public String getTablename() {
		return tablename;
	}
				
	
	/**
	 * 设置： name
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取： name
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * 设置： picture
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取： picture
	 */
	public String getPicture() {
		return picture;
	}
				
	
	/**
	 * 设置：类型(1: Collect,21: praise,22:踩,31:竞拍参与,41:关注)
	 */
	 
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 获取：类型(1: Collect,21: praise,22:踩,31:竞拍参与,41:关注)
	 */
	public String getType() {
		return type;
	}
				
	
	/**
	 * 设置： Recommended类型
	 */
	 
	public void setInteltype(String inteltype) {
		this.inteltype = inteltype;
	}
	
	/**
	 * 获取： Recommended类型
	 */
	public String getInteltype() {
		return inteltype;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
			
}
