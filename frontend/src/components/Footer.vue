<template>
  <footer>
    <div>
      <Logo />
      <RouterLink
        to="/"
        class="footer-logo">
        <h3>HELNGERS</h3>
      </RouterLink>
    </div>
    <a href="https://github.com/HyojinPark1223/Helngers">
      (c) {{ new Date().getFullYear() }} Helngers Team Github
    </a>
  </footer>
</template>

<script>
import Logo from '~/components/Logo'
export default {
  components: {
    Logo
  }
}
</script>

<style lang="scss" scoped>
footer {
  background-color: #333;
  padding: 70px 0;
  text-align: center;
  div {
    display: flex;
    justify-content: center;
    align-items: center;
    .footer-logo {
      text-decoration: none;
    }
    h3 {
      margin-bottom: 0;
      color: #fff;
    }
  }
}
</style>