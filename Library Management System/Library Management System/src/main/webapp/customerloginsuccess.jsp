<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #ff005d, #7a7aff);
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            text-align: center;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        .message {
            color: green;
            font-size: 20px;
            margin-bottom: 20px;
        }
     
     button {
        width: 100%;
        padding: 12px;
        background: #28a745;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: all 0.3s;
    }

    button:hover {
        background: #218838;
        box-shadow: 0 8px 20px rgba(40, 167, 69, 0.5);
        transform: translateY(-3px);
    }
    
    #bt{
    	background: blue;
    } 
    
    a {
    	
    	color: white;
    	text-decoration: none;
    }
    </style>
</head>
<body>

<div class="container">
    <div class="message">
        <%= request.getAttribute("message") %>
    </div>
    <h1>Welcome Customer: <%= request.getAttribute("custname") %></h1>
    <button id="bt"><a href="Disp">View all Books</a></button>
</div>

</body>
</html>
