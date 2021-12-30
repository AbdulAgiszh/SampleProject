<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.blackbus.Dao.OperatorDao" %>
    <%@page import="java.sql.ResultSet" %>
    <%OperatorDao operatorDao=new OperatorDao();
    ResultSet rs=operatorDao.viewOperator();%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
        #operatorlistdiv table tr th,td {
            padding: 20px;
            text-align: center;
            border: 1px solid black;
            border-collapse: collapse;
         }
        #operatorlistfieldset{
            margin-top: 20px;
            margin-left: 200px;
            width: 900px;
        }
        #operatorlistdiv{
            padding: 35px;
            margin-left: 20px;
            margin-top: 10px;
        }
        legend{
            font-size: 30px;
            text-align: center;
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

    <fieldset id="operatorlistfieldset">
        <legend>Operator_Details</legend>
    <div id="operatorlistdiv">
        <table>
            <tr>
                <th>Operator Id</th>
                <th>Operator Name</th>
                <th>Operator Email</th>
                <th>Operator Contact</th>
                <th>Operator Age</th>
            </tr>
            <% while(rs.next()){ %>
                <tr>
                    <td><%=rs.getInt(1) %></td>
                    <td><%=rs.getString(2) %></td>
                    <td><%=rs.getString(3) %></td>
                    <td><%=rs.getLong(4) %></td>
                    <td><%=rs.getInt(5) %></td>
                </tr>
                <%} %>
        
        </table>
  </div>
</fieldset>

</body>
</html>