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
  </div>
</template>

<script>
import HomeBanner from './HomeBanner'
import HomeMain from './HomeMain'
import HomeYoutube from './HomeYoutube'
import HomeChallenge from './HomeChallenge'
import HomeArticle from './HomeArticle'

export default {
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
</style>