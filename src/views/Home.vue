<template>
  <div id="app">
    <el-container>
      <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
        <div class="user-info" :style="{ height: isCollapse == true ? '6.7vh' : '38vh' }">
          <div class="logo">
            <div :style="isCollapse ? header : ''">
              <span>BDSD</span>
              <span style="white-space: nowrap;" v-if="isCollapse == false">行为检测系统</span>
            </div>
            <span v-if="isCollapse == false"></span>
          </div>
          <i v-if="isCollapse == false" class="person-img">
            <img src="../../static/assets/suanfa.jpg" alt="" style="width: 10vw;height: 20vh;" />
          </i>
          <div v-if="isCollapse == false" style="display:flex;flex-direction: column;margin-bottom:20px;font-size:17px">
            <span>管理员</span>
            <span>阿龙</span>
          </div>
        </div>
        <div>
          <ul class="menu-item-group">
            <!-- <li :style="isCollapse ? '' : open" @click="toHome">
              <div> <img src="../../static/img/homeimg/u188.png" alt=""> </div>
              <span v-show="!isCollapse">首页</span>
            </li> -->
            <li :style="isCollapse ? '' : open" @click="manageUser">
              <div> <i class="el-icon-s-custom"></i> </div>
              <span v-show="!isCollapse">用户信息</span>
            </li>
            <li :style="isCollapse ? '' : open" @click="behaviorDetection">
              <div> <img src="../../static/img/homeimg/u190.png" alt=""> </div>
              <span v-show="!isCollapse">行为检测</span>
            </li>
            <li :style="isCollapse ? '' : open" @click="densityDetection">
              <div> <img src="../../static/img/homeimg/u190.png" alt=""> </div>
              <span v-show="!isCollapse">密度检测</span>
            </li>
            <li @click="panicDetection" :style="isCollapse ? '' : open">
              <div> <img src="../../static/img/homeimg/u194.png" alt=""> </div>
              <span v-show="!isCollapse">恐慌检测</span>
            </li>
            <!-- <li @click="xitong" :style="isCollapse ? '' : open">
              <div> <img src="../../static/img/homeimg/u196.png" alt=""> </div>
              <span v-show="!isCollapse">系统设置</span>
            </li>
            <li @click="packingPlan" :style="isCollapse ? '' : open">
              <div> <img src="../../static/img/homeimg/u1789.png" alt=""> </div>
              <span v-show="!isCollapse">包装计划</span>
            </li>
            <li @click="iqc" :style="isCollapse ? '' : open">
              <div> <img src="../../static/img/homeimg/u190.png" alt=""> </div>
              <span v-show="!isCollapse">质检</span>
            </li>
            <li :style="isCollapse ? '' : open" @click="tank">
              <div> <img src="../../static/img/homeimg/u190.png" alt=""> </div>
              <span v-show="!isCollapse">油箱车间</span>
            </li> -->
          </ul>
        </div>
      </el-menu>
      <el-container>
        <el-header>
          <div style="display:flex;align-items: center;">
            <el-button-group v-model="isCollapse">
              <el-button :label="true" v-if="isCollapse == false" @click="changeIsCollapse" style="background:rgb(48, 129, 220)">
                <i class="el-icon-d-arrow-left" style="font-size:1.7rem;color: #ffffff;font-weight:bold"></i>
              </el-button>
              <el-button :label="false" v-else @click="changeIsCollapse" style="background:rgb(48, 129, 220)">
                <i class="el-icon-d-arrow-right" style="font-size:1.7rem;color: #ffffff;font-weight:bold"></i>
              </el-button>
            </el-button-group>
            <div class="right">
              <span>行为检测系统设计</span>
              <span>Behavior Detection System Design</span>
            </div>
          </div>
          <div class="icon" style="display:flex;align-items: center">
            <i class="el-icon-bell"></i>
            <i class="el-icon-right"></i>
          </div>
        </el-header>
        <keep-alive>
          <router-view class="content"></router-view>
        </keep-alive>
      </el-container>
    </el-container>
  </div>
