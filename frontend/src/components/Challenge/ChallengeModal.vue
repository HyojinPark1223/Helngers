<template>
  <div
    class="card mb-3">
    <div class="row g-0">
      <div class="col-md-5 image">
        <div
          class="imagePreviewWrapper"
          :style="{ 'background-image': `url(${previewImage})` }"
          @click="selectImage">
        </div>
      </div>
      <div class="col-md-7 content">
        <div class="card-body">
          <button
            type="button"
            class="btn-close"
            @click="toChallenge"
            aria-label="Close"></button>
          <h2 class="card-title">
            챌린지 제목
          </h2>
          <p class="card-text">
            ~~한 챌린지 입니다!
          </p>
          <p class="text-muted">
            취득가능 기간: 2021 0월 0일 ~ 2021 0월 0일
          </p>
        </div>
        <div class="filebox">
          <label for="ex_file">이미지 업로드</label>
          <input
            ref="fileInput"
            type="file"
            @input="pickFile"
            id="ex_file" />
          <button
            type="submit"
            class="btn btn-danger">
            작성 완료
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      previewImage: null
    };
  },
  methods: {
    toChallenge() {
      this.$emit('close')
    },
    selectImage () {
          this.$refs.fileInput.click()
      },
    pickFile () {
      let input = this.$refs.fileInput
      let file = input.files
      if (file && file[0]) {
        let reader = new FileReader
        reader.onload = e => {
          this.previewImage = e.target.result
        }
        reader.readAsDataURL(file[0])
        this.$emit('input', file[0])
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.card {
  font-family: 'Do Hyeon', sans-serif;
  height: 100%;
  width: 100%;
  margin: 10px auto;
  .row {
    height: 100%;
    .image {
      padding: 10px;
      .imagePreviewWrapper {
        width: 100%;
        height: 100%;
        display: block;
        cursor: pointer;
        margin: 0 auto 30px;
        background-size: cover;
        background-position: center center;
      }
    }
    .content { 
      padding: 20px;
      .card-body {
        height: 90%;
        display: flex;
        flex-direction: column;
        .btn-close {
          margin: 0 10px 0 auto;
          padding: 10px
        }
        .card-title {
          margin-top: 20px;
        }
        .card-text {
          min-height: 50%;
        }
      }
      .filebox {
        display: flex;
        justify-content: space-between;
        label { 
        display: inline-block;
        padding: .5em .75em; 
        color: rgb(22, 22, 22); 
        font-size: inherit; 
        line-height: normal; 
        vertical-align: middle; 
        background-color: $primary; 
        cursor: pointer; 
        border-radius: .25em; 
        }
        input[type="file"] { /* 파일 필드 숨기기 */ 
        position: absolute; 
        width: 1px; 
        height: 1px; 
        padding: 0; 
        margin: -1px; 
        overflow: hidden; 
        clip:rect(0,0,0,0); 
        border: 0; 
        }
        .btn {
          margin-right: 30px;
        }
      }
    }
  }
}
</style>