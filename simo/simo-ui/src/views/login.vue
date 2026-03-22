<template>
  <div class="login">
    <div class="login-mask">
      <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form">
        <div class="sys-header">
          <i class="el-icon-camera-solid logo-icon"></i>
          <h3 class="title">Simo 摄影智能管理平台</h3>
        </div>
        
        <el-form-item prop="username">
          <el-input
            v-model="loginForm.username"
            type="text"
            auto-complete="off"
            placeholder="请输入摄影师账号"
          >
            <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
          </el-input>
        </el-form-item>
        
        <el-form-item prop="password">
          <el-input
            v-model="loginForm.password"
            type="password"
            auto-complete="off"
            placeholder="请输入密码"
            @keyup.enter.native="handleLogin"
          >
            <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon" />
          </el-input>
        </el-form-item>
        
        <el-form-item prop="code" v-if="captchaEnabled">
          <el-input
            v-model="loginForm.code"
            auto-complete="off"
            placeholder="验证码"
            style="width: 63%"
            @keyup.enter.native="handleLogin"
          >
            <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
          </el-input>
          <div class="login-code">
            <img :src="codeUrl" @click="getCode" class="login-code-img"/>
          </div>
        </el-form-item>
        
        <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px; color: #fff;">记住密码</el-checkbox>
        
        <el-form-item style="width:100%;">
          <el-button
            :loading="loading"
            size="medium"
            type="primary"
            style="width:100%; border-radius: 8px; font-weight: bold; font-size: 16px; background-color: #409EFF; border-color: #409EFF;"
            @click.native.prevent="handleLogin"
          >
            <span v-if="!loading">登 录 系 统</span>
            <span v-else>身 份 验 证 中...</span>
          </el-button>
          <div style="float: right;" v-if="register">
            <router-link class="link-type" :to="'/register'" style="color: #e0e0e0;">立即注册摄影师账号</router-link>
          </div>
        </el-form-item>
      </el-form>
    </div>
    
    <div class="el-login-footer">
      <span>Copyright © 2026 Simo Photography System All Rights Reserved.</span>
    </div>
  </div>
</template>

<script>
import { getCodeImg } from "@/api/login";
import Cookies from "js-cookie";
import { encrypt, decrypt } from '@/utils/jsencrypt'

export default {
  name: "Login",
  data() {
    return {
      codeUrl: "",
      loginForm: {
        username: "",
        password: "",
        rememberMe: false,
        code: "",
        uuid: ""
      },
      loginRules: {
        username: [
          { required: true, trigger: "blur", message: "请输入您的账号" }
        ],
        password: [
          { required: true, trigger: "blur", message: "请输入您的密码" }
        ],
        code: [{ required: true, trigger: "change", message: "请输入验证码" }]
      },
      loading: false,
      // 验证码开关
      captchaEnabled: true,
      // 注册开关
      register: true,
      redirect: undefined
    };
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect;
      },
      immediate: true
    }
  },
  created() {
    this.getCode();
    this.getCookie();
  },
  methods: {
    getCode() {
      getCodeImg().then(res => {
        this.captchaEnabled = res.captchaEnabled === undefined ? true : res.captchaEnabled;
        if (this.captchaEnabled) {
          this.codeUrl = "data:image/gif;base64," + res.img;
          this.loginForm.uuid = res.uuid;
        }
      });
    },
    getCookie() {
      const username = Cookies.get("username");
      const password = Cookies.get("password");
      const rememberMe = Cookies.get('rememberMe')
      this.loginForm = {
        username: username === undefined ? this.loginForm.username : username,
        password: password === undefined ? this.loginForm.password : decrypt(password),
        rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
      };
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true;
          if (this.loginForm.rememberMe) {
            Cookies.set("username", this.loginForm.username, { expires: 30 });
            Cookies.set("password", encrypt(this.loginForm.password), { expires: 30 });
            Cookies.set('rememberMe', this.loginForm.rememberMe, { expires: 30 });
          } else {
            Cookies.remove("username");
            Cookies.remove("password");
            Cookies.remove('rememberMe');
          }
          // 核心验证机制调用若依后端的 /login 接口
          this.$store.dispatch("Login", this.loginForm).then(() => {
            this.$router.push({ path: this.redirect || "/" }).catch(()=>{});
          }).catch(() => {
            this.loading = false;
            if (this.captchaEnabled) {
              this.getCode();
            }
          });
        }
      });
    }
  }
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  /* 建议你在 src/assets/images 目录下放一张高质量的摄影图片 login-background.jpg */
  background-image: url("../assets/images/login-background.jpg");
  background-size: cover;
  background-position: center;
}

/* 毛玻璃半透明遮罩层 */
.login-mask {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5); /* 暗色系遮罩更能凸显高级感 */
  backdrop-filter: blur(8px); /* 核心毛玻璃效果 */
}

.sys-header {
  text-align: center;
  margin-bottom: 30px;
  color: #fff;
  
  .logo-icon {
    font-size: 48px;
    margin-bottom: 10px;
    color: #409EFF;
    text-shadow: 0 2px 10px rgba(64, 158, 255, 0.5);
  }
}

.title {
  margin: 0px auto;
  font-size: 24px;
  font-weight: 600;
  letter-spacing: 2px;
}

.login-form {
  border-radius: 12px;
  background: rgba(255, 255, 255, 0.15); /* 表单半透明 */
  border: 1px solid rgba(255, 255, 255, 0.3);
  box-shadow: 0 8px 32px 0 rgba(0, 0, 0, 0.37);
  width: 420px;
  padding: 40px 35px 25px 35px;
  z-index: 1;

  ::v-deep .el-input__inner {
    background: rgba(255, 255, 255, 0.8);
    border: none;
    height: 42px;
    border-radius: 6px;
    font-size: 15px;
    &:focus {
      background: #fff;
      box-shadow: 0 0 8px rgba(64, 158, 255, 0.5);
    }
  }
  .input-icon {
    height: 42px;
    width: 14px;
    margin-left: 2px;
  }
}

.login-code {
  width: 33%;
  height: 42px;
  float: right;
  img {
    cursor: pointer;
    vertical-align: middle;
    height: 42px;
    border-radius: 6px;
  }
}
.el-login-footer {
  height: 40px;
  line-height: 40px;
  position: absolute;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: rgba(255, 255, 255, 0.7);
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 1px;
}
</style>