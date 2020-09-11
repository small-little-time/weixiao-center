<template>
  <div style="margin-top: 40px;">
    <van-image
      width="15rem"
      height="15rem"
      fit="cover"
      src="./static/images/register-success.jpg"
    />
    <br />
    <van-button size="normal" round plain type="info" style="margin-top: 20px;" @click="toIndex">立即体验</van-button>
  </div>
</template>

<script>
export default {
  name: 'RegisterSuccess',
  data () {
    return {
      active: 0
    }
  },
  methods: {
    toIndex () {
      this.$emit('updateInfo')
    }
  }
}
</script>

<style>

</style>
