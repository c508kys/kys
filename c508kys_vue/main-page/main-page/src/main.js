import './assets/main.css'
import { createApp } from 'vue'
import App from './index.vue'
import router from './router' // 导入路由配置

// 创建应用实例并使用路由
const app = createApp(App)
app.use(router)
app.mount('#app')
