<template>
  <div class="user_manage_footer">
    <div class="button_group">
      <el-button type="primary" icon="el-icon-plus">添加用户</el-button>
      <el-button type="primary" icon="el-icon-minus">批量删除</el-button>
    </div>
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" :header-cell-style="{background:'rgb(247,247,247)'}" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column label="用户名">
        <template slot-scope="scope">{{ scope.row.name }}</template>
      </el-table-column>
      <el-table-column prop="staffName" label="员工姓名"></el-table-column>
      <el-table-column prop="sex" label="性别" width="80"></el-table-column>
      <el-table-column prop="organization" label="组织"></el-table-column>
      <el-table-column prop="organization" label="角色"></el-table-column>
      <el-table-column prop="organization" label="创建时间" width="250"></el-table-column>
      <el-table-column prop="organization" label="修改时间" width="250"></el-table-column>
      <el-table-column label="操作" width="200">
        <template slot-scope="scope">
          <el-switch v-model="switchValue" inactive-color="#ff4949" @change="controlSwitch($event,scope.row)"></el-switch>
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
        name: '孙小猪',
        staffName: '王小虎',
        sex: '女',
        organization: '本部'
      }, {
        name: '孙小猪',
        staffName: '王小虎',
        sex: '女',
        organization: '本部'
      }, {
        name: '孙小猪',
        staffName: '王小虎',
        sex: '女',
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