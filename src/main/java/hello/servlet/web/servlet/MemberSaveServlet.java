package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //1) html form으로 전송된 데이터를 getParameter로 파싱
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        //2) 데이터를 회원 저장소에 저장(비즈니스로직)
        Member member = new Member(username, age);
        memberRepository.save(member);

        //3) 응답 -> html코드로 내림(동적 html)
        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");

        PrintWriter w = res.getWriter();
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                " <li>id="+member.getId()+"</li>\n" +
                " <li>username="+member.getUsername()+"</li>\n" +
                " <li>age="+member.getAge()+"</li>\n" +
                " <li>grade="+member.getGrade()+"</li>\n" +
                "</ul>\n" +
                "<a href=\"/servlet/members/new-form\">폼으로</a>\n" +
                "<a href=\"/servlet/members\">회원 목록</a>\n" +
                "</body>\n" +
                "</html>");

    }
}
