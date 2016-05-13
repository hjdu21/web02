package step04.servlet22;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/calculator3/tailer")
public class TailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// include 인 경우, 메인 서블릿의 설정을 그대로 사용하기 때문에,
	// 다음의 코드를 작성할 필요가 없다.
	// response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("=====================================");
		
	}

}

/*
  
 
*/