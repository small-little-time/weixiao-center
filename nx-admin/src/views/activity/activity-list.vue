<template>
  <section class="app-container">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters" @submit.native.prevent>
        <el-form-item>
          <el-input v-model="filters.truename" placeholder="发布者姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="filters.title" placeholder="标题"></el-input>
        </el-form-item>
        <el-form-item>
          <el-select v-model="filters.categoryid" clearable placeholder="选择类别">
          <el-option
            v-for="item in categories"
            :key="item.id"
            :label="item.categoryName"
            :value="item.id">
          </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select v-model="filters.state" clearable placeholder="选择状态">
          <el-option
            v-for="item in states"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select v-model="filters.type" clearable placeholder="选择类型">
          <el-option
            v-for="item in types"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="getList">查询</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="list" highlight-current-row @selection-change="selsChange" style="width: 100%;">
      <el-table-column type="selection" width="35">
      </el-table-column>
      <el-table-column type="index" width="40">
      </el-table-column>
      <el-table-column prop="truename" label="发布者" width="80">
      </el-table-column>
      <el-table-column prop="title" label="标题" width="120">
      </el-table-column>
      <el-table-column prop="abs" label="摘要" width="120">
      </el-table-column>
      <el-table-column prop="category" label="类型" width="50">
      </el-table-column>
      <el-table-column prop="releaseTime" label="发布时间" min-width="160">
      </el-table-column>
      <el-table-column prop="type" label="活动类型" min-width="80" :formatter="formatType">
      </el-table-column>
      </el-table-column>
      <el-table-column prop="signEndTime" label="报名截止" min-width="160" :formatter="formatEndTime">
      </el-table-column>
      <el-table-column prop="maxNumber" label="人数上限" min-width="80" :formatter="formatMaxNumber">
      </el-table-column>
      <el-table-column prop="state" label="状态" min-width="80" :formatter="formatState">
      </el-table-column>
      <el-table-column label="操作" width="200">
        <template slot-scope="scope">
          <el-button size="small" type="primary" @click="handleDetail(scope.$index, scope.row)">审核</el-button>
          <el-button size="small" type="info" @click="handleSign(scope.$index, scope.row)">报名信息</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-button type="danger" @click="batchPass" :disabled="this.sels.length===0">批量通过</el-button>
      <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="10" :total="total" style="float:right;">
      </el-pagination>
    </el-col>

    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible" :close-on-click-modal="false">
      <el-form :model="detailForm" label-width="80px" ref="detailForm">
        <el-form-item label="发布者" prop="name">
          <el-input v-model="detailForm.truename" readonly></el-input>
        </el-form-item>
        <el-form-item label="院部名称" prop="name">
          <el-input v-model="detailForm.academyName" readonly></el-input>
        </el-form-item>
        <el-form-item label="标题">
          <el-input v-model="detailForm.title" readonly></el-input>
        </el-form-item>
        <el-form-item label="摘要">
          <el-input v-model="detailForm.abs" readonly></el-input>
        </el-form-item>
        <el-form-item label="内容">
          <el-input type="textarea" autosize v-model="detailForm.content" readonly></el-input>
        </el-form-item>
        <el-form-item label="图片">
          <el-upload
            action="http://localhost:8089/file/upload"
            list-type="picture-card"
            :file-list="listArr"
            :disabled="true"
            :on-preview="handlePictureCardPreview">
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="dialogFormVisible=false">取消</el-button>
        <el-button type="primary" @click="updateUnPass">不通过</el-button>
        <el-button type="danger" @click="updatePass">通过</el-button>
      </div>
    </el-dialog>
  </section>
</template>

<script>
import {
  getActivityListPage,
  reviewActivity,
  batchPassActivity,
  getCatgoryList
} from '@/api/activityList'

