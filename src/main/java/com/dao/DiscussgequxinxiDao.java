package com.dao;

import com.entity.DiscussgequxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgequxinxiVO;
import com.entity.view.DiscussgequxinxiView;


/**
 * Song INFO review表
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscussgequxinxiDao extends BaseMapper<DiscussgequxinxiEntity> {
	
	List<DiscussgequxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussgequxinxiEntity> wrapper);
	
	DiscussgequxinxiVO selectVO(@Param("ew") Wrapper<DiscussgequxinxiEntity> wrapper);
	
	List<DiscussgequxinxiView> selectListView(@Param("ew") Wrapper<DiscussgequxinxiEntity> wrapper);

	List<DiscussgequxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgequxinxiEntity> wrapper);
	
	DiscussgequxinxiView selectView(@Param("ew") Wrapper<DiscussgequxinxiEntity> wrapper);
	

}
