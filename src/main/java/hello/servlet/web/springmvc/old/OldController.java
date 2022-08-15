package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
* 핸들러 매핑 방법: BeanNameUrlHandlerMapping
* 핸들러 어댑터 : SimpleControllerHandlerAdapter
* */
@Component("/springmvc/old-controller") //spring빈의 이름을 url로 맞춘것
public class OldController implements Controller {  //@Controller와 다름
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        return new ModelAndView("new-form");    //논리이름
    }
    
}
