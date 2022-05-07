<template>
  <div class="select-person">
    <p>
      <icon name="split" scale="2.0"></icon>
      选择签审人员
    </p>
    <div class="roleBox">
      <div class="select-reviewer" v-for="(role, index1) in roleLists" :key="index1">
        <div class="select-reviewer-info">
          <span class="character">{{
            role.roleDisplay == "BOM邮件通知" ? "" : "*"
          }}</span>
          <span class="text">{{ role.roleDisplay }}</span>
          <el-select v-model="role.roleList[0]" v-if="role.roleList[0] == '(DCC组)'" disabled filterable placeholder="请选择">
            <el-option v-for="(item, index2) in userList" :key="index2" :label="item.userFullName" :value="item.userName">
            </el-option>
          </el-select>
          <el-select v-model="role.roleList" v-else filterable multiple default-first-option placeholder="请选择">
            <el-option v-for="(item, index2) in userList" :key="index2" :label="item.userFullName" :value="item.userName">
            </el-option>
          </el-select>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
// import { getUserList } from "@/api/getUserList";
export default {
  props: {
    // roleLists: Array,
  },
  data() {
    return {
      userList: [],
      value: "",
      // roleLists: Array,
      roleLists:[
        {
        roleList:["(DCC组)"],
        roleDisplay:'BOM邮件通知',
        }
      ]
    };
  },
  methods: {
    // getUserList() {
    //   getUserList().then((response) => {
    //     this.userList = response.data;
    //     // this.userList.forEach(function(e) {
    //     //   e.label = e.userFullName;
    //     // });
    //     // console.log(11111111, this.userList);
    //     // console.log(2222222, this.roleLists[0].roleList);
    //   });
    // },
  },
  mounted() {
    // this.getUserList();
  },
};
</script>
<style lang="less" scoped>
.select-person {
  width: 100%;
  height: 25%;
  padding-top: 25px;
  border-bottom: 1px solid rgb(170, 168, 168);
  p {
    font-size: 20px;
    font-weight: bold;
  }
  .roleBox {
    display: flex;
    flex-wrap: wrap;
    .select-reviewer {
      display: flex;
      margin-right: 20px;
      .select-reviewer-info {
        margin-left: 40px;
        .text {
          width: 135px;
          box-shadow: 1px 1px 1px rgb(209, 207, 207);
          margin-right: 5px;
          text-align: left;
        }
        font-size: 16px;
        display: flex;
        align-items: center;
        .character {
          color: red;
          font-size: 30px;
          width: 18px;
          height: 18px;
          line-height: 28px;
          text-align: center;
          margin-left: 5px;
        }
        span:nth-child(2) {
          //   padding-left: 10px;
          // margin-right: 5px;
          line-height: 40px;
        }
      }
    }
  }
}
</style>
