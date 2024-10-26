import { createApp } from 'vue'
// import './style.css'
// import './public.js'    // 自己写的public.js
import App from './App.vue'
// import 'element-plus'
import axios from 'axios'
import './mock'

import router from './router'
import store from './store'
import { getCookie } from './public'




//请求拦截器。用于在每个axios的Header添加token
axios.interceptors.request.use(
    config => {
        config.baseURL = 'http://localhost:8080/';   // 自动添加基础 URL
        const token = localStorage.getItem('Token');
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

// 在每个axios的Cookie中添加JSESSIONID
// axios.interceptors.request.use(
//     config => {
//         const JSESSIONID = getCookie('JSESSIONID');
//         if (JSESSIONID) {
//             // 确保headers对象存在
//             if (!config.headers) {
//                 config.headers = {};
//             }
//             // 添加或修改Cookie header
//             // config.headers.Cookie = `JSESSIONID=${JSESSIONID}`;
//             config.headers.Authorization = "我设置的字符串";
//             // config={}
//         }
//         return config;
//     },
//     error => {
//         return Promise.reject(error);
//     }
// );

createApp(App)
    .use(router)
    .use(store)
    .mount('#app')
