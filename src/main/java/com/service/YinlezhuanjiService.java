package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinlezhuanjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinlezhuanjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinlezhuanjiView;


/**
 * Music album
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface YinlezhuanjiService extends IService<YinlezhuanjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinlezhuanjiVO> selectListVO(Wrapper<YinlezhuanjiEntity> wrapper);
   	
   	YinlezhuanjiVO selectVO(@Param("ew") Wrapper<YinlezhuanjiEntity> wrapper);
   	
   	List<YinlezhuanjiView> selectListView(Wrapper<YinlezhuanjiEntity> wrapper);
   	
   	YinlezhuanjiView selectView(@Param("ew") Wrapper<YinlezhuanjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinlezhuanjiEntity> wrapper);
   	

}

