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
 * Music album
 * 数据库通用Controls实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@TableName("yinlezhuanji")
public class YinlezhuanjiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YinlezhuanjiEntity() {
		
	}
	
	public YinlezhuanjiEntity(T t) {
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
	 * album name
	 */
					
	private String zhuanjimingcheng;
	
	/**
	 * Song name
	 */
					
	private String songname;
	
	/**
	 * Music classification
	 */
					
	private String yinlefenlei;
	
	/**
	 * Singer
	 */
					
	private String singer;
	
	/**
	 * cover
	 */
					
	private String fengmian;
	
	/**
	 * Music file
	 */
					
	private String songfile;
	
	/**
	 * Musical style
	 */
					
	private String yinlefengge;
	
	/**
	 * Issue time
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date faxingshijian;
	
	/**
	 * Album introduction
	 */
					
	private String zhuanjijieshao;
	
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
	 * 设置：Musical style
	 */
	public void setYinlefengge(String yinlefengge) {
		this.yinlefengge = yinlefengge;
	}
	/**
	 * 获取：Musical style
	 */
	public String getYinlefengge() {
		return yinlefengge;
	}
	/**
	 * 设置：Issue time
	 */
	public void setFaxingshijian(Date faxingshijian) {
		this.faxingshijian = faxingshijian;
	}
	/**
	 * 获取：Issue time
	 */
	public Date getFaxingshijian() {
		return faxingshijian;
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
