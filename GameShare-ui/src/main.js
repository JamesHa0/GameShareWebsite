import { createApp } from 'vue'
import App from './App.vue'
import { startLoading, endLoading } from '@js/myPublic.js'    // 自己写的public.js
import ElementPlus from'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import axios from 'axios'
import './mock'

import router from './router'
import store from './store'

import { ElMessage } from 'element-plus'



// 请求拦截器。用于在每个axios的Header添加token，和服务器前缀
axios.interceptors.request.use(
    config => {
        config.baseURL = 'http://localhost:8080/';   // 自动添加基础 URL
        const token = localStorage.getItem('Token');
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        startLoading();  // 开启加载动画
        
        return config;
    },
    error => {
        endLoading();
        return Promise.reject(error);
    }
);
// 响应拦截器
axios.interceptors.response.use(
    response => {
        endLoading();    // 结束加载动画
        return response;
    },
    error => {
        endLoading();    // 结束加载动画
        ElMessage({
            message: error,
            type: 'info'
        })
        if (error.status == 401){
            console.error('jwt为空或过期。')
			router.push('/LR')
            ElMessage({
                message: '登录信息失效，请重新登录',
                type: 'error'
            })
        } else {
            // router.push({ path: '/500' })   // 跳转错误页面
        }
        return Promise.reject(error);
    }
)


const app = createApp(App);
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
   app.component(key, component)
}

app
    .use(ElementPlus)
    import '@/assets/styles/myPublic.css'   // 自定义css。放在elmentplus后面防止被覆盖
app
    .use(router)
    .use(store)
    .mount('#app')