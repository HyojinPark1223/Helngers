import axios from "axios"
export default {
  namespaced: true,
  state: {
    boardList: null,
  },
  getters: {
  },
  mutations: {
    getboards(state, payload) {
      state.boardList = payload
    }
  },
  actions: {
    getBoards({ commit }) {
      axios
      .get("http://localhost:8080/board")
      .then(res => {
        console.log(res)
        let board_info = res.data.boardList
        console.log(board_info)
        commit('getboards', board_info)
      })
      .catch(() => {

      })
    },
    createBoard({ commit }, payload) {
      const frm = new FormData() 
      console.log(payload.title)
      frm.append('title', payload.title) 
      frm.append('writer', payload.writer)
      frm.append('content', payload.content)
      frm.append('file', payload.file)
      console.log(frm)
      axios
        .post("http://localhost:8080/board", frm)
        .then(res => {
          console.log(res)
          console.log('작성완료!')
        })
        .catch(() => {

        })
    }
  }
}