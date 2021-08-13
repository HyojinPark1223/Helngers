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
            <label
              for="email">email&nbsp;</label>
            <input
              v-model="formData.email"
              id="email"
              placeholder="email을 입력하세요"
              type="text" />
            <div clss="error-text"></div>
          </div>
          <div class="input-with-label">
            <label
              for="password">비밀번호&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input
              v-model="formData.password"
              id="password"
              placeholder="비밀번호를 입력하세요"
              type="password" />
            <div clss="error-text"></div>
          </div>
          <div class="button-div">
            <button
              class="btn btn-primary"
              @click="login">
              LOGIN
            </button>
            <button
              class="btn btn-secondary"
              @click="toSignup">
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
import UserService from '../services/user.service'
import User from '../models/user'
import vuex from 'vuex'

export default {
  created() {
    AOS.init()
  },
  components: {
    Logo,
  },
  data() {
    return {
      formData: new User('', ''),
    }
  },
  methods: {
    ...vuex.mapActions(['updateUser']),
    login() {
      console.log('로긴 누른 state')
      console.log(this.$store.state)
      UserService.login(this.formData).then(
        response => {
          // console.log(response)
          console.log(response.data)
          console.log('id')
          console.log(response.data.id)
          console.log(this.$store.state)
          console.log('업데이트 전')

          this.updateUser(response.data)
        },
        // response.data.password = this.FormData.password
        console.log('로긴')
      )
    },
    toSignup() {
      this.$router.push('/signup')
    }
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
            input {
              margin-left: 15px;
            }
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
              width: 100px;
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
  }
</style>