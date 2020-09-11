<template>
  <div>
    <van-popup
      v-model="show"
      closeable
      position="bottom"
      :style="style">
        <van-skeleton
        title
        avatar
        :row="2"
        :loading="loading"
      >
          <div>
            <img :src="item.avatar" class="comment-img" />
            <div class="comment-content">
              <h3 class="comment-publisher">{{item.nickname}}</h3>
              <p class="comment-more">{{item.content}}</p>
            </div>
          </div>
          <div style="text-align: right;background: white;padding-right: 5px;">
            <span class="comment-other">时间：{{item.releaseTime}}</span>
          </div>
        </van-skeleton>
      </van-popup>
  </div>
</template>

<script>
export default {
  name: 'CommentPage',
  data () {
    return {
      item: {
        avatar: 'https://img.yzcdn.cn/vant/logo.png',
        nickname: '评论人',
        content: '内容内容内容内容内容内容内容',
        releaseTime: '2020-03-04 10:45:42'
      },
      show: true,
      loading: true,
      style: {
        height: '30%'
      }
    }
  }
}
</script>

<style>
.comment-content {
  padding-top: 6px;
  text-align: left;
}
.comment-publisher {
  margin: 0;
  font-size: 14px;
  line-height: 20px;
}
.comment-more {
  margin: 8px 0 0;
  font-size: 14px;
  line-height: 20px;
}
.comment-img {
  flex-shrink: 0;
  width: 32px;
  height: 32px;
  margin-right: 16px;
}
.comment-other {
  font-size: 8px;
}
</style>
