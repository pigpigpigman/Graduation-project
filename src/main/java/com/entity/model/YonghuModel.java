package com.entity.model;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 *  user 
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model name
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public class YonghuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * password
	 */
	
	private String mima;
		
	/**
	 *  user  name
	 */
	
	private String yonghuxingming;
		
	/**
	 * sex
	 */
	
	private String xingbie;
		
	/**
	 * age
	 */
	
	private String nianling;
		
	/**
	 * mailbox
	 */
	
	private String youxiang;
		
	/**
	 * Mobile phone number
	 */
	
	private String shoujihao;
		
	/**
	 * avatar
	 */
	
	private String touxiang;
				
	
	/**
	 * 设置：password
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：password
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置： user  name
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取： user  name
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：sex
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：sex
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：age
	 */
	 
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：age
	 */
	public String getNianling() {
		return nianling;
	}
				
	
	/**
	 * 设置：mailbox
	 */
	 
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	
	/**
	 * 获取：mailbox
	 */
	public String getYouxiang() {
		return youxiang;
	}
				
	
	/**
	 * 设置：Mobile phone number
	 */
	 
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	
	/**
	 * 获取：Mobile phone number
	 */
	public String getShoujihao() {
		return shoujihao;
	}
				
	
	/**
	 * 设置：avatar
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：avatar
	 */
	public String getTouxiang() {
		return touxiang;
	}
			
}
