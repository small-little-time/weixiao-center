<template>
  <section class="app-container">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters" @submit.native.prevent>
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
          <el-button type="primary" v-on:click="getReports">查询</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="list" highlight-current-row @selection-change="selsChange" style="width: 100%;" @row-dblclick="handleDetail">
      <el-table-column type="selection" :selectable="checkSelectable" width="45">
      </el-table-column>
      <el-table-column type="index" width="30">
      </el-table-column>
      <el-table-column prop="reportStudentName" label="被举报人" width="100">
      </el-table-column>
      <el-table-column prop="studentName" label="举报人" width="100">
      </el-table-column>
      <el-table-column prop="categoryId" label="类型" width="80" :formatter="formatCategory">
      </el-table-column>
      <el-table-column prop="content" label="举报说明" width="200">
      </el-table-column>
      <el-table-column prop="state" label="状态" min-width="80" :formatter="formatState">
      </el-table-column>
      <el-table-column prop="reply" label="反馈" min-width="160" :formatter="formatReply">
      </el-table-column>
      <el-table-column prop="updated" label="处理时间" min-width="150" :formatter="formatHanderTime">
      </el-table-column>
      <el-table-column label="操作" width="150">
        <template slot-scope="scope">
          <el-button size="small" @click="handleReply(scope.$index, scope.row)" :disabled="scope.row.state === 2 ? true : false">反馈</el-button>
          <el-button type="danger" size="small" @click="handleDel(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-button @click="HandleBatch" :disabled="this.sels.length===0">批量反馈</el-button>
      <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="10" :total="total" style="float:right;">
      </el-pagination>
    </el-col>

    <!--编辑界面-->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible" :close-on-click-modal="false">
      <el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
        <el-form-item label="反馈信息" prop="content">
          <el-input type="textarea" v-model="editForm.content"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
       <el-button @click.native="dialogFormVisible=false">取消</el-button>
        <el-button v-if="dialogStatus=='batch'" type="primary" @click="handlerBatchReplay">批量反馈</el-button>
        <el-button v-else type="primary" @click="doReply">反馈</el-button>
      </div>
    </el-dialog>

    <el-dialog title="内容详情" :visible.sync="dialogDetailVisible">
      <el-form :model="form">
        <el-form-item label="活动名称" label-width="80px">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogDetailVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogDetailVisible = false">确 定</el-button>
      </div>
    </el-dialog>
  </section>
</template>

<script>
import {
  getReportListPage,
  removeReport,
  reply,
  batchReply
} from '@/api/reportList'

export default {
  data() {
    return {
      dialogDetailVisible: false,
      dialogStatus: '',
      textMap: {
        update: '举报反馈',
        batch: '批量反馈'
      },
      form: {
        name: ''
      },
      dialogFormVisible: false,
      filters: {
        state: ''
      },
      states: [{
        id: '1',
        name: '未处理'
      }, {
        id: '2',
        name: '已处理'
      }],
      editForm: {
        id: '',
        content: ''
      },
      list: [],
      total: 0,
      page: 1,
      sels: [],
      editFormRules: {
        content: [{ required: true, message: '请输入反馈内容', trigger: 'blur' }]
      }
    }
  },
  methods: {
    handleDetail() {
      this.dialogDetailVisible = true
    },
    checkSelectable(row) {
      return row.state === 1
    },
    formatCategory: function(row, column) {
      return row.categoryId === 1 ? '活动' : row.categoryId === 2 ? '动态' : '无'
    },
    formatState: function(row, column) {
      return row.state === 1 ? '未处理' : row.state === 2 ? '已处理' : '未知'
    },
    formatReply: function(row, column) {
      return row.state === 1 ? '无' : row.state === 2 ? row.reply : '未知'
    },
    formatHanderTime: function(row, column) {
      return row.state === 1 ? '无' : row.state === 2 ? row.updated : '未知'
    },
    handleCurrentChange(val) {
      this.page = val
      this.getReports()
    },
    // 获取用户列表
    getReports() {
      const para = {
        page: this.page - 1,
        state: this.filters.state
      }
      getReportListPage(para).then(res => {
        this.total = res.data.totalRecords
        this.list = res.data.entities
      })
    },
    // 删除
    handleDel(index, row) {
      this.$confirm('确认删除该记录吗?', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = { id: row.id }
          removeReport(para).then(res => {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            this.getReports()
          })
        })
        .catch(() => {})
    },
    // 显示编辑界面
    handleReply(index, row) {
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      const rowData = Object.assign({}, row)
      this.editForm.id = rowData.id
    },
    HandleBatch(index, row) {
      this.dialogStatus = 'batch'
      this.dialogFormVisible = true
    },
    doReply() {
      this.$refs.editForm.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {})
            .then(() => {
              const para = Object.assign({}, this.editForm)
              reply(para).then(res => {
                this.$message({
                  message: '反馈成功',
                  type: 'success'
                })
                this.$refs['editForm'].resetFields()
                this.dialogFormVisible = false
                this.getReports()
              })
            })
            .catch(e => {
              // 打印一下错误
              console.log(e)
            })
        }
      })
    },
    // 全选单选多选
    selsChange(sels) {
      this.sels = sels
    },
    // 批量反馈
    handlerBatchReplay() {
      this.$refs.editForm.validate(valid => {
        if (valid) {
          var ids = this.sels.map(item => item.id).toString()
          this.$confirm('确认提交吗？', '提示', {
            type: 'warning'
          })
            .then(() => {
              const para = {
                ids: ids,
                content: this.editForm.content
              }
              batchReply(para).then(res => {
                this.$message({
                  message: '批量反馈成功',
                  type: 'success'
                })
                this.$refs['editForm'].resetFields()
                this.dialogFormVisible = false
                this.getReports()
              })
            })
            .catch(() => {})
        }
      })
    }
  },
  mounted() {
    this.getReports()
  }
}
</script>

<style scoped>

</style>