package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyinlemvEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyinlemvVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyinlemvView;


/**
 * Music MV review表
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscussyinlemvService extends IService<DiscussyinlemvEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyinlemvVO> selectListVO(Wrapper<DiscussyinlemvEntity> wrapper);
   	
   	DiscussyinlemvVO selectVO(@Param("ew") Wrapper<DiscussyinlemvEntity> wrapper);
   	
   	List<DiscussyinlemvView> selectListView(Wrapper<DiscussyinlemvEntity> wrapper);
   	
   	DiscussyinlemvView selectView(@Param("ew") Wrapper<DiscussyinlemvEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyinlemvEntity> wrapper);
   	

}

