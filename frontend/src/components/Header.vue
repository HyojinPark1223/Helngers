<template>
  <header>
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

export default {
  data() {
    return {
      navigations: [
        {
          name: 'Main',
          href: '/'
        },
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
  background-color: #FFDB59;
  .nav-link {
    color: #000;
  }
}

</style>