<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
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
<form action="insertUser.us" method="post">
    <label for="id">아이디:</label>
    <input type="text" id="id" name="id" required>

    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password" required>

    <label for="phone">전화번호:</label>
    <input type="text" id="phone" name="phone" required>

    <label for="email">이메일:</label>
    <input type="email" id="email" name="email">

    <label for="addr">주소:</label>
    <input type="text" id="addr" name="addr">
    
    <label for="role">권한</label>
    <select name="role" id="role">
        <option value="user">user</option>
        <option value="admin">admin</option>
    </select><br>

    <button type="submit">가입하기</button>
    <button type="button" onclick="location.href='http://localhost:8282/test/'">home</button>
</form>
</body>
</html>