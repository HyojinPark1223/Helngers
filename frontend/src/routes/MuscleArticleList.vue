<template>
  <div class="muscleArticle">
    <div
      v-if="isStatusOn"
      class="create">
      <CreateMuscleArticle />
    </div>
    <div class="menu">
      <h2>오늘의 근육을 채워보아요~!</h2>
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
export default {
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
  margin-top: 100px;
  .create {
    position: fixed;
    margin: 0 auto;
    left: 0;
    right: 0;
    z-index: 500;
    width: 800px;
    background-color: #fff;
    box-shadow: 0 0 999px 999px rgba(189, 186, 186, 0.7);
  }
  .menu {
    display: flex;
    justify-content: center;
    align-content: center;
    margin: 150px 300px;
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
    margin: 100px auto;
    cursor: pointer;
    .ArticleHeader {
      p {
        color: #919191;
      }
    }
  }
}
</style>