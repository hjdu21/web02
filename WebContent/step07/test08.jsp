<%@ page contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<h1>JSP 액션태그 - jsp:useBean</h1>
<ul>
  <li> JSP 액션 태그란? JSP 페이지에서 사용할 수 있는 전용 태그이다.
  <li> 각 태그는 고유의 자바 코드로 변환된다.
  <li> 자바 객체를 생성하여 보관소에 저장하는 기능
  <li> 보관소 : ServletContext, HttpSession, ServletRequest, PageContext
 
</ul>
<%
int i = 10;
int j = 20;
%>
<%@ include file="footer.txt" %>

</body>
</html>