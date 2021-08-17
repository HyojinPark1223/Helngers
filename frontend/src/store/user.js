import axios from "axios"
import router from "../routes/index"

export default {
  namespaced: true,
  // data
  state: {
    userInfo: null,
    isLogin: false,
    isLoginError: false
  },
  // computed
  getters: {},
  // 변이 : state값 변경은 여기서만 가능
  // 실행할 때  .commit() 메소드 사용
  mutations: {
    // 로그인 성공했을 때,
    loginSuccess(state, payload) {
      state.isLogin = true
      state.isLoginError = false
      state.userInfo = payload
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
    }
  },
  // 비동기 처리
  // 실행할 때 .dispatch() 메소드 사용
  // context : state 데이터 접근, payload : 입력받은 값의 매개변수
  actions: {
    // 로그인 시도
    login(loginObj) {
      // 로그인 -> 토큰반환
      axios
        .post("http://localhost:8080/login", loginObj) // email, password
        .then(res => {
          console.log(res)
          console.log(res.data)
          // 성공 시 token이 돌아옴.
          // 토킁을 헤더에 포함시켜서 유저정보를 요청
          let token = res.data
          // 토큰을 로컬 스토리지에 저장
          localStorage.setItem("access_token", token) // key - value
          //dispatch("getMemberInfo")
        })
        // 로그인 실패했을 때.
        .catch(() => {
          alert('이메일과 비밀번호를 확인하세요.')
        })
    },
    getMemberInfo({ commit }) {
      // 로컬 스토리지에 저장되어 있는 토큰을 불러온다.
      let token = localStorage.getItem("access_token")
      let config = {
        headers: {
          "access-token": token
        }
      }
      // 토큰 -> 멤버 정보를 반환
      // 새로 고침 -> 토큰만 가지고 멤버정보를 요청
      axios
        .get("https://reqres.in/api/users/2", config) // 헤더에 담아보내주기 위해 config 사용
        .then(response => {
          console.log(response)
          let userInfo = {
            id: response.data.data.id,
            first_name: response.data.data.first_name,
            last_name: response.data.data.last_name,
            email: response.data.data.email,
            avatar: response.data.data.avatar
          }
          commit('loginSuccess', userInfo)
          router.push({ name: "main" })
        })
        .catch(() => {
          alert('이메일과 비밀번호를 확인하세요.')
        })
    },
    logout({ commit }) {
      commit("logout")
      router.push({ name: "home"})
    },
    signup({dispatch}, signupObj) {
      axios
        .post('http://localhost:8080/signup', signupObj)
        .then(res => {
          // "id": 5,
          // "email": "test2@ssafy.com",
          // "password": "test",
          // "nickname": "test2",
          // "count": 0,
          // "comment_count": 0,
          // "level": 0,
          // "introduce": "test",
          // "point": 0,
          // "period": 0,
          // "purpose": 0,
          // "createdAt": "2021-08-15T20:07:29.1377038",
          // "role": "ROLE_USER"
          let email = res.email
          let password = res.password
          let loginObj = {
            email: email,
            password: password
          }
          //dispatch('login', loginObj)
        })
        .catch(() => {
          alert('다시 입력해주세요!')
        })
    }
  }
}