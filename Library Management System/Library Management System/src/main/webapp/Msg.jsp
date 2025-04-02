<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Session Expired</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #f06, #3cf);
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #fff;
        }
        .container {
            background: rgba(0, 0, 0, 0.8);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            text-align: center;
            max-width: 500px;
        }
        h1 {
            font-size: 28px;
        }
        button {
            background: #28a745;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            transition: background 0.3s;
        }
        button:hover {
            background: #218838;
        }
    </style>
</head>
<body>

<div class="container">
    <%
        String ms = (String) request.getAttribute("msg");
        if (ms == null) {
            ms = "Session expired.";
        }
    %>
    <h1><%= ms %> Please login again.</h1>
    
    <button onclick="goToHome()">Go to Home</button>
</div>

<script>
    function goToHome() {
        window.location.href = "home.html";   // Navigate to home.html
    }
</script>

</body>
</html>
