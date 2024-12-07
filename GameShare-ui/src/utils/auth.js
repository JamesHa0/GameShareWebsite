export function getRawToken() {       // 获取token
    return localStorage.getItem('Token');
}

export function setToken(token) {       // 设置token
    localStorage.setItem('Token', token);
}

export function removeToken() {       // 删除token
    localStorage.removeItem('Token');
}

export function parseToken(token) {       // 解析token
    let base64Url = token.split('.')[1];
    let base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    let jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}

export function getDecodedToken() {       // 获取token，返回解码后的token
    let token = getRawToken();
    if (token) {
        let decodedToken = parseToken(token);
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

const auth = {
    getRawToken,
    setToken,
    removeToken,
    parseToken,
    getDecodedToken
};

export default auth;