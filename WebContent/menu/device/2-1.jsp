<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2022/1/5
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="GB2312"%>
<%@page import="java.sql.*" %>  <%--����java.sql��--%>
<html>
<head>
    <title >��MySQL���ݿ��ж���student��</title>
</head>
<body>
<%
    Connection conn = null;
    Statement stmt = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/shop?characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root","123456");
        stmt = conn.createStatement();

        if(conn != null){
            out.print("���ݿ����ӳɹ���");
            out.print("<br />");
%>
<table border="2">
    <tr>
        <td width="100" user_id="title">�˺�</td>
        <td width="100" username="title">�û���</td>
        <td width="100" password="title">����</td>
        <td width="100" birth="title">��������</td>
        <td width="100" phone="title">��ϵ�绰</td>
        <td width="100" email="title">��������</td>
        <td width="100" address="title">�ջ���ַ</td>
        <td width="100" creationTime="title">�û�ע��ʱ��</td>

    </tr>
    <%
        ResultSet rs = null;
        String sql = "SELECT * FROM user;";  //��ѯ���
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        out.print("��ѯ�����");
        out.print("<br/>");
        while (rs.next()) {%>
    <tr>
        <td width="100" ><%=rs.getString("user_id") %></td>
        <td width="100" ><%=rs.getString("username") %></td>
        <td width="100"><%=rs.getString("password") %></td>
        <td width="100"><%=rs.getString("birth") %></td>
        <td width="100"><%=rs.getString("phone") %></td>
        <td width="100"><%=rs.getString("email") %></td>
        <td width="100"><%=rs.getString("address") %></td>
        <td width="100"><%=rs.getString("creationTime") %></td>

    </tr>
    <%
                }
            }else{
                out.print("����ʧ�ܣ�");
            }
        }catch (Exception e) {
            //e.printStackTrace();
            out.print("���ݿ������쳣��");
        }
    %>
</table>
</body>
</html>


