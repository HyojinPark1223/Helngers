import { createStore } from 'vuex'
import profile from './profile'
import user from './user'
import medal from './medal'
import challenge from './challenge'

export default createStore({
  modules: {
    profile,
    user,
    medal,
    challenge
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