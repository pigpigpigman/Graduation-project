package com.entity.vo;

import com.entity.LepingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Music review INFO
 * 手机端接口return实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public class LepingxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
