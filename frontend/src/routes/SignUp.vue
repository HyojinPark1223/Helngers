<template>
  <div class="background">
    <div class="user" id="signup">
      <div class="form-wrap" style="margin-top: 5%; margin-left: 5%">
        <Logo />
        <br>
        <div class="input-with-label">
          <label for="username" style="padding: 0 3em 0 0;">아이디 :  </label>
          <input v-model="username" id="username" placeholder="아이디를 입력하세요" type="text" />
          <div clss="error-text"></div>
        </div>
        <br>
        <div class="input-with-label">
          <label for="nickname" style="padding: 0 3em 0 0;">닉네임 :</label>
          <input v-model="nickname" id="nickname" placeholder="닉네임을 입력하세요" type="text" />
          <div clss="error-text"></div>
        </div>
        <br>
        <div class="input-with-label">
          <label for="email" style="padding: 0 3em 0 0;">email :</label>
          <input v-model="email" id="email" placeholder="이메일을 입력하세요" type="text" style="margin-left: 12px;"/>
          <div clss="error-text"></div>
        </div>
        <br>
        <div class="input-with-label">
          <label for="password" style="padding: 0 2em 0 0;">비밀번호 : </label>
          <input v-model="password" id="password" placeholder="비밀번호를 입력하세요" type="password"/>
          <div clss="error-text"></div>
        </div>
        <br>
        <div class="input-with-label">
          <label for="passwordchk" style="margin-left:0;">비밀번호확인 :</label>
          <input v-model="passwordchk" id="passwordchk" placeholder="비밀번호를 입력하세요" type="password" />
          <div clss="error-text"></div>
        </div>
        <br>
        <button type="button" class="button-form">
          회원가입
        </button>

        <div class="sns-login">
          <div class="text">
            <p>SNS 간편 회원가입</p>
            <div class="bar"></div>
          </div>
          <div>
            <img style="margin-right: 5px;" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/600px-Google_%22G%22_Logo.svg.png" alt="" width="40" height="40">

            <img style="margin-right: 8px;" src="https://image.rocketpunch.com/company/5466/naver_logo.png?s=400x400&t=inside" alt="" width="40" height="40">
            <img src="https://blog.kakaocdn.net/dn/Sq4OD/btqzlkr13eD/dYwFnscXEA6YIOHckdPDDk/img.jpg" alt="" width="40" height="40">
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
export default {
  components: {
    Logo,
  },
  data() {
    return {
      username: "",
      nickname: "",
      email: "",
      password: "",
      passwordchk: "",
    }
  }

}
</script>

<style scoped>

.background {
  height: 800px;
  background-color: rgb(255,219,89, .73);
}

#password, #email, #username, #nickname, #passwordchk {
  background-color: #c8c8c8;
  border-radius: 10px;
  border: 0;
  outline: 0;
  
  margin-left: 5px;
}
.form-wrap {
  background-color: white;
  width: 700px;
  height: 500px;
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
.button-form {
  background-color: rgb(255,219,89, .73);
  border-radius: 10px;
  border: 0;
  outline: 0;
  color: white;

}



</style>