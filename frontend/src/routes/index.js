import { createRouter, createWebHashHistory } from 'vue-router'
import Main from '../components/Main/Main'
import Home from '../components/Home/Home'
import Login from './Login'
import Medal from '../components/Medal/Medal'
import MuscleArticle from '../components/MuscleArticle/MuscleArticle'
import MyPage from '../components/MyPage/MyPage'
import Challenge from '../components/Challenge/Challenge'
import SignUp from './SignUp'
import SingleArticle from '../components/MuscleArticle/SingleArticle'

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
      component: Home
    },
    {
      path: '/main',
      component: Main
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/medal',
      component: Medal
    },
    {
      path: '/musclearticle',
      component: MuscleArticle
    },
    {
      path: '/mypage',
      component: MyPage
    },
    {
      path: '/challenge',
      component: Challenge
    },
    {
      path: '/signup',
      component: SignUp
    },
    {
      path: '/singlearticle',
      component: SingleArticle
    }
  ]
})