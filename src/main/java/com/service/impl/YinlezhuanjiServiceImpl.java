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


import com.dao.YinlezhuanjiDao;
import com.entity.YinlezhuanjiEntity;
import com.service.YinlezhuanjiService;
import com.entity.vo.YinlezhuanjiVO;
import com.entity.view.YinlezhuanjiView;

@Service("yinlezhuanjiService")
public class YinlezhuanjiServiceImpl extends ServiceImpl<YinlezhuanjiDao, YinlezhuanjiEntity> implements YinlezhuanjiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinlezhuanjiEntity> page = this.selectPage(
                new Query<YinlezhuanjiEntity>(params).getPage(),
                new EntityWrapper<YinlezhuanjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinlezhuanjiEntity> wrapper) {
		  Page<YinlezhuanjiView> page =new Query<YinlezhuanjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YinlezhuanjiVO> selectListVO(Wrapper<YinlezhuanjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinlezhuanjiVO selectVO(Wrapper<YinlezhuanjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinlezhuanjiView> selectListView(Wrapper<YinlezhuanjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinlezhuanjiView selectView(Wrapper<YinlezhuanjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
