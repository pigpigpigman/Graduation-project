package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LepingxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LepingxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LepingxinxiView;


/**
 * Music review INFO
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface LepingxinxiService extends IService<LepingxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LepingxinxiVO> selectListVO(Wrapper<LepingxinxiEntity> wrapper);
   	
   	LepingxinxiVO selectVO(@Param("ew") Wrapper<LepingxinxiEntity> wrapper);
   	
   	List<LepingxinxiView> selectListView(Wrapper<LepingxinxiEntity> wrapper);
   	
   	LepingxinxiView selectView(@Param("ew") Wrapper<LepingxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LepingxinxiEntity> wrapper);
   	

}

