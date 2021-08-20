<template>
  <div class="createForm">
    <form>
      <div class="mb-3 createHeader">
        <h2>게시글 작성하기</h2>
        <button
          type="button"
          class="btn-close"
          @click="toMain"
          aria-label="Close"></button>
      </div>
      <div class="mb-3">
        <div
          id="emailHelp"
          class="form-text">
          오늘 한 운동을 기록해보세요! No pain, No gain!!
        </div>
      </div>
      <div class="mb-3 article-title">
        <h4>제목 : </h4>
        <input
          type="text"
          autofocus
          v-model="title"
          class="form-control"
          placeholder="제목을 입력해주세요." />
      </div>
      <div class="mb-3 today">
        <h4>오늘의 운동 : </h4>
        <select
          class="form-select"
          id="inlineFormSelectPref">
          <option selected>
            운동 선택하기 ...
          </option>
          <option value="1">
            하체
          </option>
          <option value="2">
            가슴
          </option>
          <option value="3">
            등
          </option>
        </select>
      </div>
      <div class="mb-3 articleText">
        <textarea
          class="form-control"
          v-model="content"
          id="exampleFormControlTextarea1"
          placeholder="게시글을 작성해주세요."
          rows="3"></textarea>
      </div>
      <div class="mb-3 bottom">
        <div class="fileUpload">
          <FileSelect @input="input" />
          <p v-if="file">
            {{ file.name }}
          </p>
        </div>
        <button
          type="submit"
          class="btn btn-primary"
          @click="createBoard({title, writer, content,})">
          작성 완료
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import FileSelect from './FileSelect.vue'
export default {
  components: {
    FileSelect
  },
  data() {
    return {
      file: null,
      title: null,
      writer: null,
      content: null,
    }
  },
  methods: {
    toMain() {
      this.$parent.toggleOnOff()
    },
    input(value) {
      this.file = value;
    },
    ...mapActions('board', ["createBoard"]),
  }
}
</script>

<style lang="scss" scoped>
.createForm {
  form {
    padding: 30px;
    .createHeader {
      display: flex;
      justify-content: space-between;
    }
    .article-title {
      display: flex;
      margin: 0 15px;
      h4 {
        margin: 10px 0px;
      }
      input {
        border: none;
        margin: 10px 10px;
        height: 30px;
        width: 400px;
      }
    }
    .today {
      display: flex;
      margin: 0 15px;
      justify-content: space-between;
      h4 {
        margin: 5px 0;
      }
      .form-select {
        margin-left: 10px;
        max-width: 580px;
        border: none;
      }
    }
    .articleText {
      border-top: solid rgba($color: #817d7d, $alpha: 0.5);
      margin: 0 15px;
      textarea {
        height: 200px;
        margin-top: 20px;
        border: none;
        background-color: rgba($color: #817d7d, $alpha: 0.1);
      }
    }
    .bottom {
      display: flex;
      justify-content: space-between;
      margin: 0 15px;
      .fileUpload {
        display: flex;
        p {
          margin: 7px 0px 3px 20px;
        }
      }
    }
  }
}
.card {
  font-family: 'Do Hyeon', sans-serif;
  width: 600px;
  height: 200px;
  position: absolute;
  left: 50%;
  top: 70%;
  margin: 0 auto;
  margin-left: -250px;
  margin-top: -250px;
  box-shadow: 0 0 999px 999px rgba(255, 255, 255, 0.678);
  z-index: 500;
  .card-body {
    .card-title {
      display: flex;
      justify-content: space-between;
      align-content: center;
    }
    .card-content {
      display: flex;
      justify-content: space-around;
      align-content: center;
      margin: 30px 0;
      input {
        margin-right: 5px;
      }
    }
    .card-bottom {
      display: flex;
      justify-content: center;
      align-content: center;
      button {
        width: 100px;
        padding: 3px 10px;
      }
      .cancel {
        margin-right: 20px;
      }
    }
  }
}
</style>