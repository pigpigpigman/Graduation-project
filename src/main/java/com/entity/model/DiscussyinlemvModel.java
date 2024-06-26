package com.entity.model;

import com.entity.DiscussyinlemvEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * Music MV review表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model name
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public class DiscussyinlemvModel  implements Serializable {
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
