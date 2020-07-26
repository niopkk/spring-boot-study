import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugin/element.js'
import moment from 'moment'
import './assets/css/global.css'
import axios from 'axios'

axios.defaults.baseURL = 'http://127.0.0.1:9000/'
axios.interceptors.request.use(config => {

  console.log(config)
  config.headers.x_auth_token = window.sessionStorage.getItem('x_auth_token')
  return config
})
Vue.prototype.$http = axios
Vue.prototype.$moment = moment


Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
