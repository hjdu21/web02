<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"
    autoFlush="true"
    buffer="8kb"
    trimDirectiveWhitespaces="true"
    import ="java.util.List, java.io.File"
    import ="java.io.Reader"    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<h1>지시문 (declaration element)</h1>
<ul>
  <li> JSP 페이지에 대한 특별한 설정을 할 때 사용
  <li> 종류 : page, include, taglib
  <li> page => 출력 내용에 대한 설정
  <li> include => JSP 페이지 안에 다른 파일의 내용을 삽입할 때
  <li> taglib =>  JSP 외부 태그를 선언할 때. 예: JSTL, 사용자 정의 태그
</ul>

<h2>page 지시어의 주요 속성 </h2>
<ul>
<li> language : 스크립트릿 태그 안에 넣을 코드의 언어를 지정한다. 현재 java만 가능하다.
				이 속성을 생략해도 된다.
<li> contentType: response.setContentType() 메서드를 추가한다.
<li> pageEncoding: JSP 파일을 작성할 때 사용한 언어를 지정한다.
	 만약 이 속성을 생략한다면 contenType에서 지정한 문자 집합과 같은 것으로 간주한다.
<li>autoFlush: true ==> 버퍼가 꽉 차면 자동으로 데이터를 클라이언트로 보낸다.
    즉 버퍼가 넘친다는 오류가 발생하지 않는다.
    autoFlush: false ==> 버퍼가 꽉 차면 오류를 발생시킨다.
<li> buffer : 버퍼 크기를 지정한다. 기본은 8kb이다.
<li>errorPage : 실행 중 오류 발생했을 때 포워딩 할 URL을 지정한다.
    지정하지 않으면 오류가 발생했을 때 서블릿 컨테이너의 기본 오류 페이지를 출력한다.
<li>trimDirectiveWhitespaces: 지시문 태그뒤에 붙은 공백(스페이스,탭,줄바꿈)을 제거한다.
	기본은 false이다.
<li>import : 자바 import 문을 추가한다. 콤마(,)를 사용하여 여러 개를 지정할 수 있다.
	import 속성을 여러개 둘 수 있다.
	import 속성만 있는 page 지시문을 선언해도 된다.
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
