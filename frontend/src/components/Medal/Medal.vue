<template>
  <div>
    <section class="banner">
      <div
        class="container"
        data-aos="fade-up"
        data-aos-duration="1000">
        <h1>Badge Now!</h1>
        <p>운동을 하면서 쌓여 가는 빛나는 뱃지들!</p>
      </div>
    </section>
    <section class="container">
      <MedalCard />
    </section>
  </div>
</template>

<script>
import AOS from 'aos'
import MedalCard from './MedalCard'
export default {
  components: {
    MedalCard,
  },
  async created() {
    AOS.init()
  }
}
</script>

<style lang="scss" scoped>
.banner {
  position: relative;
  width: 100%;
  height: 350px;
  top: 0;
  left: 0;
  background-size: cover;
  background-position: center;
  z-index: -1;
  overflow: hidden;
  background-repeat: no-repeat;
  background-image: linear-gradient(to top, rgb(0, 0, 0, 0.9), rgb(255, 255, 255, 0.1)), url('https://han.gl/qEvNm');
  h1 {
    font-family: 'Anton', sans-serif;
    color: #fff;
    text-align: center;
    font-size: 60px;
    margin-top: 140px;
    text-shadow: 1px 1px 4px #000;
  }
  p {
    font-family: 'Do Hyeon', sans-serif;
    color: rgb(228, 226, 226);
    text-align: center;
    font-size: 20px;
  }
}
.container {
  font-family: 'Do Hyeon', sans-serif;
  width: 70%;
  min-height: 700px;
  margin-top: 60px;
}

</style>