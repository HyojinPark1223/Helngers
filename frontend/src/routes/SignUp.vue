<template>
  <div class="background">
    <div
      class="user"
      id="login">
      <div
        class="for-sns">
        <div class="form-wrap">
          <Logo class="Logo" />
          <div class="input-with-label">
            <label
              for="nickName">username&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input
              v-model="formData.username"
              placeholder="username을 입력하세요."
              type="text" />
            <div clss="error-text"></div>
          </div>
          <div class="input-with-label">
            <label
              for="email">name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input
              v-model="formData.name"
              placeholder="name을 입력하세요"
              type="text" />
            <div clss="error-text"></div>
          </div>
          <div class="input-with-label">
            <label
              for="email">비밀번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input
              v-model="formData.password"
              placeholder="비밀번호를 입력하세요"
              type="text" />
            <div clss="error-text"></div>
          </div>
          <div class="input-with-label">
            <label
              for="password">비밀번호 확인</label>
            <input
              v-model="password"
              placeholder="비밀번호를 입력하세요"
              type="password" />
            <div clss="error-text"></div>
          </div>
          <div class="button-div">
            <button
              class="btn btn-primary"
              @click="Signup"
              :disabled="loading">
              SIGN UP
            </button>
          </div>
          <div class="add-option">
            <div class="wrap">
              <p>SNS 간편 회원가입</p>
            </div>
          </div>
          <div
            class="sns-login">
            <img
              src="https://me2.kr/0wmie"
              alt="google" />
            <img
              src="https://me2.kr/rh1k0"
              alt="naver" />
            <img
              src="https://me2.kr/vxczh"
              alt="kakao" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import UserService from '../services/user.service';
import User from '../models/user';
import Logo from '../components/Logo'
// import axios from 'axios'
// import vuex from 'vuex'

export default {
  components: {
    Logo,
  },
  data() {
    return {
      // email: "",
      // password: "",
        formData: new User('', '', ''),
        loading: false,
        submitted: false,
    }
  },
  methods: {
    // ...vuex.mapActions(['updateUser']),
    // Signup() {
    //   axios({
    //     method: 'post',
    //     url: 'http://localhost:8080/api/user/',
    //     data: this.fomrData
    //   })
    //     .then(res => {
    //       console.log(res)
    //     })
    //     .catch(err => {
    //       console.log(err)
    //     })
    // }
    Signup() {
      UserService.register(this.formData).then(
        () => {
          console.log('요청')
          this.$router.push('/login')
        },

      ).then(() => {
        this.loading = false
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.background {
    height: 800px;
    background-color: rgb(255,219,89, .73);
    font-family: 'Do Hyeon', sans-serif;
    .user {
      display: flex;
      flex-direction: column;
      justify-content: center;
      .for-sns {
        border: black;
        width: 600px;
        height: 500px;
        display: flex; 
        justify-content: center;
        align-content: center;
        flex-direction: column;
        margin: 10% auto;
        .form-wrap {
          background-color: white;
          width: 600px;
          height: 800px;
          border: 0;
          outline: 0;
          border-radius: 50px;
          display: flex;
          flex-direction: column;
          justify-content: center;
          align-items: center;
          .Logo {
            margin-bottom: 20px;
          }
          .input-with-label {
            margin: 10px 0;
            input {
              margin-left: 15px;
              background-color: #f1e5e5;
              border-radius: 10px;
              border: 0;
              outline: 0;
            }
          }
          .button-div {
            display: flex;
            button {
              margin: 15px 10px;
              width: 250px;
              height: 32px;
              font-size: 15px;
            }
          }
          .add-option {
            margin: 10px 0 0;
            color: rgb(192, 190, 190);
          }
          .sns-login {
            width: 600px;
            display: flex; 
            justify-content: center;
            margin-top: 10px;
            img {
              width: 35px;
              height: 35px;
              margin: 0 5px;
            }
          }
        }
      }
    }
  }
</style>