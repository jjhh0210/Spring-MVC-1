package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* Http 응답 데이터 다루기 - HTML
* */
@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHTMLServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: text/html;charset=utf-8
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();

        //서블릿으로 html 렌더링할 때는 직접 html 코드 작성해줘야함
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<div> hello 안녕 hello <div>");
        writer.println("<body>");
        writer.println("<html>");
        
    }
}
