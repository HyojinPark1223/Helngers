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
        <h1>Today's Muschle!</h1>
        <p>오늘의 근육을 채워보아요~!</p>
      </div>
    </section>
    <div class="menu">
      <!-- <h2>오늘의 근육을 채워보아요~!</h2> -->
      <div class="search push">
        <input
          type="text"
          @focus="searchFocus"
          @blur="searchBlur" />
        <img
          src="../assets/search.png"
          alt="search"
          @click="searchFocus" />
      </div>
      <img
        src="../assets/pencil.png"
        alt="pencil"
        @click="toggleOnOff" />
    </div>
    <div
      class="singleArticle"
      v-for="article in articles"
      :key="article.user">
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
</template>

<script>
import CreateMuscleArticle from '../components/CreateMuscleArticle.vue'
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
          category: '카테고리',
          title: 'Title',
          user: '작성자 이름',
          date: '2021.07.27',
          content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quia sapiente accusamus ducimus voluptates. Vitae, alias quidem delectus saepe eveniet illum nihil dicta minus in nostrum hic dolorum minima? Distinctio, alias?',
          img: 'https://url.kr/rjuqsh'
        },
        {
          category: '카테고리',
          title: 'Title',
          user: '작성자 이름',
          date: '2021.07.27',
          content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quia sapiente accusamus ducimus voluptates. Vitae, alias quidem delectus saepe eveniet illum nihil dicta minus in nostrum hic dolorum minima? Distinctio, alias?',
          img: 'https://url.kr/rjuqsh'
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
  }
}
</script>

<style lang="scss" scoped>
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
    }
    p {
      color: rgb(156, 155, 155);
      text-align: center;
      font-size: 20px;
    }
  }
  .menu {
    display: flex;
    justify-content: center;
    align-content: center;
    margin: 50px 200px;
    z-index: 10;
    .search{
      position: relative;
      input {
        width: 100px;
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
  .singleArticle {
    text-align: center;
    width: 600px;
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