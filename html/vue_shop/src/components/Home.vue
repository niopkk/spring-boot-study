<template>
  <el-container class="home-container">
    <el-header>
      <div>
        <img src="../assets/login.png">
        <span>
           后台管理
        </span>
      </div>
      <el-button type="primary">退出</el-button>
    </el-header>
    <el-container>
      <el-aside :width="isCollapse?'64px':'200px'">
        <div class="toggle-button" @click="toggleCollapse">|||</div>
        <el-menu
          :default-active="activePath"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#333744"
          text-color="#fff"
          active-text-color="#ffd04b"
          unique-opened
          :collapse="isCollapse"
          :router="true">
          <el-submenu :index="menu.id+''" v-for="menu in menus" :key="menu.id">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>{{menu.name}}</span>
            </template>
            <el-menu-item :index="subItem.path+''"
                          v-for="subItem in menu.children"
                          :key="subItem.id"
                          @click="activeClick(subItem.path)">
              <template slot="title">
                <i class="el-icon-menu"></i>
                <span>{{subItem.name}}</span>
              </template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view>

        </router-view>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
  export default {
    data () {
      return {
        menus: [],
        isCollapse: false,
        activePath: ''
      }
    },
    created () {
      this.getMenuList()
    },
    methods: {
      handleOpen (key, keyPath) {
        console.log(key, keyPath)
      },
      handleClose (key, keyPath) {
        console.log(key, keyPath)
      },
      async getMenuList () {
        const { data } = await this.$http.get('menu')
        console.log(data)
        if (data.code > 0) {

          this.menus = data.data
        }
      },
      toggleCollapse () {
        this.isCollapse = !this.isCollapse
      },
      activeClick (path) {
        this.activePath = path
      }
    }
  }
</script>

<style lang="less" scoped>
  .home-container {
    height: 100%;
  }


  .el-header {
    background-color: #373d41;
    display: flex;
    justify-content: space-between;
    padding-left: 0;
    align-items: center;
    font-size: 20px;

    > div {
      display: flex;
      align-items: center;

      > span {
        margin-left: 15px;
        color: #ffffff;
      }
    }
  }

  .el-aside {
    background-color: #333744;

    .el-menu {
      border-right: none;
    }
  }

  .toggle-button {
    background-color: #4a5064;
    font-size: 10px;
    line-height: 24px;
    color: #ffffff;
    text-align: center;
    letter-spacing: 0.2em;
    cursor: pointer;
  }

  .el-main {
    background-color: #eaedf1;
  }
</style>
