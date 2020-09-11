<template>
  <div class="animated fadeIn" style="padding-bottom: 50px;">
    <home-swiper></home-swiper>

    <van-notice-bar
      color="#1989fa"
      background="#F8F8FF"
      left-icon="volume-o"
    >
      {{notice}}
    </van-notice-bar>

    <home-icon></home-icon>

    <home-hot-acitivity></home-hot-acitivity>

    <home-hot-content></home-hot-content>

    <home-other></home-other>

  </div>
</template>

<script>
import HomeIcon from './Icon'
import HomeSwiper from './Swiper'
import HomeHotAcitivity from './HotActivity'
import HomeHotContent from './HotContent'
import HomeOther from './Other'
export default {
  name: 'HomeIndex',
  components: {
    HomeSwiper,
    HomeIcon,
    HomeHotAcitivity,
    HomeHotContent,
    HomeOther
  },
  data () {
    return {
      notice: 'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'
    }
  }
}
</script>

<style>

</style>
