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
              <button
                type="button"
                class="btn btn-danger btn-lg">
                사진 올리기
              </button>
            </div>
          </div>
        </div>
      </Slide>
      <template #addons>
        <Pagination />
        <Navigation />
      </template>
    </Carousel>
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
  padding: 80px 30px;
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
        box-shadow: 0px 30px 30px rgba(10, 10, 10, 0.2);
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
</style>