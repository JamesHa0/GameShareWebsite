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
    component: () => import("@/error/404.vue"),
},{
    path:"/500",
    component: () => import("@/error/500.vue"),
},{
    path:"/login", 
    component: () => import("@/views/LR/login.vue"),
},{
    path:"/test_el", 
    component: () => import("@comp/test_el.vue"),
},{
    path:"/test", 
    component: () => import("@comp/test.vue"),
},{
    path:"/swagger-ui.html#/"   // swagger
},
{
    path: "/:catchAll(.*)",     // 匹配其他所有未定义的路径
    redirect: "/404"
}

]


export default routers;