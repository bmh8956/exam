<%@ page import="product.ProductDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    ProductDTO dto = new ProductDTO();
    try {
        dto = (ProductDTO) session.getAttribute("dto");
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세 정보</title>
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
    <h2>상품 상세 정보</h2>
    <form action="updateProd.pd" method="post">
        <label for="id">상품 ID:</label>
        <p id="id"><%=dto.getId()%></p>
        <input type="hidden" name="id" value="<%=dto.getId()%>">


        <label for="name">상품명:</label>
        <p id="name"><input type="text" name="name" value="<%=dto.getName()%>"></p>


        <label for="price">가격:</label>
        <p id="price"><input type="number" name="price" value="<%=dto.getPrice()%>"></p>


        <label for="content">상세 설명:</label>
        <p id="content"><textarea name="content"><%=dto.getContent()%></textarea></p>


        <label for="regdate">등록일자:</label>
        <p id="regdate"><%=dto.getRegdate()%></p>
        <button type="submit">저장</button>
        <button type="button" onclick="location.href='delete.pd?id=<%=dto.getId()%>'">삭제</button>
        <button type="button" onclick="location.href='prodList.pd'">목록</button>
    </form>
</div>
</body>
</html>