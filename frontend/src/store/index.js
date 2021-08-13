import { createStore } from 'vuex'
import profile from './profile'
import user from './user'

export default createStore({
  modules: {
    profile,
    user
  },
  state: {
    // user: JSON.parse(localStorage.getItem("currentUser")),
    // user_id:0,
  },
  getters: {
    // user: state => state.user
  },
  mutations: {
    // ["UPDATE_USER"](s, user) {
    //   s.user = user;
    // UPDATE_USER(state, user) {
    //   state.user = user
    // }
  },
  actions: {
    // updateUser({ commit }, user) {
    //   if (user) {
    //     localStorage.setItem("currentUser", JSON.stringify(user));
    //   } else {
    //     localStorage.removeItem("currentUser");
    //   }
    //   commit("UPDATE_USER", user);
    // }
  }
})