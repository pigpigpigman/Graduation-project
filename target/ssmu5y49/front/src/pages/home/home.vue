<template>
<div class="home-preview" :style='{"width":"100%","margin":"0px auto","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>






<div class="lists" :style='{"width":"100%","padding":"0px 7% 20px","margin":"0px auto","background":"#fff"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","padding":"0px 7%","margin":"0px auto 40px","lineHeight":"54px","textAlign":"center","background":"none"}'>
	  <span :style='{"padding":"0 0 20px","fontSize":"24px","color":"#202020","background":"url(http://codegen.caihongy.cn/20230111/0c17638871cf4d2ebd3ed6bc1131ba4c.png) no-repeat center bottom"}'>Singer INFO show</span>
	</div>
	
	
	
	
	<!-- 样式三 -->
	<div class="list list3 index-pv1">
		<div class="swiper-container" id="listsgeshouxinxi" :style='{"width":"100%","padding":"10px","background":"#fff","height":"auto"}'>
			<div class="swiper-wrapper">
				<div class="swiper-slide animation-box" :style='{"border":"0","fontSize":"0","position":"relative","borderRadius":"4px","background":"#fff"}' v-for="(item,index) in geshouxinxiList" :key="index" @click="toDetail('geshouxinxiDetail', item)">
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-if="preHttp(item.touxiang)" :src="item.touxiang.split(',')[0]" alt="" />
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-else :src="baseUrl + (item.touxiang?item.touxiang.split(',')[0]:'')" alt="" />
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.geshouxingming}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.geshouxingbie}}</div>
            </div>
        </div>
			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>
	
	
	
	
	
	
	
	<div @click="moreBtn('geshouxinxi')" :style='{"border":"0","margin":"0px auto 0px","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>view更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>
<div class="lists" :style='{"width":"100%","padding":"0px 7% 20px","margin":"0px auto","background":"#fff"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","padding":"0px 7%","margin":"0px auto 40px","lineHeight":"54px","textAlign":"center","background":"none"}'>
	  <span :style='{"padding":"0 0 20px","fontSize":"24px","color":"#202020","background":"url(http://codegen.caihongy.cn/20230111/0c17638871cf4d2ebd3ed6bc1131ba4c.png) no-repeat center bottom"}'>Song INFO show</span>
	</div>
	
	
	
	
	<!-- 样式三 -->
	<div class="list list3 index-pv1">
		<div class="swiper-container" id="listsgequxinxi" :style='{"width":"100%","padding":"10px","background":"#fff","height":"auto"}'>
			<div class="swiper-wrapper">
				<div class="swiper-slide animation-box" :style='{"border":"0","fontSize":"0","position":"relative","borderRadius":"4px","background":"#fff"}' v-for="(item,index) in gequxinxiList" :key="index" @click="toDetail('gequxinxiDetail', item)">
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.songname}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.yinlefenlei}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.singer}}</div>
            </div>
        </div>
			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>
	
	
	
	
	
	
	
	<div @click="moreBtn('gequxinxi')" :style='{"border":"0","margin":"0px auto 0px","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>view更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>
<div class="lists" :style='{"width":"100%","padding":"0px 7% 20px","margin":"0px auto","background":"#fff"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","padding":"0px 7%","margin":"0px auto 40px","lineHeight":"54px","textAlign":"center","background":"none"}'>
	  <span :style='{"padding":"0 0 20px","fontSize":"24px","color":"#202020","background":"url(http://codegen.caihongy.cn/20230111/0c17638871cf4d2ebd3ed6bc1131ba4c.png) no-repeat center bottom"}'>Music album show</span>
	</div>
	
	
	
	
	<!-- 样式三 -->
	<div class="list list3 index-pv1">
		<div class="swiper-container" id="listsyinlezhuanji" :style='{"width":"100%","padding":"10px","background":"#fff","height":"auto"}'>
			<div class="swiper-wrapper">
				<div class="swiper-slide animation-box" :style='{"border":"0","fontSize":"0","position":"relative","borderRadius":"4px","background":"#fff"}' v-for="(item,index) in yinlezhuanjiList" :key="index" @click="toDetail('yinlezhuanjiDetail', item)">
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.zhuanjimingcheng}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.songname}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.yinlefenlei}}</div>
            </div>
        </div>
			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>
	
	
	
	
	
	
	
	<div @click="moreBtn('yinlezhuanji')" :style='{"border":"0","margin":"0px auto 0px","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>view更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>
