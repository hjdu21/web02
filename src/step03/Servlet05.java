// 주제 : 출력하는 데이터의 형식을 Http Client 에게 알려주기.

package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet05")
public class Servlet05 extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		// 파라미터 값 꺼내기
		// => http://localhost:8080/web02/step03/servlet05?name=111&email=222&tel=333
		// ServletRequest.getParameter(파라미터명)
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel 	= request.getParameter("tel");
		
		
		//출력할 내용의 데이터 타입과 문자 집합을 함께 지정한다.
		response.setContentType("text/plain;charset=UTF-8");
		
		// 출력 도구를 준비한다.
		PrintWriter out = response.getWriter();
		out.println("이름: " + name);
		out.println("이메일: " + email);
		out.println("전화번호: " + tel);
		
	}

	
}

/*

# URL에 포함된 한글 파라미터 값이 깨지는 이유?
- 서블릿 컨테이너는 클라이언트가 보낸 데이터를 ISO-8859-1 로 간주한다.
- 그래서 ISO-8859-1  ---> unicode로 변환한다.
	여기서 문제가 발생한 것이다.
	예 ) 보내는 파라미터 값이 "ABC가각" 일 때?
	웹 브라우저는 UTF-8로 보낸다  => 41 42 43 EA B0 80 EA B0 81
	서블릿 컨테이너는 ISO-8859-1 로 취급한다. 즉 1바이트 문자로 취급.
	각 1바이트를 유니코드로 바꾼다.
	41 --> 0041		(OK)
	42 --> 0042		(OK)
	43 --> 0043		(OK)
	EA --> 00EA		X
	B0 --> 00B0		X
	80 --> 0080		X
	81 --> 0081		X
	
	- 정상적으로 유니코드로 바꿨다면 다음과 같아야 한다.
	=> 영어는 1BYTE에 00을 붙이면 된다.
	41 --> 0041		
	42 --> 0042	
	43 --> 0043		
	=> 그러나 한글은 3byte를 묶어 유니코드 2바이트로 만들어야 한다.
	EA 	B0 	80 --> AC 00		(가)
	EA 	B0 	81 --> AC 01		(각)
	
	
-해결책은?
 1) 톰캣 8.0은 자동으로 처리한다 ( 별도 설정 필요 없음 ) = 한글 안깨짐
 		톰캣 7.0 이하는 server.xml 파일의 <connect> 태그에 다음 속성을 추가하라.
 		<URIEncoding="UTF-8">

*/


