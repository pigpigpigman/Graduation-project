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
 * Annual list
 * 数据库通用Controls实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@TableName("niandubangdan")
public class NiandubangdanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public NiandubangdanEntity() {
		
	}
	
	public NiandubangdanEntity(T t) {
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
	 * Year
	 */
					
	private String nianfen;
	
	/**
	 * view counts
	 */
					
	private Integer bofangliang;
	
	/**
	 * Song name
	 */
					
	private String songname;
	
	/**
	 * Song name
	 */
					
	private String gequmingcheng;
	
	/**
	 * Singer
	 */
					
	private String singer;
	
	/**
	 * Music classification
	 */
					
	private String yinlefenlei;
	
	/**
	 * cover
	 */
					
	private String fengmian;
	
	/**
	 * Music file
	 */
					
	private String songfile;
	
	/**
	 * album name
	 */
					
	private String zhuanjimingcheng;
	
	/**
	 * Issue date
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date faxingriqi;
	
	/**
	 * lyric 
	 */
					
	private String geci;
	
	
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
	 * 设置：Year
	 */
	public void setNianfen(String nianfen) {
		this.nianfen = nianfen;
	}
	/**
	 * 获取：Year
	 */
	public String getNianfen() {
		return nianfen;
	}
	/**
	 * 设置：view counts
	 */
	public void setBofangliang(Integer bofangliang) {
		this.bofangliang = bofangliang;
	}
	/**
	 * 获取：view counts
	 */
	public Integer getBofangliang() {
		return bofangliang;
	}
	/**
	 * 设置：Song name
	 */
	public void setSongname(String songname) {
		this.songname = songname;
	}
	/**
	 * 获取：Song name
	 */
	public String getSongname() {
		return songname;
	}
	/**
	 * 设置：Song name
	 */
	public void setGequmingcheng(String gequmingcheng) {
		this.gequmingcheng = gequmingcheng;
	}
	/**
	 * 获取：Song name
	 */
	public String getGequmingcheng() {
		return gequmingcheng;
	}
	/**
	 * 设置：Singer
	 */
	public void setSinger(String singer) {
		this.singer = singer;
	}
	/**
	 * 获取：Singer
	 */
	public String getSinger() {
		return singer;
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
	 * 设置：cover
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：cover
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：Music file
	 */
	public void setSongfile(String songfile) {
		this.songfile = songfile;
	}
	/**
	 * 获取：Music file
	 */
	public String getSongfile() {
		return songfile;
	}
	/**
	 * 设置：album name
	 */
	public void setZhuanjimingcheng(String zhuanjimingcheng) {
		this.zhuanjimingcheng = zhuanjimingcheng;
	}
	/**
	 * 获取：album name
	 */
	public String getZhuanjimingcheng() {
		return zhuanjimingcheng;
	}
	/**
	 * 设置：Issue date
	 */
	public void setFaxingriqi(Date faxingriqi) {
		this.faxingriqi = faxingriqi;
	}
	/**
	 * 获取：Issue date
	 */
	public Date getFaxingriqi() {
		return faxingriqi;
	}
	/**
	 * 设置：lyric 
	 */
	public void setGeci(String geci) {
		this.geci = geci;
	}
	/**
	 * 获取：lyric 
	 */
	public String getGeci() {
		return geci;
	}

}