export default {
  data() {
    return {
      dialogStatus: '',
      textMap: {
        update: '详情'
      },
      listArr: [],
      dialogFormVisible: false,
      filters: {
        truename: '',
        title: '',
        state: '',
        type: '',
        categoryid: ''
      },
      categories: [],
      states: [{
        id: '1',
        name: '未审核'
      }, {
        id: '2',
        name: '通过'
      }, {
        id: '3',
        name: '未通过'
      }, {
        id: '4',
        name: '已结束'
      }],
      types: [{
        id: '1',
        name: '组织活动'
      }, {
        id: '2',
        name: '报名活动'
      }],
      list: [],
      total: 0,
      page: 1,
      sels: [], // 列表选中列
      // 编辑界面数据
      detailForm: {
        id: '',
        truename: '',
        title: '',
        abs: '',
        content: '',
        academyName: '',
        imgs: []
      },
      dialogImageUrl: '',
      dialogVisible: false
    }
  },
  methods: {
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    },
    formatType: function(row, column) {
      return row.type === 1 ? '组织活动' : row.type === 2 ? '报名活动' : '未知'
    },
    formatState: function(row, column) {
      return row.state === 1 ? '未审核' : row.state === 2 ? '通过' : row.state === 3 ? '未通过' : '未知'
    },
    formatEndTime: function(row, column) {
      return row.type === 1 ? '无信息' : row.signEndTime
    },
    formatMaxNumber: function(row, column) {
      return row.type === 1 ? '无信息' : row.maxNumber
    },
    handleCurrentChange(val) {
      this.page = val
      this.getList()
    },
    getCatgories() {
      const para = {
        pageindex: 0,
        pagesize: 100
      }
      getCatgoryList(para).then(res => {
        this.categories = res.data.entities
      })
    },
    getList() {
      const para = {
        pageindex: this.page - 1,
        truename: this.filters.truename,
        title: this.filters.title,
        state: this.filters.state,
        type: this.filters.type,
        categoryid: this.filters.categoryid
      }
      getActivityListPage(para).then(res => {
        this.list = res.data.entities
        this.total = res.data.totalRecords
      })
    },
    handleDetail(index, row) {
      this.listArr = []
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.detailForm = Object.assign({}, row)
      if (this.detailForm.images !== null && this.detailForm.images !== '') {
        this.imgs = this.detailForm.images.split(';')
        for (var i = 0; i < this.imgs.length; i++) {
          const data = {
            name: '',
            url: ''
          }
          data.url = this.imgs[i]
          data.name = this.imgs[i].split('-')[1]
          this.listArr.push(data)
        }
      }
    },
    updateUnPass() {
      this.$confirm('确认提交吗？', '提示', {})
        .then(() => {
          const id = Object.assign({}, this.detailForm).id
          const state = 3
          const para = {
            id: id,
            state: state
          }
          reviewActivity(para).then(res => {
            this.$message({
              message: '提交成功',
              type: 'success'
            })
            this.$refs['detailForm'].resetFields()
            this.dialogFormVisible = false
            this.getList()
          })
        })
        .catch(e => {
          // 打印一下错误
          console.log(e)
        })
    },
    updatePass() {
      this.$confirm('确认提交吗？', '提示', {})
        .then(() => {
          const id = Object.assign({}, this.detailForm).id
          const state = 2
          const para = {
            id: id,
            state: state
          }
          reviewActivity(para).then(res => {
            this.$message({
              message: '提交成功',
              type: 'success'
            })
            this.$refs['detailForm'].resetFields()
            this.dialogFormVisible = false
            this.getList()
          })
        })
        .catch(e => {
          // 打印一下错误
          console.log(e)
        })
    },
    handleSign(index, row) {
      this.$router.push({
        path: '/activity/activity-sign',
        query: {
          id: row.id
        }
      })
    },
    selsChange(sels) {
      this.sels = sels
    },
    batchPass() {
      var ids = this.sels.map(item => item.id).toString()
      var state = 2
      this.$confirm('确认通过选中记录吗？', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = {
            ids: ids,
            state: state
          }
          batchPassActivity(para).then(res => {
            this.$message({
              message: '操作成功',
              type: 'success'
            })
            this.getList()
          })
        })
        .catch(() => {})
    }
  },
  mounted() {
    this.getList()
    this.getCatgories()
  }
}
</script>

<style scoped>

</style>