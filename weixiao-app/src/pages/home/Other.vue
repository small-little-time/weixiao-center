<template>
  <div style="padding: 5px;background: white;">
    <div class="info">
      <van-tag plain>名称:</van-tag>
      <van-tag round type="primary">We微校</van-tag>
    </div>
    <div class="info">
      <van-tag plain>前端:</van-tag>
      <van-tag round type="warning">Vue</van-tag>
      <van-tag round type="warning">Element-UI</van-tag>
      <van-tag round type="warning">Vant</van-tag>
    </div>
    <div class="info">
      <van-tag plain>后端:</van-tag>
      <van-tag round type="danger">SpringBoot</van-tag>
      <van-tag round type="danger">SpringCloud</van-tag>
      <van-tag round type="danger">Security</van-tag>
      <van-tag round type="danger">Swagger2</van-tag>
    </div>
    <div class="info">
      <van-tag plain>聊天:</van-tag>
      <van-tag round type="danger" color="#7232dd">Netty</van-tag>
    </div>
    <div class="info">
      <van-tag plain>工具:</van-tag>
      <van-tag round type="success">IDEA</van-tag>
      <van-tag round type="success">Sublime Text3</van-tag>
    </div>
    <div class="info">
      <van-tag plain>作者:</van-tag>
      <van-tag round type="danger" color="#f2826a">张张张</van-tag>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeOther',
  data () {
    return {
    }
  }
}
</script>

<style scoped>
.info {
  text-align: left;
  margin: 3px;
}
</style>
