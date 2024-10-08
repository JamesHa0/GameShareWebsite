<template>
  <!-- 轮播图 -->
  <section class="carousel">
    <div class="picture-area">
      <ul id="item">
        <li class="item" v-for="(image, index) in images" :key="index">
          <img :src="image.src" @click="handleClick(index)">
        </li>
      </ul>
    </div>
    <div id="btn-left" @click="prevImage">&lt;</div>
    <div id="btn-right" @click="nextImage">&gt;</div>
    <ul id="circle">
      <li class="circle" v-for="(circle, idx) in circles" :key="idx" @click="selectCircle(idx)"></li>
    </ul>
  </section>
</template>

<script>
export default {
  data() {
    return {
      images: [
        { src: '/src/assets/game/1091500/1.jpg' },
        { src: '/src/assets/game/1086940/1.jpg' },
        { src: '/src/assets/game/1245620/1.jpg' },
        { src: '/src/assets/game/1174180/1.jpg' },
        { src: '/src/assets/game/2358720/1.jpg' }
      ],
      currentIndex: 0,
      timer: null
    };
  },
  computed: {
    circles() {
      return new Array(this.images.length).fill(null);
    }
  },
  // methods: {
  //   clearClass() {
  //     this.images.forEach((_, i) => {
  //       this.$set(this.images[i], 'className', 'item');
  //       this.$set(this.circles[i], 'className', 'circle');
  //     });
  //   },
    // move(index) {
    //   this.clearClass();
    //   this.currentIndex = index;
    //   this.$set(this.images[this.currentIndex], 'className', 'item active');
    //   this.$set(this.circles[this.currentIndex], 'className', 'circle white');
    // },
    // nextImage() {
    //   if (this.currentIndex < this.images.length - 1) {
    //     this.currentIndex++;
    //   } else {
    //     this.currentIndex = 0;
    //   }
    //   this.move(this.currentIndex);
    // },
    // prevImage() {
    //   if (this.currentIndex > 0) {
    //     this.currentIndex--;
    //   } else {
    //     this.currentIndex = this.images.length - 1;
    //   }
    //   this.move(this.currentIndex);
    // },
    // handleClick(index) {
    //   const gid = this.images[index].src.match(/\/(\d+)\//)[1];
    //   window.location.href = `DetailServlet.do?gid=${gid}`;
    // },
    // selectCircle(index) {
    //   this.currentIndex = index;
    //   this.move(index);
    // },
    // startTimer() {
    //   this.timer = setInterval(() => {
    //     this.nextImage();
    //   }, 3500);
  //   },
  //   stopTimer() {
  //     clearInterval(this.timer);
  //   }
  // },
  // mounted() {
  //   this.move(0);
  //   this.startTimer();
  // },
//   watch: {
//     '$el': {
//       handler: function () {
//         const pictureArea = this.$el.querySelector('.picture-area');
//         pictureArea.addEventListener('mouseover', () => {
//           this.stopTimer();
//           this.timer = setInterval(() => {
//             this.nextImage();
//           }, 6000);
//         });
//         pictureArea.addEventListener('mouseleave', () => {
//           this.stopTimer();
//           this.startTimer();
//         });
//       },
//       immediate: true
//     }
//   }
};
</script>

<style scoped>
.carousel {
  margin: 0 auto;
  display: block;
  margin: 0px auto;
  padding-top: 0px;
  width: 888px;
  border: 1px solid #0a3b86;
  height: 500px;
  overflow: hidden;
  position: relative;
}

.picture-area {
  display: flex;
  float: left;
  position: relative;
}

.carousel img {
  width: 888px;
}

#item {
  width: 100%;
  height: 100%;
}

.item {
  position: absolute;
  opacity: 0.2;
  transition: all 2s;
  list-style-type: none;
}

.active {
  opacity: 1 !important;
}

#btn-left {
  user-select: none;
  width: 30px;
  height: 75px;
  font-size: 30px;
  color: white;
  background-color: rgba(0, 0, 0, 0.4);
  line-height: 75px;
  padding-left: 5px;
  z-index: 999;
  position: absolute;
  left: 0px;
  top: 225px;
  cursor: pointer;
  opacity: 0;
}

.picture:hover #btn-left {
  opacity: 1;
}

#btn-right {
  user-select: none;
  width: 30px;
  height: 75px;
  font-size: 30px;
  color: white;
  background-color: rgba(0, 0, 0, 0.4);
  line-height: 75px;
  padding-left: 5px;
  z-index: 10;
  position: absolute;
  right: 0px;
  top: 225px;
  cursor: pointer;
  opacity: 0;
}

.picture:hover #btn-right {
  opacity: 1;
}

#circle {
  height: 20px;
  display: flex;
  position: absolute;
  top: 470px;
  right: 5px;
}

.circle {
  width: 10px;
  height: 10px;
  border-radius: 10px;
  border: 2px solid white;
  background: rgba(0, 0, 0, 0);
  cursor: pointer;
  margin: 5px;
  list-style-type: none;
}

.white {
  background-color: #FFFFFF;
}
</style>