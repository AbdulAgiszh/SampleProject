<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.blackbus.Dao.BookedTicketsDao" %>
    <%@page import="java.time.LocalDate" %>
    <%@page import="java.sql.ResultSet" %>
    <%BookedTicketsDao bookDao=new BookedTicketsDao();
    ResultSet rs=bookDao.showlistAdmin();%>
    
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
                margin-top: 25px;
                margin-left: 50px;
                width: 1000px;
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
            
        <fieldset id="operatorlistfieldset">
            <legend>Booking List</legend>
        <div id="operatorlistdiv">
            <table>
                <tr>
                    <th>Booking Id</th>
                    <th>User Id</th>
                    <th>Bus Id</th>
                    <th>Booking Date</th>
                    <th>Departure Date</th>
                    <th>Ticket Count</th>
                    <th>Seat Category</th>
                    <th>Seat No</th>
                    <th>Booking Status</th>
                    <th>Total Price</th>
                    <th>Payment Status</th>
                </tr>
                <% while(rs.next()){ %>
                <tr>
                    <td><%=rs.getInt(1) %></td>
                    <td><%=rs.getInt(2) %></td>
                    <td><%=rs.getInt(3) %></td>
                    <td><%=rs.getDate(4).toLocalDate()%></td>
                    <td><%=rs.getDate(5).toLocalDate()%></td>
                    <td><%=rs.getInt(6) %></td>
                    <td><%=rs.getString(7) %></td>
                    <td><%=rs.getString(8) %></td>
                    <td><%=rs.getString(9) %></td>
                    <td><%=rs.getInt(10) %></td>
                    <td><%=rs.getString(11) %></td>
                </tr>
                <%} %>
            </table>
      </div>
    </fieldset>
    </div>
</body>
</html>