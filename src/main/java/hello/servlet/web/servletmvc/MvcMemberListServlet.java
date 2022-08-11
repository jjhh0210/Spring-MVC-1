package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcMemberListServlet",urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 비즈니스 로직 수행 (회원 목록 뽑음)
        List<Member> memList = memberRepository.findAll();

        //2. Model에 저장
        req.setAttribute("memberList", memList);

        //3. 뷰 이동
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/members.jsp");
        dispatcher.forward(req,resp);

    }
}
