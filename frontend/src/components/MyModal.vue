<template>
  <div>
    <!-- Button trigger modal -->
    <div
      type="button"
      class="profile"
      data-bs-toggle="modal"
      data-bs-target="#MyModal">
      <img 
        :src="image" 
        :alt="name" />
    </div>

    <!-- Modal -->
    <div
      class="modal fade"
      id="MyModal"
      tabindex="-1"
      aria-labelledby="MyModalLabel"
      aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5
              class="modal-title"
              id="MyModalLabel">
              Profile
            </h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <img 
              :src="image" 
              :alt="name" />
            <h3>사용자 이름</h3>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-primary"
              @click="toMypage"
              data-bs-dismiss="modal">
              MyPage
            </button>
            <button
              type="button"
              class="btn btn-secondary">
              Logout
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  computed: {
    ...mapState('profile', [ // vuex helper
      'image',
      'name'
    ])
  },
  methods: {
    toMypage() {
      this.$router.push('/mypage')
    },
  }
}
</script>

<style lang="scss" scoped>
div {
  button {
    margin-left: 12px;
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
  #MyModal {
    top: 6%;
  }
  .modal-dialog {
    width: 250px;
    position: absolute;
    top: 5px;
    right: 35px;
    .modal-body {
      text-align: center;
    }
    .modal-footer {
      justify-content: center;
    }
    img {
      width: 100px;
      height: 100px;
    }
  }
}
</style>