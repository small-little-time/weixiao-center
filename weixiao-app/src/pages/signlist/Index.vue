<template>
  <div style="padding: 5px;">
    <van-nav-bar
      title="报名列表"
      left-arrow
      @click-left="onClickLeft"
    />

    <van-field v-model="title" label="活动标题" readonly/>

    <van-field v-model="numText" label="人员列表" readonly/>

    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list
        v-model="loading"
        :finished="finished"
        finished-text="没有更多了"
        @load="onLoad"
      >
        <van-row v-for="item in list" :key="item.id" justify="center" @click="moreShow(item)" style="background: white;">
          <van-col span="4">
            <van-image round :src="item.avatar" style="width: 32px;height: 32px;"/>
          </van-col>
          <van-col span="4" class="listText">
            {{item.sex === 1? '男 ': '女'}}
          </van-col>
          <van-col span="8" class="listText">
            {{item.academyName}}
          </van-col>
          <van-col span="8" class="listText">
            {{item.truename}}
          </van-col>
        </van-row>
      </van-list>
    </van-pull-refresh>

    <van-popup v-model="show" round position="bottom" :style="{ height: '55%' }" closeable>
      <van-field
        v-model="item.truename"
        name="真实姓名"
        label="真实姓名"
        readonly
      />
      <van-field
        v-model="item.sex"
        name="性别"
        label="性别"
        readonly
      />
      <van-field
        v-model="item.age"
        name="性别"
        label="性别"
        readonly
      />
      <van-field
        v-model="item.academyName"
        name="专业"
        label="专业"
        readonly
      />
      <van-field
        v-model="item.qq"
        name="qq"
        label="qq"
        readonly
      />
      <van-field
        v-model="item.phone"
        name="phone"
        label="phone"
        readonly
      />
      <van-field
        v-model="item.signTime"
        name="报名时间"
        label="报名时间"
        readonly
      />
      <van-field
        v-model="item.message"
        name="备注"
        label="备注"
        type="textarea"
        readonly
      />
    </van-popup>
  </div>
</template>

<script>
import { getSignList } from './api/signList'
export default {
  name: 'SignList',
  data () {
    return {
      title: 'title',
      list: [],
      activityId: '',
      loading: false,
      finished: false,
      refreshing: false,
      pageIndex: 0,
      pageSize: 5,
      totalRecords: 0,
      show: false,
      item: {}
    }
  },
  methods: {
    onClickLeft () {
      this.$router.go(-1)
    },
    onLoad () {
      if (this.refreshing) {
        this.pageIndex = 0
        this.list = []
        this.refreshing = false
      }
      this.signList()
    },
    onRefresh () {
      this.finished = false
      this.loading = true
      this.onLoad()
    },
    signList () {
      const paras = {
        activityid: this.activityId,
        pageindex: this.pageIndex,
        pagesize: this.pageSize
      }
      getSignList(paras).then(res => {
        this.list = res.data.entities
        this.totalRecords = res.data.totalRecords
        this.pageIndex++
        this.loading = false
        if (this.list.length >= this.totalRecords) {
          this.finished = true
        }
      })
    },
    moreShow (item) {
      this.item = item
      this.item.sex = this.item.sex === 1 ? '男' : '女'
      this.show = true
    },
    initData () {
      this.activityId = this.$route.query.activityId
    }
  },
  computed: {
    numText () {
      return '共' + this.totalRecords + '人'
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
