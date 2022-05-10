<template>
  <div class="user_manage_footer">
    <div class="button_group">
      <el-button type="primary" @click="add" icon="el-icon-plus">添加用户</el-button>
      <el-button type="primary" @click="deleteMoroUserList" icon="el-icon-minus">批量删除</el-button>
    </div>
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" :header-cell-style="{ background: 'rgb(247,247,247)' }" style="width: 100%" height="508px" :cell-style="cellStyle" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column label="用户名">
        <template slot-scope="scope">{{ scope.row.account }}</template>
      </el-table-column>
      <el-table-column prop="sex" label="性别" :formatter="formatSex"></el-table-column>
      <el-table-column prop="admin" label="是否是管理员" :formatter="formatAdmin"></el-table-column>
      <el-table-column label="操作" width="200">
        <template slot-scope="scope">
          <!-- <el-switch v-model="scope.row.isEffect" class="switchStyle" inactive-color="#ff4949" active-text="启用" inactive-text="禁用" active-value="1" inactive-value="0" @change="controlSwitch($event, scope.row.userId)"></el-switch> -->
          <!-- <i class="el-icon-view" @click="view(scope.row)"></i> -->
          <i class="el-icon-edit" @click="edit(scope.row)"></i>
          <i class="el-icon-delete" @click="deleteUser(scope.row.id)"></i>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog :title="title" :visible.sync="dialogFormVisible" width="40%" :before-close="cancel" :close-on-click-modal="false">
      <el-form :model="form" :rules="rules" ref="ruleForm">
        <el-form-item label="用户名" prop="account" :label-width="formLabelWidth">
          <el-input v-model="form.account" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
          <el-input type="password" v-model="form.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth">
          <el-radio v-model="form.sex" label="1">男</el-radio>
          <el-radio v-model="form.sex" label="0">女</el-radio>
        </el-form-item>
        <el-form-item label="用户级别" :label-width="formLabelWidth">
          <el-radio v-model="form.admin" label="1">管理员</el-radio>
          <el-radio v-model="form.admin" label="0">普通用户</el-radio>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel()">取 消</el-button>
        <el-button v-if="isModel" type="primary" @click="addUser('ruleForm')">确 定</el-button>
        <el-button v-else type="primary" @click="editUser('ruleForm',)">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { getAllUserList, addUser, deleteUser, updateUser } from "@/api/userManage";

export default {
  props: {
    tableData: Array,
  },
  data() {
    return {
      multipleSelection: [],
      //滑块数据
      isEffect: "1",
      //添加用户弹出框数据
      dialogFormVisible: false,
      dialogVisible: false,
      organization: [],
      form: {
        id: "",
        account: "",
        password: "",
        sex: "1", //性别选择
        admin: "0", //是否为管理员，0为普通用户，1是管理员
      },
      // departmentNumber:"衡变本部",
      formLabelWidth: "120px",
      //用来判断是更新用户的弹框还是添加用户的弹框
      isModel: true,
      title: "添加用户",
      rules: {
        account: [
          { required: true, message: "请输用户名", trigger: "blur" },
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },
    };
  },
  computed: {
    sex() {
      return this.viewRow.sex == "1" ? "男" : "女";
    },
  },
  created() { },
  mounted() { },
  methods: {
    addUser(formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          this.dialogFormVisible = false;
          const result = await addUser(this.form);
          if (result.data.code == 200) {
            this.$message.success("添加用户成功!");
            this.cancel();
            this.$emit("getUser")
          } else {
            this.$message.error(result.data.msg);
          }
        } else {
          return false;
        }
      });
    },
    add() {
      this.isModel = true;
      this.dialogFormVisible = true;
      this.title = "添加用户";
    },
    //查看用户
    view(row) {
      this.dialogVisible = true;
      this.viewRow = row;
      this.roleArr = row.roleVOList;
      console.log(this.viewRow);
    },
    async edit(row) {
      this.isModel = false;
      this.dialogFormVisible = true;
      this.title = "编辑用户";
      this.form = row;
      this.form.sex = row.sex.toString()
      this.form.admin = row.sex.toString()
    },
    editUser(formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          this.dialogFormVisible = false;
          const result = await updateUser(this.form);
          if (result.data.code == 200) {
            this.$message.success("修改用户成功!");
            this.cancel();
            this.$emit("getUser")
          } else {
            this.$message.error(result.data.msg);
          }
        } else {
          return false;
        }
      });
    },
    async deleteUser(id) {
      const ids = [];
      ids.push(id);
      const result = await deleteUser(ids);
      if (result.data.code == 200) {
        this.$message.success("删除成功!");
        this.cancel();
        this.$emit("getUser")
      } else {
        this.$message.error(result.data.msg);
      }
    },
    //批量删除
    async deleteMoroUserList() {
      const ids = [];
      this.multipleSelection.forEach((selectItem) => {
        ids.push(selectItem.id);
      });
      const result = await deleteUser(ids);
      if (result.data.code == 200) {
        this.$message.success("删除成功");
        this.cancel();
        this.$emit("getUser")
      } else {
        this.$message.error(result.data.msg);
      }
    },
    cancel() {
      this.dialogFormVisible = false;
      // this.$refs[formName].resetFields();
      this.form = {
        account: "",
        password: "",
        sex: "1", //性别选择
        admin: "0", //是否为管理员，0为普通用户，1是管理员
      };
    },
    formatSex(row) {
      return row.sex == "1" ? "男" : "女";
    },
    formatAdmin(row) {
      return row.admin == "1" ? "管理员" : "普通用户";
    },
    //控制角色的颜色
    cellStyle({ columnIndex }) {
      if (columnIndex === 3) {
        // 指定列号
        return "color:green";
      } else {
        return "";
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
      console.log(666, this.multipleSelection);
    },
    //改变滑块事件的回调
    async controlSwitch(isEffect, cmkeyid) {
      const isDisableRes = await isDisable(isEffect, cmkeyid);
      if (isDisableRes.status === 10000) {
        if (isEffect === "0") {
          this.$message.success("用户禁用成功!");
        } else {
          this.$message.success("用户解开成功!");
        }
      } else {
        return false;
      }
      console.log(isDisableRes);
    },
  },
};
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
  .user {
    display: flex;
    align-items: center;
    border: 1px solid red !important;
  }
  .user_detail {
    height: 280px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
  //滑块样式设置
  /deep/ .switchStyle .el-switch__label {
    position: absolute;
    display: none;
    color: #fff;
  }
  /deep/ .switchStyle .el-switch__label--left {
    z-index: 9;
    left: 8px;
    text-align: center;
  }
  /deep/ .switchStyle .el-switch__label--right {
    z-index: 9;
    left: -8px;
  }
  /deep/ .switchStyle .el-switch__label.is-active {
    display: block;
  }
  /deep/ .switchStyle.el-switch .el-switch__core,
  /deep/ .el-switch .el-switch__label {
    width: 50px !important;
  }
}
</style>