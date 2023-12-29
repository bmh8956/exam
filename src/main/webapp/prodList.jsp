<%@ page import="product.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<ProductDTO> list = null;
    try {
        list = (List<ProductDTO>) session.getAttribute("list");
    } catch (Exception e) {

    }
%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 목록</title>
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
        <th>상품명</th>
        <th>가격</th>
        <th>상세 설명</th>
        <th>등록일자</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (list == null || list.isEmpty()) {
    %>
    <tr>
        <td colspan="5">입력된 상품이 없습니다.</td>
    </tr>
    <%
    } else if (list != null && !list.isEmpty()) {
        for (ProductDTO dto : list) {
    %>
    <tr>
        <td><%=dto.getId()%>
        </td>
        <td><a href="getProd.pd?id=<%=dto.getId()%>"><%=dto.getName()%></a>
        </td>
        <td><%=dto.getPrice()%>
        </td>
        <td><%=dto.getContent()%>
        </td>
        <td><%=dto.getRegdate()%>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
    <br>
    <button type="button" onclick="location.href='http://localhost:8282/test/'">home</button>
</table>
</body>
</html>