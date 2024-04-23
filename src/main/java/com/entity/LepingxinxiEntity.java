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
 * Music review INFO
 * 数据库通用Controls实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@TableName("lepingxinxi")
public class LepingxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LepingxinxiEntity() {
		
	}
	
	public LepingxinxiEntity(T t) {
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
	 *  user Account number
	 */
					
	private String yonghuzhanghao;
	
	/**
	 *  user  name
	 */
					
	private String yonghuxingming;
	
	/**
	 * album name
	 */
					
	private String zhuanjimingcheng;
	
	/**
	 * Song name
	 */
					
	private String songname;
	
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
	 * evaluate
	 */
					
	private String pingjia;
	
	/**
	 * Music review time
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date lepingshijian;
	
	/**
	 * Music review content
	 */
					
	private String lepingneirong;
	
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
	 * 设置： user Account number
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取： user Account number
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
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
	 * 设置：evaluate
	 */
	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}
	/**
	 * 获取：evaluate
	 */
	public String getPingjia() {
		return pingjia;
	}
	/**
	 * 设置：Music review time
	 */
	public void setLepingshijian(Date lepingshijian) {
		this.lepingshijian = lepingshijian;
	}
	/**
	 * 获取：Music review time
	 */
	public Date getLepingshijian() {
		return lepingshijian;
	}
	/**
	 * 设置：Music review content
	 */
	public void setLepingneirong(String lepingneirong) {
		this.lepingneirong = lepingneirong;
	}
	/**
	 * 获取：Music review content
	 */
	public String getLepingneirong() {
		return lepingneirong;
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
