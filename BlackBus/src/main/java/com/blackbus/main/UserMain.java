package com.blackbus.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.blackbus.Dao.AdminDao;
import com.blackbus.Dao.UserDao;
import com.blackbus.module.AdminModule;
import com.blackbus.module.UserModule;

public class UserMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserDao ud = new UserDao();
		AdminDao ad = new AdminDao();
		Scanner scan = new Scanner(System.in);

		boolean flag = true;
		int value;
		do {

			System.out.println("--------------------click the Number to perform the action-------------------");
			System.out.print("1. Login here \t");
			System.out.print("2. To register as a user:  \t");
			System.out.println("3. Exit");

			String choi = scan.nextLine();
			
			if (choi.matches("[0-9]")) {
				int choice=Integer.parseInt(choi);

				int num = 0;
				String contact;
				switch (choice) {

				case 1:

					System.out.println("Enter your LoginID");
					
					do {
						contact = scan.nextLine();
						if (contact.trim() == "") {
							System.out.println("please enter mobile number or password (it can't be empty)");
						}
						
					} while (contact.trim() == "");

					System.out.println("Enter your password");
					String pass = scan.nextLine();
					
					         // if admin is logining in
					
					if (contact.endsWith("admin@gmail.com")) {
						
					
						//to check admin is entering valid id or not according to db values
						boolean adminloginflag;
						adminloginflag=ad.checkadmin(contact);
						if(adminloginflag) {
						
						AdminModule adminmodule = ad.adminLogin(contact);
						do { // admin password validation
							if (adminmodule.getAdminPassword().equals(pass)) {
								System.out.println("welcome " + adminmodule.getAdminName());

								// switch case for the admin to perform
								do {
									System.out.println(
											"--------------------click the Number to perform the action-------------------");
									System.out.print("1. To delete a user \t");
									System.out.print("2. To add a bus:  \t");
									System.out.println("3. Exit");

									int adminchoice = scan.nextInt();
									switch (adminchoice) {
									case 1:
										System.out.println("----------------To Delete query----------------------");
										System.out.println("Enter the user id to delete ");
										int userId = scan.nextInt();
										UserModule usermodule2 = new UserModule(userId);
										ad.deleteUser(usermodule2);
										break;
									case 3:
										System.exit(adminchoice);
									default:
										System.out.println("please enter correct choice number: ");
										break;
									}
								} while (flag);

							}

							// if admin is entering wrong password
							else {
								num++;
								System.out.println("please enter correct password");
							}
							pass = scan.nextLine();
						} while (adminmodule.getAdminPassword() != (pass) && num != 3);
						System.out.println("Oops!! You have exceeded more than 3 times please do login after 5 min");
						System.exit(num);
						}
						else {
							System.out.println("Invalid adminId");
						}
					}    //admin closing 

					else if(contact.endsWith("admin@gmail.com")==false && contact.matches("[0-9]+")==false) {
					System.out.println("invalid login id");	
					}
					// if it is not a admin --> USER
					else  {
				    //contact
						boolean userloginflag;
						long num21=Long.parseLong(contact);
						userloginflag=ud.checkUser(num21);
						if(userloginflag) {
						
						
						
						UserModule UserModule = ud.loginUser(Long.parseLong(contact));
						// user password verification
						do {
							if (UserModule.getUserPassword().equals(pass)) {
								System.out.println("welcome " + UserModule.getUserName());

								// switch case for user to perform
								do {
									System.out.println(
											"--------------------click the Number to perform the action-------------------");
									System.out.print("1. To update profile \t");
									System.out.print("2. To add a booking:  \t");
									System.out.println("3. Exit");
									int userchoice = scan.nextInt();
									scan.nextLine();
									switch (userchoice) {

									case 1:
										System.out.println("------------------To Update Profile-------------------");
										System.out.println("LoginID: "+UserModule.getUserContact());
										System.out.println("Enter the user_name ");
										String userName1 = scan.nextLine();
										System.out.println("Enter the user_age ");
										int userAge1 = Integer.parseInt(scan.nextLine());
										System.out.println("Enter the user_email ");
										String userEmail1 = scan.nextLine();

										long userContact1 = UserModule.getUserContact();
										
										System.out.println("Enter the user_gender");
										String userGender1 = scan.nextLine();
										System.out.println("Enter the user_password");
										String userPassword1 = scan.nextLine();

										UserModule usermodule1 = new UserModule(userName1, userAge1, userEmail1,
												userContact1, userGender1, userPassword1);
										ud.updateProfile(usermodule1);
										break;

									case 3:
										System.exit(userchoice);
									default:
										System.out.println("please enter correct choice number: ");
										break;
									}
								} while (flag);

							} // user if for password
							else {
								num++;
								System.out.println("please enter correct password");
							}
							pass = scan.nextLine();
						} while (UserModule.getUserPassword() != (pass) && num != 3);
						System.out.println("Oops!! You have exceeded more than 3 times please do login after 5 min");
						System.exit(num);
						}
						else {
							System.out.println("Invalid LoginID");
						}
					} // user else
					break;
					// from index page 2nd button insert query
				case 2:
					System.out.println("-------------------To Insert query-------------");

					boolean flagname = true;                                                        // name
					String userName = null;
					do {
						System.out.println("Enter the user_name: ");
						userName = scan.nextLine();
						if (userName.trim().matches("[A-Za-z]{4,20}")) {
							flagname = false;
						} else {
							System.out.println("name must having 4 character and doesn't allow null values");
						}
					} while (flagname);

					System.out.println("Enter the user_age ");                                       // age
					int userAge = Integer.parseInt(scan.nextLine());

					boolean flagemail = true;                                                       // email
					String userEmail = null;
					do {
						System.out.println("Enter the user_email ");
						userEmail = scan.nextLine();

						if (userEmail.matches("[a-zA_z][A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}")) {
							flagemail = false;
							userEmail = userEmail.trim().toLowerCase();
						} else {
							System.out.println("please enter correct email format for eg: abc123@gmail.com");
						}
					} while (flagemail);

					boolean flagcontact = true;                                                       // contact
					String userContactnum;
					long userContact = 0;
					do {
						System.out.println("Enter the user_contact ");
						userContactnum = scan.nextLine();

						if (userContactnum.matches("[6-9][0-9]{9}")) {
							flagcontact = false;
							userContact = Long.parseLong(userContactnum);
						} else {
							System.out.println(
									"contact must be start with 6-9 and it should contain 10 numbers and it does not allow space and char");
						}
					} while (flagcontact);

					System.out.println("Enter the user_gender (male or female)");                     // gender
					String userGender = scan.nextLine();

					boolean userpass = true;                                                          // password
					String userPassword = null;
					do {
						System.out.println("Enter the user_password");
						System.out.println(
								"Password must have 7-15 char \t" + "should contain atlease one upper and lower case \t"
										+ "atleast one number and special char");
						userPassword = scan.nextLine();

						if (userPassword
								.matches("(?=.*\\d)(?=.*[@#$%!^()_+])(?=.*[a-z])(?=.*[A-Z]).{7,15}")) {
							userpass = false;
						} else {
							System.out.println("please enter valid type password");
						}
					} while (userpass);

					UserModule usermodule1 = new UserModule(userName, userAge, userEmail, userContact, userGender,
							userPassword);
					ud.registrationUser(usermodule1);
					break;
				}

			}

			else {
				System.out.println("enter correct one");
			}
			
			
			
			System.out.println("Do you want to redirect to home page: press 5");
			 value = Integer.parseInt(scan.nextLine());

		} while (value == 5);

	}
}

//				
//			
//				
//			case 5:
//				System.out.println("To list users table ");
//				
//				
//			case 6:
//				System.exit(0);
//		}
//		
//		}

//case 1: 
//System.out.println("Enter your mobile number or email");
//String contact=scan.next();
//if(contact.endsWith("admin@gmail.com")) {
//	
//	AdminModule adminmodule= ad.admin(contact);
//	System.out.println("welcome "+ adminmodule.getAdminName());
//	
//}
//else {
//	
//	UserModule usermodule=ud.login(Long.parseLong(contact));
//	System.out.println("welcome "+ usermodule.getUserName());
//}
//
//
//
//break;
