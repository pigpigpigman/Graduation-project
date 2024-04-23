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


import com.dao.DiscussyinlezhuanjiDao;
import com.entity.DiscussyinlezhuanjiEntity;
import com.service.DiscussyinlezhuanjiService;
import com.entity.vo.DiscussyinlezhuanjiVO;
import com.entity.view.DiscussyinlezhuanjiView;

@Service("discussyinlezhuanjiService")
public class DiscussyinlezhuanjiServiceImpl extends ServiceImpl<DiscussyinlezhuanjiDao, DiscussyinlezhuanjiEntity> implements DiscussyinlezhuanjiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyinlezhuanjiEntity> page = this.selectPage(
                new Query<DiscussyinlezhuanjiEntity>(params).getPage(),
                new EntityWrapper<DiscussyinlezhuanjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyinlezhuanjiEntity> wrapper) {
		  Page<DiscussyinlezhuanjiView> page =new Query<DiscussyinlezhuanjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyinlezhuanjiVO> selectListVO(Wrapper<DiscussyinlezhuanjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyinlezhuanjiVO selectVO(Wrapper<DiscussyinlezhuanjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyinlezhuanjiView> selectListView(Wrapper<DiscussyinlezhuanjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyinlezhuanjiView selectView(Wrapper<DiscussyinlezhuanjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
