package com.dao;

import com.entity.DiscussyinlemvEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyinlemvVO;
import com.entity.view.DiscussyinlemvView;


/**
 * Music MV review表
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscussyinlemvDao extends BaseMapper<DiscussyinlemvEntity> {
	
	List<DiscussyinlemvVO> selectListVO(@Param("ew") Wrapper<DiscussyinlemvEntity> wrapper);
	
	DiscussyinlemvVO selectVO(@Param("ew") Wrapper<DiscussyinlemvEntity> wrapper);
	
	List<DiscussyinlemvView> selectListView(@Param("ew") Wrapper<DiscussyinlemvEntity> wrapper);

	List<DiscussyinlemvView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyinlemvEntity> wrapper);
	
	DiscussyinlemvView selectView(@Param("ew") Wrapper<DiscussyinlemvEntity> wrapper);
	

}
