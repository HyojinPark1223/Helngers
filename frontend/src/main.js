import { createApp } from 'vue'
import App from './App.vue'
import router from './routes/index'
import store from './store/index'
import scrollMagic from '../node_modules/scrollmagic'
import AOS from '../node_modules/aos'
import "aos/dist/aos.css"


createApp(App)
  .use(store) // $store
  .use(router) // 플러그인
  .use(AOS)
  .use(scrollMagic)
  .mount('#app')