package com.entity.vo;

import com.entity.NiandubangdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Annual list
 * 手机端接口return实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public class NiandubangdanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date faxingriqi;
		
	/**
	 * lyric 
	 */
	
	private String geci;
				
	
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
