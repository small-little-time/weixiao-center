<template>
  <div style="padding: 5px;">
    <van-sticky>
      <van-search v-model="title" shape="round" background="#B0E0E6" placeholder="请输入搜索活动标题" @search="searchActivity" show-action>
        <template #action>
          <div style="line-height: normal;">
            <van-icon name="add-o" size="20" @click="toAddActivity"/>
          </div>
        </template>
      </van-search>
    </van-sticky>

    <van-dropdown-menu>
      <van-dropdown-item title="筛选" ref="selects">
        <van-field name="state" label="活动状态">
          <template #input>
            <van-radio-group v-model="activityState" direction="horizontal">
              <van-radio v-for="item in activityStateOption" :key="item.value" :name="item.value">{{item.text}}</van-radio>
            </van-radio-group>
          </template>
        </van-field>
        <van-field name="acitvityCategory" label="活动类别">
          <template #input>
            <van-radio-group v-model="activityType" direction="horizontal">
              <van-radio v-for="item in activityTypeOption" :key="item.value" :name="item.value">{{item.text}}</van-radio>
            </van-radio-group>
          </template>
        </van-field>
        <van-field name="category" label="活动类型">
          <template #input>
            <van-checkbox-group v-model="result" direction="horizontal">
              <van-checkbox v-for="item in categories" :key="item.id" :name="item.id" shape="square">{{item.categoryName}}
              </van-checkbox>
            </van-checkbox-group>
          </template>
        </van-field>
        <van-field name="publisher" label="发布人">
          <template #input>
            <van-radio-group v-model="sex" direction="horizontal">
              <van-radio v-for="item in activitySexOption" :key="item.value" :name="item.value">{{item.text}}</van-radio>
            </van-radio-group>
          </template>
        </van-field>
        <van-field name="time" label="活动时间"
          v-model="activityTime"
          placeholder="选择时间"
          readonly="readonly"
          @click="activityTimePop = true" />
        <van-button block type="info" @click="onConfirm">确认</van-button>
      </van-dropdown-item>
    </van-dropdown-menu>

    <van-popup v-model="activityTimePop" label="活动时间" position="bottom" :overlay="true" >
      <van-datetime-picker
        v-model="currentDate"
        title="请选择时间"
        type="datetime"
        :minDate="minDate"
        @cancel="activityTimeSelectCancel"
        @confirm="activityTimeSelect"
        @change="activityTimeChange"
      />
    </van-popup>

    <van-tabs @click="clickDepartment" v-model="tabValue">
      <van-tab v-for="item in department" :title="item.abridge" :key="item.id">
        <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
          <van-list
            v-model="loading"
            :finished="finished"
            finished-text="我是有底线的"
            @load="onLoad"
            v-show="flag"
          >
            <van-skeleton title avatar :row="5" :loading="isShow" v-for="item in list" :key="item.id">
              <div class="contentItem animated fadeIn" style="display: flex;margin-top: 5px;background: white;padding: 5px;">
                <van-image round :src="item.avatar" class="contentItem-img" @click="toInfo(item.studentId, item.avatar, item.nickname)"/>
                <div class="contentItem-content">
                  <h3 class="contentItem-publisher">{{item.nickname}}</h3>
                  <div style="text-align: center;">
                    <p class="contentItem-title">{{item.title}}</p>
                  </div>
                  <div @click="toDetail(item)">
                    <div>
                      <van-tag round type="warning" v-show="item.type === 1">组织活动</van-tag>
                      <van-tag round type="success" v-show="item.type === 2">报名活动</van-tag>
                    </div>
                    <p class="contentItem-time">活动时间: {{item.startTime}} 到 {{item.endTime}}</p>
                    <p class="contentItem-more">{{item.abs}}</p>
                    <p class="contentItem-more" v-html="item.content"></p>
                  </div>
                  <van-grid :border="false" :column-num="3">
                    <van-grid-item v-for="(image, index) in item.images" :key="index" @click="clickImages(item.images)">
                      <van-image :src="image"/>
                    </van-grid-item>
                  </van-grid>
                </div>
              </div>
              <div style="background: white;text-align: right;padding-right: 15px;">
                <van-icon name="friends-o" :badge="item.signNumber" style="margin-right: 5px;" color="#ADD8E6" v-show="item.type === 2" @click="toSignMessage(item.id, item.title, item.signNumber, item.maxNumber, item.studentId)"/>
                <van-icon name="comment-o" color="#DEB887" @click="getComment(item.id)"/>
              </div>
              <div style="text-align: right;background: white;padding-right: 5px;">
                <span class="contentItem-other">时间：{{item.releaseTime}}</span>
              </div>
            </van-skeleton>
          </van-list>
        </van-pull-refresh>
      </van-tab>
    </van-tabs>

    <van-popup
      v-model="showComment"
      closeable
      position="bottom"
      :style="style">
      <comment v-if="showComment" :id="itemId" :category="itemCategory"></comment>
    </van-popup>

  </div>
