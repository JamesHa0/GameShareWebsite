<template>
  <div>
    <!--页眉-->
    <Header />
    <!--搜索栏-->
    <!-- {{count}}
    <button @click="add">+1</button>
    <ul>
      <li v-for="todo in doneTodos" :key="todo.id">{{todo.text}}</li>
    </ul> -->
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
import {getToken} from '@/public.js';

import {mapGetters, mapState} from 'vuex';

export default {
  components: {
    SearchBar,
    Carousel,
    Footer,
    Header,
    GameGallery,
  },
  created() {
    let Token = localStorage.getItem('Token');
    this.uid = getToken(Token).sub;
    this.fetchUser(this.uid);
  },
  mounted() {
    // this.login(); 
    // axios.post('http://localhost:8080/game/100000001',{},{
    //   headers: {
    //     'Authorization': 'Bearer eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJzdWIiOiJyb290IiwiaWF0IjoxNzI3NzY1MTE3LCJleHAiOjE3MjgzNjk5MTd9.9TZ2fb4QplqTvPeiyBf6KiOckfX1wcvrTYRXu8uShJg',
    //   }
    // })
    //     .then(res=>{
    //         console.log('这里是res：');
    //         console.log(res);
    //         let token = res.data.data.token;
    //         console.log('这里是token：');
    //         console.log(token);
    //         this.token=token;

            // if(this.token){
            //     // 将token存储在本地存储中以便后续使用
            //     localStorage.setItem('token', this.token);
            //     let decodedToken = parseJwt(this.token);
            //     console.log('这里是解析后的token：');
            //     console.log(decodedToken);
            //     this.uid = decodedToken.sub; // 使用 sub 字段（JWT主题）
            //     this.uname = decodedToken.uname; // 使用自定义声明 uname
            //     this.urole = decodedToken.urole; // 使用自定义声明 urole
            // }
        // })
        // .catch(err=>{
        //     console.log(err);
        // })
  },
  
  data() {
      return {
        uid:null,
        user:null,
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

  computed:{
    ...mapState ([
      //映射 this.count 为 store.state.count
      // 'count','todos',
      // 'isLogin'
    ]),
    // ...mapGetters([
    //   'doneTodos'
    // ])
  },
  methods:{
    fetchUser(){
      axios.get('/user/' + this.uid)
      .then(response => {
        // console.log('响应数据data = :', response.data);
        this.user = response.data;
        this.$store.dispatch('setUser', this.user);   // 触发action，异步提交mutation，往vuex中存入user
      })
      .catch(error => {
        console.error('请求失败:', error);
      });
    }
    // add(){
    // 调用mutations中的increment，传参n=2
    //   this.$store.commit("increment" , 3) 
    // }
  }
};
</script>

<style>

/**********<!-- shop（商品栏） -->***********/
.shop{
    display: block;
    margin: 10px auto 0px;
    width: 1200px;
}

</style>