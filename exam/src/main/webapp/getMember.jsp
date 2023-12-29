<%@ page import="member.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    MemberDTO dto = null;
    try {
        dto = (MemberDTO) session.getAttribute("dto");
    } catch (Exception e) {
        e.printStackTrace();
    }
    if(dto == null) {
        response.sendRedirect("http://localhost:8282/test/");
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 상세정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        p {
            margin-bottom: 16px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>회원 상세정보</h2>

    <label for="id">아이디:</label>
    <p id="id"><%=dto.getId()%></p>

    <label for="phone">전화번호:</label>
    <p id="phone"><%=dto.getPhone()%></p>

    <label for="email">이메일:</label>
    <p id="email"><%=dto.getEmail()%></p>

    <label for="regdate">가입일자:</label>
    <p id="regdate"><%=dto.getRegdate()%></p>

    <label for="addr">주소:</label>
    <p id="addr"><%=dto.getAddr()%></p>

    <label for="role">역할:</label>
    <p id="role"><%=dto.getRole()%></p>
    
    <p><button type="button" onclick="location.href='updateMember.us?id=<%=dto.getId()%>'">수정</button></p>
    <p><button type="button" onclick="location.href='delete.us?id=<%=dto.getId()%>'">삭제</button></p>
    <button type="button" onclick="location.href='http://localhost:8282/test/'">home</button>
</div>
</body>
</html>