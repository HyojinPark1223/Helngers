<template>
  <div class="home">
    <HomeBanner />
    <HomeMain />
    <HomeYoutube />
    <HomeChallenge />
    <HomeArticle />
    <div id="to-top">
      <div
        class="material-icons"
        @click="toTop">
        arrow_upward
      </div>
    </div>
    <div class="popups">
      <div
        class="popup"
        data-aos="fade-left"
        data-aos-duration="1000">
        <img
          class="img1"
          @click="toMain"
          src="../../assets/popup.png"
          alt="Popup" />
      </div>
      <div
        class="popup popup2"
        data-aos="fade-left"
        data-aos-duration="1000">
        <img
          class="img2"
          @click="toChallenge"
          src="../../assets/popup2.jpg"
          alt="Popup" />
      </div>
    </div>
  </div>
</template>

<script>
import AOS from 'aos'
import gsap from 'gsap'
import _ from 'lodash'

import HomeBanner from './HomeBanner'
import HomeMain from './HomeMain'
import HomeYoutube from './HomeYoutube'
import HomeChallenge from './HomeChallenge'
import HomeArticle from './HomeArticle'

export default {
  created() {
    AOS.init()
    window.addEventListener('scroll', _.throttle(function () {
      if (window.scrollY > 700) {
        gsap.to(".popups", .6, {
          opacity: 0,
          display: 'none'
        })
        gsap.to("#to-top", .2, {
          x:0
        })
      } else {
        gsap.to(".popups", .6, {
        opacity: 1,
        display: 'block'
        })
        gsap.to("#to-top", .2, {
          x:100
        })
      }
    }, 300))
  },
  mounted() {

  },
  components: {
    HomeBanner,
    HomeMain,
    HomeYoutube,
    HomeChallenge,
    HomeArticle
  },
  methods: {
    toTop() {
      window.scrollTo(0,0)
    },
    toMain() {
      this.$router.push('/main')
    },
    toChallenge() {
      this.$router.push('/challenge')
    }
  }
}
</script>

<style lang="scss" scoped>
@include media-breakpoint-down(md) {
  .popups {
    display: none;
  }
}
#to-top {
  position: fixed;
  bottom:30px;
  right: 30px;
  z-index: 9;
  width: 42px;
  height: 42px;
  background-color: #333;
  color: #fff;
  border: 2px solid #fff;
  border-radius: 10px;
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
}
.popups {
  position: fixed;
  top: 100px;
  right: 12px;
  z-index: 100;
  .popup {
    border-radius: 30px;
    margin-bottom: 12px;
    box-shadow: 4px 4px 10px rgba(0,0,0,.15);
    cursor: pointer;
    .img1 {
      width: 140px;
      height: 220px;
      border-radius: 30px;
    }
    .img2 {
      width: 140px;
      height: 140px;
      border-radius: 30px;
    }
  }
}
</style>