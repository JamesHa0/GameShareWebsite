<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>登录注册</title>
        <link rel="stylesheet" type="text/css" href="css/public.css"/>
        <link rel="stylesheet" type="text/css" href="css/LR.css"/>
        <script src="js/jquery-3.6.0.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="js/login.js" type="text/javascript" charset="utf-8"></script>

    </head>
    <body>
        <div class="head">
            <div class="shouye_head">
                <a href="index.jsp">返回首页</a>
            </div>
        </div>
        <div class="dowebok" id="dowebok">
            <!-- 注册 -->
            <div class="form-container sign-up">
                <form action="<%=request.getContextPath() %>/registServlet.do" method="post" class="register">
                    <h1>注册</h1>
                    <input type="text"  id="uname" name="uname" placeholder="用户名" />
        
                    <input type="text"  id="utel" name="utel" placeholder="手机号（必填）" />
       
                    <input type="password" id="upsw" name="upsw" placeholder="请输入密码" />
       
                    <input type="password" id="second_pwd" name="second_pwd" placeholder="请再次输入密码" />
       
                    <input type="email" id="uemail" name="uemail" placeholder="邮箱地址">
                    
                    <!-- <input type="radio" id="man" checked="checked" name="ugender"/>男<input type="radio" id="woman" name="ugender">女
                    
                    <input type="text" id="uaddress" name="uaddress" placeholder="地址" /> -->
       
                    <button>注册</button>
                </form>
            </div>
            <!-- 登录 -->
            <div class="form-container sign-in">
                <form action="loginServlet.do" method="post" class="sign">
                    <h1>登录</h1>
                    <input type="text" name="utel" placeholder="手机号">
                    <input type="password"  name="upsw" placeholder="密码">
                    <a href="jsp_admin/admin_login.jsp">管理员登录</a>
                    <button>登录</button>
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
    </body>
</html>
