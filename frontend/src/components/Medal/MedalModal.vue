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
              :src="badges.img_path"
              alt="badge_image" />
            <div class="title">
              <h2>{{ now_medal_info.title }}</h2>
              <P>560명(25▲)</P>
            </div>
          </div>
          <div class="progress">
            <div
              class="progress-bar"
              role="progressbar"
              :style="{width:achievement_rate+'%'}"
              :aria-valuenow="achievement_rate"
              aria-valuemin="0"
              aria-valuemax="100">
              {{ achievement_rate }}%
            </div>
          </div>
          <div class="detail">
            <br />
            <p>{{ now_medal_info.content }}</p>
            <!-- <p>인덱스 : {{ index }} 레벨 : {{ level }}</p> -->
          </div>
        </div>
        <div class="body-right">
          <div>
            <h2>{{ achievement_rate }}퍼나!!!!</h2>
            <img
              src="https://drive.google.com/uc?id=1rCxu8Okv1ukv9baQMG-jDyOzrGg2oVaG"
              alt="" 
              width="200"
              height="200" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import AOS from 'aos'
import { mapState } from 'vuex'

export default {
  data() {
    return {
      achievement_rate: 0,
      now_medal_info: {},
      badges: {
        img_path: 'https://drive.google.com/uc?id=1FgqUR3lzLvJeQssFAWbaS6W7XilvK-LV'
      }
    }
  },
  computed: {
      ...mapState('medal', ['medals_has_users']),
      ...mapState('medal', ['medals']),
      ...mapState('medal', ['level_0_user_medal']),
      ...mapState('medal', ['level_1_user_medal']),
      ...mapState('medal', ['level_2_user_medal']),
    },
    props: {
      index:Number,
      level:Number,
    },
    created: function (){
      AOS.init()
      console.log(this.index)
      console.log(this.level)
      if (this.level === 0) {
        this.now_medal_info = this.level_0_user_medal[this.index]
      } else if (this.level === 1) {
        this.now_medal_info = this.level_1_user_medal[this.index]
      } else if (this.level === 2) {
        this.now_medal_info = this.level_2_user_medal[this.index]
      }
      console.log('현재 메달의 정보')
      console.log(this.now_medal_info)
      this.badges.img_path = this.now_medal_info.url
      console.log('유저 전체 메달의정보')
      console.log(this.medals_has_users)
      for (let m of this.medals_has_users) {
        console.log('m')
        console.log(m)
        if (m.medals_id === this.now_medal_info.id) {
          console.log('찾았다')
          this.achievement_rate = m.present/this.now_medal_info.goal *100

          break
        }
      }
      console.log(this.achievement_rate)


    },
    name: 'MedalModal',
    methods: {
      close() {
        this.$emit('close')
      },
    },
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