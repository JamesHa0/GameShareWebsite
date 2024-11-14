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
            return null;
        }
    } else {
        console.error('本地存储的Token 为空。');
        return null;
    }
}


export function isNull(obj) {
    return obj == null || obj == undefined || obj == '' ;
}


//开始 加载loading
  let startLoading=()=>{
    loading = Loading.service({
      lock: true,
    //   text: window.$Vue.$t('common.loading'),//加载动画的文字
      background: 'rgba(0, 0, 0, 0.7)'//加载动画的背景
    })
  }
  //结束 取消loading加载
  let endLoading=()=>{
    loading.close()
  }
   
  //showFullScreenLoading() 与 tryHideFullScreenLoading() 目的是合并同一页面多个请求触发loading
   
  let needLoadingRequestCount = 0 //声明一个变量
   
  let showFullScreenLoading=()=> {
    if (needLoadingRequestCount === 0) { //当等于0时证明第一次请求 这时开启loading
      startLoading()
    }
    needLoadingRequestCount++ //全局变量值++
  }
   
  let tryHideFullScreenLoading=()=> {
    if (needLoadingRequestCount <= 0) return //小于等于0 证明没有开启loading 此时return
    needLoadingRequestCount-- //正常响应后 全局变量 --
    if (needLoadingRequestCount === 0) {  //等于0 时证明全部加载完毕 此时结束loading 加载
      endLoading()
    }
  }