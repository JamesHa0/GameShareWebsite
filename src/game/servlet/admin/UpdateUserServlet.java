package game.servlet.admin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.User;
import game.bean.UserLog;
import game.dao.UserDaoImpl;
import game.other.MD5;

/**
 * Servlet implementation class UpdateUserServlet
 * 用于处理更新用户信息的Servlet
 */
@WebServlet("/UpdateUserServlet.do")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDaoImpl daoImp; // 用户数据访问对象

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        daoImp = new UserDaoImpl(); // 初始化用户数据访问对象
    }

    /**
     * 处理GET请求，接收用户信息更新请求
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserLog userLog = new UserLog(); // 用户操作日志对象
        
        // 获取前端传递的参数
        String uid = request.getParameter("uid"); // 用户ID
        String uname = request.getParameter("uname"); // 用户名
        String utel = request.getParameter("utel"); // 用户电话
        String uemail = request.getParameter("uemail"); // 用户邮箱
        String urole = request.getParameter("urole_" + uid); // 用户角色（注意特殊处理）
        if (urole == null) urole = request.getParameter("urole"); // 处理未传入特定用户角色情况
        String ugender = request.getParameter("ugender"); // 用户性别
        String uaddress = request.getParameter("uaddress"); // 用户地址
        String upsw = request.getParameter("upsw"); // 用户密码
        String upoint = request.getParameter("upoint"); // 用户积分

        // 如果密码未加密（假设未加密的密码长度小于等于18），则进行MD5加密
        if (upsw.length() <= 18) {
            try {
                upsw = MD5.MD5Encoder(upsw);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("！Servlet-update：加密报错。");
            }
        }
        
        // 测试用例中的管理员登录信息（可根据实际情况修改）
        String Login_uid = "114514"; // 登录用户ID
        String Login_urole = "admin"; // 登录用户角色
        String Login_uname = "管理员先生"; // 登录用户名

        // 创建User对象，准备更新用户信息
        User user = new User(uid, uname, utel, uemail, urole, ugender, uaddress, upsw, upoint);
        try {
            // 调用数据访问对象更新用户信息，获取更新结果
            int updateResult = daoImp.updateUserByUid(user); 
            if (updateResult <= 0) {
                System.out.println("!插入失败。");
                // 记录用户操作日志：修改User信息失败
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "修改User信息", "失败");
                response.setStatus(500); // 设置响应状态码500，表示服务器内部错误
            } else {
                // 记录用户操作日志：修改User信息成功
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "修改User信息", "成功");
                response.setStatus(200); // 设置响应状态码200，表示成功
            }
        } catch (Exception e) {
            System.out.println("!500 Servlet-user-update");
            response.setStatus(500); // 设置响应状态码500，表示服务器内部错误
        }
    }

    /**
     * 处理POST请求，调用doGet方法处理
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
