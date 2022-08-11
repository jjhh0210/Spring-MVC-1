package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
* 1,2) http 요청 데이터 - GET 쿼리 파라미터 & POST html form
* http://localhost:8080/request-param?username=park&age=25&username=kim
* */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getAllParams(request);      //전체 파라미터 조회
        getSingleParam(request);    //단일 파라미터 조회
        getMultiParams(request);    //복수 파라미터 조회
        
    }

    //1) 전체 쿼리 파라미터 조회 - request.getParameterNames()
    private void getAllParams(HttpServletRequest request) {
        System.out.println("---- 전체 파라미터 조회 ----");
        request.getParameterNames().asIterator()
                .forEachRemaining(param -> System.out.println(param+" = " + request.getParameter(param)));  //key = value 출력
        System.out.println();
    }

    //2) 단일 쿼리 파라미터 조회 - request.getParameter(name)
    private void getSingleParam(HttpServletRequest request) {
        System.out.println("---- 단일 파라미터 조회 ----");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();
    }

    //3) 이름이 같은 복수 파라미터 조회(username=kim&username=park) - request.getParameterValues(name) //배열
    //근데 중복으로 보내는 경우는 많지 않음(대부분 단일파라미터로 보냄)
    private void getMultiParams(HttpServletRequest request) {
        System.out.println("---- 값이 여러개인 파라미터 조회 ----");
        String[] usernames = request.getParameterValues("username");    //배열로 리턴
        for (String username : usernames) {
            System.out.println("username = "+username);
        }
    }

}
