// 주제 : 요청을 다른 서블릿으로 위임하기  - include 방식
package step04.servlet21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet21")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 서블릿을 만들 때 마다 다음과 같이 요청 데이터의 문자 집합을
		// 지정하는 것은 매우 번거롭고 귀찮은 일이다
		// 해결책??
		// 필터를 이용하여 문자 집합을 설정한다.
		// request.setCharacterEncoding("UTF-8");

		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("******************************");
		
		
		out.println(request.getParameter("a"));
		out.println(request.getParameter("b"));

		// 1) 요청을 다른 서블릿에게 전달할 배달자 준비
		RequestDispatcher rd = null;

		switch (request.getParameter("op")) {
			case "더하기":
				rd = request.getRequestDispatcher("/step04/calculator2/plus");
				break;
			case "빼기":
				rd = request.getRequestDispatcher("/step04/calculator2/minus");
				break;
			case "곱하기":
				rd = request.getRequestDispatcher("/step04/calculator2/multiple");
				break;
			case "나누기":
				rd = request.getRequestDispatcher("/step04/calculator2/divide");
				break;
			default:
				out.println("지원하지 않는 연산자 입니다.");
				return;
		}
		// 2) 요청 배달자를 통해 다른 서블릿으로 요청을 전달한다.
		rd.include(request, response);
		out.println("******************************");
	}

}

/*
  # include 실행 위임 방식
 - 여러 서블릿이 협력하여 한 작업을 수행할 때 사용하는 방식이다.
 - 메인 서블릿에서 기본 작업을 수행하고, 다른 서블릿이 부분 작업을 수행한다.
 
 
*/