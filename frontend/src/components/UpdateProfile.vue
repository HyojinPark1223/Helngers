<template>
  <div class="update">
    <h2>회원정보 수정</h2>
    <div class="updateform">
      <div
        class="card">
        <div class="card-body">
          <form>
            <div class="mb-3">
              <label
                for="exampleInputEmail1"
                class="form-label">이름</label>
              <input
                type="email"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp" />
            </div>
            <div class="mb-3">
              <label
                for="exampleInputPassword1"
                class="form-label">아이디</label>
              <input
                type="password"
                class="form-control"
                id="exampleInputPassword1" />
            </div>
            <div class="mb-3">
              <label
                for="exampleInputPassword1"
                class="form-label">비밀번호</label>
              <input
                type="password"
                class="form-control"
                id="exampleInputPassword1" />
            </div>
            <div class="mb-3">
              <label
                for="exampleInputPassword1"
                class="form-label">관심운동</label>
              <input
                type="password"
                class="form-control"
                id="exampleInputPassword1" />
            </div>
            <div class="mb-3">
              <label
                for="exampleInputPassword1"
                class="form-label">3대</label>
              <input
                type="password"
                class="form-control"
                id="exampleInputPassword1" />
            </div>
            <div class="mb-3">
              <label
                for="exampleInputPassword1"
                class="form-label">운동 시작날짜</label>
              <Datepicker
                class="datepicker"
                v-model="picked" />
            </div>
            <div class="submit_button">
              <button
                type="submit"
                class="btn btn-primary">
                <h4>수정하기</h4>
              </button>
              <button
                type="submit"
                class="btn btn-secondary"
                @click="toggleOnOff">
                <h4>MyPage</h4>
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Datepicker from 'vue3-datepicker'
import { ref } from 'vue'
const picked = ref(new Date())
export default {
  name: 'UpdateProfile',
  components: {
    Datepicker
  },
  data() {
    return {
      picked,
    }
  },
  methods: {
    toggleOnOff() {
      this.$emit('toggleOnOff');
    }
  }
}
</script>

<style lang="scss" scoped>
.update {
  font-family: 'Do Hyeon', sans-serif;
  z-index: 1;
  position: relative;
    &::before {
      width: 100%;
      height: 100%;
      content: "";
      position: absolute;
      top: 0;
      left: 0;
      z-index: -10;
      background: url('https://url.kr/na8mq2') no-repeat center center fixed;
      background-size: cover;
      opacity: 0.2;
    }
  h2 {
    padding: 50px 0;
    text-align: center;
  }
  .updateform {
    margin: 0 auto;
    padding: 0 0 80px 0;
    min-width: 460px;
    .card {
      width: 460px;
      margin: 0 auto;
      .card-body {
        .datepicker {
        }
        .submit_button {
          display: flex;
          .btn {
            margin: 15px 15px;
            padding: 5px 20px;
            width: 450px;
          }
          h4 {
            margin-bottom: 0;
          }
        }
      }
    }
  }
}
</style>