<div class="lists" :style='{"width":"100%","padding":"0px 7% 20px","margin":"0px auto","background":"#fff"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","padding":"0px 7%","margin":"0px auto 40px","lineHeight":"54px","textAlign":"center","background":"none"}'>
	  <span :style='{"padding":"0 0 20px","fontSize":"24px","color":"#202020","background":"url(http://codegen.caihongy.cn/20230111/0c17638871cf4d2ebd3ed6bc1131ba4c.png) no-repeat center bottom"}'>Music MV show</span>
	</div>
	
	
	
	
	<!-- 样式三 -->
	<div class="list list3 index-pv1">
		<div class="swiper-container" id="listsyinlemv" :style='{"width":"100%","padding":"10px","background":"#fff","height":"auto"}'>
			<div class="swiper-wrapper">
				<div class="swiper-slide animation-box" :style='{"border":"0","fontSize":"0","position":"relative","borderRadius":"4px","background":"#fff"}' v-for="(item,index) in yinlemvList" :key="index" @click="toDetail('yinlemvDetail', item)">
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-if="preHttp(item.fengmiantupian)" :src="item.fengmiantupian.split(',')[0]" alt="" />
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-else :src="baseUrl + (item.fengmiantupian?item.fengmiantupian.split(',')[0]:'')" alt="" />
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.mvmingcheng}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.geshouxingming}}</div>
            </div>
        </div>
			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>
	
	
	
	
	
	
	
	<div @click="moreBtn('yinlemv')" :style='{"border":"0","margin":"0px auto 0px","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>view更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>
<div class="lists" :style='{"width":"100%","padding":"0px 7% 20px","margin":"0px auto","background":"#fff"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","padding":"0px 7%","margin":"0px auto 40px","lineHeight":"54px","textAlign":"center","background":"none"}'>
	  <span :style='{"padding":"0 0 20px","fontSize":"24px","color":"#202020","background":"url(http://codegen.caihongy.cn/20230111/0c17638871cf4d2ebd3ed6bc1131ba4c.png) no-repeat center bottom"}'>Music review INFO show</span>
	</div>
	
	
	
	
	<!-- 样式三 -->
	<div class="list list3 index-pv1">
		<div class="swiper-container" id="listslepingxinxi" :style='{"width":"100%","padding":"10px","background":"#fff","height":"auto"}'>
			<div class="swiper-wrapper">
				<div class="swiper-slide animation-box" :style='{"border":"0","fontSize":"0","position":"relative","borderRadius":"4px","background":"#fff"}' v-for="(item,index) in lepingxinxiList" :key="index" @click="toDetail('lepingxinxiDetail', item)">
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.zhuanjimingcheng}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.songname}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.yinlefenlei}}</div>
            </div>
        </div>
			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>
	
	
	
	
	
	
	
	<div @click="moreBtn('lepingxinxi')" :style='{"border":"0","margin":"0px auto 0px","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>view更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>
<div class="lists" :style='{"width":"100%","padding":"0px 7% 20px","margin":"0px auto","background":"#fff"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","padding":"0px 7%","margin":"0px auto 40px","lineHeight":"54px","textAlign":"center","background":"none"}'>
	  <span :style='{"padding":"0 0 20px","fontSize":"24px","color":"#202020","background":"url(http://codegen.caihongy.cn/20230111/0c17638871cf4d2ebd3ed6bc1131ba4c.png) no-repeat center bottom"}'>Music charts show</span>
	</div>
	
	
	
	
	<!-- 样式三 -->
	<div class="list list3 index-pv1">
		<div class="swiper-container" id="listsyinlebangdan" :style='{"width":"100%","padding":"10px","background":"#fff","height":"auto"}'>
			<div class="swiper-wrapper">
				<div class="swiper-slide animation-box" :style='{"border":"0","fontSize":"0","position":"relative","borderRadius":"4px","background":"#fff"}' v-for="(item,index) in yinlebangdanList" :key="index" @click="toDetail('yinlebangdanDetail', item)">
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.gequmingcheng}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.yinlefenlei}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.geshou}}</div>
            </div>
        </div>
			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>
	
	
	
	
	
	
	
	<div @click="moreBtn('yinlebangdan')" :style='{"border":"0","margin":"0px auto 0px","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>view更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>
