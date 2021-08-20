// import axios from "axios"
// import router from "../routes/index"

import axios from "axios"

export default {
  namespaced: true,
  state: {
    user_achievement_rate : 0,
    medals_has_users: [],
    medals: {},
    medals_info_user_has: {},
    level_0_user_medal: [],
    level_1_user_medal: [],
    level_2_user_medal: [],
    level_0_user_medal_url: [],
    level_1_user_medal_url: [],
    level_2_user_medal_url: [],

  },
  getters: {
    // level_0_user_medal_url : function (state) {
    //   for (let i of state.level_0_user_medal) {
    //     let tmp = []
    //     state.level_0_user_medal_url.push(i.url)
    //   }
    //   return state.level_0_user_medal_url
    // },
    // level_1_user_medal_url : function (state) {
    //   for (let i of state.level_1_user_medal) {
    //     state.level_1_user_medal_url.push(i.url)
    //   }
    //   return state.level_0_user_medal_url
    // },
    // level_2_user_medal_url : function (state) {
    //   for (let i of state.level_2_user_medal) {
    //     state.level_2_user_medal_url.push(i.url)
    //   }
    //   return state.level_2_user_medal_url
    // }
    
  },
  mutations: {
    MEDALS(state, medals) {
      state.medals = medals
      for (let m of medals) {
        if (m.level === 0) {
          state.level_0_user_medal.push(m)
        } else if (m.level === 1) {
          state.level_1_user_medal.push(m)
        } else {
          state.level_2_user_medal.push(m)
        }
      }
    },
    MEDALS_USER_HAS(state, medals_has_users) {
      state.medals_has_users = medals_has_users
      console.log('medals')
      console.log(medals_has_users)
      
    }
  },

  actions: {
    upDate({ commit }) {
      console.log('actions시작')
      

      // console.log(localStorage.getItem("currentUser"))
      if (localStorage.getItem("access_token")) {
        console.log('됨')
        
        console.log('axios 전')
        axios
        .get(`http://i5c206.p.ssafy.io/api/medals/list`)
        .then(res => {
          console.log('메달 정보')
          console.log(res.data)
          const resdata = res.data
          commit('MEDALS', resdata)
        })
        .catch(err => {
          console.log('메달 정보 실패')
          console.log(err)
        })
        
        // get user_id
        let token = localStorage.getItem("access_token")
        let config = {
          headers: {
            "access-token": token
          }
        }
        
        let id = 11
        axios
          .get(`http://i5c206.p.ssafy.io/api/medals/list/${id}`, config)
          .then(res => {
            console.log('얍')
            console.log(res.data)
            let resdata = res.data
            // medals_id_has_user
            commit('MEDALS_USER_HAS', resdata)
          })
          .catch(err => {
            console.log('힝')
            console.log(err)
          })

      } else {
        console.log('?')
        // this.$router.push('/login')
      }

      
      

    }
  }
}