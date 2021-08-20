<template>
  <div style="overflow:auto; height: 160px;">
    <!-- <span class="scroll">{{ scrollY }}</span> -->
    <ul
      ref="list"
      :style="getStyle">
      <li
        v-for="item of displayList"
        :key="item.index"
        :item="item.index">
        {{ item.name }} : &nbsp;{{ item.description }}
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      dummy: [],
      sample: {
        name: '김싸피',
        description: '오 저랑 비슷하게 운동하시네요!',
      },
      startIdx: 0,
      endIdx: 1,
      paddingTop: 0,
      paddingBottom: 0,
      scrollY: 0,
      defaultHeight: 1,
    }
  },
  created() {
    for (let i = 0 ; i < 100; i++) {
      this.dummy.push({
        ...this.sample,
        index: i,
      });
    }
    this.paddingBottom = this.defaultHeight * this.dummy.length - this.endIdx;
  },
  mounted() {
    window.addEventListener('scroll', this.onScroll);
  },
  beforeUnmount() {
    window.removeEventListener('scroll', this.onScroll);
  },
  computed: {
    getStyle() {
      return {
        paddingTop: `${this.paddingTop}px`,
        paddingBottom: `${this.paddingBottom}px`,
      }
    },
    displayList() {
      return this.dummy.slice(this.startIdx, this.endIdx);
    }
  },
  methods: {
    onScroll() {
      this.scrollY = window.scrollY;
      this.startIdx = Math.floor(this.scrollY / this.defaultHeight);
      this.endIdx = Math.min(this.dummy.length, this.startIdx + 1);
      this.paddingTop = this.defaultHeight * this.startIdx;
      this.paddingBottom = this.defaultHeight * (this.dummy.length - this.endIdx);
    }
  }
}
</script>
<style scoped>
.scroll {
  position: fixed;
  top: 10px;
  font-size: 20px;
  font-weight: bold;
}
ul {
  list-style-type: none;
  padding-left: 0;
}
li {
  display: block;
  margin: 0 10px;
  padding: 5px;
}
</style>