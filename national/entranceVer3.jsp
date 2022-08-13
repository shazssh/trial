<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header_footer/header.html" %>
<%@ page import="bean.National" %>
<%@ page import="dao.NationalDAO" %>


<p>国の情報について、追加または検索をします</p>

<form action="/creatures/controlVer3_servlet" method="post">
-追加-
<br>
国名(重複不可、未入力不可)<br>
<input type="text" name="englishname" size="36"><br>
<br>
首都名<br>
<input type="text" name="capital" size="36"><br>
<br>
首相名（いなければ国家元首名）<br>
<input type="text" name="ministry" size="36"><br>
<br>
<br>
memo<br><textarea name="memo" rows="5" cols="48"></textarea><br>
<br>
<input type ="submit" value="追加"></form>
<br>

<form action="/creatures/controlVer3_servlet" method="post">
<br>
-検索-<br>
国名の一部を入力してください（未入力で全検索）<br>
<input type="text" name="keyword" size="24"><br>
<br>
<input type ="submit" value="検索"></form>
<br>

<%@ include file="../../header_footer/footer.html" %>