<template>
  <div class="box-row1">
    <p>
      <i style="color:#3498db" class="el-icon-tickets"></i>
      任务信息
    </p>
    <div class="task-info">
      <span>主题：{{ taskinfo.subject }}</span>
      <span>工作负责人：{{ taskinfo.taskOwnerFullName }}</span>
      <span>流程启动者：{{ taskinfo.processCreatorFullName }}</span>
    </div>
  </div>
</template>
<script>
export default {
  // props: {
  //    taskInfo: Object,
  // },
  data() {
    return {
      taskinfo: {
          subject:'衡变',
          taskOwnerFullName:'好相信',
          processCreatorFullName:'好像行'
      },
    };
  },
};
</script>
 <style lang="less" scoped>
.box-row1 {
  width: 100%;
  height: 10%;
  padding-top: 25px;
  border-bottom: 1px solid rgb(170, 168, 168);
  p {
    font-size: 20px;
    font-weight: bold;
    text-align: left;
  }
  .task-info {
    display: flex;
    span {
      font-size: 18px;
    }
    span:nth-child(2) {
      margin-left: 300px;
      margin-right: 300px;
    }
  }
}
</style>
