<template>
  <div style="padding: 5px;">
    <van-nav-bar
      title="我参与的"
      left-arrow
      @click-left="onClickLeft"
    />

    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list
        v-model="loading"
        :finished="finished"
        finished-text="没有更多了"
        @load="onLoad"
      >
        <div v-for="item in list" :key="item.id" style="background: white;">
          <div style="margin: 3px;padding-top: 2px;">
            <van-tag mark v-show="item.state === 4" type="primary" style="float: right;">已结束</van-tag>
            <van-tag mark v-show="item.state === 5" style="float: right;">已取消</van-tag>
          </div>
          <div class="contentItem animated fadeIn" style="display: flex;margin-top: 5px;background: white;padding: 5px;">
            <van-image round :src="item.avatar" class="contentItem-img" @click="toInfo(item.studentId, item.avatar, item.nickname)"/>
            <div class="contentItem-content">
              <h3 class="contentItem-publisher">{{item.nickname}}</h3>
              <div style="text-align: center;">
                <p class="contentItem-title">{{item.title}}</p>
              </div>
              <div @click="toDetail(item)">
                <div>
                  <van-tag round type="warning" v-show="item.type === 1">组织活动</van-tag>
                  <van-tag round type="success" v-show="item.type === 2">报名活动</van-tag>
                </div>
                <p class="contentItem-time">活动时间: {{item.startTime}} 到 {{item.endTime}}</p>
                <p class="contentItem-more">{{item.abs}}</p>
                <p class="contentItem-more" v-html="item.content"></p>
              </div>
              <van-grid :border="false" :column-num="3">
                <van-grid-item v-for="(image, index) in item.images" :key="index" @click="clickImages(item.images)">
                  <van-image :src="image"/>
                </van-grid-item>
              </van-grid>
            </div>
          </div>
          <div style="background: white;text-align: right;padding-right: 15px;">
            <van-icon name="friends-o" :badge="item.signNumber" style="margin-right: 5px;" color="#ADD8E6" v-show="item.type === 2" @click="toSignMessage(item.id, item.title, item.signNumber, item.studentId)"/>
            <van-icon name="comment-o" color="#DEB887" @click="getComment(item.id)"/>
            <van-icon name="close" @click="cancelSignActivity(item.id)"/>
          </div>
          <div style="text-align: right;background: white;padding-right: 5px;">
            <span class="contentItem-other">时间：{{item.releaseTime}}</span>
          </div>
        </div>
      </van-list>
    </van-pull-refresh>

    <van-popup
      v-model="showComment"
      closeable
      position="bottom"
      :style="style">
      <comment v-if="showComment" :id="itemId" :category="itemCategory"></comment>
    </van-popup>

  </div>
</template>

<script>
import Comment from '@/components/Comment'
import { getMyParticipation, cancelMyParticipation } from './api/myActivity'
import { Dialog } from 'vant'
export default {
  name: 'MyParticipation',
  components: {
    Comment
  },
  data () {
    return {
      showComment: false,
      itemId: 0,
      itemCategory: 1,
      list: [],
      loading: false,
      finished: false,
      refreshing: false,
      totalRecords: '',
      pageSize: 5,
      pageIndex: 0,
      style: {
        height: '70%'
      }
    }
  },
  methods: {
    getComment (id) {
      this.itemId = id
      this.showComment = true
    },
    onClickLeft () {
      this.$router.go(-1)
    },
    onLoad () {
      if (this.refreshing) {
        this.pageIndex = 0
        this.list = []
        this.refreshing = false
      }
      this.myActivity()
    },
    toSignMessage (id, title, signNumber, studentId) {
      Dialog.confirm({
        title: title,
        message: '该活动共' + signNumber + '人报名哦！',
        confirmButtonText: '查看报名'
      }).then(() => {
        // on confirm
        this.toSignList(id)
      }).catch(() => {
        // on cancel
      })
    },
    toSignList (id) {
      this.$router.push({
        path: '/signlist',
        query: {
          activityId: id
        }
      })
    },
    onRefresh () {
      this.finished = false
      this.loading = true
      this.onLoad()
    },
    myActivity () {
      const paras = {
        id: this.$store.getters.id,
        pageindex: this.pageIndex,
        pagesize: this.pageSize
      }
      getMyParticipation(paras).then(res => {
        this.list = res.data.entities
        this.totalRecords = res.data.totalRecords
        this.pageIndex++
        this.loading = false
        if (this.list.length >= this.totalRecords) {
          this.finished = true
        }
      })
    },
    toDetail (item) {
      this.$router.push({
        name: 'ActivityDetail',
        params: {
          item: item
        }
      })
    },
    cancelSignActivity (id) {
      Dialog.confirm({
        title: '提示',
        message: '确认取消报名该活动吗？',
        confirmButtonText: '确认'
      }).then(() => {
        // on confirm
        const params = {
          activityId: id,
          studentId: this.$store.getters.id
        }
        this.list.map((item, index) => {
          if (item.id === id) {
            this.list.splice(index, 1)
          }
        })
        cancelMyParticipation(params).then(res => {
        })
      }).catch(() => {
        // on cancel
      })
    }
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
