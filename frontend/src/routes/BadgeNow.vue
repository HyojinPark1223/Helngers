<template>
  <div>
    <section class="banner">
      <div
        class="container"
        data-aos="fade-up"
        data-aos-duration="1000">
        <h1>Badge Now!</h1>
        <p>운동을 하면서 쌓여 가는 빛나는 뱃지들!</p>
      </div>
    </section>
    <section class="container">
      <ul
        class="nav nav-tabs"
        id="myTab"
        role="tablist">
        <li
          class="nav-item"
          role="presentation">
          <button
            class="nav-link active"
            id="home-tab"
            data-bs-toggle="tab"
            data-bs-target="#chest"
            type="button"
            role="tab"
            aria-controls="home"
            aria-selected="true">
            가슴
          </button>
        </li>
        <li
          class="nav-item"
          role="presentation">
          <button
            class="nav-link"
            id="profile-tab"
            data-bs-toggle="tab"
            data-bs-target="#back"
            type="button"
            role="tab"
            aria-controls="profile"
            aria-selected="false">
            등
          </button>
        </li>
        <li
          class="nav-item"
          role="presentation">
          <button
            class="nav-link"
            id="contact-tab"
            data-bs-toggle="tab"
            data-bs-target="#shoulder"
            type="button"
            role="tab"
            aria-controls="contact"
            aria-selected="false">
            어깨
          </button>
        </li>
        <li
          class="nav-item"
          role="presentation">
          <button
            class="nav-link"
            id="contact-tab"
            data-bs-toggle="tab"
            data-bs-target="#arm"
            type="button"
            role="tab"
            aria-controls="contact"
            aria-selected="false">
            팔
          </button>
        </li>
        <li
          class="nav-item"
          role="presentation">
          <button
            class="nav-link"
            id="contact-tab"
            data-bs-toggle="tab"
            data-bs-target="#lower"
            type="button"
            role="tab"
            aria-controls="contact"
            aria-selected="false">
            하체
          </button>
        </li>
        <li
          class="nav-item"
          role="presentation">
          <button
            class="nav-link"
            id="contact-tab"
            data-bs-toggle="tab"
            data-bs-target="#running"
            type="button"
            role="tab"
            aria-controls="contact"
            aria-selected="false">
            유산소
          </button>
        </li>
        <li
          class="nav-item"
          role="presentation">
          <button
            class="nav-link"
            id="contact-tab"
            data-bs-toggle="tab"
            data-bs-target="#special"
            type="button"
            role="tab"
            aria-controls="contact"
            aria-selected="false">
            Special
          </button>
        </li>
        <li
          class="nav-item"
          role="presentation">
          <button
            class="nav-link"
            id="contact-tab"
            data-bs-toggle="tab"
            data-bs-target="#event"
            type="button"
            role="tab"
            aria-controls="contact"
            aria-selected="false">
            Event
          </button>
        </li>
      </ul>
      <div
        class="tab-content"
        id="myTabContent">
        <div
          class="tab-pane fade show active"
          id="chest"
          role="tabpanel"
          aria-labelledby="home-tab">
          <MedalCard />
        </div>
        <div
          class="tab-pane fade"
          id="back"
          role="tabpanel"
          aria-labelledby="profile-tab">
          <MedalCard />
        </div>
        <div
          class="tab-pane fade"
          id="shoulder"
          role="tabpanel"
          aria-labelledby="contact-tab">
          <MedalCard />
        </div>
        <div
          class="tab-pane fade"
          id="arm"
          role="tabpanel"
          aria-labelledby="contact-tab">
          <MedalCard />
        </div>
        <div
          class="tab-pane fade"
          id="lower"
          role="tabpanel"
          aria-labelledby="contact-tab">
          <MedalCard />
        </div>
        <div
          class="tab-pane fade"
          id="running"
          role="tabpanel"
          aria-labelledby="contact-tab">
          <MedalCard />
        </div>
        <div
          class="tab-pane fade"
          id="special"
          role="tabpanel"
          aria-labelledby="contact-tab">
          <MedalCard />
        </div>
        <div
          class="tab-pane fade"
          id="event"
          role="tabpanel"
          aria-labelledby="contact-tab">
          <MedalCard />
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import AOS from 'aos'
import MedalCard from '~/components/MedalCard'
export default {
  components: {
    MedalCard
  },
  async created() {
    AOS.init()
  }
}
</script>

<style lang="scss" scoped>
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
  background-image: linear-gradient(to top, rgb(0, 0, 0, 0.9), rgb(255, 255, 255, 0.1)), url('https://han.gl/qEvNm');
  h1 {
    font-family: 'Anton', sans-serif;
    color: #fff;
    text-align: center;
    font-size: 60px;
    margin-top: 140px;
    text-shadow: 1px 1px 4px #000;
  }
  p {
    font-family: 'Do Hyeon', sans-serif;
    color: rgb(228, 226, 226);
    text-align: center;
    font-size: 20px;
  }
}
.container {
  font-family: 'Do Hyeon', sans-serif;
  width: 70%;
  min-height: 700px;
  .nav-tabs {
    margin-top: 20px;
    .nav-item {
      .nav-link {
        min-width: 123px;
        color: rgb(245, 200, 0);
        font-size: 20px;
      }
    }
  }
  .tab-content {
    margin: 60px 0;
  }
}

</style>