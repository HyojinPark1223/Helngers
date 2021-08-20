<template>
  <div class="container">
    <div
      class="navBar"
      :class="{ dropdown : isActive}">
      <div class="navHeader">
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
            class="user-nav-item">
            <RouterLink
              to="/login"
              v-if="isLogin === false"
              active-class="active"
              class="nav-link">
              Login
            </RouterLink>
            <RouterLink
              to="/home"
              v-if="isLogin === true"
              active-class="active"
              @click="$store.dispatch('user/logout')"
              class="nav-link">
              Logout
            </RouterLink>
            <RouterLink
              to="/signup"
              v-if="isLogin === false"
              active-class="active"
              class="nav-link">
              SignUp
            </RouterLink>
          </div>
        </div>
        <MyModal
          v-if="isLogin === true"
          class="mymodal" />
        <span
          class="material-icons hamburgerBtn push"
          @click="toggleClass()">
          menu
        </span>
      </div>
      <transition name="slide-fade">
        <div
          class="hamburger"
          v-if="isActive">
          <RouterLink
            to="/main"
            tag="div"
            class="routerlink"
            @click="toggleClass">
            <h4>피드</h4>
          </RouterLink>
          <RouterLink
            to="/medal"
            tag="div"
            class="routerlink"
            @click="toggleClass">
            <h4>메달</h4>
          </RouterLink>
          <RouterLink
            to="/challenge"
            tag="div"
            class="routerlink"
            @click="toggleClass">
            <h4>챌린지</h4>
          </RouterLink>
          <RouterLink
            to="/musclearticle"
            tag="div"
            class="routerlink"
            @click="toggleClass">
            <h4>오늘의 머슬</h4>
          </RouterLink>
          <div class="user">
            <RouterLink
              to="/login"
              tag="div"
              class="routerlink"
              @click="toggleClass"
              v-if="isLogin === false">
              <p>Login</p>
            </RouterLink>
            <RouterLink
              to="/signup"
              tag="div"
              class="routerlink"
              @click="toggleClass"
              v-if="isLogin === false">
              <p>Signup</p>
            </RouterLink>
            <RouterLink
              to="/mypage"
              tag="div"
              class="routerlink"
              @click="toggleClass"
              v-if="isLogin">
              <p>MyPage</p>
            </RouterLink>
            <RouterLink
              to="/home"
              tag="div"
              class="routerlink"
              @click="[$store.dispatch('user/logout'), toggleClass]"
              v-if="isLogin">
              <p>LogOut</p>
            </RouterLink>
          </div>
        </div>
      </transition>
    </div>
  </div>
</template>

<script>
import Logo from './Logo'
import MyModal from './MyPage/MyModal.vue'
import {mapState} from 'vuex'
export default {
  components: {
    Logo,
    MyModal
  },
  mounted() {
    window.addEventListener('resize', this.handleResize);
    this.handleResize();
  },
  methods: {
    toggleClass(){
      this.isActive = !this.isActive;
    },
    handleResize() {
      this.window.width = window.innerWidth;
        if (window.innerWidth >= 1100) {
        this.isActive = false
        }
    }
  },
  data() {
    return {
      window: {
        width: 0,
        height: 0
      },
      isActive: false,
      timer: 0,
      navigations: [
        {
          name: '피드',
          href: '/main'
        },
        {
          name: '메달',
          href: '/medal'
        },
        {
          name: '챌린지',
          href: '/challenge'
        },
        {
          name: '오늘의 머슬',
          href: '/musclearticle'
        },
      ],
    }
  },
  computed: {
    ...mapState("user", ["isLogin"])
  }
}
</script>

<style lang="scss" scoped>
@include media-breakpoint-down(xl) {
  .nav{
    display: none;
  }
  .mymodal{
    display: none;
  }
}
@include media-breakpoint-up(xl) {
  .hamburgerBtn {
    display: none;
  }
  .hamburger {
    display: none;
  }
}
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
    position: fixed;
    background-color: rgb(255,219,89);
    border-radius: 20px;
    font-family: 'Do Hyeon', sans-serif;
    font-size: 20px;
    transition: height 0.5s ease;
    &.dropdown {
      height: 250px;
      transition: height 0.3s ease;
    }
    .navHeader {
      display: flex;
      align-items: center;
      height: 50px;
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
        display: flex;
      }
      .push {
        margin-left: auto;
      }
      .test {
        display: inline;
      }
      .hamburgerBtn {
        cursor: pointer;
      }
    }
    .hamburger {
      margin-top: 10px;
      width: 100%;
      height: 200px;
      padding: 10px;
      &.slide-fade-enter-active {
        transition: all 1.3s ease-out;
      }
      &.slide-fade-leave-active {
        transition: all 0.3s translateY(20px);;
      }
      &.slide-fade-enter-from,
      .slide-fade-leave-to {
        transform: translateY(-20px);
        opacity: 0;
      }
      .routerlink {
        cursor: pointer;
        text-decoration: none;
        color: #fff;
        &:hover {
          color: #333;
        }
      }
      .user {
        display: flex;
        justify-content: center;
        align-content: center;
        font-size: 13px;
        cursor: pointer;
        p {
          margin: 0 5px;
        }
        .routerlink {
          cursor: pointer;
          text-decoration: none;
          color: rgb(102, 102, 102);
          &:hover {
            color: #fff;
          }
        }
      }
    }
  }
}
</style>