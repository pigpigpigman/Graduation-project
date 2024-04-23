package com.entity.view;

import com.entity.GeshouxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * Singer INFO
 * 后端return视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要return使用）
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@TableName("geshouxinxi")
public class GeshouxinxiView  extends GeshouxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GeshouxinxiView(){
	}
 
 	public GeshouxinxiView(GeshouxinxiEntity geshouxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, geshouxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
