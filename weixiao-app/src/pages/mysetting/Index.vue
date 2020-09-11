<template>
  <div style="margin: 5px;">
    <van-nav-bar
      title="我的设置"
      left-arrow
      :right-text="read === true ? '编辑' : '取消'"
      @click-left="onClickLeft"
      @click-right="onClickRight"
    />

    <van-form>
      <van-field name="switch" label="展示全部信息">
        <template #input>
          <span>否</span>&nbsp;
          <van-switch :disabled="read" v-model="settingForm.hide" size="20" @change="changeState"/>
          &nbsp;<span>是</span>
        </template>
      </van-field>
      <van-field name="switch" label="允许他人私聊">
        <template #input>
          <span>否</span>&nbsp;
          <van-switch :disabled="read" v-model="settingForm.chat" size="20" @change="change"/>
          &nbsp;<span>是</span>
        </template>
      </van-field>
      <van-field name="switch" label="展示性别院部">
        <template #input>
          <span>否</span>&nbsp;
          <van-switch :disabled="read" v-model="settingForm.sexs" size="20" @change="change"/>
          &nbsp;<span>是</span>
        </template>
      </van-field>
      <van-field name="switch" label="展示姓名手机">
        <template #input>
          <span>否</span>&nbsp;
          <van-switch :disabled="read" v-model="settingForm.academy" size="20" @change="change"/>
          &nbsp;<span>是</span>
        </template>
      </van-field>
    </van-form>

    <van-button type="primary" round v-show="!read" class="editButton" @click="edit">提交</van-button>

  </div>
</template>

<script>
import { getSettingInfo, updateSetting } from './api/MySetting'
import { Notify } from 'vant'
export default {
  name: 'MySetting',
  data () {
    return {
      read: true,
      settingForm: {
        hide: this.$store.getters.hide === 1,
        chat: true,
        sexs: true,
        academy: true
      }
    }
  },
  methods: {
    onClickLeft () {
      this.$router.go(-1)
    },
    onClickRight () {
      this.read = !this.read
    },
    changeState (value) {
      this.settingForm.chat = this.settingForm.sexs = this.settingForm.academy = value
    },
    change (value) {
      if (this.settingForm.chat === this.settingForm.sexs && this.settingForm.sexs === this.settingForm.academy) {
        this.settingForm.hide = value
      }
    },
    edit () {
      const params = {
        studentId: this.$store.getters.id,
        hide: this.settingForm.hide === true ? 1 : 0,
        chatSet: this.settingForm.chat === true ? 1 : 0,
        sexSet: this.settingForm.sexs === true ? 1 : 0,
        academySet: this.settingForm.academy === true ? 1 : 0
      }
      updateSetting(params).then(res => {
        this.$store.dispatch('SetHide', this.settingForm.hide === true ? 1 : 0)
        this.read = true
        Notify({ type: 'success', message: '修改成功' })
      })
    },
    getSetting () {
      getSettingInfo(this.$store.getters.id).then(res => {
        this.settingForm.chat = res.data.chatSet === 1
        this.settingForm.sexs = res.data.sexSet === 1
        this.settingForm.academy = res.data.academySet === 1
      })
    }
  },
  mounted () {
    this.getSetting()
  }
}
</script>

<style scoped>
.editButton {
  margin: 35px 5px;
  width: 320px;
}
</style>
