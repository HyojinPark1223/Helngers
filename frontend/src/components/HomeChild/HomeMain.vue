<template>
  <div>
    <section
      class="introMain">
      <div
        class="container"
        data-aos="fade-up"
        data-aos-duration="1500">
        <div class="mainExplain">
          <div
            class="col-md-10">
            <h3 class="mb-4">
              하루하루 운동을 기록하고, 나와 비슷한 친구와 함께 성장해요!
            </h3>
            <P>서로 응원하고 같이하면 어느새 목표치 달성!</P>
          </div>
        </div>
        <div
          class="mainCard"
          data-aos="flip-up"
          data-aos-duration="1000">
          <div class="rating-wrap">
            <div
              class="content"
              v-for="content in contents"
              :key="content.name"
              @click="toMain">
              <div
                class="card"
                @click="detailOnOff">
                <img
                  :src="content.image"
                  class="card-img-top"
                  alt="..." />
                <div class="card-body">
                  <h5 class="card-title">
                    {{ content.title }}
                  </h5>
                  <p class="card-text">
                    {{ content.context }}
                  </p>
                </div>
                <div class="sub-bottom">
                  <p>{{ content.time }}</p>
                </div>
                <div class="card-body bottom">
                  <img
                    src="../../assets/profile.png"
                    alt="profile" />
                  <h6>
                    {{ content.user }}
                  </h6>
                  <img
                    class="push"
                    src="../../assets/heart.png"
                    alt="heart" />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import AOS from 'aos'
export default {
  created() {
    AOS.init()
  },
  data() {
      return {
        contents: [
          {
            name: 1,
            title: '오늘도 등 운동 하는날!',
            context: 'Gym종국이 형처럼 이번 여름은 나도 멋진 등신이 될거야!',
            time: '2021. 7월 21일 / 10개의 댓글',
            user: '나는 등신이다, 김싸피 님',
            image: 'https://url.kr/jekuoa'
          },
          {
            name: 2,
            title: '요가 10일차~!',
            context: '취미로 시작한 요가가 어느새 제 인생 운동이 되었어요!!',
            time: '2021. 7월 23일 / 14개의 댓글',
            user: '요가 파이아, 박싸피 님',
            image: 'https://url.kr/vbdfwq'
          },
          {
            name: 3,
            title: '다이어트 2주차',
            context: '코어 운동을 기반으로 시작한 다이어트 2주차! 10kg감량 가즈아!',
            time: '2021. 7월 26일 / 6개의 댓글',
            user: '코어는 국력, 정싸피 님',
            image: 'https://url.kr/a3c6ne'
          }
        ]
      }
    },
    methods: {
      toMain() {
        this.$router.push('/main')
      }
    }
}
</script>

<style lang="scss" scoped>
.introMain {
  font-family: 'Noto Serif KR', serif;
  text-align: center;
  background-color: #fff;
  position: relative;
  padding: 7.5rem 0;
  outline: 0;
  .container {
    z-index: 1;
    position: relative;
    .mainExplain {
      justify-content: center;
      display: flex;
      flex-wrap: wrap;
      margin: 0 -15px;
      outline: 0;
      .col-md-10 {
        flex: 0 0 83.3333%;
        max-width: 83.3333%;
        h3 {
          font-weight: bolder;
        }
        .mb-4 {
          margin-bottom: 1.8rem;
        }
      }
    }
    .mainCard {
      display: flex;
      justify-content: center;
      flex-wrap: wrap;
      margin: 0 -15px;
      margin-top: 4rem;
      outline: 0;
      font-family: 'Do Hyeon', serif;
      .rating-wrap {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        .content {
          display: flex;
          justify-content: space-between;
          align-content: center;
          margin: 0 30px 50px 30px;
          .card {
            border-radius: 15px;
            height: 250px * 3 / 2;
            width: 250px;
            border: none;
            box-shadow: 2px 2px 5px 3px rgba(189, 186, 186, 0.5);
            cursor: pointer;
            &:hover {
              transform: scale(1.05);
              transition: 1s;
              box-shadow: 0 10px 20px rgba(0,0,0,.12), 0 4px 8px rgba(0,0,0,.06);
            }
            .card-body {
              background-color: rgba($color: #e9e9e9, $alpha: .2);
              text-align: left;
              h6 {
                height: 25px;
                margin: 5px 0 0 10px;
              }
              img {
                width: 25px;
                height: 25px;
                cursor: pointer;
              }
              .push {
              margin-left: auto;
              }
              
            }
            .sub-bottom {
                background-color: rgba($color: #e9e9e9, $alpha: .1);
                margin: 0 0 10px 15px;
                text-align: left;
                p {
                  margin: 0;
                  font-size: 12px;
                  color: #919191;
                }
              }
            .bottom {
              border-top: solid rgba($color: #919191, $alpha: .2);
              max-height: 40px;
              display: flex;
              padding: 8px 13px;
              h6 {
                font-size: 14px;
                margin: 3px 0 0 10px;
              }
              img {
                width: 20px;
                height: 20px;
              }
            }
          }
        }
      }
    }
  }
}
</style>