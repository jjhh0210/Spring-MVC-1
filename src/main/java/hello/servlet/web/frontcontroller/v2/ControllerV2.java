package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    //v1 에선 void 였는데 v2에선 MyView를 반환한다
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
