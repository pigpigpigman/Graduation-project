package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinlebangdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinlebangdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinlebangdanView;


/**
 * Music charts
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface YinlebangdanService extends IService<YinlebangdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinlebangdanVO> selectListVO(Wrapper<YinlebangdanEntity> wrapper);
   	
   	YinlebangdanVO selectVO(@Param("ew") Wrapper<YinlebangdanEntity> wrapper);
   	
   	List<YinlebangdanView> selectListView(Wrapper<YinlebangdanEntity> wrapper);
   	
   	YinlebangdanView selectView(@Param("ew") Wrapper<YinlebangdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinlebangdanEntity> wrapper);
   	

}

