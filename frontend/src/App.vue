<template>
  <div>
    <Header />
    <FileUploader />
    <RouterView />
    <Footer />
  </div>
</template>

<script>
import Header from './components/Header'
import Footer from './components/Footer'
import FileUploader from './components/fileUploader.vue'

export default {
  beforeCreate() {
    this.$store.dispatch('getMemberInfo')
  },
  components:{
    Header,
    Footer,
    FileUploader
  }
}
</script>

<style lang="scss">
@import "~/scss/main";
</style>