<div class="lists" :style='{"width":"100%","padding":"0px 7% 20px","margin":"0px auto","background":"#fff"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","padding":"0px 7%","margin":"0px auto 40px","lineHeight":"54px","textAlign":"center","background":"none"}'>
	  <span :style='{"padding":"0 0 20px","fontSize":"24px","color":"#202020","background":"url(http://codegen.caihongy.cn/20230111/0c17638871cf4d2ebd3ed6bc1131ba4c.png) no-repeat center bottom"}'>Annual list show</span>
	</div>
	
	
	
	
	<!-- 样式三 -->
	<div class="list list3 index-pv1">
		<div class="swiper-container" id="listsniandubangdan" :style='{"width":"100%","padding":"10px","background":"#fff","height":"auto"}'>
			<div class="swiper-wrapper">
				<div class="swiper-slide animation-box" :style='{"border":"0","fontSize":"0","position":"relative","borderRadius":"4px","background":"#fff"}' v-for="(item,index) in niandubangdanList" :key="index" @click="toDetail('niandubangdanDetail', item)">
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
					<img :name="item.id" :style='{"border":"0","width":"100%","height":"250px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.songname}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.gequmingcheng}}</div>
					<div class="name line1" :style='{"padding":"0 10px","fontSize":"14px","lineHeight":"32px","color":"#333"}'>{{item.yinlefenlei}}</div>
            </div>
        </div>
			<!-- 如果需要导航按钮 -->
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>
	
	
	
	
	
	
	
	<div @click="moreBtn('niandubangdan')" :style='{"border":"0","margin":"0px auto 0px","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>view更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>

	
