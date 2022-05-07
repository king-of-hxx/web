<template>
  <div class="opinion">
    <div class="opinion-single">
    <p>
      <i style="color:#3498db" class="el-icon-tickets"></i>
      意见
    </p>
    <div>
    <el-radio-group v-model="radio" v-for="(item, index) in routeInfo" :key="index">
      <el-radio :label="item"></el-radio>
    </el-radio-group>
    </div>
    </div>

    <!-- <el-radio v-model="radio" label="2">取消</el-radio> -->
    <div class="opinion-text">
      <span>备注</span>
      <textarea name="" id="text" cols="50" rows="3" placeholder="请输入内容" v-model="opinionData"></textarea>
    </div>
    <el-row style="margin-left:10px; text-align: left;">
      <el-button v-if="taskInfo.workItemState !== '已完成'" type="primary" round @click="getFinish" v-loading.fullscreen.lock="fullscreenLoading">完成任务</el-button>
      <!-- <el-button v-else type="primary" round :loading="true">加载中</el-button> -->
    </el-row>
    <!-- <a-button shape="circle">
      <template #icon><SearchOutlined /></template>
    </a-button> -->
  </div>
</template>
<script>
// import { getworkItemComplete } from "@/api/workItemComplete";
// import { message } from "ant-design-vue";
// import { SearchOutlined } from "@ant-design/icons-vue";
export default {
  // components: {
  //   SearchOutlined,
  // },
  // props: {
  //   routeInfo: Array,
  //   taskInfo: Object,
  //   workItemOidData: String,
  //   roleLists: Array,
  // },
  data() {
    return {
      routeInfo: ["完成","重新封样"],
      taskInfo:{workItemState: '未完成'},
      radio: "",
      // routeInfo: Array,
      // taskInfo: Object,
      // workItemOidData: String,
      opinionData: "",
      fullscreenLoading: false,
    };
  },
  // computed: {
  //   getuserRoute() {
  //     return this.workItemOidData;
  //   },
  // },
  methods: {
    // getRadio(result) {},
    //   getFinish() {
    //     const loading = this.$loading({
    //       lock: true,
    //       text: "亲，正在玩命加载中...",
    //       spinner: "el-icon-loading",
    //       background: "rgba(0, 0, 0, 0.7)",
    //     });
    //     setTimeout(() => {
    //       loading.close();
    //     }, 1000);
    //     if (this.radio == "同意" || this.radio == "通过") {
    //       getworkItemComplete({
    //         userName: this.taskInfo.taskInfo.taskOwnerFullName,
    //         userRoute: [this.radio],
    //         userComments: this.opinionData,
    //         workItemOid: this.workItemOidData,
    //         participantList: this.roleLists,
    //       }).then((res) => {
    //         if (res.retCode !== 200) {
    //           alert(message.error);
    //         } else {
    //           this.$message.success("完成任务!");
    //           this.$router.push({
    //             path: "/home",
    //           });
    //         }
    //       });
    //     } else if (this.radio == "驳回" && this.opinionData.trim() !== "") {
    //       getworkItemComplete({
    //         userName: this.taskInfo.taskInfo.taskOwnerFullName,
    //         userRoute: [this.radio],
    //         userComments: this.opinionData,
    //         workItemOid: this.workItemOidData,
    //         participantList: this.roleLists,
    //       }).then((res) => {
    //         if (res.retCode !== 200) {
    //           alert(message.error);
    //         } else {
    //           this.$message.success("驳回成功!");
    //           this.$router.push({
    //             path: "/home",
    //           });
    //         }
    //       });
    //     } else if (this.radio == "取消") {
    //       this.$message.success("取消成功!");
    //       this.$router.push({
    //         path: "/home",
    //       });
    //     } else {
    //       this.$message.warning("备注不能为空!");
    //     }
    //   },
    // },
    // mounted() {
    //   if (this.routeInfo.length > 0) {
    //     this.radio = this.routeInfo[0].routeDisplay;
    //   }
    // },
  }
};
</script>
<style lang="less" scoped>
.opinion {
  width: 100%;
  height: 35%;
  padding-top: 25px;
  border-bottom: 1px solid rgb(170, 168, 168);
  .opinion-single{
    p {
    font-size: 20px;
    font-weight: bold;
    text-align: left;
  }
  div{
    text-align: left;
  .radio {
    display: flex;
  }
  .el-radio {
    margin-top: 10px;
    margin-left: 10px !important;
    
  }
  }
  }
  
  .opinion-text {
    display: flex;
    flex-direction: column;
    margin-top: 30px;
    margin-bottom: 30px;
    span {
      font-size: 18px;
      margin-left: 10px;
      text-align: left;
    }
    #text {
      border-radius: 8px;
      width: 80%;
      padding-left: 20px;
    }
  }
}
</style>
