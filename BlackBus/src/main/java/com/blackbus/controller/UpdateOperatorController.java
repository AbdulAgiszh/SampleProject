package com.blackbus.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackbus.daoimpl.OperatorDaoImpl;
import com.blackbus.model.Operator;

@WebServlet("/UpdateOpertaorjsp")
public class UpdateOperatorController extends HttpServlet {
	
	OperatorDaoImpl operatorDao=new OperatorDaoImpl();
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session=req.getSession();
		Operator operatorModel=(Operator) session.getAttribute("operatorModel");	
		int operatorId=operatorModel.getOperatorId();
		String operatorName=req.getParameter("operatorName");
		String operatorEmail=req.getParameter("operatorEmail");
		long operatorContact=Long.parseLong(req.getParameter("operatorContact"));
		int operatorAge=Integer.parseInt(req.getParameter("operatorAge"));
		
		Operator operator= new Operator(operatorId,operatorName,
				operatorEmail, operatorContact, operatorAge);
		operatorDao.updateOperator(operator);
		
	}
}
