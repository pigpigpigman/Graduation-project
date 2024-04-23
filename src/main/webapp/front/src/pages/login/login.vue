<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230111/af6e32bf0cd344b79a044e00ea687ea3.jpg) no-repeat center top / 100% 100%","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"border":"1px solid #666","padding":"50px 40px","boxShadow":"inset 0px 0px 56px 0px #666","margin":"0","borderRadius":"4px","flexWrap":"wrap","background":"none","display":"flex","width":"800px","position":"relative","justifyContent":"flex-end","height":"auto"}' :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"margin":"0 0 10px","color":"#fff","textAlign":"center","width":"66%","lineHeight":"44px","fontSize":"20px","textShadow":"0px 0px 0px rgba(64, 158, 255, .5)"}'>Online music site login</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"66%","margin":"0 0 10px"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Account number：</div>
				<input :style='{"border":"0px solid #efefef","padding":"0 10px","color":"#333","outlineOffset":"8px","background":"linear-gradient(25deg, rgba(129,129,130,0) 0%, rgba(255,255,255,1) 60%, rgba(129,129,130,1) 100%),#fff","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.username" placeholder="Please enter账户">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"66%","margin":"0 0 10px"}' prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>password：</div>
				<input :style='{"border":"0px solid #efefef","padding":"0 10px","color":"#333","outlineOffset":"8px","background":"linear-gradient(25deg, rgba(129,129,130,0) 0%, rgba(255,255,255,1) 60%, rgba(129,129,130,1) 100%),#fff","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.password" placeholder="Please enterpassword" type="password">
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"66%","padding":"0 10px","margin":"0px 0 10px","background":"linear-gradient(25deg, rgba(129,129,130,.6) 0%, rgba(255,255,255,1) 80%, rgba(129,129,130,1) 100%),#fff"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"width":"100%","margin":"20px auto","minWidth":"720px"}'>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 0 0 34%","color":"#333","minWidth":"475px","outline":"none","borderRadius":"4px","background":"linear-gradient(90deg, rgba(129,129,130,1) 0%, rgba(255,255,255,1) 50%, rgba(129,129,130,1) 100%)","width":"66%","fontSize":"14px","position":"relative","height":"44px","zIndex":"999"}' @click="submitForm('loginForm')">Login</el-button>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 5px","outline":"none","color":"#fff","borderRadius":"4px","background":"rgba(64, 158, 255, 1)","display":"none","width":"auto","fontSize":"14px","height":"44px"}' @click="resetForm('loginForm')">reset</el-button>
			</el-form-item>
			<div :style='{"margin":"0 40px 0 0","top":"104px","flexWrap":"wrap","left":"0","display":"flex","width":"30%","position":"absolute","justifyContent":"center","height":"70%"}'>
			<router-link :style='{"cursor":"pointer","padding":"0 10px","margin":"0 0 10px 0","color":"#000","borderRadius":"8px","textAlign":"center","background":"#818182","width":"55%","fontSize":"16px","textDecoration":"none","lineHeight":"2","height":"32px"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">register{{item.roleName.replace('register','')}}</router-link>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>

