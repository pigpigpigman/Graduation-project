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

import com.entity.DiscussyinlemvEntity;
import com.entity.view.DiscussyinlemvView;

import com.service.DiscussyinlemvService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * Music MV review表
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-15 21:24:16
 */
@RestController
@RequestMapping("/discussyinlemv")
public class DiscussyinlemvController {
    @Autowired
    private DiscussyinlemvService discussyinlemvService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyinlemvEntity discussyinlemv, 
		HttpServletRequest request){

        EntityWrapper<DiscussyinlemvEntity> ew = new EntityWrapper<DiscussyinlemvEntity>();


		PageUtils page = discussyinlemvService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyinlemv), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussyinlemvEntity discussyinlemv, 
		HttpServletRequest request){
        EntityWrapper<DiscussyinlemvEntity> ew = new EntityWrapper<DiscussyinlemvEntity>();

		PageUtils page = discussyinlemvService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyinlemv), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyinlemvEntity discussyinlemv){
       	EntityWrapper<DiscussyinlemvEntity> ew = new EntityWrapper<DiscussyinlemvEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyinlemv, "discussyinlemv")); 
        return R.ok().put("data", discussyinlemvService.selectListView(ew));
    }

	 /**
     * inquire
     */
    @RequestMapping("/query")
    public R query(DiscussyinlemvEntity discussyinlemv){
        EntityWrapper< DiscussyinlemvEntity> ew = new EntityWrapper< DiscussyinlemvEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyinlemv, "discussyinlemv")); 
		DiscussyinlemvView discussyinlemvView =  discussyinlemvService.selectView(ew);
		return R.ok("inquireMusic MV review表 succeed").put("data", discussyinlemvView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyinlemvEntity discussyinlemv = discussyinlemvService.selectById(id);
        return R.ok().put("data", discussyinlemv);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyinlemvEntity discussyinlemv = discussyinlemvService.selectById(id);
        return R.ok().put("data", discussyinlemv);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyinlemvEntity discussyinlemv, HttpServletRequest request){
    	discussyinlemv.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussyinlemv);

        discussyinlemvService.insert(discussyinlemv);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyinlemvEntity discussyinlemv, HttpServletRequest request){
    	discussyinlemv.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussyinlemv);

        discussyinlemvService.insert(discussyinlemv);
        return R.ok();
    }


    /**
     * edit
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussyinlemvEntity discussyinlemv, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyinlemv);
        discussyinlemvService.updateById(discussyinlemv);//AllRenewal
        return R.ok();
    }
    
    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyinlemvService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscussyinlemvEntity> wrapper = new EntityWrapper<DiscussyinlemvEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussyinlemvService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
