<template>
  <div style="padding: 5px;">
    <van-nav-bar
      title="详情"
      left-arrow
      @click-left="onClickLeft"
    />
    <div class="contentItem animated fadeIn" style="display: flex;margin-top: 5px;background: white;padding: 5px;">
      <van-image round :src="content.avatar" class="contentItem-img"  @click="toInfo(content.studentId, content.avatar, content.nickname)"/>
      <div class="contentItem-content">
        <h3 class="contentItem-publisher">{{content.nickname}}</h3>
        <p class="contentItem-more" v-html="content.content"></p>
        <van-grid :border="false" :column-num="3">
          <van-grid-item v-for="(image, index) in content.image" :key="index" @click="clickImages(content.image)">
            <van-image :src="image"/>
          </van-grid-item>
        </van-grid>
      </div>
    </div>

    <div style="background: white;text-align: right;padding-right: 15px;">
      <van-icon name="browsing-history-o" :badge="content.lookNum" style="margin-right: 5px;"/>
      <van-icon v-if="!content.like" name="like-o" :badge="content.likeNum" style="margin-right: 5px;" color="red" @click="handleLike(content.id)"/>
      <van-icon v-else name="like" :badge="content.likeNum" style="margin-right: 5px;" color="red" @click="handleUnLike(content.id)"/>
      <van-icon v-if="!content.collect" name="star-o" color="#DEB887" @click="handleCollect(content.id)"/>
      <van-icon v-else name="star" color="#FF7F50" @click="handleUnCollect(content.id)"/>
      <van-icon name="warning-o" @click="toReport(content)"/>
    </div>

    <div style="text-align: right;background: white;padding-right: 5px;">
      <span class="contentItem-other">时间：{{content.releaseTime}}</span>
    </div>
  </div>
</template>

<script>
import { ImagePreview } from 'vant'
import { getDetail, postCollect, putCollect, postLike, putLike } from './api/Detail'
export default {
  name: 'ContentDetail',
  data () {
    return {
      id: '',
      studentId: '',
      content: {
        // avatar: 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg',
        // nickname: 'nickname',
        // content: '正在测试<br/>换行<br/>分享<br/>加&nbsp;空格<br/>正在测试<br/>换行<br/>分享<br/>加&nbsp;空格',
        // likeNum: 10,
        // collect: false,
        // like: false,
        // lookNum: 0,
        // releaseTime: '2020-03-04 10:45:42',
        // images: [
        //   'https://img.yzcdn.cn/vant/logo.png',
        //   'https://img.yzcdn.cn/vant/logo.png',
        //   'https://img.yzcdn.cn/vant/logo.png',
        //   'https://img.yzcdn.cn/vant/logo.png'
        // ]
      }
    }
  },
  methods: {
    toInfo (studentId, avatar, nickname) {
      if (studentId === this.$store.getters.id) {
        this.$router.push({
          name: 'Setting'
        })
      } else {
        this.$router.push({
          name: 'Info',
          params: {
            studentId: studentId,
            avatar: avatar,
            nickname: nickname
          }
        })
      }
    },
    onClickLeft () {
      this.$router.go(-1)
    },
    clickImages (images) {
      ImagePreview({
        images: images,
        closeable: true
      })
    },
    handleLike (id) {
      const params = {
        contentId: id,
        studentId: this.studentId
      }
      postLike(params).then(res => {
        this.content.like = true
        this.content.likeNum = this.content.likeNum + 1
      })
    },
    handleCollect (id) {
      const params = {
        contentId: id,
        studentId: this.studentId
      }
      postCollect(params).then(res => {
        this.content.collect = true
      })
    },
    handleUnLike (id) {
      const params = {
        contentId: id,
        studentId: this.studentId
      }
      putLike(params).then(res => {
        this.content.like = false
        this.content.likeNum = this.content.likeNum - 1
      })
    },
    handleUnCollect (id) {
      const params = {
        contentId: id,
        studentId: this.studentId
      }
      putCollect(params).then(res => {
        this.content.collect = false
      })
    },
    initData () {
      this.id = this.$route.params.item.id
      this.content = this.$route.params.item
      this.content.image = this.content.images
      this.studentId = this.$route.params.studentId
    },
    detail () {
      const params = {
        id: this.id,
        studentId: this.studentId
      }
      getDetail(params).then(res => {
        this.content = res.data
      })
    },
    toReport (content) {
      this.$router.push({
        path: '/report',
        query: {
          categoryId: content.category,
          title: content.content,
          postId: content.id,
          reportStudentId: content.studentId
        }
      })
    }
  },
  mounted () {
    this.initData()
    this.detail()
  }
}
</script>

<style scoped>
.contentItem-content {
  padding-top: 6px;
  text-align: left;
}
.contentItem-publisher {
  margin: 0;
  font-size: 14px;
  line-height: 20px;
}
.contentItem-more {
  margin: 8px 0 0;
  font-size: 14px;
  line-height: 20px;
}
.contentItem-img {
  flex-shrink: 0;
  width: 32px;
  height: 32px;
  margin-right: 16px;
}
.contentItem-other {
  font-size: 8px;
}
</style>
