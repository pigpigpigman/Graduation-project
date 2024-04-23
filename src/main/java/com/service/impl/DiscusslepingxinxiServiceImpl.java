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


import com.dao.DiscusslepingxinxiDao;
import com.entity.DiscusslepingxinxiEntity;
import com.service.DiscusslepingxinxiService;
import com.entity.vo.DiscusslepingxinxiVO;
import com.entity.view.DiscusslepingxinxiView;

@Service("discusslepingxinxiService")
public class DiscusslepingxinxiServiceImpl extends ServiceImpl<DiscusslepingxinxiDao, DiscusslepingxinxiEntity> implements DiscusslepingxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusslepingxinxiEntity> page = this.selectPage(
                new Query<DiscusslepingxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusslepingxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusslepingxinxiEntity> wrapper) {
		  Page<DiscusslepingxinxiView> page =new Query<DiscusslepingxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusslepingxinxiVO> selectListVO(Wrapper<DiscusslepingxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusslepingxinxiVO selectVO(Wrapper<DiscusslepingxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusslepingxinxiView> selectListView(Wrapper<DiscusslepingxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusslepingxinxiView selectView(Wrapper<DiscusslepingxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
