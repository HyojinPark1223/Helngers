import { createApp } from 'vue'
import App from './App.vue'
import router from './routes/index'
import store from './store/index'
import AOS from '../node_modules/aos'
import "aos/dist/aos.css"
import YouTube from 'vue3-youtube'
import ImageUploader from 'vue-image-upload-resize'


createApp(App)
  .use(store) // $store
  .use(router) // 플러그인
  .use(AOS)
  .use(ImageUploader)
  .component('YouTube', YouTube)
  .mount('#app')

