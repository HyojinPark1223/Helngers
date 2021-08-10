<template>
  <label class="file-select">
    <div class="select-button btn btn-danger">
      <span>이미지 선택</span>
    </div>
    <input
      type="file"
      @change="handleFileChange" />
  </label>
</template>

<script>
export default {
  props: {
    value: File
  },
  methods: {
    handleFileChange(e) {
      this.$emit('input', e.target.files[0])
    }
  }
}
</script>

<style lang="scss" scoped>
.file-select {
  .select-button {
    color: white;
    border-radius: .3rem;
    text-align: center;
  }
  input[type="file"] {
    display: none;
  }
}
</style>