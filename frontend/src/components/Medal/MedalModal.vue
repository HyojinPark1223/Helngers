<template>
  <div class="black-bg">
    <div
      class="white-bg"
      data-aos="fade-up"
      data-aos-duration="1000">
      <div class="modal-header">
        <button
          @click="close"
          type="submit"
          class="btn-close"
          aria-label="Close">
        </button>
      </div>
      <div class="modal-body">
        <div class="body-left">
          <div class="left-header">
            <img
              src="../../assets/fitness.png"
              alt="badge_image" />
            <div class="title">
              <h2>데드리프트 고수</h2>
              <P>560명(25▲)</P>
            </div>
          </div>
          <div class="progress">
            <div
              class="progress-bar"
              role="progressbar"
              style="width: 50%;"
              aria-valuenow="50"
              aria-valuemin="0"
              aria-valuemax="100">
              50%
            </div>
          </div>
          <div class="detail">
            <p>데드리프트는 ~~한 운동입니다.</p>
            <p>(운동 설명)</p>
          </div>
        </div>
        <div class="body-right">
          <div><h2>유튜브 등</h2></div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import AOS from 'aos'
export default {
    created() {
      AOS.init()
    },
    name: 'MedalModal',
    methods: {
      close() {
        this.$emit('close')
      },
    },
    data() {
      return {
        badges: {
          img_path: require('../../assets/badge/chest.png')
        }
      }
    }
}
</script>
<style lang="scss" scoped>
.black-bg {
  width: 100%; height: 100%;
  background-color: rgba(189, 186, 186, 0.5);
  z-index: 1000;
  position: fixed; padding: 20px;
  top: 0px;
  left: 0px;
  .white-bg {
    width: 50%; 
    height: 60%;
    margin-left: 25%;
    margin-top: 10%;
    background: white;
    opacity: 1;
    border-radius: 8px;
    padding: 20px;
    display: flex;
    flex-direction: column;
    .modal-header {
      width: 100%;
      height: 20px;
    }
    .modal-body {
      display: flex;
      justify-content: space-around;
      .body-left {
        width: 50%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        .left-header {
          display: flex;
          justify-content: center;
          align-content: center;
          img {
            width: 100px;
            height: 100px;
          }
          .title {
            text-align: center;
            padding: 20px 0 10px 30px;
          }
        }
        .progress {
          width: 250px;
          margin: 20px 0 20px;
        }
        .detail {
          width: 350px;
          height: 150px;
          background-color: $primary;
          text-align: center;
        }
      }
      .body-right {
        border: 2px, black, solid;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
      }
    }
  }
}
</style>