</template>
<script>
import ContentBody from '@/components/contentBody/ContentBody.vue'
export default {
  components: {
    ContentBody,
  },
  // name:["Pproduction"],
  data() {
    return {
      //需要被 keep-alive
      // cacheRoute:["Pproduction"],
      isCollapse: true,
      open: {
        width: "35%",
        height: "120px"
      },
      header: {
        display: "flex",
        height: "6.7vh",
        "align-items": "center",
        "font-size": "1.2rem"
      }
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    toHome() {
      this.$router.push({
        name: "ContentBody"
      });
    },
    manageUser() {
      this.$router.push({
        name: "PersonManage"
      })
    },
    behaviorDetection() {
      this.$router.push({
        name: "behaviorDetection"
      });
    },
    densityDetection() {
      this.$router.push({
        name: "densityDetection"
      });
    },
    panicDetection() {
      this.$router.push({
        name: "panicDetection"
      });
    },
    computingTask() {
      this.$router.push({
        name: "Qrcode"
      });
    },
    xitong() {
      this.$router.push({
        name: "Qrcode"
      });
    },
    packingPlan() {
      this.$router.push({
        name: "packingPlan"
      });
    },
    iqc() {
      this.$router.push({
        name: "Iqc"
      });
    },
    tank() {
      this.$router.push({
        name: "Tank"
      });
    },
    changeIsCollapse() {
      this.isCollapse = !this.isCollapse;
    }
  }
};
</script>
<style scoped>
* {
  border: 0;
}
.el-header {
  text-align: center;
  height: 6.7vh !important;
  padding: 0 !important;
  display: flex;
  justify-content: space-between;
  color: white;
  font-weight: 1000;
  font-size: 1.5rem;
  background: linear-gradient(to right, rgb(48, 129, 220), rgb(25, 187, 107));
}
.right span:first-child {
  margin: 0 20px;
}
.icon i:last-child {
  margin: 0 20px;
}
.user-info {
  /* height: 30vh; */
  color: white;
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  background: rgb(48, 129, 220);
}
.logo {
  background: rgb(48, 129, 220);
  /* height: 62px !important; */
  width: 100%;
  margin: 0 !important;
  color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
  white-space: wrap;
  text-overflow: ellipsis !important;
  font-weight: 800;
  font-size: 1.3rem;
}
.logo span:first-child {
  font-style: italic;
}
.logo span:last-of-type {
  overflow: hidden;
}
.el-menu {
  height: 100vh;
}
.person-img {
  margin-top: 10px;
}
.user-info img {
  border-radius: 50%;
  overflow: hidden;
}
.menu-item-group {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  justify-content: space-around;
}

li span {
  color: black;
  font-size: 20px;
  font-weight: 600;
}
.menu-item-group li:hover {
  transform: translateX(-4px);
}
li {
  display: flex;
  flex-direction: column;
  height: 80px;
  margin-top: 10px;
  cursor: pointer;
  /* border: 1px solid red; */
}
li .el-icon-s-custom {
  font-size: 65px;
  color: rgb(50, 150, 251);
}
li div img {
  width: 60px;
  height: 60px;
}
.el-button {
  padding: 0px !important;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 300px;
  min-height: 400px;
  text-align: center;
  height: 100vh;
}
.btn-display {
  display: none;
}
@media screen and (max-width: 500px) {
  .el-menu-vertical-demo {
    display: none;
  }
  .el-header {
    font-size: 1rem;
    font-weight: 300;
    color: rgb(0, 255, 255);
  }
  .el-button-group {
    display: none;
  }
  .btn-display {
    display: block;
    margin-right: 10px;
  }
}
.content {
  padding: 10px;
  background-color: rgb(236, 245, 255);
}
.el-container {
  background-color: #e6f1fc;
}
</style>
