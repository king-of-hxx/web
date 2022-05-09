<template>
  <div class="fullContain">
    <div class="login">
      <header class="login-title">
        <h5>
          <!-- <img src="../../static/img/assemblingimg/u8.png" alt="" /> -->
          BDSD
        </h5>
        <span>行为检测系统设计</span>
        <span>Behavior Detection System Design</span>
      </header>
      <footer>
        <keep-alive>
          <div class="input-group">
            <el-input prefix-icon="el-icon-user" suffix-icon="el-icon-warning-outline" v-model="loginData.account" placeholder="Enter your username"></el-input>
            <el-input prefix-icon="el-icon-unlock" placeholder="input password" v-model="loginData.password" @keyup.enter.native="login" show-password></el-input>
          </div>
        </keep-alive>
        <el-button type="primary" @click="login">登录</el-button>
      </footer>
      <div class="tag">
        <ul>
          <li>帮助</li>
          <li>隐私</li>
          <li>条款</li>
        </ul>
        <div>
          <span>copyright&copy;</span>
          <span>2022</span>
          <span>行为检测系统设计与实现</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Login } from "@/api/Login";
import { setToken } from "@/utils/auth"
import cookie from 'js-cookie'

export default {
  name: 'login',
  data() {
    return {
      msg: '',
      loginData: {
        account: "",
        password: ""
      }
    }
  },
  created() {
    // this.loginData.password = cookie.get("password");
    // this.loginData.username = cookie.get("username");
    // if (cookie.get('token') && cookie.get('refreshToken')) {
    //   this.$router.push(`/home`)
    // }
  },
  methods: {
    async login() {
      console.log(this.loginData);
      if (this.loginData.account.trim() === "") {
        this.$message.warning("请输入用户名！");
      } else if (this.loginData.password.trim() === "") {
        this.$message.warning("请输入密码！");
      } else {
        //登录接口
        const res = await Login(this.loginData)
        console.log(res);
        if (res.data.code == 200) {
          this.$message.success("登陆成功");
          this.$router.push(`/home`);
        }

        // cookie.set("refreshToken", this.loginData.password);
        // cookie.set("username", this.loginData.username);
        // cookie.set("password", this.loginData.password);
        // localStorage.setItem("username", this.loginData.username);
        // localStorage.setItem("password", this.loginData.password);
        // let form = new FormData();
        // form.append("username", this.loginData.username);
        // form.append("password", this.loginData.password);

        // login(form).then(response => {
        //   if (response.status == 200) {
        //     this.$message.success(response.message);
        //     cookie.set("token", response.body.token);
        //     cookie.set("refreshToken", response.body.refreshToken);
        //     this.$router.push(`/home`);
        //   }
        // });
      }
    }
  }
}
</script>

<style scoped>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.fullContain {
  /* width: 100%; */
  height: 100vh;
  background: url("../../static/assets/suanfa.jpg") no-repeat;
  background-size: 100% 100%;
  padding-top: 15vh;
}

.login {
  padding-top: 40px;
  width: 30vw;
  height: 70vh;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  background-color: #fff;
  filter: drop-shadow(0 0 16px #f1f3f2);
  /* border: 1px solid red; */
}

.login .login-title {
  width: 30vw;
  height: 10vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  opacity: 0.8;
  font-size: 22px;
  font-weight: 600;
  background-color: transparent;
  border: none;
  text-align: center;
  color: #929191;
  letter-spacing: 0;
  /* border: 1px solid red; */
}
.login .login-title h5 {
  margin-bottom: 10px;
  font-weight: 800;
  font-size: 1.8rem;
  color: rgb(0, 50, 141);
}
.login .login-title span:first-child {
  margin-bottom: 10px;
}

footer {
  width: 30vw;
  height: 30vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  /* border: 1px solid yellow; */
}

footer .input-group {
  width: 20vw;
  /* border: 1px solid blue; */
}

footer .el-input {
  width: 20vw;
  /* padding-left: 38px !important; */
}

footer .input-group .el-input:first-child {
  margin-bottom: 20px;
}

footer .el-button {
  width: 20vw;
  height: 35px;
  padding: 10px !important;
  color: white;
  margin-top: 50px;
  border: 0;
  background-color: rgb(67, 164, 253);
}
.login .tag {
  height: 10vh;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  /* border: 1px solid black; */
}
.login .tag ul {
  list-style-type: none;
  display: flex;
  color: rgb(120, 120, 133);
}
.login .tag ul li:nth-of-type(2) {
  margin: 0px 30px;
}
.login .tag span {
  color: rgb(178, 178, 178);
}
</style>
