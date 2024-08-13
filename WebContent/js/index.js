

$(function() {
	/*
左右切换式轮播图示例代码：
  let faceList=$(".faceList");
  let faces=$(".faceList li");
  let len=faces.length;
  let currentIndex=0;
  function currentShow(i){
    //  调整currentIndex:
      if (i >= len) {
          currentIndex = 0;
      } else {
          currentIndex = i;
      }
    let tmp=-currentIndex*100+"%";  //负号-向左移动;索引*100%-向左翻页的数量。
    faceList.css("transform","translateX("+tmp+")");
  }
  //计时器：（默认触发）
  let interval=setInterval(function (){  //设定时间间隔
    currentShow(currentIndex+1);
  },1500);
  faceList.css("transition","transform 0.5s ease-in-out");
	*/
	
	var items = document.getElementsByClassName("item");
	var circles = document.getElementsByClassName("circle");
	var leftBtn = document.getElementById("btn-left");
	var rightBtn = document.getElementById("btn-right");
	var picture = document.querySelector('.picture-area');
	var index = 0;
	var timer = null;

	// 清除class
	var clearclass = function() {
		for (var i = 0; i < items.length; i++) {
			items[i].className = "item";
			circles[i].className = "circle";
			circles[i].setAttribute("num", i);
		}
	}
	
	/* move函数，负责向新的index移动 */
	function move() {
		clearclass();
		items[index].className = "item active";
		circles[index].className = "circle white";
	}
	move();
	// 点击右边按钮切换下一张图片
	rightBtn.onclick = function() {
		if (index < items.length - 1) {
			index++;
		} else {
			index = 0;
		}
		move();
	}
	// 点击左边按钮切换上一张图片
	leftBtn.onclick = function() {
		if (index > 0) {
			index--;
		} else {
			index = items.length - 1;
		}
		move();
	}
	//点击图片进行跳转
	document.getElementById('item').onclick= function(){
		document.querySelector('#loadingFrame').style.display="block";	//小猪loading显示
		
		const gid=items[index].childNodes[0].src.match(/\/(\d+)\//)[1]	//获得img内的游戏gid信息
		window.location.href = 'DetailServlet.do?gid='+gid	//跳转
	}
	// 开始定时器，每隔3.5s自动点击右边按钮，实现轮播
	timer = setInterval(function() {
		rightBtn.onclick();
	}, 3500)
	
	// 点击圆点时，跳转到对应图片
	for (var i = 0; i < circles.length; i++) {
		items[index].style.opacity = 0;
		circles[i].addEventListener("click", function() {
			var point_index = this.getAttribute("num");
			index = point_index;
			move();
		})

	}
	// 鼠标移入定时器变慢
	picture.onmouseover = function() {
		clearInterval(timer);
		timer = setInterval(function() {
			rightBtn.onclick();
		}, 6000)
	}
	// 鼠标移出定时器变快
	picture.onmouseleave = function() {
		clearInterval(timer);
		timer = setInterval(function() {
			rightBtn.onclick();
		}, 3500)
	}
	
	
	
	//通过Ajax，到servlet生成SESSIONID：
	fetch('SESSIONIDGeneratorServlet.do',{
		method:'POST'
	})
	.then(response=> {
		if(!response.ok){
			alert('获取SESSIONID失败')
		}else{
			console.log('获取SESSIONID成功。')
		}
	})
	
	
	
});


