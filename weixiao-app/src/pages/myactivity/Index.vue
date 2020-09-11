<template>
  <div style="padding: 5px;">
    <van-nav-bar
      title="我的活动"
      left-arrow
      @click-left="onClickLeft"
    />

    <div class="avtiviti_cell">
      <van-cell title="我发布的" is-link to="/mypublish"/>
      <van-cell title="我参与的" is-link to="/myparticipation"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MyActivity',
  data () {
    return {
    }
  },
  methods: {
    onClickLeft () {
      this.$router.go(-1)
    }
  }
}
</script>

<style scoped>
.avtiviti_cell {
  text-align: left;
}
</style>
