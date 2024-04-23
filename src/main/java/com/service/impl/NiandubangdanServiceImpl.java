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


import com.dao.NiandubangdanDao;
import com.entity.NiandubangdanEntity;
import com.service.NiandubangdanService;
import com.entity.vo.NiandubangdanVO;
import com.entity.view.NiandubangdanView;

@Service("niandubangdanService")
public class NiandubangdanServiceImpl extends ServiceImpl<NiandubangdanDao, NiandubangdanEntity> implements NiandubangdanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NiandubangdanEntity> page = this.selectPage(
                new Query<NiandubangdanEntity>(params).getPage(),
                new EntityWrapper<NiandubangdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NiandubangdanEntity> wrapper) {
		  Page<NiandubangdanView> page =new Query<NiandubangdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NiandubangdanVO> selectListVO(Wrapper<NiandubangdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NiandubangdanVO selectVO(Wrapper<NiandubangdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NiandubangdanView> selectListView(Wrapper<NiandubangdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NiandubangdanView selectView(Wrapper<NiandubangdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
