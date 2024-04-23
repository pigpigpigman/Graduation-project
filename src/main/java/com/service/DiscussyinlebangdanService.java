package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyinlebangdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyinlebangdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyinlebangdanView;


/**
 * Music charts review表
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
public interface DiscussyinlebangdanService extends IService<DiscussyinlebangdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyinlebangdanVO> selectListVO(Wrapper<DiscussyinlebangdanEntity> wrapper);
   	
   	DiscussyinlebangdanVO selectVO(@Param("ew") Wrapper<DiscussyinlebangdanEntity> wrapper);
   	
   	List<DiscussyinlebangdanView> selectListView(Wrapper<DiscussyinlebangdanEntity> wrapper);
   	
   	DiscussyinlebangdanView selectView(@Param("ew") Wrapper<DiscussyinlebangdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyinlebangdanEntity> wrapper);
   	

}

