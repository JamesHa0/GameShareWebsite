import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import router from '@/router'
import store from '@/store'
import { download } from '@/utils/request'

const app = createApp(App);

app.config.globalProperties.$download = download       // 原型链全局挂载

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {   // 全局挂载element-plus图标
   app.component(key, component)
}

app
    .use(ElementPlus)
    import '@/assets/styles/myPublic.css'   // 自定义css。放在elmentplus后面防止被覆盖
app
    .use(router)
    .use(store)
    .mount('#app')