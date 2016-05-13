<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<h1>선언문 (declaration element)</h1>
<ul>
  <li> 태그 안에 작성한 코드는 클래스의 블록 안에 복사된다. 
  <li> 클래스 맴버를 선언할 때 주로 사용한다.
  <li> 10 + 20 = <%=plus(10,20) %>
</ul>
</body>
</html>
<%!
// 선언 태그의 위치는 중요하지 않다.
// 왜 ? 선언태그 안에있는 코드는 클래스의 블록 안에 삽입되기 때문이다.
private int plus(int a, int b) {
	return a + b;
}

%>
