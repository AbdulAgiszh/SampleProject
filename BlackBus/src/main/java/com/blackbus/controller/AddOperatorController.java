package com.blackbus.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackbus.Dao.OperatorDao;
import com.blackbus.module.OperatorModel;



@WebServlet("/addoperator")
public class AddOperatorController extends HttpServlet {
	
	OperatorDao operatorDao=new OperatorDao();
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		String operatorName=req.getParameter("operatorName");
		String operatorEmail=req.getParameter("operatorEmail");
		long operatorContact=Long.parseLong(req.getParameter("operatorContact"));
		int operatorAge=Integer.parseInt(req.getParameter("operatorAge"));
		
		OperatorModel operatorModel= new OperatorModel(operatorName,
				operatorEmail, operatorContact, operatorAge);
		operatorDao.insertOperator(operatorModel);
	}

}
