<template>
  <div>
    <van-form @submit="onSubmit" ref="codeForm">
      <van-field
        v-model="loginForm.phone"
        type="number"
        name="手机号"
        label="手机号"
        clearable
        right-icon="phone-o"
        placeholder="请输入手机号"
        :rules="[{ validator: validPhone, message: '手机号格式不正确'}]"
      />
      <van-field
        v-model="loginForm.sms"
        center
        clearable
        right-icon="certificate"
        label="短信验证码"
        placeholder="请输入短信验证码"
        style="margin-top: 5px;"
      >
        <van-button slot="button" size="small" type="primary" native-type="submit" v-show="show" @click="sendingCode">发送验证码</van-button>
        <van-button slot="button" size="small" type="primary" v-show="!show">{{count}}秒后重试</van-button>
      </van-field>
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
  name: 'CodeLogin',
  data () {
    return {
      loginForm: {
        phone: '',
        sms: ''
      },
      show: true,
      count: ''
    }
  },
  methods: {
    toRegister () {
      this.$refs.codeForm.resetValidation()
      this.$router.push('/register')
    },
    validPhone (val) {
      return /^1[34578]\d{9}$/.test(val)
    },
    onSubmit () {
    },
    resetVaild () {
      this.$refs.codeForm.resetValidation()
    },
    sendingCode () {
      this.$refs.codeForm.validate().then(res => {
        this.show = false
        this.count = 60
        setInterval(() => {
          if (this.count <= 0) {
            this.show = true
          } else {
            this.count = this.count - 1
          }
        }, 1000)
      })
    }
  }
}
</script>

<style scoped>

</style>
