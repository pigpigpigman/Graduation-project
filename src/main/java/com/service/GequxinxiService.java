package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GequxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GequxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GequxinxiView;


/**
 * Song INFO
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface GequxinxiService extends IService<GequxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GequxinxiVO> selectListVO(Wrapper<GequxinxiEntity> wrapper);
   	
   	GequxinxiVO selectVO(@Param("ew") Wrapper<GequxinxiEntity> wrapper);
   	
   	List<GequxinxiView> selectListView(Wrapper<GequxinxiEntity> wrapper);
   	
   	GequxinxiView selectView(@Param("ew") Wrapper<GequxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GequxinxiEntity> wrapper);
   	

}

