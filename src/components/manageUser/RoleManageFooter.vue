<template>
  <div class="user_manage_footer">
    <div class="button_group">
      <el-button type="primary" icon="el-icon-plus">添加用户</el-button>
      <el-button type="primary" icon="el-icon-minus">批量删除</el-button>
    </div>
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" :header-cell-style="{background:'rgb(247,247,247)'}" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column label="角色名">
        <template slot-scope="scope">{{ scope.row.rolename }}</template>
      </el-table-column>
      <el-table-column prop="staffName" label="描述"></el-table-column>
      <el-table-column prop="organization" label="创建时间" width="260"></el-table-column>
      <el-table-column prop="organization" label="修改时间" width="260"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <i class="el-icon-view"></i>
          <i class="el-icon-edit"></i>
          <i class="el-icon-delete"></i>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
export default {
  data() {
    return {
      tableData: [{
        rolename: '孙小猪',
        staffName: '王小虎',
        organization: '本部'
      }, {
        rolename: '孙小猪',
        staffName: '王小虎',
        organization: '本部'
      }, {
        rolename: '孙小猪',
        staffName: '王小虎',
        organization: '本部'
      }],
      multipleSelection: [],
      //滑块数据
      switchValue: true
    }
  },

  methods: {
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    //改变滑块事件的回调
    controlSwitch(a, b) {
      console.log(a, b);
    }
  }
}
</script>
<style lang="scss" scoped>
.user_manage_footer {
  .button_group {
    .el-button:first-child {
      margin-right: 150px;
    }
  }
  .el-table {
    i {
      font-size: 1.1rem;
      margin-right: 10px;
      cursor: pointer;
    }
    .el-icon-view {
      margin-left: 10px;
    }
  }
}
</style>