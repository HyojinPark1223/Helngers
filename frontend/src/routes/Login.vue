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
          <dv class="input-with-label">
            <div>
              <p>이메일 : </p>
            </div>
            <div>
              <input
                v-model="email"
                id="email"
                placeholder="email을 입력하세요"
                type="text" />
            </div>
          </dv>
          <div class="input-with-label">
            <div>
              <p>비밀번호 : </p>
            </div>
            <div>
              <input
                v-model="password"
                id="password"
                placeholder="비밀번호를 입력하세요"
                type="password" />
            </div>
          </div>
          <div class="button-div">
            <button
              class="btn btn-primary"
              @click="login({email, password})">
              LOGIN
            </button>
            <button
              class="btn btn-secondary">
              SIGN UP
            </button>
          </div>
          <div class="add-option">
            <div class="wrap">
              <p>비밀번호를 잊으셨나요?</p>
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
import Logo from '../components/Logo'

import { mapState, mapActions } from "vuex"

export default {
  created() {
    AOS.init()
  },
  components: {
    Logo,
  },
  data() {
    return {
      email: null,
      password: null,
    }
  },
  computed: {
    ...mapState(["isLogin", "isLoginError"])
  },
  methods: {
    toSignup() {
      this.$router.push('/signup')
    },
    toMain() {
      this.$router.push('/main')
    },
    ...mapActions('user', ["login"]),
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
          margin: auto !important;
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
          margin: auto !important;
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
        border: black 1px;
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
          height: 400px;
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
            p {
              margin: 0;
              font-size: 17px;
            }}
          }
          #password, #email {
            background-color: #f1e5e5;
            border-radius: 10px;
            border: 0;
            outline: 0;
          }
          .button-div {
            display: flex;
            button {
              margin: 15px 10px;
              width: 110px;
              height: 32px;
              font-size: 15px;
            }
          }
          .add-option {
            margin: 10px 0;
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
</style>