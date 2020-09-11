<template>
  <section class="app-container">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters" @submit.native.prevent>
        <el-form-item>
          <el-input v-model="filters.name" placeholder="姓名"></el-input>
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
          <el-select v-model="filters.reviewstate" clearable placeholder="选择审核状态">
          <el-option
            v-for="item in reviewstates"
            :key="item.id"
            :label="item.name"
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
          <el-button type="primary" v-on:click="getList">查询</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="list" highlight-current-row @selection-change="selsChange" style="width: 100%;">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column type="index" width="60">
      </el-table-column>
      <el-table-column prop="truename" label="姓名" width="120">
      </el-table-column>
      <el-table-column prop="academyName" label="专业" width="120">
      </el-table-column>
      <el-table-column prop="categoryName" label="类别" width="120">
      </el-table-column>
      <el-table-column prop="content" label="内容" width="120">
      </el-table-column>
      <el-table-column prop="releaseTime" label="发布时间" width="160">
      </el-table-column>
      <el-table-column prop="lookNum" label="观看数" min-width="50">
      </el-table-column>
      <el-table-column prop="likeNum" label="点赞数" min-width="50">
      </el-table-column>
      <el-table-column prop="reviewState" label="审核状态" min-width="60" :formatter="formatReviewState">
      </el-table-column>
      <el-table-column prop="state" label="状态" min-width="60" :formatter="formatState">
      </el-table-column>
      <el-table-column label="操作" width="180">
        <template slot-scope="scope">
          <el-button size="small" type="primary" @click="handleState(scope.$index, scope.row)">禁/启</el-button>
          <el-button size="small" @click="handleDetail(scope.$index, scope.row)">详情</el-button>
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
        <el-form-item label="内容">
          <el-input type="textarea" v-model="detailForm.content" readonly></el-input>
        </el-form-item>
        <el-form-item label="图片">
          <el-carousel :interval="4000" type="card">
            <el-carousel-item v-for="(item, index) in imgs" :key="index">
              <img :src="item" width="100%" />
            </el-carousel-item>
          </el-carousel>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native="dialogFormVisible=false">取消</el-button>
        <el-button type="success" @click="contentPass">通过</el-button>
        <el-button type="danger" @click="contentUnPass">不通过</el-button>
      </div>
    </el-dialog>
  </section>
</template>

<script>
import {
  getContentListPage,
  batchPassContent,
  enableOrDisable,
  review,
  getCatgoryList
} from '@/api/contentList'

export default {
  data() {
    return {
      dialogStatus: '',
      textMap: {
        update: '详情'
      },
      imgs: [],
      dialogFormVisible: false,
      filters: {
        truename: '',
        categoryid: '',
        reviewstate: '',
        state: ''
      },
      categories: [],
      reviewstates: [{
        id: '1',
        name: '未审核'
      }, {
        id: '2',
        name: '通过'
      }, {
        id: '3',
        name: '不通过'
      }],
      states: [{
        id: '1',
        name: '启用'
      }, {
        id: '2',
        name: '禁用'
      }],
      list: [],
      total: 0,
      page: 1,
      sels: [],
      detailForm: {
        id: '0',
        content: '',
        images: []
      }
    }
  },
  methods: {
    formatReviewState: function(row, column) {
      return row.reviewState === 1 ? '审核中' : row.reviewState === 2 ? '通过' : row.reviewState === 3 ? '未通过' : '未知'
    },
    formatState: function(row, column) {
      return row.state === 1 ? '启用' : row.state === 2 ? '禁用' : '未知'
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
    // 获取用户列表
    getList() {
      const para = {
        pageindex: this.page - 1,
        truename: this.filters.name,
        categoryid: this.filters.categoryid,
        reviewstate: this.filters.reviewstate,
        state: this.filters.state
      }
      getContentListPage(para).then(res => {
        this.list = res.data.entities
        this.total = res.data.totalRecords
      })
    },
    handleState(index, row) {
      this.$confirm('确认修改该状态吗?', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = { id: row.id }
          enableOrDisable(para).then(res => {
            this.$message({
              message: '操作成功',
              type: 'success'
            })
            this.getList()
          })
        })
        .catch(() => {})
    },
    handleDetail(index, row) {
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.detailForm = Object.assign({}, row)
      if (this.detailForm.images !== null && this.detailForm.images !== '') {
        this.imgs = this.detailForm.images.split(';')
      }
    },
    contentUnPass() {
      this.$confirm('确认提交吗？', '提示', {})
        .then(() => {
          const id = Object.assign({}, this.detailForm).id
          const para = {
            id: id,
            reviewstate: 3
          }
          review(para).then(res => {
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
    contentPass() {
      this.$confirm('确认提交吗？', '提示', {})
        .then(() => {
          const id = Object.assign({}, this.detailForm).id
          const para = {
            id: id,
            reviewstate: 2
          }
          review(para).then(res => {
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
    // 全选单选多选
    selsChange(sels) {
      this.sels = sels
    },
    batchPass() {
      var ids = this.sels.map(item => item.id).toString()
      this.$confirm('确认通过选中记录吗？', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = {
            ids: ids,
            reviewstate: 2
          }
          batchPassContent(para).then(res => {
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