import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
// import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {          // 路径别名
    alias: {
      '@': '/src',
      '@game': '/src/assets/game',
      '@images': '/src/assets/images',
      // '@': path.resolve('src')
    },
  },
  // server: {
  //   proxy: {
  //     '/game': {
  //       target: 'http://localhost:8080',  // 后端服务器地址
  //       changeOrigin: true,
  //       rewrite: (path) => path.replace(/^\/game/, '')
  //     }
  //   }
  // }
})
