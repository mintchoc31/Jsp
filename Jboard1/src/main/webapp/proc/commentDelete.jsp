<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	// 수신

	ArticleDAO dao = new ArticleDAO();
	dao.deleteComment(no);

	// 리다이렉트
	
%>