<template>
  <div class="manage_organize_box">
    <CommonHeader>
      <h3>组织管理</h3>
    </CommonHeader>
    <section>
      <div class="button_group">
        <el-button type="primary" icon="el-icon-plus">添加组织</el-button>
        <el-button type="primary" icon="el-icon-minus">批量删除</el-button>
      </div>
      <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" :header-cell-style="{background:'rgb(247,247,247)'}" style="width: 100%" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column label="组织名称">
          <template slot-scope="scope">{{ scope.row.name }}</template>
        </el-table-column>
        <el-table-column prop="OrganizationCode" label="组织代码"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <i class="el-icon-edit"></i>
            <i class="el-icon-delete"></i>
          </template>
        </el-table-column>
      </el-table>
    </section>
    <el-row type="flex" justify="end">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage4" :page-sizes="[10, 20, 30, 40]" :page-size="10" layout="total, sizes, prev, pager, next, jumper" :total="40">
      </el-pagination>
    </el-row>
  </div>
</template>
<script>
import CommonHeader from "./CommonHeader"
export default {
  components: {
    CommonHeader
  },
  data() {
    return {
      tableData: [{
        name: '孙小猪',
        OrganizationCode: 'AABBB',
      }, {
        name: '孙小猪',
        OrganizationCode: 'AABBB',
      }, {
        name: '孙小猪',
        OrganizationCode: 'AABBB',
      }],
      multipleSelection: [],
      //滑块数据
      switchValue: true,
      //分页的数据
      currentPage4: 4
    }
  },
  methods: {
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    //分页的事件
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    }
  }
}
</script>
<style lang="scss" scoped>
.button_group {
  .el-button:first-child {
    margin-right: 50px;
    margin-top: 20px;
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
</style>