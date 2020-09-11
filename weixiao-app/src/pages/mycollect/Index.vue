<template>
  <div style="padding: 5px;">
    <van-nav-bar
      title="我的收藏"
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

        <div v-for="item in collects" :key="item.id">
          <div class="contentItem animated fadeIn" style="display: flex;margin-top: 5px;background: white;padding: 5px;">
            <van-image round :src="item.avatar" class="contentItem-img" @click="toInfo(item.studentId, item.avatar, item.nickname)"/>
            <div class="contentItem-content">
              <h3 class="contentItem-publisher">{{item.nickname}}</h3>
              <div @click="toDetail(item)">
                <p class="contentItem-more" v-html="item.content" ></p>
              </div>
              <van-grid :border="false" :column-num="3">
                <van-grid-item v-for="(image, index) in item.images" :key="index" @click="clickImages(item.images)">
                  <van-image :src="image"/>
                </van-grid-item>
              </van-grid>
            </div>
          </div>
          <div style="background: white;text-align: right;padding-right: 15px;">
            <van-icon name="browsing-history-o" :badge="item.lookNum" style="margin-right: 5px;"/>
            <van-icon name="comment-o" color="#DEB887" @click="getComment(item.id)"/>
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
import { getMyCollect } from './api/MyCollect'
import { ImagePreview } from 'vant'
export default {
  name: 'MyCollect',
  components: {
    Comment
  },
  data () {
    return {
      itemId: 0,
      itemCategory: 2,
      showComment: false,
      loading: false,
      finished: false,
      refreshing: false,
      pageSize: 5,
      pageIndex: 0,
      totalRecords: '',
      collects: [],
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
        this.collects = []
        this.refreshing = false
      }
      this.myCollect()
    },
    onRefresh () {
      this.finished = false
      this.loading = true
      this.onLoad()
    },
    clickImages (images) {
      ImagePreview({
        images: images,
        closeable: true
      })
    },
    myCollect () {
      const paras = {
        id: this.$store.getters.id,
        pageindex: this.pageIndex,
        pagesize: this.pageSize
      }
      getMyCollect(paras).then(res => {
        this.collects = res.data.entities
        this.totalRecords = res.data.totalRecords
        this.pageIndex++
        this.loading = false
        if (this.collects.length >= this.totalRecords) {
          this.finished = true
        }
      })
    },
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
    toDetail (item) {
      this.$router.push({
        name: 'ContentDetail',
        params: {
          item: item,
          studentId: this.$store.getters.id
        }
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
