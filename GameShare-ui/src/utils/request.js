import axios from 'axios'
import { ElMessage } from 'element-plus'
import { saveAs } from 'file-saver'
import { getRawToken } from '@/utils/auth'
import { startLoading, endLoading } from '@/utils/public'
import errorCode from '@/utils/errorCode'

// 设置默认Content-Type
axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

// 创建axios实例
const service = axios.create({
    baseURL: 'http://localhost:8080/',
    timeout: 10000
})

// 请求拦截器，接受的参数：config => {url, headers{setToken}, method, data}
service.interceptors.request.use(
  config => {
    startLoading()
    const setToken = (config.headers || {}).setToken !== false   // 是否需要设置 token
    if (getRawToken() && setToken) {
      config.headers.Authorization = `Bearer ${getRawToken()}`; // 让每个请求携带自定义token
    }
  // // get请求映射params参数
  // if (config.method === 'get' && config.params) {
  //   let url = config.url + '?' + tansParams(config.params);
  //   url = url.slice(0, -1);
  //   config.params = {};
  //   config.url = url;
  // }
    return config;
  }, 
  error => {
    endLoading()
    return Promise.reject(error)
})

// 响应拦截器
service.interceptors.response.use(
res => {
  console.log('response', res)
  endLoading();    // 结束加载动画
  const code = res.data.code || 200;  // 未设置状态码则默认成功状态
  const msg = errorCode[code] || res.data.message || errorCode['default']  // 获取错误信息

  if (code === 200) {  // 正常返回
    return res.data;  // 剥一层
  } else {
    if (code === 401) {
      ElMessage({ message: '登录信息失效，请你重登', type: 'error' });
    } else if (code === 409) {
      if (res.data.data.action === 'signIn') {
        ElMessage({ message: '今日已签到！别急呦 ~', type: 'info' });
        return Promise.reject('重复签到');
      }
    } else {
      ElMessage({ message: '系统未知异常，请麻烦管理员：' + msg, type: 'error' });
    }
    return Promise.reject('error');
  }
},
error => {
  endLoading();
  ElMessage({
      message: `响应失败。${error}`,
      type: 'error'
  })
  console.log('err' + error)
  // let { message } = error;
  // if (message == "Network Error") {
  //   message = "后端接口连接异常";
  // } else if (message.includes("timeout")) {
  //   message = "系统接口请求超时";
  // } else if (message.includes("Request failed with status code")) {
  //   message = "系统接口" + message.substr(message.length - 3) + "异常";
  // }
  // ElMessage({ message: message, type: 'error', duration: 5 * 1000 })

  // if (error.status == 401){
  //     console.error('jwt为空或过期。')
  //     router.push('/LR')
  //     ElMessage({
  //         message: '登录信息失效，请你重登',
  //         type: 'error'
  //     })
  // } else {
  //     // router.push({ path: '/500' })   // 跳转错误页面
  // }
  return Promise.reject(error);
}
)

// 通用下载方法
export function download(url, filename) {
  startLoading()
  service.get(url, {
    'responseType': 'blob'
  })
  .then(res => {
    endLoading()
    const blob = new Blob([res])
    saveAs(blob, filename)
  })
  .catch(err => {
    endLoading()
    ElMessage({ message: `下载失败！请麻烦管理员。${err}`, type: 'error' })
  })
} 


export default service