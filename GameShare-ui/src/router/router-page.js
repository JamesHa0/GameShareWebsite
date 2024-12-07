const routers = [{   
    path:"/",
    component: () => import("@/views/index/index.vue") , 
    name:"Index",
    meta: { requiresAuth: true },    //需要认证
},{
    path:"/detail",
    component: () => import("@/views/detail/index.vue"),
    name:"Detail",
    meta: { requiresAuth: true },
},{
    path:"/info",
    component: () => import("@/views/info/index.vue"),
    name:"Info",
    meta: { requiresAuth: true },
},{
    path:"/info/order",
    component: () => import("@/views/info/order/index.vue"),
    name:"Order",
    meta: { requiresAuth: true },
}
,
{
    path:"/LR",
    component: () => import("@/views/LR/index.vue"),    //无需认证
    name:"LR"
},{
    path:"/404",
    component: () => import("@/error/404.vue"),
},{
    path:"/500",
    component: () => import("@/error/500.vue"),
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