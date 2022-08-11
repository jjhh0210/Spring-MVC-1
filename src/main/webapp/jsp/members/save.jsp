<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%
    //request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    //1) parsing
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    //2) save
    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id = <%=member.getId()%></li>
    <li>username = <%=member.getUsername()%></li>
    <li>age = <%=member.getAge()%></li>
    <li>grade = <%=member.getGrade()%></li>

</ul>
<a href="/jsp/members/new-form.jsp">폼으로 돌아가기</a>
<a href ="/index.html">메인</a>
</body>
</html>