<template>
  <div class="main">
    <div
      v-if="isStatusOn"
      class="create">
      <CreateMyArticle />
    </div>
    <transition name="slide-fade">
      <div
        v-if="isDetailOn"
        class="detail">
        <MyArticleDetail @close="detailOff" />
      </div>
    </transition>
    <section class="banner">
      <div
        class="container"
        data-aos="fade-up"
        data-aos-duration="1000">
        <h1>Workout Feed!</h1>
        <p>오늘은 어떤 운동을 하셨나요~?</p>
      </div>
    </section>
    <div class="menu">
      <div
        class="subtitle"
        data-aos="fade-right"
        data-aos-duration="1000">
        <h3 v-if="userInfo">
          {{ userInfo.first_name }}
        </h3>
        <h3 v-if="userInfo === null">
          OOO
        </h3>
        <h3>님이 운동하는 동안.. </h3>
      </div>
      <div
        class="search push"
        data-aos="fade-left"
        data-aos-duration="1000">
        <input
          type="text"
          @focus="searchFocus"
          @blur="searchBlur" />
        <img
          src="../../assets/search.png"
          alt="search"
          @click="searchFocus" />
        <img
          src="../../assets/pencil.png"
          alt="pencil"
          @click="toggleOnOff" />
      </div>
    </div>
    <div class="rating-wrap">
      <div
        class="content"
        v-for="index in contents"
        :key="index">
        <div
          class="card"
          @click="detailOn"
          data-aos="zoom-in-up"
          data-aos-durations="1000">
          <img
            src="https://url.kr/jekuoa"
            class="card-img-top"
            alt="..." />
          <div class="card-body">
            <h5 class="card-title">
              title
            </h5>
            <p class="card-text">
              Text
            </p>
          </div>
          <div class="sub-bottom">
            <p>2021. 7월 26일 / 6개의 댓글</p>
          </div>
          <div class="card-body bottom">
            <img
              src="../../assets/profile.png"
              alt="profile" 
              @click="toProfile" />
            <h6>
              코어는 국력, OOO 님
            </h6>
            <img
              class="push"
              src="../../assets/heart.png"
              alt="heart" />
          </div>
        </div>
      </div>
    </div>
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
import CreateMyArticle from './CreateMyArticle'
import MyArticleDetail from './MyArticleDetail'
import AOS from 'aos'

import { mapState } from "vuex"

export default {
  created() {
    AOS.init()
  },
  components: {
    CreateMyArticle,
    MyArticleDetail
  },
  data() {
    return {
      contents: 50,
      isStatusOn: false,
      isDetailOn: false,
      scrollY : 0
    }
  },
  computed: {
    ...mapState("user", ["userInfo"])
  },
  methods: {
    searchFocus() {
      const searchEl = document.querySelector('.search')
      const searchInputEl = searchEl.querySelector('input')
      searchEl.classList.add('focused')
      searchInputEl.setAttribute('placeholder', '게시물 검색')
    },
    searchBlur() {
      const searchEl = document.querySelector('.search')
      const searchInputEl = searchEl.querySelector('input')
      searchEl.classList.remove('focused')
      searchInputEl.setAttribute('placeholder', '')
    },
    toProfile() {
      this.$router.push('/mypage')
    },
    toggleOnOff() {
      this.isStatusOn = !this.isStatusOn
    },
    detailOn() {
      this.isDetailOn = !this.isDetailOn
      this.scrollY = window.scrollY;
      // console.log(this.scrollY)
      const main = document.querySelector('body')
      if (this.isDetailOn) {
        main.setAttribute('style', 'position: fixed;')
      }
    },
    detailOff() {
      this.isDetailOn = !this.isDetailOn
      const main = document.querySelector('body')
      if (!this.isDetailOn) {
        main.setAttribute('style', '')
      }
      window.scrollTo(0, this.scrollY)
    },
    toTop() {
      window.scrollTo(0,0)
    },
  }
}
</script>

