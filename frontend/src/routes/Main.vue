<template>
  <div class="main">
    <div class="menu">
      <h2>OOO 님이 운동하는 동안.. </h2>
      <input
        class="push"
        type="text" />
      <img
        src="../assets/search.png"
        alt="search" />
      <img
        src="../assets/pencil.png"
        alt="pencil" />
    </div>
    <div class="content">
      <div
        class="card">
        <img
          src="https://url.kr/a7td2s"
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
            alt="profile" />
          <h6>
            코어는 국력, OOO 님
          </h6>
          <img
            class="push"
            src="../assets/heart.png"
            alt="heart" />
        </div>
      </div>
      <div
        class="card">
        <img
          src="https://url.kr/a7td2s"
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
            alt="profile" />
          <h6>
            코어는 국력, OOO 님
          </h6>
          <img
            class="push"
            src="../assets/heart.png"
            alt="heart" />
        </div>
      </div>
      <div
        class="card">
        <img
          src="https://url.kr/a7td2s"
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
            alt="profile" />
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
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
.main {
  font-family: 'Do Hyeon', sans-serif;
  .menu {
    display: flex;
    justify-content: center;
    align-content: center;
    margin: 50px 60px;
    input {
      width: 300px;
      height: 30px;
      margin: 5px 10px;
      background-color: rgba($color: #919191, $alpha: .2);
      border: none;
      border-radius: 30px;
    }
    img {
      width: 35px;
      height: 35px;
      margin: 0px 5px;
    }
    h2 {
      margin-left: 10px;
    }
    .push {
      margin-left: auto;
    }
  }
  .content {
    display: flex;
    justify-content: space-between;
    align-content: center;
    margin: 0 80px 60px 80px;
    .card {
      border-radius: 10px;
      height: 530px;
      width: 400px;
      border: none;
      .card-body {
        background-color: rgba($color: #e9e9e9, $alpha: .1);
        h6 {
          height: 25px;
          margin: 5px 0 0 10px;
        }
        img {
          width: 25px;
          height: 25px;
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
          }
        }
      .bottom {
        border-top: solid rgba($color: #919191, $alpha: .2);
        max-height: 20px;
        display: flex;
      }
    }
  }
}
</style>