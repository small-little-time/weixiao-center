<template>
  <div style="margin: 5px;">
    <van-nav-bar
      title="我的信息"
      left-arrow
      :right-text="read === true ? '编辑' : '取消'"
      @click-left="onClickLeft"
      @click-right="onClickRight"
    />

    <van-form>
      <van-field
        v-model="infoForm.truename"
        name="真实姓名"
        label="真实姓名"
        placeholder="请填写真实姓名"
        :readonly="read"
      />
      <van-field
        v-model="infoForm.nickname"
        name="昵称"
        label="昵称"
        placeholder="请填写昵称"
        :readonly="read"
      />
      <van-field
        v-model="infoForm.number"
        type="number"
        name="学号"
        label="学号"
        placeholder="请填写学号"
        :readonly="read"
      />
      <van-field
        v-model="infoForm.phone"
        type="number"
        name="手机号"
        label="手机号"
        placeholder="请填写手机号"
        :readonly="read"
      />
      <van-field name="radio" label="性别" :readonly="read">
        <template #input>
          <van-radio-group v-model="infoForm.sex" direction="horizontal">
            <van-radio name="1">男</van-radio>
            <van-radio name="2">女</van-radio>
          </van-radio-group>
        </template>
      </van-field>
      <van-field name="stepper" label="年龄" :readonly="read">
        <template #input>
          <van-stepper v-model="infoForm.age" min="0" max="200"/>
        </template>
      </van-field>
      <van-field
        readonly
        clickable
        name="area"
        :value="areasName"
        label="地区选择"
        placeholder="点击选择省市区"
        @click="read === true ? showArea = showArea : showArea = true"
      />
      <van-popup v-model="showArea" position="bottom" :lock-scroll="false">
        <van-area
          title="地区"
          :area-list="areaList"
          @confirm="onConfirm"
          @cancel="showArea = false"
        />
      </van-popup>
      <van-field
        readonly
        clickable
        label="专业"
        :value="academyName"
        placeholder="选择专业"
        @click="read === true ? showAcademy = showAcademy : showAcademy = true"
      />
      <van-popup v-model="showAcademy" position="bottom" :lock-scroll="false">
        <van-picker
          ref="picker"
          show-toolbar
          @cancel="showAcademy = false"
          title="专业"
          :columns="columns"
          @confirm="getValue"
          @change="onChange"/>
      </van-popup>
        <van-field
          v-model="infoForm.autograph"
          rows="2"
          autosize
          label="留言"
          type="textarea"
          maxlength="30"
          placeholder="请输入留言"
          show-word-limit
          :readonly="read"
        />
    </van-form>

    <van-button type="primary" round v-show="!read" class="editButton" @click="edit">提交</van-button>

  </div>
</template>

<script>
import { Notify } from 'vant'
import { updateInfo } from './api/MyInfo'
import Area from '@/resources/Area.js'
import Academy from '@/resources/Academy.js'
export default {
  name: 'MyInfoIndex',
  data () {
    return {
      infoForm: {
        id: this.$store.getters.id,
        truename: this.$store.getters.truename,
        nickname: this.$store.getters.nickname,
        number: this.$store.getters.number,
        phone: this.$store.getters.phone,
        sex: this.$store.getters.sex === '女' ? '2' : '1',
        age: this.$store.getters.age,
        areaName: this.$store.getters.areaName,
        areaId: this.$store.getters.areaId,
        academyId: this.$store.getters.academyId,
        autograph: this.$store.getters.autograph
      },
      areasName: this.$store.getters.areaName,
      academyName: '',
      showArea: false,
      showAcademy: false,
      areaList: Area,
      columns: [
        { values: Object.keys(Academy) },
        { values: Academy['经济学院'] }
      ],
      read: true
    }
  },
  methods: {
    onClickLeft () {
      this.$router.go(-1)
    },
    onClickRight () {
      this.read = !this.read
    },
    onConfirm (values) {
      this.areasName = values.map(item => {
        if (item !== undefined && item !== '') {
          return item.name
        }
      }).join('/')
      this.infoForm.areaName = this.areasName
      this.infoForm.areaId = values[3] === undefined ? values[2].code : values[3].code
      this.showArea = false
    },
    getValue (values) {
      this.academyName = values[0] + '/' + values[1].text
      this.infoForm.academyId = values[1].id
      this.showAcademy = false
    },
    onChange (picker, values) {
      picker.setColumnValues(1, Academy[values[0]])
    },
    edit () {
      updateInfo(this.infoForm).then(res => {
        this.$store.dispatch('GetInfo2').then(res => {
          Notify({ type: 'success', message: '修改成功' })
          this.read = true
        })
      })
    },
    getAcademyName () {
      const arr = Object.entries(Academy)
      arr.map(items => {
        items[1].map(item => {
          if (item.id === this.infoForm.academyId) {
            this.academyName = items[0] + '/' + item.text
          }
        })
      })
    }
  },
  mounted () {
    this.getAcademyName()
  }
}
</script>

<style scoped>
.editButton {
  margin: 35px 5px;
  width: 320px;
}
</style>
