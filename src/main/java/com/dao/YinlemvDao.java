package com.dao;

import com.entity.YinlemvEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinlemvVO;
import com.entity.view.YinlemvView;


/**
 * Music MV
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface YinlemvDao extends BaseMapper<YinlemvEntity> {
	
	List<YinlemvVO> selectListVO(@Param("ew") Wrapper<YinlemvEntity> wrapper);
	
	YinlemvVO selectVO(@Param("ew") Wrapper<YinlemvEntity> wrapper);
	
	List<YinlemvView> selectListView(@Param("ew") Wrapper<YinlemvEntity> wrapper);

	List<YinlemvView> selectListView(Pagination page,@Param("ew") Wrapper<YinlemvEntity> wrapper);
	
	YinlemvView selectView(@Param("ew") Wrapper<YinlemvEntity> wrapper);
	

}
