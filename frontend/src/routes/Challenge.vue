<template>
  <div class="container">
    <Carousel
      :settings="settings"
      :breakpoints="breakpoints"
      class="carousel">
      <Slide
        v-for="slide in slides"
        :key="slide"
        class="slide">
        <div class="carousel__item">
          <div class="front">
            <div class="front__inner">
              <h2>오늘의 챌린지!</h2>
              <br />
              <img
                src="../assets/fitness.png"
                alt="fitness" />
            </div>
          </div>
          <div class="back">
            <div class="back__inner">
              <h2>챌린지 설명</h2>
              <p>어쩌구 저쩌구</p>
              <div
                type="button"
                class="btn btn-danger btn-lg"
                @click="toggleOnOff">
                사진 올리기
              </div>
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
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import { Carousel, Navigation, Slide, Pagination } from 'vue3-carousel';
import 'vue3-carousel/dist/carousel.css';


export default defineComponent({
  components: {
    Pagination,
    Carousel,
    Slide,
    Navigation,

  },
  data: () => ({
    // carousel settings
    slides: 10,
    isStatusOn: false,
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
        itemsToShow: 2,
        snapAlign: 'start',
      },
      1474: {
        itemsToShow: 3,
        snapAlign: 'start',
      },
    },
  }),
  methods: {
    toggleOnOff() {
      this.isStatusOn = !this.isStatusOn
    }
  }
});
</script>

<style lang="scss" scoped>
@mixin backface-visibility($visibility: hidden) {
  backface-visibility: $visibility;
  -webkit-backface-visibility: $visibility;
  -moz-backface-visibility: $visibility;
  -ms-backface-visibility: $visibility;
  -o-backface-visibility: $visibility;
}

@mixin transition($time){
  transition: $time;
  -webkit-transition: $time;
  -moz-transition: $time;
  -o-transition: $time;
}

@mixin transform($transformation) {
  transform: $transformation;
  -webkit-transform: $transformation;
  -moz-transform: $transformation;
  -ms-transform: $transformation;
  -o-transform: $transformation;  
}

@mixin transform-style($style){
   transform-style: $style;
  -moz-transform-style: $style;
  -o-transform-style: $style;
  -ms-transform-style: $style;
  -webkit-transform-style: $style;
}
.carousel{
  // padding: 80px 100px 80px 30px;
  padding: 80px 78px 80px 30px;
  margin-top: 100px;
  .slide {
    margin: 50px 10px;
    .carousel__item {
      font-family: 'Do Hyeon', sans-serif;
      min-height: 400px;
      width: 300px;
      background-color: $primary;
      color: var(--carousel-color-white);
      font-size: 20px;
      border-radius: 8px;
      display: flex;
      justify-content: center;
      align-items: center;
      margin: 0 10px;
      position: relative;
      &:hover {
        @include transform(rotatey(-180deg));
      }
      @include transform-style(preserve-3d);
      @include transition(1s);

      .front, .back {
        width: 100%;
        height: 100%;
        position: absolute;
        @include backface-visibility;
      }

      .front {
        z-index:3;
        font-size: 20px;
        justify-content: center;
        align-content: center;
        border-radius: 8px;
        box-shadow: 0px 15px 15px rgba(10, 10, 10, 0.2);
        .front__inner {
          margin-top: 130px;
          img {
            width: 100px;
            height: 100px; 
          }
        }
      }
      .back {
        z-index: 1;
        background-color: $warning;
        box-shadow: 0px 20px 20px rgba(10, 10, 10, 0.2);
        top: -10px;
        right: -10px;
        border-radius: 8px;
        justify-content: center;
        align-content: center;
        .back__inner {
          margin-top: 130px
        }
        @include transform(rotatey(-180deg));
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
</style>