</template>

<script>
import Comment from '@/components/Comment'
import { checkSignActivity } from '@/api/other'
import { ImagePreview, Dialog } from 'vant'
import Department from '@/resources/Department'
import { getCategory } from '@/api/category'
import { getActivity } from './api/Activity'
export default {
  name: 'ContentIndex',
  components: {
    Comment
  },
  data () {
    return {
      flag: false,
      title: '',
      result: [],
      resultInit: [],
      departmentId: '',
      sex: 0,
      pageIndex: 0,
      activityState: 2,
      activityType: 0,
      activityTime: '',
      pageSize: 6,
      tabValue: 0,
      minDate: new Date(2020, 0, 1),
      currentDate: '',
      activityTimePop: false,
      totalRecords: '',
      activeNames: [],
      department: Department,
      isShow: true,
      showComment: false,
      value: '',
      list: [],
      loading: false,
      finished: false,
      refreshing: false,
      categories: [],
      activityStateOption: [
        { text: '未结束', value: 2 },
        { text: '已结束', value: 4 },
        { text: '已取消', value: 5 }
      ],
      activityTypeOption: [
        { text: '全部', value: 0 },
        { text: '组织活动', value: 1 },
        { text: '报名活动', value: 2 }
      ],
      activitySexOption: [
        { text: '全部', value: 0 },
        { text: '男', value: 1 },
        { text: '女', value: 2 }
      ],
      itemId: 0,
      itemCategory: 1,
      commentList: [{
        id: '1',
        studentId: '1',
        avatar: 'https://img.yzcdn.cn/vant/logo.png',
        nickname: '评论人',
        content: '内容内容内容内容内容内容内容',
        releaseTime: '2020-03-04 10:45:42'
      },
      {
        id: '2',
        studentId: '2',
        avatar: 'https://img.yzcdn.cn/vant/logo.png',
        nickname: '评论人',
        content: '内容内容内容内容内容内容内容',
        releaseTime: '2020-03-04 10:45:42'
      },
      {
        id: '3',
        studentId: '3',
        avatar: 'https://img.yzcdn.cn/vant/logo.png',
        nickname: '评论人',
        content: '内容内容内容内容内容内容内容',
        releaseTime: '2020-03-04 10:45:42'
      }],
      commentLoading: false,
      style: {
        height: '70%'
      },
      commentListLoading: false,
      commentFinished: true,
      commentPageIndex: 0,
      commentPageSize: 0,
      commentMessage: ''
    }
  },
  methods: {
    getComment (id) {
      this.itemId = id
      this.showComment = true
    },
    toInfo (studentId, avatar, nickname) {
      this.$router.push({
        name: 'Info',
        params: {
          studentId: studentId,
          avatar: avatar,
          nickname: nickname
        }
      })
    },
    toSignMessage (id, title, signNumber, studentId, maxNumber) {
      const myId = this.$store.getters.id
      if (myId === studentId) {
        Dialog.confirm({
          title: title,
          message: '该活动共' + signNumber + '人报名哦！',
          confirmButtonText: '查看报名'
        }).then(() => {
          this.toSignList(id)
          // on confirm
        }).catch(() => {
          // on cancel
        })
      } else {
        Dialog.confirm({
          title: title,
          message: '该活动共' + signNumber + '人报名哦！赶紧去报名吧~',
          confirmButtonText: '前往报名'
        }).then(() => {
          // on confirm
          if (signNumber >= maxNumber) {
            Dialog({ message: '该活动已报满哦~' })
          } else {
            const paras = {
              activityId: id,
              studentId: this.$store.getters.id
            }
            checkSignActivity(paras).then(res => {
              const flag = res.data
              if (flag) {
                this.toSignList(id)
              } else {
                this.$router.push({
                  path: '/sign',
                  query: {
                    id: id,
                    title: title
                  }
                })
              }
            })
          }
        }).catch(() => {
          // on cancel
        })
      }
    },
    toSignList (id) {
      this.$router.push({
        path: '/signlist',
        query: {
          activityId: id
        }
      })
    },
    onLoad () {
      if (this.refreshing) {
        this.pageIndex = 0
        this.list = []
        this.refreshing = false
      }
      this.getContents()
    },
    getContents () {
      const props = {
        title: this.title,
        sex: this.sex,
        activitystate: this.activityState,
        activitytype: this.activityType,
        activitytime: this.activityTime,
        category: this.result.join(','),
        departmentid: this.tabValue,
        pageindex: this.pageIndex,
        pagesize: this.pageSize
      }
      getActivity(props).then(res => {
        this.list = this.list.concat(res.data.entities)
        this.totalRecords = res.data.totalRecords
        this.pageIndex++
        this.loading = false
        this.isShow = false
        if (this.list.length >= this.totalRecords) {
          this.finished = true
        }
      })
    },
    searchActivity () {
      this.clearProps()
      this.getContents()
    },
    onRefresh () {
      this.finished = false
      this.loading = true
      this.onLoad()
    },
    clickImages (images) {
      ImagePreview({
        images: images,
        closeable: true
      })
    },
    clickDepartment (values) {
      this.result = this.resultInit
      this.departmentId = values
      this.clearProps()
      this.getContents()
    },
    onConfirm () {
      this.clearProps()
      this.$refs.selects.toggle(false)
      this.getContents()
    },
    getCategory () {
      getCategory().then(res => {
        const data = res.data.entities
        this.result = data.map(item => item.id)
        this.resultInit = this.result
        this.categories = data
        this.flag = true
        this.onLoad()
      })
    },
    clearProps () {
      this.pageIndex = 0
      this.list = []
      this.loading = true
      this.isShow = true
      this.finished = false
    },
    activityTimeChange (e) {
      let activityTimeArr = e.getValues()
      this.activityTime = `${activityTimeArr[0]}-${activityTimeArr[1]}-${activityTimeArr[2]} ${activityTimeArr[3]}:${activityTimeArr[4]}:00`
    },
    activityTimeSelect () {
      this.activityTimePop = false
      setTimeout(() => {
        this.$refs.selects.toggle(true)
      }, 10)
    },
    activityTimeSelectCancel () {
      this.activityTime = ''
      this.activityTimePop = false
      setTimeout(() => {
        this.$refs.selects.toggle(true)
      }, 10)
    },
    toDetail (item) {
      this.$router.push({
        name: 'ActivityDetail',
        params: {
          item: item
        }
      })
    },
    toAddActivity () {
      this.$router.push('/addactivity')
    },
    commentOnLoad () {
    }
  },
  mounted: function () {
    this.getCategory()
  }
}
</script>

