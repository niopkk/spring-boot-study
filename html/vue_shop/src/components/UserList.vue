<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
      <el-breadcrumb-item>用户列表</el-breadcrumb-item>
    </el-breadcrumb>

    <el-card class="box-card">


      <el-row :gutter="20">
        <el-col :span="7">
          <el-input placeholder="请输入内容" v-model="queryInfo.key" class="input-with-select">
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>
        <el-col :span="3">
          <el-button type="primary" @click="addDialogVisible=true">新增</el-button>
        </el-col>
      </el-row>
      <el-table style="width: 100%" :data="users" border stripe>
        <el-table-column
          prop="id"
          label="id">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="150">
        </el-table-column>
        <el-table-column
          prop="createTime"
          :formatter="dateFormat"
          label="创建时间">
        </el-table-column>
        <el-table-column
          prop="loginTime"
          :formatter="dateFormat"
          label="登录时间">
        </el-table-column>
        <el-table-column
          prop="modifyTime"
          :formatter="dateFormat"
          label="修改时间">
        </el-table-column>
        <el-table-column
          label="状态">
          <template slot-scope="scope">
            <el-switch v-model="scope.row.status" :active-value="1"
                       :inactive-value="0" @change="userStatusChange(scope.row)">
            </el-switch>
          </template>
        </el-table-column>
        <el-table-column
          label="操作" width="180px">
          <template slot-scope="scope">
            <el-button type="primary" size="mini" icon="el-icon-edit" @click="editHandler(scope.row.id)"></el-button>
            <el-tooltip effect="dark" content="分配权限" placement="top" :enterable="false">
              <el-button type="warning" size="mini"
                         icon="el-icon-share"></el-button>
            </el-tooltip>

            <el-button type="danger" size="mini" @click="deleteHandler(scope.row.id)" icon="el-icon-delete"></el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryInfo.pageIndex"
        :page-sizes="[10, 20, 50, 100]"
        :page-size="queryInfo.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="100">
      </el-pagination>

      <el-dialog title="添加用户" :visible.sync="addDialogVisible" width="30%">

        <el-form :model="userForm" ref="userFormRef" :rules="userInfoRules" label-width="100px">
          <el-form-item label="用户名" prop="name">
            <el-input v-model="userForm.name"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="userForm.password"></el-input>
          </el-form-item>
        </el-form>


        <span slot="footer" class="dialog-footer">
          <el-button @click="addDialogVisible=false">取 消</el-button>
          <el-button @click="submitUserForm" type="primary">确 定</el-button>
        </span>
      </el-dialog>
    </el-card>
  </div>

</template>

<script>
  export default {
    data () {
      return {
        queryInfo: {
          key: '',
          pageIndex: 0,
          pageSize: 20
        },
        users: [],
        addDialogVisible: false,
        userForm: {
          name: '',
          password: ''
        },
        userInfoRules: {
          name: [
            {
              required: true,
              message: '请输入活动名称',
              trigger: 'blur'
            }
          ],
          password: [
            {
              required: true,
              message: '请输入密码',
              trigger: 'blur'
            },
            {
              min: 6,
              max: 15,
              message: '长度在 6 到 15个字符',
              trigger: 'blur'
            }
          ]
        }
      }
    },

    created () {
      this.getUserList()
    },
    methods: {
      async getUserList () {
        const { data } = await this.$http.get('users', {
          params: {
            key: this.key,
          }
        })
        if (data.code > 0) {
          this.users = data.data
        }
      },
      dateFormat (row, column) {
        let date = row[column.property]
        if (date == undefined) {
          return ''
        }
        return this.$moment(date).format('YYYY-MM-DD HH:mm:ss')
      },
      handleSizeChange (newSize) {
        this.queryInfo.pageSize = newSize
        this.getUserList()
      },
      handleCurrentChange (newPage) {
        this.queryInfo.pageIndex = newPage
        this.getUserList()
      },
      userStatusChange (status) {
        console.log(status.status)
      },
      submitUserForm () {
        this.$refs.userFormRef.validate(async (valid) => {
          if (!valid) return
          const { data: res } = await this.$http.post('user/store', this.userForm)
          console.log(res)
          if (res.code > 0) {
            // this.$message.success(res.data.msg)
            this.$message.success(res.msg)
            this.addDialogVisible = false
            await this.getUserList()
          } else {
            this.$message.error(res.data.msg)
          }
        })
      },
      async editHandler (id) {
        console.log(id)
        const { data: res } = await this.$http.get('user', {
          params: {
            id: id,
          }
        })
        if (res.code > 0) {
          this.userForm.name = res.data.name
          this.userForm.password = res.data.passWord
        }
        this.addDialogVisible = true
      },
      async deleteHandler (id) {
        const confirmResult = await this.$confirm('确认删除吗！', '提示', {
          distinguishCancelAndClose: true,
          confirmButtonText: '确认',
          cancelButtonText: '取消'
        }).catch(err => err)
        if (confirmResult === 'confirm') {
          const { data: res } = await this.$http.delete('user/delete', {
            params: {
              id: id,
            }
          })
          if (res.code > 0) {
            this.$message.success('删除成功！')
            await this.getUserList()
          } else {
            this.$message.error('删除失败！')
          }
        }
      }
    }
  }
</script>

<style scoped>

</style>
