import { createApp } from 'vue'
import App from './App.vue'
import router from './routes/index.js'

createApp(App)
  .use(router) // 플러그인
  .mount('#app')