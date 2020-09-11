<template>
  <div style="padding: 5px;">
    <van-nav-bar
      title="活动报名"
      left-arrow
      @click-left="onClickLeft"
    />

    <van-form @submit="onSubmit">
      <van-field
        v-model="title"
        name="活动标题"
        label="活动标题"
        readonly
      />
      <van-field
        v-model="truename"
        name="我的姓名"
        label="我的姓名"
        readonly
      />
      <van-field
        v-model="signForm.qq"
        name="qq"
        label="qq"
        placeholder="qq"
        type="digit"
        :rules="[{ validator: validatorQq, message: '请填写正确的qq' }]"
      />
      <van-field
        v-model="signForm.phone"
        name="电话"
        label="电话"
        placeholder="电话"
        type="digit"
        :rules="[{ validator: validatorPhone, message: '请填写正确的电话' }]"
      />
      <van-field
        v-model="signForm.message"
        rows="2"
        autosize
        label="备注"
        type="textarea"
        maxlength="50"
        placeholder="请输入备注"
        show-word-limit
      />
      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">
          报名
        </van-button>
      </div>
    </van-form>

  </div>
</template>

<script>
import { Notify } from 'vant'
import { postSign } from './api/sign'
export default {
  name: 'Sign',
  data () {
    return {
      title: 'activityName',
      truename: this.$store.getters.truename,
      signForm: {
        activityId: '',
        studentId: this.$store.getters.id,
        qq: '',
        phone: '',
        message: ''
      }
    }
  },
  methods: {
    validatorQq (val) {
      return /^\d{6,11}$/.test(val)
    },
    validatorPhone (val) {
      return /^1[34578]\d{9}$/.test(val)
    },
    onClickLeft () {
      this.$router.go(-1)
    },
    onSubmit () {
      postSign(this.signForm).then(res => {
        Notify({ type: 'success', message: '报名成功' })
        setTimeout(() => {
          this.$router.go(-1)
        }, 1000)
      })
    },
    initData () {
      this.title = this.$route.query.title
      this.signForm.activityId = this.$route.query.id
    }
  },
  mounted () {
    this.initData()
  }
}
</script>

<style scoped>

</style>
