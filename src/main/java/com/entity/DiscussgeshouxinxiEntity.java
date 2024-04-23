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
 * Singer INFO review表
 * 数据库通用Controls实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
@TableName("discussgeshouxinxi")
public class DiscussgeshouxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DiscussgeshouxinxiEntity() {
		
	}
	
	public DiscussgeshouxinxiEntity(T t) {
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
	 * 关联表id
	 */
					
	private Long refid;
	
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
	 * 设置：关联表id
	 */
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	/**
	 * 获取：关联表id
	 */
	public Long getRefid() {
		return refid;
	}
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
