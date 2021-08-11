<template>
  <section class="challenge">
    <div class="inner">
      <div
        class="text-group"
        data-aos="fade-right"
        data-aos-duration="1000">
        <img
          src="../../assets/challenge.png"
          alt="challenge" />
        <h1>Challenge</h1>
        <p>
          혼자하면 어렵지만 같이 하면 해낼 수 있습니다!
          오늘의 챌린지로 작심3일을 함께 이겨나가요!
        </p>
        <button
          type="button"
          class="btn btn-success"
          @click="toChallnege">
          자세히 보기
        </button>
      </div>
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
    toChallnege() {
      this.$router.push('/challenge')
    },
  }
}
</script>

<style lang="scss" scoped>
@include media-breakpoint-down(lg) {
  .challenge {
    .inner {
      .text-group {
        margin-left: 100px !important;
      }
    }    
  }
}
@include media-breakpoint-down(md) {
  .challenge {
    .inner {
      .text-group {
        margin-left: 30px !important;
      }
    }    
  }
}
@include media-breakpoint-down(sm) {
  .challenge {
    .inner {
      .text-group {
        margin-left: 0px !important;
        img {
          width: 1500px !important;
        }
        h1 {
          font-size: 80px !important;
        }
      }
    }    
  }
}
.challenge {
  background-image: linear-gradient(to top, rgb(0, 0, 0, 0.9), rgb(255, 255, 255, 0.1)) ,url('https://url.kr/7egcm5');
  background-repeat: no-repeat;
  background-position: center;
  background-attachment: fixed;
  background-size: cover;
  .inner {
    padding: 110px 0;
    box-shadow: 0 0 999px 999px rgba(255, 255, 255, 0.678);
    z-index: 10;
    .text-group {
      width: 450px;
      margin-left: 200px;
      display: flex;
      justify-content: flex-start;
      flex-wrap: wrap;
      color: #fff;
      font-family: 'Do Hyeon', serif;
      img {
        height: 300px;
        width: 3000px;
      }
      h1 {
        margin-left: 100px;
        font-size: 100px;
      }
      p {
        margin-left: 100px;
        font-size: 20px;
      }
      .btn {
        margin-left: 100px;
        width: 130px;
      }
    }
  }
}
</style>