<template>
  <div>
    <van-swipe :autoplay="3000" indicator-color="white">
      <van-swipe-item v-for="item in list" :key="item.id" @click="getHotMore(item.id)">
        <van-image :src="item.images" fit="fill" width="100%" height="140"/>
      </van-swipe-item>
    </van-swipe>
  </div>
</template>

<script>
import { getPostHotList } from './api/Home'
export default {
  name: 'HomeSwiper',
  data () {
    return {
      list: [{
        id: 1,
        images: ''
      }]
    }
  },
  methods: {
    getHotMore (id) {
      console.log(id)
    },
    getPostHot () {
      getPostHotList().then(res => {
        this.list = res.data.entities
      })
    }
  },
  mounted () {
    this.getPostHot()
  }
}
</script>

<style>

</style>
