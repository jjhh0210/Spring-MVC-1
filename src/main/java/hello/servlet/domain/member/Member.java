package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private long id;    //회원을 repository에 저장하면 id 자동 생성
    private String username;
    private int age;
    private int grade;   //등급 자동 생성 (1등급- vip , 2등급 - normal)

    public Member() {
        
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
