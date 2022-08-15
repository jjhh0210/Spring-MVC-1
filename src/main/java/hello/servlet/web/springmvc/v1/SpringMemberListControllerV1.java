package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringMemberListControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {

        //1.비즈니스 로직 수행
        List<Member> memberList = memberRepository.findAll();

        //2. put data in model
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("memberList", memberList);

        //3. return
        return mv;
    }
}
