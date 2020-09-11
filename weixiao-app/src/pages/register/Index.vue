<template>
  <div>
    <van-image
      fit="contain"
      src="./static/images/index-register.jpg"
    />
    <van-steps
      :active="active"
      active-icon="success"
      active-color="#38f"
      style="text-align: justify;"
    >
      <van-step>账号密码</van-step>
      <van-step>个人信息</van-step>
      <van-step>其他设置</van-step>
      <van-step>注册完成</van-step>
    </van-steps>
      <van-button v-show="showButton && active === 2" type="default" size="mini" @click="nextStep" round plain color="#A9A9A9" class="stepButton">跳过</van-button>
    <register-user v-show="active === 0" class="animated bounceInRight" @passId="getId"></register-user>
    <register-info v-show="active === 1" class="animated bounceInRight" @passInfoForm="getInfoForm"></register-info>
    <register-setting v-show="active === 2" class="animated bounceInRight" @passSettingForm="getSettingForm"></register-setting>
    <register-success v-show="active === 3" class="animated heartBeat" @updateInfo="update"></register-success>
  </div>
</template>

<script>
import { updateInfo } from './api/register'
import { Toast } from 'vant'
import { getToken } from '@/utils/auth'
import RegisterUser from './Register'
import RegisterInfo from './Info'
import RegisterSetting from './Setting'
import RegisterSuccess from './Success'
export default {
  name: 'Register',
  data () {
    return {
      active: 0,
      showButton: false,
      infoForm: {},
      id: '',
      username: '',
      password: ''
    }
  },
  components: {
    RegisterUser,
    RegisterInfo,
    RegisterSetting,
    RegisterSuccess
  },
  methods: {
    nextStep () {
      this.showButton = true
      this.active = this.active + 1
      if (this.active >= 3) {
        this.showButton = false
      }
    },
    getId (val, username, password) {
      this.id = val
      this.username = username
      this.password = password
      console.log(this.id)
    },
    getInfoForm (infoForm) {
      this.infoForm = infoForm
      console.log(this.infoForm)
    },
    getSettingForm (settingForm) {
      this.infoForm.hide = settingForm.hide === true ? 1 : 0
      this.infoForm.chat = settingForm.chat === true ? 1 : 0
      this.infoForm.sexs = settingForm.sexs === true ? 1 : 0
      this.infoForm.academy = settingForm.academy === true ? 1 : 0
      console.log(this.infoForm)
    },
    update () {
      this.infoForm.id = this.id
      const para = this.infoForm
      const loginForm = {
        username: this.username,
        password: this.password
      }
      Toast.loading()
      updateInfo(para, getToken()).then((res) => {
        this.$store.dispatch('Login', loginForm).then(res => {
          this.$store.dispatch('GetInfo').then(res => {
            Toast.clear()
            this.$router.replace('/index')
          })
        })
      })
    }
  }
}
</script>

<style>
.stepButton {
  background: #F0F8FF;
  margin: 5px;
  float: right;
}
</style>
