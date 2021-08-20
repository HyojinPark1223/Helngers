<template>
  <div>
    <div
      class="singleArticle container">
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
export default {
data() {
  return {
    article:
      {
        category: '어깨운동',
        title: '태평양 어깨를 만들 사이드 레터럴 레이즈',
        user: '김머니',
        date: '2021.07.27',
        content: '오늘은 태평양 어깨를 만들 수 있는 가장 좋은 운동인 사이드 레터럴 레이즈 를 한번 배워보겠습니다!',
        img: 'https://drive.google.com/uc?id=1RRhHxvTao7wI73b9-GM7xKfz5Fhd4f2K'
      },
  }
}
}
</script>

<style lang="scss" scoped>
.singleArticle {
  font-family: 'Do Hyeon', sans-serif;
  text-align: center;
  width: 50%;
  margin: 150px auto;
  cursor: pointer;
  .ArticleHeader {
    p {
      color: #919191;
    }
  }
}
</style>