<template>
  <div>
    <h1>파일 업로더</h1>
    <input
      type="file"
      id="file-selector"
      ref="file"
      @change="handleFileUpload()" />
    <button
      @click="upload"
      color="primary"
      flat>
      업로드
    </button>
  </div>
</template>

<script>
import AWS from 'aws-sdk'

export default {
  data() {
    return {
      file: null,
      albumBucketName: "helngers",
      bucketRegion: "ap-northeast-2",
      IdentityPoolId: "ap-northeast-2:5055eafa-ec30-43d2-a704-76d56874724a"
    }
  },
  methods: {
    handleFileUpload() {
      this.file = this.$refs.file.files[0]
      console.log(this.file, '파일이 업로드')
    },
    upload() {
      AWS.config.update({
      region: this.bucketRegion,
      credentials: new AWS.CognitoIdentityCredentials({
        IdentityPoolId: this.IdentityPoolId
      })
    })

    const s3 = new AWS.S3({
      apiVersion: "2006-03-01",
      params: { Bucket: this.albumBucketName }
    })

    let photoKey = this.file.name
    //
    s3.upload({
      Key: photoKey,
      Body: this.file,
      ACL: 'public-read'
    }, (err, data) => {
      if (err) {
        console.log(err)
        return alert('There was an error', err.message);
      }
      alert('Successfully uploaded photo.');
      console.log(data)
    })

    // Use S3 ManagedUpload class as it supports multipart uploads
    // var upload = new AWS.S3.ManagedUpload({
    //   apiVersion: "2006-03-01",
    //   params: {
    //     Bucket: this.albumBucketName,
    //     Key: photoKey,
    //     Body: this.file
    //   }
    // });

    // var promise = upload.promise();

    // promise.then(
    //   function(data) {
    //     alert("Successfully uploaded photo.");
    //     console.log(data)
    //   },
    //   function(err) {
    //     console.log(err)
    //     return alert("There was an error uploading your photo: ", err.message);
    //   }
    // );

    }
  }
}
</script>

<style>

</style>