<template>
  <div style="margin: 5px;">
    <van-form>
      <van-field
        v-model="infoForm.truename"
        name="真实姓名"
        label="真实姓名"
        placeholder="请填写真实姓名"
      />
      <van-field
        v-model="infoForm.nickname"
        name="昵称"
        label="昵称"
        placeholder="请填写昵称"
      />
      <van-field
        v-model="infoForm.number"
        type="number"
        name="学号"
        label="学号"
        placeholder="请填写学号"
      />
      <van-field
        v-model="infoForm.phone"
        type="number"
        name="手机号"
        label="手机号"
        placeholder="请填写手机号"
      />
      <van-field name="radio" label="性别">
        <template #input>
          <van-radio-group v-model="infoForm.sex" direction="horizontal">
            <van-radio name="1">男</van-radio>
            <van-radio name="2">女</van-radio>
          </van-radio-group>
        </template>
      </van-field>
      <van-field name="stepper" label="年龄">
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
        @click="showArea = true"
      />
      <van-popup v-model="showArea" position="bottom" :lock-scroll="false">
        <van-area
          :area-list="areaList"
          @confirm="onConfirm"
          @cancel="showArea = false"
          title="地区"
        />
      </van-popup>
      <van-field
        readonly
        clickable
        label="专业"
        :value="academyName"
        placeholder="选择专业"
        @click="showAcademy = true"
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
        />
    </van-form>
    <div style="margin: 16px;">
      <van-button round block type="info" plain @click="nextStep">
        下一步
      </van-button>
    </div>
  </div>
</template>

<script>
import { Toast } from 'vant'
import Area from '@/resources/Area.js'
import Academy from '@/resources/Academy.js'
export default {
  name: 'RegisterInfo',
  data () {
    return {
      infoForm: {
        truename: '',
        nickname: '',
        number: '',
        phone: '',
        sex: '',
        age: '',
        areaId: '',
        areaName: '',
        academyId: '',
        autograph: ''
      },
      areasName: '',
      academyName: '',
      showArea: false,
      showAcademy: false,
      areaList: Area,
      columns: [
        { values: Object.keys(Academy) },
        { values: Academy['经济学院'] }
      ]
    }
  },
  methods: {
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
    nextStep () {
      if (this.infoForm.areaId === '') {
        Toast.fail('地区不能为空')
        return false
      } else if (this.infoForm.academyId === '') {
        Toast.fail('专业不能为空')
        return false
      } else {
        this.$emit('passInfoForm', this.infoForm)
        this.$parent.nextStep()
      }
    }
  }
}
</script>

<style scoped>
form {
  margin-top: 30px !important;
}
</style>
