<template>
	<div class="main-containers">
		<div class="top-container" :style='{"padding":"0px 7%","overflow":"hidden","top":"0","alignItems":"center","left":"0","background":"#434343","display":"flex","width":"100%","position":"relative","justifyContent":"space-between","height":"44px","zIndex":"1002"}'>
			<img v-if='true' :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}' src='http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg'>
			<div v-if="true" :style='{"width":"calc(100% - 770px)","margin":"0 0 0 410px","fontSize":"18px","color":"#fff","textAlign":"center","background":"none"}'>Online music site</div>
			<div>
				<div v-if="false" :style='{"color":"#fff","fontSize":"16px","display":"inline-block"}'>0753-1234567</div>
				<div v-if="Token" :style='{"color":"#fff","fontSize":"16px","display":"inline-block"}'>{{username}}</div>
				<el-button v-if="!Token" @click="toLogin()" :style='{"padding":"0 12px","margin":"0 0 0 10px","color":"#fff","borderRadius":"2px","background":"#999999","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px"}'>Login/register</el-button>
                <el-button v-if="Token" @click="logout" :style='{"padding":"0 12px","margin":"0 0 0 10px","color":"#666","borderRadius":"2px","background":"#f4f4f5","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px"}'>quit </el-button>
			</div>
		</div>
		
		
		<div class="body-containers" :style='"horizontal" == "vertical" ? {"minHeight":"100vh","padding":"64px 0 0","margin":"0 0 0 210px","position":"relative","background":"rgba(64, 158, 255, .3)","display":"block"} : {"padding":"0","margin":"0","position":"relative","background":"url() fixed repeat-y,#fff"}'>
			<div class="menu-preview" :style='{"width":"100%","background":"none","height":"80px"}'>
				<el-menu class="el-menu-horizontal-demo" :style='{"border":0,"padding":"0","listStyle":"none","margin":"0","background":"#FFF","display":"flex","position":"relative","justifyContent":"center"}' :default-active="activeIndex" :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
					<el-image v-if="false" :style='{"width":"44px","margin":"8px 10px 8px 0","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
					<el-menu-item v-for="(menu, index) in menuList" :index="index + ''" :key="index" :route="menu.url">
						<i v-if="false" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' :class="iconArr[index]"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>{{menu.name}}</span>
					</el-menu-item>
					<el-menu-item @click="goChat">
						<i v-if="false" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-service"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>Help center</span>
					</el-menu-item>
					<el-menu-item :index="menuList.length + 2 + ''" v-if="Token && notAdmin" @click="goMenu('/index/center')">
						<i v-if="false" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-user"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>Individual center</span>
					</el-menu-item>
				</el-menu>
			</div>
			
			<div class="banner-preview" :style='{"width":"100%","height":"auto"}'>
				<el-carousel :style='{"width":"80%","margin":"0 auto"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="400px" :autoplay="true" :interval="5000" :loop="true">
					<el-carousel-item :style='{"borderRadius":"10px","width":"100%","height":"100%"}' v-for="item in carouselList" :key="item.id">
						<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + item.value" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>
			
			<router-view></router-view>
			
			<div class="bottom-preview" :style='{"padding":"20px 0","alignItems":"center","background":"#333","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center","height":"150px"}'>
			    <img :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" >
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			</div>
		</div>
		
        <el-dialog title="Help center" :visible.sync="chatFormVisible" width="600px" :before-close="chatClose">
            <div class="chat-content"
                style="background: #f5f5f5;padding: 10px;box-sizing: border-box;overflow-y: scroll;max-height: 40vh;min-height: 40vh;">
                <div :class="{'right-content': item.reply == '' || item.reply == null, 'left-content': item.ask == '' || item.ask == null}"
                    v-for="item in chatList" :key="item.id">
                    <el-tag :type="(item.ask == '' || item.ask == null) ? 'warning' : 'success'" style="margin: 10px;">
                        {{(item.ask == '' || item.ask == null) ? item.reply : item.ask}}
                    </el-tag>
                </div>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-input v-model="form.ask" placeholder="Please entercontent" style="width: calc(100% - 80px);float: left;">
                </el-input>
                <el-button type="primary" @click="addChat">发送</el-button>
            </div>
        </el-dialog>
        <div class="audioAnimation-box" :class="showType?'audioAnimation-box1':''" v-if="audio.length"
            style="width: 100%;position: fixed;bottom: 0;left: 0;z-index: 99999;" @mouseover="showmouseover">
            <div @click="suoClick"
                style="position: absolute;top: -20px;right: 40%;background: #fff;border-radius: 50% 50% 0 0;font-size: 0;width: 30px;height: 30px;display: flex;justify-content: center;align-items: center;cursor: pointer;">
                <img v-if="suoType" style="width: 20px;height: 20px;" src="../assets/suo.png">
                <img v-else style="width: 20px;height: 20px;" src="../assets/jiesuo.png">
            </div>
            <aplayer :float="true" :volume="1" repeat="repeat-all" ref="aplayer" id="aplayer" :music="audio[audioIndex]"
                :list="audio" :showlrc="false" :listFolded="true" :autoplay="true" listMaxHeight="180px"></aplayer>
        </div>
	</div>
