<template>
  <div>
    <van-form @submit="onSubmit" ref="userForm">
      <van-field
        v-model="loginForm.username"
        name="用户名"
        label="用户名"
        clearable
        right-icon="user-o"
        placeholder="用户名"
        :rules="[{ required: true, message: '请填写用户名' }]"
      />
      <van-field
        v-show="!showPassword"
        v-model="loginForm.password"
        type="password"
        name="密码"
        label="密码"
        clearable
        right-icon="closed-eye"
        placeholder="密码"
        :rules="[{ required: true, message: '请填写密码' }]"
        style="margin-top: 5px;"
        @click-right-icon="changeShow"
      />
      <van-field
        v-show="showPassword"
        v-model="loginForm.password"
        name="密码"
        label="密码"
        clearable
        right-icon="closed-eye"
        placeholder="密码"
        :rules="[{ required: true, message: '请填写密码' }]"
        style="margin-top: 5px;"
        @click-right-icon="changeUnShow"
      />
      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">
          登录
        </van-button>
      </div>
    </van-form>
    <div style="margin: 16px;" @click="toRegister">
      <van-button round block type="info" plain>
        注册
      </van-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UserLogin',
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      showPassword: false
    }
  },
  methods: {
    toRegister () {
      this.$refs.userForm.resetValidation()
      this.$router.push('/register')
    },
    onSubmit (values) {
      this.$store.dispatch('Login', this.loginForm).then(res => {
        this.$store.dispatch('GetInfo').then(res => {
          this.$router.replace('/index')
        })
      })
    },
    resetVaild () {
      this.$refs.userForm.resetValidation()
    },
    changeShow () {
      this.showPassword = true
    },
    changeUnShow () {
      this.showPassword = false
    }
  }
}
</script>

<style scoped>

</style>
