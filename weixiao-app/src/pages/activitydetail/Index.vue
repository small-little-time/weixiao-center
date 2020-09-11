<template>
  <div style="padding: 5px;">
    <van-nav-bar
      title="详情"
      left-arrow
      @click-left="onClickLeft"
    />

    <div class="contentItem animated fadeIn" style="display: flex;margin-top: 5px;background: white;padding: 5px;">
      <van-image round :src="activity.avatar" class="contentItem-img"  @click="toInfo(activity.studentId, activity.avatar, activity.nickname)"/>
      <div class="contentItem-content">
        <h3 class="contentItem-publisher">{{activity.nickname}}</h3>
        <div style="text-align: center;">
          <p class="contentItem-title">{{activity.title}}</p>
        </div>
        <div>
          <van-tag round type="warning" v-show="activity.type === 1">组织活动</van-tag>
          <van-tag round type="success" v-show="activity.type === 2">报名活动</van-tag>
        </div>
        <p class="contentItem-time">活动时间: {{activity.startTime}} 到 {{activity.endTime}}</p>
        <p class="contentItem-more">{{activity.abs}}</p>
        <p class="contentItem-more" v-html="activity.content"></p>
        <van-grid :border="false" :column-num="3">
          <van-grid-item v-for="(image, index) in activity.images" :key="index" @click="clickImages(activity.images)">
            <van-image :src="image"/>
          </van-grid-item>
        </van-grid>
      </div>
    </div>
    <div style="background: white;text-align: right;padding-right: 15px;">
      <van-icon name="friends-o" :badge="activity.signNumber" style="margin-right: 5px;" color="#ADD8E6" v-show="activity.type === 2" @click="toSignMessage(activity.id, activity.title, activity.signNumber, activity.studentId, activity.maxNumber)"/>
    </div>
    <div style="text-align: right;background: white;padding-right: 5px;">
      <span class="contentItem-other">时间：{{activity.releaseTime}}</span>
    </div>
  </div>
</template>

<script>
import { Dialog, ImagePreview } from 'vant'
import { checkSignActivity } from '@/api/other'
export default {
  name: 'ActivityDetail',
  data () {
    return {
      studentId: this.$store.getters.id,
      activity: {
        // avatar: 'http://img1.imgtn.bdimg.com/it/u=3999684833,1365604362&fm=26&gp=0.jpg',
        // nickname: 'nickname',
        // title: '活动',
        // type: 2,
        // startTime: '2020-03-04 10:45:42',
        // endTime: '2020-03-04 10:45:42',
        // abs: '摘要',
        // content: '内容<br/>内容<br/>内容<br/>内容内容内容内容内容内容<br/>内容<br/>',
        // images: [
        //   'https://img.yzcdn.cn/vant/logo.png',
        //   'https://img.yzcdn.cn/vant/logo.png',
        //   'https://img.yzcdn.cn/vant/logo.png',
        //   'https://img.yzcdn.cn/vant/logo.png'
        // ],
        // signNumber: 1,
        // releaseTime: '2020-03-04 10:45:42'
      }
    }
  },
  methods: {
    toInfo (studentId, avatar, nickname) {
      this.$router.push({
        name: 'Info',
        params: {
          studentId: studentId,
          avatar: avatar,
          nickname: nickname
        }
      })
    },
    onClickLeft () {
      this.$router.go(-1)
    },
    toSignMessage (id, title, signNumber, studentId, maxNumber) {
      const myId = this.$store.getters.id
      if (myId === studentId) {
        Dialog.confirm({
          title: title,
          message: '该活动共' + signNumber + '人报名哦！',
          confirmButtonText: '查看报名'
        }).then(() => {
          this.toSignList(id)
          // on confirm
        }).catch(() => {
          // on cancel
        })
      } else {
        Dialog.confirm({
          title: title,
          message: '该活动共' + signNumber + '人报名哦！赶紧去报名吧~',
          confirmButtonText: '前往报名'
        }).then(() => {
          // on confirm
          if (signNumber >= maxNumber) {
            Dialog({ message: '该活动已报满哦~' })
          } else {
            const paras = {
              activityId: id,
              studentId: this.$store.getters.id
            }
            checkSignActivity(paras).then(res => {
              const flag = res.data
              if (flag) {
                this.toSignList(id)
              } else {
                this.$router.push({
                  path: '/sign',
                  query: {
                    id: id,
                    title: title
                  }
                })
              }
            })
          }
        }).catch(() => {
          // on cancel
        })
      }
    },
    toSignList (id) {
      this.$router.push({
        path: '/signlist',
        query: {
          activityId: id
        }
      })
    },
    clickImages (images) {
      ImagePreview({
        images: images,
        closeable: true
      })
    },
    initData () {
      this.activity = this.$route.params.item
    }
  },
  mounted () {
    this.initData()
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
  overflow: hidden;
  -webkit-line-clamp: 4;
  -webkit-box-orient: vertical;
  text-overflow: ellipsis;
  display: -webkit-box;
}
.contentItem-title {
  margin: 8px 0 0;
  font-size: 10px;
  line-height: 20px;
  font-weight: bold;
}
.contentItem-time {
  margin: 8px 0 0;
  font-size: 10px;
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
