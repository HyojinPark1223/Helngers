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
      <div
        class="profile"
        @click="toMypage">
        <img 
          :src="image" 
          :alt="name" />
      </div>
    </div>
  </header>
</template>

<script>
import Logo from './Logo'
import { mapState } from 'vuex'

export default {
  components: {
    Logo,
  },
  data() {
    return {
      navigations: [
        {
          name: '메달 현황',
          href: '/medalnow'
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
  computed: {
    ...mapState('profile', [ // vuex helper
      'image',
      'name'
    ])
  },
  methods: {
    toMypage() {
      this.$router.push('/mypage')
    }
  }
}
</script>

<style lang="scss" scoped>
header {
  height: 70px;
  padding: 0 40px;
  display: flex;
  align-items: center;
  position: relative;
  background-color: rgb(255,219,89, .73);
  font-family: 'Do Hyeon', sans-serif;
  font-size: 23px;
  .nav-link {
    color: #000;
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
  .profile {
    width: 40px;
    height: 40px;
    padding: 6px;
    border-radius: 50%;
    background-color: #fff;
    cursor: pointer;
    margin: auto;
    margin-left: 10px;
    transition: .4s;
    &:hover {
      background-color: darken( $gray-200, 10%);
    }
    img {
      width: 100%;
      margin-bottom: 4px;
    }
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