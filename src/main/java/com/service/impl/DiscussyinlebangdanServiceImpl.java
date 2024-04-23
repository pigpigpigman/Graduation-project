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


import com.dao.DiscussyinlebangdanDao;
import com.entity.DiscussyinlebangdanEntity;
import com.service.DiscussyinlebangdanService;
import com.entity.vo.DiscussyinlebangdanVO;
import com.entity.view.DiscussyinlebangdanView;

@Service("discussyinlebangdanService")
public class DiscussyinlebangdanServiceImpl extends ServiceImpl<DiscussyinlebangdanDao, DiscussyinlebangdanEntity> implements DiscussyinlebangdanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyinlebangdanEntity> page = this.selectPage(
                new Query<DiscussyinlebangdanEntity>(params).getPage(),
                new EntityWrapper<DiscussyinlebangdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyinlebangdanEntity> wrapper) {
		  Page<DiscussyinlebangdanView> page =new Query<DiscussyinlebangdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyinlebangdanVO> selectListVO(Wrapper<DiscussyinlebangdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyinlebangdanVO selectVO(Wrapper<DiscussyinlebangdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyinlebangdanView> selectListView(Wrapper<DiscussyinlebangdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyinlebangdanView selectView(Wrapper<DiscussyinlebangdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
