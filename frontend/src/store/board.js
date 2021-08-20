import axios from "axios"

export default {
  namespaced: true,
  state: {
    boards: null,
  },
  getters: {

  },
  mutations: {

  },
  actions: {
    getBoards() {
      axios
      .get("https://reqres.in/api/users/")
    }
  }
}