<template>
	<div class="addEdit-block" :style='{"padding":"30px 0 0 0"}' style="width: 100%;">
		<el-form
			:style='{"padding":"20px 0px 120px"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="140px"
		>
			<template >
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label=" user Account number" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder=" user Account number" clearable  :readonly="ro.yonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label=" user Account number" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder=" user Account number" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label=" user  name" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder=" user  name" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label=" user  name" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder=" user  name" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="album name" prop="zhuanjimingcheng">
					<el-input v-model="ruleForm.zhuanjimingcheng" placeholder="album name" clearable  :readonly="ro.zhuanjimingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="album name" prop="zhuanjimingcheng">
					<el-input v-model="ruleForm.zhuanjimingcheng" placeholder="album name" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="Song name" prop="songname">
					<el-input v-model="ruleForm.songname" placeholder="Song name" clearable  :readonly="ro.songname"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="Song name" prop="songname">
					<el-input v-model="ruleForm.songname" placeholder="Song name" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="Singer" prop="singer">
					<el-input v-model="ruleForm.singer" placeholder="Singer" clearable  :readonly="ro.singer"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="Singer" prop="singer">
					<el-input v-model="ruleForm.singer" placeholder="Singer" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="select" v-if="type!='info'"  label="Music classification" prop="yinlefenlei">
					<el-select :disabled="ro.yinlefenlei" v-model="ruleForm.yinlefenlei" placeholder="Please selectMusic classification" >
						<el-option
							v-for="(item,index) in yinlefenleiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="Music classification" prop="yinlefenlei">
					<el-input v-model="ruleForm.yinlefenlei"
						placeholder="Music classification" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="upload" v-if="type!='info' && !ro.fengmian" label="cover" prop="fengmian">
					<file-upload
						tip="Click to uploadcover"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
						@change="fengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="upload" v-else-if="ruleForm.fengmian" label="cover" prop="fengmian">
					<img v-if="ruleForm.fengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="upload" v-if="type!='info'&& !ro.songfile" label="Music file" prop="songfile">
					<file-upload
						tip="Click to uploadMusic file"
						action="file/upload"
						:limit="1"
						:multiple="true"
						:fileUrls="ruleForm.songfile?ruleForm.songfile:''"
						@change="songfileUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else-if="ruleForm.songfile" label="Music file" prop="songfile">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#797979","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="text" size="small" @click="download($base.url+ruleForm.songfile)">预览</el-button>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else-if="!ruleForm.songfile" label="Music file" prop="songfile">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#797979","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="text" size="small">无</el-button>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="select" v-if="type!='info'"  label="evaluate" prop="pingjia">
					<el-select :disabled="ro.pingjia" v-model="ruleForm.pingjia" placeholder="Please selectevaluate" >
						<el-option
							v-for="(item,index) in pingjiaOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="evaluate" prop="pingjia">
					<el-input v-model="ruleForm.pingjia"
						placeholder="evaluate" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="date" v-if="type!='info'" label="Music review time" prop="lepingshijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.lepingshijian" 
						type="date"
						:readonly="ro.lepingshijian"
						placeholder="Music review time"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-else-if="ruleForm.lepingshijian" label="Music review time" prop="lepingshijian">
					<el-input v-model="ruleForm.lepingshijian" placeholder="Music review time" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-if="type!='info'"  label="Music review content" prop="lepingneirong">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.lepingneirong" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 20px 0","display":"inline-block"}' v-else-if="ruleForm.lepingneirong" label="Music review content" prop="lepingneirong">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.lepingneirong"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"40px","background":"rgba(27, 167, 166, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">submit</el-button>
				<el-button :style='{"border":"1px solid rgba(27, 167, 166, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(27, 167, 166, 1)","borderRadius":"40px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">Cancel</el-button>
				<el-button :style='{"border":"1px solid rgba(27, 167, 166, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(27, 167, 166, 1)","borderRadius":"40px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">return</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("Please enter正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("Please enter正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("Please enter正确的Mobile phone number码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("Please enter正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("Please enter正确的mailbox地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("Please enter数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("Please enter整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				yonghuzhanghao : false,
				yonghuxingming : false,
				zhuanjimingcheng : false,
				songname : false,
				singer : false,
				yinlefenlei : false,
				fengmian : false,
				songfile : false,
				pingjia : false,
				lepingshijian : false,
				lepingneirong : false,
				thumbsupnum : false,
				crazilynum : false,
			},
			
			
			ruleForm: {
				yonghuzhanghao: '',
				yonghuxingming: '',
				zhuanjimingcheng: '',
				songname: '',
				singer: '',
				yinlefenlei: '',
				fengmian: '',
				songfile: '',
				pingjia: '',
				lepingshijian: '',
				lepingneirong: '',
			},
		
			yinlefenleiOptions: [],
			pingjiaOptions: [],
			
			rules: {
				yonghuzhanghao: [
				],
				yonghuxingming: [
				],
				zhuanjimingcheng: [
				],
				songname: [
					{ required: true, message: 'Song name Cannot be empty', trigger: 'blur' },
				],
				singer: [
					{ required: true, message: 'Singer Cannot be empty', trigger: 'blur' },
				],
				yinlefenlei: [
				],
				fengmian: [
				],
				songfile: [
					{ required: true, message: 'Music file Cannot be empty', trigger: 'blur' },
				],
				pingjia: [
				],
				lepingshijian: [
				],
				lepingneirong: [
				],
				thumbsupnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				crazilynum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.lepingshijian = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='yonghuzhanghao'){
							this.ruleForm.yonghuzhanghao = obj[o];
							this.ro.yonghuzhanghao = true;
							continue;
						}
						if(o=='yonghuxingming'){
							this.ruleForm.yonghuxingming = obj[o];
							this.ro.yonghuxingming = true;
							continue;
						}
						if(o=='zhuanjimingcheng'){
							this.ruleForm.zhuanjimingcheng = obj[o];
							this.ro.zhuanjimingcheng = true;
							continue;
						}
						if(o=='songname'){
							this.ruleForm.songname = obj[o];
							this.ro.songname = true;
							continue;
						}
						if(o=='singer'){
							this.ruleForm.singer = obj[o];
							this.ro.singer = true;
							continue;
						}
						if(o=='yinlefenlei'){
							this.ruleForm.yinlefenlei = obj[o];
							this.ro.yinlefenlei = true;
							continue;
						}
						if(o=='fengmian'){
							this.ruleForm.fengmian = obj[o];
							this.ro.fengmian = true;
							continue;
						}
						if(o=='songfile'){
							this.ruleForm.songfile = obj[o];
							this.ro.songfile = true;
							continue;
						}
						if(o=='pingjia'){
							this.ruleForm.pingjia = obj[o];
							this.ro.pingjia = true;
							continue;
						}
						if(o=='lepingshijian'){
							this.ruleForm.lepingshijian = obj[o];
							this.ro.lepingshijian = true;
							continue;
						}
						if(o=='lepingneirong'){
							this.ruleForm.lepingneirong = obj[o];
							this.ro.lepingneirong = true;
							continue;
						}
						if(o=='thumbsupnum'){
							this.ruleForm.thumbsupnum = obj[o];
							this.ro.thumbsupnum = true;
							continue;
						}
						if(o=='crazilynum'){
							this.ruleForm.crazilynum = obj[o];
							this.ro.crazilynum = true;
							continue;
						}
				}
				













			}
			
			
			// 获取 user  information
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0) && this.$storage.get("role")!="Administrator "){
						this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
						this.ro.yonghuzhanghao = true;
					}
					if(((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0) && this.$storage.get("role")!="Administrator "){
						this.ruleForm.yonghuxingming = json.yonghuxingming
						this.ro.yonghuxingming = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/yinlefenlei/yinlefenlei`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.yinlefenleiOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
            this.pingjiaOptions = "★,★★,★★★,★★★★,★★★★★".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `lepingxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传 picture后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表All
        this.ruleForm.lepingneirong = this.ruleForm.lepingneirong.replace(reg,'../../../ssmu5y49/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // submit
    onSubmit() {














	if(this.ruleForm.fengmian!=null) {
		this.ruleForm.fengmian = this.ruleForm.fengmian.replace(new RegExp(this.$base.url,"g"),"");
	}


	if(this.ruleForm.songfile!=null) {
		this.ruleForm.songfile = this.ruleForm.songfile.replace(new RegExp(this.$base.url,"g"),"");
	}











var objcross = this.$storage.getObj('crossObj');

      //Renewal跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "lepingxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `lepingxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "Controls succeed",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.lepingxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `lepingxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "Controls succeed",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.lepingxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // return
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.lepingxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    fengmianUploadChange(fileUrls) {
	    this.ruleForm.fengmian = fileUrls;
    },
    songfileUploadChange(fileUrls) {
	    this.ruleForm.songfile = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #333;
	  	  width: 140px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 140px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 150px;
	  	  font-size: 32px;
	  	  line-height: 150px;
	  	  text-align: center;
	  	  height: 150px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
