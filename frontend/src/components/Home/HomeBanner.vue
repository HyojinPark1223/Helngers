<template>
  <div class="home">
    <div
      id="carouselMyCaptions"
      class="carousel slide"
      data-bs-ride="carousel">
      <div class="carousel-indicators">
        <button
          type="button"
          data-bs-target="#carouselMyCaptions"
          data-bs-slide-to="0"
          class="active"
          aria-current="true"
          aria-label="Slide 1"></button>
        <button
          type="button"
          data-bs-target="#carouselMyCaptions"
          data-bs-slide-to="1"
          aria-label="Slide 2"></button>
        <button
          type="button"
          data-bs-target="#carouselMyCaptions"
          data-bs-slide-to="2"
          aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
        <div 
          class="carousel-item active">
          <img
            src="https://url.kr/v3gekf"
            class="d-block w-100"
            alt="main1" />
          <transition
            appear
            @before-enter="beforeEnter"
            @enter="enter"
            @after-enter="afterEnter">
            <div
              class="carousel-caption d-none d-md-block">
              <h1>Do not give up. The beginning is always the hardest.</h1>
              <p>포기하지 마세요. 시작은 언제나 힘든 법입니다.</p>
            </div>
          </transition>
        </div>
        <div class="carousel-item">
          <img
            src="https://url.kr/k2d8g4"
            class="d-block w-100"
            alt="main2" />
          <div class="carousel-caption d-none d-md-block">
            <h1>Break me down to build me up.</h1>
            <p>원하는 몸을 위해 지금의 몸을 부수자.</p>
          </div>
        </div>
        <div class="carousel-item">
          <img
            src="https://url.kr/vtyu25"
            class="d-block w-100"
            alt="main3" />
          <div class="carousel-caption d-none d-md-block">
            <h1>There is no shortcut. You have to keep plugging away.</h1>
            <p>계속 노력해야 해요. 지름길은 없어요.</p>
          </div>
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselMyCaptions"
        data-bs-slide="prev">
        <span
          class="carousel-control-prev-icon"
          aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselMyCaptions"
        data-bs-slide="next">
        <span
          class="carousel-control-next-icon"
          aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </div>
</template>

<script>
import gsap from 'gsap'

export default {
  data() {
    return {
      contents : [
        {
          url : 'https://url.kr/v3gekf',
          title : 'Do not give up. The beginning is always the hardest.',
          subTitle : '포기하지 마세요. 시작은 언제나 힘든 법입니다.'
        },
        {
          url : 'https://url.kr/v3gekf',
          title : 'Break me down to buile me up.',
          subTitle : '원하는 몸을 위해 지금의 몸을 부수자.'
        },
        {
          url : 'https://url.kr/v3gekf',
          title : 'There is no shortcut. You have to keep plugging away.',
          subTitle : '계속 노력해야 해요. 지름길은 없어요.'
        }
      ]
    }
  },
  setup() {
    const beforeEnter = (el) => {
      // console.log('before enter - set initial state')
      el.style.transform = 'translateY(-150px)'
      el.style.opacity = 0
    }
    const enter = (el, done) => {
      // console.log('starting to enter - make transition')
      gsap.to(el, {
        duration: .2,
        y : 0,
        opacity: 1,
        ease: 'Power0-in',
        onComplete: done
      })
    }
    const afterEnter = () => {
      // console.log('after enter')
    }

    return { beforeEnter, enter, afterEnter}
  }
}
</script>

<style lang="scss" scoped>
@include media-breakpoint-down(md) {
.carousel-control-prev, .carousel-control-next {
  display: none;
}
}
@include media-breakpoint-down(sm) {
.carousel-control-prev, .carousel-control-next {
  display: none;
}
}
.home {
  #carouselMyCaptions {
    width: 100%;
    max-height: 100vh;
    overflow: hidden;
    .carousel-inner {
      img {
        filter: brightness(50%)
      }
      .carousel-item.active {
        .carousel-caption {
          opacity: 1;
          transition: 1s;
          transform: translateX(0)
        }
      }
      .carousel-item{
        .carousel-caption {
          opacity: 0;
          transition: 1s;
          transform: translateX(-150px);
          height: 100%;
          display: flex;
          padding-top: 250px;
          font-family: 'Anton', sans-serif;
          text-shadow: 1px 1px 3px #000;
        }
      }
    }
    .carousel-control-prev, .carousel-control-next {
      margin: 100px 100px 0 100px;
    }
  }
}

</style>