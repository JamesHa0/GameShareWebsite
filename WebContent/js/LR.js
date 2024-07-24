window.onload = function() {
	var img = document.getElementById("checkinput");
	img.onclick = function() {
		var date = new Date().getTime();
		img.src = "CheckCodeServlet?" + date;
	}
}

$(function (){
	
    $("#signUp").click(function() {
        $("#dowebok").addClass("right-panel-active");
    });
    $("#signIn").click(function() {
        $("#dowebok").removeClass("right-panel-active");
    });
	// 表单验证
	$(".register").validate({
		rules:{
			utel:{
				required: true,
				rangelength:[11,11],
			},
			upsw:{
				required: true,
				rangelength:[8,20],
			},
			second_pwd:{
				required: true,
				rangelength:[8,20],
				equalTo:"#upsw",
			},
			checkinput:{
				required: true,
			}
		},
		messages:{
			utel:{
				required:"手机号码不能为空",
				rangelength:"请输入正确的手机号",
			},
			upsw:{
				required:'密码不能为空',
				rangelength:"密码长度在8~20位",
			},
			second_pwd:{
				required:'密码不能为空',
				rangelength:"密码长度在8~20位",
				equalTo:'两次密码不同',
			},
			checkinput:{
				required: "验证码不能为空",
			}
		}
	});
	$(".sign").validate({
		rules:{
			utel:{
				required: true,
				rangelength:[11,11],
			},
			upsw:{
				required: true,
				rangelength:[8,20],
			},
			checkinput:{
				required: true,
			}
		},
		messages:{
			utel:'请输入手机号',
			upsw:{
				required:'密码不能为空',
				rangelength:"密码长度在8~20位",
			},
			checkinput:{
				required: "验证码不能为空",
			}
		},
	});
});