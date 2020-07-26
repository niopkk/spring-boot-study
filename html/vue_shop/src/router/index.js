import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login'
import Home from '../components/Home'
import Welcome from '../components/Welcome'
import UserList from '../components/UserList'
import RoleList from '../components/RoleList'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/home',
    component: Home,
    redirect: '/welcome',
    children: [
      {
        path: '/welcome',
        component: Welcome
      },
      {
        path: '/users',
        component: UserList
      },{
        path: '/roles',
        component: RoleList
      }
    ]
  }
]

const router = new VueRouter({
  routes
})
router.beforeEach((to, from, next) => {
  //to 将要访问的路径
  //from 从那个路径跳转而来
  //next 是一个函数 ,表示要放行,next('/login)表示强制跳转
  if (to.path === '/login') return next()
  const tokenStr = window.sessionStorage.getItem('x_auth_token')
  if (!tokenStr) return next('/login')
  next()
})

export default router
