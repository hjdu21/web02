package step02;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter init()...");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//서블릿을 호출 하기 전에 수행
		System.out.println("MyFilter doFilter()... before");
		
		//서블릿을 호출
		// => FilterChain 객체는 호출 정보를 관리한다)
		// => FilterChain 객체에게 다음 실행 순서의 객체를 호출하라고 명령을 내린다.
		// 		만약 더이상 필터가 없다면 서블릿을 호출할 것이다.
		// => doFilter() 는 다음 객체의 호출이 끝나야 리턴한다.
		chain.doFilter(request, response);
		
		//서블릿을 호출한 후에 수행한다.
		System.out.println("MyFilter doFilter() ... after ");
		
		
	}
	
	@Override
	public void destroy() {
		System.out.println("MyFilter destroy()...");
	}
	
}

/* 필터 컴포넌트
  => 서블릿 실행 전/후에 작업을 수행하는 컴포넌트
  => 메서드
  init() :
  	필터 객체 생성 후 즉시 호출한다.
  	필터가 사용할 자원을 준비하는 용도이다.
  doFilter() :
    필터가 적용될 때 마다 호출된다.
    실제 작업을 두는 메서드.
  destroy() :
  	웹 애플리케이션이 멈추면 호출된다.
  	필터가 사용한 자원을 해제시키는 용도.
  
 # 필터 컴포넌트 배치.
 	=> web.xml 에 무슨 URL에 대해서 필터를 적용할 것인지 설정한다.
 	
 # 필터 객체 생성
 	=> 서블릿 컨테이너는 웹 애플리케이션을 시작할 때 필터 객체는 자동으로 생성한다.
 	
 # 필터 활용
  => 요청 데이터 암호 해제 / 응답 데이터 암호화
  => 요청 데이터 압축 해제 / 응답 데이터 압축
  => 요청한 사용자 권한 검증(authorization)
  => 요청한 사용자 인증(authentication)
 	
 # 필터 특징
 	=> 특정한 기능을 붙이고 떼기 쉽다.
 	=> 특정 URL에 대해서만 필터를 붙일 수 있다.
 
 	
 * */
 