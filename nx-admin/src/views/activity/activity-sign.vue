<template>
  <section class="app-container">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters" @submit.native.prevent>
        <el-form-item>
          <el-input v-model="filters.truename" clearable placeholder="姓名"></el-input>
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
      <el-table-column prop="truename" label="姓名" width="160">
      </el-table-column>
      <el-table-column prop="academyName" label="专业" width="160">
      </el-table-column>
      <el-table-column prop="qq" label="qq" width="160">
      </el-table-column>
      <el-table-column prop="message" label="其他信息" width="160">
      </el-table-column>
      <el-table-column prop="signTime" label="报名时间" width="160">
      </el-table-column>
      <el-table-column label="操作" width="150">
        <template slot-scope="scope">
          <el-button size="small">操作</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-button type="danger" :disabled="this.sels.length===0">批量操作</el-button>
      <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="20" :total="total" style="float:right;">
      </el-pagination>
    </el-col>
  </section>
</template>

<script>
import {
  getSignList
} from '@/api/activityList'
export default {
  data() {
    return {
      id: '',
      filters: {
        truename: ''
      },
      list: [],
      total: 0,
      page: 1,
      sels: []
    }
  },
  methods: {
    handleCurrentChange(val) {
      this.page = val
      this.getList()
    },
    getList() {
      const para = {
        pageindex: this.page - 1,
        truename: this.filters.truename,
        activityid: this.id
      }
      getSignList(para).then(res => {
        this.list = res.data.entities
        this.total = res.data.totalRecords
      })
    },
    // 全选单选多选
    selsChange(sels) {
      this.sels = sels
    },
    getParams() {
      this.id = this.$route.query.id === undefined ? 0 : this.$route.query.id
    }
  },
  created() {
    this.getParams()
  },
  mounted() {
    this.getList()
  }
}
</script>

<style scoped>

</style>