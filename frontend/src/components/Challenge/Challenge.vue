<template>
  <div>
    <section class="banner">
      <div
        class="container"
        data-aos="fade-up"
        data-aos-duration="1000">
        <h1>Challenge Now!</h1>
        <p>하루하루 챌린지를 완료해서 뱃지를 모아보세요!</p>
      </div>
    </section> 
    <section class="container">
      <Carousel
        :settings="settings"
        :breakpoints="breakpoints"
        class="carousel">
        <Slide
          v-for="(challenge) in challenges"
          :key="challenge.id"
          class="slide">
          <div
            class="carousel__item"
            data-aos="flip-left"
            @click="getChallengeId(challenge.id)"
            data-aos-duration="1000">
            <div
              @click="modalOnOff"
              class="challengeCard">
              <div class="challengeCard__inner">
                <h2>{{ challenge.title }}</h2>
                <br />
                <img
                  src="../../assets/fitness.png"
                  alt="fitness" />
                <!-- <div
                  type="button"
                  class="btn btn-danger btn-lg"
                  @click="toggleOnOff">
                  사진 올리기
                </div> -->
              </div>
            </div>
          </div>
        </Slide>
        <template #addons>
          <Pagination />
          <Navigation />
        </template>
      </Carousel>
      <div
        v-if="isStatusOn"
        class="test">
        <div class="card">
          <div class="card-body">
            <div class="card-title">
              <h4>
                업로드 할 사진을 첨부해주세요.
              </h4>
              <button
                type="button"
                class="btn-close"
                @click="toggleOnOff"
                aria-label="Close"></button>
            </div>
            <div class="card-content">
              <input
                class="form-control"
                type="file"
                id="formFile" />
            </div>
            <div class="card-bottom">
              <button
                class="btn btn-secondary cancel"
                @click="toggleOnOff">
                취소
              </button>
              <button class="btn btn-danger">
                확인
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>
    <transition name="slide-fade">
      <section
        class="detail"
        v-if="cModal">
        <ChallengeModal @close="modalOnOff" />
      </section>
    </transition>
  </div>
</template>

<script>
import ChallengeModal from './ChallengeModal.vue'
import { defineComponent } from 'vue';
import { mapState, mapActions } from 'vuex'
import { Carousel, Navigation, Slide, Pagination } from 'vue3-carousel';
import 'vue3-carousel/dist/carousel.css';
import AOS from 'aos'


export default defineComponent({
  beforeCreate() {
    this.$store.dispatch('challenge/getChallenge')
  },
  created() {
    AOS.init()
  },
  components: {
    Pagination,
    Carousel,
    Slide,
    Navigation,
    ChallengeModal
  },
  data: () => ({
    // carousel settings
    slides: 10,
    isStatusOn: false,
    activeItem: null,
    cModal: false,
    settings: {
      itemsToShow: 1,
      snapAlign: 'center',
    },
    // breakpoints are mobile first
    // any settings not specified will fallback to the carousel settings
    breakpoints: {
      // 700px and up
      700: {
        itemsToShow: 1,
        snapAlign: 'center',
      },
      // 1024 and up
      1024: {
        itemsToShow: 3,
        snapAlign: 'start',
      },
      // 1474: {
      //   itemsToShow: 3,
      //   snapAlign: 'start',
      // },
    },
  }),
  computed: {
    ...mapState("challenge", ["challenges"])
  },
  methods: {
    toggleOnOff() {
      this.isStatusOn = !this.isStatusOn
    },
    modalOnOff() {
      this.cModal = !this.cModal
    },
    getId(id) {
      console.log(id)
    },
    ...mapActions("challenge", ['getChallengeId'])
  }
});
</script>

<style lang="scss" scoped>
.banner {
    position: relative;
    width: 100%;
    height: 350px;
    top: 0;
    left: 0;
    background-size: cover;
    background-position: center;
    z-index: -1;
    overflow: hidden;
    background-repeat: no-repeat;
    background-image: linear-gradient(to top, rgb(0, 0, 0, 0.9), rgb(255, 255, 255, 0.1)), url('https://han.gl/F8N1I');
    h1 {
      font-family: 'Anton', sans-serif;
      color: #fff;
      text-align: center;
      font-size: 60px;
      margin-top: 140px;
      text-shadow: 1px 1px 4px #000;
    }
    p {
      font-family: 'Do Hyeon', sans-serif;
      color: rgb(228, 226, 226);
      text-align: center;
      font-size: 20px;
    }
  }
.container {
  max-width: 1000px;
  .carousel{
    // padding: 80px 100px 80px 30px;
    padding: 80px 78px 80px 30px;
    .slide {
      margin: 50px 0 50px 10px;
      .carousel__item {
        font-family: 'Do Hyeon', sans-serif;
        min-height: 400px;
        width: 250px;
        background-color: $primary;
        color: var(--carousel-color-white);
        font-size: 20px;
        border-radius: 8px;
        display: flex;
        justify-content: center;
        align-items: center;
        position: relative;
        .challengeCard {
          width: 100%;
          height: 100%;
          position: absolute;
          z-index:3;
          font-size: 20px;
          justify-content: center;
          align-content: center;
          border-radius: 8px;
          box-shadow: 0px 15px 15px rgba(10, 10, 10, 0.2);
          cursor: pointer;
          .challengeCard__inner {
            margin-top: 130px;
            img {
              width: 100px;
              height: 100px; 
            }
          }
        }
        &:hover {
          transform: scale(1.05);
          transition: 1s;
          box-shadow: 0 10px 20px rgba(0,0,0,.12), 0 4px 8px rgba(0,0,0,.06);
        }
      }
    }
  }
  .card {
    font-family: 'Do Hyeon', sans-serif;
    width: 600px;
    height: 200px;
    position: absolute;
    left: 50%;
    top: 70%;
    margin: 0 auto;
    margin-left: -250px;
    margin-top: -250px;
    box-shadow: 0 0 999px 999px rgba(255, 255, 255, 0.678);
    z-index: 500;
    .card-body {
      .card-title {
        display: flex;
        justify-content: space-between;
        align-content: center;
      }
      .card-content {
        display: flex;
        justify-content: space-around;
        align-content: center;
        margin: 30px 0;
        input {
          margin-right: 5px;
        }
      }
      .card-bottom {
        display: flex;
        justify-content: center;
        align-content: center;
        button {
          width: 100px;
          padding: 3px 10px;
        }
        .cancel {
          margin-right: 20px;
        }
      }
    }
  }
}
.detail {
  position: fixed;
  top: 20%;
  left: 25%;
  z-index: 500;
  width: 50%; height: 60%;
  background-color: rgba(189, 186, 186, 0.7);
  border-radius: 20px;
  box-shadow: 0 0 999px 999px rgba(189, 186, 186, 0.7);
  &.slide-fade-enter-active {
    transition: all .5s ease-out;
  }
  &.slide-fade-leave-active {
    transition: all 0.3s translateY(-20px);;
  }
  &.slide-fade-enter-from,
  .slide-fade-leave-to {
    transform: translateY(20px);
    opacity: 0;
  }
}
</style>