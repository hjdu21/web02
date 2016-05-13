// 주제 : 한글 출력하기

package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet03")
public class Servlet03 extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		//출력할 내용의 문자 집합을 지정한다.
		response.setCharacterEncoding("UTF-8");
		
		// 출력 도구를 준비한다.
		PrintWriter out = response.getWriter();
		out.println("Servlet03...");
		out.println("한글 출력...");
		
	}

	
}

/*
 # 출력 문자열 중에서 한글이 깨지는 이유
 - response.getWriter() 가 리턴한 PrintWriter는
 	 기본적으로 Unicode --> ISO-8859-1 문자 집합으로 변환하여 출력한다.
 - 유니코드에는 정의된 문자이지만 ISO-8859-1 에는 정의되지 않은 문자라면, ??으로 변환된다.
 - 해결책!??
 ==> PrintWriter를 얻기 전에 어떤 문자집합을 사용하여 출력할 것인지 설정하라!!
 =>  ServletResponse.setContentType()사용.
 
 이 방식의 문제점?
 => Http Client 는 서버가 보낸 데이터가 어떤 문자 집합인지 알 수 없다.
 => Http Client 현재 설정된 문자 집합을 사용하여 서버가 보낸 데이터를 출력하려 할 것이다.
 	  다행히 같은 서버와 같은 문자 집합으로 설정 되어 있다면 정상적으로 출력 될 것이나,
 	  만약 서버가 보낸 데이터와 다른 문자 집합을 사용하고 있다면 출력할 때 글자가 깨질 것이다.
 	  => 해결책은 servlet04에서 확인~~~~

 */


