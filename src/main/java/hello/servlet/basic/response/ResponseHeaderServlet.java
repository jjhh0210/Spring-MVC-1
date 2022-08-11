package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* Http 응답메시지 status line, 헤더 생성
* */
@WebServlet(name = "responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. Status-line
        response.setStatus(HttpServletResponse.SC_OK);  //응답 코드 설정

        //2. response 헤더
//        response.setHeader("Content-Type", "text/plain;charset=utf-8"); //utf-8 안넣으면 한글 깨질수도
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");   //캐시 무효화
        response.setHeader("my-header", "hello");   //내가 만든 헤더

        //3. 편의 메서드
        //1) Content-Type 편의 설정
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(2); 보통 생략 -> 생략시 길이 자동 계산 및 생성

        //2) 쿠키 설정
        cookie(response);

        //3) Redirect
        redirect(response);

        //4. 메시지 바디
//        PrintWriter writer = response.getWriter();
//        writer.println("ok");
        response.getWriter().println("안녕"); //write()나 println()이나 똑같이 화면에 출력됨
    }

    private void cookie(HttpServletResponse response) {
//        response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");

        //1. 쿠키 객체 생성,설정 (생성자로 쿠키값 지정)
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);  //600초

        //2. response.addCookie(쿠키객체)!!
        response.addCookie(cookie);

    }
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location : /basic/hello-form.html
        response.sendRedirect("/basic/hello-form.html");
    }
}
