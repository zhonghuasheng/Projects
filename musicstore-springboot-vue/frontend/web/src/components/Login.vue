<template>
  <div class='login'>
    <el-form :model='user' :rules='rules' ref='loginForm'>
      <el-form-item prop='email'>
        <el-input v-model='user.email' auto-complete='on' placeholder='请输入邮箱'></el-input>
      </el-form-item>
      <el-form-item prop='password'>
        <el-input v-model='user.password' type='password' auto-complete='on' placeholder='请输入密码'></el-input>
      </el-form-item>
      <div class='box clearfix'>
        <span class='float-left' v-on:click='clearCookie'>忘记密码？</span>
        <div class='float-right'>
          <el-checkbox v-model='checked'>一周内自动登录</el-checkbox>
        </div>
      </div>
      <el-form-item>
          <el-button type='primary' class='w-100' v-on:click='loginAction(user)'>登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      user: {
        email: '',
        password: ''
      },
      checked: false,
      rules: {
        email: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { type: 'email', message: '请输入正确的邮箱格式', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: blur },
          { min: 6, max: 14, message: '密码长度在６到１４个字符', trigger: blur }
        ]
      }
    }
  },
  methods: {
    loginAction (user) {
      this.$refs['loginForm'].validate((valid) => {
        if (valid) {
          if (this.checked === true) {
            this.setCookie(this.user.email, this.user.password, 7)
          } else {
            this.clearCookie()
          }

          this.axios.post('http://localhost:8081/user/login', user).then((response) => {
            console.log(response.data)
          }).catch((response) => {
            console.log(response.data)
          })
        }
      })
    },
    setCookie (email, password, exdays) {
      var exdate = new Date()
      exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays)
      window.document.cookie = 'email' + '=' + email + ';path=/;expires=' + exdate.toGMTString()
      window.document.cookie = 'password' + '=' + password + ';path=/;expires=' + exdate.toGMTString()
    },
    clearCookie () {
      this.setCookie('', '', -1)
    }
  }
}
</script>
<style>
.login {
  min-width: 350px;
  width: 25%;
  margin: auto;
}
</style>
