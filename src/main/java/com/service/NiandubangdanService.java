package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NiandubangdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NiandubangdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NiandubangdanView;


/**
 * Annual list
 *
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
public interface NiandubangdanService extends IService<NiandubangdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NiandubangdanVO> selectListVO(Wrapper<NiandubangdanEntity> wrapper);
   	
   	NiandubangdanVO selectVO(@Param("ew") Wrapper<NiandubangdanEntity> wrapper);
   	
   	List<NiandubangdanView> selectListView(Wrapper<NiandubangdanEntity> wrapper);
   	
   	NiandubangdanView selectView(@Param("ew") Wrapper<NiandubangdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NiandubangdanEntity> wrapper);
   	

}

