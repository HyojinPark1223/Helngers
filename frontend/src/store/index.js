import { createStore } from 'vuex'
import profile from './profile'
import user from './user'
import medal from './medal'
import challenge from './challenge'
import board from './board'

export default createStore({
  modules: {
    profile,
    user,
    medal,
    challenge,
    board
  },
  state: {
  },
  medals:{
  },
  getters: {

  },
  mutations: {

  },
  actions: {

  }
})