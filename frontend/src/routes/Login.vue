<template>
  <div class="background">
    <div class="user" id="login">
      <div class="for-sns" style="display: flex; flex-direction: column; margin-top: 5%; margin-left: 25%">
        <div class="form-wrap">
          <Logo />
          <br>
          <div class="input-with-label">
            <label for="email" style="margin-right: 35px;">이메일</label>
          
            <input v-model="email" id="email" placeholder="이메일을 입력하세요" type="text" />
            <div clss="error-text"></div>
          </div>
          <br>
          <div class="input-with-label">
            <label for="password" style="margin-right: 20px;">비밀번호</label>
            <input v-model="password" id="password" placeholder="비밀번호를 입력하세요" type="password" />
            <div clss="error-text"></div>
          </div>
          <br>
          <div class="button-div">
            <button class="button-form" type="button" style="margin-right: 20px;">
              LOGIN
            </button>
            <button class="button-form" type="button">
              <router-link to="/signup" class="button-form">SIGNUP</router-link>
            </button>
          </div>

          <div class="add-option">
            <div class="wrap">
              <p>비밀번호를 잊으셨나요?</p>
            </div>
          </div>
        </div>
        <div class="sns-login" style="display: flex; margin-left: auto; margin-top: 10px;">

          <div style="margin-left: auto;">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/600px-Google_%22G%22_Logo.svg.png" alt="" width="55" height="55">
          </div>
          <div>
            <img src="https://image.rocketpunch.com/company/5466/naver_logo.png?s=400x400&t=inside" alt="" width="55" height="55">
          </div>
          <div style="display: flex; margin-right: 50px;">
            <img src="https://blog.kakaocdn.net/dn/Sq4OD/btqzlkr13eD/dYwFnscXEA6YIOHckdPDDk/img.jpg" alt="" width="55" height="55">
          </div>
          
          <!-- <kakaoLogin :component="component" />
          <GoogleLogin :component="component" /> -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Logo from '../components/Logo'
import MedalCard from '../components/MedalCard'
export default {
  components: {
    Logo,
  },
  data() {
    return {
      email: "",
      password: "",
    }
  }

}
</script>

<style scoped>
.for-sns {
  border: black 1px;
  width: 750px;
  height: 500px;
}
.background {
  height: 800px;
  background-color: rgb(255,219,89, .73);
}
.button-div {
  display: flex;
}
.button-form {
  background-color: rgb(255,219,89, .73);
  border-radius: 10px;
  border: 0;
  outline: 0;
  color: white;

}
#password, #email {
  background-color: #c8c8c8;
  border-radius: 10px;
  border: 0;
  outline: 0;
  
}
.form-wrap {
  background-color: white;
  width: 700px;
  height: 400px;
  border: 0;
  outline: 0;
  border-radius: 50px;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.user {
  display: flex;
  flex-direction: column;
  justify-content: center;
}


</style>