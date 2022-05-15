<template>
  <div id="dotaskApp">
    <div class="headr">
      <router-link to="/home"><i class="el-icon-s-home"></i></router-link>
      <span style="">恐慌检测</span>
    </div>
    <el-row>
      <div>
        <span>恐慌检测</span>
      </div>
    </el-row>
    <div class="show_result">
      <div class="btn_group">
        <span>人群密度估计</span>
        <span>人群恐慌程度估计</span>
        <span>显示人群密度热度图</span>
      </div>
      <div class="des">
        <span>人群密度估计值:0.31</span>
        <span>人群恐慌程度估计值:0.31</span>
      </div>
      <div>
        <el-upload class="avatar-uploader" ref="uploadButton" action="#" :auto-upload="false" :http-request="uploadFile" :on-change="submitFile" v-bind:on-progress="uploadVideoProcess" v-bind:before-upload="beforeUploadVideo" v-bind:show-file-list="false">
          <video v-if="videoForm.showVideoPath != '' && !videoFlag" v-bind:src="videoForm.showVideoPath" class="avatar video-avatar" preload="auto" autoplay="autoplay" loop="loop" controls="controls">
            您的浏览器不支持视频播放
          </video>
          <i v-else-if="videoForm.showVideoPath == '' && !videoFlag" class="el-icon-plus avatar-uploader-icon"></i>
          <el-progress v-if="videoFlag == true" type="circle" v-bind:percentage="videoUploadPercent" style="margin-top: 7px"></el-progress>
        </el-upload>
      </div>
      <el-button type="primary">开始检测</el-button>
    </div>
  </div>
</template>
<script>
import { upload } from "@/api/assemble"
export default {
  data() {
    return {
      file: "",
      videoFlag: false,
      //是否显示进度条
      videoUploadPercent: "",
      //进度条的进度，
      isShowUploadVideo: false,
      //显示上传按钮
      videoForm: {
        showVideoPath: "",  //回显的变量
      },
      fits: 'cover',
      flag: false,
    }
  },
  computed: {
  },
  created() { },
  mounted() {
  },
  methods: {
    submitFile(file, fileList) {
      // 获取上传的文件
      this.file = file.raw
      // 通过submit调用uploadFile
      // this.$refs.uploadButton.submit()
    },
    async uploadFile() {
      console.log(this.file);
      let formdata = new FormData();
      formdata.append("file", this.file)
      const res = await upload(formdata)
      console.log(res);
    },
    sure() {
      this.$refs.uploadButton.submit()
    },
    //上传前回调
    beforeUploadVideo(file) {
      var fileSize = file.size / 1024 / 1024 < 50;   //控制大小  修改50的值即可
      if (
        [
          "video/mp4",
          "video/ogg",
          "video/flv",
          "video/avi",
          "video/wmv",
          "video/rmvb",
          "video/mov",
        ].indexOf(file.type) == -1     //控制格式
      ) {
        this.$message.error("请上传正确的视频格式");
        return false;
      }
      if (!fileSize) {
        this.$message.error("视频大小不能超过50MB");
        return false;
      }
      this.isShowUploadVideo = false;
    },
    //进度条
    uploadVideoProcess(event, file, fileList) {    //注意在data中添加对应的变量名
      console.log(file);
      this.videoFlag = true;
      this.videoUploadPercent = file.percentage.toFixed(0) * 1;
    },
  }
}
</script>
<style scoped lang="less">
.show_result {
  width: 60%;
  height: 600px;
  margin: 50px auto;
  box-shadow: 0 3px 15px rgba(74, 129, 137, 0.4);
  // border: 1px solid rgb(63, 116, 132);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  .btn_group {
    width: 100%;
    display: flex;
    justify-content: space-evenly;
    span {
      width: 150px;
      height: 30px;
      text-align: center;
      // border: 1px solid black;
      box-shadow: 0 3px 5px rgba(0, 0, 0, 0.4);
    }
  }
}
.avatar-uploader-icon {
  border: 1px dashed #d9d9d9 !important;
}
// .avatar-uploader .el-upload {
//   border: 1px dashed #d9d9d9 !important;
//   border-radius: 6px !important;
//   position: relative !important;
//   overflow: hidden !important;
// }
.avatar-uploader .el-upload:hover {
  border: 1px dashed #d9d9d9 !important;
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 600px;
  height: 300px;
  line-height: 300px;
  text-align: center;
}
.avatar {
  width: 600px;
  height: 300px;
  display: block;
}
#dotaskApp {
  .headr {
    height: 40px;
    text-align: left;
    line-height: 40px;
    padding-left: 5px;
    color: #fff;
    background: linear-gradient(to right, rgb(48, 129, 220), rgb(25, 187, 107));
    .el-icon-s-home {
      font-size: 25px;
      color: #fff;
    }
    span {
      font-size: 14px;
      padding-left: 2px;
    }
  }
  div:nth-child(2) {
    margin-top: 5px;
    padding-bottom: 5px;
    margin-left: 10px;
    height: 40px;
    div {
      float: left;
      .el-image {
        width: 33px;
        float: left;
      }
      span {
        line-height: 40px;
        font-weight: 700;
        padding-left: 2px;
      }
    }
    .el-input {
      float: right;
    }
  }
}
</style>
