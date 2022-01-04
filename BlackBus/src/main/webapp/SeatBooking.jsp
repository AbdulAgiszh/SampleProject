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
       
       // busId coming filterjsp class
       int busId=Integer.parseInt(request.getParameter("busIdValue")); 
       
 
      
       session.setAttribute("currentBusId", busId );
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
  
    <fieldset >
        <legend>Booking Form</legend>
        <form  action="bookingPage" onmouseover="check()">
        <div id="bookingdiv" >
        <table id="seatbookingtable">
            <tr>
                <td><label for="pickuppoint">Pickup Point : <input type="text" id="pickuppoint" value="<%=busModel.getFromCity() %>"></label></td>
                <td><label for="pickuptime">Pickup Time  : <input type="text" id="pickuptime" value="<%=busModel.getDeparture().toLocalTime()%>"></label></td>
            </tr>
            <tr>
                <td><label for="dropoffpoint">DropOff Point  : <input id="dropoffpoint" type="text" value="<%=busModel.getToCity()%>"></label></td>
                <td><label for="dropofftime">DropOff Time  : <input id="dropofftime" type="text" value="<%=busModel.getArrival().toLocalTime()%>"></label></td>
            </tr>
        </table>
        <table id="seatinfotable">
            <tr>
                <td> <label for="buscategory">Bus Category :  </label></td>
                <td><input id="buscategory" type="text" value="<%=busModel.getBusCategory() %>" ></td>
            </tr>
            <tr>
                <td><label for="availableseat">Available Seat : </label></td>
                <td><input id="availableseat" type="text" value="<%=busModel.getTotalseat()%> "readonly ></td>
            </tr>
            <tr>
                <td><label for="noofselectedseat">No OF Seats Selected :</label></td>
                <td><input id="noofseatsselected" name="noofseats" type="text" readonly ></td>
            </tr>
            <tr>
                <td><label for="totalfair">Total Fair :</label></td>
                <td><input id="totalFair" name="totalFair" type="text" readonly ></td>
            </tr>
            <tr>
                <td><input id="randomnumber" name="randomnumber" type="text" style="visibility: hidden;" ></td>
            </tr>
         </table>

         <div id="seatcountdiv">
            <label for="seatercount">Seater Count</label>
            <select name="seatcount" id="seatcount" >
            <%int totalSeat=busModel.getTotalseat();
            for(int i=1;i<=totalSeat;i++) { %>
                <option  value="<%=i%>"><%=i%></option>
               <%} %>
              </select>
           </div>


         <button id="btn" name="btn" type="submit">BookTicket</button>
    </div>
    </form>  
        </fieldset>

</body>

<script type="text/javascript">

function check(){


var numberSeats=document.getElementById('noofseatsselected'); 
var price=document.getElementById('totalFair');
var seatcount=document.getElementById('seatcount');
var randomNo=document.getElementById('randomnumber');

var count=seatcount.options[seatcount.selectedIndex].value;
console.log(count);

numberSeats.value=count;
price.value=<%=busModel.getSeaterFare()%>*count;

console.log(numberSeats.value);
console.log(price.value);


var text = "";
var random = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

for (var i = 0; i < 7; i++)
  text += random.charAt(Math.floor(Math.random() * random.length));


randomNo.value=text;
console.log(randomNo.value);
}



</script>
</html>