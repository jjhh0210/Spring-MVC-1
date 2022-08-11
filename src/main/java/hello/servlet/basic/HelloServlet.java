package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet",urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // 요청 url이 /hello이면 이 서블릿 실행(호츨)

    //이 서블릿이 호출 되면 service 메소드 실행
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        //1. 요청메세지 읽기
        //서블릿은 쿼리파라미터를 편하게 읽도록 지원
        // req.getParameter(): 쿼리파라미터 조회
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        
        //2. 응답 메세지에 데이터 담기
        //1,2번째 줄은 content-type 헤더정보에 들어감
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8"); //요즘 다 utf-8씀!
        resp.getWriter().write("hello "+ username); //http 메세지 바디에 해당 데이터 들어감


    }

}
