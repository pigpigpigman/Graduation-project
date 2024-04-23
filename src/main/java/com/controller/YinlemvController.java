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

import com.entity.YinlemvEntity;
import com.entity.view.YinlemvView;

import com.service.YinlemvService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * Music MV
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@RestController
@RequestMapping("/yinlemv")
public class YinlemvController {
    @Autowired
    private YinlemvService yinlemvService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinlemvEntity yinlemv, 
		HttpServletRequest request){

        EntityWrapper<YinlemvEntity> ew = new EntityWrapper<YinlemvEntity>();


		PageUtils page = yinlemvService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlemv), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinlemvEntity yinlemv, 
		HttpServletRequest request){
        EntityWrapper<YinlemvEntity> ew = new EntityWrapper<YinlemvEntity>();

		PageUtils page = yinlemvService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlemv), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinlemvEntity yinlemv){
       	EntityWrapper<YinlemvEntity> ew = new EntityWrapper<YinlemvEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinlemv, "yinlemv")); 
        return R.ok().put("data", yinlemvService.selectListView(ew));
    }

	 /**
     * inquire
     */
    @RequestMapping("/query")
    public R query(YinlemvEntity yinlemv){
        EntityWrapper< YinlemvEntity> ew = new EntityWrapper< YinlemvEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinlemv, "yinlemv")); 
		YinlemvView yinlemvView =  yinlemvService.selectView(ew);
		return R.ok("inquireMusic MV succeed").put("data", yinlemvView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinlemvEntity yinlemv = yinlemvService.selectById(id);
        return R.ok().put("data", yinlemv);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinlemvEntity yinlemv = yinlemvService.selectById(id);
        return R.ok().put("data", yinlemv);
    }
    


    /**
     *  praise或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        YinlemvEntity yinlemv = yinlemvService.selectById(id);
        if(type.equals("1")) {
        	yinlemv.setThumbsupnum(yinlemv.getThumbsupnum()+1);
        } else {
        	yinlemv.setCrazilynum(yinlemv.getCrazilynum()+1);
        }
        yinlemvService.updateById(yinlemv);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinlemvEntity yinlemv, HttpServletRequest request){
    	yinlemv.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinlemv);

        yinlemvService.insert(yinlemv);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinlemvEntity yinlemv, HttpServletRequest request){
    	yinlemv.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinlemv);

        yinlemvService.insert(yinlemv);
        return R.ok();
    }


    /**
     * edit
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinlemvEntity yinlemv, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlemv);
        yinlemvService.updateById(yinlemv);//AllRenewal
        return R.ok();
    }
    
    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinlemvService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YinlemvEntity> wrapper = new EntityWrapper<YinlemvEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = yinlemvService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
