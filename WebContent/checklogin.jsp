<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

<title>loading</title>
</head>
<body>
	<p>正在检查...</p>
	<%@page import="java.sql.*" %>
	<%
	String role=request.getParameter("role");
	String name=request.getParameter("name");
	String paswd=request.getParameter("paswd");
	boolean flag =true;
	%>
	<%
	//Class.forName("oracle.jdbc.driver.OracleDriver");
	//String url="jdbc:oracle:thin:@localhost:1521:orcl";
	//String user="system";
	//String password="Qwe5201314";
	//Connection conn = DriverManager.getConnection(url,user,password);
	//Statement stmt=conn.createStatement();
	//String sql="select * from userinfo where username= '"+name+"' and password='"+paswd+"'and identify='"+role+"'";
	//ResultSet rs =stmt.executeQuery(sql);
	//boolean flag=false;
	//if(rs.next()){
	//	flag=true;
	//}
	//if(flag==true)
	//	out.println("yes");
	%>
	<%
	if(flag&&role.equals("店员")){
		out.println("用户："+name+"欢迎登录！");
	%>
	<a href="homepage.jsp">点此跳转</a>
	<%
	}
	if(flag&&role.equals("管理员")){
		out.println("用户："+name+"欢迎登录！");
	%>
	<a href="managerhomepage.jsp">点此跳转</a>
	<%
	}%>
	
	
	
	
</body>
</html>