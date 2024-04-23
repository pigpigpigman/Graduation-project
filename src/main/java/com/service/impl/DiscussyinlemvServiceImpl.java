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


import com.dao.DiscussyinlemvDao;
import com.entity.DiscussyinlemvEntity;
import com.service.DiscussyinlemvService;
import com.entity.vo.DiscussyinlemvVO;
import com.entity.view.DiscussyinlemvView;

@Service("discussyinlemvService")
public class DiscussyinlemvServiceImpl extends ServiceImpl<DiscussyinlemvDao, DiscussyinlemvEntity> implements DiscussyinlemvService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyinlemvEntity> page = this.selectPage(
                new Query<DiscussyinlemvEntity>(params).getPage(),
                new EntityWrapper<DiscussyinlemvEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyinlemvEntity> wrapper) {
		  Page<DiscussyinlemvView> page =new Query<DiscussyinlemvView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyinlemvVO> selectListVO(Wrapper<DiscussyinlemvEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyinlemvVO selectVO(Wrapper<DiscussyinlemvEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyinlemvView> selectListView(Wrapper<DiscussyinlemvEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyinlemvView selectView(Wrapper<DiscussyinlemvEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
