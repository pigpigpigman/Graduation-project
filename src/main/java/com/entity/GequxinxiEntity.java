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
 * Song INFO
 * 数据库通用Controls实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@TableName("gequxinxi")
public class GequxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GequxinxiEntity() {
		
	}
	
	public GequxinxiEntity(T t) {
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
	 * Song name
	 */
					
	private String songname;
	
	/**
	 * Music classification
	 */
					
	private String yinlefenlei;
	
	/**
	 * cover
	 */
					
	private String fengmian;
	
	/**
	 * Singer
	 */
					
	private String singer;
	
	/**
	 * Language
	 */
					
	private String yuyan;
	
	/**
	 * Music file
	 */
					
	private String songfile;
	
	/**
	 * album
	 */
					
	private String zhuanji;
	
	/**
	 * duration
	 */
					
	private String shizhang;
	
	/**
	 * issuer
	 */
					
	private String faxingfang;
	
	/**
	 * Song introduction
	 */
					
	private String gequjianjie;
	
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
	 * 设置：Language
	 */
	public void setYuyan(String yuyan) {
		this.yuyan = yuyan;
	}
	/**
	 * 获取：Language
	 */
	public String getYuyan() {
		return yuyan;
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
	 * 设置：album
	 */
	public void setZhuanji(String zhuanji) {
		this.zhuanji = zhuanji;
	}
	/**
	 * 获取：album
	 */
	public String getZhuanji() {
		return zhuanji;
	}
	/**
	 * 设置：duration
	 */
	public void setShizhang(String shizhang) {
		this.shizhang = shizhang;
	}
	/**
	 * 获取：duration
	 */
	public String getShizhang() {
		return shizhang;
	}
	/**
	 * 设置：issuer
	 */
	public void setFaxingfang(String faxingfang) {
		this.faxingfang = faxingfang;
	}
	/**
	 * 获取：issuer
	 */
	public String getFaxingfang() {
		return faxingfang;
	}
	/**
	 * 设置：Song introduction
	 */
	public void setGequjianjie(String gequjianjie) {
		this.gequjianjie = gequjianjie;
	}
	/**
	 * 获取：Song introduction
	 */
	public String getGequjianjie() {
		return gequjianjie;
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
