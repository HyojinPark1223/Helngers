<template>
  <!-- <div class="black-bg">
    <div class="white-bg">
      <h4>물구나무</h4>
      <p>상세페이지 내용</p>
    </div>
  </div> -->
  <div class="MYBADGENOW">
    <div class="wrap">
      <div class="medal-wrap1">
        <MedalCard/>
        <MedalCard/>
        <MedalCard/>
        <MedalCard/>
      </div>
      <div class="medal-wrap1">
        <MedalCard/>
        <MedalCard/>
        <MedalCard/>
        <MedalCard/>
      </div>
    </div>
  </div>
</template>

<script>
import MedalCard from '../components/MedalCard'
export default {
  components: {
    MedalCard,
  }

}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css?family=Poppins|Ubuntu&display=swap');
body {
  margin: 0
}
div {
  box-sizing: border-box;
}

// .black-bg {
//   width: 100%; height: 100%;
//   background: rgba(0,0,0,0.5);
//   position: fixed; padding: 20px;
//   z-index: -1;
//   .white-bg {
//     width: 100%; background: white;
//     border-radius: 8px;
//     padding: 20px;
//   }
// }

.MYBADGENOW {
  font-family: 'Do Hyeon', sans-serif;
  width: 100%;
  height: 100%;
  z-index: 1;
  position: relative;
  padding: 60px 0;
  display: flex;
  justify-content: space-around;
  
  ::after {
    width: 100%;
    height: 100%;
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    z-index: -1;
    background: url('https://url.kr/na8mq2') no-repeat center center fixed;
    background-size: cover;
    opacity: 0.05;
  }
  .wrap {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    /* width: 500px;// */
    height: 800px;
    width: 80%;
    padding-top: 10px;
  
    /* border: 5px black solid; */
    .medal-wrap1 {
      height: 300px;
      /* border: 3px black solid; */
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;
    }

  }

}

</style>