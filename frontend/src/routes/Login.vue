<template>
  <div class="background">
    <div class="user" id="login">
      <div class="form-wrap">
        <Logo />
        <br>
        <div class="input-with-label">
          <label for="email" style="margin-right: 20px;">이메일</label>
        
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
    </div>
    <div class="sns-login">

      <div>
        <img src="https://pbs.twimg.com/profile_images/770139154898382848/ndFg-IDH.jpg" alt="" width="55" height="55">
        <img src="https://image.rocketpunch.com/company/5466/naver_logo.png?s=400x400&t=inside" alt="" width="55" height="55">
        <img src="https://blog.kakaocdn.net/dn/Sq4OD/btqzlkr13eD/dYwFnscXEA6YIOHckdPDDk/img.jpg" alt="" width="55" height="55">
      </div>
      <!-- <kakaoLogin :component="component" />
      <GoogleLogin :component="component" /> -->
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
  }

}
</script>

<style scoped>
.background {
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
  width: 500px;
  height: 300px;
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
  justify-content: center;
}


</style>