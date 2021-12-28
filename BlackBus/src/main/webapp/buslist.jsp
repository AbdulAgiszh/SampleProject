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
       
        #buslistdiv table tr th,td {
            padding: 20px;
            text-align: center;
            border: 1px solid black;
            border-collapse: collapse;
         }
        #buslistfieldset{
            margin-top: 20px;
            padding: 10px;
        }
        #buslistdiv{
            padding: 20px;
            
            margin-top: 20px;
        }
        legend{
            font-size: 30px;
            text-align: center;
        }
    </style>
    <body>
        <div id="homeadmin">
            <ul>
                <li><a href="adminProfile.jsp">Profile</a></li>
                <li><a href="addBus.jsp">Add Bus</a></li>
                <li><a href="addOperator.jsp">Add Operator</a></li>
                <li><a href="busList.jsp">Bus list</a></li>
                <li><a href="operatorList.jsp">Operator list</a></li>
                <li><a href="userList.jsp">User list</a></li>
                <li><a href="bookingList.jsp">Booking list</a></li>
            </ul>
                
        </div>
        <fieldset id="buslistfieldset">
            <legend>Bus_Details</legend>
        <div id="buslistdiv">
            <table>
                <tr>
                    <th>Bus Id</th>
                    <th>Operator Id</th>
                    <th>Bus Category</th>
                    <th>From City</th>
                    <th>To City</th>
                    <th>Departure</th>
                    <th>Arrival</th>
                    <th>Sleeper Fare</th>
                    <th>Seater Fare</th>
                    <th>Total Seat</th>
                    <th>Status</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                </tr>
            </table>
      </div>
    </fieldset>
    </body>

</html>