<template>
  <header>
    <Logo />
    <div class="nav nav-pills">
      <div
        v-for="nav in navigations"
        :key="nav.name"
        class="nav-item">
        <RouterLink 
          :to="nav.href"
          active-class="active"
          class="nav-link">
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
    <MyModal />
  </header>
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
header {
  height: 50px;
  width: 100%;
  padding: 0 40px;
  display: flex;
  align-items: center;
  position: fixed;
  background-color: rgb(255,219,89, 1);
  font-family: 'Do Hyeon', sans-serif;
  font-size: 20px;
  z-index: 100;
  top: 0;
  .nav-link {
    color: rgb(255, 255, 255);
    padding-top: 12px;
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

</style>