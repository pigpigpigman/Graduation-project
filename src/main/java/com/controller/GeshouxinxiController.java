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

import com.entity.GeshouxinxiEntity;
import com.entity.view.GeshouxinxiView;

import com.service.GeshouxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * Singer INFO
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@RestController
@RequestMapping("/geshouxinxi")
public class GeshouxinxiController {
    @Autowired
    private GeshouxinxiService geshouxinxiService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GeshouxinxiEntity geshouxinxi, 
		HttpServletRequest request){

        EntityWrapper<GeshouxinxiEntity> ew = new EntityWrapper<GeshouxinxiEntity>();


		PageUtils page = geshouxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, geshouxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GeshouxinxiEntity geshouxinxi, 
		HttpServletRequest request){
        EntityWrapper<GeshouxinxiEntity> ew = new EntityWrapper<GeshouxinxiEntity>();

		PageUtils page = geshouxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, geshouxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GeshouxinxiEntity geshouxinxi){
       	EntityWrapper<GeshouxinxiEntity> ew = new EntityWrapper<GeshouxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( geshouxinxi, "geshouxinxi")); 
        return R.ok().put("data", geshouxinxiService.selectListView(ew));
    }

	 /**
     * inquire
     */
    @RequestMapping("/query")
    public R query(GeshouxinxiEntity geshouxinxi){
        EntityWrapper< GeshouxinxiEntity> ew = new EntityWrapper< GeshouxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( geshouxinxi, "geshouxinxi")); 
		GeshouxinxiView geshouxinxiView =  geshouxinxiService.selectView(ew);
		return R.ok("inquireSinger INFO succeed").put("data", geshouxinxiView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GeshouxinxiEntity geshouxinxi = geshouxinxiService.selectById(id);
        return R.ok().put("data", geshouxinxi);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GeshouxinxiEntity geshouxinxi = geshouxinxiService.selectById(id);
        return R.ok().put("data", geshouxinxi);
    }
    


    /**
     *  praise或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        GeshouxinxiEntity geshouxinxi = geshouxinxiService.selectById(id);
        if(type.equals("1")) {
        	geshouxinxi.setThumbsupnum(geshouxinxi.getThumbsupnum()+1);
        } else {
        	geshouxinxi.setCrazilynum(geshouxinxi.getCrazilynum()+1);
        }
        geshouxinxiService.updateById(geshouxinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GeshouxinxiEntity geshouxinxi, HttpServletRequest request){
    	geshouxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(geshouxinxi);

        geshouxinxiService.insert(geshouxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GeshouxinxiEntity geshouxinxi, HttpServletRequest request){
    	geshouxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(geshouxinxi);

        geshouxinxiService.insert(geshouxinxi);
        return R.ok();
    }


    /**
     * edit
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GeshouxinxiEntity geshouxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(geshouxinxi);
        geshouxinxiService.updateById(geshouxinxi);//AllRenewal
        return R.ok();
    }
    
    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        geshouxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GeshouxinxiEntity> wrapper = new EntityWrapper<GeshouxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = geshouxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
