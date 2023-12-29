<%@ page import="m_board.M_boardDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    List<M_boardDTO> list = null;
	try {
		list = (List<M_boardDTO>) session.getAttribute("list");
    } catch (Exception e) {
	    e.printStackTrace();
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록</title>
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

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #4caf50;
            color: #fff;
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
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일자</th>
        <th>조회수</th>
    </tr>
    </thead>
    <tbody>
    <%
        if(list != null && !list.isEmpty()) {
			for(M_boardDTO dto : list) {
    %>
    <tr>
        <td><%=dto.getId()%></td>
        <td><a href="get_mboard.mb?id=<%=dto.getId()%>"><%=dto.getM_title()%></a></td>
        <td><%=dto.getM_write()%></td>
        <td><%=dto.getRegdate()%></td>
        <td><%=dto.getCnt()%></td>
    </tr>
    <%
        }
		} else {
    %>
        <tr>
            <td colspan="5">등록된 게시물이 없습니다.</td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>
<br>
<button type="button" onclick="location.href='http://localhost:8282/test/'">home</button>
</body>
</html>