package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        //1. 비즈니스 로직 수행
        List<Member> memberList = memberRepository.findAll();
        //2. 모델 저장
        ModelView mv = new ModelView("members");
        mv.getModel().put("memberList", memberList);

        //3. return
        return mv;

    }
}
