<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta charset="UTF-8">
<title>登录注册</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/LR.css" />
<script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/LR.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
	<!-- 小猪loading -->
	<iframe src="小猪loading.html" id="loadingFrame" style=
	"display: none;width:100%;height:100%;border:none;
	position: fixed;z-index: 1000;"></iframe>
	
	<div class="head">
		<div class="shouye_head">
			<a href="index.jsp" onclick="click_forLoading()">返回首页</a>
		</div>
	</div>
	<div class="dowebok" id="dowebok">
		<!-- 注册 -->
		<div class="form-container sign-up">
			<form action="<%=request.getContextPath() %>/RegisterServlet.do"
				method="post" class="register">
				<h1>注册</h1>
				<input type="text" id="uname" name="uname" placeholder="用户名" />
				<input type="text" id="utel" name="utel" placeholder="手机号*（必填）" maxlength="18"  required/>
				<input type="password" id="upsw" name="upsw" placeholder="请输入密码*（必填）"  required/>
				<input type="password" id="second_pwd" name="second_pwd" placeholder="请再次输入密码" />
				<input name="checkinput" placeholder="点击下方图片刷新（验证码*：必填）" value="" class="checkinput">
				<img id="checkinput" src="CheckCodeServlet" />
				<input  id="uemail" name="uemail" placeholder="邮箱地址"/>

				保密<input type="radio" id="man" checked="checked" name="ugender" value="保密"/>
				男<input type="radio" id="man" name="ugender" value="M"/>
				女<input type="radio" id="woman" name="ugender" value="F"/>
                <input type="text" id="uaddress" name="uaddress" placeholder="地址" /> 

				<button onclick="click_forLoading()">注册</button>
			</form>
		</div>
		<!-- 登录 -->
		<div class="form-container sign-in">
			<form action="LoginServlet.do" method="post" class="sign">
				<h1>登录</h1>
				<input type="text" name="utel" placeholder="手机号" required>
				<input type="password" name="upsw" placeholder="密码" required>
				<input name="checkinput" placeholder="点击下方图片刷新" value="" class="checkinput"  required>
				<img id="checkinput" src="CheckCodeServlet" />
				<a href="jsp_admin/admin_login.jsp">管理员登录</a>

				<button onclick="click_forLoading()">登录</button>
			</form>
		</div>
		<!-- 两边的蒙版 -->
		<div class="overlay-container">
			<div class="overlay">
				<!-- 登录蒙版 -->
				<div class="overlay-panel mask-left">
					<h1>已有帐号？</h1>
					<p>请使用您的手机号进行登录</p>
					<button class="ghost" id="signIn">登录</button>
				</div>
				<!-- 注册蒙版 -->
				<div class="overlay-panel mask-right">
					<h1>没有帐号？</h1>
					<p>立即注册加入我们，和我们一起开始旅程吧</p>
					<button class="ghost" id="signUp">注册</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.html" flush="true" />
</body>
</html>
