<template>
  <div style="background: #F0F8FF">
    <van-image
      fit="contain"
      src="./static/images/index-logo.jpg"
    />
    <van-tabs v-model="active" animated color="#1989fa" @change="tabChange" style="margin-top: 20px;">
      <van-tab name="userlogin">
        <div slot="title">
          <van-icon name="more-o" />
          <span>密码登录</span>
        </div>
        <div style="margin: 16px;">
          <user-login ref="userLogin"></user-login>
        </div>
      </van-tab>
      <van-tab name="codelogin">
        <div slot="title">
          <van-icon name="more-o" />
          <span>短信登录</span>
        </div>
        <div style="margin: 16px;">
          <code-login ref="codeLogin"></code-login>
        </div>
      </van-tab>
    </van-tabs>
  </div>
</template>

<script>
import CodeLogin from './CodeLogin'
import UserLogin from './UserLogin'
export default {
  name: 'Index',
  components: {
    UserLogin,
    CodeLogin
  },
  data () {
    return {
      active: ''
    }
  },
  methods: {
    tabChange () {
      if (this.active === 'userlogin') {
        if (this.$refs.userLogin !== undefined) {
          this.$refs.userLogin.resetVaild()
        }
      } else if (this.active === 'codelogin') {
        if (this.$refs.codeLogin !== undefined) {
          this.$refs.codeLogin.resetVaild()
        }
      }
    },
    clearStorage () {
      sessionStorage.clear()
    }
  },
  mounted () {
    this.clearStorage()
  }
}
</script>

<style>
.van-tab {
  background: #F0F8FF;
}
</style>
