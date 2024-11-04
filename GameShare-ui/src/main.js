import { createApp } from 'vue'
import './public.js'    // 自己写的public.js
import App from './App.vue'
import ElementPlus from'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import axios from 'axios'
import './mock'

import router from './router'
import store from './store'
import { getCookie } from './public'




//请求拦截器。用于在每个axios的Header添加token，和服务器前缀
// axios.interceptors.request.use(
//     config => {
//         config.baseURL = 'http://localhost:8080/';   // 自动添加基础 URL
//         const token = localStorage.getItem('Token');
//         if (token) {
//             config.headers.Authorization = `Bearer ${token}`;
//         }
//         return config;
//     },
//     error => {
//         return Promise.reject(error);
//     }
// );


const app = createApp(App)
    .use(router)
    .use(store)
    .use(ElementPlus)
    .mount('#app')
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
    }
