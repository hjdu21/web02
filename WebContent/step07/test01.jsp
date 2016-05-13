<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP</title>
</head>
<body>
<h1> JSP 개요 </h1>
<ul>
 <li> 서블릿 출력 코드를 자동으로 작성하기 위한 기술이다.
 <li> 개발자가 out.println() 등의 코드를 작성할 필요가 없어 편리하다.
 <li> JSP 는 서블릿 자바 코드를 만드는데 템플릿으로 이용된다.
 <li> JSP 엔진은 JSP 파일을 읽어 자바 서블릿 소스를 생성한다.
 <li> 결론 : JSP 는 "서블릿" 이다.
 <li> JSP 를 직접 실행 시키는 것은 아니다.
</ul>
<h1> JSP 구동 원리 </h1>
<ol>
 <li> 클라이언트가 서블릿 컨테이너에 JSP 실행을 요청한다.
 <li> 서블릿 컨테이너는 해당 JSP 로 만든 서블릿을 찾는다.
 <li> 없다면, 
 	<ol>
 	<li> JSP 엔진은 JSP 파일을 읽어 서블릿 자바 코드를 생성한다.
 	<li> 자바 컴파일러를 사용하여 서블릿 클래스 파일을 만든다.
 	<li> 서블릿을 배치한다.
 	</ol>
 	</li>
 	<li>서블릿을 실행한다.
</ol>

<h2> JSP 를 이용하여 만든 서블릿 자바 코드 경로 </h2>
<p> 임시 배치폴더 : tmp0/work/../*.java </p>

</body>
</html>