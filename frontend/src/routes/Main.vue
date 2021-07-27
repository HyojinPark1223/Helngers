<template>
  <div class="main">
    <div
      v-if="isStatusOn"
      class="create">
      <CreateMyArticle />
    </div>
    <div
      v-if="isDetailOn"
      class="detail">
      <MyArticleDetail />
    </div>
    <div class="menu">
      <h2>OOO 님이 운동하는 동안.. </h2>
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
    <div class="rating-wrap">
      <div
        class="content"
        v-for="index in contents"
        :key="index">
        <div
          class="card"
          @click="detailOnOff">
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
              src="../assets/profile.png"
              alt="profile" 
              @click="toProfile" />
            <h6>
              코어는 국력, OOO 님
            </h6>
            <img
              class="push"
              src="../assets/heart.png"
              alt="heart" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CreateMyArticle from '~/components/CreateMyArticle'
import MyArticleDetail from '~/components/MyArticleDetail'

export default {
  components: {
    CreateMyArticle,
    MyArticleDetail
  },
  data() {
    return {
      contents: 50,
      isStatusOn: false,
      isDetailOn: false
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
    toProfile() {
      this.$router.push('/mypage')
    },
    toggleOnOff() {
      this.isStatusOn = !this.isStatusOn
    },
    detailOnOff() {
      this.isDetailOn = !this.isDetailOn
      const main = document.querySelector('body')
      if (this.isDetailOn) {
        main.setAttribute('style', 'position: fixed;')
      }
      else {
        main.setAttribute('style', '')
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.main {
  font-family: 'Do Hyeon', sans-serif;
  position: relative;
  margin-top: 100px;
  .detail {
    position: fixed;
    z-index: 500;
    width: 800px;
    top: 100px;
    right: 320px;
    background-color: #fff;
    border-radius: 20px;
    box-shadow: 0 0 999px 999px rgba(189, 186, 186, 0.7);
  }
  .create {
    position: fixed;
    z-index: 500;
    width: 800px;
    top: 130px;
    right: 320px;
    background-color: #fff;
    box-shadow: 0 0 999px 999px rgba(189, 186, 186, 0.7);
  }
  .menu {
    display: flex;
    justify-content: center;
    align-content: center;
    margin: 50px 60px;
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
  .rating-wrap {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    .content {
      display: flex;
      justify-content: space-between;
      align-content: center;
      margin: 0 30px 50px 30px;
      .card {
        border-radius: 15px;
        height: 250px * 3 / 2;
        width: 250px;
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
</style>