package com.dao;

import com.entity.DiscussyinlezhuanjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyinlezhuanjiVO;
import com.entity.view.DiscussyinlezhuanjiView;


/**
 * Music album review表
 * 
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscussyinlezhuanjiDao extends BaseMapper<DiscussyinlezhuanjiEntity> {
	
	List<DiscussyinlezhuanjiVO> selectListVO(@Param("ew") Wrapper<DiscussyinlezhuanjiEntity> wrapper);
	
	DiscussyinlezhuanjiVO selectVO(@Param("ew") Wrapper<DiscussyinlezhuanjiEntity> wrapper);
	
	List<DiscussyinlezhuanjiView> selectListView(@Param("ew") Wrapper<DiscussyinlezhuanjiEntity> wrapper);

	List<DiscussyinlezhuanjiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyinlezhuanjiEntity> wrapper);
	
	DiscussyinlezhuanjiView selectView(@Param("ew") Wrapper<DiscussyinlezhuanjiEntity> wrapper);
	

}
