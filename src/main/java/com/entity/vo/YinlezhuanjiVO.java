package com.entity.vo;

import com.entity.YinlezhuanjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Music album
 * 手机端接口return实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public class YinlezhuanjiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
