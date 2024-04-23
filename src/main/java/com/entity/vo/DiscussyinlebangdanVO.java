package com.entity.vo;

import com.entity.DiscussyinlebangdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * Music charts review表
 * 手机端接口return实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public class DiscussyinlebangdanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 *  user id
	 */
	
	private Long userid;
		
	/**
	 * avatar
	 */
	
	private String avatarurl;
		
	/**
	 *  user name
	 */
	
	private String nickname;
		
	/**
	 * Comment content
	 */
	
	private String content;
		
	/**
	 * Reply content
	 */
	
	private String reply;
				
	
	/**
	 * 设置： user id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取： user id
	 */
	public Long getUserid() {
		return userid;
	}
				
	
	/**
	 * 设置：avatar
	 */
	 
	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	
	/**
	 * 获取：avatar
	 */
	public String getAvatarurl() {
		return avatarurl;
	}
				
	
	/**
	 * 设置： user name
	 */
	 
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * 获取： user name
	 */
	public String getNickname() {
		return nickname;
	}
				
	
	/**
	 * 设置：Comment content
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：Comment content
	 */
	public String getContent() {
		return content;
	}
				
	
	/**
	 * 设置：Reply content
	 */
	 
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	/**
	 * 获取：Reply content
	 */
	public String getReply() {
		return reply;
	}
			
}
