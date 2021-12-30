<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
    <style>
       *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, Helvetica, sans-serif;
        }
        #homeadmin{
            border: 1px solid black;
            height: 85px;
            background-color: rgb(166, 166, 233);
           
        }
        #homeadmin ul li {
            list-style: none;
            display: inline-block;
            padding: 30px;
            padding-left: 70px;
            }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div id="homeadmin">
        <ul>
            <li><a href="admin.jsp">Profile</a></li>
            <li><a href="addBus.jsp">Add Bus</a></li>
            <li><a href="addOperator.jsp">Add Operator</a></li>
            <li><a href="busList.jsp">Bus list</a></li>
            <li><a href="operatorList.jsp">Operator list</a></li>
            <li><a href="userList.jsp">User list</a></li>
            <li><a href="bookingList.jsp">Booking list</a></li>
        </ul>
    </div>
</body>
</html>