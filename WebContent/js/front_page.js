/*var index = $(this).index();
index=0;

$(function() {
	//节流阀 互斥锁
	var flag = true;
	// 导航栏显示隐藏
	let boxTop = $(".nei").offset().top;
	toggleTool();
	function toggleTool(){
		if ($(document).scrollTop() >= boxTop){
			$(".nav").fadeIn(800);
		}else {
			$(".nav").fadeOut(800);
		}
	};
	//页面滚动
	$(window).scroll(function(){
		// console.info($(document).scrollTop());
		toggleTool();
		//滚动到相应区域，导航栏颜色随之变化
		if(flag) {
			$(".nei .w").each(function(i,e){
				if($(document).scrollTop() >= $(e).offset().top){
					// console.info(i);
					$(".nav li").eq(i).addClass("current").siblings().removeClass("current");
				}
			})
		}
	});
	// 返回顶部
	$(".back").click(function(){
		$("body,html").stop().animate({
			scrollTop:0,
		});
	});
	// 导航栏点击跳转到相应页面
	$(".nav li").click(function() {
		flag = false;
		console.info($(this).index());
		let current = $(".nei .w").eq($(this).index()).offset().top;
		$("body,html").stop().animate({
			scrollTop:current
		},function (){
			flag = true;
		});
		//点击之后，让当前li 添加current类名，兄弟节点移除current类名
		$(this).addClass("current").siblings().removeClass("current");
	})
	//使用 判断index范围
	$("#right").click(function (){
		index++;
		console.info(index);
		// console.info('1');
		$("#lunbo div ").eq(index).stop().slideDown(100).siblings().stop().slideUp(100);
	});
	$("#left").click(function (){
		index--;
		console.info(index);
		$("#lunbo div ").eq(index).stop().slideDown(100).siblings().stop().slideUp(100);
	});
});



*/

window.onload = function() {
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
	/* 只显示一个class */
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
	// 开始定时器，点击右边按钮，实现轮播
	timer = setInterval(function() {
		rightBtn.onclick();
	}, 3500)
	// 点击圆点时，跳转到对应图片
	for (var i = 0; i < circles.length; i++) {
		circles[i].addEventListener("click", function() {
			var point_index = this.getAttribute("num");
			index = point_index;
			move();
		})

	}
	// 鼠标移入清除定时器
	picture.onmouseover = function() {
		clearInterval(timer);
		timer = setInterval(function() {
			rightBtn.onclick();
		}, 6000)
	}
	// 鼠标移出又开启定时器
	picture.onmouseleave = function() {
		clearInterval(timer);
		timer = setInterval(function() {
			rightBtn.onclick();
		}, 3500)
	}
	
}