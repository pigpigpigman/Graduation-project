package com.dao;

import com.entity.LepingxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LepingxinxiVO;
import com.entity.view.LepingxinxiView;


/**
 * Music review INFO
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface LepingxinxiDao extends BaseMapper<LepingxinxiEntity> {
	
	List<LepingxinxiVO> selectListVO(@Param("ew") Wrapper<LepingxinxiEntity> wrapper);
	
	LepingxinxiVO selectVO(@Param("ew") Wrapper<LepingxinxiEntity> wrapper);
	
	List<LepingxinxiView> selectListView(@Param("ew") Wrapper<LepingxinxiEntity> wrapper);

	List<LepingxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<LepingxinxiEntity> wrapper);
	
	LepingxinxiView selectView(@Param("ew") Wrapper<LepingxinxiEntity> wrapper);
	

}
