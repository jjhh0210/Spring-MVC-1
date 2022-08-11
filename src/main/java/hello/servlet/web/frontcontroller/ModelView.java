package hello.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter@Setter
public class ModelView {
    //Model+View
    private String viewName;    //view의 논리적 이름
    private Map<String, Object> model = new HashMap<>();    //데이터 저장할 model

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

}