package com.blackbus.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.blackbus.Dao.AdminDao;
import com.blackbus.Dao.UserDao;
import com.blackbus.module.AdminModule;
import com.blackbus.module.UserModule;

public class UserMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserDao ud=new UserDao();
		AdminDao ad=new AdminDao();
		Scanner scan=new Scanner(System.in);
		
		boolean flag;
		while(flag=true) {
		
		System.out.println("select Number from this:  ");
		System.out.print("1. Login here \t");
		System.out.print("2.  To register as a user:  \t");
		System.out.print("3.To update the value \t");
		System.out.print("4.To delete the value \t");
		System.out.print("5.To fetch the data \t");
		System.out.println("Enter the value \t");
		int choice=scan.nextInt();
		scan.nextLine();
		
		switch(choice)  {
		
			case 1: 
				System.out.println("Enter your mobile number or email");
				String contact=scan.next();
				if(contact.endsWith("admin@gmail.com")) {
					
					AdminModule adminmodule= ad.admin(contact);
					System.out.println("welcome "+ adminmodule.getAdminName());
					
				}
				else {
					
					UserModule usermodule=ud.login(Long.parseLong(contact));
					System.out.println("welcome "+ usermodule.getUserName());
				}
				
				
				
				break;
		
			case 2:
				System.out.println("-------------------To Insert query-------------");
				System.out.println("Enter the user_name: ");
				String userName=scan.nextLine();
				System.out.println("Enter the user_age ");
				int userAge=Integer.parseInt(scan.nextLine());
				System.out.println("Enter the user_email ");
				String userEmail=scan.nextLine();
				System.out.println("Enter the user_contact ");
				long userContact=Long.parseLong(scan.nextLine());
				System.out.println("Enter the user_gender");
				String userGender=scan.nextLine();
				System.out.println("Enter the user_password");
				String userPassword=scan.nextLine();
				
				UserModule usermodule=new UserModule(userName,userAge,userEmail,userContact,userGender,userPassword);
				ud.insert(usermodule);
				break;
				
			case 3:
				System.out.println("------------------To Update query-------------------");
				System.out.println("Enter the user_name ");
				String userName1=scan.nextLine();
				System.out.println("Enter the user_age ");
				int userAge1=Integer.parseInt(scan.nextLine());
				System.out.println("Enter the user_email ");
				String userEmail1=scan.nextLine();
				System.out.println("Enter the user_contact ");
				long userContact1=Long.parseLong(scan.nextLine());
				System.out.println("Enter the user_gender");
				String userGender1=scan.nextLine();
				System.out.println("Enter the user_password");
				String userPassword1=scan.nextLine();
				
				UserModule usermodule1=new UserModule(userName1,userAge1,userEmail1,userContact1,userGender1,userPassword1);
				ud.update(usermodule1);
				break;
				
			case 4:
				System.out.println("----------------To Delete query----------------------");
				System.out.println("Enter the id to delete ");
				int userId=scan.nextInt();
				UserModule usermodule2=new UserModule(userId);
				ad.delete(usermodule2);
				break;
				
			case 5:
				System.out.println("To list users table ");
				
				
			case 6:
				System.exit(0);
		}
		
		}

	}
}


