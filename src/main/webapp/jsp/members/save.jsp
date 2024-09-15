<%@ page import="com.hyunzinbak.servlet.domain.member.MemberRepository" %>
<%@ page import="com.hyunzinbak.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
        <% ~~ %> :
        자바 코드를 그대로 사용 할 수 있다.
--%>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("save.jsp");

    // request, response 사용 가능
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <%--
            <%= ~~ %> :
            자바 코드를 출력할 수 있다.
    --%>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
