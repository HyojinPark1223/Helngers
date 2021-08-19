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
import user from '../store/user'

const rejectAuthUser = (to, from, next) => {
  if (user.state.isLogin === true) {
    //로그인된 유저니까 막아야 함.
    alert('이미 로그인을 하였습니다.')
    next("/main")
  }else {
    next()
  }
}
const onlyAuthUser = (to, from, next) => {
  if (user.state.isLogin === false) {
    //아직 로그인이 안된 유저니까 막아야 함.
    alert('로그인을 해주세요!')
    next("/login")
  }else {
    next()
  }
}

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
      name: "home",
      component: Home
    },
    {
      path: '/main',
      name: "main",
      component: Main
    },
    {
      path: '/login',
      name: "login",
      beforeEnter: rejectAuthUser,
      component: Login
    },
    {
      path: '/medal',
      name: "medal",
      beforeEnter: onlyAuthUser,
      component: Medal
    },
    {
      path: '/musclearticle',
      name: "musclearticle",
      component: MuscleArticle
    },
    {
      path: '/mypage',
      name: "mypage",
      beforeEnter: onlyAuthUser,
      component: MyPage
    },
    {
      path: '/challenge',
      name: "challenge",
      component: Challenge
    },
    {
      path: '/signup',
      name: "signup",
      component: SignUp
    },
    {
      path: '/singlearticle',
      name: "singlearticle",
      component: SingleArticle
    }
  ]
})