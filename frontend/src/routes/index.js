import { createRouter, createWebHashHistory } from 'vue-router'
import Main from './Main'
import Login from './Login'
import MedalNow from './MedalNow'
import MuscleArticleList from './MuscleArticleList'
import MyPage from './MyPage'
import Challenge from './Challenge'

export default createRouter({
  // Hash 모드, 모든 주소 앞에 #붙음
  history: createWebHashHistory(),
  scrollBehavior() { // 스크롤 위치 복구.
    return { top:0 }
  },
  // webpage 관리
  routes: [
    {
      path: '/',
      component: Main
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/medalnow',
      component: MedalNow
    },
    {
      path: '/musclearticlelist',
      component: MuscleArticleList
    },
    {
      path: '/mypage',
      component: MyPage
    },
    {
      path: '/challenge',
      component: Challenge
    }
  ]
})