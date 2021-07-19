<template>
  <div class="user" id="login">
    <div class="form-wrap">
      <h3>Login</h3>
      <div class="input-with-label">
        <label for="email">email</label>
        <br>
        <input v-model="email" id="email" placeholder="이메일을 입력하세요" type="text" />
        <div clss="error-text"></div>
      </div>
      <br>
      <div class="input-with-label">
        <label for="password">비밀번호</label>
        <br>
        <input v-model="password" id="password" placeholder="비밀번호를 입력하세요" type="password" />
        <div clss="error-text"></div>
      </div>
      <br>
      <button type="button">
        로그인
      </button>

      <div class="sns-login">
        <div class="text">
          <p>SNS 간편 로그인</p>
          <div class="bar"></div>
        </div>
        <div>
          <img src="https://pbs.twimg.com/profile_images/770139154898382848/ndFg-IDH.jpg" alt="" width="55" height="55">
          <img src="https://image.rocketpunch.com/company/5466/naver_logo.png?s=400x400&t=inside" alt="" width="55" height="55">
          <img src="https://blog.kakaocdn.net/dn/Sq4OD/btqzlkr13eD/dYwFnscXEA6YIOHckdPDDk/img.jpg" alt="" width="55" height="55">
        </div>
        <!-- <kakaoLogin :component="component" />
        <GoogleLogin :component="component" /> -->
      </div>

      <div class="add-option">
        <div class="wrap">
          <p>비밀번호를 잊으셨나요?</p>
        </div>
        <div class="wrap">
          <p>아직 회원이 아니신가요?</p>
          <router-link to="/user/signup" class="btn--text">가입하기</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: "",
      password: "",
    }
  }

}
</script>

<style scoped>
.form-wrap {
  width: 700px;
  height: 500px;
  border: 1px solid black;
  border-radius: 50px;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.user {
  display: flex;
  justify-content: center;
  /* text-align: center; */
}


</style>