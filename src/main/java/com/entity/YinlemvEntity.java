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
 * Music MV
 * 数据库通用Controls实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@TableName("yinlemv")
public class YinlemvEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YinlemvEntity() {
		
	}
	
	public YinlemvEntity(T t) {
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
	 * mv name
	 */
					
	private String mvmingcheng;
	
	/**
	 * Music classification
	 */
					
	private String yinlefenlei;
	
	/**
	 * Singer name
	 */
					
	private String geshouxingming;
	
	/**
	 * video
	 */
					
	private String shipin;
	
	/**
	 * Release date
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date faburiqi;
	
	/**
	 * lyric details
	 */
					
	private String gecixiangqing;
	
	/**
	 * cover picture
	 */
					
	private String fengmiantupian;
	
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
	 * 设置：mv name
	 */
	public void setMvmingcheng(String mvmingcheng) {
		this.mvmingcheng = mvmingcheng;
	}
	/**
	 * 获取：mv name
	 */
	public String getMvmingcheng() {
		return mvmingcheng;
	}
	/**
	 * 设置：Music classification
	 */
	public void setYinlefenlei(String yinlefenlei) {
		this.yinlefenlei = yinlefenlei;
	}
	/**
	 * 获取：Music classification
	 */
	public String getYinlefenlei() {
		return yinlefenlei;
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
	 * 设置：video
	 */
	public void setShipin(String shipin) {
		this.shipin = shipin;
	}
	/**
	 * 获取：video
	 */
	public String getShipin() {
		return shipin;
	}
	/**
	 * 设置：Release date
	 */
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	/**
	 * 获取：Release date
	 */
	public Date getFaburiqi() {
		return faburiqi;
	}
	/**
	 * 设置：lyric details
	 */
	public void setGecixiangqing(String gecixiangqing) {
		this.gecixiangqing = gecixiangqing;
	}
	/**
	 * 获取：lyric details
	 */
	public String getGecixiangqing() {
		return gecixiangqing;
	}
	/**
	 * 设置：cover picture
	 */
	public void setFengmiantupian(String fengmiantupian) {
		this.fengmiantupian = fengmiantupian;
	}
	/**
	 * 获取：cover picture
	 */
	public String getFengmiantupian() {
		return fengmiantupian;
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
