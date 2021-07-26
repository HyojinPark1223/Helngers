<template>
  <div class="createForm">
    <form>
      <div class="mb-3 createHeader">
        <h2>게시글 작성하기</h2>
        <button
          type="button"
          class="btn-close"
          @click="toProfile"
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
          id="exampleFormControlTextarea1"
          placeholder="게시글을 작성해주세요."
          rows="3"></textarea>
      </div>
      <div class="mb-3 bottom">
        <button
          type="submit"
          class="btn btn-secondary">
          이미지 첨부
        </button>
        <button
          type="submit"
          class="btn btn-primary">
          작성 완료
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  methods: {
    toProfile() {
      this.$parent.toggleOnOff()
    },
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
      margin: 0 15px;
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
      }
    }
    .bottom {
      display: flex;
      justify-content: space-between;
      margin: 0 15px;
    }
  }
}
</style>