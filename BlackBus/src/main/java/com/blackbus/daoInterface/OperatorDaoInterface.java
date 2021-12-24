package com.blackbus.daoInterface;

import java.util.List;

import com.blackbus.module.OperatorModel;

public interface OperatorDaoInterface {

	public void insertOperator(OperatorModel OperatorModel) ;
	
	 public void updateOperator (OperatorModel OperatorModel);
	 
	 public boolean deleteOperator (int operatorId);
	 
	 public List<OperatorModel> viewOperator();
	 
	 public OperatorModel getOperatorById(int operatorId) ;
}
