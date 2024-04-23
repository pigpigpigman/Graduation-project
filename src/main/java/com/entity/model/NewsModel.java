package com.entity.model;

import com.entity.NewsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * Music INFO
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model name
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public class NewsModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * intro
	 */
	
	private String introduction;
		
	/**
	 *  picture
	 */
	
	private String picture;
		
	/**
	 * content
	 */
	
	private String content;
				
	
	/**
	 * 设置：intro
	 */
	 
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	/**
	 * 获取：intro
	 */
	public String getIntroduction() {
		return introduction;
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
	 * 设置：content
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：content
	 */
	public String getContent() {
		return content;
	}
			
}