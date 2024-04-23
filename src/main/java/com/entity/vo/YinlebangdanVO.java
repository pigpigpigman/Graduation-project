package com.entity.vo;

import com.entity.YinlebangdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Music charts
 * 手机端接口return实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public class YinlebangdanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * Song name
	 */
	
	private String gequmingcheng;
		
	/**
	 * Music classification
	 */
	
	private String yinlefenlei;
		
	/**
	 * Singer
	 */
	
	private String geshou;
		
	/**
	 * cover
	 */
	
	private String fengmian;
		
	/**
	 * album name
	 */
	
	private String zhuanjimingcheng;
		
	/**
	 * play back
	 */
	
	private String bofang;
		
	/**
	 * Issue date
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date faxingriqi;
		
	/**
	 * lyric 
	 */
	
	private String geci;
				
	
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
	 
	public void setGeshou(String geshou) {
		this.geshou = geshou;
	}
	
	/**
	 * 获取：Singer
	 */
	public String getGeshou() {
		return geshou;
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
	 * 设置：play back
	 */
	 
	public void setBofang(String bofang) {
		this.bofang = bofang;
	}
	
	/**
	 * 获取：play back
	 */
	public String getBofang() {
		return bofang;
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
