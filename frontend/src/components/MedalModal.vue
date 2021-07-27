<template>
  <div class="black-bg">
    <div class="white-bg">
      <div class="modal-header">
        <button
          @click="closep"
          type="submit"
          class="btn-close"
          aria-label="Close">
        </button>
      </div>
      <div class="modal-body">
        <div class="body-left">
          <div><h2>물구나무</h2></div>
          <div>
            <img
              src="https://t1.daumcdn.net/cfile/tistory/99DBCD4E5A82385D1B"
              width="100px"
              height="100px" />
          </div>
          <div>
            <img
              src="https://mblogthumb-phinf.pstatic.net/20160902_126/rbamtori_1472800583452FW8NT_GIF/helixbar.gif?type=w800"
              width="50px"
              height="50px" />
          </div>
          <div class="dtail-box">
          </div>
        </div>
        <div class="body-right">
          <div><h2>유튜브 등</h2></div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
    name: 'MedalModal',
    methods: {
      closep() {
        this.$parent.showModal()
      },
    }
}
</script>
<style lang="scss" scoped>
  .black-bg {
  width: 100%; height: 100%;
  background-color: rgba(59, 54, 48, 0.205);

  z-index: 1000;
  position: fixed; padding: 20px;
  top: 0px;
  left: 0px;
  .white-bg {
    width: 50%; 
    height: 70%;
    margin-left: 25%;
    margin-top: 10%;
    background: white;
    opacity: 1;
    border-radius: 8px;
    padding: 20px;
    display: flex;
    flex-direction: column;

    .modal-header {
      width: 100%;
      height: 20px;
    }
    .modal-body {
      display: flex;
      justify-content: space-around;
      .body-left {
        width: 50%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;

        .dtail-box {
          width: 100%;
          height: 80%;
          
          background-color: #f7e6ae;
          border-radius: 5px;
          
        }
      }
      .body-right {
        border: 2px, black, solid;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
      }


    }
  }

}
</style>