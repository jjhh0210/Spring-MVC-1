package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    //서블릿에 종속적이지 않는 형태임, 컨트롤러 호출시 paramMap 같이 넘겨받을 것
    ModelView process(Map<String, String> paramMap);
}
