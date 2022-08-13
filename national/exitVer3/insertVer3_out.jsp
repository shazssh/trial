<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header_footer/header.html" %>
<%@ page import="bean.National" %>

<% National n = (National)request.getAttribute("national"); %>

国名<br>
<%=n.getEnglishName() %><br>
首都名<br><%=n.getCapital() %><br>
首相名（もしくは国家元首名）<br><%=n.getMinistry() %><br>
<br>
memo<br>
<%=n.getMemo() %><br>
<br>を追加しました

<%@ include file="../../return/return.jsp" %>

<%@ include file="../../header_footer/footer.html" %>
