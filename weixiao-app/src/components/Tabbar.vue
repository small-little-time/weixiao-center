<template>
  <div id="app">
    <van-tabbar v-model="active"
    active-color="#07c160"
    inactive-color="#000"
    @change="changeTabbar">
      <van-tabbar-item name="home" icon="home-o" replace to="/home">
        <span>首页</span>
      </van-tabbar-item>
      <van-tabbar-item name="activity" icon="flag-o" replace  to="/activity">
        <span>活动</span>
      </van-tabbar-item>
      <van-tabbar-item name="find" icon="eye-o" replace to="/index">
        <span>发现</span>
      </van-tabbar-item>
      <van-tabbar-item name="chat" icon="chat-o" replace dot to="/chatlist">
        <span>消息</span>
      </van-tabbar-item>
      <van-tabbar-item name="setting" icon="setting-o" replace to="/setting">
        <span>设置</span>
      </van-tabbar-item>
    </van-tabbar>
  </div>
</template>

<script>
export default {
  name: 'Tabbar',
  data () {
    return {
      active: '/index'
    }
  },
  methods: {
    getItemShow () {
      const name = this.active
      if (name === '/home') {
        this.active = 'home'
      } else if (name === '/activity') {
        this.active = 'activity'
      } else if (name === '/index') {
        this.active = 'find'
      } else if (name === '/chatlist') {
        this.active = 'chat'
      } else if (name === '/') {
        this.active = 'find'
      }
    },
    changeTabbar () {
    }
  },
  mounted: function () {
    this.getItemShow()
  }
}
</script>

<style>

</style>
