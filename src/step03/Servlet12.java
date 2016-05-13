/* 주제: HTTP 프로토콜의 요청 방식을 식별하기 - HTTP 요청 프로토콜 분석 */
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step03/servlet12")
public class Servlet12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();

			out.printf("요청 방식 => %s\n" , request.getMethod());
			// 이게 호출하는것은
			// GET /web02/step03/servlet12?names=aaaa&age=30&tel=111-1111 HTTP/1.1 이거임
	}
}

/*
 * # HTTP Request 요청 프로토콜
 
GET /web02/step03/servlet12?names=aaaa&age=30&tel=111-1111 HTTP/1.1
Host: localhost:8080(CRLF)
Connection: keep-alive(CRLF)
Cache-Control: max-age=0(CRLF)
Accept: text/html,application/xhtml+xml,application/xml;q=0.9 ... (CRLF)
Upgrade-Insecure-Requests: 1(CRLF)
User-Agent: Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94  ...(CRLF)
Accept-Encoding: gzip, deflate, sdch(CRLF)
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4(CRLF)
(CRLF)
 
 # HTTP  요청 프로토콜 분석
 1) GET /web02/step03/servlet12?names=aaaa&age=30&tel=111-1111 HTTP/1.1
 => Request Line : method request-uri http version (CRLF)
 => method : GET, POST, PUT, DELETE, TRACE, HEAD, OPTIONS, CONNECT 등
 => request-uri : 요청하는 자원의 웹 주소
 => http version : 프로토콜 이름 및 버전
 
 2) 일반 헤더.
 => 요청과 응답 모두에 사용할 수 있는 헤더
 => 예)
Connection: keep-alive
Cache-Control: max-age=0		
Upgrade-Insecure-Requests: 1

 3) 요청 헤더
 => 요청할 때만 보낼 수 있는 헤더
Accept: text/html,application/xhtml+xml,application/xml;q=0.9 ... 
Host: localhost:8080
User-Agent: Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94  ...
Accept-Encoding: gzip, deflate, sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
 
 4) 엔티티 헤더
 => POST 방식으로 서버에 데이터를 보낼 때 사용하는 헤더
 => 보내는 데이터의 정보를 표현한다.
 => 위의 프로토콜엔 GET 방식 이기 때문에 Entity 헤더를 찾을 수 없다. 
 
 5) 빈줄
 => 항상 요청 헤더의 끝을 표시하기 위해 빈줄을 삽입해야 한다.
 
 */