export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["new","view","edit","delete"],"menu":" user ","menuJump":"列表","tableName":"yonghu"}],"menu":" user MGT"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["new","view","edit","delete"],"menu":"Music classification","menuJump":"列表","tableName":"yinlefenlei"}],"menu":"Music classification MGT"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["new","view","edit","delete","view review"],"menu":"Singer INFO","menuJump":"列表","tableName":"geshouxinxi"}],"menu":"Singer INFO MGT"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["new","view","edit","delete","view review"],"menu":"Song INFO","menuJump":"列表","tableName":"gequxinxi"}],"menu":"Song INFO MGT"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["new","view","edit","delete","view review"],"menu":"Music album","menuJump":"列表","tableName":"yinlezhuanji"}],"menu":"Music album MGT"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["new","view","edit","delete","view review"],"menu":"Music MV","menuJump":"列表","tableName":"yinlemv"}],"menu":"Music MV MGT"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["view","edit","delete","view review"],"menu":"Music review INFO","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO MGT"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["new","view","edit","delete","view review"],"menu":"Music charts","menuJump":"列表","tableName":"yinlebangdan"}],"menu":"Music charts MGT"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["new","view","edit","delete","view review"],"menu":"Annual list","menuJump":"列表","tableName":"niandubangdan"}],"menu":"Annual list MGT"},{"child":[{"appFrontIcon":"cuIcon-service","buttons":["new","view","edit","delete"],"menu":"Help center","tableName":"chat"},{"appFrontIcon":"cuIcon-rank","buttons":["new","view","edit","delete"],"menu":"Rotation chart MGT","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["new","view","edit","delete"],"menu":"Music INFO","tableName":"news"}],"menu":"System MGT"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["view"],"menu":"Singer INFO列表","menuJump":"列表","tableName":"geshouxinxi"}],"menu":"Singer INFO模块"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["view"],"menu":"Song INFO列表","menuJump":"列表","tableName":"gequxinxi"}],"menu":"Song INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view","Music criticism"],"menu":"Music album列表","menuJump":"列表","tableName":"yinlezhuanji"}],"menu":"Music album模块"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["view"],"menu":"Music MV列表","menuJump":"列表","tableName":"yinlemv"}],"menu":"Music MV模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["view"],"menu":"Music review INFO列表","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view"],"menu":"Music charts列表","menuJump":"列表","tableName":"yinlebangdan"}],"menu":"Music charts模块"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["view"],"menu":"Annual list列表","menuJump":"列表","tableName":"niandubangdan"}],"menu":"Annual list模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"Administrator ","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["view","edit","delete","view review"],"menu":"Music review INFO","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO MGT"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["view"],"menu":"Singer INFO列表","menuJump":"列表","tableName":"geshouxinxi"}],"menu":"Singer INFO模块"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["view"],"menu":"Song INFO列表","menuJump":"列表","tableName":"gequxinxi"}],"menu":"Song INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view","Music criticism"],"menu":"Music album列表","menuJump":"列表","tableName":"yinlezhuanji"}],"menu":"Music album模块"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["view"],"menu":"Music MV列表","menuJump":"列表","tableName":"yinlemv"}],"menu":"Music MV模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["view"],"menu":"Music review INFO列表","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view"],"menu":"Music charts列表","menuJump":"列表","tableName":"yinlebangdan"}],"menu":"Music charts模块"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["view"],"menu":"Annual list列表","menuJump":"列表","tableName":"niandubangdan"}],"menu":"Annual list模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":" user ","tableName":"yonghu"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: 'Please enter账户', trigger: 'blur' }
				],
				password: [
					{ required: true, message: 'Please enterpassword', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}]
		}
	},
  components: {
  },
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='是') {
                this.roles.push(this.roleMenus[item]);
            }
        }
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("Please selectLogin user 类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                this.$router.push('/index/center');
                this.$message({
                  message: 'Login succeed',
                  type: 'success',
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20230111/af6e32bf0cd344b79a044e00ea687ea3.jpg) no-repeat center top / 100% 100%;
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border: 0px solid #efefef;
			padding: 0 10px;
			color: #333;
			background: linear-gradient(25deg, rgba(129,129,130,0) 0%, rgba(255,255,255,1) 60%, rgba(129,129,130,1) 100%),#fff;
			width: 100%;
			font-size: 14px;
			outline-offset: 8px;
			height: 44px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border: 0px solid rgba(64, 158, 255, 1);
			padding: 0 10px;
			outline: none;
			color: #333;
			background: linear-gradient(25deg, rgba(129,129,130,0) 0%, rgba(255,255,255,1) 90%, rgba(129,129,130,1) 100%),#fff;
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 124px);
			font-size: 14px;
			height: 44px;
		}
		
		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: #333;
			border-color: #333;
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #333;
			font-size: 14px;
		}
	}
</style>