<style scoped>
.contentItem-content {
  padding-top: 6px;
  text-align: left;
}
.contentItem-publisher {
  margin: 0;
  font-size: 14px;
  line-height: 20px;
}
.contentItem-more {
  margin: 8px 0 0;
  font-size: 14px;
  line-height: 20px;
  overflow: hidden;
  -webkit-line-clamp: 4;
  -webkit-box-orient: vertical;
  text-overflow: ellipsis;
  display: -webkit-box;
}
.contentItem-title {
  margin: 8px 0 0;
  font-size: 10px;
  line-height: 20px;
  font-weight: bold;
}
.contentItem-time {
  margin: 8px 0 0;
  font-size: 10px;
  line-height: 20px;
}
.contentItem-img {
  flex-shrink: 0;
  width: 32px;
  height: 32px;
  margin-right: 16px;
}
.contentItem-other {
  font-size: 8px;
}
.van-checkbox-group--horizontal {
  margin: 5px;
}
.van-skeleton {
  margin-top: 5px;
}
.comment-content {
  padding-top: 6px;
  text-align: left;
}
.comment-publisher {
  margin: 0;
  font-size: 14px;
  line-height: 20px;
}
.comment-more {
  margin: 8px 0 0;
  font-size: 14px;
  line-height: 20px;
}
.comment-img {
  flex-shrink: 0;
  width: 32px;
  height: 32px;
  margin-right: 16px;
}
.comment-other {
  font-size: 8px;
}
.van-dropdown-menu {
  height: 30px;
}
.van-dropdown-menu >>> .van-dropdown-menu__item {
  -webkit-justify-content: left;
  justify-content: left;
}
.van-cell >>> .van-field__label {
  width: 60px;
}
</style>

<style>
.van-grid-item__content {
  padding: 0;
}
.van-cell__title,.van-cell__value {
  text-align: left;
}
.van-collapse-item__content {
  padding: 0;
}
.van-list {
  margin-bottom: 50px;
}
</style>
