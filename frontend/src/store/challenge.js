import axios from "axios"

export default {
  namespaced: true,
  state: {
    challenges: null,
    singleChallenge: null,
    title: "",
    content: "",
    url: "",
    id: "",
  },
  getters: {

  },
  // commit
  mutations: {
    getSuccess(state, payload) {
      state.challenges = payload
    },
    getSingleChallenge(state, payload) {
      state.singleChallenge = payload
      state.title = payload.title
      state.content = payload.content
      state.url = payload.url
      state.id = payload.id
    }
  },
  // dispatch
  actions: {
    getChallenge({ commit }) {
      axios
        .get('http://i5c206.p.ssafy.io/api/challenges/list')
        .then(res => {
          let challenge_info = res.data
          console.log(res.data)
          commit('getSuccess', challenge_info)
        })
        .catch(() => {
          alert('챌린지를 불러오는 데 실패했습니다.')
        })
    },
    getChallengeId({ commit, state }, id) {
      console.log(id)
      console.log(state.challenges[id-1])
      let singleC = state.challenges[id-1]
      commit('getSingleChallenge', singleC)
      console.log(state.singleChallenge)
    }
  }
}