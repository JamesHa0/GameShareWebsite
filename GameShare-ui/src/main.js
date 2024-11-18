import { createApp } from 'vue'
import App from './App.vue'
import  '@/assets/js/myPublic.js'    // 自己写的public.js
import ElementPlus from'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import axios from 'axios'
import './mock'

import router from './router'
import store from './store'

import { ElLoading } from 'element-plus'
let elLoading = null //定义loading变量



//请求拦截器。用于在每个axios的Header添加token，和服务器前缀
axios.interceptors.request.use(
    config => {
        config.baseURL = 'http://localhost:8080/';   // 自动添加基础 URL
        const token = localStorage.getItem('Token');
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        startLoading()  // 开启加载动画
        
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

axios.interceptors.response.use(
    response => {
        if (response.status != 200) {
            router.push({ path: '/500' })   // 跳转错误页面
        }

        endLoading()    // 结束加载动画
        return response;
    },
    error => {
        router.push({ path: '/500' })   // 跳转错误页面
        endLoading()    // 结束加载动画
        return Promise.reject(error);
    }
)


const app = createApp(App);
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
   app.component(key, component)
}

app
    .use(ElementPlus)
    import '@/assets/styles/myPublic.css'   // 自己写的css。放在elmentplus后面防止被覆盖
app
    .use(router)
    .use(store)
    .mount('#app')









//开始 加载loading
let startLoading=()=>{
    elLoading = ElLoading.service({
    //   lock: true,
    //   text: window.$Vue.$t('common.loading'),//加载动画的文字
      background: 'rgba(0, 0, 0, 0.7)'//加载动画的背景
    })
  }
  //结束 取消loading加载
  let endLoading=()=>{
    elLoading.close()
  }


