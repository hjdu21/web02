<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<% int i = 10;
   int j = 20;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<h1>표현식(expression element)</h1>
<ul>
  <li>_jspService() 메서드 안에 출력문으로 변환되어 들어간다
  <li>태그 안의 자바 코드가 그대로 출력문의 파라미터 자리에 놓인다.
  <li>예 ) sum = <%=i + j%>
</ul>
<%-- JSP 주석 
=> 클라이언트로 출력되지 않는다.

# JSP 표현식
<%= 자바코드 %> ===> out.print(자바코드);
=>  out.print()의 파라미터 자리에 올 수 있는 자바 코드는 모두 가능하다.
 --%>
<!-- HTMl 주석 => 템플릿 데이터이다. -->
</body>
</html>