package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussniandubangdanEntity;
import com.entity.view.DiscussniandubangdanView;

import com.service.DiscussniandubangdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * Annual list review表
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
@RestController
@RequestMapping("/discussniandubangdan")
public class DiscussniandubangdanController {
    @Autowired
    private DiscussniandubangdanService discussniandubangdanService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussniandubangdanEntity discussniandubangdan, 
		HttpServletRequest request){

        EntityWrapper<DiscussniandubangdanEntity> ew = new EntityWrapper<DiscussniandubangdanEntity>();


		PageUtils page = discussniandubangdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussniandubangdan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussniandubangdanEntity discussniandubangdan, 
		HttpServletRequest request){
        EntityWrapper<DiscussniandubangdanEntity> ew = new EntityWrapper<DiscussniandubangdanEntity>();

		PageUtils page = discussniandubangdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussniandubangdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussniandubangdanEntity discussniandubangdan){
       	EntityWrapper<DiscussniandubangdanEntity> ew = new EntityWrapper<DiscussniandubangdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussniandubangdan, "discussniandubangdan")); 
        return R.ok().put("data", discussniandubangdanService.selectListView(ew));
    }

	 /**
     * inquire
     */
    @RequestMapping("/query")
    public R query(DiscussniandubangdanEntity discussniandubangdan){
        EntityWrapper< DiscussniandubangdanEntity> ew = new EntityWrapper< DiscussniandubangdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussniandubangdan, "discussniandubangdan")); 
		DiscussniandubangdanView discussniandubangdanView =  discussniandubangdanService.selectView(ew);
		return R.ok("inquireAnnual list review表 succeed").put("data", discussniandubangdanView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussniandubangdanEntity discussniandubangdan = discussniandubangdanService.selectById(id);
        return R.ok().put("data", discussniandubangdan);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussniandubangdanEntity discussniandubangdan = discussniandubangdanService.selectById(id);
        return R.ok().put("data", discussniandubangdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussniandubangdanEntity discussniandubangdan, HttpServletRequest request){
    	discussniandubangdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussniandubangdan);

        discussniandubangdanService.insert(discussniandubangdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussniandubangdanEntity discussniandubangdan, HttpServletRequest request){
    	discussniandubangdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussniandubangdan);

        discussniandubangdanService.insert(discussniandubangdan);
        return R.ok();
    }


    /**
     * edit
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussniandubangdanEntity discussniandubangdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussniandubangdan);
        discussniandubangdanService.updateById(discussniandubangdan);//AllRenewal
        return R.ok();
    }
    
    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussniandubangdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussniandubangdanEntity> wrapper = new EntityWrapper<DiscussniandubangdanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussniandubangdanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
