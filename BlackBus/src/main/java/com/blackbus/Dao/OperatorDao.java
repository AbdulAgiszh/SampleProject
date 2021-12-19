package com.blackbus.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.module.OperatorModel;
import com.blackbus.module.UserModel;


public class OperatorDao {

	public void insertOperator(OperatorModel OperatorModel) {
		String insertbus = "insert into bus_operators (OPERATOR_NAME,OPERATOR_EMAIL,OPERATOR_CONTACT, OPERATOR_AGE) values (?,?,?,?)";
		try {
			Connection con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(insertbus);

			pstatement.setString(1, OperatorModel.getOperatorName());
			pstatement.setString(2, OperatorModel.getOperatorEmail());
			pstatement.setLong(3, OperatorModel.getOperatorContact());
			pstatement.setInt(4, OperatorModel.getOperatorAge());
			

			int result = pstatement.executeUpdate();
			if (result == 1) {
				System.out.println("Bus Operators added successfully");
				pstatement.close();
				con.close();
			} else {
				System.out.println("Failed to add the Bus Operators");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	
   public void updateOperator (OperatorModel OperatorModel) {
    	
    	String operatorUpdate="update bus_operators set operator_name=?, operator_email=?, operator_contact=?, operator_age=? where operator_id='"+OperatorModel.getOperatorId()+"'";
    	
    	Connection con;
    	
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement=con.prepareStatement(operatorUpdate);
			
			pstatement.setString(1,OperatorModel.getOperatorName());
			pstatement.setString(2, OperatorModel.getOperatorEmail());
			pstatement.setLong(3, OperatorModel.getOperatorContact());
			pstatement.setInt(4, OperatorModel.getOperatorAge());
			
			int result=pstatement.executeUpdate();
			if(result==1) {
			System.out.println("for "+OperatorModel.getOperatorId()+ "profile is updated !!");
			pstatement.close();
			con.close();
			}
			else {
				System.out.println("BusOperator updation failed");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
   
   
   
   public void deleteOperator (OperatorModel OperatorModel) {
		
		String del="delete from bus_operators where operator_id=?";
		
		Connection con;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement ps=con.prepareStatement(del);
			
			ps.setInt(1, OperatorModel.getOperatorId());
			int result=ps.executeUpdate();
			if(result==1) {
			System.out.println("Operator Details Successfully deleted");
			ps.close();
			con.close();		
			}
			else
			{
				System.out.println("please enter correct id");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
   
   
   public List<OperatorModel> viewOperator(){
   	
   	String operatorView="select * from bus_operators";
   	
   	Connection con;
   	List<OperatorModel> operatorList=new ArrayList<OperatorModel>();
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement ps=con.prepareStatement(operatorView);
			
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(operatorView);
			
			while(rs.next()) {
				OperatorModel operator=new OperatorModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getInt(5));
				operatorList.add(operator);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return operatorList;
		
   }
}