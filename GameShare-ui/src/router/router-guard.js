import { ElMessage } from "element-plus";
import store from "@/store";
import { isNull, startLoading, endLoading } from '@/utils/public.js'
import { getDecodedToken } from '@/utils/auth.js'  

function beforeEachGuard(to, from, next) {
    const token = localStorage.getItem("Token")
    if(to.meta.requiresAuth && !store.state.isLogin) {
        if (isNull(token)){
            startLoading()
            next('/LR')
            endLoading()
            ElMessage({
                message: '请先登录',
                type: 'info'
            })
        } else {
            let decodedToken = null
            try {
                decodedToken = getDecodedToken()
                if (decodedToken.exp < Date.now() / 1000) { // 过期
                    startLoading()
                    next('/LR')
                    endLoading()
                    ElMessage({
                        message: '登录信息过期，请重新登录！每次登录有效期为7日~',
                        type: 'warning'
                    })
                } else {
                    next()  // 通过
                }
            } catch (error) {   // 异常
                startLoading()
                next('/LR')
                endLoading()
                ElMessage({
                    message: '登录凭证异常，请重新登录。',
                    type: 'error'
                })
            }
        }

    } else { 
        next() 
    }
}

export default beforeEachGuard