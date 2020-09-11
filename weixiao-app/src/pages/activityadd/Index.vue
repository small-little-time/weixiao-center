<template>
  <div>
    <van-nav-bar
      title="发布活动"
      left-arrow
      @click-left="onClickLeft"
    >
      <template #right>
        <van-button round type="info" size="mini" @click="publishActivity">发布</van-button>
      </template>
    </van-nav-bar>

    <div class="animated zoomIn" style="margin-left: 5px;margin-right: 5px;">
      <div style="margin-top: 10px;background: white;padding: 5px;text-align: left;">
        <div style="display: flex;">
          <van-image round :src="avatar" class="img"/>
          <div class="content">
            <span class="publisher">{{nickname}}</span>
          </div>
        </div>

        <van-dropdown-menu>
          <van-dropdown-item v-model="type" :options="activityTypeOption" />
        </van-dropdown-menu>

        <van-field
          v-model="title"
          clearable
          label="标题"
          maxlength="15"
          placeholder="请输入活动标题"
        />

        <van-field
          v-model="abs"
          clearable
          maxlength="25"
          label="摘要"
          placeholder="请输入摘要"
        />

        <van-field name="time" label="开始时间"
            v-model="startTime"
            placeholder="选择时间"
            readonly="readonly"
            @click="startTimePop = true" />

        <van-field name="time" label="结束时间"
            v-model="endTime"
            placeholder="选择时间"
            readonly="readonly"
            @click="endTimePop = true" />

        <van-field name="stepper" label="人数上限" v-show="type === 2">
          <template #input>
            <van-stepper v-model="maxNumber" min="1" max="500"/>
          </template>
        </van-field>

        <van-field
          v-model="content"
          rows="5"
          type="textarea"
          placeholder="填写你的活动内容吧~"
        />

        <van-dropdown-menu class="dropdown">
          <van-dropdown-item v-model="category" :options="categories" />
        </van-dropdown-menu>

        <van-uploader
          :max-count="9"
          :max-size="maxSize"
          v-model="fileList"
          :before-read="beforeRead"
          :after-read="afterRead"
          :before-delete="beforeDelete"
          style="margin-top: 5px;" />
      </div>
    </div>

    <van-popup v-model="startTimePop" label="开始时间" position="bottom" :overlay="true" >
      <van-datetime-picker
        v-model="currentDate"
        title="请选择时间"
        type="datetime"
        :minDate="minDate"
        @cancel="startTimeSelectCancel"
        @confirm="startTimeSelect"
        @change="startTimeChange"
      />
    </van-popup>

    <van-popup v-model="endTimePop" label="结束时间" position="bottom" :overlay="true" >
      <van-datetime-picker
        v-model="currentDate"
        title="请选择时间"
        type="datetime"
        :minDate="minDate"
        @cancel="endTimeSelectCancel"
        @confirm="endTimeSelect"
        @change="endTimeChange"
      />
    </van-popup>

  </div>
</template>

