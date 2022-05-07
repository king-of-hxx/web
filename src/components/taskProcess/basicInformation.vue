<template>
  <div class="basicInformation">
    <p>
      <i style="color:#3498db" class="el-icon-tickets"></i>
      基本信息
    </p>
    <el-table :data="basicInfo" style="width: 100%" height="250" border="1" :header-cell-style="getRowClass">
      <el-table-column  prop="workName" label="编号" width="400" :header-cell-style="getRowClass">
        <template slot-scope="scope">
          <el-button type="text" @click="getMoreInfo(scope.row.workItemOid)">
            {{ scope.row.workName }}
          </el-button>
        </template>
      </el-table-column>
      <el-table-column   prop="name" label="名称" width="400">
      </el-table-column>
      <el-table-column  prop="version" label="版本" width="400">
      </el-table-column>
      <el-table-column  prop="state" label="状态" width="400"> </el-table-column>
    </el-table>
  </div>
</template>
<script>
export default {
  // props: {
  //   basicInfo: Array,
  //   // dotasksList: Object,
  // },
  data() {
    return {
      // tableData: [this.basicInfo],
      // dotasksList: [],
      basicInfo: [],
    };
  },
  methods: {
    // getMoreInfo(oid) {
    //   this.$router.push({
    //     name: "DetailedInfomation",
    //     query: {
    //       oid: oid,
    //     },
    //   });
    // },
    getRowClass({ row, column, rowIndex, columnIndex }) {
      if (rowIndex == 0) {
        return "color:black";
      } else {
        return "";
      }
    },
  },
};
</script>
<style lang="less" scoped>
.el-table {
  height: 160px !important;
}
.basicInformation {
  width: 100%;
  height: 25%;
  padding-top: 25px;
  border-bottom: 1px solid rgb(170, 168, 168);
    p {
    font-size: 20px;
    font-weight: bold;
    text-align: left
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