</template>

<script>
import Vue from 'vue'
export default {
    data() {
		return {
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["new","view","edit","delete"],"menu":" user ","menuJump":"列表","tableName":"yonghu"}],"menu":" user MGT"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["new","view","edit","delete"],"menu":"Music classification","menuJump":"列表","tableName":"yinlefenlei"}],"menu":"Music classification MGT"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["new","view","edit","delete","view review"],"menu":"Singer INFO","menuJump":"列表","tableName":"geshouxinxi"}],"menu":"Singer INFO MGT"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["new","view","edit","delete","view review"],"menu":"Song INFO","menuJump":"列表","tableName":"gequxinxi"}],"menu":"Song INFO MGT"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["new","view","edit","delete","view review"],"menu":"Music album","menuJump":"列表","tableName":"yinlezhuanji"}],"menu":"Music album MGT"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["new","view","edit","delete","view review"],"menu":"Music MV","menuJump":"列表","tableName":"yinlemv"}],"menu":"Music MV MGT"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["view","edit","delete","view review"],"menu":"Music review INFO","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO MGT"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["new","view","edit","delete","view review"],"menu":"Music charts","menuJump":"列表","tableName":"yinlebangdan"}],"menu":"Music charts MGT"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["new","view","edit","delete","view review"],"menu":"Annual list","menuJump":"列表","tableName":"niandubangdan"}],"menu":"Annual list MGT"},{"child":[{"appFrontIcon":"cuIcon-service","buttons":["new","view","edit","delete"],"menu":"Help center","tableName":"chat"},{"appFrontIcon":"cuIcon-rank","buttons":["new","view","edit","delete"],"menu":"Rotation chart MGT","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["new","view","edit","delete"],"menu":"Music INFO","tableName":"news"}],"menu":"System MGT"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["view"],"menu":"Singer INFO列表","menuJump":"列表","tableName":"geshouxinxi"}],"menu":"Singer INFO模块"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["view"],"menu":"Song INFO列表","menuJump":"列表","tableName":"gequxinxi"}],"menu":"Song INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view","Music criticism"],"menu":"Music album列表","menuJump":"列表","tableName":"yinlezhuanji"}],"menu":"Music album模块"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["view"],"menu":"Music MV列表","menuJump":"列表","tableName":"yinlemv"}],"menu":"Music MV模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["view"],"menu":"Music review INFO列表","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view"],"menu":"Music charts列表","menuJump":"列表","tableName":"yinlebangdan"}],"menu":"Music charts模块"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["view"],"menu":"Annual list列表","menuJump":"列表","tableName":"niandubangdan"}],"menu":"Annual list模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"Administrator ","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["view","edit","delete","view review"],"menu":"Music review INFO","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO MGT"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["view"],"menu":"Singer INFO列表","menuJump":"列表","tableName":"geshouxinxi"}],"menu":"Singer INFO模块"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["view"],"menu":"Song INFO列表","menuJump":"列表","tableName":"gequxinxi"}],"menu":"Song INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view","Music criticism"],"menu":"Music album列表","menuJump":"列表","tableName":"yinlezhuanji"}],"menu":"Music album模块"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["view"],"menu":"Music MV列表","menuJump":"列表","tableName":"yinlemv"}],"menu":"Music MV模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["view"],"menu":"Music review INFO列表","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view"],"menu":"Music charts列表","menuJump":"列表","tableName":"yinlebangdan"}],"menu":"Music charts模块"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["view"],"menu":"Annual list列表","menuJump":"列表","tableName":"niandubangdan"}],"menu":"Annual list模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":" user ","tableName":"yonghu"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			chatFormVisible: false,
			chatList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('userid')
			},
			Token: localStorage.getItem('Token'),
            username: localStorage.getItem('username'),
            notAdmin: localStorage.getItem('sessionTable')!='"users"',
			timer: '',
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-MGT',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],	
                musicType: false,
                showTimer: null,
                showType: false,
                suoType:false,
		}
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
		this.getCarousel();
        if(localStorage.getItem('Token') && localStorage.getItem('Token')!=null) {
            this.saveChathelper('主人，我是您的智能助手小搏，请问有什么可以帮您！');
            this.getChatList();
        }
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';
        this.musicType = localStorage.getItem('musicType') ? true : false;
    },
    computed: {
        audioIndex: {
            get() {
                return this.$store.state.app.audioIndex
            },
            set(val) {
                return this.$store.state.app.audioIndex = val
            }
        },
        audio: {
              get() {
                  return this.$store.state.app.audio
              },
              set(val) {
                  return this.$store.state.app.audio = val
              }
        },
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('Token')
        },
        audio(newValue) {
            this.audioIndex = this.$store.state.app.audioIndex
        },
        audioIndex() {
            this.showmouseover()
            this.$nextTick(() => {
                this.$refs.aplayer.play()
            })
            this.$forceUpdate()
        },
    },
    methods: {
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: '登出 succeed',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		getChatList() {
			this.$http.get('chat/list', {params: { userid: localStorage.getItem('userid'), sort: 'addtime', order: 'asc',limit: 1000 }}).then(res => {
				if (res.data.code == 0) {
					this.chatList = res.data.data.list;
                    let div = document.getElementsByClassName('chat-content')[0]
                    setTimeout(() => {
                        if (div)
                            div.scrollTop = div.scrollHeight
                    }, 0)
				}
			});
		},
		addChat() {
			this.$http.post('chat/add', this.form).then(res => {
				if (res.data.code == 0) {
					this.form.ask = '';
					this.getChatList();
				}
			});
		},
		chatClose() {
			clearInterval(this.timer);
			this.chatFormVisible = false;
		},
		goChat() {
            if(!localStorage.getItem('Token')) {
                this.toLogin();
                return;
            }
			this.chatFormVisible = true;
			this.timer = setInterval(this.getChatList, 2000);
		},
		goMenu(path) {
            if (!localStorage.getItem('Token')) {
                this.toLogin();
            } else {
                this.$router.push(path);
            }
		},
        suoClick(){
            this.suoType = !this.suoType
            if(this.suoType){
                clearTimeout(this.showTimer)
            }else{
                this.showmouseover()
            }
        },
        showmouseover() {
            if(this.suoType){
                return false
            }
            let that = this
            clearTimeout(this.showTimer)
            this.showType = true
            this.showTimer = setTimeout(() => {
                that.$refs.aplayer.showList = false;
                that.showType = false

            }, 6000)
        },
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item {
		cursor: pointer;
		border: 0;
		padding: 0 20px;
		color: #333;
		white-space: nowrap;
		display: flex;
		font-size: 14px;
		line-height: 80px;
		background: none;
		align-items: center;
		position: relative;
		list-style: none;
		height: 80px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item:hover {
		cursor: pointer;
		border: 0;
		padding: 0 20px;
		color: #333;
		white-space: nowrap;
		background: url(http://codegen.caihongy.cn/20230111/2184b24053404f55a468cfd5a24ba3f1.png) no-repeat center 60px;
		font-size: 14px;
		line-height: 80px;
		position: relative;
		list-style: none;
		height: 80px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.is-active {
		cursor: pointer;
		border: 0;
		padding: 0 20px;
		color: #333;
		white-space: nowrap;
		background: url(http://codegen.caihongy.cn/20230111/2184b24053404f55a468cfd5a24ba3f1.png) no-repeat center 60px;
		font-size: 14px;
		line-height: 80px;
		position: relative;
		list-style: none;
		height: 80px;
	}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0 0 10px;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
		border-radius: 10px;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
      .left-content {
          width: 100%;
          text-align: left;
      }
      .right-content {
          width: 100%;
          text-align: right;
      }
    }
    .audioAnimation-box {
        transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 68px, 0px);
        -webkit-perspective: 1000px;
        perspective: 1000px;
        transition: 0.3s;
    }

    .audioAnimation-box1 {
        transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0, 0px) !important;
    }
</style>
