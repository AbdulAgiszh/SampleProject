package com.blackbus.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackbus.daoimpl.OperatorDaoImpl;
import com.blackbus.model.Operator;



@WebServlet("/addoperator")
public class AddOperatorController extends HttpServlet {
	
	OperatorDaoImpl operatorDao=new OperatorDaoImpl();
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		String operatorName=req.getParameter("operatorName");
		String operatorEmail=req.getParameter("operatorEmail");
		long operatorContact=Long.parseLong(req.getParameter("operatorContact"));
		int operatorAge=Integer.parseInt(req.getParameter("operatorAge"));
		
		Operator operatorModel= new Operator(operatorName,
				operatorEmail, operatorContact, operatorAge);
		operatorDao.insertOperator(operatorModel);
	}

}
