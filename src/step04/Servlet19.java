/* 주제: 파일업로드 처리 */
package step04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/step04/servlet19")
public class Servlet19 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.printf("요청 method => %s\n", request.getMethod());

    // 멀티파트 방식으로 요청을 할 때는 
    // 다음 코드로 한글을 처리할 수 없다.
    //request.setCharacterEncoding("UTF-8");
    
    // 화이팅!
    // => name, email, tel 값을 화면에 출력하라!
    // => 사진 파일은 배치 폴더의 files/ 디렉토리에 둔다.
    // => 예)
    // ...\tmp0\wtpwebapps\web02\files
    
    // 1) 멀티파트 데이터를 분해하여 각 파트의 데이터를 
    //    한 개의 객체로 만들어주는 공장을 준비한다.
    DiskFileItemFactory factory = new DiskFileItemFactory();
    
    // 2) 클라이언트 파일 업로드 요청 정보를 분석할 객체를 준비한다.
    ServletFileUpload upload = new ServletFileUpload(factory);
    
    // 3) 요청을 분석한다.
    try {
      List<FileItem> items = upload.parseRequest(request);
      
      // 4) 반복하여 각 파트의 데이터를 처리한다.
      for (FileItem item : items) {
        if (item.isFormField()) { // 일반적인 폼 입력 값이면,
          out.printf("%s=%s\n", item.getFieldName(), item.getString("UTF-8"));
          
        } else { // 파일이면,
          //getName() => 원래의 파일 이름을 리턴한다.
          //=> 서버에 파일을 저장할 때 원래의 파일명을 사용해서는 안된다.
          //   => 다른 클라이언트가 같은 이름을 파일을 업로드하면 
          //      기존 파일을 덮어쓰기 때문이다.
          out.printf("%s=%s\n", item.getFieldName(), item.getName());
          
          // 서버에 업로드된 파일을 저장하기
          // 가. 임의의 파일 명을 준비한다. 
          //    보통 "현재 시간(밀리초) + 일련번호"를 파일명으로 사용한다.
          int extPoint = item.getName().lastIndexOf(".");
          String filename = System.currentTimeMillis() + "-" + count()
                             + item.getName().substring(extPoint);
          out.printf("새파일명=%s\n", filename);
          
          // 나. 파일을 저장할 경로 알아내기
          //    $contextRoot/files/새파일명 ---> 진짜 OS 경로
          ServletContext servletContext = this.getServletContext();
          String realPath = servletContext.getRealPath("/files/" + filename);
          out.printf("새 파일을 저장할 실제 경로=%s\n", realPath);
          
          // 다. 파일을 저장한다.
          item.write(new File(realPath));
        }
      }
    } catch (Exception e) {
      out.println("업로드된 파일을 처리하는 중에 오류 발생!");
    }
    
  }
  
  int no = 0;
  synchronized private int count() {
    if (++no == 100) no = 1;
    return no;
  }
  
}

/*
# ServletContext 객체
- 웹 애플리케이션의 정보를 다루는 객체
- 웹 애플리케이션 ===> web02
- 서블릿(예:Servlet19) ===> 웹 애플리케이션을 구성하고 있는 한 개의 기능
- 웹 애플리케이션 루트 디렉토리(예: /web02)를 컨텍스트 루트(context root)라고 부른다.



 */

















