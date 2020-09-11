<template>
  <div class="hello">
    <van-search v-model="value" placeholder="请输入搜索关键词" />
    <van-tabs>
      <van-tab v-for="index in 8" :title="'标签 ' + index" :key="index">
        内容 {{ index }}
      </van-tab>
    </van-tabs>
    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list
        v-model="loading"
        :finished="finished"
        finished-text="没有更多了"
        @load="onLoad"
      >
        <van-cell v-for="item in list" :key="item" :title="item" />
      </van-list>
    </van-pull-refresh>
  </div>
</template>

<script>
export default {
  name: 'Index',
  data () {
    return {
      active: 'home',
      value: '',
      name: '',
      list: [],
      loading: false,
      finished: false,
      refreshing: false
    }
  },
  mounted: function () {
    this.getUserInfo()
  },
  methods: {
    getUserInfo () {
      const user = this.$store.state.user
      this.name = user.nickname
    },
    onLoad () {
      setTimeout(() => {
        if (this.refreshing) {
          this.list = []
          this.refreshing = false
        }

        for (let i = 0; i < 10; i++) {
          this.list.push(this.list.length + 1)
        }
        this.loading = false

        if (this.list.length >= 20) {
          this.finished = true
        }
      }, 1000)
    },
    onRefresh () {
      // 清空列表数据
      this.finished = false

      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.loading = true
      this.onLoad()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
