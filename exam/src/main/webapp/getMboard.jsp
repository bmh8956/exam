<%@ page import="m_board.M_boardDTO" %>
<%@ page import="member.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    M_boardDTO dto = null;
    MemberDTO login = null;
    try {
        dto = (M_boardDTO) session.getAttribute("dto");
        login = (MemberDTO) session.getAttribute("login");
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 상세 정보</title>
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

        h2 {
            margin-bottom: 16px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        p {
            margin-bottom: 16px;
        }

        a {
            text-decoration: none;
            color: #007BFF;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<form action="update.mb" method="post">
<div class="container">
    <label for="id">게시물 ID:</label>
    <p id="id"><%=dto.getId()%></p>
    <input type="hidden" name="id" value="<%=dto.getId()%>">

    <label for="title">제목:</label>
    <%
        if (dto.getM_write() != null && login.getId().equals(dto.getM_write())) {
    %>
    <p id="title"><input type="text" name="m_title" value="<%=dto.getM_title()%>"></p>
    <label for="write">등록자:</label>
    <p id="write"><input type="text" name="m_write" value="<%=dto.getM_write()%>" readonly></p>
    <%
    } else {
    %>
    <p id="title"><%=dto.getM_title()%>
    </p>
    <%
        }
    %>

    <label for="content">내용:</label>
    <%
        if (dto.getM_write() != null && login.getId().equals(dto.getM_write())) {
    %>
    <p id="content"><input type="text" name="m_cont" value="<%=dto.getM_cont()%>"></p>
    <%
        } else {
    %>
    <p id="content"><%=dto.getM_cont()%></p>
    <%
        }
    %>
    <label for="regdate">등록일자:</label>
    <p id="regdate"><%=dto.getRegdate()%></p>

    <a href="mboard_list.mb">게시판 목록으로 돌아가기</a>
    <%
        if (dto.getM_write() != null && login.getId().equals(dto.getM_write())) {
    %>
    <button type="submit">저장</button>
    <button type="button" onclick="location.href='delete.mb?id=<%=dto.getId()%>'">삭제</button>
    <%
        }
    %>
    <button type="button" onclick="location.href='http://localhost:8282/test/'">home</button>
</div>
</form>
</body>
</html>