<template>
  <div class="user_manage">
    <CommonHeader>
      <h3>用户管理</h3>
    </CommonHeader>
    <section>
      <el-form :model="formInline" class="demo-form-inline" @submit.native.prevent>
        <el-form-item label="用户名">
          <el-input v-model="formInline.keyWord" @keyup.enter.native="onSubmit" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <!-- <el-form-item label="员工姓名">
          <el-input v-model="formInline.username" @keyup.enter.native="onSubmit" placeholder="请输入员工姓名"></el-input>
        </el-form-item>
        <el-form-item label="组织" :label-width="formLabelWidth">
          <el-select v-model="formInline.department" @change="onSubmit" placeholder="请选择组织名称">
            <el-option v-for="item in organization" :key="item.departmentId" :label="item.name" :value="item.name"></el-option>
          </el-select>
        </el-form-item> -->
        <el-form-item class="button_group">
          <el-button type="primary" icon="el-icon-search" @click="onSubmit">查询</el-button>
          <el-button icon="el-icon-refresh" @click="reset">重置</el-button>
        </el-form-item>
      </el-form>
    </section>
    <footer>
      <UserManageFooter :tableData="tableData" @getUser="getUser" />
      <el-row type="flex" justify="end">
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[5, 10, 15, 20]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
        </el-pagination>
      </el-row>
    </footer>
  </div>
</template>
<script>
import { getAllUserList } from "@/api/userManage"
import CommonHeader from "./CommonHeader";
import UserManageFooter from "./UserManageFooter";
export default {
  components: {
    UserManageFooter,
    CommonHeader,
  },
  data() {
    return {
      formInline: {
        keyWord: "",
      },
      formLabelWidth: "120px",
      organization: [],
      //分页的数据
      tableData: [],
      pageSize: 5,
      currentPage: 1,
      total: 0,
    };
  },
  created() {
    this.getUser();
  },
  methods: {
    getUser() {
      let params = {
        currentPage: this.currentPage,
        pageSize: this.pageSize,
        keyWord: this.formInline.keyWord
      };
      getAllUserList(params).then((res) => {
        this.tableData = res.data.data.userList;
        this.total = res.data.data.total;
      });
    },
    onSubmit() {
      // this.currentPage = 1
      this.getUser();
    },
    reset() {
      this.formInline = {
        account: "",
      };
      this.getUser()
    },
    //分页的事件
    handleSizeChange(val) {
      // console.log(`每页 ${val} 条`);
      this.pageSize = val;
      this.getUser();
    },
    handleCurrentChange(val) {
      // console.log(`当前页: ${val}`);
      this.currentPage = val;
      this.getUser();
    },
  },
};
</script>
<style lang="scss" scoped>
.user_manage {
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
      /deep/ .el-form-item__content {
        display: flex;
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