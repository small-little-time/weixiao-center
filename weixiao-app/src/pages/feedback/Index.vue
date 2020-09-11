<template>
  <div style="padding: 5px;">
    <van-nav-bar
      title="反馈"
      right-text="提交"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
    />

    <van-field
      v-model="content"
      rows="4"
      autosize
      type="textarea"
      maxlength="100"
      placeholder="请输入反馈建议"
      show-word-limit
    />

  </div>
</template>

<script>
import { postFeedback } from './api/Feedback'
import { Notify } from 'vant'
export default {
  name: 'Feedback',
  data () {
    return {
      content: '',
      id: this.$store.getters.id
    }
  },
  methods: {
    onClickLeft () {
      this.$router.go(-1)
    },
    onClickRight () {
      if (this.content === '' || this.content == null) {
        return false
      }
      const data = {
        studentId: this.id,
        content: this.content
      }
      postFeedback(data).then(res => {
        Notify({ type: 'success', message: '感谢您的反馈！' })
        setTimeout(() => {
          this.$router.go(-1)
        }, 1000)
      })
    }
  }
}
</script>

<style>

</style>
