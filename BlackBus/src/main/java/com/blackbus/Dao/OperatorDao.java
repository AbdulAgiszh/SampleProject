package com.blackbus.dao;

import java.sql.ResultSet;
import java.util.List;

import com.blackbus.model.Operator;

public interface OperatorDAO {

	public void insertOperator(Operator OperatorModel) ;
	
	 public void updateOperator (Operator OperatorModel);
	 
	 public boolean deleteOperator (int operatorId);
	 
	 public ResultSet viewOperator();
	 
	 public Operator getOperatorById(int operatorId) ;
}
