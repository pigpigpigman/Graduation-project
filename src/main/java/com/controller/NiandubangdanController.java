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

import com.entity.NiandubangdanEntity;
import com.entity.view.NiandubangdanView;

import com.service.NiandubangdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * Annual list
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@RestController
@RequestMapping("/niandubangdan")
public class NiandubangdanController {
    @Autowired
    private NiandubangdanService niandubangdanService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NiandubangdanEntity niandubangdan, 
		HttpServletRequest request){

        EntityWrapper<NiandubangdanEntity> ew = new EntityWrapper<NiandubangdanEntity>();


		PageUtils page = niandubangdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, niandubangdan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NiandubangdanEntity niandubangdan, 
		HttpServletRequest request){
        EntityWrapper<NiandubangdanEntity> ew = new EntityWrapper<NiandubangdanEntity>();

		PageUtils page = niandubangdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, niandubangdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NiandubangdanEntity niandubangdan){
       	EntityWrapper<NiandubangdanEntity> ew = new EntityWrapper<NiandubangdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( niandubangdan, "niandubangdan")); 
        return R.ok().put("data", niandubangdanService.selectListView(ew));
    }

	 /**
     * inquire
     */
    @RequestMapping("/query")
    public R query(NiandubangdanEntity niandubangdan){
        EntityWrapper< NiandubangdanEntity> ew = new EntityWrapper< NiandubangdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( niandubangdan, "niandubangdan")); 
		NiandubangdanView niandubangdanView =  niandubangdanService.selectView(ew);
		return R.ok("inquireAnnual list succeed").put("data", niandubangdanView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NiandubangdanEntity niandubangdan = niandubangdanService.selectById(id);
        return R.ok().put("data", niandubangdan);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NiandubangdanEntity niandubangdan = niandubangdanService.selectById(id);
        return R.ok().put("data", niandubangdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NiandubangdanEntity niandubangdan, HttpServletRequest request){
    	niandubangdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(niandubangdan);

        niandubangdanService.insert(niandubangdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NiandubangdanEntity niandubangdan, HttpServletRequest request){
    	niandubangdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(niandubangdan);

        niandubangdanService.insert(niandubangdan);
        return R.ok();
    }


    /**
     * edit
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NiandubangdanEntity niandubangdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(niandubangdan);
        niandubangdanService.updateById(niandubangdan);//AllRenewal
        return R.ok();
    }
    
    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        niandubangdanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<NiandubangdanEntity> wrapper = new EntityWrapper<NiandubangdanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = niandubangdanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


    /**
     * 协同算法（按 Collect Recommended）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,NiandubangdanEntity niandubangdan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "yinlefenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "niandubangdan").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<NiandubangdanEntity> niandubangdanList = new ArrayList<NiandubangdanEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                niandubangdanList.addAll(niandubangdanService.selectList(new EntityWrapper<NiandubangdanEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<NiandubangdanEntity> ew = new EntityWrapper<NiandubangdanEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = niandubangdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, niandubangdan), params), params));
        List<NiandubangdanEntity> pageList = (List<NiandubangdanEntity>)page.getList();
        if(niandubangdanList.size()<limit) {
            int toAddNum = (limit-niandubangdanList.size())<=pageList.size()?(limit-niandubangdanList.size()):pageList.size();
            for(NiandubangdanEntity o1 : pageList) {
                boolean addFlag = true;
                for(NiandubangdanEntity o2 : niandubangdanList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    niandubangdanList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(niandubangdanList.size()>limit) {
            niandubangdanList = niandubangdanList.subList(0, limit);
        }
        page.setList(niandubangdanList);
        return R.ok().put("data", page);
    }







}
