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
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.plugins.Page;
import com.entity.DiscussgequxinxiEntity;
import com.entity.YonghuEntity;
import com.service.*;
import com.utils.*;
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

import com.entity.GequxinxiEntity;
import com.entity.view.GequxinxiView;

import com.entity.StoreupEntity;

/**
 * Song INFO
 * 后端接口
 * @author 
 * @email 
 * @date 2030-04-15 21:24:15
 */
@RestController
@RequestMapping("/gequxinxi")
public class GequxinxiController {
    @Autowired
    private GequxinxiService gequxinxiService;



    @Autowired
    private StoreupService storeupService;


    @Autowired
    private DiscussgequxinxiService discussgequxinxiService;


    @Autowired
    private YonghuService yonghuService;


    /**
     * 后端列表
     */
    @RequestMapping("/tuijian")
    public R tuijian(@RequestParam Map<String, Object> params,GequxinxiEntity lingshixinxi,
                     HttpServletRequest request){

        List<GequxinxiEntity> lingshixinxiEntities = gequxinxiService.selectList(null);
        List<Long> lingshiids = lingshixinxiEntities.stream().map(GequxinxiEntity::getId).collect(Collectors.toList());
        List<YonghuEntity> yonghuEntities = yonghuService.selectList(null);
        List<Long> yonghuids = yonghuEntities.stream().map(YonghuEntity::getId).collect(Collectors.toList());
        double[][] pingfenjuzheng = new double[yonghuids.size()][lingshiids.size()];


        // 初始化二维数组
        for (int i = 0; i < lingshiids.size(); i++) {
            for (int j = 0; j < yonghuids.size(); j++) {
                pingfenjuzheng[i][j] = 0;
            }
        }

        // 打印二维数组
        for (double[] row : pingfenjuzheng) {
            for (double num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        List<DiscussgequxinxiEntity> discussgequxinxiEntities = discussgequxinxiService
                .selectList(null);
        for (int i = 0 ; i < discussgequxinxiEntities.size() ; i ++){
            DiscussgequxinxiEntity storeupEntity  = discussgequxinxiEntities.get(i);
            Long goodid = storeupEntity.getRefid();
            Long userid = storeupEntity.getUserid();
            int i2 = lingshiids.indexOf(goodid);
            int i1 = yonghuids.indexOf(userid);

            pingfenjuzheng[i1][i2] = pingfenjuzheng[i1][i2]+1;
        }


        List<StoreupEntity> storeupEntities = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type",1).eq("tablename","gequxinxi"));
        for (int i = 0 ; i < storeupEntities.size() ; i ++){
            StoreupEntity storeupEntity  = storeupEntities.get(i);
            Long goodid = storeupEntity.getRefid();
            Long userid = storeupEntity.getUserid();
            int i2 = lingshiids.indexOf(goodid);
            int i1 = yonghuids.indexOf(userid);

            pingfenjuzheng[i1][i2] = pingfenjuzheng[i1][i2]+1;
        }




        List<StoreupEntity> dianzanEntities = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type",21).eq("tablename","gequxinxi"));
        for (int i = 0 ; i < dianzanEntities.size() ; i ++){
            StoreupEntity storeupEntity  = dianzanEntities.get(i);
            Long goodid = storeupEntity.getRefid();
            Long userid = storeupEntity.getUserid();
            int i2 = lingshiids.indexOf(goodid);
            int i1 = yonghuids.indexOf(userid);

            pingfenjuzheng[i1][i2] = pingfenjuzheng[i1][i2]+1;
        }

        List<StoreupEntity> buxihuanEntities = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type",22).eq("tablename","gequxinxi"));
        for (int i = 0 ; i < buxihuanEntities.size() ; i ++){
            StoreupEntity storeupEntity  = buxihuanEntities.get(i);
            Long goodid = storeupEntity.getRefid();
            Long userid = storeupEntity.getUserid();
            int i2 = lingshiids.indexOf(goodid);
            int i1 = yonghuids.indexOf(userid);
            if(pingfenjuzheng[i1][i2] >0.5){
                pingfenjuzheng[i1][i2] = pingfenjuzheng[i1][i2]-1*0.5;
            }
        }










        Long userId = (Long)request.getSession().getAttribute("userId");
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);








        // 打印二维数组
        for (double[] row : pingfenjuzheng) {
            for (double num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }


        List<Integer> recommend = CollaborativeFiltering.recommend(yonghuids.indexOf(userId), pingfenjuzheng);

        double[] tuijianshangpin = new double[yonghuids.size()];
        for(int i = 0 ; i < yonghuids.size() ; i ++){
            tuijianshangpin[i] = 0;
        }
        for(int i = 0; i < recommend.size() ; i ++){
            double[] temp = pingfenjuzheng[recommend.get(i)];

            //两个数组相加
            for (int j = 0; j < tuijianshangpin.length; j++) {
                tuijianshangpin[j] = tuijianshangpin[j] + temp[j];
            }
        }

        List<Integer> shangpin_index = new ArrayList<>();
        for (int i = 0 ; i < tuijianshangpin.length ; i ++){

            if(tuijianshangpin[i]>0.1){
                shangpin_index.add(i);
            }
        }


        List<Long> tuijianid = new ArrayList<>();
        for(int i = 0 ; i < shangpin_index.size() ; i++){

            Long aLong = lingshiids.get(shangpin_index.get(i));
            tuijianid.add(aLong);
        }
        List<GequxinxiEntity> lingshixinxiEntities1 = new ArrayList<>();

        if(tuijianid.size()>0){
            lingshixinxiEntities1 = gequxinxiService.selectBatchIds(tuijianid);
        }

        Page<GequxinxiEntity> page =new Query<GequxinxiEntity>(params).getPage();
        page.setRecords(lingshixinxiEntities1);
        PageUtils pageUtil = new PageUtils(page);
        return R.ok().put("data", pageUtil);
    }



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GequxinxiEntity gequxinxi, 
		HttpServletRequest request){

        EntityWrapper<GequxinxiEntity> ew = new EntityWrapper<GequxinxiEntity>();


		PageUtils page = gequxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GequxinxiEntity gequxinxi, 
		HttpServletRequest request){
        EntityWrapper<GequxinxiEntity> ew = new EntityWrapper<GequxinxiEntity>();

		PageUtils page = gequxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GequxinxiEntity gequxinxi){
       	EntityWrapper<GequxinxiEntity> ew = new EntityWrapper<GequxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gequxinxi, "gequxinxi")); 
        return R.ok().put("data", gequxinxiService.selectListView(ew));
    }

	 /**
     * inquire
     */
    @RequestMapping("/query")
    public R query(GequxinxiEntity gequxinxi){
        EntityWrapper< GequxinxiEntity> ew = new EntityWrapper< GequxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gequxinxi, "gequxinxi")); 
		GequxinxiView gequxinxiView =  gequxinxiService.selectView(ew);
		return R.ok("inquireSong INFO succeed").put("data", gequxinxiView);
    }
	
    /**
     * 后端details
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GequxinxiEntity gequxinxi = gequxinxiService.selectById(id);
        return R.ok().put("data", gequxinxi);
    }

    /**
     * 前端details
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GequxinxiEntity gequxinxi = gequxinxiService.selectById(id);
        return R.ok().put("data", gequxinxi);
    }
    


    /**
     *  praise或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        GequxinxiEntity gequxinxi = gequxinxiService.selectById(id);
        if(type.equals("1")) {
        	gequxinxi.setThumbsupnum(gequxinxi.getThumbsupnum()+1);
        } else {
        	gequxinxi.setCrazilynum(gequxinxi.getCrazilynum()+1);
        }
        gequxinxiService.updateById(gequxinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GequxinxiEntity gequxinxi, HttpServletRequest request){
    	gequxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gequxinxi);

        gequxinxiService.insert(gequxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody GequxinxiEntity gequxinxi, HttpServletRequest request){
    	gequxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gequxinxi);

        gequxinxiService.insert(gequxinxi);
        return R.ok();
    }


    /**
     * edit
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GequxinxiEntity gequxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gequxinxi);
        gequxinxiService.updateById(gequxinxi);//AllRenewal
        return R.ok();
    }
    
    

    /**
     * delete
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gequxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GequxinxiEntity> wrapper = new EntityWrapper<GequxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = gequxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


    /**
     * 协同算法（按 Collect Recommended）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,GequxinxiEntity gequxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "yinlefenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "gequxinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<GequxinxiEntity> gequxinxiList = new ArrayList<GequxinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                gequxinxiList.addAll(gequxinxiService.selectList(new EntityWrapper<GequxinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<GequxinxiEntity> ew = new EntityWrapper<GequxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = gequxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequxinxi), params), params));
        List<GequxinxiEntity> pageList = (List<GequxinxiEntity>)page.getList();
        if(gequxinxiList.size()<limit) {
            int toAddNum = (limit-gequxinxiList.size())<=pageList.size()?(limit-gequxinxiList.size()):pageList.size();
            for(GequxinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(GequxinxiEntity o2 : gequxinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    gequxinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(gequxinxiList.size()>limit) {
            gequxinxiList = gequxinxiList.subList(0, limit);
        }
        page.setList(gequxinxiList);
        return R.ok().put("data", page);
    }







}
