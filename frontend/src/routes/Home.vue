<template>
  <div class="home">
    <HomeBanner />
    <HomeMain />
  </div>
</template>

<script>
import HomeBanner from '~/components/HomeBanner'
import HomeMain from '~/components/HomeMain'

export default {
  components: {
    HomeBanner,
    HomeMain
  },
}
</script>

<style lang="scss" scoped>

</style>