<%@page import="kr.co.farmstory2.dao.UserDAO"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 데이터 수신
	request.setCharacterEncoding("UTF-8");
	String uid = request.getParameter("uid");
	
	// DB 조회
	int result = UserDAO.getInstance().selectCountUid(uid);
	
	// Json 생성
	JsonObject json = new JsonObject();
	json.addProperty("result", result);
	
	// Json 출력
	String jsonData = json.toString();
	out.print(jsonData);
%>