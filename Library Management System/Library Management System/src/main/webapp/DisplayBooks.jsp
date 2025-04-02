<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
<style>
    /* Page Styling */
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #74ebd5, #acb6e5);
        color: #333;
        margin: 0;
        padding: 0;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    h1 {
        color: #333;
        font-size: 32px;
        margin: 20px 0;
        text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.3);
        animation: fadeIn 0.8s ease-in-out;
    }

    table {
        width: 85%;
        max-width: 1200px;
        border-collapse: collapse;
        background: #fff;
        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        border-radius: 12px;
        overflow: hidden;
        animation: slideIn 0.8s ease-in-out;
    }

    th, td {
        padding: 15px;
        border: 1px solid #ddd;
        text-align: center;
        font-size: 16px;
    }

    th {
        background: #007bff;
        color: #fff;
        letter-spacing: 1px;
        font-weight: bold;
        text-transform: uppercase;
    }

    td {
        transition: all 0.3s ease;
    }

    tr:nth-child(even) {
        background: #f9f9f9;
    }

    tr:hover {
        background: #f1f1f1;
        transform: scale(1.02);
        transition: all 0.3s ease;
    }

    td:nth-child(4), td:nth-child(5) {
        font-weight: bold;
        color: #28a745; /* Green for price and quantity */
    }

    td[colspan="5"] {
        color: red;
        font-style: italic;
        font-weight: bold;
    }

    /* Button Styling */
    .back-btn {
        display: inline-block;
        margin: 20px;
        padding: 12px 25px;
        color: #fff;
        background: #007bff;
        text-decoration: none;
        border-radius: 25px;
        box-shadow: 0 8px 15px rgba(0, 123, 255, 0.3);
        transition: all 0.3s ease-in-out;
    }

    .back-btn:hover {
        background: #0056b3;
        box-shadow: 0 12px 20px rgba(0, 123, 255, 0.5);
        transform: translateY(-5px);
    }

    /* Animations */
    @keyframes fadeIn {
        from {
            opacity: 0;
            transform: translateY(-20px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }

    @keyframes slideIn {
        from {
            opacity: 0;
            transform: translateX(-100px);
        }
        to {
            opacity: 1;
            transform: translateX(0);
        }
    }

    /* Responsive Design */
    @media screen and (max-width: 768px) {
        table {
            width: 95%;
        }

        th, td {
            padding: 10px;
            font-size: 14px;
        }

        .back-btn {
            padding: 10px 20px;
            font-size: 14px;
        }
    }
</style>
</head>
<body>

<h1>Viewing All the Books</h1>

<table>
    <tr>
        <th>Book ID</th>
        <th>Book Name</th>
        <th>Book Author</th>
        <th>Book Price</th>
        <th>Book Quantity</th>
    </tr>
    <%
    List<List<String>> list = (List<List<String>>) request.getAttribute("list");
    if (list != null && !list.isEmpty()) {
        for (List<String> row : list) {
    %>
    <tr>
        <td><%= row.get(0) %></td>
        <td><%= row.get(1) %></td>
        <td><%= row.get(2) %></td>
        <td>$<%= row.get(3) %></td>
        <td><%= row.get(4) %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">No Books to display</td>
    </tr>
    <%
    }
    %>
</table>

<a href="loginsuccess.jsp" class="back-btn"> Back to Admin Page</a>

</body>
</html>
