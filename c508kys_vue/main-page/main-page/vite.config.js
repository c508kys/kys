import { fileURLToPath, URL } from 'node:url'
import path from 'path'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': path.resolve(__dirname, './src'),
      // 可以在这里添加其他别名
      '~assets': path.resolve(__dirname, './src/assets')
    }
    // alias: {
    //   '@': fileURLToPath(new URL('./src', import.meta.url))
    // },
  },
})
