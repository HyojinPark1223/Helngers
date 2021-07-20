<template>
  <div class="user" id="signup">
    <div class="form-wrap">
      <h3>Signup</h3>
      <div class="input-with-label">
        <label for="username">아이디:  </label>
        <input v-model="username" id="email" placeholder="아이디를 입력하세요" type="text" />
        <div clss="error-text"></div>
      </div>
      <br>
      <div class="input-with-label">
        <label for="nickname">닉네임:</label>
        <input v-model="nickname" id="email" placeholder="닉네임을 입력하세요" type="text" />
        <div clss="error-text"></div>
      </div>
      <br>
      <div class="input-with-label">
        <label for="email">email:</label>
        <input v-model="email" id="email" placeholder="이메일을 입력하세요" type="text" />
        <div clss="error-text"></div>
      </div>
      <br>
      <div class="input-with-label">
        <label for="password">비밀번호</label>
        <input v-model="password" id="password" placeholder="비밀번호를 입력하세요" type="password" />
        <div clss="error-text"></div>
      </div>
      <div class="input-with-label">
        <label for="passwordchk">비밀번호 확인</label>
        <input v-model="passwordchk" id="passwordchk" placeholder="비밀번호를 입력하세요" type="password" />
        <div clss="error-text"></div>
      </div>
      <br>
      <button type="button">
        회원가입
      </button>

      <div class="sns-login">
        <div class="text">
          <p>SNS 간편 회원가입</p>
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
    </div>
  </div>
</template>

<script>
export default {
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
}


</style>