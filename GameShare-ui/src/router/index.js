import { createRouter , createWebHistory} from "vue-router";
import store from '@/store'; // 假设你用 Vuex 存储认证状态
import component from "element-plus/es/components/tree-select/src/tree-select-option.mjs";

const routers = [{   
        path:"/",
        component: () => import("@/views/index/index.vue") , 
        meta: { requiresAuth: true },
    },{
        path:"/detail",
        component: () => import("@/views/detail/detail.vue"),
        meta: { requiresAuth: true },
    },{
        path:"/info",
        component: () => import("@/views/info/info.vue"),
        meta: { requiresAuth: true },
    }
    ,
    {
        path:"/LR",
        component: () => import("@/views/LR/LR.vue")    //无需认证
    },{
        path:"/404",
        component: () => import("@/error/404.vue"), // 无需认证
    },{
        path:"/login", 
        component: () => import("@/views/LR/login.vue"),  //无需认证
    },{
        path:"/test", 
        component: () => import("@/views/test.vue"),   //无需认证
    },{
        path: "/:catchAll(.*)",     // 匹配其他所有未定义的路径
        redirect: "/404"
    }
    
]

const router = createRouter({
    history: createWebHistory(),
    routes: routers
})

router.beforeEach((to, from, next) => {
    // 如果路由需要认证，并且未登录，则跳转至登录页面（这里做了Token存在性验证）
    if (to.meta.requiresAuth && !store.state.isLogin
        && (localStorage.getItem("Token") == undefined 
        || localStorage.getItem("Token") == ''
        || localStorage.getItem("Token") == null)) {
        next('/LR')
    } else {
        next()
    }
})

export default router