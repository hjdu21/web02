/* 주제: HTTP 프로토콜과 관련된 정보를 추출하기 - HttpServletRequest */
package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step03/servlet11")
public class Servlet11 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    // 이미 형변환시킨 객체가 파라미터로 넘어오기 때문에 
    // 다음과 같이 따로 형변환할 필요가 없다.
    //HttpServletRequest httpReq = (HttpServletRequest) request;
    //HttpServletResponse httpResp = (HttpServletResponse) response;
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    Enumeration<String> names = request.getHeaderNames();
    
    String name = null;
    while (names.hasMoreElements()) {
      name = names.nextElement();
      out.printf("%s=> %s\n", name, request.getHeader(name));
    }
    
  }
}

/*
# 

 */

















