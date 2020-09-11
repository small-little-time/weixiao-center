<template>
  <div>
    <van-nav-bar
      title="设置中心"
    />

    <div style="background: white;">
      <van-uploader
        :max-count="1"
        :max-size="maxSize"
        :after-read="afterRead"
        :before-read="beforeRead">
        <van-image :src="avatar" width="100" height="100" round class="avatar"/>
      </van-uploader>

      <van-field v-model="autograph" input-align="center" :readonly="edit"/>

    </div>

    <div class="thingItems">
      <van-grid :border="false" :column-num="3">
<!--         <van-grid-item
          icon="star"
          :text="postCollectNum"
        />
        <van-grid-item
          icon="coupon"
          :text="postContentNum"
        />
        <van-grid-item
          icon="flag-o"
          :text="9"
        /> -->
        <van-grid-item>
          <van-icon name="star" size="40" @click="toMyCollect()"/>
          <span>{{postCollectNum}}</span>
        </van-grid-item>
        <van-grid-item>
          <van-icon name="coupon" size="40" @click="toMyContent()"/>
          <span>{{postContentNum}}</span>
        </van-grid-item>
        <van-grid-item>
          <van-icon name="flag-o" size="40" @click="toMyActivity()"/>
          <span>{{postActivityNum + postSignNum}}</span>
        </van-grid-item>
      </van-grid>
    </div>

    <div class="cellItems">
      <van-cell title="我关注的" is-link to="/myfollow"/>
      <van-cell title="个人信息" is-link to="/myinfo"/>
      <van-cell title="设置" is-link to="/mysetting"/>
      <van-cell title="举报中心" is-link to="/report"/>
      <van-cell title="反馈" is-link to="/feedback"/>
    </div>

    <van-button type="primary" round color="red" class="logoutButton" @click="logout">退出登录</van-button>

  </div>
</template>

<script>
import { removeToken } from '@/utils/auth'
import { getMaxSize } from '@/api/config'
import { upload, updateFace, getPostInfo } from './api/Setting'
import { Toast } from 'vant'
export default {
  name: 'SettingIndex',
  data () {
    return {
      id: this.$store.getters.id,
      avatar: this.$store.getters.faceImgMin,
      autograph: this.$store.getters.autograph,
      postContentNum: 0,
      postActivityNum: 0,
      postSignNum: 0,
      postCollectNum: 0,
      edit: true,
      maxSize: getMaxSize()
    }
  },
  methods: {
    afterRead (file) {
      const formData = new FormData()
      formData.append('id', this.id)
      formData.append('file', file.file)
      upload(formData).then(res => {
        const para = {
          id: this.id,
          faceImg: res.data
        }
        this.$store.dispatch('SetFace', res.data)
        this.avatar = res.data
        updateFace(para).then(res => {
          Toast.success('上传成功！')
        })
      })
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
    editAutograph () {
      this.edit = false
    },
    toMyCollect () {
      this.$router.push('/mycollect')
    },
    toMyContent () {
      this.$router.push('/mycontent')
    },
    toMyActivity () {
      this.$router.push('/myactivity')
    },
    logout () {
      removeToken()
      const chatInfo = {
        senderId: this.$store.getters.id,
        senderAvatar: '',
        senderNickname: '',
        receiverId: '',
        message: '',
        msgId: 0
      }
      const dataContent = {
        action: 8,
        chatInfo: chatInfo,
        extend: ''
      }
      this.$store.getters.websocket.send(JSON.stringify(dataContent))
      // try {
      //   this.$store.getters.websocket.send(JSON.stringify(dataContent))
      // } catch (e) {
      // }
      this.$router.replace({
        path: '/'
      })
    }
  },
  mounted: function () {
    this.getPostInfo()
  }
}
</script>

<style scoped>
.logoutButton {
  margin: 35px 5px;
  width: 320px;
}
.avatar {
  padding-top: 30px;
  padding-bottom: 15px;
}
.van-grid >>>.van-icon-star {
  color: #FF7F50;
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
