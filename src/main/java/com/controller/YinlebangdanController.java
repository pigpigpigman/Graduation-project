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

import com.entity.YinlebangdanEntity;
import com.entity.view.YinlebangdanView;

import com.service.YinlebangdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * Music charts
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@RestController
@RequestMapping("/yinlebangdan")
public class YinlebangdanController {
    @Autowired
    private YinlebangdanService yinlebangdanService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinlebangdanEntity yinlebangdan, 
		HttpServletRequest request){

        EntityWrapper<YinlebangdanEntity> ew = new EntityWrapper<YinlebangdanEntity>();


		PageUtils page = yinlebangdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlebangdan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinlebangdanEntity yinlebangdan, 
		HttpServletRequest request){
        EntityWrapper<YinlebangdanEntity> ew = new EntityWrapper<YinlebangdanEntity>();

		PageUtils page = yinlebangdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlebangdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinlebangdanEntity yinlebangdan){
       	EntityWrapper<YinlebangdanEntity> ew = new EntityWrapper<YinlebangdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinlebangdan, "yinlebangdan")); 
        return R.ok().put("data", yinlebangdanService.selectListView(ew));
    }

	 /**
     * inquire
     */
    @RequestMapping("/query")
    public R query(YinlebangdanEntity yinlebangdan){
        EntityWrapper< YinlebangdanEntity> ew = new EntityWrapper< YinlebangdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinlebangdan, "yinlebangdan")); 
		YinlebangdanView yinlebangdanView =  yinlebangdanService.selectView(ew);
		return R.ok("inquireMusic charts succeed").put("data", yinlebangdanView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinlebangdanEntity yinlebangdan = yinlebangdanService.selectById(id);
        return R.ok().put("data", yinlebangdan);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinlebangdanEntity yinlebangdan = yinlebangdanService.selectById(id);
        return R.ok().put("data", yinlebangdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinlebangdanEntity yinlebangdan, HttpServletRequest request){
    	yinlebangdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinlebangdan);

        yinlebangdanService.insert(yinlebangdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinlebangdanEntity yinlebangdan, HttpServletRequest request){
    	yinlebangdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinlebangdan);

        yinlebangdanService.insert(yinlebangdan);
        return R.ok();
    }


    /**
     * edit
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinlebangdanEntity yinlebangdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlebangdan);
        yinlebangdanService.updateById(yinlebangdan);//AllRenewal
        return R.ok();
    }
    
    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinlebangdanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YinlebangdanEntity> wrapper = new EntityWrapper<YinlebangdanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = yinlebangdanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


    /**
     * 协同算法（按 Collect Recommended）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YinlebangdanEntity yinlebangdan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "yinlefenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "yinlebangdan").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<YinlebangdanEntity> yinlebangdanList = new ArrayList<YinlebangdanEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                yinlebangdanList.addAll(yinlebangdanService.selectList(new EntityWrapper<YinlebangdanEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<YinlebangdanEntity> ew = new EntityWrapper<YinlebangdanEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = yinlebangdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlebangdan), params), params));
        List<YinlebangdanEntity> pageList = (List<YinlebangdanEntity>)page.getList();
        if(yinlebangdanList.size()<limit) {
            int toAddNum = (limit-yinlebangdanList.size())<=pageList.size()?(limit-yinlebangdanList.size()):pageList.size();
            for(YinlebangdanEntity o1 : pageList) {
                boolean addFlag = true;
                for(YinlebangdanEntity o2 : yinlebangdanList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    yinlebangdanList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(yinlebangdanList.size()>limit) {
            yinlebangdanList = yinlebangdanList.subList(0, limit);
        }
        page.setList(yinlebangdanList);
        return R.ok().put("data", page);
    }







}
