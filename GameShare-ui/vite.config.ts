import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {          // 路径别名
    alias: {
      '@': '/src',
      '@game': '/src/assets/game',
      '@images': '/src/assets/images',
    },
  },
})
