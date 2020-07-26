<template>
  <div class="login-container">
    <div class="login-box">
      <div class="avatar-box">
        <img src="../assets/logo.png">
      </div>
      <el-form ref="loginFormRef" :model="loginForm" :rules="rules" label-width="0px" class="login-form">
        <el-form-item prop="username">
          <el-input prefix-icon="el-icon-search" v-model="loginForm.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" prefix-icon="el-icon-search" v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item class="btns">
          <el-button type="primary" @click.prevent="login">登陆</el-button>
          <el-button type="info" @click="resetLoginForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        loginForm: {
          username: 'admin',
          password: 'admin111111'
        },
        rules: {
          username: [
            {
              required: true,
              message: '请输入用户名',
              trigger: 'blur'
            },
            {
              min: 2,
              max: 20,
              message: '长度在 3 到 20 个字符',
              trigger: 'blur'
            }
          ],
          password: [
            {
              required: true,
              message: '请输入登录密码',
              trigger: 'blur'
            },
            {
              min: 6,
              max: 16,
              message: '长度在6到16个字符',
              trigger: 'blur'
            }
          ]
        }
      }
    },
    methods: {
      resetLoginForm () {
        this.$refs.loginFormRef.resetFields()
      },
      login () {
        this.$refs.loginFormRef.validate((valid) => {
          // console.log(valid);
          if (valid) {
            this.$http.post('login', this.loginForm)
              .then(response => {
                if (response.data.code > 0) {
                  this.$message.success('登录成功')
                  window.sessionStorage.setItem('x_auth_token', response.data.data)
                  this.$router.push('/home')
                } else {
                  this.$message.error('登录失败')
                }
              }, function () {

              })
          }
        })
      }
    }
  }
</script>

<style lang="less" scoped>
  .login-container {
    background-color: #2b4b6b;
    height: 100%;
  }

  .login-box {
    width: 450px;
    height: 300px;
    background-color: #ffffff;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);

    .avatar-box {
      height: 130px;
      width: 130px;
      border: 1px solid #eeeeee;
      border-radius: 50%;
      padding: 10px;
      box-shadow: 0 0 10px #ddd;
      position: absolute;
      left: 50%;
      transform: translate(-50%, -50%);
      background-color: #eeeeee;

      img {
        width: 100%;
        height: 100%;
        border-radius: 50%;
        background-color: #eeeeee;
      }
    }
  }

  .btns {
    display: flex;
    justify-content: flex-end;
  }

  .login-form {
    width: 100%;
    position: absolute;
    bottom: 0;
    padding: 0 20px;
    box-sizing: border-box;
  }

</style>
