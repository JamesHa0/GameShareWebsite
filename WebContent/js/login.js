window.onload = function() {
	var img = document.getElementById("checkinput");
	if (img) { // 确保元素存在
	    img.onclick = function() {
	        var date = new Date().getTime();
	        img.src = "CheckCodeServlet?" + date;
	    }
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
			password:{
				required: true,
				rangelength:[8,20],
			},
			second_pwd:{
				required: true,
				rangelength:[8,20],
				equalTo:"#upsw", // 确保此处与密码字段的 ID 匹配
			}
		},
		messages:{
			utel:{
				required:"手机号码不能为空",
				rangelength:"请输入正确的手机号",
			},
			password:{
				required:'密码不能为空',
				rangelength:"密码长度在8~20位",
			},
			second_pwd:{
				required:'密码不能为空',
				rangelength:"密码长度在8~20位",
				equalTo:'两次密码不同',
			},
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
		},
		messages:{
			utel:'请输入手机号',
			upsw:{
				required:'密码不能为空',
				rangelength:"密码长度在8~20位",
			},
		},
	});
});
