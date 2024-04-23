package com.dao;

import com.entity.DiscussniandubangdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussniandubangdanVO;
import com.entity.view.DiscussniandubangdanView;


/**
 * Annual list review表
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscussniandubangdanDao extends BaseMapper<DiscussniandubangdanEntity> {
	
	List<DiscussniandubangdanVO> selectListVO(@Param("ew") Wrapper<DiscussniandubangdanEntity> wrapper);
	
	DiscussniandubangdanVO selectVO(@Param("ew") Wrapper<DiscussniandubangdanEntity> wrapper);
	
	List<DiscussniandubangdanView> selectListView(@Param("ew") Wrapper<DiscussniandubangdanEntity> wrapper);

	List<DiscussniandubangdanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussniandubangdanEntity> wrapper);
	
	DiscussniandubangdanView selectView(@Param("ew") Wrapper<DiscussniandubangdanEntity> wrapper);
	

}
