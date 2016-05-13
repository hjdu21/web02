// 주제 : GET / POST 요청을 분리하여 처리하기 2.
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/servlet25")
public class Servlet25 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getMethod().equals("GET")) {
			get(request, response);
		} else if (request.getMethod().equals("POST")) {
			post(request, response);		
		} else {			
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("지원하지 않는 HTTP 요청 입니다.");
		}
		
	}

	public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>getPost</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>POST 요청</h1>");
		out.println("<form action=\"servlet25\" method=\"post\">");
		out.println("이름: <input type=\"text\" name=\"name\"><br>");
		out.println("이메일: <input type=\"text\" name=\"email\"><br>");
		out.println("전화: <input type=\"text\" name=\"tel\"><br>");
		out.println("<button>보내기</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>getPost</title>");
		out.println("</head>");
		out.println("<body>");
		out.printf("name = > %s<br>\n", request.getParameter("name"));
		out.printf("email = > %s<br>\n", request.getParameter("email"));
		out.printf("tel = > %s<br>\n", request.getParameter("tel"));
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	
}

/*
  */
