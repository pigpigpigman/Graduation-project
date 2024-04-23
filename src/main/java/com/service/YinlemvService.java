package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinlemvEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinlemvVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinlemvView;


/**
 * Music MV
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface YinlemvService extends IService<YinlemvEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinlemvVO> selectListVO(Wrapper<YinlemvEntity> wrapper);
   	
   	YinlemvVO selectVO(@Param("ew") Wrapper<YinlemvEntity> wrapper);
   	
   	List<YinlemvView> selectListView(Wrapper<YinlemvEntity> wrapper);
   	
   	YinlemvView selectView(@Param("ew") Wrapper<YinlemvEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinlemvEntity> wrapper);
   	

}

