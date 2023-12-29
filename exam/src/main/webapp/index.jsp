<%@ page import="member.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    MemberDTO dto = null;
    try {
        dto = (MemberDTO) session.getAttribute("login");
    } catch (Exception e) {
        e.printStackTrace();
    }

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    if(dto != null  && dto.getId() != null) {
%>
<h2><%=dto.getId()%></h2>
<%=dto.getRole()%><br>
<%
    }
%>
<a href="join.us">회원가입</a>
<a href="memberList.us">회원리스트</a>
<%
    if(dto == null  || dto.getId() == null) {
%>
<a href="loginPage.us">로그인</a>
<%
    } else if(dto != null  && dto.getId() != null) {
%>
<a href="logout.us">로그아웃</a>
<%
    }
%>

<br>
<hr>
<br>
<%
    if(dto != null  && dto.getId() != null && dto.getRole().equals("admin")) {
%>
<a href="insertPage.pd">상품등록</a>
<a href="prodList.pd">상품리스트</a>

<%
    } else if(dto != null  && dto.getId() != null && dto.getRole().equals("user")) {
%>
<a href="insertPage.mb">게시물 등록</a>
<a href="mboard_list.mb">게시물 목록</a>

<%
    }
%>




</body>
</html>