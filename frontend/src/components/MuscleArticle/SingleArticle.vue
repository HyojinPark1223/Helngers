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
        category: '카테고리',
        title: 'Title',
        user: '작성자 이름',
        date: '2021.07.27',
        content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quia sapiente accusamus ducimus voluptates. Vitae, alias quidem delectus saepe eveniet illum nihil dicta minus in nostrum hic dolorum minima? Distinctio, alias?',
        img: 'https://url.kr/rjuqsh'
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