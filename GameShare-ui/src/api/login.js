import request from '@/utils/request'

export function login(fromData){
    return request({
        url: '/login',
        method: 'post',
        data: fromData,
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'setToken': false   // 不携带Token
        }
    })
}