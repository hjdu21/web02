/* 주제: HTTP 프로토콜과 관련된 정보를 추출하기 - HttpServletRequest */
package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step03/servlet10")
public class Servlet10 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    
    // HTTP 프로토콜 관련 기능을 사용하기 위해서는 
    // 반드시 원래 타입의 객체로 전환해야 한다.
    HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpServletResponse httpResp = (HttpServletResponse) response;
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    // HTTP 요청 헤더의 이름과 값 출력하기
    Enumeration<String> names = httpReq.getHeaderNames();
    
    String name = null;
    while (names.hasMoreElements()) {
      name = names.nextElement();
      out.printf("%s=> %s\n", name, httpReq.getHeader(name));
    }
    
  }
}

/*
# Servlet 기술
- Servlet = Server Application + let => 서버 애플리케이션의 작은 조작을 말한다.
- 서블릿 기술은 HTTP에서만 사용하도록 만든 것은 아니다.
- 다양한 프로토콜을 기반으로 서버 애플리케이션을 작성할 수 있도록
  범용성을 고려해 만든 기술이다. 
- Servlet 인터페이스의 service() 메서드를 살펴보면
  파라미터 타입이 ServletRequest와 ServletResponse인데, 
  이들 객체의 메서드를 보면 HTTP에 종속된 기능을 발견할 수 없다.
- 하지만, 현재 서블릿은 대부분 HTTP(웹 기술)를 기반으로 사용되고 있다.
- 그래서 서블릿 기술도 HTTP를 다루는 클래스나, 인터페이스를 포함하고 있다.

# 중요!
- 만약 서블릿 기술이 HTTP를 기반으로 사용된다면,
  서블릿 컨테이너는 service() 메서드를 호출할 때 파라미터 값으로  
  ServletRequest 대신 HttpServletRequest를
  ServletResponse 대신 HttpServletResponse를 넘겨줄 것이다.
- 실무에서 사용하는 서블릿 기술은 거의 HTTP를 기반으로 하기 때문에
  service()에 넘어오는 파라미터 값이 
  HttpServletRequest, HttpServletResponse라고 간주해도 무방하다. 
  

 */

















