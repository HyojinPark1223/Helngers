<template>
  <div class="background">
    <div
      data-aos="zoom-in"
      data-aos-duration="1000"
      class="user"
      id="login">
      <div
        class="for-sns">
        <div class="form-wrap">
          <Logo class="Logo" />
          <div class="input-with-label">
            <div>
              <p>닉네임 : </p>
            </div>
            <div>
              <input
                v-model="nickname"
                placeholder="닉네임을 입력하세요."
                type="text" />
            </div>
          </div>
          <div class="input-with-label">
            <div>
              <p>이메일 : </p>
            </div>
            <div>
              <input
                v-model="email"
                placeholder="이메일을 입력하세요."
                type="text" />
            </div>
          </div>
          <div class="input-with-label">
            <div>
              <p>비밀번호 : </p>
            </div>
            <div>
              <input
                v-model="password"
                placeholder="비밀번호를 입력하세요."
                type="password" />
            </div>
          </div>
          <div class="input-with-label">
            <div>
              <p>자기소개 : </p>
            </div>
            <div>
              <input
                v-model="introduce"
                placeholder="자기소개를 입력하세요."
                type="text" />
            </div>
          </div>
          <div class="button-div">
            <button
              class="btn btn-primary"
              @click="signup({email, password, nickname, introduce})"
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
import AOS from 'aos'
// import UserService from '../services/user.service';
// import User from '../models/user';
import Logo from '../components/Logo'
// import axios from 'axios'
// import vuex from 'vuex'

import { mapActions } from "vuex"

export default {
  created() {
    AOS.init()
  },
  components: {
    Logo,
  },
  data() {
    return {
        // formData: new User('', '', '', ''),
        // loading: false,
        // submitted: false,
        email: null,
        password: null,
        nickname: null,
        introduce: null
    }
  },
  methods: {
    // Signup() {
    //   UserService.signUp(this.formData).then(
    //     () => {
    //       console.log('요청')
    //       this.$router.push('/login')
    //     },

    //   ).then(() => {
    //     this.loading = false
    //   })
    // }
    ...mapActions('user', ["signup"]),
  }
}
</script>

<style lang="scss" scoped>
@include media-breakpoint-down(md) {
  .background {
    .user {
      .for-sns {
        width: 80% !important;
        .form-wrap {
          width: 80% !important;
          margin: 30px auto !important;
        }
      }
    }
  }
}
@include media-breakpoint-down(sm) {
  .background {
    .user {
      .for-sns {
        width: 80% !important;
        .form-wrap {
          width: 80% !important;
          margin: 30px auto !important;
        }
      }
    }
  }
}
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
            display: flex;
            justify-content: space-between;
            width: 40%;
            input {
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