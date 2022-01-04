package com.blackbus.dao;

import java.sql.ResultSet;
import java.util.List;

import com.blackbus.model.Operator;

public interface OperatorDAO {

	public boolean insertOperator(Operator OperatorModel) ;
	
	 public boolean updateOperator (Operator OperatorModel);
	 
	 public boolean deleteOperator (int operatorId);
	 
	 public ResultSet viewOperator();
	 
	 public Operator getOperatorById(int operatorId) ;
}
