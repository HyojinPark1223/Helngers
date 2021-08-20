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
    

  },
  getters: {
    // 1. 10개의 메달들의 정보 리스트를 전부 뽑아다가 
    // 2. 유저가 가지고 있는 메달 리스트들을 뽑아다가 
    // 3. for문으로 유저 메달 리스트들을 돌리며 10개의 메달들과 id값을 비교해서
    // 4. 일치하는 친구들을 state의 출력 메달 데이터에 배열로 넣는다.
    // 5. 또한 process 데이터를 저장하여 goal 데이터와 비교해서 state의 달성률 데이터를 반영한다.

    // medals_has_users_1 : function (state) {
    //   let a = state.medals_has_users.filter(m => m.kind === 1)
    //   return a
    // },
    // medals_has_users_2 : function (state) {
    //   return state.medals_has_users.filter(m => m.kind === 2)
    // },
    // medals_has_users_3 : function (state) {
    //   return state.medals_has_users.filter(m => m.kind === 3)
    // },
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