package com.dao;

import com.entity.DiscussyinlebangdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyinlebangdanVO;
import com.entity.view.DiscussyinlebangdanView;


/**
 * Music charts review表
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscussyinlebangdanDao extends BaseMapper<DiscussyinlebangdanEntity> {
	
	List<DiscussyinlebangdanVO> selectListVO(@Param("ew") Wrapper<DiscussyinlebangdanEntity> wrapper);
	
	DiscussyinlebangdanVO selectVO(@Param("ew") Wrapper<DiscussyinlebangdanEntity> wrapper);
	
	List<DiscussyinlebangdanView> selectListView(@Param("ew") Wrapper<DiscussyinlebangdanEntity> wrapper);

	List<DiscussyinlebangdanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyinlebangdanEntity> wrapper);
	
	DiscussyinlebangdanView selectView(@Param("ew") Wrapper<DiscussyinlebangdanEntity> wrapper);
	

}
