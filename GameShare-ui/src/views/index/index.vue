<template>
  <div>
    <!--页眉-->
    <Header />
    <!--搜索栏-->
    <SearchBar />
    <!-- shop（商品栏） -->
    <article class="shop">
      <!-- 轮播图 -->
      <Carousel/>
      <!-- 游戏一览 -->
		  <section class="content">
        <!-- 本站游戏 -->
        <GameGallery :title="'本站游戏'" :data="data_1" />
        <!-- steam站内游戏 -->
        <GameGallery :title="'近期推荐'" :data="data_2" />
        <!-- 也是steam站内游戏 -->
        <GameGallery :title="'高分神作'" :data="data_3" />
		  </section>
	  </article>

    <!--页脚-->
    <Footer />
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import SearchBar from './SearchBar.vue';
import Carousel from '@/views/index/Carousel.vue';
import GameGallery from '@/views/index/GameGallery.vue';
import Footer from '@/components/Footer.vue';

import axios from 'axios';
import { getToken } from '@/assets/js/myPublic.js'
import {mapGetters, mapState} from 'vuex';

export default {
  components: {
    SearchBar,
    Carousel,
    Footer,
    Header,
    GameGallery,
  },
  data() {
      return {
        //‘本站游戏’游戏数据
        data_1:[
            {
              gid:100000001,
              name:"植物大战僵尸",
              img:"/src/assets/game/100000001/1.jpg"
            },
            {
              gid:100000002,
              name:"魔塔2023",
              img:"/src/assets/game/100000002/1.jpg"
            },
            {
              gid:0,
              name:"待定",
              img:"/src/assets/images/gameNotFound.png"
            },
            {
              gid:0,
              name:"待定",
              img:"/src/assets/images/gameNotFound.png"
            },
            
        ],
          //‘近期推荐’游戏数据
        data_2:[
            {
              gid:2420110,
              name:"地平线：西之绝境",
              img:"/src/assets/game/2420110/1.jpg"
            },
            {
              gid:1245620,
              name:"艾尔登法环",
              img:"/src/assets/game/1245620/1.jpg"
            },
            {
              gid:1623730,
              name:"幻兽帕鲁",
              img:"/src/assets/game/1623730/1.jpg"
            },
            {
              gid:2358720,
              name:"黑神话：悟空",
              img:"/src/assets/game/2358720/1.jpg"
            },
        ],
          //‘高分神作’游戏数据
        data_3:[
            {
              gid:205100,
              name:"耻辱系列",
              img:"/src/assets/game/205100/1.jpg"
            },
            {
              gid:413410,
              name:"弹丸论破系列",
              img:"/src/assets/game/413410/1.jpg"
            },
            {
              gid:49520,
              name:"无主之地2",
              img:"/src/assets/game/49520/1.jpg"
            },
            {
              gid:268050,
              name:"恶灵附身",
              img:"/src/assets/game/268050/1.jpg"
            },
        ],
  }
  },
};
</script>

<style scoped>

/**********<!-- shop（商品栏） -->***********/
.shop{
    display: block;
    margin: 10px auto 0px;
    width: 1200px;
}

</style>