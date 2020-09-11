<template>
  <div style="padding: 5px;">
    <van-nav-bar
      title="我关注的"
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
        <van-row v-for="item in list" :key="item.id" justify="center" style="background: white;">
          <van-col span="3">
            <van-image round :src="item.faceImg" style="width: 32px;height: 32px;" @click="toInfo(item.id, item.faceImg, item.nickname)"/>
          </van-col>
          <van-col span="2" class="listText">
            {{item.sex === 1? '男 ': '女'}}
          </van-col>
          <van-col span="9" class="listText">
            {{item.academyName}}
          </van-col>
          <van-col span="6" class="listText">
            {{item.truename}}
          </van-col>
          <van-col span="4" class="listText">
            <van-button type="warning" size="mini" @click="cancel(item.id)">取消关注</van-button>
          </van-col>
        </van-row>
      </van-list>
    </van-pull-refresh>

  </div>
</template>

<script>
import { getMyFollow, cancelFollow } from './api/MyFollow'
import { Notify } from 'vant'
export default {
  name: 'MyFollow',
  data () {
    return {
      list: [],
      loading: false,
      finished: false,
      refreshing: false,
      pageIndex: 0,
      pageSize: 5,
      totalRecords: 0
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
    onLoad () {
      if (this.refreshing) {
        this.pageIndex = 0
        this.list = []
        this.refreshing = false
      }
      this.myFollowList()
    },
    onRefresh () {
      this.finished = false
      this.loading = true
      this.onLoad()
    },
    myFollowList () {
      if (this.id === undefined || this.id === '' || this.id === null) {
        this.id = this.$store.getters.id
      }
      const paras = {
        id: this.id,
        pageindex: this.pageIndex,
        pagesize: this.pageSize
      }
      getMyFollow(paras).then(res => {
        this.list = res.data.entities
        this.totalRecords = res.data.totalRecords
        this.pageIndex++
        this.loading = false
        if (this.list.length >= this.totalRecords) {
          this.finished = true
        }
      })
    },
    cancel (studentId) {
      const params = {
        studentid: this.$store.getters.id,
        followstudentid: studentId
      }
      cancelFollow(params).then(res => {
        this.list.map((item, index) => {
          if (item.id === studentId) {
            this.list.splice(index, 1)
          }
        })
        Notify({ type: 'success', message: '取消成功' })
      })
    },
    initData () {
      this.id = this.$route.query.id
    }
  },
  mounted () {
    this.initData()
  }
}
</script>

<style scoped>
.listText {
  line-height: 32px;
}
</style>
