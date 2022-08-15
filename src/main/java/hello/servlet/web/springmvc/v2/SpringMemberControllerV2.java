package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Form, Save, List 컨트롤러 -> 하나의 컨트롤러에 메서드단위로 통합
 * 클래스 단위 -> 메서드 단위
 * @RequestMapping 클래스 레벨과 메서드 레벨 조합
 */
@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        //1. 비즈니스 로직 수행
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);

        //2. put data in model
        ModelAndView mv = new ModelAndView("save-result");
//      mv.getModel().put("mem", member);
        mv.addObject("mem", member);

        //3. return modelview
        return mv;
    }

    @RequestMapping
    public ModelAndView memberList() {

        //1.비즈니스 로직 수행
        List<Member> memberList = memberRepository.findAll();

        //2. put data in model
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("memberList", memberList);

        //3. return
        return mv;
    }

}
