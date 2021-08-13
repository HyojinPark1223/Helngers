<template>
  <section class="article">
    <div
      class="inner"
      data-aos="fade-left"
      data-aos-duration="1000">
      <div class="text-group">
        <h1>Today's Muscle</h1>
        <p>전문가의 정확한 운동방법까지 오늘의 꿀팁을 배워보세요~!</p>
        <button
          type="button"
          class="btn btn-warning"
          @click="toMusclearticlelist">
          오늘의 머슬
        </button>
      </div>
      <img
        src="../../assets/trophy.png"
        alt="throphy" />
    </div>
  </section>
</template>

<script>
import AOS from 'aos'
export default {
  created() {
    AOS.init()
  },
  methods: {
    toMusclearticlelist() {
      this.$router.push('/musclearticle')
    },
  }
}
</script>

<style lang="scss" scoped>
@include media-breakpoint-down(lg) {
  .article {
    .inner {
      margin-right: 200px !important;
    }
  }
}
@include media-breakpoint-down(md) {
  .article {
    .inner {
      margin-right: 100px !important;
    }
  }
}
@include media-breakpoint-down(sm) {
  .article {
    .inner {
      margin-right: 50px !important;
      .text-group {
        p {
          font-size: 13px !important;
        }
      }
    }
  }
}
.article {
  background-image: linear-gradient(to top, rgb(0, 0, 0, 0.9), rgb(255, 255, 255, 0.1)), url('https://url.kr/p6gjw5');
  background-repeat: no-repeat;
  background-position: center;
  background-attachment: fixed;
  background-size: cover;
  .inner {
    height: 300px;
    padding: 90px 0;
    margin-right: 300px;
    display: flex;
    justify-content: flex-end;
    img {
      height: 140px;
      width: 100px;
    }
    .text-group {
      text-align: right;
      margin-right: 30px;
      h1 {
        font-family: 'Anton', sans-serif;
        color: #fff;
      }
      p {
        font-family: 'Do Hyeon', serif;
        color: #fff;
      }
      .btn {
        font-family: 'Do Hyeon', serif;
        width: 130px;
        height: 35px;
        color: #fff;
      }
    }
  }
}
</style>