<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<style>
    /* General Styling */
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #74ebd5, #acb6e5);
        color: #333;
        text-align: center;
        margin: 0;
        padding: 0;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    h1 {
        color: #444;
        font-size: 36px;
        margin-bottom: 20px;
        animation: fadeIn 1s ease-in-out;
    }

    form {
        background: #fff;
        padding: 40px;
        width: 400px;
        box-shadow: 0 15px 30px rgba(0, 0, 0, 0.3);
        border-radius: 12px;
        animation: slideIn 0.8s ease-in-out;
    }

    /* Button Styling */
    button {
        background: #007bff;
        color: white;
        padding: 12px 25px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        width: 100%;
        margin: 12px 0;
        font-size: 18px;
        transition: all 0.3s;
        box-shadow: 0 5px 15px rgba(0, 123, 255, 0.3);
    }

    button:hover {
        background: #0056b3;
        transform: translateY(-3px);
        box-shadow: 0 8px 20px rgba(0, 123, 255, 0.5);
    }

    /* Logout Button Styling */
    #bt {
        background: #dc3545; 
        transition: all 0.3s;
    }

    #bt:hover {
        background: #c82333;
        transform: translateY(-3px);
        box-shadow: 0 8px 20px rgba(220, 53, 69, 0.5);
    }

    /* Form Animation */
    @keyframes slideIn {
        from {
            opacity: 0;
            transform: translateY(-30px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }

    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        form {
            width: 90%;
            padding: 30px;
        }

        button {
            font-size: 16px;
            padding: 10px;
        }
    }

    @media (max-width: 480px) {
        form {
            width: 95%;
            padding: 25px;
        }

        h1 {
            font-size: 28px;
        }

        button {
            font-size: 14px;
            padding: 8px;
        }
    }
</style>
</head>

<body>

    <div>
        <h1>Welcome Admin</h1>
        <form action="Admindis" method="post">
            <button type="submit" name="sb" value="add">Add Book</button>
            <button type="submit" name="sb" value="delete">Delete Book</button>
            <button type="submit" name="sb" value="update">Update Book</button>
            <button type="submit" name="sb" value="view">View All Books</button>
            <button type="submit" name="sb" value="logout" id="bt">Log Out</button>
        </form>
    </div>

</body>
</html>
