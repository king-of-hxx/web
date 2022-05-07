<template>
  <div class="manage_user_box">
    <el-row class="left_bar">
      <el-col>
        <div class="left_bar_title">
          <i class="el-icon-s-custom"></i>
          <span>用户设置</span>
        </div>
        <el-menu default-active="2" class="el-menu-vertical-demo" router @open="handleOpen" @close="handleClose">
          <el-menu-item index="/home/personManage/userManage">
            <span slot="title">用户管理</span>
          </el-menu-item>
          <el-menu-item index="/home/personManage/organizationManage">
            <span slot="title">组织管理</span>
          </el-menu-item>
          <el-menu-item index="/home/personManage/roleManage">
            <span slot="title">角色管理</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <div class="show_manage">
      <router-view></router-view>
    </div>
  </div>
</template>
<script>
export default {
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>
<style lang="scss" scoped>
.manage_user_box {
  width: 100%;
  // border: 1px solid red;
  box-sizing: border-box;
  background-color: rgb(236, 245, 255);
  display: flex;
  .left_bar {
    height: 90vh;
    background-color: #fff;
    .el-col {
      width: 200px;
      .left_bar_title {
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 10px 10px;
      }
    }
    .el-icon-s-custom {
      font-size: 1.2rem;
    }
    span {
      height: 50px;
      line-height: 50px;
      font-size: 1.1rem;
    }
  }
  .show_manage {
    width: 100%;
    background-color: #fff;
    overflow: auto;
    padding: 10px;
  }
}
</style>