<template>
  <div v-show="show" style="padding: 5px;">
    <van-cell title="热门活动" is-link value="更多" />
    <div class="contentItem animated fadeIn" style="display: flex;background: white;padding: 5px;">
      <van-image round :src="activity.avatar" class="contentItem-img"/>
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

  </div>
</template>

<script>
import { getPostActivityHotList } from './api/Home'
import { ImagePreview } from 'vant'
export default {
  name: 'HomeHotActivity',
  data () {
    return {
      list: [],
      activity: {},
      show: false
    }
  },
  methods: {
    getList () {
      getPostActivityHotList().then(res => {
        this.list = res.data.entities
        this.activity = this.list[0]
        this.show = true
      })
    },
    clickImages (images) {
      ImagePreview({
        images: images,
        closeable: true
      })
    }
  },
  mounted () {
    this.getList()
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
.van-cell {
  padding: 5px 8px;
}
.van-cell >>> .van-cell__title {
  text-align: left;
}
</style>
