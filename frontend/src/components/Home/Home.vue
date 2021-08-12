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
          src="../../assets/popup.png"
          alt="Popup" />
      </div>
    </div>
  </div>
</template>

<script>
import AOS from 'aos'
import HomeBanner from './HomeBanner'
import HomeMain from './HomeMain'
import HomeYoutube from './HomeYoutube'
import HomeChallenge from './HomeChallenge'
import HomeArticle from './HomeArticle'

export default {
  created() {
    AOS.init()
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
  }
}
</script>

<style lang="scss" scoped>
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
    img {
      width: 140px;
      height: 230px;
      border-radius: 30px;
    }
  }
}
</style>