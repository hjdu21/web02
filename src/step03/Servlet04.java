// 주제 : 출력하는 데이터의 형식을 Http Client 에게 알려주기.

package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet04")
public class Servlet04 extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		//출력할 내용의 데이터 타입과 문자 집합을 함께 지정한다.
		response.setContentType("text/plain;charset=UTF-8");
		// setContentType의 내용에 오타 있으면 파일 다운으로 된다.
		
		// 출력 도구를 준비한다.
		PrintWriter out = response.getWriter();
		out.println("Servlet04...");
		out.println("한글 출력...");
		
	}

	
}

/*

# ServletResponse.setContentType("MIME Type;문자집합")
	-- 응답데이터의 형식과 문자 집합을 클라이언트에게 알려준다.
	 예) Content-Type : text/plain;charset=UTF-8
	-- 클라이언트는 응답 헤더 "Content-Type"의 내용을 보고 어떻게 처리할 것인지 결정한다.
	HTML --> 출력
	PDF  --> PDF 리더를 실행
	PPT  --> PowerPoint 를 실행
	동영상-> 동영상 플레이어를 실행
	SWF  --> 플래시 플레이어를 실행
	기타  -> 다운로드 대화상자를 띄운다.

#MIME?
-		Mutil-purpose Internet Mail Extensions
- 메일 컨텐츠의 형식을 지정하기 위해 등장
- 지금은 여러 통신 프로토콜에서 컨텐츠의 형식을 지정하는 데에 사용하고 있다.

예)
text/plain							-> .txt
text/html								-> .html		
text/css								-> .css
application/x-msvideo		-> .avi
image/gif								-> .gif
application/json				-> .json
application/xml					-> .xml
...
------------------
http://freeformatter.com/mime-types-list.html


# 언어 국가 표현
	로케일(locale)
- 요청 및 응답할 때 사용할 언어와 국가를 표시하는 것
- 언어 코드(Language Codes)
[ISO 639-1] / [ISO 639-2]
	en				/ 		eng
	fr				/			fre
	ja				/			jpn
	ko				/ 		kor
	
- 국가 코드(Country Codes)
[ISO 639-1] / [ISO 639-2]
	US 				/		 	USA		(United States)
	GB				/ 		GBR		(United Kingdom)
	KR			  /		  KOR		(South Korea)
	KP				/			PRK		(North Korea)
	JP				/			JPN		(Japan)
	
- 로케일표현 : 언어-국가
en-US	, ko-KR , ja-JP
 */


