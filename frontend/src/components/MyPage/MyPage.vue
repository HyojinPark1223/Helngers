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
                src="../../assets/hello.jpg"
                class="img-fluid rounded-start"
                :alt="name" />
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <div class="card-title">
                  <h5>환영합니다. &nbsp;</h5>
                  <h5 v-if="userInfo">
                    {{ userInfo.nickname }} 님!
                  </h5>
                  <h5 v-if="userInfo === null">
                    OOO 님!
                  </h5>
                </div>
                <p class="card-text">
                  My Point : {{ userInfo.point }}
                </p>
                <p class="card-text">
                  <small class="text-muted">
                    소개 : <br />
                  </small>
                  <small class="text-muted">
                    {{ userInfo.introduce }}
                  </small>
                </p>
              </div>
            </div>
          </div>
          <div class="mypage_footer">
            <div class="footer_top">
            </div>
            <div
              class="footer_bottom">
              <button
                type="button"
                class="btn btn-danger"
                @click="toChallenge">
                챌린지
              </button>
              <button
                type="button"
                class="btn btn-primary"
                style="color: #fff"
                @click="toBadgeNow">
                메달
              </button>
              <button
                type="button"
                class="btn btn-secondary"
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
                  보유 메달 : 하체 마스터, 등 마스터, 헬스장 개근상
                </p>
                <p class="card-text">
                  <small class="text-muted">운동시작일 : 2020.06.24</small>
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
                  보유 메달 : 최고의 다이어터, 런닝 마스터
                </p>
                <p class="card-text">
                  <small class="text-muted">운동시작일 : 2021.02.14</small>
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
                  보유메달 : 벤치 프레스 마스터, 턱걸이 왕
                </p>
                <p class="card-text">
                  <small class="text-muted">운동시작일 : 2021.01.24</small>
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
    ]),
    ...mapState("user", ["userInfo"])
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
      color: #fff;
      text-shadow: #333 1px 0 10px;;
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
        margin-left: 200px;
        padding: 100px 30px 0 30px;
        .card-body {
          padding: 20px 60px;
          .card-title {
            display: flex;
          }
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
            justify-content: center;
            align-content: center;
            margin-top: 20px;
            .btn {
              font-size: 0.9rem;
              padding: 3px;
              margin: 10px;
              min-width: 100px;
            }
          }
        }
      }
    }
    .recommand {
      .friend {
        height: 140px;
        width: 500px;
        margin-right: 200px;
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