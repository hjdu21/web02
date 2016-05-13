// 주제 : 서블릿 배치 정보를 작성하는 또다른 방법
// 주제 : 에노테이션을 이용하여 서블릿 배치 정보를 등록하기.
// 				=> servlet 3.0 규격부터 지원

//				=> web.xml에 서블릿 정보를 등록하는 대신 @webServlet 에노테이션을 이용한다.

package step03;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet01")
public class Servlet01 extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet01...");
		
	}

	
}
