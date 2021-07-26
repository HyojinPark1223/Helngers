<template>
	<div v-if="modalChk">
		<MedalModal/>
	</div>
	<div class="medal-card">
		<div class="box">
			<div class="our-services settings" @click="showModal">
				<div class="icon"> 
					<img src="https://t1.daumcdn.net/cfile/tistory/99DBCD4E5A82385D1B" width="100" height="100"> 
				</div>
				<h4>물구나무</h4>
				<p>8/10</p>
			</div>
		</div>
	</div>
</template>
<script>
import MedalModal from './MedalModal'

export default {
	name: 'MedalCard',
	components: {
		MedalModal,
	},
	data() {
		return {
      modalChk: false
		}
	},
	methods: {
		showModal() {
			this.modalChk = !this.modalChk
		}
	},
}
</script>
<style lang="scss" scoped>
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
                margin-top: 30px;
                padding-top: 40px;
                padding-bottom: 30px;
                padding: 0 60px;
                min-height: 198px;
                text-align: center;
                border-radius: 30px;
                background-color: #fff;
                transition: all .4s ease-in-out;
                box-shadow: 0 0 25px 0 rgba(20, 27, 202, .17);
                .icon {
                    margin-bottom: -10px;
                    transform: translateY(-50%);
                    text-align: center;
                }
            }
            .settings:hover {
                box-shadow: 0 0 25px 0 rgba(20, 27, 201, .05);
                cursor: pointer;
                background-image: linear-gradient(-45deg, #dbb023 0%, #e2cc85 100%)
            }
        }
    }
</style>