import { createRouter, createWebHistory, createWebHashHistory } from "vue-router";
import routers from './router-page.js'
import scrollBehavior from './router-bahavior.js'
import beforeEachGuard from './router-guard.js'

const router = createRouter({
    // history: createWebHistory(),
    history: createWebHashHistory(),
    routes: routers,
    scrollBehavior: scrollBehavior, // 管理页面滚动行为
})

router.beforeEach(beforeEachGuard)  // 路由守卫

export default router