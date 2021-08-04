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
              for="nickName">닉네임&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input
              v-model="nickName"
              placeholder="닉네임을 입력하세요."
              type="text" />
            <div clss="error-text"></div>
          </div>
          <div class="input-with-label">
            <label
              for="email">이메일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input
              v-model="email"
              placeholder="이메일을 입력하세요"
              type="text" />
            <div clss="error-text"></div>
          </div>
          <div class="input-with-label">
            <label
              for="email">비밀번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input
              v-model="password"
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
              @click="toSignup">
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
import Logo from '../components/Logo'

export default {
  components: {
    Logo,
  },
  data() {
    return {
      email: "",
      password: "",
    }
  },
  methods: {
    toSignup() {
      this.$router.push('/signup')
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