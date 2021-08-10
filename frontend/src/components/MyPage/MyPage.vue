<template>
  <div 
    v-if="isStatusOn"
    class="MYPAGE">
    <div class="mybanner">
      <h1>마이페이지</h1>
      <h4>현재 나와 비슷한 친구를 추천해 드려요!</h4>
    </div>
    <div class="mypage">
      <div class="myprofile">
        <div
          class="card mb-3 myprofilecard"
          style="max-width: 540px;">
          <div class="row g-0">
            <div class="col-md-4">
              <img
                :src="image"
                class="img-fluid rounded-start"
                :alt="name" />
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">
                  환영합니다. OOO님!
                </h5>
                <p class="card-text">
                  Point : 2000 
                </p>
                <p class="card-text">
                  <small class="text-muted">
                    관심운동 : 헬스, 축구 <br />
                    운동시작일 : 2019.7.20 <br />
                    3대 : 400 <br />
                  </small>
                </p>
              </div>
            </div>
          </div>
          <div class="mypage_footer">
            <div class="footer_top">
              <h2>
                보유 뱃지
              </h2>
              <button
                type="button"
                class="btn btn-danger push"
                @click="toChallenge">
                진행 챌린지
              </button>
              <button
                type="button"
                class="btn btn-primary"
                @click="toBadgeNow">
                뱃지 더보기
              </button>
            </div>
            <div>
              <h1>badge Image</h1>
            </div>
            <div
              class="footer_bottom">
              <button
                type="button"
                class="btn btn-secondary push"
                @click="toggleOnOff">
                프로필 수정하기
              </button>
            </div>
          </div>
        </div>
      </div>
      <div class="recommand">
        <div
          class="card mb-3 friend"
          style="max-width: 540px;">
          <div class="row g-0">
            <div class="col-md-4">
              <img
                src="http://file3.instiz.net/data/cached_img/upload/2019/05/17/12/992918c07b9c5b40d1ddd0c4c801ba64.jpg"
                class="img-fluid rounded-start"
                alt="..." />
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">
                  그리즐리
                </h5>
                <p class="card-text">
                  This 
                </p>
                <p class="card-text">
                  <small class="text-muted">Last updated 3 mins ago</small>
                </p>
              </div>
            </div>
          </div>
        </div>
        <div
          class="card mb-3 friend"
          style="max-width: 540px;">
          <div class="row g-0">
            <div class="col-md-4">
              <img
                src="https://c11.kr/qofs"
                class="img-fluid rounded-start"
                alt="..." />
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">
                  판다
                </h5>
                <p class="card-text">
                  This 
                </p>
                <p class="card-text">
                  <small class="text-muted">Last updated 3 mins ago</small>
                </p>
              </div>
            </div>
          </div>
        </div>
        <div
          class="card mb-3 friend"
          style="max-width: 540px;">
          <div class="row g-0">
            <div class="col-md-4">
              <img
                src="https://c11.kr/qofu"
                class="img-fluid rounded-start"
                alt="..." />
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">
                  아이스베어
                </h5>
                <p class="card-text">
                  This 
                </p>
                <p class="card-text">
                  <small class="text-muted">Last updated 3 mins ago</small>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div
    class="MYPAGE_UPDATE"
    v-else>
    <UpdateProfile @toggleOnOff="toggleOnOff" />
    <div class="mypage_btn">
      <button
        type="button"
        class="btn btn-secondary push"
        @click="toggleOnOff">
        <h5>
          Mypage로 이동
        </h5>
      </button>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import UpdateProfile from './UpdateProfile'

export default {
  name: 'MyPage',
  data () {
    return {
      isStatusOn: true
    }
  },
  components: {
    UpdateProfile
  },
  computed: {
    ...mapState('profile', [ // vuex helper
      'image',
      'name'
    ])
  },
  methods: {
    toChallenge() {
      this.$router.push('/challenge')
    },
    toBadgeNow() {
      this.$router.push('/medal')
    },
    toggleOnOff() {
      this.isStatusOn = !this.isStatusOn
    }
  }
}
</script>

<style lang="scss" scoped>
.MYPAGE {
  font-family: 'Do Hyeon', sans-serif;
  width: 100%;
  height: 100%;
  z-index: 1;
  position: relative;
  padding: 60px 0;
  ::after {
    width: 100%;
    height: 100%;
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    z-index: -1;
    background: url('https://url.kr/na8mq2') no-repeat center center fixed;
    background-size: cover;
    opacity: 0.2;
  }
  .mybanner {
    text-align: center;
    color: #333;
    margin-top: 80px;
    h4 {
      color: #333;
      margin-bottom: 0;
    }
  }
  .mypage {
    height: 500px;
    display: flex;
    justify-content: space-around;
    padding-top: 50px;
    margin-bottom: 100px;
    .myprofile {
      position: relative;
      .myprofilecard{
        width: 500px;
        height: 456px;
        margin-left: 150px;
        padding: 30px;
        .card-body {
          padding: 20px 60px;
        }
        img {
          width: 200px;
          height: 200px;
          max-width: 130%;
        }
        .mypage_footer {
          height: 200px;
          hr {
            margin-top: 0;
          }
          .footer_top {
            border-bottom: solid rgb(109, 109, 109);
            display: flex;
            h2 {
              margin: 0;
              padding-top: 12px;
              padding-left: 10px;
            }
            .btn {
              margin: 10px;
              width: 80px;
              font-size: 0.9rem;
              padding: 3px;
            }
            .push {
              margin-left: auto;
            }
          }
          .footer_bottom {
            display: flex;
            .push {
              margin-left: auto;
            }
            .btn {
              font-size: 0.9rem;
              padding: 3px;
            }
          }
        }
      }
    }
    .recommand {
      .friend {
        height: 140px;
        width: 500px;
        margin-right: 150px;
        img {
          padding: 10px 10px 26px 10px;
          width: 150px;
          height: 150px;
        }
      }
    }
  }
}
.MYPAGE_UPDATE {
  font-family: 'Do Hyeon', sans-serif;
  .mypage_btn {
    display: none;
    button {
      width: 450px;
      margin: 40px auto;
      h5 {
        margin-bottom: 0;
      }
    }
  }
}
</style>