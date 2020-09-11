<template>
  <div>
    <van-list
      v-model="commentListLoading"
      :finished="commentFinished"
      finished-text="我是有底线的~"
      @load="commentOnLoad"
    >
      <van-skeleton
        title
        avatar
        :row="2"
        :loading="commentLoading"
        v-for="item in commentList"
        :key="item.id"
      >
        <div style="display: flex;margin-top: 5px;background: white;padding: 5px;" @click="reply(item.nickname, item.studentId)">
          <img :src="item.avatar" class="comment-img" />
          <div class="comment-content">
            <h3 class="comment-publisher">{{item.nickname}}</h3>
            <p class="comment-more">{{item.content}}</p>
          </div>
        </div>
        <div style="text-align: right;background: white;padding-right: 5px;">
          <span class="comment-other">时间：{{item.commentTime}}</span>
        </div>
      </van-skeleton>
    </van-list>
    <van-field
      v-model="commentMessage"
      type="textarea"
      maxlength="100"
      :placeholder="holder"
      clearable
      show-word-limit
    >
      <template #button>
        <van-button v-show="!replyShow" size="small" type="primary" @click="postComment">评论</van-button>
        <van-button v-show="replyShow" size="small" type="primary" @click="postReply">回复</van-button>
      </template>
    </van-field>
  </div>
</template>

<script>
import { getComment, postComment } from '@/api/comment'
export default {
  name: 'Comment',
  props: {
    id: Number,
    category: Number
  },
  data () {
    return {
      holder: '请输入评论',
      commentList: [],
      commentLoading: false,
      commentListLoading: false,
      commentFinished: false,
      commentTotalRecords: 0,
      commentPageIndex: 0,
      commentPageSize: 1000,
      commentMessage: '',
      replyShow: false
    }
  },
  methods: {
    reply (nickname, studentId) {
      this.holder = '回复' + nickname + '：'
      this.replyShow = true
    },
    postReply () {
      this.commentMessage = this.holder + this.commentMessage
      this.postComment()
      this.replyShow = false
      this.holder = '请输入评论'
    },
    commentOnLoad () {
      const param = {
        postid: this.id,
        category: this.category,
        pageindex: this.commentPageIndex,
        pagesize: this.commentPageSize
      }
      this.commentPageIndex++
      getComment(param).then(res => {
        this.commentList = this.commentList.concat(res.data.entities)
        this.commentTotalRecords = res.data.totalRecords
        this.commentLoading = false
        if (this.commentList.length >= this.commentTotalRecords) {
          this.commentFinished = true
        }
      })
    },
    postComment () {
      if (this.commentMessage === '') {
        return false
      } else {
        var item = {
          postId: this.id,
          studentId: this.$store.getters.id,
          content: this.commentMessage,
          category: this.category
        }
        this.commentMessage = ''
        postComment(item).then(res => {
          item.id = res.data.id
          item.avatar = this.$store.getters.faceImgMin
          item.nickname = this.$store.getters.nickname
          item.commentTime = res.data.commentTime
          this.commentList.unshift(item)
        })
      }
    }
  },
  mounted () {
    this.commentOnLoad()
  }
}
</script>

<style scoped>
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
.van-cell {
  padding-bottom: 30px;
}
</style>
