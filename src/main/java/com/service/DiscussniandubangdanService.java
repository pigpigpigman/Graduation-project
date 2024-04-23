package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussniandubangdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussniandubangdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussniandubangdanView;


/**
 * Annual list review表
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscussniandubangdanService extends IService<DiscussniandubangdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussniandubangdanVO> selectListVO(Wrapper<DiscussniandubangdanEntity> wrapper);
   	
   	DiscussniandubangdanVO selectVO(@Param("ew") Wrapper<DiscussniandubangdanEntity> wrapper);
   	
   	List<DiscussniandubangdanView> selectListView(Wrapper<DiscussniandubangdanEntity> wrapper);
   	
   	DiscussniandubangdanView selectView(@Param("ew") Wrapper<DiscussniandubangdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussniandubangdanEntity> wrapper);
   	

}

