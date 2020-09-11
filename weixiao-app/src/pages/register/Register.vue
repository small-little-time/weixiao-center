<template>
  <div style="margin: 5px;">
    <van-form ref="userForm">
      <van-field
        v-model="registerForm.username"
        name="用户名"
        label="用户名"
        clearable
        right-icon="user-o"
        placeholder="用户名"
        :rules="[{ validator: validaUsername, message: '请填写用户名' }]"
      />
      <van-field
        v-model="registerForm.password"
        type="password"
        name="密码"
        label="密码"
        clearable
        right-icon="closed-eye"
        placeholder="密码"
        :rules="[{ required: true, message: '请输入密码' }]"
        style="margin-top: 5px;"
      />
      <van-field
        v-model="registerForm.password2"
        type="password"
        name="确认密码"
        label="确认密码"
        clearable
        right-icon="closed-eye"
        placeholder="确认密码"
        :rules="[{ validator: validPassword, message: '两次密码不一致' }]"
        style="margin-top: 5px;"
      />
      <div style="margin: 16px;">
        <van-button round block type="info" plain @click="onSubmit">
          注册
        </van-button>
      </div>
    </van-form>
  </div>
</template>

<script>
import { setToken } from '@/utils/auth'
import { canRegister, register } from './api/register'
import { Toast } from 'vant'
export default {
  name: 'RegisterUser',
  data () {
    return {
      registerForm: {
        username: '',
        password: '',
        password2: ''
      }
    }
  },
  methods: {
    validaUsername (val) {
      if (val === undefined || val === null || val === '') {
        return false
      }
      return new Promise(resolve => {
        canRegister(this.registerForm.username).then(res => {
          if (res.data === 1) {
            Toast.fail(res.message)
            resolve(res.data !== 1)
          }
        })
      })
    },
    validPassword (val) {
      return this.registerForm.password === this.registerForm.password2
    },
    onSubmit () {
      if (this.validPassword()) {
        const params = {
          username: this.registerForm.username,
          password: this.registerForm.password
        }
        const that = this
        register(params).then(res => {
          const id = res.data.id
          setToken(res.message)
          that.$emit('passId', id, this.registerForm.username, this.registerForm.password)
          Toast.success('注册成功！')
          setTimeout(function () {
            that.$parent.nextStep()
          }, 2000)
        })
      }
    }
  }
}
</script>

<style>

</style>
