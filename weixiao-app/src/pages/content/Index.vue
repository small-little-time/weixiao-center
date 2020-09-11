<template>
  <div>
    <van-nav-bar
      title="发布动态"
      left-arrow
      @click-left="onClickLeft"
    >
      <template #right>
        <van-button round type="info" size="mini" @click="publishContent">发布</van-button>
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

      <van-field
        v-model="content"
        rows="5"
        type="textarea"
        placeholder="分享你的动态吧~"
      />

      <van-dropdown-menu class="dropdown">
        <van-dropdown-item v-model="value" :options="categories" />
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

  </div>
</template>

<script>
import { getMaxSize } from '@/api/config'
import { getCategory } from '@/api/category'
import { upload, postContent } from './api/Content'
import { Toast, Notify } from 'vant'
export default {
  name: 'ContentAdd',
  data () {
    return {
      studentId: '',
      fileList: [],
      images: [],
      avatar: '',
      nickname: '',
      content: '',
      value: 0,
      categories: [],
      maxSize: getMaxSize()
    }
  },
  methods: {
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
    publishContent () {
      const params = {
        studentId: this.studentId,
        content: this.content.replace(/\r\n/g, '<br/>').replace(/\n/g, '<br/>').replace(/\s/g, '&nbsp;'),
        images: this.images.join(';'),
        category: this.value
      }
      postContent(params).then(res => {
        Notify({ type: 'success', message: '发布成功' })
        setTimeout(() => {
          this.$router.go(-1)
        }, 1000)
      })
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
</style>

<style>
.van-dropdown-menu__item {
  justify-content: left;
}
</style>
