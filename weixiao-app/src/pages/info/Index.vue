<template>
  <div>
    <van-nav-bar
      title="信息"
      left-arrow
      @click-left="onClickLeft"
    />

    <div style="background: white;padding-bottom: 5px;">
      <van-image :src="avatar" width="100" height="100" round class="avatar" @click="toChat"/><br/>
      <van-button round type="info" size="small" color="#20B2AA" v-show="!isFollow && show" @click="toFollow()">关注</van-button>
      <van-button round icon="passed" type="primary" size="small" v-show="isFollow && show"
      @click="toUnFollow()">取消关注</van-button>
    </div>

    <div class="thingItems">
      <van-grid :border="false" :column-num="3">
        <van-grid-item>
          <van-icon name="star" size="40"/>
          <span>{{postCollectNum}}</span>
        </van-grid-item>
        <van-grid-item>
          <van-icon name="coupon" size="40"/>
          <span>{{postContentNum}}</span>
        </van-grid-item>
        <van-grid-item>
          <van-icon name="flag-o" size="40"/>
          <span>{{postActivityNum + postSignNum}}</span>
        </van-grid-item>
      </van-grid>
    </div>

    <div class="cellItems">
      <van-cell title="个人信息" is-link />
      <van-cell title="举报" is-link />
    </div>
  </div>
</template>

<script>
import { getPostInfo, checkFollow, postFollow, cancelFollow } from './api/Info'
import { Notify } from 'vant'
export default {
  name: 'InfoIndex',
  data () {
    return {
      id: '',
      avatar: '',
      nickname: '',
      postContentNum: 0,
      postActivityNum: 0,
      postSignNum: 0,
      postCollectNum: 0,
      isFollow: false,
      show: false
    }
  },
  methods: {
    toChat () {
      this.$router.push({
        name: 'Chat',
        params: {
          receiverId: this.id,
          avatar: this.avatar,
          nickname: this.nickname
        }
      })
    },
    onClickLeft () {
      this.$router.go(-1)
    },
    getParams () {
      this.id = this.$route.params.studentId
      this.avatar = this.$route.params.avatar
      this.nickname = this.$route.params.nickname
    },
    getPostInfo () {
      const para = {
        id: this.id
      }
      getPostInfo(para).then(res => {
        this.postContentNum = res.data.contentNum
        this.postActivityNum = res.data.activityPublishNum
        this.postSignNum = res.data.activitySignNum
        this.postCollectNum = res.data.collectNum
      })
    },
    getCheckFollow () {
      const params = {
        studentid: this.$store.getters.id,
        followstudentid: this.id
      }
      checkFollow(params).then(res => {
        this.isFollow = res.data
        this.show = true
      })
    },
    toFollow () {
      const params = {
        studentId: this.$store.getters.id,
        followStudentId: this.id
      }
      postFollow(params).then(res => {
        this.isFollow = true
        Notify({ type: 'success', message: '关注成功' })
      })
    },
    toUnFollow () {
      const params = {
        studentid: this.$store.getters.id,
        followstudentid: this.id
      }
      cancelFollow(params).then(res => {
        this.isFollow = false
        Notify({ type: 'success', message: '取消成功' })
      })
    }
  },
  mounted: function () {
    this.getParams()
    this.getPostInfo()
    this.getCheckFollow()
  }
}
</script>

<style scoped>
.avatar {
  padding-top: 30px;
  padding-bottom: 15px;
}
.van-grid >>>.van-icon-star {
  color: red;
}
.van-grid >>>.van-icon-flag-o {
  color: #00a0ff;
}
.van-grid >>>.van-icon-coupon {
  color: #ffc060;
}
.cellItems {
  text-align: left;
}
</style>
