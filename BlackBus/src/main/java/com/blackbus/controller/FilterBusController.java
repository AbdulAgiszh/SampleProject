package com.blackbus.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackbus.daoimpl.BusDaoImpl;

public class FilterBusController extends HttpServlet {


	public void service(HttpServletRequest req,HttpServletResponse res) {
		SimpleDateFormat sdf=new SimpleDateFormat();
		
		
		
		BusDaoImpl busDao=new BusDaoImpl();
		busDao.searchhBus(searchDate, fromLocation, toLocation);
		
	}

	
}
