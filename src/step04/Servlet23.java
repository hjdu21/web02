/* 주제: 서블릿 초기화 파라미터 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml에 배치 정보를 등록 했기 때문에 다음 에노테이션은 제거하라
// @WebServlet("/step04/servlet23")
public class Servlet23 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//# 서블릿 초기화 파라미터 값 꺼내기
		// 1) 서블릿 설정 정보를 다루는 객체를 준비한다.
		ServletConfig config = this.getServletConfig();
		
		// 2) 초기화 파라미터 값 출력(init-param)
		out.printf("test1=%s\n", config.getInitParameter("test1"));
		out.printf("test2=%s\n", config.getInitParameter("test2"));
		out.println("-------------------------------------------");
		
		// # 서블릿 컨텍스트 파라미터 값 꺼내기
		// 1) 서블릿 컨텍스트 정보를 다루는 객체를 준비한다.
		ServletContext context = this.getServletContext();
		
		// 2) 컨텍스트 파라미터 값 추출하여 출력하기
		out.printf("center=%s\n", context.getInitParameter("center"));
		out.printf("class=%s\n", context.getInitParameter("class"));
		out.println("-------------------------------------------");
		
	}

}

/* 

# 서블릿 초기화 파라미터
- DD 파일에 설정된 파라미터 값을 읽는 방법.
- 파라미터가 선언된 서블릿 만이 참조할 수 있다.
- 예) 
	<servlet>
		<init-param>
				<param-name>파라미터명</param-name>
				<param-value>파라미터값</param-value>
		</init-param>
		
		<init-param>
				<param-name>파라미터명2</param-name>
				<param-value>파라미터값2</param-value>
		</init-param>
	</servlet>
	
	
	# 서블릿 컨텍스트 파라미터
	- 모든 서블릿들이 참조할 수 있는 파라미터
	<context-param>
	<param-name>파라미터명</param-name> 
	<param-value>파라미터값</param-value> 
	</context-param>
	
	
	# 필터 초기화 파라미터
	- DD 파일에 선언된 파라미터
	- 파라미터가 선언된 필터만이 사용할 수 있다.
	- 설정하는 방법은 서블릿 초기화 파라미터와 같다.
	- CharacterEncodingFilter.java 를 참조하라.
*
*
*/