package step02;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("contextInitialized()...");
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("contextDestroyed()...");
  }
}

/*
# ServletContextListener 인터페이스 
=> 웹 애플리케이션이 시작되거나 종료될 때 호출될 메서드를 정의하고 있다.
=> 이 인터페이스 구현체를 등록하면, 
   서블릿 컨테이너는 웹 애플리케이션을 시작하거나 종료할 때 해당 구현체를 호출할 것이다.
=> 물론 DD 파일(web.xml; deployment descriptor)에 리스너 구현체를 등록해야 한다.   
=> 메서드
   contextInitialized() : 
     웹 애플리케이션을 시작한 직후에 호출된다.
     서블릿들이 공유하는 자원을 준비하는 코드를 둔다.
   contextDestroyed() : 
     웹 애플리케이션을 종료하기 직전에 호출된다.
     공유 자원을 해제시키는 코드를 둔다.
*/









