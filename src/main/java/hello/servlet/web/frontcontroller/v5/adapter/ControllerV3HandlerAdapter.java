package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
* ControllerV3 따르는 핸들러들 handle하는 어댑터
* 즉, MemberFormControllerV3, MemberSaveControllerV3, MemberListControllerV3
* */
public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean support(Object handler) {
        //어댑터가 해당 handler 처리할 수 있는지, support 가능한지 판단)
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        //1. handler가 Object 타입이므로 V3으로 캐스팅 필요
        ControllerV3 controller = (ControllerV3) handler;
        //2. handler 호출 전 create param map 필요
        Map<String, String> paramMap = createParamMap(request);
        //3. handler 호출
        ModelView mv = controller.process(paramMap);

        return mv;
    }

    private Map<String,String> createParamMap(HttpServletRequest request) {

        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,request.getParameter(paramName)));

        return paramMap;
    }
}