<style lang="scss" scoped>
@include media-breakpoint-down(md) {
.menu {
  flex-direction: column !important;
  align-content: center !important;
  justify-content: center !important;
}
.subtitle {
  margin: 3px auto !important;
  justify-content: center !important;

}
.search {
  margin: 3px auto !important;
  justify-content: center !important;
  input {
    width: 190px !important;
    margin: 5px 0 !important;
  }
}
.focused {
    input{
      width: 190px !important;
      border-color: $primary !important;
    }
  }
}
.main {
  font-family: 'Do Hyeon', sans-serif;
  position: relative;
  .detail {
    position: fixed;
    z-index: 500;
    width: 60%;
    height: 85%;
    top: 10%;
    left: 20%;
    background-color: #fff;
    border-radius: 20px;
    box-shadow: 0 0 999px 999px rgba(41, 40, 40, 0.747);
    &.slide-fade-enter-active {
      transition: all .5s ease-out;
    }
    &.slide-fade-leave-active {
      transition: all 0.3s translateY(-20px);;
    }
    &.slide-fade-enter-from,
    .slide-fade-leave-to {
      transform: translateY(20px);
      opacity: 0;
    }
  }
  .create {
    position: fixed;
    margin: 0 auto;
    top: 80px;
    left: 0;
    right: 0;
    z-index: 500;
    width: 60%;
    background-color: #fff;
    box-shadow: 0 0 999px 999px rgba(189, 186, 186, 0.7);
  }
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
    background-image: linear-gradient(to top, rgb(0, 0, 0, 0.9), rgb(255, 255, 255, 0.1)), url('https://han.gl/TbkEG');
    h1 {
      font-family: 'Anton', sans-serif;
      color: #fff;
      text-align: center;
      font-size: 60px;
      margin-top: 140px;
      text-shadow: 1px 1px 4px #000;
    }
    p {
      color: rgb(228, 226, 226);
      text-align: center;
      font-size: 20px;
    }
  }
  .menu {
    display: flex;
    justify-content: center;
    align-content: center;
    margin: 100px 20%;
    .subtitle {
      min-width: 280px;
      display: flex;
      h3 {
        margin: 5px 0px;
      }
    }
    .search{
      min-width: 300px;
      display: flex;
      justify-content: flex-end;
      align-content: center;
      input {
        width: 200px;
        height: 30px;
        margin: 5px 10px;
        background-color: rgba($color: #919191, $alpha: .1);
        border: solid rgba($color: #919191, $alpha: .1);
        outline: none;
        border-radius: 30px;
        box-sizing: border-box;
        transition: width .4s;
      }
    }
    .focused {
      input{
        width: 300px;
        border-color: $primary;
      }
    }
    img {
      width: 35px;
      height: 33px;
      margin: 0px 5px;
      cursor: pointer;
    }
    h2 {
      margin-left: 10px;
    }
    .push {
      margin-left: auto;
    }
  }
  .rating-wrap {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    margin: 0 30px;
    .content {
      display: flex;
      justify-content: space-between;
      align-content: center;
      margin: 0 30px 50px 30px;
      .card {
        border-radius: 15px;
        height: 290px * 3 / 2;
        width: 290px;
        border: none;
        box-shadow: 2px 2px 5px 3px rgba(189, 186, 186, 0.5);
        cursor: pointer;
        &:hover {
          transform: scale(1.05);
          transition: 1s;
          box-shadow: 0 10px 20px rgba(0,0,0,.12), 0 4px 8px rgba(0,0,0,.06);
        }
        .card-body {
          background-color: rgba($color: #e9e9e9, $alpha: .2);
          h6 {
            height: 25px;
            margin: 5px 0 0 10px;
          }
          img {
            width: 25px;
            height: 25px;
            cursor: pointer;
          }
          .push {
          margin-left: auto;
          }
          
        }
        .sub-bottom {
            background-color: rgba($color: #e9e9e9, $alpha: .1);
            margin: 0 0 10px 15px;
            p {
              margin: 0;
              font-size: 12px;
              color: #919191;
            }
          }
        .bottom {
          border-top: solid rgba($color: #919191, $alpha: .2);
          max-height: 40px;
          display: flex;
          padding: 8px 13px;
          h6 {
            font-size: 14px;
            margin: 3px 0 0 10px;
          }
          img {
            width: 20px;
            height: 20px;
          }
        }
      }
    }
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
</style>