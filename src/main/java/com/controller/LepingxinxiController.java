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

import com.entity.LepingxinxiEntity;
import com.entity.view.LepingxinxiView;

import com.service.LepingxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * Music review INFO
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@RestController
@RequestMapping("/lepingxinxi")
public class LepingxinxiController {
    @Autowired
    private LepingxinxiService lepingxinxiService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LepingxinxiEntity lepingxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			lepingxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LepingxinxiEntity> ew = new EntityWrapper<LepingxinxiEntity>();


		PageUtils page = lepingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lepingxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LepingxinxiEntity lepingxinxi, 
		HttpServletRequest request){
        EntityWrapper<LepingxinxiEntity> ew = new EntityWrapper<LepingxinxiEntity>();

		PageUtils page = lepingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lepingxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LepingxinxiEntity lepingxinxi){
       	EntityWrapper<LepingxinxiEntity> ew = new EntityWrapper<LepingxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lepingxinxi, "lepingxinxi")); 
        return R.ok().put("data", lepingxinxiService.selectListView(ew));
    }

	 /**
     * inquire
     */
    @RequestMapping("/query")
    public R query(LepingxinxiEntity lepingxinxi){
        EntityWrapper< LepingxinxiEntity> ew = new EntityWrapper< LepingxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lepingxinxi, "lepingxinxi")); 
		LepingxinxiView lepingxinxiView =  lepingxinxiService.selectView(ew);
		return R.ok("inquireMusic review INFO succeed").put("data", lepingxinxiView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LepingxinxiEntity lepingxinxi = lepingxinxiService.selectById(id);
        return R.ok().put("data", lepingxinxi);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LepingxinxiEntity lepingxinxi = lepingxinxiService.selectById(id);
        return R.ok().put("data", lepingxinxi);
    }
    


    /**
     *  praise或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        LepingxinxiEntity lepingxinxi = lepingxinxiService.selectById(id);
        if(type.equals("1")) {
        	lepingxinxi.setThumbsupnum(lepingxinxi.getThumbsupnum()+1);
        } else {
        	lepingxinxi.setCrazilynum(lepingxinxi.getCrazilynum()+1);
        }
        lepingxinxiService.updateById(lepingxinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LepingxinxiEntity lepingxinxi, HttpServletRequest request){
    	lepingxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lepingxinxi);

        lepingxinxiService.insert(lepingxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody LepingxinxiEntity lepingxinxi, HttpServletRequest request){
    	lepingxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lepingxinxi);

        lepingxinxiService.insert(lepingxinxi);
        return R.ok();
    }


    /**
     * edit
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LepingxinxiEntity lepingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lepingxinxi);
        lepingxinxiService.updateById(lepingxinxi);//AllRenewal
        return R.ok();
    }
    
    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lepingxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<LepingxinxiEntity> wrapper = new EntityWrapper<LepingxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = lepingxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
