package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusslepingxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusslepingxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusslepingxinxiView;


/**
 * Music review INFO review表
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscusslepingxinxiService extends IService<DiscusslepingxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusslepingxinxiVO> selectListVO(Wrapper<DiscusslepingxinxiEntity> wrapper);
   	
   	DiscusslepingxinxiVO selectVO(@Param("ew") Wrapper<DiscusslepingxinxiEntity> wrapper);
   	
   	List<DiscusslepingxinxiView> selectListView(Wrapper<DiscusslepingxinxiEntity> wrapper);
   	
   	DiscusslepingxinxiView selectView(@Param("ew") Wrapper<DiscusslepingxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusslepingxinxiEntity> wrapper);
   	

}

