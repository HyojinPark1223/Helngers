<template>
  <div>
    <div v-if="modalChk">
      <MedalModal @close="showModal" />
    </div>
    <section>
      <div class="header">
        <span class="material-icons">
          face
        </span>
        <h3>헬린이</h3>
      </div>
      <Carousel
        :settings="settings"
        :breakpoints="breakpoints"
        class="carousel">
        <Slide
          v-for="slide in slides"
          :key="slide"
          class="slide">
          <div
            class="carousel__item"
            @click="showModal"
            data-aos="flip-left"
            data-aos-duration="1000">
            {{ slide }}
          </div>
          <div class="progress">
            <div
              class="progress-bar"
              role="progressbar"
              style="width: 50%;"
              aria-valuenow="50"
              aria-valuemin="0"
              aria-valuemax="100">
              50%
            </div>
          </div>
        </Slide>
        <template #addons>
          <Navigation />
        </template>
      </Carousel>
    </section>
    <section>
      <div class="header">
        <span class="material-icons">
          directions_run
        </span>
        <h3>헬고딩</h3>
      </div>
      <Carousel
        :settings="settings"
        :breakpoints="breakpoints"
        @click="showModal"
        class="carousel">
        <Slide
          v-for="slide in slides"
          :key="slide"
          class="slide">
          <div
            class="carousel__item"
            data-aos="flip-left"
            data-aos-duration="1000">
            {{ slide }}
          </div>
          <div class="progress">
            <div
              class="progress-bar"
              role="progressbar"
              style="width: 50%;"
              aria-valuenow="50"
              aria-valuemin="0"
              aria-valuemax="100">
              50%
            </div>
          </div>
        </Slide>
        <template #addons>
          <Navigation />
        </template>
      </Carousel>
    </section>
    <section>
      <div class="header">
        <span class="material-icons">
          fitness_center
        </span>
        <h3>헬창</h3>
      </div>
      <Carousel
        :settings="settings"
        :breakpoints="breakpoints"
        @click="showModal"
        class="carousel">
        <Slide
          v-for="slide in slides"
          :key="slide"
          class="slide">
          <div
            class="carousel__item"
            data-aos="flip-left"
            data-aos-duration="1000">
            {{ slide }}
          </div>
          <div class="progress">
            <div
              class="progress-bar"
              role="progressbar"
              style="width: 50%;"
              aria-valuenow="50"
              aria-valuemin="0"
              aria-valuemax="100">
              50%
            </div>
          </div>
        </Slide>
        <template #addons>
          <Navigation />
        </template>
      </Carousel>
    </section>
  </div>
</template>
<script>
import AOS from 'aos'
import MedalModal from './MedalModal';
import { defineComponent } from 'vue'
import { Carousel, Navigation, Slide } from 'vue3-carousel';

import 'vue3-carousel/dist/carousel.css';

export default defineComponent({
	name: 'Breakpoints',
	components: {
		MedalModal,
    Carousel,
    Slide,
    Navigation,
	},
  created() {
    AOS.init()
  },
	data() {
		return {
      modalChk: false,
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
          itemsToShow: 3,
          snapAlign: 'center',
        },
        // 1024 and up
        1024: {
          itemsToShow: 5,
          snapAlign: 'start',
        },
      },
		}
	},
	methods: {
		showModal() {
			this.modalChk = !this.modalChk
		}
	},
});
</script>
<style>
.carousel__prev,
.carousel__next {
  background-color: #333;
}
.carousel__pagination-button {
  background-color: rgba(51, 51, 51, 0.541);
}
.carousel__pagination-button--active {
  background-color: #333;
}

</style>
<style lang="scss" scoped>
.material-icons {
  font-size: 40px;
}
.header {
  display: flex;
  justify-content: flex-start;
  align-content: center;
  margin: 20px 0 0;
  h3 {
    margin: 5px 5px;
  }
}

.carousel{
  .slide {
    margin: 20px 0 40px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: center;
    .carousel__item {
      font-family: 'Do Hyeon', sans-serif;
      height: 120px;
      width: 120px;
      border-radius: 50%;
      background-color: $primary;
      color: var(--carousel-color-white);
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;
      &:hover {
        transform: scale(1.05);
        transition: 1s;
        background-color: rgb(221, 53, 53);
        box-shadow: 0 10px 20px rgba(0,0,0,.12), 0 4px 8px rgba(0,0,0,.06);
      }
    }
    .progress {
      width: 70px;
      margin: 20px 0 20px;
    }
  }
}
</style>