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
  </header>
</template>

<script>
import Logo from './Logo'

export default {
  components: {
    Logo,
  },
  data() {
    return {
      navigations: [
        {
          name: 'Login',
          href: '/login'
        },
        {
          name: 'MedalNow',
          href: '/medalnow'
        },
        {
          name: 'MuscleArticleList',
          href: '/musclearticlelist'
        },
        {
          name: 'Mypage',
          href: '/mypage'
        },
      ]
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
  .nav-link {
    color: #000;
  }
  .logo {
    margin-right: 20px;
  }
}

</style>