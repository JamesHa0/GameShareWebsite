import request from '@/utils/request'


export function getCommentByPage(gid, current, size){
    return request({
        url: `/comment/listByPage/${gid}/${current}/${size}`,
        method: 'get'
    })
}

export function addComment(uid, gid, commentText){
    return request({
        url: '/comment/doComment',
        method: 'post',
        data: {
            uid: uid,
            gid: gid,
            commentText: commentText
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
}

export function doCommentLike(uid, gid, cid){
    return request({
        url: '/comment/doLike',
        method: 'post',
        data: {
            uid: uid,
            gid: gid,
            cid: cid
        },
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
}

export function doCommentReply(uid, gid, commentText, parentCid, parentUid){
    return request({
        url: '/comment/doReply',
        method: 'post',
        data: {
            uid: uid,
            gid: gid,
            comment: commentText,
            parentCid: parentCid,
            parentUid: parentUid
        },
        Headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    })
}