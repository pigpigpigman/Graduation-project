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


import com.dao.YinlemvDao;
import com.entity.YinlemvEntity;
import com.service.YinlemvService;
import com.entity.vo.YinlemvVO;
import com.entity.view.YinlemvView;

@Service("yinlemvService")
public class YinlemvServiceImpl extends ServiceImpl<YinlemvDao, YinlemvEntity> implements YinlemvService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinlemvEntity> page = this.selectPage(
                new Query<YinlemvEntity>(params).getPage(),
                new EntityWrapper<YinlemvEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinlemvEntity> wrapper) {
		  Page<YinlemvView> page =new Query<YinlemvView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YinlemvVO> selectListVO(Wrapper<YinlemvEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinlemvVO selectVO(Wrapper<YinlemvEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinlemvView> selectListView(Wrapper<YinlemvEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinlemvView selectView(Wrapper<YinlemvEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
