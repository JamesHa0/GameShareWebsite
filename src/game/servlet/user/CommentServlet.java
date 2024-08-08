package game.servlet.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import game.bean.Comment;
import game.bean.UserLog;
import game.dao.CommentDaoImpl;

//用于写/回复评论入库（action=writeComment）的servlet。Ajax。
//或者是点赞入库。
@WebServlet("/CommentServlet.do")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLog userLog=new UserLog();
		CommentDaoImpl commentDaoImpl=new CommentDaoImpl();
		//从Cookie获取当前登录者信息：
        String Login_uid = "0";
        String Login_uname = "获取cookie（Login_uname）失败";
        String Login_urole = "获取cookie（Login_urole）失败";
        Cookie[] cookie=request.getCookies();
        if(cookie !=null) {
        	for(Cookie c:cookie) {
        		if("Login_uid".equals(c.getName())) {
        			Login_uid=c.getValue();
        		}else if("Login_uname".equals(c.getName())) {
        			Login_uname=c.getValue();
        		}else if("Login_urole".equals(c.getName())) {
        			Login_urole=c.getValue();
        		}
        	}
        }
        if("0".equals(Login_uid)) {//见鬼了
        	System.out.println("没登录呢还");
        	response.sendRedirect("LR.jsp");
        	return;
        }
        
        
System.out.println("来到了commentservlet。");
        //前端数据6参：
        String new_uid=request.getParameter("uid");
        String new_gid=request.getParameter("gid");
        String new_uname=request.getParameter("uname");
        String new_comment=request.getParameter("comment");
        String cid=request.getParameter("cid_upper");
        String cpath=request.getParameter("cpath_upper");
        String uname_upper=request.getParameter("uname_upper");	//从js拿来的7个参数
System.out.println("uname_upper="+uname_upper);
        //手搓2参：
        String new_clike="0";	//7：刚发表评论，赞为0
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String new_ctime=sdf.format(new Date());	//8：时间
        //处理cparentid、cpath、uname：
        String new_cparentid="null".equals(cid)? null: cid;	//传来的null值会被转化为字符串'null'，所以需要这步
        String new_cpath;
        if(cpath==null || "null".equals(cpath)) {//同上
        	new_cpath="99999["+new_ctime+"]";
        }else {
        	new_cpath=cpath+"#["+new_ctime+"]";
        }
        if(uname_upper!=null && !"null".equals(uname_upper)){	//确存在回复人的姓名
        	new_uname+="&nbsp;&nbsp;回复&nbsp;&nbsp;"+uname_upper.split("\u00A0\u00A0回复\u00A0\u00A0")[0].trim();
System.out.println("切割后的uname是："+uname_upper.split("\u00A0\u00A0回复\u00A0\u00A0")[0].trim());	//【&nbsp;】在Java中以非破折号空格（Unicode即【\u00A0】）呈现
        }
        
        //判断是否是点赞业务：
        String likeChange=request.getParameter("likeChange");
        if("null".equals(likeChange) || likeChange==null) {	//不是点赞业务，走评论业务
        	try {//写评论入库
    			Comment comment_preInsert=new Comment(new_uid, new_gid, new_uname, new_ctime, new_comment, new_clike, new_cparentid, new_cpath);
    			Comment comment_inserted=commentDaoImpl.insertComment(comment_preInsert);
System.out.println("插入评论为："+comment_inserted);
    			if(comment_inserted==null) {
    				response.setStatus(204);//204 No Content - 服务器成功处理了请求，但没有返回任何内容。
    			}else {
    				//response返回json，供给detail.js使用
    				String json = new Gson().toJson(comment_inserted);//comment_inserted是有cid的。
    			    response.setContentType("application/json");
    			    response.setCharacterEncoding("UTF-8");
    			    response.getWriter().write(json);
    			    
    		        response.setStatus(200);
    			}
    		} catch (Exception e) {
    			System.out.println("!500 Servlet-comment-2");
    			userLog.logOperation(Login_uid, Login_uname, Login_urole, "写评论入库：500", "失败");
    			response.setStatus(500);
    			return;
    		}
        }else {	//点赞业务
        	//cid,likeChange,cpath
        	cid=request.getParameter("cid");
        	cpath=request.getParameter("cpath");
        	if( !cpath.contains("#")) { //一级评论
        		String prefix = 99999-Integer.parseInt(likeChange)+"";
        		int startIndex = cpath.indexOf('['); // 查找 '[' 的索引
        	    String suffix = cpath.substring(startIndex);
        	    String likeChanged_cpath=prefix+suffix;	//更新cpath
        	    Comment part_comment = new Comment(cid, null, null, null, null, null, likeChange , null, likeChanged_cpath);
        	    try {
					if(commentDaoImpl.updateComment(part_comment)>0) {
						response.setStatus(200);
					}else {
						response.setStatus(204);
					}
				} catch (Exception e) {
					System.out.println("!500 Servlet-comment_like");
					e.printStackTrace();
					response.setStatus(500);
					return;
				}
        	}
        }
        
        

        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
