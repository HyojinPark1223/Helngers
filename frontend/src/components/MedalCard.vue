<template>
  <div>
    <div v-if="modalChk">
      <MedalModal />
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
          <div class="carousel__item">
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
        class="carousel">
        <Slide
          v-for="slide in slides"
          :key="slide"
          class="slide">
          <div class="carousel__item">
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
        class="carousel">
        <Slide
          v-for="slide in slides"
          :key="slide"
          class="slide">
          <div class="carousel__item">
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
import MedalModal from './MedalModal'
import { Carousel, Navigation, Slide } from 'vue3-carousel';

export default {
	name: 'MedalCard',
	components: {
		MedalModal,
    Carousel,
    Slide,
    Navigation,
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
          itemsToShow: 4,
          snapAlign: 'center',
        },
        // 1024 and up
        1024: {
          itemsToShow: 5,
          snapAlign: 'start',
        },
        1474: {
          itemsToShow: 6,
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
}
</script>
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
    margin: 20px 10px 40px;
    display: block;
    .carousel__item {
      font-family: 'Do Hyeon', sans-serif;
      height: 100px;
      width: 100px;
      border-radius: 50%;
      background-color: $primary;
      color: var(--carousel-color-white);
      display: flex;
      justify-content: center;
      align-items: center;
      margin: 0 10px;
      position: relative;
    }
    .progress {
      width: 70px;
      margin: 20px 0 20px 27px;
    }
  }
}
</style>