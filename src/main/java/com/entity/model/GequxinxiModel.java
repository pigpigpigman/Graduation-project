package com.entity.model;

import com.entity.GequxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * Song INFO
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model name
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public class GequxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
