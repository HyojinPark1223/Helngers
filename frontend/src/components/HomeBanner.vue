<template>
  <div class="home">
    <div
      id="carouselMyCaptions"
      class="carousel slide"
      data-bs-ride="carousel">
      <div class="carousel-indicators">
        <button
          type="button"
          data-bs-target="#carouselMyCaptions"
          data-bs-slide-to="0"
          class="active"
          aria-current="true"
          aria-label="Slide 1"></button>
        <button
          type="button"
          data-bs-target="#carouselMyCaptions"
          data-bs-slide-to="1"
          aria-label="Slide 2"></button>
        <button
          type="button"
          data-bs-target="#carouselMyCaptions"
          data-bs-slide-to="2"
          aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img
            src="https://url.kr/v3gekf"
            class="d-block w-100"
            alt="main1" />
          <div
            class="carousel-caption d-none d-md-block">
            <h1>Do not give up. The beginning is always the hardest.</h1>
            <p>포기하지 마세요. 시작은 언제나 힘든 법입니다.</p>
          </div>
        </div>
        <div class="carousel-item">
          <img
            src="https://url.kr/k2d8g4"
            class="d-block w-100"
            alt="main2" />
          <div class="carousel-caption d-none d-md-block">
            <h1>Break me down to buile me up.</h1>
            <p>원하는 몸을 위해 지금의 몸을 부수자.</p>
          </div>
        </div>
        <div class="carousel-item">
          <img
            src="https://url.kr/vtyu25"
            class="d-block w-100"
            alt="main3" />
          <div class="carousel-caption d-none d-md-block">
            <h1>There is no shortcut. You have to keep plugging away.</h1>
            <p>계속 노력해야 해요. 지름길은 없어요.</p>
          </div>
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselMyCaptions"
        data-bs-slide="prev">
        <span
          class="carousel-control-prev-icon"
          aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselMyCaptions"
        data-bs-slide="next">
        <span
          class="carousel-control-next-icon"
          aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
.home {
  #carouselMyCaptions {
    width: 100%;
    max-height: 100vh;
    overflow: hidden;
    .carousel-inner {
      img {
        filter: brightness(50%)
      }
      .carousel-caption {
        height: 100%;
        display: flex;
        padding-top: 250px;
        font-family: 'Anton', sans-serif;
        text-shadow: 1px 1px 3px #000;
      }
    }
  }
}

</style>