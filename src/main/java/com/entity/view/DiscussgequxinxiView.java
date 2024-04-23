package com.entity.view;

import com.entity.DiscussgequxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Song INFO review表
 * 后端return视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要return使用）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
@TableName("discussgequxinxi")
public class DiscussgequxinxiView  extends DiscussgequxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussgequxinxiView(){
	}
 
 	public DiscussgequxinxiView(DiscussgequxinxiEntity discussgequxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussgequxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
