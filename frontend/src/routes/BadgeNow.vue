<template>
  <div class="MYBADGENOW">
    <div class="wrap">
      <div class="medal-wrap1">
        <div class="medal-card">
          <div class="box">
            <div class="our-services settings">
                <div class="icon"> <img src="https://t1.daumcdn.net/cfile/tistory/99DBCD4E5A82385D1B" width="100px" height="100px"> </div>
                <h4>물구나무</h4>
                <p>8/10</p>
            </div>
          </div>
        </div>
        <div class="medal-card">
          <div class="box">
            <div class="our-services settings">
                <div class="icon"> <img src="https://t1.daumcdn.net/cfile/tistory/99DBCD4E5A82385D1B" width="100px" height="100px"> </div>
                <h4>물구나무</h4>
                <p>8/10</p>
            </div>
          </div>
        </div>
        
        <div class="medal-card">
          <div class="box">
            <div class="our-services settings">
                <div class="icon"> <img src="https://t1.daumcdn.net/cfile/tistory/99DBCD4E5A82385D1B" width="100px" height="100px"> </div>
                <h4>물구나무</h4>
                <p>8/10</p>
            </div>
          </div>
        </div>
        <div class="medal-card">
          <div class="box">
            <div class="our-services settings">
                <div class="icon"> <img src="https://t1.daumcdn.net/cfile/tistory/99DBCD4E5A82385D1B" width="100px" height="100px"> </div>
                <h4>물구나무</h4>
                <p>8/10</p>
            </div>
          </div>
        </div>
      </div>
      <div class="medal-wrap1">
        <div class="medal-card">
          <div class="box">
            <div class="our-services settings">
                <div class="icon"> <img src="https://t1.daumcdn.net/cfile/tistory/99DBCD4E5A82385D1B" width="100px" height="100px"> </div>
                <h4>물구나무</h4>
                <p>8/10</p>
            </div>
          </div>
        </div>
        <div class="medal-card">
          <div class="box">
            <div class="our-services settings">
                <div class="icon"> <img src="https://t1.daumcdn.net/cfile/tistory/99DBCD4E5A82385D1B" width="100px" height="100px"> </div>
                <h4>물구나무</h4>
                <p>8/10</p>
            </div>
          </div>
        </div>
        <div class="medal-card">
          <div class="box">
            <div class="our-services settings">
                <div class="icon"> <img src="https://t1.daumcdn.net/cfile/tistory/99DBCD4E5A82385D1B" width="100px" height="100px"> </div>
                <h4>물구나무</h4>
                <p>8/10</p>
            </div>
          </div>
        </div>
        <div class="medal-card">
          <div class="box">
            <div class="our-services settings">
                <div class="icon"> <img src="https://t1.daumcdn.net/cfile/tistory/99DBCD4E5A82385D1B" width="100px" height="100px"> </div>
                <h4>물구나무</h4>
                <p>8/10</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css?family=Poppins|Ubuntu&display=swap');
.MYBADGENOW {
  font-family: 'Do Hyeon', sans-serif;
  width: 100%;
  height: 100%;
  z-index: 1;
  position: relative;
  padding: 60px 0;
  display: flex;
  justify-content: space-around;
  
  ::after {
    width: 100%;
    height: 100%;
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    z-index: -1;
    background: url('https://url.kr/na8mq2') no-repeat center center fixed;
    background-size: cover;
    opacity: 0.8;
  }
  .wrap {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    /* width: 500px;// */
    height: 800px;
    width: 80%;
    padding-top: 10px;
  
    /* border: 5px black solid; */
    .medal-wrap1, medal-wrap2 {
      height: 300px;
      /* border: 3px black solid; */
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;
      .medal-card {
        height: 60%;
        width: 300px;
        margin-right: 10px;
        margin-left: 10px;
        /* border: 3px black solid; */
        .box {
          position: relative;
          width: 100%;
          padding-right: 15px;
          padding-left: 15px;
          .our-services:hover h4,
          .our-services:hover p {
              color: #fff
          }
          .our-services {
            margin-top: 75px;
            padding-bottom: 30px;
            padding: 0 60px;
            min-height: 198px;
            text-align: center;
            border-radius: 30px;
            background-color: #fff;
            transition: all .4s ease-in-out;
            box-shadow: 0 0 25px 0 rgba(20, 27, 202, .17);
            .icon {
              margin-bottom: -21px;
              transform: translateY(-50%);
              text-align: center
            }
          }
          .settings:hover {
            box-shadow: 0 0 25px 0 rgba(20, 27, 201, .05);
            cursor: pointer;
            background-image: linear-gradient(-45deg, #dbb023 0%, #e2cc85 100%)
        }
        }
      }
    }

  }

}

</style>