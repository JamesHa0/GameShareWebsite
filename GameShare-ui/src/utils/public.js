import router from '@/router'
import { ElMessage } from 'element-plus'
import { ElLoading } from 'element-plus'

export function getCookie(name) {       // 获取cookie
    let cookieArray = document.cookie.split(';');
    for(let i = 0; i < cookieArray.length; i++) {
        let cookiePair = cookieArray[i].trim().split('=');
        if (cookiePair[0] === name) {
            return decodeURIComponent(cookiePair[1]);
        }
    }
    return null;
}

export function isNull(obj) {   // 判断是否为空
    return obj == null || obj == undefined || obj == '' ;
}

export function isUndefined(obj){ // 判断是否为undefined
    return typeof obj === 'undefined';
}



export function startLoading() {    //开始 加载loading
    const elLoading = ElLoading.service({
      background: 'rgba(0, 0, 0, 0.7)'
    })
}

export function endLoading() {  //结束 销毁loading
    const elLoading = ElLoading.service({    // 由于是单例loading，这里不会创建一个新的实例，而仅是返回那个单例
        background: 'rgba(0, 0, 0, 0.7)'
      })   
    elLoading.close()   // 销毁
}

const util = {
    getCookie,
    isNull,
    isUndefined,
    startLoading,
    endLoading
}
export default util;