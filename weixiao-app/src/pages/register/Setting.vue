<template>
  <div style="margin: 5px;">
    <van-form>
      <van-field name="switch" label="展示全部信息">
        <template #input>
          <span>否</span>&nbsp;
          <van-switch v-model="settingForm.hide" size="20" @change="changeState"/>
          &nbsp;<span>是</span>
        </template>
      </van-field>
      <van-field name="switch" label="允许他人私聊">
        <template #input>
          <span>否</span>&nbsp;
          <van-switch v-model="settingForm.chat" size="20" @change="change"/>
          &nbsp;<span>是</span>
        </template>
      </van-field>
      <van-field name="switch" label="展示性别院部">
        <template #input>
          <span>否</span>&nbsp;
          <van-switch v-model="settingForm.sexs" size="20" @change="change"/>
          &nbsp;<span>是</span>
        </template>
      </van-field>
      <van-field name="switch" label="展示姓名手机">
        <template #input>
          <span>否</span>&nbsp;
          <van-switch v-model="settingForm.academy" size="20" @change="change"/>
          &nbsp;<span>是</span>
        </template>
      </van-field>
    </van-form>
    <div style="margin: 16px;">
      <van-button round block type="info" plain @click="nextStep">
        下一步
      </van-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RegisterSetting',
  data () {
    return {
      settingForm: {
        hide: true,
        chat: true,
        sexs: true,
        academy: true
      }
    }
  },
  methods: {
    changeState (value) {
      this.settingForm.chat = this.settingForm.sexs = this.settingForm.academy = value
    },
    change (value) {
      if (this.settingForm.chat === this.settingForm.sexs && this.settingForm.sexs === this.settingForm.academy) {
        this.settingForm.hide = value
      }
    },
    nextStep () {
      this.$emit('passSettingForm', this.settingForm)
      this.$parent.nextStep()
    }
  }
}
</script>

<style scoped>
.van-cell__value {
  margin-left: 10px;
}
span {
  margin: 2px;
}
form {
  margin-top: 30px !important;
}
</style>
