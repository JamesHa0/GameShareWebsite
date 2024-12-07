import request from '@/utils/request'

export function getUser(uid){
    return request({
        url: `/user/${uid}`,
        method: 'get'
    })
}

export function doSignIn(uid){
    return request({
        url: `/user/signIn`,
        method: 'post',
        data: {
            uid: uid
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
}