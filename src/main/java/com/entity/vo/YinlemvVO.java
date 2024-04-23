package com.entity.vo;

import com.entity.YinlemvEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Music MV
 * 手机端接口return实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public class YinlemvVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
