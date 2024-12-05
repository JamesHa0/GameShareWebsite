//x，横滚；y，纵滚
function scrollBehavior(to, from, savedPosition) {
    // console.log('savedPosition是：')
    // console.log(savedPosition)
    if (savedPosition) {
        return savedPosition;
    } else {
    //   const savedScrollPosition = window.sessionStorage.getItem('scrollPosition');
    //   console.log('这是新页面，拿到了上一页面存储的位置：')
    //   console.log(JSON.parse(savedScrollPosition).y)
    //   if (savedScrollPosition !== null) {
    //     return { top: parseInt(JSON.parse(savedScrollPosition).y) };
    //   }
        return { top: 0 };
    }
}

  export default scrollBehavior;