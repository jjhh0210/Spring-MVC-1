package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * v3
 * Model 도입
 * ViewName 직접 반환
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("age") int age,
                       Model model) {
        //1. 비즈니스 로직 수행
        Member member = new Member(username, age);
        memberRepository.save(member);

        //2. put data in model
        model.addAttribute("mem", member);

        //3. return viewName
        return "save-result";
    }

    @GetMapping
    public String memberList(Model model) {

        //1.비즈니스 로직 수행
        List<Member> memberList = memberRepository.findAll();

        //2. put data in model
        model.addAttribute("memberList", memberList);

        //3. return viewName
        return "members";
    }

}
