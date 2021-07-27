<template>
  <div class="muscleArticle">
    <div class="menu">
      <h2>오늘의 근육을 채워보아요</h2>
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
  </div>
</template>

<script>
export default {
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
}
</style>