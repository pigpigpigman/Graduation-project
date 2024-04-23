package com.dao;

import com.entity.DiscusslepingxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusslepingxinxiVO;
import com.entity.view.DiscusslepingxinxiView;


/**
 * Music review INFO review表
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscusslepingxinxiDao extends BaseMapper<DiscusslepingxinxiEntity> {
	
	List<DiscusslepingxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusslepingxinxiEntity> wrapper);
	
	DiscusslepingxinxiVO selectVO(@Param("ew") Wrapper<DiscusslepingxinxiEntity> wrapper);
	
	List<DiscusslepingxinxiView> selectListView(@Param("ew") Wrapper<DiscusslepingxinxiEntity> wrapper);

	List<DiscusslepingxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusslepingxinxiEntity> wrapper);
	
	DiscusslepingxinxiView selectView(@Param("ew") Wrapper<DiscusslepingxinxiEntity> wrapper);
	

}
