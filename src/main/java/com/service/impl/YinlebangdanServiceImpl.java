package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YinlebangdanDao;
import com.entity.YinlebangdanEntity;
import com.service.YinlebangdanService;
import com.entity.vo.YinlebangdanVO;
import com.entity.view.YinlebangdanView;

@Service("yinlebangdanService")
public class YinlebangdanServiceImpl extends ServiceImpl<YinlebangdanDao, YinlebangdanEntity> implements YinlebangdanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinlebangdanEntity> page = this.selectPage(
                new Query<YinlebangdanEntity>(params).getPage(),
                new EntityWrapper<YinlebangdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinlebangdanEntity> wrapper) {
		  Page<YinlebangdanView> page =new Query<YinlebangdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YinlebangdanVO> selectListVO(Wrapper<YinlebangdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinlebangdanVO selectVO(Wrapper<YinlebangdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinlebangdanView> selectListView(Wrapper<YinlebangdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinlebangdanView selectView(Wrapper<YinlebangdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
