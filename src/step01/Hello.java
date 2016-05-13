// 주제 :  서블릿 만들고 배포하기.
package step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Hello implements Servlet{

	ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()...");
		this.config = config;
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service()...");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy()...");
	}
	
	@Override
	public String getServletInfo() {
		return "Hello Servlet";
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return config;
		//init 에서 받아놨던 설정 파일을 리턴하면됨.
	}
	

}

/* 
 # 서블릿 컨테이너란?
 - 자바 웹 애플리케이션을 관리하는 프로그램.
 
 # 웹 애플리케이션?
 - 서블릿 컨테이너가 실행하는 자바 프로그램.
 - 작은 기능을 수행하는 자바 프로그램들로 구성된다.
 예 ) 인사관리 시스템, 물류관리 시스템, 고객관계관리 시스템 등 관리시스템 류
 
 # 서블릿?
 - 웹 어플리케이션에 소속된 자바 프로그램.
 - 작은 단위의 기능을 실행한다. 
 예 ) 사원 등록, 퇴사 처리, 사원 상벌조회, 휴가계작성 등 작은 기능..
  
 서블릿 만들기
 
- Servlet 인터페이스를 구현한다

* Servlet 인터페이스
- 서블릿 컨테이너와 자바 프로그램 사이의 호출 규칙이다.
- 클라이언트 요청이 들어오면 호출 규칙에 따라 서블릿컨테이너는 자바 객체를 호출한다.
- 메서드

 init() : 
 			서블릿 컨테이너가 서블릿을 생성한 후 호출한다.
 			서블릿을 실행하는데 필요한 자원을 준비시키는 코드를 넣는다.
 			
 service() : 
 			클라이언트가 요청 할 때 마다 호출한다
 			클라이언트 요청을 처리하는 코드를 둔다.
 destroy() :  
 			웹 애플리케이션이 멈출 때 호출한다.
 			서블릿이 사용한 자원을 해제시키는 코드를 둔다.
 getServletInfo() :
 			서블릿에 대한 간단한 정보를 문자열로 리턴한다.
 			서블릿 컨테이너에서 서블릿을 관리할 때 서블릿의 정보를 출력하기 위해 호출한다.
 			일반적으로 요청을 처리하는 작업과는 관련이 없다.
 getServletConfig() :
 			서블릿의 설정 정보를 다루는 객체(ServletConfig)를 리턴한다.
 			ServletConfig 객체는 서블릿 컨테이너가 init() 를 호출할 때 파라미터로 넘겨준다.
 			이 메서드도 요청을 처리하는 작업과는 무관하다. 
 
# 서블릿 컨테이너 (중에서) - Tomcat 서버
 - JavaEE 기술 규격 중에서 웹 애플리케이션 규칙에 따라 만든
 	 자바 프로그램을 관리하고 실행하는 서버.
 - 웹 애플리케이션 규칙 
 			=> Servlet , JavaServer Page(=Jsp), Jsp Standard Tag Library(JSTL),
 			   Expression Language(EL) 과 같은 기술	 
 - 톰캣 서버 자체가 자바로 만들어졌다.
 
# Tomcat 서버의 디렉토리 구조!
- bin : 톰캣 서버를 실행하는 스크립트를 모아 놓은 디렉토리
- conf : 톰캣 서버의 설정 파일을 모아둔 디렉토리
- lib : 톰캣 서버 및 톰캣 서버를 실행하는데 필요한 자바 라이브러리를 모아둔 디렉토리
- logs : 톰캣 서버의 실행 상황을 기록한 로그 파일을 모아둔 디렉토리
				 톰캣 서버에 문제가 발생했을 때 이 로그 파일을 분석하여 문제를 찾는다.
- temp : 임시 작업 결과물을 두는 디렉토리
- webapps : 웹 애플리케이션을 모아둔 디렉토리.
						웹 애플리케이션을 배포할 때 기본으로 이 디렉토리를 두어야 한다.
						물론, 다른 디렉토리에 웹 애플리케이션을 두고 
						톰캣 설정파일에서 그 디렉토리를 지정할 수 있다.
- work : JSP 파일을 자바 서블릿으로 변환한 파일을 두는 디렉토리.

 
 # 웹 애플리케이션 배포
 - $톰캣서버홈/webapps/디렉토리에 웹 애플리케이션 디렉토리를 생성한다.
 - 웹 애플리케이션 디렉토리
==> $웹애플리케이션/WEB-INF/web.xml 		(: 웹 애플리케이션 설정 파일이다)
													 /classes 		(: 자바 바이트코드(.class) 및 실행할 때 사용할 설정 파일(.xml, .properties등)을 둔다.)
													 /lib					(: 자바 라이브러리 파일(.jar)을 둔다)
									/...   (디렉토리, HTML, CSS, JavaScript, JSP, 이미지파일 등 웹 자원을 둔다 // 웹 어플리케이션 밑에)				  
 주의!!!!!!!!!!!!!!!!
 => 절대 WEB-INF 밑에 HTML, CSS, JavaScript, JSP 등 웹자원을 두지말라!!
 => 클라이언트에서 사용할 수 없다.												 

 *
 *
 *
 # 서블릿 실행
 - 웹 브라우저에서 다음 형식으로 URL을 입력한다.
   http://서버주소:포트번호/웹어플리케이션이름/서블릿URL
   예) http://localhost:8080/web01/step01/hello
   
 # 웹 자원
 - static resource (정적 자원)
  => HTML, CSS, JavaScript, 이미지 파일처럼 서버에서 실행하지 않고,
     그대로 클라이언트로 전달하는 파일
  => 정적 자원 실행.
   - 그 자원의 위치를 그대로 URL 경로에 지정하면 된다.
   예) http://localhost:8080/web01/timer.html		<==위치 그대로   
     
 - dynamic resource (동적 자원)
  => 서블릿, JSP 처럼 서버에서 실행한 후 그 결과를 클라이언트로 보내는 파일
  
  
  # web.xml
 - 웹 애플리케이션의 정보를 설정하는 파일.
 - 서블릿, 필터, 리스너 등의 컴포넌트 정보를 등록한다.
 - 즉 웹 애플리케이션 배치를 위한 정보를 설정하는 파일이다.
 - 이 파일을 "배치기술서(Deployment Descriptor)" 라고 부른다.
 - 줄여서 "DD File" 이라고 부를때도 있다.
  
 */
