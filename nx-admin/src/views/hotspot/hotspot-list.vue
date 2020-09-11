<template>
  <section class="app-container">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters" @submit.native.prevent>
        <el-form-item>
          <el-input v-model="filters.title" clearable placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="getList">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="list" highlight-current-row @selection-change="selsChange" style="width: 100%;">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column type="index" width="60">
      </el-table-column>
      <el-table-column prop="title" label="标题" width="120">
      </el-table-column>
      <el-table-column prop="content" label="内容" width="120" >
      </el-table-column>
      <el-table-column prop="releaseTime" label="发布时间" width="120">
      </el-table-column>
      <el-table-column prop="startTime" label="开始时间" width="120">
      </el-table-column>
      <el-table-column prop="endTime" label="结束时间" min-width="160">
      </el-table-column>
      <el-table-column prop="lookNum" label="浏览次数" width="120">
      </el-table-column>
      <el-table-column prop="likeNum" label="点赞次数" width="120">
      </el-table-column>
      <el-table-column prop="state" label="状态" width="120" :formatter="formatState">
      </el-table-column>
      <el-table-column label="操作" width="150">
        <template slot-scope="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button type="danger" size="small" @click="handleDel(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-button type="danger" @click="batchRemove" :disabled="this.sels.length===0">批量删除</el-button>
      <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="10" :total="total" style="float:right;">
      </el-pagination>
    </el-col>

    <!--编辑界面-->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible" :close-on-click-modal="false">
      <el-form ref="editForm" :model="editForm" label-width="80px" :rules="editFormRules">
        <el-form-item label="标题" prop="title">
            <el-input v-model="editForm.title"></el-input>
        </el-form-item>
        <el-form-item label="有效时间">
          <el-date-picker
            v-model="dateTime"
            type="datetimerange"
            value-format="yyyy-MM-dd HH:mm:ss"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期">
          </el-date-picker>
        </el-form-item>
          <el-form-item label="图片">
            <el-upload
              action="http://47.100.91.56:8089/file/upload"
              list-type="picture-card"
              :on-success="uploadSuccess"
              :file-list="listArr"
              :headers="headers"
              :on-remove="removeFile"
              :on-preview="handlePictureCardPreview">
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>
          </el-form-item>
          <el-form-item label="热点状态">
              <el-switch
                v-model="stateValue"
                active-text="启用"
                inactive-text="禁用">
              </el-switch>
          </el-form-item>
          <el-form-item label="文本框">
              <el-input type="textarea" rows="5" v-model="editForm.content"></el-input>
          </el-form-item>
        </el-form>
      <div slot="footer" class="dialog-footer">
       <el-button @click.native="dialogFormVisible=false">取消</el-button>
        <el-button v-if="dialogStatus=='create'" type="primary" @click="createData">添加</el-button>
        <el-button v-else type="primary" @click="updateData">修改</el-button>
      </div>
    </el-dialog>
  </section>
</template>

<script>
import { getToken } from '@/utils/auth'
import {
  getHotspotListPage,
  removeHotspot,
  batchRemoveHotspot,
  editHotspot,
  addHotspot
} from '@/api/hotspotList'

export default {
  data() {
    return {
      headers: {
        'authorization': getToken()
      },
      listArr: [],
      imgs: [],
      stateValue: false,
      dialogImageUrl: '',
      dateTime: [],
      dialogVisible: false,
      editForm: {
        title: '',
        startTime: '',
        endTime: '',
        images: '',
        state: '',
        content: ''
      },
      dialogStatus: '',
      textMap: {
        update: '编辑热点',
        create: '新增热点'
      },
      dialogFormVisible: false,
      filters: {
        title: ''
      },
      list: [],
      total: 0,
      page: 1,
      sels: [], // 列表选中列
      editFormRules: {
        title: [{
          required: true, message: '请输入标题', trigger: 'blur'
        }]
      },
      addFormVisible: false, // 新增界面是否显示
      addFormRules: {
        title: [{ required: true, message: '请输入姓名', trigger: 'blur' }]
      }
    }
  },
  methods: {
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    },
    removeFile(file, fileList) {
      const status = this.dialogStatus
      if (status === 'create') {
        const index = this.imgs.indexOf(file.response.data)
        this.imgs.splice(index, 1)
      } else {
        const index = this.imgs.indexOf(file.url)
        this.imgs.splice(index, 1)
      }
    },
    uploadSuccess(response, file, fileList) {
      this.imgs.push(response.data)
    },
    formatState: function(row, column) {
      return row.state === 1 ? '启用' : row.state === 0 ? '禁用' : '未知'
    },
    handleCurrentChange(val) {
      this.page = val
      this.getList()
    },
    getList() {
      const para = {
        page: this.page - 1,
        title: this.filters.title
      }
      getHotspotListPage(para).then(res => {
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
          removeHotspot(para).then(res => {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            this.getList()
          })
        })
        .catch(() => {})
    },
    // 显示编辑界面
    handleEdit(index, row) {
      this.dateTime = []
      this.listArr = []
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.editForm = Object.assign({}, row)
      this.stateValue = this.editForm.state === 1
      this.dateTime.push(this.editForm.startTime)
      this.dateTime.push(this.editForm.endTime)
      if (this.editForm.images !== null && this.editForm.images !== '') {
        this.imgs = this.editForm.images.split(';')
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
    // 显示新增界面
    handleAdd() {
      this.listArr = []
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.dateTime = ''
      this.stateValue = true
      this.imgs = []
      this.editForm = {
        title: '',
        startTime: '',
        endTime: '',
        images: '',
        state: '',
        content: ''
      }
    },
    // 编辑
    updateData() {
      this.$refs.editForm.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {})
            .then(() => {
              const data = Object.assign({}, this.editForm)
              const para = {
                id: '',
                title: '',
                startTime: '',
                endTime: '',
                images: '',
                state: '',
                content: ''
              }
              para.id = data.id
              para.title = data.title
              para.content = data.content
              para.images = this.imgs.join(';')
              para.startTime = this.dateTime[0]
              para.endTime = this.dateTime[1]
              para.state = this.stateValue === true ? 1 : 0
              editHotspot(para).then(res => {
                this.$message({
                  message: '提交成功',
                  type: 'success'
                })
                this.$refs['editForm'].resetFields()
                this.dateTime = []
                this.stateValue = true
                this.imgs = []
                this.dialogFormVisible = false
                this.listArr = []
                this.getList()
              })
            })
            .catch(e => {
              // 打印一下错误
              console.log(e)
            })
        }
      })
    },
    // 新增
    createData: function() {
      this.$refs.editForm.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {})
            .then(() => {
              const para = Object.assign({}, this.editForm)
              para.images = this.imgs.join(';')
              para.startTime = this.dateTime[0]
              para.endTime = this.dateTime[1]
              para.state = this.stateValue === true ? 1 : 0
              addHotspot(para).then(res => {
                this.$message({
                  message: '提交成功',
                  type: 'success'
                })
                this.$refs['editForm'].resetFields()
                this.dateTime = []
                this.stateValue = true
                this.imgs = []
                this.dialogFormVisible = false
                this.listArr = []
                this.getList()
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
    // 批量删除
    batchRemove() {
      var ids = this.sels.map(item => item.id).toString()
      this.$confirm('确认删除选中记录吗？', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = { ids: ids }
          batchRemoveHotspot(para).then(res => {
            this.$message({
              message: '删除成功',
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
  }
}
</script>

<style scoped>

</style>