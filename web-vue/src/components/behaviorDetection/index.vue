<template>
  <div id="dotaskApp">
    <div class="headr">
      <router-link to="/home"><i class="el-icon-s-home"></i></router-link>
      <span style="">行为检测</span>
    </div>
    <el-row>
      <div>
        <span>行为检测</span>
      </div>
    </el-row>
  </div>
</template>
<script>
export default {
  name: "densityDetection",
  data() {
    return {
      fits: 'cover',
      flag: false,
    }
  },
  computed: {
  },
  created() { },
  mounted() {
  },
  methods: {}
}
</script>
<style scoped lang="less">
#dotaskApp {
  .headr {
    height: 40px;
    text-align: left;
    line-height: 40px;
    padding-left: 5px;
    color: #fff;
    background: linear-gradient(to right, rgb(48, 129, 220), rgb(25, 187, 107));
    .el-icon-s-home {
      font-size: 25px;
      color: #fff;
    }
    span {
      font-size: 14px;
      padding-left: 2px;
    }
  }
  div:nth-child(2) {
    margin-top: 5px;
    padding-bottom: 5px;
    margin-left: 10px;
    height: 40px;
    div {
      float: left;
      .el-image {
        width: 33px;
        float: left;
      }
      span {
        line-height: 40px;
        font-weight: 700;
        padding-left: 2px;
      }
    }
    .el-input {
      float: right;
    }
  }
}
</style>
