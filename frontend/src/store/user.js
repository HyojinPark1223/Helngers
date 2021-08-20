import axios from "axios"
import router from "../routes/index"

export default {
  namespaced: true,
  // data
  state:{
    userInfo: null,
    isLogin: false,
    email: null,
    isLoginError: false
  },
  // computed
  getters: {
    // user_email: (state) => {
    //   return state.userInfo.email
    // }
  },
  // 변이 : state값 변경은 여기서만 가능
  // 실행할 때  .commit() 메소드 사용
  mutations: {
    // 로그인 성공했을 때,
    loginSuccess(state, payload) {
      state.isLogin = true
      state.isLoginError = false
      state.userInfo = payload
      state.email = payload.email
    },
    // 로그인이 실패했을 때,
    LoginError(state) {
      state.isLogin = false
      state.isLoginError = false
    },
    logout(state) {
      state.isLogin = false
      state.isLoginError = false
      state.userInfo = null
      state.email = null
    }
  },
  // 비동기 처리
  // 실행할 때 .dispatch() 메소드 사용
  // context : state 데이터 접근, payload : 입력받은 값의 매개변수
  actions: {
    // 로그인 시도
    login({dispatch}, loginObj) {
      // 로그인 -> 토큰반환
      console.log(loginObj)
      axios
        .post("http://i5c206.p.ssafy.io/api/login", loginObj) // email, password
        .then(res => {
          // 성공 시 token이 돌아옴.
          // 토큰을 헤더에 포함시켜서 유저정보를 요청
          let token = res.data.token
          let user_id = res.data.user_id
          // 토큰을 로컬 스토리지에 저장
          localStorage.setItem("access_token", token) // key - value
          localStorage.setItem("user_id", user_id)
          dispatch("getMemberInfo")
          console.log('로그인 완료')
        })
        // 로그인 실패했을 때.
        .catch(() => {
          alert('이메일과 비밀번호를 확인하세요.')
        })
    },
    getMemberInfo({ commit }) {
      // 로컬 스토리지에 저장되어 있는 토큰을 불러온다.
      let token = localStorage.getItem("access_token")
      let user_id = localStorage.getItem("user_id")
      let config = {
        headers: {
          "access-token": token
        }
      }
      // 토큰 -> 멤버 정보를 반환
      // 새로 고침 -> 토큰만 가지고 멤버정보를 요청
      axios
        .get("http://i5c206.p.ssafy.io/api/profile/"+ user_id, config) // 헤더에 담아보내주기 위해 config 사용
        .then(res => {
          let userInfo = {
            email: res.data.email,
            id: res.data.id,
            introduce: res.data.introduce,
            nickname: res.data.nickname,
            comment_count: res.data.comment_count,
            boardcount: res.data.boardcount,
            password: res.data.password,
            period: res.data.period,
            point: res.data.point,
            purpose: res.data.purpose,
            role: res.data.role,
            selected_medal: res.data.selected_medal,
            createdAt: res.data.createdAt
          }
          console.log('회원정보 불러오기 완료')
          commit('loginSuccess', userInfo)
          console.log('로그인 상태 : 완료')
          router.push({ name: "main" })
          console.log('메인으로 이동')
          console.log(userInfo)
        })
        .catch(() => {
          router.push({ name: "home" })
        })
    },
    logout({ commit }) {
      commit("logout")
      localStorage.removeItem('access_token')
      localStorage.removeItem('user_id')
      router.push({ name: "home"})
    },
    signup({dispatch}, signupObj) {
      axios
        .post('http://i5c206.p.ssafy.io/api/signup', signupObj)
        .then(res => {
          let email = res.data.email
          let password = res.data.password
          let loginObj = {
            email: email,
            password: password
          }
          console.log('회원가입 완료')
          dispatch('login', loginObj)
          router.push({ name: "main" })
        })
        .catch(() => {
          alert('다시 입력해주세요!')
        })
    },
    profileUpdate({ commit }, profileObj) {
      let user_id = localStorage.getItem("user_id")
      console.log(profileObj)
      axios
        .put('http://i5c206.p.ssafy.io/api/profile/edit/'+ user_id, profileObj)
        .then(() => {
          console.log('수정 완료!')
          router.push({ name: "main" })
        })
        .catch(() => {
          alert('프로필 수정을 다시 입력해주세요!')
        })
    }
  }
}