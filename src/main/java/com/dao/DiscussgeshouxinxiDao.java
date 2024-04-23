package com.dao;

import com.entity.DiscussgeshouxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgeshouxinxiVO;
import com.entity.view.DiscussgeshouxinxiView;


/**
 * Singer INFO review表
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscussgeshouxinxiDao extends BaseMapper<DiscussgeshouxinxiEntity> {
	
	List<DiscussgeshouxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussgeshouxinxiEntity> wrapper);
	
	DiscussgeshouxinxiVO selectVO(@Param("ew") Wrapper<DiscussgeshouxinxiEntity> wrapper);
	
	List<DiscussgeshouxinxiView> selectListView(@Param("ew") Wrapper<DiscussgeshouxinxiEntity> wrapper);

	List<DiscussgeshouxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgeshouxinxiEntity> wrapper);
	
	DiscussgeshouxinxiView selectView(@Param("ew") Wrapper<DiscussgeshouxinxiEntity> wrapper);
	

}
