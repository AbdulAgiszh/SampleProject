<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.blackbus.daoimpl.BusDaoImpl" %>
    <%@page import java.util.List; %>
    <%@page import="java.sql.ResultSet" %>
    <%
    BusDaoImpl busDao=new BusDaoImpl();
        String fromLocation=req.getParameter("fromlocation");
    	String toLocation=req.getParameter("tolocation");
    	LocalDate searchDate=LocalDate.parse(req.getParameter("searchdate"));
        ResultSet rs=busDao.searchhBus(givenDepartureDate, fromLocation, toLocation);
    %>
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
         legend{
             border: 1px solid black;
             height: 33px;
             width: 170px;
             padding: 5px;
             border-radius: 10px;
             background-color: rgb(224, 209, 209);
         }
         legend h3{
             margin-left: 7px;
         }
         table,tr,th,td{
             text-align: center; 
             border: 1px solid black;
             width: 1200px;
             height: 60px;
             border: none;
             margin-left: 15px;
         }
         th{
             background-color: rgb(184, 71, 71);
             color: white;
         }
         #outerlinetable{
             border: 1px solid rgb(32, 32, 32);
             padding: 20px;
         }
         #fieldsettable{
             padding: 40px;
             margin-left: 2px;
             
         }
         #forcontent{
            border: 1px solid rgb(32, 32, 32);
             padding: 20px;
             border-bottom: none;
             border-radius: 10px 10px 0px 0px;
             height: 20px;
             background-color: rgb(138, 93, 93);
             color: white;
             margin-top: -15px;
         }
         #forcontentinlist{
             padding: 0px;
             list-style: none;
             display: flex;
             margin-top: -8px;
         }
         #backbutton{
            height: 30px;
            width: 150px;
            margin-left: 550px;
            margin-top: -30px ;
         }
        </style>
    </head>
    <body>
        <div>
            <fieldset id="fieldsettable">
                <legend><h3>Available Buses</h3></legend>
                <div id="forcontent">
                      <ul id="forcontentinlist">
                        <li><h4></h4></li>
                        <li><p>to</p></li>
                        <li><h4></h4>-</li>
                        <li><h4>Journey Date :</h4></li>
                        <li><h4></h4></li>
                    </ul>
                </div>
                <div id="outerlinetable">
                    <table>
                        <tr>
                            <th>Type</th>
                            <th>Departure</th>
                            <th>Arrival</th>
                            <th>Start Point</th>
                            <th>Destination</th>
                            <th>Sleeper Fare</th>
                            <th>Seater Fare</th>
                            <th>Select Service</th>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><a href="seatbooking.html">Book</a></td>
                        </tr>
                    </table>
                </div>
                
            </fieldset>
            <button id="backbutton" type="submit"><a href="index.html">GO BACK TO HOME</a></button>
        </div>
    </body>
    </html>