package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * Singer INFO
 * 数据库通用Controls实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@TableName("geshouxinxi")
public class GeshouxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GeshouxinxiEntity() {
		
	}
	
	public GeshouxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * Singer name
	 */
					
	private String geshouxingming;
	
	/**
	 * Singersex
	 */
					
	private String geshouxingbie;
	
	/**
	 * school
	 */
					
	private String liupai;
	
	/**
	 * label
	 */
					
	private String biaoqian;
	
	/**
	 * Debut date
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date chudaoriqi;
	
	/**
	 * Fame song
	 */
					
	private String chengminggequ;
	
	/**
	 * avatar
	 */
					
	private String touxiang;
	
	/**
	 * Hit song
	 */
					
	private String remengequ;
	
	/**
	 * Album introduction
	 */
					
	private String zhuanjijieshao;
	
	/**
	 * Singer introduce
	 */
					
	private String geshoujieshao;
	
	/**
	 *  praise
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：Singer name
	 */
	public void setGeshouxingming(String geshouxingming) {
		this.geshouxingming = geshouxingming;
	}
	/**
	 * 获取：Singer name
	 */
	public String getGeshouxingming() {
		return geshouxingming;
	}
	/**
	 * 设置：Singersex
	 */
	public void setGeshouxingbie(String geshouxingbie) {
		this.geshouxingbie = geshouxingbie;
	}
	/**
	 * 获取：Singersex
	 */
	public String getGeshouxingbie() {
		return geshouxingbie;
	}
	/**
	 * 设置：school
	 */
	public void setLiupai(String liupai) {
		this.liupai = liupai;
	}
	/**
	 * 获取：school
	 */
	public String getLiupai() {
		return liupai;
	}
	/**
	 * 设置：label
	 */
	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}
	/**
	 * 获取：label
	 */
	public String getBiaoqian() {
		return biaoqian;
	}
	/**
	 * 设置：Debut date
	 */
	public void setChudaoriqi(Date chudaoriqi) {
		this.chudaoriqi = chudaoriqi;
	}
	/**
	 * 获取：Debut date
	 */
	public Date getChudaoriqi() {
		return chudaoriqi;
	}
	/**
	 * 设置：Fame song
	 */
	public void setChengminggequ(String chengminggequ) {
		this.chengminggequ = chengminggequ;
	}
	/**
	 * 获取：Fame song
	 */
	public String getChengminggequ() {
		return chengminggequ;
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
	/**
	 * 设置：Hit song
	 */
	public void setRemengequ(String remengequ) {
		this.remengequ = remengequ;
	}
	/**
	 * 获取：Hit song
	 */
	public String getRemengequ() {
		return remengequ;
	}
	/**
	 * 设置：Album introduction
	 */
	public void setZhuanjijieshao(String zhuanjijieshao) {
		this.zhuanjijieshao = zhuanjijieshao;
	}
	/**
	 * 获取：Album introduction
	 */
	public String getZhuanjijieshao() {
		return zhuanjijieshao;
	}
	/**
	 * 设置：Singer introduce
	 */
	public void setGeshoujieshao(String geshoujieshao) {
		this.geshoujieshao = geshoujieshao;
	}
	/**
	 * 获取：Singer introduce
	 */
	public String getGeshoujieshao() {
		return geshoujieshao;
	}
	/**
	 * 设置： praise
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取： praise
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}

}
