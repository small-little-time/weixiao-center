<template>
  <section class="app-container">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters" @submit.native.prevent>
        <el-form-item>
          <el-input v-model="filters.username" clearable placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-select v-model="filters.sex" clearable placeholder="性别">
          <el-option
            v-for="item in sexs"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select v-model="filters.state" clearable placeholder="状态">
          <el-option
            v-for="item in states"
            :key="item.id"
            :label="item.name"
            :value="item.id">
          </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="getStudents">查询</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="students" highlight-current-row @selection-change="selsChange" style="width: 100%;">
      <el-table-column type="selection" width="45">
      </el-table-column>
      <el-table-column type="index" width="50">
      </el-table-column>
      <el-table-column prop="username" label="用户名" width="60">
      </el-table-column>
      <el-table-column prop="truename" label="姓名" width="80">
      </el-table-column>
      <el-table-column prop="nickname" label="昵称" width="100">
      </el-table-column>
      <el-table-column prop="icon" label="头像" width="60">
        <template slot-scope="scope">
          <img :src="scope.row.faceImg" width="50" height="50" />
        </template>
      </el-table-column>
      </el-table-column>
      <el-table-column prop="sex" label="性别" width="60" :formatter="formatSex">
      </el-table-column>
      <el-table-column prop="age" label="年龄" width="60">
      </el-table-column>
      <el-table-column prop="area" label="地区" width="80">
      </el-table-column>
      <el-table-column prop="number" label="学号" min-width="50">
      </el-table-column>
      <el-table-column prop="phone" label="手机号" min-width="50">
      </el-table-column>
      <el-table-column prop="academyName" label="专业名称" min-width="60">
      </el-table-column>
<!--       <el-table-column prop="autograph" label="个性签名" min-width="80">
      </el-table-column> -->
      <el-table-column prop="state" label="状态" min-width="30" :formatter="formatState">
      </el-table-column>
      <el-table-column label="操作" width="240">
        <template slot-scope="scope">
          <el-button size="small" @click="handleDetail(scope.$index, scope.row)">数据</el-button>
          <el-button size="small" type="primary" @click="handleState(scope.$index, scope.row)">禁/启</el-button>
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
      <el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="editForm.name" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group v-model="editForm.sex">
            <el-radio class="radio" :label=1>男</el-radio>
            <el-radio class="radio" :label=0>女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input-number v-model="editForm.age" :min="0" :max="200"></el-input-number>
        </el-form-item>
        <el-form-item label="生日">
          <el-date-picker type="date" placeholder="选择日期" v-model="editForm.birth"></el-date-picker>
        </el-form-item>
        <el-form-item label="地址">
          <el-input type="textarea" v-model="editForm.addr"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
       <el-button @click.native="dialogFormVisible=false">取消</el-button>
      </div>
    </el-dialog>
  </section>
</template>

<script>
import {
  getStudentListPage,
  removeStudent,
  disableOrEnableStudent,
  batchRemoveStudent
} from '@/api/studentList'

export default {
  data() {
    return {
      dialogStatus: '',
      textMap: {
        update: '数据详情',
        create: 'Create'
      },
      dialogFormVisible: false,
      filters: {
        username: '',
        sex: '',
        academyid: '',
        areaid: '',
        state: ''
      },
      sexs: [{
        id: '1',
        name: '男'
      }, {
        id: '2',
        name: '女'
      }, {
        id: '3',
        name: '不详'
      }],
      states: [{
        id: '0',
        name: '禁用'
      }, {
        id: '1',
        name: '启用'
      }],
      students: [],
      total: 0,
      page: 1,
      sels: [], // 列表选中列
      editFormRules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }]
      },
      // 编辑界面数据
      editForm: {
        id: '0',
        name: '',
        sex: 1,
        age: 0,
        birth: '',
        addr: ''
      },

      addFormVisible: false, // 新增界面是否显示
      addFormRules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }]
      }
    }
  },
  methods: {
    // 性别显示转换
    formatSex: function(row, column) {
      return row.sex === 1 ? '男' : row.sex === 0 ? '女' : '不详'
    },
    formatState: function(row, column) {
      return row.state === 1 ? '启用' : row.state === 0 ? '禁用' : '不详'
    },
    handleCurrentChange(val) {
      this.page = val
      this.getStudents()
    },
    // 获取用户列表
    getStudents() {
      const para = {
        pageindex: this.page - 1,
        username: this.filters.username,
        sex: this.filters.sex,
        state: this.filters.state
      }
      getStudentListPage(para).then(res => {
        this.total = res.data.totalRecords
        this.students = res.data.entities
      })
    },
    // 删除
    handleDel(index, row) {
      this.$confirm('确认删除该记录吗?', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = { id: row.id }
          removeStudent(para).then(res => {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            this.getStudents()
          })
        })
        .catch(() => {})
    },
    // 显示编辑界面
    handleDetail(index, row) {
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.editForm = Object.assign({}, row)
    },
    handleState(index, row) {
      this.$confirm('确认修改该状态吗?', '提示', {
        type: 'warning'
      })
        .then(() => {
          const para = { id: row.id }
          disableOrEnableStudent(para).then(res => {
            this.$message({
              message: '操作成功',
              type: 'success'
            })
            this.getStudents()
          })
        })
        .catch(() => {})
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
          batchRemoveStudent(para).then(res => {
            this.$message({
              message: '删除成功',
              type: 'success'
            })
            this.getStudents()
          })
        })
        .catch(() => {})
    }
  },
  mounted() {
    this.getStudents()
  }
}
</script>

<style scoped>

</style>