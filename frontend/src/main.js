import { createApp } from 'vue'
import App from './App.vue'
import router from './routes/index'
import store from './store/index'

createApp(App)
  .use(store) // $store
  .use(router) // 플러그인
  .mount('#app')