// 주제 : JavaEE 에서 제공하는 HTTPServlet 클래스 상속하기
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet14")
public class Servlet14 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서블릿 컨테이너
	// ==> service(ServletRequest, ServletResponse)  <== Servlet 인터페이스꺼
						//=> service(HttpServletRequest, HttpServletResponse)		<== HttpServlet 클래스꺼.
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//	http://localhost:8080/web02/step04/servlet14
		out.printf("getRequestURL() ==> %s\n", request.getRequestURL().toString());
		// toString 왜붙였냐면 getRequestURL의 리턴값이 스트링버퍼라서

		// /web02/step04/servlet14
		out.printf("getRequestURI() ==> %s\n", request.getRequestURI());

		// /step04/servlet14
		out.printf("getServletPath() ==> %s\n", request.getServletPath());
		
		// name=okok&email=okok@test.com&tel=111-1111(물음표 다음에 나오는 파라미터 정보)
		out.printf("getQueryString() ==> %s\n", request.getQueryString());
		
		// 특정 파라미터의 값만 꺼내고 싶을 때
		// http://localhost:8080/web02/step04/servlet14?name=okok&email=okok@test.com&tel=111-1111
		// 이렇게 입력했다 치면 okok가 출력됨.
		out.printf("getParameter(\"name\") ==> %s\n", request.getParameter("name"));
	}

}
