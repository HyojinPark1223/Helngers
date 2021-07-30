<template>
  <div class="container">
    <div class="navBar">
      <Logo />
      <div class="nav nav-pills">
        <div
          v-for="nav in navigations"
          :key="nav.name"
          class="nav-item">
          <RouterLink 
            :to="nav.href"
            class="nav-link"
            active-class="active"
            @click="addActive">
            {{ nav.name }}
          </RouterLink>
        </div>
      </div>
      <div class="nav nav-pills push">
        <div
          v-for="nav in user_navigations"
          :key="nav.name"
          class="user-nav-item">
          <RouterLink
            :to="nav.href"
            active-class="active"
            class="nav-link">
            {{ nav.name }}
          </RouterLink>
        </div>
      </div>
      <MyModal class="mymodal" />
    </div>
  </div>
</template>

<script>
import Logo from './Logo'
import MyModal from '~/components/MyModal'

export default {
  components: {
    Logo,
    MyModal
  },
  data() {
    return {
      navigations: [
        {
          name: '운동 기록',
          href: '/'
        },
        {
          name: '뱃지 현황',
          href: '/badgenow'
        },
        {
          name: '챌린지',
          href: '/challenge'
        },
        {
          name: '오늘의 머슬',
          href: '/musclearticlelist'
        },
      ],
      user_navigations: [
        {
          name: 'Login',
          href: '/login'
        },
      ]
    }
  },
}
</script>

<style lang="scss" scoped>
.container {
  position: relative;
  z-index: 500;
  width: 100%;
  display: flex;
  justify-content: center;
  top: 0;
  left: 0;
  right: 0;
  .navBar {
    width: 60%;
    height: 50px;
    padding: 0 40px;
    margin: 10px auto;
    display: flex;
    align-items: center;
    position: fixed;
    background-color: rgb(255,219,89, .8);
    border-radius: 20px;
    font-family: 'Do Hyeon', sans-serif;
    font-size: 20px;
    .mymodal {
      z-index: 100;
    }
    .nav-link {
      color: rgb(255, 255, 255);
      padding-top: 12px;
      cursor: pointer;
      &.active {
        color: #000;
      }
    }
    .logo {
      margin-right: 20px;
    }
    .user-nav-item {
      top: 0;
      bottom: 0;
      right: 40px;
      margin: auto;
    }
    .push {
      margin-left: auto;
    }
    .test {
      display: inline;
    }
    @include media-breakpoint-down(sm) {
      .nav {
        display: none;
      }
    }
  }
}

</style>