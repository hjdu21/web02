package step02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("MyServlet Service()...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("MyServlet init()...");
		super.init();
	}
	
	@Override
	public void destroy() {
		System.out.println("MyServlet destroy().. ");
		super.destroy();
	}
	
	
}

/* 
 # 서블릿 컴포넌트
=> 클라이언트의 요청을 직접 처리하는 컴포넌트다.
=> 클라이언트는 URL을 사용하여 서블릿 실행을 요청한다.

 # 서블릿 생성
=> 클라이언트의 최초 요청시에 해당 서블릿 객체를 생성한다.
=> 물론 DD 파일(web.xml)에 웹 애플리케이션 시작할 때 객체를 생성하라고 설정할 수 있다.
	어떻게?!?!
	
	<servlet>
	.........
		<load-on-startup>1</load-on-startup>
	</servlet>
	
	숫자 1은 생성 순서를 의미한다.
	여러개의 서블릿이 있을 때 숫자가 낮은 서블릿을 먼저 생성한다.

*/