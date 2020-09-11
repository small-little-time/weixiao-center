<template>
    <div class="app-container">
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item><i class="el-icon-date"></i>热点</el-breadcrumb-item>
                <el-breadcrumb-item>热点发布</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="form-box">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="标题">
                        <el-input v-model="form.title"></el-input>
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
                        <el-input type="textarea" rows="5" v-model="form.content"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">表单提交</el-button>
                        <el-button>取消</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>

    </div>
</template>

<script>
    import { getToken } from '@/utils/auth'
    export default {
      name: 'baseform',
      data: function() {
        return {
          headers: {
            'authorization': getToken()
          },
          imgs: [],
          stateValue: false,
          dialogImageUrl: '',
          dateTime: [],
          dialogVisible: false,
          form: {
            title: '',
            startTime: '',
            endTime: '',
            images: [],
            state: '',
            content: ''
          }
        }
      },
      methods: {
        onSubmit() {
          const para = this.form
          para.images = this.imgs
          para.startTime = this.dateTime[0]
          para.endTime = this.dateTime[1]
          para.state = this.stateValue === true ? 1 : 0
        },
        handlePictureCardPreview(file) {
          this.dialogImageUrl = file.url
          this.dialogVisible = true
        },
        removeFile(file, fileList) {
          const index = this.imgs.indexOf(file.response.data)
          this.imgs.splice(index, 1)
        },
        uploadSuccess(response, file, fileList) {
          this.imgs.push(response.data)
        }
      },
      mounted() {
        this.dateTime.push('2020-02-28 10:00:00')
        this.dateTime.push('2020-02-28 10:59:59')
      }
    }
</script>