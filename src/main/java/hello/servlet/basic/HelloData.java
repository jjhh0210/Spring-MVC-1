package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter         //Lombok -> getter,setter를 자동으로 생성해줌
public class HelloData {
    private  String username;
    private int age;
}
