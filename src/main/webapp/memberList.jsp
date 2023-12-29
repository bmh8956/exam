        <%@ page import="member.MemberDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    List<MemberDTO> list = null;
    try {
        list = (List<MemberDTO>) session.getAttribute("list");
    } catch (Exception e) {
        e.printStackTrace();
    }


%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 리스트</title>
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
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>전화번호</th>
                <th>이메일</th>
                <th>가입일자</th>
                <th>주소</th>
                <th>역할</th>
            </tr>
        </thead>
        <tbody>
            <%
                if (list != null && !list.isEmpty()) {
                    for(MemberDTO dto : list) {
            %>
            <tr>
                <td><a href="getMember.us?id=<%=dto.getId()%>"><%=dto.getId()%></a></td>
                <td><%=dto.getPhone()%></td>
                <td><%=dto.getEmail()%></td>
                <td><%=dto.getRegdate()%></td>
                <td><%=dto.getAddr()%></td>
                <td><%=dto.getRole()%></td>
            </tr>
            <%
                }
                } else {
            %>
            <tr>
                <td colspan="6">입력된 데이터가 없습니다.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <button type="button" onclick="location.href='http://localhost:8282/test/'">home</button>
</body>
</html>