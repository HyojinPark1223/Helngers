<template>
  <div>
    <Header />
    <RouterView />
    <Footer />
  </div>
</template>

<script>
import Header from './components/Header'
import Footer from './components/Footer'

export default {
  beforeCreate() {
    this.$store.dispatch('user/getMemberInfo')
  },
  components:{
    Header,
    Footer,
  }
}
</script>

<style lang="scss">
@import "~/scss/main";
</style>