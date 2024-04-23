package com.dao;

import com.entity.YinlezhuanjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinlezhuanjiVO;
import com.entity.view.YinlezhuanjiView;


/**
 * Music album
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface YinlezhuanjiDao extends BaseMapper<YinlezhuanjiEntity> {
	
	List<YinlezhuanjiVO> selectListVO(@Param("ew") Wrapper<YinlezhuanjiEntity> wrapper);
	
	YinlezhuanjiVO selectVO(@Param("ew") Wrapper<YinlezhuanjiEntity> wrapper);
	
	List<YinlezhuanjiView> selectListView(@Param("ew") Wrapper<YinlezhuanjiEntity> wrapper);

	List<YinlezhuanjiView> selectListView(Pagination page,@Param("ew") Wrapper<YinlezhuanjiEntity> wrapper);
	
	YinlezhuanjiView selectView(@Param("ew") Wrapper<YinlezhuanjiEntity> wrapper);
	

}
