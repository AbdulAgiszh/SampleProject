package com.blackbus.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.blackbus.Dao.AdminDao;
import com.blackbus.Dao.BusDao;
import com.blackbus.Dao.OperatorDao;
import com.blackbus.Dao.UserDao;
import com.blackbus.module.AdminModel;
import com.blackbus.module.BusModel;
import com.blackbus.module.OperatorModel;
import com.blackbus.module.UserModel;

public class UserMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserDao ud = new UserDao();
		AdminDao ad = new AdminDao();
		OperatorDao operatorDao=new OperatorDao();
		BusDao busDao=new BusDao();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
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
						
						AdminModel adminmodel = ad.adminLogin(contact);
						do { // admin password validation
							if (adminmodel.getAdminPassword().equals(pass)) {
								System.out.println("welcome " + adminmodel.getAdminName());

								// switch case for the admin to perform
								do {
									System.out.println(
											"--------------------click the Number to perform the action-------------------");
									
									System.out.print("1. To add a bus:  \t");
									System.out.print("2. To add a operator:  \t");
									System.out.print("3. To update a admin \n");
									System.out.print("4. To update a bus \t");
									System.out.print("5. To update a operator \t");
									System.out.print("6. To show buslist \n");
									System.out.print("7. To show operatorList \t");
									System.out.print("8. To show userlist \t");
									System.out.print("9. To delete a bus \n");
									System.out.print("10. To delete a operator \t");
									System.out.print("11. To delete a user \t");
									System.out.print("12. To delete a admin \t");
									System.out.println("13. Exit");

									int adminchoice = scan.nextInt();
									scan.nextLine();
									switch (adminchoice) {
									case 1:
										//System.out.println("----------------To add bus----------------------");
										System.out.println("Enter operator Id");
										int operatorId=Integer.parseInt(scan.nextLine());
										System.out.println("Enter the Bus category");
										String busCategory=scan.nextLine();
										System.out.println("Enter the from city");
										String fromCity=scan.nextLine();
										System.out.println("Enter the to city");
										String toCity=scan.nextLine();
										System.out.println("Enter the Departure date and time");
										String depDate=scan.nextLine();
										LocalDateTime depTimeDate =LocalDateTime.parse(depDate, format);
										System.out.println("Enter the Arrival date and time");
										String arrDate=scan.nextLine();
										LocalDateTime arrTimeDate =LocalDateTime.parse(arrDate, format);
										System.out.println("Enter the sleeper Fare for bus");
										int sleeperFare=Integer.parseInt(scan.nextLine());
										System.out.println("Enter the seater Fare for bus");
										int seaterFare=Integer.parseInt(scan.nextLine());
										System.out.println("Enter the total seat for bus");
										int totalSeat=Integer.parseInt(scan.nextLine());
										BusModel busmodel=new BusModel(operatorId,busCategory,fromCity,toCity,depTimeDate,arrTimeDate,sleeperFare,seaterFare,totalSeat);
										busDao.insertBus(busmodel);
										break;
									case 2:
										//System.out.println("----------------To add operator----------------------");
										System.out.println("Enter the operator name");
										String operatorId11=scan.nextLine();
										System.out.println("Enter the operator Email");
										String operatorEmail=scan.nextLine();
										System.out.println("Enter the operator contact");
										long operatorContact=Long.parseLong(scan.nextLine());
										System.out.println("Enter the operator age");
										int operatorAge=Integer.parseInt(scan.nextLine());
										OperatorModel operatorModel1=new OperatorModel(operatorId11,operatorEmail,operatorContact,operatorAge);
										operatorDao.insertOperator(operatorModel1);
										
										break;
									case 3:
										//System.out.println("----------------To update admin----------------------");
										System.out.println("AdminID: "+adminmodel.getAdminEmail());
										System.out.println("update the admin name");
										String adminName=scan.nextLine();
										System.out.println("update the admin contact");
										long adminContact=Long.parseLong(scan.nextLine());
										System.out.println("update the admin password");
										String adminPassword=scan.nextLine();
										AdminModel adminModel=new AdminModel(adminName,adminContact,adminPassword,adminmodel.getAdminEmail());
										ad.updateAdmin(adminModel);
										break;
									case 4:
										//System.out.println("----------------To update bus----------------------");
										System.out.println("Enter the bus id to update the particular bus");
										int updateBusId=Integer.parseInt(scan.nextLine());
										System.out.println("Enter operator Id");
										int updateOperatorId=Integer.parseInt(scan.nextLine());
										System.out.println("Enter the Bus category");
										String updateBusCategory=scan.nextLine();
										System.out.println("Enter the from city");
										String updateFromCity=scan.nextLine();
										System.out.println("Enter the to city");
										String updateToCity=scan.nextLine();
										System.out.println("Enter the Departure date and time");
										String updateDepDate=scan.nextLine();
										LocalDateTime departureTimeDate =LocalDateTime.parse(updateDepDate, format);
										System.out.println("Enter the Arrival date and time");
										String updateArrDate=scan.nextLine();
										LocalDateTime arrivalTimeDate =LocalDateTime.parse(updateArrDate, format);
										System.out.println("Enter the sleeper Fare for bus");
										int updateSleeperFare=Integer.parseInt(scan.nextLine());
										System.out.println("Enter the seater Fare for bus");
										int updateSeaterFare=Integer.parseInt(scan.nextLine());
										System.out.println("Enter the total seat for bus");
										int updateTotalSeat=Integer.parseInt(scan.nextLine());
										System.out.println("Enter the bus status");
										String updateStatus=scan.nextLine();
										BusModel busModel=new BusModel(updateBusId,updateOperatorId,updateBusCategory,updateFromCity,updateToCity,departureTimeDate,arrivalTimeDate,updateSleeperFare,updateSeaterFare,updateTotalSeat,updateStatus);
										busDao.updateBus(busModel);
										break;
									case 5:
										//System.out.println("----------------To update operator----------------------");
										System.out.println("Enter the operator Id");
										int operatorId1=Integer.parseInt(scan.nextLine());
										System.out.println("Enter the operator name");
										String operatorName1=scan.nextLine();
										System.out.println("Enter the operator Email");
										String operatorEmail1=scan.nextLine();
										System.out.println("Enter the operator contact");
										long operatorContact1=Long.parseLong(scan.nextLine());
										System.out.println("Enter the operator age");
										int operatorAge1=Integer.parseInt(scan.nextLine());
										OperatorModel operatorModel2=new OperatorModel(operatorId1,operatorName1,operatorEmail1,operatorContact1,operatorAge1);
										operatorDao.updateOperator(operatorModel2);
										break;
									case 6:
										//System.out.println("----------------To show buslist----------------------");
										
										break;
									case 7:
										//System.out.println("----------------To show operatorlist----------------------");
										List<OperatorModel> listoperator=operatorDao.viewOperator();
										for (int i=0;i<listoperator.size();i++) {
											System.out.println(listoperator.get(i));
										}
										break;
									case 8:
										//System.out.println("----------------To show userlist----------------------");
										List<UserModel> listUser=ud.viewUser();
										for(int i=0;i<listUser.size();i++) {
											System.out.println(listUser.get(i));
										}
										break;
									case 9:
										//System.out.println("----------------To Delete bus----------------------");
										
										break;
									case 10:
										//System.out.println("----------------To Delete operator----------------------");
										System.out.println("Enter the operator id");
										int operatorId2=scan.nextInt();
//										OperatorModel operatorModel=operatorDao.getOperatorById(operatorId2);
										boolean deleteop=operatorDao.deleteOperator(operatorId2);
										if(deleteop==true) {
											System.out.println("Operator Details Successfully deleted");
										}
										else {
											System.out.println("please enter correct ID");
										}
										break;
									case 11:
										//System.out.println("----------------To Delete user----------------------");
										System.out.println("Enter the user id to delete ");
										int userId = scan.nextInt();							
										ud.deleteUser(userId);
										break;
									case 12:
										//System.out.println("----------------To Delete admin----------------------");

										break;
									case 13:
										//System.out.println("----------------To exit----------------------");

										System.exit(0);
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
						} while (adminmodel.getAdminPassword() != (pass) && num != 3);
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
						
						
						
						UserModel UserModule = ud.loginUser(Long.parseLong(contact));
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

										UserModel usermodule1 = new UserModel(userName1, userAge1, userEmail1,
												userContact1, userGender1, userPassword1);
										ud.updateUser(usermodule1);
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

					UserModel usermodule1 = new UserModel(userName, userAge, userEmail, userContact, userGender,
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
