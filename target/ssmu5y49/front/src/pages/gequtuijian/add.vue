<template>
<div :style='{"width":"100%","padding":"20px 7% 40px","margin":"0px auto","position":"relative","background":"none"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="110px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Song name" prop="songname">
            <el-input v-model="ruleForm.songname" 
                placeholder="Song name" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}'  label="Music classification" prop="yinlefenlei">
            <el-select v-model="ruleForm.yinlefenlei" placeholder="Please selectMusic classification"  >
              <el-option
                  v-for="(item,index) in yinlefenleiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="cover" v-if="type!='cross' || (type=='cross' && !ro.fengmian)" prop="fengmian">
            <file-upload
            tip="Click to uploadcover"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
            @change="fengmianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' class="upload" v-else label="cover" prop="fengmian">
                <img v-if="ruleForm.fengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fengmian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fengmian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Singer" prop="singer">
            <el-input v-model="ruleForm.singer" 
                placeholder="Singer" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Language" prop="yuyan">
            <el-input v-model="ruleForm.yuyan" 
                placeholder="Language" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Music file" prop="songfile">
            <file-upload
            tip="Click to uploadMusic file"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.songfile?ruleForm.songfile:''"
            @change="songfileUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="album" prop="zhuanji">
            <el-input v-model="ruleForm.zhuanji" 
                placeholder="album" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="duration" prop="shizhang">
            <el-input v-model="ruleForm.shizhang" 
                placeholder="duration" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="issuer" prop="faxingfang">
            <el-input v-model="ruleForm.faxingfang" 
                placeholder="issuer" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Song introduction" prop="gequjianjie">
            <editor 
                :style='{"minHeight":"300px","padding":"0","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"1px","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.gequjianjie" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","textAlign":"center","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#000000","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">submit</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#aaaaaa","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">return</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            songname : false,
            yinlefenlei : false,
            fengmian : false,
            singer : false,
            yuyan : false,
            songfile : false,
            zhuanji : false,
            shizhang : false,
            faxingfang : false,
            gequjianjie : false,
            thumbsupnum : false,
            crazilynum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          songname: '',
          yinlefenlei: '',
          fengmian: '',
          singer: '',
          yuyan: '',
          songfile: '',
          zhuanji: '',
          shizhang: '',
          faxingfang: '',
          gequjianjie: '',
          thumbsupnum: '',
          crazilynum: '',
        },
        yinlefenleiOptions: [],
        rules: {
          songname: [
            { required: true, message: 'Song name Cannot be empty', trigger: 'blur' },
          ],
          yinlefenlei: [
            { required: true, message: 'Music classification Cannot be empty', trigger: 'blur' },
          ],
          fengmian: [
          ],
          singer: [
            { required: true, message: 'Singer Cannot be empty', trigger: 'blur' },
          ],
          yuyan: [
          ],
          songfile: [
            { required: true, message: 'Music file Cannot be empty', trigger: 'blur' },
          ],
          zhuanji: [
          ],
          shizhang: [
          ],
          faxingfang: [
          ],
          gequjianjie: [
          ],
          thumbsupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          crazilynum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
        },
      };
    },
    computed: {



    },
    components: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='songname'){
              this.ruleForm.songname = obj[o];
              this.ro.songname = true;
              continue;
            }
            if(o=='yinlefenlei'){
              this.ruleForm.yinlefenlei = obj[o];
              this.ro.yinlefenlei = true;
              continue;
            }
            if(o=='fengmian'){
              this.ruleForm.fengmian = obj[o].split(",")[0];
              this.ro.fengmian = true;
              continue;
            }
            if(o=='singer'){
              this.ruleForm.singer = obj[o];
              this.ro.singer = true;
              continue;
            }
            if(o=='yuyan'){
              this.ruleForm.yuyan = obj[o];
              this.ro.yuyan = true;
              continue;
            }
            if(o=='songfile'){
              this.ruleForm.songfile = obj[o];
              this.ro.songfile = true;
              continue;
            }
            if(o=='zhuanji'){
              this.ruleForm.zhuanji = obj[o];
              this.ro.zhuanji = true;
              continue;
            }
            if(o=='shizhang'){
              this.ruleForm.shizhang = obj[o];
              this.ro.shizhang = true;
              continue;
            }
            if(o=='faxingfang'){
              this.ruleForm.faxingfang = obj[o];
              this.ro.faxingfang = true;
              continue;
            }
            if(o=='gequjianjie'){
              this.ruleForm.gequjianjie = obj[o];
              this.ro.gequjianjie = true;
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
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/yinlefenlei/yinlefenlei', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.yinlefenleiOptions = res.data.data;
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('gequxinxi/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // submit
      onSubmit() {

        //Renewal跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('gequxinxi/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('gequxinxi/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: 'Controls succeed',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('gequxinxi/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: 'Controls succeed',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
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
        this.$router.go(-1);
      },
      fengmianUploadChange(fileUrls) {
          this.ruleForm.fengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
      songfileUploadChange(fileUrls) {
          this.ruleForm.songfile = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 110px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 110px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #ccc;
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
	  border: 1px solid #ccc;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #ccc;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #ccc;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
