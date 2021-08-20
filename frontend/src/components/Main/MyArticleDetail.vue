<template>
  <div>
    <div
      class="card mb-3">
      <div class="row g-0">
        <div class="col-md-7 cardImage">
          <img
            src="https://url.kr/jekuoa"
            class="img-fluid rounded-start detailImg"
            alt="MyImage" />
        </div>
        <div class="col-md-5">
          <div class="cardtitle">
            <img
              src="../../assets/profile.png"
              alt="profile" 
              @click="toProfile" />
            <h4>
              코어는 국력님
            </h4>
            <button
              type="button"
              class="btn-close"
              @click="toMain"
              aria-label="Close"></button>
          </div>
          <div class="cardbody">
            <p class="card-text">
              벤치프레스 10set, 시티드프레스 10set
            </p>
            <div class="control">
              <button class="btn btn-primary">
                수정
              </button>
              <button class="btn btn-danger">
                삭제
              </button>
            </div>
            <div class="like">
              <h6>1명의 사람이 좋아합니다.</h6>
              <img
                class="push"
                src="../../assets/heart.png"
                alt="heart" />
            </div>
          </div>
          <div class="comment">
            <MyArticleComment />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MyArticleComment from './MyArticleComment'

export default {
  components: {
    MyArticleComment
  },
  methods: {
    toMain() {
      this.$emit('close');
    },
  },
}
</script>

<style lang="scss" scoped>
.card {
  height: 580px;
  border: 0;
  margin: 16px;
  .cardImage {
    padding: 10px 20px 20px 20px;
    .detailImg {
      height: 560px;
      width: 100%;
      border-radius: 15px;
      box-shadow: 2px 2px 5px 3px rgba(189, 186, 186, 0.5);
    }
  }
  .cardtitle {
    display: flex;
    align-items: center;
    img {
      width: 35px;
      height: 35px;
      cursor: pointer;
    }
    h4 {
      height: 25px;
      margin: 10px 0 10px 15px;
    }
    button {
      margin: 0 0 15px auto;
      padding: 0;
    }
  }
  .cardbody {
    margin: 10px;
    .card-text {
      height: 250px;
      padding-top: 20px;
    }
    .control {
      display: flex;
      border-bottom: 0.5mm solid rgba($color: #919191, $alpha: .2);
      button {
        margin: 5px;
        width: 60px;
        height: 20px;
        padding: 0;
        font-size: 14px;
        &:last-child {
          margin-right: auto;
        }
      }
    }
    .like {
      display: flex;
      justify-content: space-between;
      margin: 10px 0;
      h6 {
        margin: 4px 0;
      }
      img {
        width: 30px;
        height: 30px;
        cursor: pointer;
      }
    }
  }
  .comment {
    margin: 10px;
  }
}
</style>