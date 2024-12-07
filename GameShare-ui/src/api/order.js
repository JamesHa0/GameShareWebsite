import request from '@/utils/request'

export function getOrderAndItsGame(uid) {
    return request({
        url: `/order/orderGame/${uid}`,
        method: 'get'
    })
}