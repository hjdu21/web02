<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% int i = 0; %>
<head>
<meta charset="UTF-8">
<% 
int j = 20;
int sum = 0;
%>
<title>JSP</title>
</head>
<body>
<%
sum = i + j;
%>
<h1>스크립트릿</h1>
<ul>
  <li>자바 코드를 삽입시키는 JSP 태그이다.
  <li>_jspService() 메서드 안에 선언된 순서대로 삽입된다.
  <li>작성한 코드가 그대로 복사된다.
  <li>메서드 안에 작성할 수 있는 자바 문법은 100% 가능
</ul>
<% out.println("sum= " + sum); %>
<p>
<%
String[] names = {"홍길동", "임꺽정", "이순신", "권율"};
for (String name : names) {
 out.write(name); %>
 <br>
<% } %>
</p>
</body>
</html>