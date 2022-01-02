<%@page import="com.blackbus.daoimpl.UserDaoImpl"%>
<%@page import="com.blackbus.model.User"%>
<%@page import="com.blackbus.model.BookedTickets"%>
<%@page import="com.blackbus.model.Bus"%>
<%@page import="com.blackbus.daoimpl.BusDaoImpl"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% BusDaoImpl busDao=new BusDaoImpl();
       UserDaoImpl userDao=new UserDaoImpl(); 
       User userModel=(User)session.getAttribute("userModel");
       
       int busId=Integer.parseInt(request.getParameter("busIdValue")); 
       Bus busModel=busDao.findBusDetailsUsingID(busId);
       
       User userModel1=userDao.getUserDetailsById(userModel.getUserId());%>
       
       
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
        ul,li{
            list-style: none;
            display: flex;
            margin-left: 15px;
            padding: 70px;
            padding-left: 10px;
            padding-top: 0px;
            margin-top: 15px;
        }
        #nav{
            border: 1px solid blanchedalmond ;
            height: 90px;
            background-color: blanchedalmond;
        }
        #nav a{
            text-decoration: none;
            font-size: 20px;
        }
        
        #signlink {
            display: flex;
            margin-left: 540px;
        }


		.dropdown .dropbtn {
            font-size: 20px;  
            border: none;
            outline: none;
            color: rgb(113, 99, 177);
        }
        .dropbtn{
            font-size: 20px;  
            border: none;
            outline: none;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
  
        }

        .dropdown-content a {
            float: none;
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: #ddd;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }
        
        
        fieldset{
            padding: 40px;
        }
        #bookingdiv{
            border: 1px solid black;
            border-radius: 30px;
            padding-left: 100px;
            padding: 60px;
            width: 700px;
            margin-left: 270px;
        }
        legend{
            font-size: xx-large;
            text-align: center;
        }
        #seatbookingtable tr td{
            padding: 15px;
        }
        #seatinfodiv{
            padding: 20px;
        }
        #seatinfotable tr td{
            padding: 15px;
            padding-left: 30px;
        }
        #seatcount{
            width: 70px;
            height: 35px;
            text-align: center;
        }
        label{
            font-size: larger;
        }
        #seatcountdiv{
            margin-left: 120px;
        }
        #btn{
            height: 45px;
            width: 120px;
            background-color: rgb(129, 168, 252);
            outline: none;
            border: none;
            margin-left: 100px;
            margin-top: 30px;
            cursor:pointer;
        }
        #btn:hover{
            background-color: rgb(247, 112, 112);
        }
    </style>
</head>
<body>
    <fieldset>
        <legend>Booking Form</legend>
        <div id="bookingdiv" >
        <table id="seatbookingtable">
            <tr>
                <td><label for="pickuppoint">Pickup Point : <span><%=busModel.getFromCity() %></span></label></td>
                <td><label for="pickuptime">Pickup Time  : <span><%=busModel.getDeparture().toLocalTime()%></span></label></td>
            </tr>
            <tr>
                <td><label for="dropoffpoint">DropOff Point  : <span><%=busModel.getToCity()%></span></label></td>
                <td><label for="dropofftime">DropOff Time  : <span><%=busModel.getArrival().toLocalTime()%></span></label></td>
            </tr>
        </table>
        <table id="seatinfotable">
            <tr>
                <td> <label for="totalseat">Bus Category :  <span><%=busModel.getBusCategory() %></span></label></td>
            </tr>
            <tr>
                <td><label for="availableseat">Available Seat : <span><%=busModel.getTotalseat()%></span></label></td>
            </tr>
            <tr>
                <td><label for="noofselectedseat">No OF Seats Selected : <span></span></label></td>
            </tr>
         </table>

         <div id="seatcountdiv">
            <label for="seatercount">Seater Count</label>
            <select name="seatcount" id="seatcount">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
              </select>
           </div>

         <button id="btn" name="btn" type="submit">BookTicket</button>
    </div>
    
        </fieldset>
        
    </div>
    
    <%BookedTickets bookTickets=new BookedTickets(0,userModel1,busModel,busModel.getBusNo(),"bookingdate",busModel.getDeparture().toLocalDate().format(formatter),
    		"","ticketcount",);
      %>

</body>
</html>