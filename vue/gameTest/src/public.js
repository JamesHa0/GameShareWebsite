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
