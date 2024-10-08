import { createStore } from 'vuex'

// 创建一个新的 store 实例
const store = createStore({
  state () {
    return {
      user: null,

      // count: 0,
      // todos: [
      //   { id: 1, text: '吃饭', done: true },
      //   { id: 2, text: '睡觉', done: false }
      // ]
    }
  },
  mutations: {
    setUserData(state, data) {
      state.user = data;
    }
    // setLogin(state, status) {
    //   state.isLogin = status;  // 更改登录状态
    // },

    // increment (state,n) {
    //   state.count+=n
    // }
  },
  actions: {
    setUser({ commit }, data) {
      commit('setUserData', data);
    }
  },
  // getters: {
  //   doneTodos: state => {
  //     return state.todos.filter(todo => todo.done)
  //   }
  // }
})


export default store