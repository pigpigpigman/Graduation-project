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


import com.dao.DiscussniandubangdanDao;
import com.entity.DiscussniandubangdanEntity;
import com.service.DiscussniandubangdanService;
import com.entity.vo.DiscussniandubangdanVO;
import com.entity.view.DiscussniandubangdanView;

@Service("discussniandubangdanService")
public class DiscussniandubangdanServiceImpl extends ServiceImpl<DiscussniandubangdanDao, DiscussniandubangdanEntity> implements DiscussniandubangdanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussniandubangdanEntity> page = this.selectPage(
                new Query<DiscussniandubangdanEntity>(params).getPage(),
                new EntityWrapper<DiscussniandubangdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussniandubangdanEntity> wrapper) {
		  Page<DiscussniandubangdanView> page =new Query<DiscussniandubangdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussniandubangdanVO> selectListVO(Wrapper<DiscussniandubangdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussniandubangdanVO selectVO(Wrapper<DiscussniandubangdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussniandubangdanView> selectListView(Wrapper<DiscussniandubangdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussniandubangdanView selectView(Wrapper<DiscussniandubangdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
