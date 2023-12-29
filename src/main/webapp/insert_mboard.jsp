<%@ page import="member.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    MemberDTO dto = new MemberDTO();
	try {
		dto = (MemberDTO) session.getAttribute("login");
    } catch (Exception e) {

    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 등록</title>
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

        form {
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

        input, textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<form action="insert.mb" method="post">
    <label for="title">제목:</label>
    <input type="text" id="title" name="m_title" required>

    <label for="content">내용:</label>
    <textarea id="content" name="m_content" rows="4" required></textarea>

    <input type="hidden" name="m_write" value="<%=dto.getId()%>">

    <button type="submit">등록하기</button>
</form>
</body>
</html>