<div class="news" :style='{"minHeight":"520px","padding":"20px 0 40px","margin":"0px auto 0px","flexWrap":"wrap","background":"url() no-repeat center top,#fff","display":"flex","width":"100%","position":"relative"}'>
	<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","padding":"0px 7%","margin":"20px auto 60px","lineHeight":"54px","textAlign":"center","background":"none"}'>
		<span :style='{"padding":"0 0 20px","fontSize":"24px","lineHeight":"40px","color":"#202020","background":"url(http://codegen.caihongy.cn/20230111/0c17638871cf4d2ebd3ed6bc1131ba4c.png) no-repeat center bottom","fontWeight":"bold"}'>Music INFO</span>
	</div>
	
	
	
	
	
	<!-- 样式四 -->
	<div v-if="newsList.length" class="list list4 index-pv1" :style='{"padding":"0px 0","margin":"0 7%","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative","justifyContent":"flex-end","height":"auto"}'>
	    <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="new-list-item animation-box" :style='{"padding":"0px","margin":"0 25px 0 0","background":"none","width":"48%","float":"right","height":"300px","order":"2"}'>
			<div :style='{"margin":"0 0 0px 10px","whiteSpace":"nowrap","overflow":"hidden","color":"#111","textAlign":"left","background":"none","fontSize":"20px","lineHeight":"32px","textOverflow":"ellipsis"}' class="new-list-item-title line1">{{newsList[0].title}}</div>
			<div :style='{"padding":"10px 10px","margin":"0 0 10px","overflow":"hidden","color":"#666","background":"none","fontSize":"14px","lineHeight":"24px","textIndent":"2em","height":"188px"}' class="descript  line3">{{newsList[0].introduction}}</div>
			<div :style='{"fontSize":"12px","color":"#666","textAlign":"right","display":"none"}' class="time">{{newsList[0].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="new-list-item animation-box" :style='{"width":"48%","float":"left","background":"rgba(255,255,255,.3)","height":"500px","order":"1"}'>
			<img :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + newsList[0].picture" alt="">
	    </div>
	    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new-list-item animation-box" :style='{"width":"390px","padding":"10px","background":"#f5f5f5","display":"none","height":"300px"}'>
			<div :style='{"margin":"0 0 10px","fontSize":"16px","color":"#333","textAlign":"center"}' class="new-list-item-title line1">{{newsList[1].title}}</div>
			<div :style='{"color":"#666","margin":"0 0 10px","fontSize":"14px"}' class="descript  line3">{{newsList[1].introduction}}</div>
			<div :style='{"color":"#999","textAlign":"right","fontSize":"12px"}' class="time">{{newsList[1].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new-list-item animation-box" :style='{"padding":"0 20px  0 0","margin":"0 0px 0 1%","background":"rgba(255,255,255,.3)","bottom":"0","width":"23%","position":"absolute","right":"25%","height":"200px","order":"3"}'>
			<img :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + newsList[1].picture" alt="">
	    </div>
	    <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new-list-item animation-box" :style='{"width":"390px","padding":"10px","background":"#f5f5f5","display":"none","height":"300px"}'>
			<div :style='{"margin":"0 0 10px","fontSize":"16px","color":"#333","textAlign":"center"}' class="new-list-item-title  line1">{{newsList[2].title}}</div>
			<div :style='{"color":"#666","margin":"0 0 10px","fontSize":"14px"}' class="descript  line3">{{newsList[2].introduction}}</div>
			<div :style='{"color":"#999","textAlign":"right","fontSize":"12px"}' class="time">{{newsList[2].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new-list-item animation-box" :style='{"background":"none","bottom":"0","width":"23%","position":"absolute","right":"0","height":"200px","order":"6"}'>
			<img :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + newsList[2].picture" alt="">
	    </div>
	</div>
	
	
	
	
	
	
	
	<div @click="moreBtn('news')" :style='{"border":"0","padding":"0 22px","margin":"0px auto 0px","top":"396px","textAlign":"center","left":"52%","background":"#000","display":"inline-block","width":"auto","lineHeight":"40px","position":"absolute"}'>
		<span :style='{"color":"#fff","fontSize":"12px"}'>view更多</span>
		<i v-if="true" :style='{"color":"#fff","fontSize":"12px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>

</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        newsList: [],

        geshouxinxiList: [],
        gequxinxiList: [],
        yinlezhuanjiList: [],
        yinlemvList: [],
        lepingxinxiList: [],
        yinlebangdanList: [],
        niandubangdanList: [],
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getNewsList();
      this.getList();
    },
    //方法集合
    methods: {
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
		getNewsList() {
			this.$http.get('news/list', {params: {
				page: 1,
				limit: 4,
			order: 'desc'}}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
          let autoSortUrl = "";
			
			this.$http.get('geshouxinxi/list', {params: {
				page: 1,
				limit: 12,
			}}).then(res => {
				if (res.data.code == 0) {
					this.geshouxinxiList = res.data.data.list;
					let options = {"observer":true,"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"observeParents":true,"loop":true,"slidesPerView":5,"speed":500,"spaceBetween":20,"autoplay":{"delay":3000,"disableOnInteraction":false}}
					options.pagination = {el:'null'}
					if(options.slidesPerView) {
						options.slidesPerView = Number(options.slidesPerView);
					}
					if(options.spaceBetween) {
						options.spaceBetween = Number(options.spaceBetween);
					}
					this.$nextTick(() => {
						new Swiper ('#listsgeshouxinxi', options)
					})
					
					// 商品列表样式五
					
				}
			});
			this.$http.get('gequxinxi/list', {params: {
				page: 1,
				limit: 12,
			}}).then(res => {
				if (res.data.code == 0) {
					this.gequxinxiList = res.data.data.list;
					let options = {"observer":true,"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"observeParents":true,"loop":true,"slidesPerView":5,"speed":500,"spaceBetween":20,"autoplay":{"delay":3000,"disableOnInteraction":false}}
					options.pagination = {el:'null'}
					if(options.slidesPerView) {
						options.slidesPerView = Number(options.slidesPerView);
					}
					if(options.spaceBetween) {
						options.spaceBetween = Number(options.spaceBetween);
					}
					this.$nextTick(() => {
						new Swiper ('#listsgequxinxi', options)
					})
					
					// 商品列表样式五
					
				}
			});
			this.$http.get('yinlezhuanji/list', {params: {
				page: 1,
				limit: 12,
			}}).then(res => {
				if (res.data.code == 0) {
					this.yinlezhuanjiList = res.data.data.list;
					let options = {"observer":true,"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"observeParents":true,"loop":true,"slidesPerView":5,"speed":500,"spaceBetween":20,"autoplay":{"delay":3000,"disableOnInteraction":false}}
					options.pagination = {el:'null'}
					if(options.slidesPerView) {
						options.slidesPerView = Number(options.slidesPerView);
					}
					if(options.spaceBetween) {
						options.spaceBetween = Number(options.spaceBetween);
					}
					this.$nextTick(() => {
						new Swiper ('#listsyinlezhuanji', options)
					})
					
					// 商品列表样式五
					
				}
			});
			this.$http.get('yinlemv/list', {params: {
				sort : 'faburiqi',
				order: 'desc',
				page: 1,
				limit: 12,
			}}).then(res => {
				if (res.data.code == 0) {
					this.yinlemvList = res.data.data.list;
					let options = {"observer":true,"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"observeParents":true,"loop":true,"slidesPerView":5,"speed":500,"spaceBetween":20,"autoplay":{"delay":3000,"disableOnInteraction":false}}
					options.pagination = {el:'null'}
					if(options.slidesPerView) {
						options.slidesPerView = Number(options.slidesPerView);
					}
					if(options.spaceBetween) {
						options.spaceBetween = Number(options.spaceBetween);
					}
					this.$nextTick(() => {
						new Swiper ('#listsyinlemv', options)
					})
					
					// 商品列表样式五
					
				}
			});
			this.$http.get('lepingxinxi/list', {params: {
				page: 1,
				limit: 12,
			}}).then(res => {
				if (res.data.code == 0) {
					this.lepingxinxiList = res.data.data.list;
					let options = {"observer":true,"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"observeParents":true,"loop":true,"slidesPerView":5,"speed":500,"spaceBetween":20,"autoplay":{"delay":3000,"disableOnInteraction":false}}
					options.pagination = {el:'null'}
					if(options.slidesPerView) {
						options.slidesPerView = Number(options.slidesPerView);
					}
					if(options.spaceBetween) {
						options.spaceBetween = Number(options.spaceBetween);
					}
					this.$nextTick(() => {
						new Swiper ('#listslepingxinxi', options)
					})
					
					// 商品列表样式五
					
				}
			});
			this.$http.get('yinlebangdan/list', {params: {
				sort : 'bofangliang',
				order: 'desc',
				page: 1,
				limit: 12,
			}}).then(res => {
				if (res.data.code == 0) {
					this.yinlebangdanList = res.data.data.list;
					let options = {"observer":true,"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"observeParents":true,"loop":true,"slidesPerView":5,"speed":500,"spaceBetween":20,"autoplay":{"delay":3000,"disableOnInteraction":false}}
					options.pagination = {el:'null'}
					if(options.slidesPerView) {
						options.slidesPerView = Number(options.slidesPerView);
					}
					if(options.spaceBetween) {
						options.spaceBetween = Number(options.spaceBetween);
					}
					this.$nextTick(() => {
						new Swiper ('#listsyinlebangdan', options)
					})
					
					// 商品列表样式五
					
				}
			});
			this.$http.get('niandubangdan/list', {params: {
				sort : 'bofangliang',
				order: 'desc',
				page: 1,
				limit: 12,
			}}).then(res => {
				if (res.data.code == 0) {
					this.niandubangdanList = res.data.data.list;
					let options = {"observer":true,"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"observeParents":true,"loop":true,"slidesPerView":5,"speed":500,"spaceBetween":20,"autoplay":{"delay":3000,"disableOnInteraction":false}}
					options.pagination = {el:'null'}
					if(options.slidesPerView) {
						options.slidesPerView = Number(options.slidesPerView);
					}
					if(options.spaceBetween) {
						options.spaceBetween = Number(options.spaceBetween);
					}
					this.$nextTick(() => {
						new Swiper ('#listsniandubangdan', options)
					})
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
	
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: translate3d(10px,0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
</style>
