package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyinlezhuanjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyinlezhuanjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyinlezhuanjiView;


/**
 * Music album review表
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscussyinlezhuanjiService extends IService<DiscussyinlezhuanjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyinlezhuanjiVO> selectListVO(Wrapper<DiscussyinlezhuanjiEntity> wrapper);
   	
   	DiscussyinlezhuanjiVO selectVO(@Param("ew") Wrapper<DiscussyinlezhuanjiEntity> wrapper);
   	
   	List<DiscussyinlezhuanjiView> selectListView(Wrapper<DiscussyinlezhuanjiEntity> wrapper);
   	
   	DiscussyinlezhuanjiView selectView(@Param("ew") Wrapper<DiscussyinlezhuanjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyinlezhuanjiEntity> wrapper);
   	

}

