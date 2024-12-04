import { createRouter , createWebHistory} from "vue-router";
import store from '@/store'; // 假设你用 Vuex 存储认证状态
import {isNull } from '@/assets/js/myPublic.js'

const routers = [{   
        path:"/",
        component: () => import("@/views/index/index.vue") , 
        meta: { requiresAuth: true },    //需要认证
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
        path:"/500",
        component: () => import("@/error/500.vue"), // 无需认证
    },{
        path:"/login", 
        component: () => import("@/views/LR/login.vue"),  //无需认证
    },{
        path:"/test_el", 
        component: () => import("@comp/test_el.vue"),  //无需认证
    },{
        path:"/test", 
        component: () => import("@comp/test.vue"),   //无需认证
    },{
        path:"/swagger-ui.html#/"
    },
    {
        path: "/:catchAll(.*)",     // 匹配其他所有未定义的路径
        redirect: "/404"
    }
    
]
const router = createRouter({
    history: createWebHistory(),
    routes: routers,
  //x，横滚；y，纵滚
  scrollBehavior(to, from, savedPosition) {
    // console.log('savedPosition是：')
    // console.log(savedPosition)
    if (savedPosition) {
      return savedPosition;
    } else {
    //   const savedScrollPosition = window.sessionStorage.getItem('scrollPosition');
    //   console.log('这是新页面，拿到了上一页面存储的位置：')
    //   console.log(JSON.parse(savedScrollPosition).y)
    //   if (savedScrollPosition !== null) {
    //     return { top: parseInt(JSON.parse(savedScrollPosition).y) };
    //   }
      return { top: 0 };
    }
  },
})

router.beforeEach((to, from, next) => {
    // 如果路由需要认证，并且未登录，则跳转至登录页面（这里做了Token存在性验证）
    if (to.meta.requiresAuth && !store.state.isLogin && (isNull(localStorage.getItem("Token")))){
        next('/LR')
    }
    // 如果上次路径和本次路径相同（刷新操作），则保持滚动位置不变
    const savedPosition = { x: window.scrollX, y: window.scrollY };
    // console.log('已保存位置，这是上一页面的位置：')
    // console.log(savedPosition.y)
    window.sessionStorage.setItem('scrollPosition', JSON.stringify(savedPosition))

    next()
})

export default router