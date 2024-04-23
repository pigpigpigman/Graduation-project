<template>
<div :style='{"width":"100%","padding":"20px 7% 40px","margin":"0px auto","position":"relative","background":"none"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="110px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Singer name" prop="geshouxingming">
            <el-input v-model="ruleForm.geshouxingming" 
                placeholder="Singer name" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}'  label="Singersex" prop="geshouxingbie">
            <el-select v-model="ruleForm.geshouxingbie" placeholder="Please selectSingersex"  >
              <el-option
                  v-for="(item,index) in geshouxingbieOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="school" prop="liupai">
            <el-input v-model="ruleForm.liupai" 
                placeholder="school" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="label" prop="biaoqian">
            <el-input v-model="ruleForm.biaoqian" 
                placeholder="label" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Debut date" prop="chudaoriqi" >
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.chudaoriqi" 
                  type="date"
                  placeholder="Debut date">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Fame song" prop="chengminggequ">
            <el-input v-model="ruleForm.chengminggequ" 
                placeholder="Fame song" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="avatar" v-if="type!='cross' || (type=='cross' && !ro.touxiang)" prop="touxiang">
            <file-upload
            tip="Click to uploadavatar"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
            @change="touxiangUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' class="upload" v-else label="avatar" prop="touxiang">
                <img v-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Hit song" prop="remengequ">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="Hit song"
              v-model="ruleForm.remengequ">
            </el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Album introduction" prop="zhuanjijieshao">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="Album introduction"
              v-model="ruleForm.zhuanjijieshao">
            </el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px 0"}' label="Singer introduce" prop="geshoujieshao">
            <editor 
                :style='{"minHeight":"300px","padding":"0","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"1px","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.geshoujieshao" 
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
            geshouxingming : false,
            geshouxingbie : false,
            liupai : false,
            biaoqian : false,
            chudaoriqi : false,
            chengminggequ : false,
            touxiang : false,
            remengequ : false,
            zhuanjijieshao : false,
            geshoujieshao : false,
            thumbsupnum : false,
            crazilynum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          geshouxingming: '',
          geshouxingbie: '',
          liupai: '',
          biaoqian: '',
          chudaoriqi: '',
          chengminggequ: '',
          touxiang: '',
          remengequ: '',
          zhuanjijieshao: '',
          geshoujieshao: '',
          thumbsupnum: '',
          crazilynum: '',
        },
        geshouxingbieOptions: [],
        rules: {
          geshouxingming: [
            { required: true, message: 'Singer name Cannot be empty', trigger: 'blur' },
          ],
          geshouxingbie: [
            { required: true, message: 'Singersex Cannot be empty', trigger: 'blur' },
          ],
          liupai: [
          ],
          biaoqian: [
          ],
          chudaoriqi: [
          ],
          chengminggequ: [
          ],
          touxiang: [
          ],
          remengequ: [
          ],
          zhuanjijieshao: [
          ],
          geshoujieshao: [
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
            if(o=='geshouxingming'){
              this.ruleForm.geshouxingming = obj[o];
              this.ro.geshouxingming = true;
              continue;
            }
            if(o=='geshouxingbie'){
              this.ruleForm.geshouxingbie = obj[o];
              this.ro.geshouxingbie = true;
              continue;
            }
            if(o=='liupai'){
              this.ruleForm.liupai = obj[o];
              this.ro.liupai = true;
              continue;
            }
            if(o=='biaoqian'){
              this.ruleForm.biaoqian = obj[o];
              this.ro.biaoqian = true;
              continue;
            }
            if(o=='chudaoriqi'){
              this.ruleForm.chudaoriqi = obj[o];
              this.ro.chudaoriqi = true;
              continue;
            }
            if(o=='chengminggequ'){
              this.ruleForm.chengminggequ = obj[o];
              this.ro.chengminggequ = true;
              continue;
            }
            if(o=='touxiang'){
              this.ruleForm.touxiang = obj[o].split(",")[0];
              this.ro.touxiang = true;
              continue;
            }
            if(o=='remengequ'){
              this.ruleForm.remengequ = obj[o];
              this.ro.remengequ = true;
              continue;
            }
            if(o=='zhuanjijieshao'){
              this.ruleForm.zhuanjijieshao = obj[o];
              this.ro.zhuanjijieshao = true;
              continue;
            }
            if(o=='geshoujieshao'){
              this.ruleForm.geshoujieshao = obj[o];
              this.ro.geshoujieshao = true;
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
        this.geshouxingbieOptions = "male,female".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('geshouxinxi/detail/${id}', {emulateJSON: true}).then(res => {
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
                 this.$http.get('geshouxinxi/list', {
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


                          this.$http.post('geshouxinxi/add', this.ruleForm).then(res => {
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


                  this.$http.post('geshouxinxi/add', this.ruleForm).then(res => {
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
      touxiangUploadChange(fileUrls) {
          this.ruleForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
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
