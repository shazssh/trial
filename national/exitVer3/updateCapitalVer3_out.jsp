<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header_footer/header.html" %>
<%@ page import="bean.National" %>

<% National n = (National)request.getAttribute("national"); %>

新しい首都名<br><%=n.getCapital() %><br>
<br>に変更しました

<%@ include file="../../return/return.jsp" %>

<%@ include file="../../header_footer/footer.html" %>
