<template>
  <div>
    <section class="youtube">
      <div class="youtube__area">
        <div id="player">
          <YouTube
            style="width: 100%;height: 100%;position: relative;"
            src="https://youtube.com/H-AcDBLqxi4?t=7&autoplay=1&mute=1"
            @ready="onReady"
            ref="youtube" />
        </div>
      </div>
      <div
        class="youtube__cover">
        <div
          data-aos="zoom-in"
          data-aos-duration="1000">
          <h1>여러분의 운동을 <span>Helngers</span>가 응원합니다!</h1>
          <p>Helngers are rooting for your exercise!</p>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import AOS from 'aos'
import { defineComponent } from 'vue'
import YouTube from 'vue3-youtube'

export default defineComponent( {
  created() {
    AOS.init()
  },
  components: { YouTube },
  methods: {
    onReady() {
      this.$refs.youtube.playVideo()
    },
  } 
})
</script>

<style lang="scss" scoped>
.youtube {
  position: relative;
  height: 500px;
  background-color: #333;
  overflow: hidden;
  .youtube__area {
    width: 1920px;
    position: absolute;
    /*16비율 */
    left: 50%;
    margin-left: calc(1920px / -2);
    /*9비율 */
    top: 50%;
    margin-top: calc(1920px * 9 / 16 / -2);
    &::before {
      content: "";
      display: block;
      width: 100%;
      height: 0;
      padding-top: 56.25%;
    }
    #player {
      width: 100%;
      height: 100%;
      position: absolute;
      top: 0;
      left: 0;
    }
  }
  .youtube__cover {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, .3);
    background-image : url("../assets/video_cover_pattern.png");
    text-align: center;
    h1 {
      margin-top: 200px;
      font-family: 'Do Hyeon', sans-serif;
      color: #fff;
      font-size: 4rem;
      span {
        color: orange;
      }
    }
    p {
      font-family: 'Do Hyeon', sans-serif;
      color: #fff;
      font-size: 1rem;
    }
  }
}
</style>