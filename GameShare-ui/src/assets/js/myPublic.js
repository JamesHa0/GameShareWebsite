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
export function parseJwt(token) {       // 解析token
    let base64Url = token.split('.')[1];
    let base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    let jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}
export function getToken() {       // 获取token，返回解码后的token
    let token = localStorage.getItem('Token');
    if (token) {
        let decodedToken = parseJwt(token);
        if (decodedToken.exp > Date.now() / 1000) {     //验证过期时间
            return decodedToken;
        } else {
            console.error('Token 已过期。');
            throw new Error('Token 已过期。');
        }
    } else {
        console.error('本地存储的Token 为空。');
        throw new Error('本地存储的Token 为空。');
    }
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