package com.dao;

import com.entity.NiandubangdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NiandubangdanVO;
import com.entity.view.NiandubangdanView;


/**
 * Annual list
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface NiandubangdanDao extends BaseMapper<NiandubangdanEntity> {
	
	List<NiandubangdanVO> selectListVO(@Param("ew") Wrapper<NiandubangdanEntity> wrapper);
	
	NiandubangdanVO selectVO(@Param("ew") Wrapper<NiandubangdanEntity> wrapper);
	
	List<NiandubangdanView> selectListView(@Param("ew") Wrapper<NiandubangdanEntity> wrapper);

	List<NiandubangdanView> selectListView(Pagination page,@Param("ew") Wrapper<NiandubangdanEntity> wrapper);
	
	NiandubangdanView selectView(@Param("ew") Wrapper<NiandubangdanEntity> wrapper);
	

}
