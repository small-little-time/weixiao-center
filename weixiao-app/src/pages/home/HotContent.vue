<template>
  <div v-show="show" style="padding: 5px;">
    <van-cell title="热门话题" is-link value="更多" />
    <div class="contentItem animated fadeIn" style="display: flex;background: white;padding: 5px;">
      <van-image round :src="content.avatar" class="contentItem-img"/>
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
  </div>
</template>

<script>
import { ImagePreview } from 'vant'
import { getPostContentHotList } from './api/Home'
export default {
  name: 'HomeHotContent',
  data () {
    return {
      list: [],
      content: {},
      show: false
    }
  },
  methods: {
    getList () {
      getPostContentHotList().then(res => {
        this.list = res.data.entities
        this.content = this.list[0]
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
