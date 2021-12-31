package com.blackbus.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.blackbus.connection.ConnectionUtill;
import com.blackbus.dao.UserDAO;
import com.blackbus.model.Admin;
import com.blackbus.model.Operator;
import com.blackbus.model.User;

public class UserDaoImpl implements UserDAO {

	public User loginUser(long contact) {

		String userLogin = "select * from user_details where user_contact='" + contact + "'";
		Connection con;
		User userModel = null;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(userLogin);

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(userLogin);

			rs.next();
			userModel = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getLong(5),
					rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return userModel;
	}

	public boolean checkUser(long contact) {

		String userLogin = "select * from user_details where user_contact='" + contact + "' and user_status='Active'";
		Connection con;
		boolean checkUserFlag = true;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(userLogin);

			int i = pstatement.executeUpdate(userLogin);
			if (i > 0) {
				checkUserFlag = true;
			} else {
				checkUserFlag = false;
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			;
		}

		return checkUserFlag;
	}

	public void registrationUser(User userModel) {

		String insertUser = "insert into user_details (user_name,user_age,user_email,user_contact,user_gender,user_password) values (?,?,?,?,?,?)";
		Connection con;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(insertUser);

			pstatement.setString(1, userModel.getUserName());
			pstatement.setInt(2, userModel.getUserAge());
			pstatement.setString(3, userModel.getUserEmail());
			pstatement.setLong(4, userModel.getUserContact());
			pstatement.setString(5, userModel.getUserGender());
			pstatement.setString(6, userModel.getUserPassword());

			int result = pstatement.executeUpdate();
			if (result > 0) {
				System.out.println("Your Have Registered Successfully!!");
				pstatement.close();
				con.close();
			} else {
				System.out.println("your record has not registered");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void updateUser(User userModel) {

		String userUpdate = "update user_details set user_name=?, user_age=?, user_gender=?, user_password=? where user_contact='"
				+ userModel.getUserContact() + "'";

		Connection con;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(userUpdate);

			pstatement.setString(1, userModel.getUserName());
			pstatement.setInt(2, userModel.getUserAge());
			pstatement.setString(3, userModel.getUserGender());
			pstatement.setString(4, userModel.getUserPassword());

			pstatement.executeUpdate();
			System.out.println("for " + userModel.getUserContact() + "profile is updated !!");
			pstatement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void deleteUser(User userModel) {

		String userDelete = "update user_details set user_status='Inactive' where user_contact=?";

		Connection con;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(userDelete);

			pstatement.setLong(1, userModel.getUserContact());
			int result = pstatement.executeUpdate();
			if (result == 1) {
				System.out.println("Successfully deleted");
				pstatement.close();
				con.close();
			} else {
				System.out.println("Delete unsuccessfull...something went wrong!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void reAddUser(long contact) {

		String userReAdd = "update user_details set user_status='Active' where user_contact='"+contact+"'";
		Connection con;
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(userReAdd);
			int result = pstatement.executeUpdate();
//			if (result == 1) {
//				System.out.println("Successfully deleted");
//				pstatement.close();
//				con.close();
//			} else {
//				System.out.println("Delete unsuccessfull...something went wrong!");
//			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	

	// for admin purpose to show all users
	public ResultSet viewUserDetails() {

		String userView = "select * from user_details";

		Connection con;
		ResultSet rs = null;
//		List<User> userList = new ArrayList<User>();
		try {
			con = ConnectionUtill.connectdb();
			PreparedStatement pstatement = con.prepareStatement(userView);

			rs = pstatement.executeQuery();

//			while (rs.next()) {
//				User userModel = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
//						rs.getLong(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
//			}
			return rs;
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;

		

	}

	public boolean updateWallet(int updatedWallet, long userContact) {
		String wallet = "update user_details set user_wallet=? where user_contact=?";

		Connection con;
		PreparedStatement pstatement;
		int result = 0;
		try {
			con = ConnectionUtill.connectdb();
			pstatement = con.prepareStatement(wallet);

			pstatement.setInt(1, updatedWallet);
			pstatement.setLong(2, userContact);
			result = pstatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result > 0;

	}

	public boolean checkAlreadyUserWhileRegister(long userContact) {

		String checkUser = "select * from user_details where user_contact=?";
		Connection con = null;
		PreparedStatement pstatement = null;
		User userModel;
		boolean checkUserFlag = true;
		try {
			con = ConnectionUtill.connectdb();
			pstatement = con.prepareStatement(checkUser);
			pstatement.setLong(1, userContact);
			ResultSet rs = pstatement.executeQuery();

			if (rs.next()) {
				userModel = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
				checkUserFlag = true;
			} else {
				checkUserFlag = false;
			}
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return checkUserFlag;

	}

	public User getUserDetailsById(int userId) { ////

		String getUser = "select * from user_details where user_id=?";
		Connection con = null;
		PreparedStatement pstatement = null;
		User userModel = null;

		try {
			con = ConnectionUtill.connectdb();
			pstatement = con.prepareStatement(getUser);
			pstatement.setInt(1, userId);
			ResultSet rs = pstatement.executeQuery();

			if (rs.next()) {
				userModel = new User(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9));
			}
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return userModel;

	}

}
