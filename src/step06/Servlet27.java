// 주제 : 리프레쉬 - HTML <meta> 태그 이용
package step06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step06/servlet27")
public class Servlet27 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		// HTML meta 태그를 이용하여 refresh 구현
		// ==> 브라우저야 5초 후에 내가 알려준 url을 다시 요청하라
		out.println("<meta http-equiv='Refresh' content='5;url=http://www.naver.com'>");
		out.println("<title>리프레시</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p> 5초 후 다른 화면으로 이동합니다</p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}


	
}

/*
  */
