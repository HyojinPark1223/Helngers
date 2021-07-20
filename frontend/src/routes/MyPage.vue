<template>
  <div 
    class="MYPAGE">
    <div class="mybanner">
      <h1>마이페이지</h1>
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
</template>

<script>
import { mapState } from 'vuex'
export default {
  computed: {
    ...mapState('profile', [ // vuex helper
      'image',
      'name'
    ])
  },
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
    background: url('https://url.kr/na8mq2');
    opacity: 0.1;
  }
  .mybanner {
    text-align: center;
    color: #333;
  }
  .mypage {
    height: 500px;
    display: flex;
    justify-content: space-around;
    margin-top: 50px;
    .myprofile {
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
</style>