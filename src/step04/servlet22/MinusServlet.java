package step04.servlet22;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/calculator3/minus")
public class MinusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		// 작업 결과를 다른 서블릿이 사용할 수 있도록 ServletRequest 바구니에 저장한다.
		request.setAttribute("result", a - b);
		
	}

}

/*
  
 
*/