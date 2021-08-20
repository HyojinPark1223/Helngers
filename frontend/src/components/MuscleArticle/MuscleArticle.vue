<template>
  <div class="muscleArticle">
    <div
      v-if="isStatusOn"
      class="create">
      <CreateMuscleArticle />
    </div>
    <section class="banner">
      <div
        class="container"
        data-aos="fade-up"
        data-aos-duration="1000">
        <h1>Today's Muscle!</h1>
        <p>오늘의 근육을 채워보아요~!</p>
      </div>
    </section>
    <div class="menu">
      <div
        class="subtitle col-8"
        data-aos="fade-right"
        data-aos-duration="1000">
        <h3>
          전문가들의 운동 꿀팁 챙기기!
        </h3>
      </div>
      <div
        class="search col-4"
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
    <div
      class="singleArticle container"
      v-for="article in articles"
      @click="toSingle"
      :key="article.user">
      <div
        data-aos="zoom-in-up"
        data-aos-duration="1000">
        <div class="ArticleHeader">
          <p>{{ article.category }}</p>
          <h1>{{ article.title }}</h1>
          <p>{{ article.user }} . {{ article.date }}</p>
        </div>
        <div class="ArticleContent">
          <p>{{ article.content }}</p>
          <img
            :src="article.img"
            alt="ArtileImg"
            class="card-img" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CreateMuscleArticle from './CreateMuscleArticle.vue'
import AOS from 'aos'

export default {
  created() {
    AOS.init()
  },
  components: {
    CreateMuscleArticle,
  },
  data() {
    return {
      isStatusOn: false,
      articles: [
        {
        category: '어깨운동',
        title: '태평양 어깨를 만들 사이드 레터럴 레이즈',
        user: '김머니',
        date: '2021.07.27',
        content: '오늘은 태평양 어깨를 만들 수 있는 가장 좋은 운동인 사이드 레터럴 레이즈 를 한번 배워보겠습니다!',
        img: 'https://drive.google.com/uc?id=1RRhHxvTao7wI73b9-GM7xKfz5Fhd4f2K'
      },
        {
          category: '승모근운동',
          title: '자네 승모근 운동이라고 들어봤나',
          user: '이싸피',
          date: '2021.08.01',
          content: '모두가 승모근 운동을 기피 합니다.',
          img: 'https://drive.google.com/uc?id=1Oa9Sh1yBIqhKkneSD0diKdhWkZQvrUiB'
        }
      ]
    }
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
    toggleOnOff() {
      this.isStatusOn = !this.isStatusOn
    },
    toSingle() {
      this.$router.push('/singlearticle')
    }
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
    width: 180px !important;
    margin: 5px 0 !important;
  }
}
.focused {
    input{
      width: 180px !important;
      border-color: $primary !important;
    }
  }
}
.muscleArticle {
  font-family: 'Do Hyeon', sans-serif;
  position: relative;
  .create {
    position: fixed;
    margin: 20px auto;
    left: 0;
    right: 0;
    z-index: 500;
    width: 80%;
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
    background-image: linear-gradient(to top, rgb(0, 0, 0, 0.9), rgb(255, 255, 255, 0.1)), url('https://han.gl/HHZ57');
    h1 {
      font-family: 'Anton', sans-serif;
      color: #fff;
      text-align: center;
      font-size: 60px;
      margin-top: 140px;
      text-shadow: 1px 1px 3px #000;
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
    margin: 50px 20%;
    .subtitle {
      min-width: 280px;
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
        width: 150px;
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
        width: 330px;
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
  .singleArticle {
    text-align: center;
    width: 50%;
    margin: 50px auto;
    cursor: pointer;
    .ArticleHeader {
      p {
        color: #919191;
      }
    }
  }
}
</style>