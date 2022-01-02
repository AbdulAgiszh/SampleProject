package com.blackbus.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackbus.daoimpl.BusDaoImpl;
import com.blackbus.model.Bus;



@WebServlet("/addbus")
public class AddBusController extends HttpServlet {

	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	BusDaoImpl busDao=new BusDaoImpl();
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
//		int busNo=Integer.parseInt(req.getParameter("busNo"));
//		int operatorId=Integer.parseInt(req.getParameter("operatorId"));
		String busCategory=req.getParameter("busCategory");
		String fromCity=req.getParameter("fromCity");
		String toCity=req.getParameter("toCity");
		LocalDateTime departure=LocalDateTime.parse(req.getParameter("departure"));
		LocalDateTime arrival=LocalDateTime.parse(req.getParameter("arrival"));
		int seaterFare=Integer.parseInt(req.getParameter("seaterFare"));
		int totalSeat=Integer.parseInt(req.getParameter("totalSeat"));
		
		Bus busmodel = new Bus(0,0,0,busCategory, fromCity, toCity,
				departure, arrival, seaterFare, totalSeat,"");
		busDao.insertBus(busmodel);
				
		
		
	}
}
