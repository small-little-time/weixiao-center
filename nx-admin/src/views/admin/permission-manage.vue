<template>
  <section class="app-container">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters" @submit.native.prevent>
        <el-form-item>
          <el-input v-model="filters.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-select v-model="filters.roleid" clearable placeholder="请选择">
          <el-option
            v-for="item in roles"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
          </el-select>
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
    <el-table :data="users" highlight-current-row @selection-change="selsChange" style="width: 100%;">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column type="index" width="60">
      </el-table-column>
      <el-table-column prop="username" label="用户名" width="240">
      </el-table-column>
      <el-table-column prop="name" label="角色" width="240">
      </el-table-column>
      <el-table-column prop="description" label="描述" width="240">
      </el-table-column>
      <el-table-column label="操作" width="180">
        <template slot-scope="scope">
          <el-button type="danger" size="middle" @click="handleDel(scope.$index, scope.row)">删除</el-button>
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
      <el-form :model="editForm" label-width="90px" :rules="editFormRules" ref="editForm">
        <el-form-item label="选择管理员" prop="username">
          <el-select v-model="editForm.adminId" clearable placeholder="请选择">
            <el-option
              v-for="item in admins"
              :key="item.id"
              :label="item.username"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="选择角色">
          <el-select v-model="editForm.roleId" clearable placeholder="请选择">
          <el-option
            v-for="item in roles"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
       <el-button @click.native="dialogFormVisible=false">取消</el-button>
        <el-button v-if="dialogStatus=='create'" type="primary" @click="createData">添加</el-button>
      </div>
    </el-dialog>
  </section>
</template>

<script>
import {
  getAdminRolesList,
  removeRelation,
  batchRemoveRelation,
  addRelation,
  getAllRoles,
  getAllAdmins
} from '@/api/adminPermission'

export default {
  data() {
    return {
      dialogStatus: '',
      textMap: {
        update: 'Edit',
        create: '添加管理员权限'
      },
      dialogFormVisible: false,
      filters: {
        username: '',
        roleid: ''
      },
      users: [],
      roles: [],
      admins: [],
      total: 0,
      page: 1,
      sels: [], // 列表选中列
      editFormRules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }]
      },
      // 编辑界面数据
      editForm: {
        adminId: '',
        roleId: ''
      },

      addFormVisible: false, // 新增界面是否显示
      addFormRules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }]
      }
    }
  },
  methods: {
    handleCurrentChange(val) {
      this.page = val
      this.getList()
    },
    // 获取用户列表
    getList() {
      const para = {
        pageindex: this.page - 1,
        username: this.filters.username,
        roleid: this.filters.roleid
      }
      getAdminRolesList(para).then(res => {
        this.users = res.data.entities
        this.total = res.data.totalRecords
      })
    },
    // 删除
    handleDel(index, row) {
      this.$confirm('确认删除该记录吗?', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = {
            adminid: row.id,
            roleid: row.roleId
          }
          removeRelation(para).then(res => {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            this.getList()
          })
        })
        .catch(() => {})
    },
    // 显示新增界面
    handleAdd() {
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.editForm = {
        adminId: '',
        roleId: ''
      }
    },
    // 新增
    createData: function() {
      this.$refs.editForm.validate(valid => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {})
            .then(() => {
              this.editForm.id = (parseInt(Math.random() * 100)).toString() // mock a id
              const para = Object.assign({}, this.editForm)
              addRelation(para).then(res => {
                this.$message({
                  message: '提交成功',
                  type: 'success'
                })
                this.$refs['editForm'].resetFields()
                this.dialogFormVisible = false
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
      var roleids = this.sels.map(item => item.roleId).toString()
      this.$confirm('确认删除选中记录吗？', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = {
            ids: ids,
            roleids: roleids
          }
          batchRemoveRelation(para).then(res => {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            this.getList()
          })
        })
        .catch(() => {})
    },
    getAllRoles() {
      const para = {
        pagesize: 1000
      }
      getAllRoles(para).then(res => {
        this.roles = res.data.entities
      })
    },
    getAllAdmins() {
      const para = {
        pagesize: 1000
      }
      getAllAdmins(para).then(res => {
        this.admins = res.data.entities
      })
    }
  },
  mounted() {
    this.getList()
    this.getAllRoles()
    this.getAllAdmins()
  }
}
</script>

<style scoped>

</style>