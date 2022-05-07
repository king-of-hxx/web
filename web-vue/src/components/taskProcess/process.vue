<template>
  <div class="process">
    <p>
      <i style="color:#3498db" class="el-icon-tickets"></i>
      流程概括
    </p>
    <el-table
      :data="processData"
      style="width: 100%"
      height="250"
      border="1"
      :header-cell-style="getRowClass"
    >
      <el-table-column  prop="taskName" label="任务名称" width="220">
      </el-table-column>
      <el-table-column
        prop="taskOwnerFullName"
        label="工作负责人"
        width="150"
      >
      </el-table-column>
      <el-table-column prop="taskOwnerRoleDisplay" label="角色" width="200">
      </el-table-column>
      <el-table-column prop="taskCreateTime" label="开始时间" width="250">
      </el-table-column>
      <el-table-column prop="taskCompleteTime" label="结束时间" width="250">
      </el-table-column>
      <el-table-column prop="taskRoute" label="处理结果" width="220">
      </el-table-column>
      <el-table-column prop="userComments" label="备注" width="320">
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
export default {
  props: {
    processData: Array,
  },
  data() {
    return {
      processData,
      // tableData: [
      //   {
      //     taskName: "提交签审",
      //     workPerson: "王小虎",
      //     role: "工作负责人",
      //     startTime: "2016-05-02",
      //     endTime: "2016-05-02",
      //     handle: "成功",
      //   },
      //   {
      //     taskName: "提交签审",
      //     workPerson: "王小虎",
      //     role: "工作负责人",
      //     startTime: "2016-05-02",
      //     endTime: "2016-05-02",
      //     handle: "成功",
      //   },
      // ],
    };
  },
  methods: {
    getRowClass({ row, column, rowIndex, columnIndex }) {
      if (rowIndex == 0) {
        return "background:#F5F7FA";
      } else {
        return "";
      }
    },
  },
};
</script>
<style lang="less" scoped>
.process {
  width: 100%;
  padding-top: 25px;
  p {
    font-size: 20px;
    font-weight: bold;
    text-align: left;
  }
}
</style>
