<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header_footer/header.html" %>
<%@ page import="bean.National" %>
<%@ page import="java.util.List" %>

<% List<National> list = (List<National>)request.getAttribute("list"); %>

<% for (National n : list) { %>
ID:<%=n.getId() %>  国名:<%=n.getEnglishName() %>  首都名:<%=n.getCapital() %>  首相名（もしくは国家元首名）:<%=n.getMinistry() %><br>
<br>
memo:<br>
<%=n.getMemo() %>
<br><br>
<br>
<% } %>

<%@ include file="../../return/return.jsp" %>


<p>または、IDを元に国情報を変更、削除できます</p>

<form action="/creatures/controlVer3_servlet" method="post">
国id<br><input type="text" name="id"><br>
新しい首都名<br><input type="text" name="capital" size="36"><br>
<br>
<input type="submit" value="変更">
</form>
<br><br>

<form action="/creatures/controlVer3_servlet" method="post">
国id<br><input type="text" name="id"><br>
新しい首相名（もしくは国家元首名）<br><input type="text" name="ministry" size="36"><br>
<br>
<input type="submit" value="変更">
</form>
<br><br>

<form action="/creatures/controlVer3_servlet" method="post">
国id<br><input type="text" name="id"><br>
新しいmemo<br><textarea name="memo" rows="5" cols="48"></textarea><br>
<br>
<input type="submit" value="変更">
</form>
<br><br>

<form action="/creatures/controlVer3_servlet" method="post">
情報を削除したい国id<br><input type="text" name="id"><br>
<br>
<input type="submit" value="削除">
</form>
<br><br>

<%@ include file="../../header_footer/footer.html" %>