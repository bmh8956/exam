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

    <form action="modi.us" method="post">
    <label for="id">아이디:</label>
    <p id="id"><input type="text" name="id" value="<%=dto.getId()%>" readonly></p>
    
    <label for="password">비밀번호:</label>
    <p id="password"><input type="password" name="password" value="<%=dto.getPassword()%>"></p>

    <label for="phone">전화번호:</label>
    <p id="phone"><input type="text" name="phone" value="<%=dto.getPhone()%>"></p>

    <label for="email">이메일:</label>
    <p id="email"><input type="text" name="email" value="<%=dto.getEmail()%>"></p>

    <label for="regdate">가입일자:</label>
    <p id="regdate"><input type="text" name="regdate" value="<%=dto.getRegdate()%>" readonly></p>

    <label for="addr">주소:</label>
    <p id="addr"><input type="text" name="addr" value="<%=dto.getAddr()%>"></p>

    <label for="role">역할:</label>
    <p id="role">
        <select name="role" >
            <option value="user" <%=(dto.getRole().equals("user"))? "selected" : ""%>>user</option>
            <option value="admin" <%=(dto.getRole().equals("admin"))? "selected" : ""%>>admin</option>
        </select>
    </p>

    <p><button type="submit">수정</button></p>
    <p><button type="button" onclick="location.href='memberList.us'">목록</button></p>
    <p><button type="button" onclick="location.href='delete.us?id=<%=dto.getId()%>'">삭제</button></p>
    </form>
</div>
</body>
</html>