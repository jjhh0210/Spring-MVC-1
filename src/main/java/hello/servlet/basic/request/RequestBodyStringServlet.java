package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
* 3) http 요청 데이터 - HTTP msg body에 단순텍스트 담아서 요청
* */
@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    //
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1) msg 내용 바이트로 받음 - request.getInputStream()
        ServletInputStream inputStream = request.getInputStream();
        //2) 바이트 -> String으로 변환 - StreamUtils.copyToString(변환할stream,인코딩정보)
        String msgBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("msgBody = " + msgBody);

        response.getWriter().write("well done~!");
    }
}