<script>
import { getMaxSize } from '@/api/config'
import { getCategory } from '@/api/category'
import { upload, postActivity } from './api/ActivityAdd'
import { Toast, Notify } from 'vant'
export default {
  name: 'ActivityAdd',
  data () {
    return {
      studentId: '',
      title: '',
      abs: '',
      content: '',
      maxNumber: 30,
      category: 1,
      type: 1,
      startTime: '',
      endTime: '',
      startTimePop: false,
      endTimePop: false,
      currentDate: '',
      minDate: new Date(2020, 0, 1),
      fileList: [],
      images: [],
      avatar: '',
      nickname: '',
      categories: [],
      activityTypeOption: [
        { text: '组织活动', value: 1 },
        { text: '报名活动', value: 2 }
      ],
      maxSize: getMaxSize()
    }
  },
  methods: {
    startTimeChange (e) {
      let activityTimeArr = e.getValues()
      this.startTime = `${activityTimeArr[0]}-${activityTimeArr[1]}-${activityTimeArr[2]} ${activityTimeArr[3]}:${activityTimeArr[4]}:00`
    },
    startTimeSelect () {
      this.startTimePop = false
    },
    startTimeSelectCancel () {
      this.startTime = ''
      this.startTimePop = false
    },
    endTimeChange (e) {
      let activityTimeArr = e.getValues()
      this.endTime = `${activityTimeArr[0]}-${activityTimeArr[1]}-${activityTimeArr[2]} ${activityTimeArr[3]}:${activityTimeArr[4]}:00`
    },
    endTimeSelect () {
      this.endTimePop = false
    },
    endTimeSelectCancel () {
      this.endTime = ''
      this.endTimePop = false
    },
    onClickLeft () {
      this.$router.go(-1)
    },
    beforeRead (file) {
      if (file.size > this.maxSize) {
        const data = this.maxSize / 1048576
        Toast.fail('图片大小限制' + data + 'M~')
        return false
      } else {
        return true
      }
    },
    afterRead (file) {
      const formData = new FormData()
      formData.append('id', this.studentId)
      formData.append('file', file.file)
      upload(formData).then(res => {
        this.fileList[this.fileList.length - 1].url = res.data
        this.images.push(res.data)
      })
      // 此时可以自行将文件上传至服务器
    },
    beforeDelete (file) {
      const index = this.images.indexOf(file.url)
      this.images.splice(index, 1)
      return true
    },
    getCategories () {
      getCategory().then(res => {
        this.value = res.data.entities[0].id
        this.categories = res.data.entities.map(item => {
          const data = {
            value: item.id,
            text: item.categoryName
          }
          return data
        })
      })
    },
    publishActivity () {
      if (this.vaildProp()) {
        const params = {
          studentId: this.studentId,
          type: this.type,
          title: this.title,
          abs: this.abs,
          startTime: this.startTime,
          endTime: this.endTime,
          maxNumber: this.maxNumber,
          content: this.content.replace(/\r\n/g, '<br/>').replace(/\n/g, '<br/>').replace(/\s/g, '&nbsp;'),
          images: this.images.join(';'),
          category: this.value
        }
        postActivity(params).then(res => {
          Notify({ type: 'success', message: '发布成功' })
          setTimeout(() => {
            this.$router.go(-1)
          }, 1000)
        })
      }
    },
    vaildProp () {
      if (this.title === '' || this.title === null || this.title === undefined) {
        Toast.fail('标题不能为空')
        return false
      } else if (this.startTime === '' || this.startTime === null || this.startTime === undefined) {
        Toast.fail('开始时间不能为空')
        return false
      } else if (this.endTime === '' || this.endTime === null || this.endTime === undefined) {
        Toast.fail('结束时间不能为空')
        return false
      } else if (this.content === '' || this.content === null || this.content === undefined) {
        Toast.fail('内容不能为空')
        return false
      } else {
        return true
      }
    }
  },
  mounted: function () {
    this.studentId = this.$store.getters.id
    this.avatar = this.$store.getters.faceImgMin
    this.nickname = this.$store.getters.nickname
    this.getCategories()
  }
}
</script>

<style scoped>
.content {
  padding-top: 8px;
  text-align: left;
}
.publisher {
  margin: 0;
  font-size: 14px;
  line-height: 20px;
}
.img {
  flex-shrink: 0 !important;
  width: 36px !important;
  height: 36px !important;
  margin-right: 8px !important;
}
.dropdown {
  height: auto;
  padding: 5px;
}
.dropdown >>> .van-ellipsis {
  padding: 5px;
  border: 1px solid #1E90FF;
  border-radius: 25px;
  color: #1E90FF;
  width: 52px;
  text-align: center;
}
.van-dropdown-menu {
  height: 30px;
}
</style>

<style>
.van-dropdown-menu__item {
  justify-content: left;
}
</style>
