package com.dao;

import com.entity.YinlebangdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinlebangdanVO;
import com.entity.view.YinlebangdanView;


/**
 * Music charts
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface YinlebangdanDao extends BaseMapper<YinlebangdanEntity> {
	
	List<YinlebangdanVO> selectListVO(@Param("ew") Wrapper<YinlebangdanEntity> wrapper);
	
	YinlebangdanVO selectVO(@Param("ew") Wrapper<YinlebangdanEntity> wrapper);
	
	List<YinlebangdanView> selectListView(@Param("ew") Wrapper<YinlebangdanEntity> wrapper);

	List<YinlebangdanView> selectListView(Pagination page,@Param("ew") Wrapper<YinlebangdanEntity> wrapper);
	
	YinlebangdanView selectView(@Param("ew") Wrapper<YinlebangdanEntity> wrapper);
	

}
