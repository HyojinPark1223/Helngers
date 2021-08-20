<template>
  <div>
    <!-- <button @click="chkchk">
      메달 증식
    </button> -->
    <div v-if="modalChk">
      <MedalModal
        @close="close"
        :index="now_index"
        :level="medals_level" />
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
        <!-- 아니 시벌 왜 index랑 slide의 역할이 반대냐? -->
        <Slide
          v-for="(slide, index) in level_0_user_medal"
          :key="index"
          class="slide">
          <div
            class="carousel__item"
            @click="showModal_0(index)"
            data-aos="flip-left"
            data-aos-duration="1000">
            <!-- {{ slide }} -->
            <img
              :src="slide.url"
              width="100"
              height="100" />
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
          v-for="(slide, index) in level_1_user_medal"
          :key="index"
          class="slide">
          <div
            class="carousel__item"
            @click="showModal_1(index)"
            data-aos="flip-left"
            data-aos-duration="1000">
            <!-- {{ slide }} -->
            <img
              :src="slide.url"
              alt="" 
              width="100"
              height="100" />
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
          v-for="(slide, index) in level_2_user_medal"
          :key="index"
          class="slide">
          <div
            class="carousel__item"
            @click="showModal_2(index)"
            data-aos="flip-left"
            data-aos-duration="1000">
            <!-- {{ slide }} -->
            <img
              :src="slide.url"
              alt="" 
              width="100"
              height="100" />
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
// import axios from 'axios'
import MedalModal from './MedalModal'
// import medal from '@/store/medal'
// import { mapState } from "vuex" 
import { defineComponent } from 'vue'
import { Carousel, Navigation, Slide } from 'vue3-carousel'

import 'vue3-carousel/dist/carousel.css';
import { mapState } from 'vuex';

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
    console.log('created')
    console.log(this.level_0_user_medal)
    // level_0_user_medal

  },
  mounted() {
    this.$store.dispatch('medal/medalData', null, { root: true})
    this.$store.dispatch('medal/upDate', null, { root: true})
    // console.log('mounted')
    // console.log(this.level_0_user_medal)
    // for (let i of this.level_0_user_medal) {
    //   console.log('i')
    //   console.log(i.url)
    //   this.level_0_user_medal_url.push(i.url)
    // }
    // for (let i of this.level_1_user_medal) {
    //   console.log('i')
    //   console.log(i.url)
    //   this.level_1_user_medal_url.push(i.url)
    // }
    // for (let i of this.level_2_user_medal) {
    //   console.log('i')
    //   console.log(i.url)
    //   this.level_2_user_medal_url.push(i.url)
    // }

  },
  computed: {
    ...mapState('medal', ['medals_has_user_id']),
    ...mapState('medal', ['medals']),
    ...mapState('medal', ['level_0_user_medal']),
    ...mapState('medal', ['level_1_user_medal']),
    ...mapState('medal', ['level_2_user_medal']),
    // ...mapState('medal', ['level_0_user_medal_url']),
    // ...mapState('medal', ['level_1_user_medal_url']),
    // ...mapState('medal', ['level_2_user_medal_url']),
  },

	data() {
		return {
      now_index:-1,
      modalChk: false,
      slides:10,
      medals_level:-1,
      medals_id_has_user_url:[],
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
    close() {
      this.modalChk = !this.modalChk
    },
    chkchk() {
      console.log(this.level_0_user_medal)
      console.log(this.level_1_user_medal)
      console.log(this.level_2_user_medal)
      for (let i of this.level_0_user_medal) {
        console.log('i')
        console.log(i.url)
        this.level_0_user_medal_url.push(i.url)
      }
      for (let i of this.level_1_user_medal) {
        console.log('i')
        console.log(i.url)
        this.level_1_user_medal_url.push(i.url)
      }
      for (let i of this.level_2_user_medal) {
        console.log('i')
        console.log(i.url)
        this.level_2_user_medal_url.push(i.url)
      }
      console.log('url데이터')
      console.log(this.level_1_user_medal_url)
      console.log(this.level_2_user_medal_url)
      console.log(this.level_3_user_medal_url)
    },
		showModal_0(index) {
      // console.log('modal')
      // console.log(e.target)
      this.now_index = index
      this.medals_level = 0
			this.modalChk = !this.modalChk
		},
    showModal_1(index) {
      // console.log('modal')
      // console.log(e.target)
      this.now_index = index
      this.medals_level = 1
			this.modalChk = !this.modalChk
		},
    showModal_2(index) {
      // console.log('modal')
      // console.log(e.target)
      this.now_index = index
      this.medals_level = 2
			this.modalChk = !this.modalChk
		}
    
	}
})
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