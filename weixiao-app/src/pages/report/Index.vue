<template>
  <div style="margin: 5px;">
    <van-nav-bar
      title="举报"
      left-arrow
      @click-left="onClickLeft"
    />

    <van-form @submit="onSubmit">
      <van-field
        v-model="title"
        name="内容"
        label="内容"
        readonly
      />
      <van-field
        v-model="reportForm.content"
        rows="2"
        autosize
        label="原因说明"
        type="textarea"
        maxlength="100"
        show-word-limit
        placeholder="请输入原因说明"
        :rules="[{ required: true, message: '原因说明不能为空' }]"
      />
      <div style="margin: 16px;">
        <van-button round block type="info" native-type="submit">
          提交
        </van-button>
      </div>
    </van-form>

  </div>
</template>

<script>
import { postReport } from './api/Report'
import { Notify } from 'vant'
export default {
  name: 'Report',
  data () {
    return {
      title: '',
      reportForm: {
        content: '',
        studentId: '',
        studentName: '',
        postId: '',
        reportStudentId: '',
        categoryId: ''
      }
    }
  },
  methods: {
    onClickLeft () {
      this.$router.go(-1)
    },
    onSubmit () {
      postReport(this.reportForm).then(res => {
        Notify({ type: 'success', message: '举报成功' })
        setTimeout(() => {
          this.$router.go(-1)
        }, 1000)
      })
    },
    initData () {
      this.title = this.$route.query.title
      this.reportForm.postId = this.$route.query.postId
      this.reportForm.reportStudentId = this.$route.query.reportStudentId
      this.reportForm.categoryId = this.$route.query.categoryId
      this.reportForm.studentId = this.$store.getters.id
      this.reportForm.studentName = this.$store.getters.nickname
    }
  },
  mounted () {
    this.initData()
  }
}
</script>

<style>

</style>
