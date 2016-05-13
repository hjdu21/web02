// 주제 : 리프레쉬2 - 응답헤더를 이용
package step06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step06/servlet28")
public class Servlet28 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// 응답 헤더에 리프레시 정보를 담는다.
	
		response.setHeader("Refresh", "5;url=http://www.naver.com");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
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
