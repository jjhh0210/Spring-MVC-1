package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*프론트 컨트롤러*/
@WebServlet(name = "frontControllerServletV1",urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
    //<url,controller> 맵 생성
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    //생성자 - <url,controller> 매핑
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //서비스로직
        // 1. 요청 url에 의해 어떤 컨트롤러가 호출될지 맵에서 찾는다
        String requestURI = req.getRequestURI();    //getRequestURL 아님 주의
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURI = " + requestURI);
        System.out.println("requestURL = " + requestURL);
        ControllerV1 controllerV1 = controllerMap.get(requestURI);
        if (controllerV1 == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        // 2. 해당 컨트롤러 호출
        controllerV1.process(req,resp);


    }
}
