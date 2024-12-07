import request from '@/utils/request'

export function purchaseGame(uid, gid){
    return request({
        url: `/game/purchase/${uid}/${gid}`,
        method: 'post'
    })
}

export function getAllDetails(uid, gid){
    return request({
        url: `/game/details/${uid}/${gid}`,
        method: 'get'
    })
}

export function doLike(uid, gid){
    return request({
        url: '/game/doLike',
        method: 'post',
        data: {
            uid: uid,
            gid: gid
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
}
    
