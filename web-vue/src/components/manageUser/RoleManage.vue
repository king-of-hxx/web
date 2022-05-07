<template>
  <div class="manage_role_box">
    <CommonHeader>
      <h3>角色管理</h3>
    </CommonHeader>
    <section>
      <el-form :model="formInline" class="demo-form-inline">
        <el-form-item label="角色名">
          <el-input v-model="formInline.user" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="创建时间">
          <el-date-picker v-model="formInline.createValue" type="datetimerange" start-placeholder="开始日期" end-placeholder="结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="修改时间">
          <el-date-picker v-model="formInline.changeValue" type="datetimerange" start-placeholder="开始日期" end-placeholder="结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item class="button_group">
          <el-button type="primary" icon="el-icon-search" @click="onSubmit">查询</el-button>
          <el-button icon="el-icon-search" @click="onSubmit">重置</el-button>
        </el-form-item>
      </el-form>
    </section>
    <footer>
      <RoleManageFooter />
      <el-row type="flex" justify="end">
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage4" :page-sizes="[10, 20, 30, 40]" :page-size="10" layout="total, sizes, prev, pager, next, jumper" :total="40">
        </el-pagination>
      </el-row>
    </footer>
  </div>
</template>
<script>
import CommonHeader from "./CommonHeader"
import RoleManageFooter from "./RoleManageFooter"
export default {
  components: {
    CommonHeader,
    RoleManageFooter
  },
  data() {
    return {
      formInline: {
        user: '',
        createValue: [new Date(2000, 10, 10, 10, 10), new Date(2000, 10, 11, 10, 10)],
        changeValue: ''
      },
      //分页的数据
      currentPage4: 4
    };
  },
  methods: {
    onSubmit() {
      console.log('submit!');
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
.manage_role_box {
  width: 100%;
  // border: 1px solid red;
  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 50px;
    line-height: 50px;
    padding-left: 20px;
    border-bottom: 1px solid gray;
    i {
      font-size: 1.5rem;
    }
  }
  section {
    padding-top: 20px;
    border-bottom: 1px solid gray;
    .demo-form-inline {
      display: flex;
      justify-content: space-between;
      // border: 1px solid greenyellow;
      .button_group {
        // border: 1px solid red;
        width: 250px;
        display: flex;
        align-items: center;
      }
      /deep/ .el-input__inner {
        width: 150px;
      }
      /deep/ .el-date-editor--datetimerange.el-input__inner {
        width: 370px;
      }
    }
  }
  footer {
    padding-top: 10px;
  }
}
</style>