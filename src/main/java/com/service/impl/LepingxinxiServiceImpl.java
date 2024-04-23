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


import com.dao.LepingxinxiDao;
import com.entity.LepingxinxiEntity;
import com.service.LepingxinxiService;
import com.entity.vo.LepingxinxiVO;
import com.entity.view.LepingxinxiView;

@Service("lepingxinxiService")
public class LepingxinxiServiceImpl extends ServiceImpl<LepingxinxiDao, LepingxinxiEntity> implements LepingxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LepingxinxiEntity> page = this.selectPage(
                new Query<LepingxinxiEntity>(params).getPage(),
                new EntityWrapper<LepingxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LepingxinxiEntity> wrapper) {
		  Page<LepingxinxiView> page =new Query<LepingxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LepingxinxiVO> selectListVO(Wrapper<LepingxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LepingxinxiVO selectVO(Wrapper<LepingxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LepingxinxiView> selectListView(Wrapper<LepingxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LepingxinxiView selectView(Wrapper<LepingxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
