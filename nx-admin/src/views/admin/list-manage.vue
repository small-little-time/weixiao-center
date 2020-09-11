<template>
  <section class="app-container">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters" @submit.native.prevent>
        <el-form-item>
          <el-input v-model="filters.name" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="getUsers">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleAdd">新增</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row @selection-change="selsChange" style="width: 100%;">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column type="index" width="60">
      </el-table-column>
      <el-table-column prop="username" label="用户名" width="110">
      </el-table-column>
      <el-table-column prop="icon" label="头像" width="120">
        <template slot-scope="scope">
          <img :src="scope.row.icon" width="50" height="50" />
        </template>
      </el-table-column>
      <el-table-column prop="email" label="邮箱" width="120">
      </el-table-column>
      <el-table-column prop="nickName" label="昵称" width="110">
      </el-table-column>
      <el-table-column prop="loginTime" label="最后登录" min-width="110">
      </el-table-column>
      <el-table-column prop="status" label="状态" width="60" :formatter="formatStatus">
      </el-table-column>
      <el-table-column label="操作" width="240">
        <template slot-scope="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="small" type="primary" @click="handleStatus(scope.$index, scope.row)">禁/启</el-button>
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
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible" :close-on-click-modal="false" @close='closeDialog'>
      <el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
        <el-form-item label="用户名" prop="username">
          <el-input v-if="dialogStatus=='create'" v-model="editForm.username" auto-complete="off"></el-input>
          <el-input v-else v-model="editForm.username" auto-complete="off" readonly ="readonly"></el-input>
        </el-form-item>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="editForm.password" :min="0" :max="200"></el-input>
        </el-form-item>
        <el-form-item label="头像">
          <el-upload
            action="http://47.100.91.56:8089/file/upload"
            :headers="headers"
            :on-success="uploadSuccess"
            :limit="1"
            ref='upload'
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove"
            :on-exceed="handleExceed">
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="editForm.email" :min="0" :max="200"></el-input>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="editForm.nickName" :min="0" :max="200"></el-input>
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
import {
  getUserListPage,
  removeUser,
  batchRemoveUser,
  editUser,
  addUser,
  enableOrDisableUser
} from '@/api/adminTable'
import { getToken } from '@/utils/auth'
export default {
  data() {
    return {
      headers: {
        'authorization': getToken()
      },
      dialogImageUrl: '',
      dialogVisible: false,
      dialogStatus: '',
      textMap: {
        update: '编辑管理员',
        create: '新增管理员'
      },
      dialogFormVisible: false,
      filters: {
        name: ''
      },
      users: [],
      total: 0,
      page: 1,
      sels: [], // 列表选中列
      editFormRules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }]
      },
      // 编辑界面数据
      editForm: {
        id: '0',
        username: '',
        password: '',
        icon: '',
        email: '',
        nickName: ''
      },

      addFormVisible: false, // 新增界面是否显示
      addFormRules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }]
      }
    }
  },
  methods: {
    handleExceed(files, fileList) {
      this.$message({
        message: '只能上传一张图片哦~',
        type: 'warning'
      })
    },
    closeDialog() {
      this.$refs['upload'].clearFiles()
    },
    handleRemove(file, fileList) {
      console.log(file, fileList)
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    },
    uploadSuccess(response, file, fileList) {
      const data = response.data
      this.editForm.icon = data
      console.log(data)
    },
    // 性别显示转换
    formatStatus: function(row, column) {
      return row.status === 1 ? '启用' : row.status === 0 ? '禁用' : '未知'
    },
    handleCurrentChange(val) {
      this.page = val
      this.getUsers()
    },
    handleStatus(index, row) {
      this.$confirm('确认修改该状态吗?', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = { id: row.id }
          enableOrDisableUser(para).then(res => {
            this.$message({
              message: '操作成功',
              type: 'success'
            })
            this.getUsers()
          })
        })
        .catch(() => {})
    },
    // 获取用户列表
    getUsers() {
      const para = {
        pageindex: this.page - 1,
        name: this.filters.name
      }
      getUserListPage(para).then(res => {
        const data = res.data
        this.total = data.totalRecords
        this.users = data.entities
        // this.total = res.data.total
        // this.users = res.data.users
      })
    },
    // 删除
    handleDel(index, row) {
      this.$confirm('确认删除该记录吗?', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = { id: row.id }
          removeUser(para).then(res => {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            this.getUsers()
          })
        })
        .catch(() => {})
    },
    // 显示编辑界面
    handleEdit(index, row) {
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      const data = Object.assign({}, row)
      this.editForm.id = data.id
      this.editForm.username = data.username
      this.editForm.password = data.password
      this.editForm.icon = data.icon
      this.editForm.email = data.email
      this.editForm.nickName = data.nickName
    },
    // 显示新增界面
    handleAdd() {
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.editForm = {
        username: '',
        password: '',
        icon: '',
        email: '',
        nickName: ''
      }
    },
    // 编辑
    updateData() {
      this.$refs.editForm.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {})
            .then(() => {
              const para = Object.assign({}, this.editForm)
              editUser(para).then(res => {
                this.$message({
                  message: '提交成功',
                  type: 'success'
                })
                this.$refs['editForm'].resetFields()
                this.dialogFormVisible = false
                this.getUsers()
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
              addUser(para).then(res => {
                this.$message({
                  message: '提交成功',
                  type: 'success'
                })
                this.$refs['editForm'].resetFields()
                this.dialogFormVisible = false
                this.getUsers()
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
          batchRemoveUser(para).then(res => {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            this.getUsers()
          })
        })
        .catch(() => {})
    }
  },
  mounted() {
    this.getUsers()
  }
}
</script>

<style scoped>

</style>