<template>
  <div class="home">
    <HomeBanner />
    <HomeMain />
    <HomeYoutube />
  </div>
</template>

<script>
import HomeBanner from '~/components/HomeBanner'
import HomeMain from '~/components/HomeMain'
import HomeYoutube from '~/components/HomeYoutube'

export default {
  components: {
    HomeBanner,
    HomeMain,
    HomeYoutube
  },
}
</script>

<style lang="scss" scoped>

</style>