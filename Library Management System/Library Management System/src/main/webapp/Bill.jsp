<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>

<style>
    /* General Styles */
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(135deg, #74EBD5, #ACB6E5);
        color: #333;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        background: #fff;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 15px 30px rgba(0, 0, 0, 0.3);
        max-width: 600px;
        width: 90%;
        animation: fadeIn 1s ease-in-out;
    }

    /* Heading Styles */
    h1 {
        font-size: 36px;
        color: #2c3e50;
        text-align: center;
        margin-bottom: 30px;
    }

    /* Labels & Values Side by Side */
    .details {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 15px 0;
        border-bottom: 1px solid #ddd;
    }

    .label {
        font-weight: bold;
        font-size: 20px;
        color: #555;
    }

    .value {
        font-size: 22px;
        color: #007BFF;
        font-weight: bold;
    }

    /* Hover Effect */
    .value:hover {
        color: #FF5733;
        transition: 0.3s;
    }

    /* Button Styles */
    .btn {
        display: inline-block;
        padding: 12px 30px;
        font-size: 18px;
        color: #fff;
        text-decoration: none;
        border-radius: 8px;
        transition: background 0.3s;
        margin: 20px 10px;
        text-align: center;
    }

    /* Individual Button Colors */
    .btn-print {
        background: #28a745; /* Green */
    }

    .btn-print:hover {
        background: #218838;
    }

    .btn-home {
        background: #007BFF; /* Blue */
    }

    .btn-home:hover {
        background: #0056b3;
    }

    .btn-logout {
        background: #dc3545; /* Red */
    }

    .btn-logout:hover {
        background: #c82333;
    }

    /* Animation */
    @keyframes fadeIn {
        from {
            opacity: 0;
            transform: translateY(-30px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }
</style>

</head>

<body>

<% 
    // Retrieving attributes
    String id = (String) request.getAttribute("id");
    String bookName = (String) request.getAttribute("bookName");
    int priceStr = (Integer) request.getAttribute("price");
%>

<div class="container">
    <h1> Book Details</h1>

    <div class="details">
        <p class="label">Book ID:</p>
        <p class="value"><%= id != null ? id : "N/A" %></p>
    </div>

    <div class="details">
        <p class="label">Book Name:</p>
        <p class="value"><%= bookName != null ? bookName : "N/A" %></p>
    </div>

    <div class="details">
        <p class="label">Book Price:</p>
        <p class="value">Rs. <%= priceStr %></p>
    </div>

    <a href="#" class="btn btn-print">Make Payment</a>
    <a href="home.html" class="btn btn-home">Back to Home</a>
    <a href="lout" class="btn btn-logout">Logout</a>
</div>

</body>
</html>
