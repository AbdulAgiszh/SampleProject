package com.blackbus.main;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

import com.blackbus.Dao.AdminDao;
import com.blackbus.Dao.BookedTicketsDao;
import com.blackbus.Dao.BusDao;
import com.blackbus.Dao.OperatorDao;
import com.blackbus.Dao.UserDao;
import com.blackbus.module.AdminModel;
import com.blackbus.module.BookedTicketsModel;
import com.blackbus.module.BusModel;
import com.blackbus.module.OperatorModel;
import com.blackbus.module.UserModel;

public class UserMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserDao userDao = new UserDao();
		AdminDao adminDao = new AdminDao();
		OperatorDao operatorDao = new OperatorDao();
		BusDao busDao = new BusDao();
		BookedTicketsDao bookTicketsDao = new BookedTicketsDao();

		BookedTicketsModel bookTicketModel = new BookedTicketsModel();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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
				int choice = Integer.parseInt(choi);

				int num = 0;
				String contact;
				switch (choice) {

				case 1:

					System.out.println("Enter your LoginID");

					do {
						//checking the space while login
						contact = scan.nextLine();
						if (contact.trim() == "") {
							System.out.println("please enter mobile number or password (it can't be empty)");
						}

					} while (contact.trim() == "");

					System.out.println("Enter your password");
					String pass = scan.nextLine();

					// if admin is logining in
					if (contact.endsWith("admin@gmail.com")) {

						// to check admin is entering valid id or not according to db values
						boolean adminloginflag;
						adminloginflag = adminDao.checkadmin(contact);
						if (adminloginflag) {

							AdminModel adminmodel = adminDao.adminLogin(contact);
							do {
								// admin password validation
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
										System.out.print("6. To show booking list  \n");
										System.out.print("7. To show buslist \t");
										System.out.print("8. To show operatorList \t");
										System.out.print("9. To show userlist \n");
										System.out.print("10. To delete a bus \t");
										System.out.print("11. To delete a operator \t");
										System.out.println("12. Exit");

										int adminchoice = scan.nextInt();
										scan.nextLine();
										switch (adminchoice) {
										case 1:
											// System.out.println("----------------To add bus----------------------");
											System.out.println("Enter operator Id");
											int operatorId = Integer.parseInt(scan.nextLine());
											System.out.println("Enter the Bus category");
											String busCategory = scan.nextLine();
											System.out.println("Enter the from city");
											String fromCity = scan.nextLine();
											System.out.println("Enter the to city");
											String toCity = scan.nextLine();
											System.out.println("Enter the Departure date and time");
											String depDate = scan.nextLine();
											LocalDateTime depTimeDate = LocalDateTime.parse(depDate, format);
											System.out.println("Enter the Arrival date and time");
											String arrDate = scan.nextLine();
											LocalDateTime arrTimeDate = LocalDateTime.parse(arrDate, format);
											System.out.println("Enter the sleeper Fare for bus");
											int sleeperFare = Integer.parseInt(scan.nextLine());
											System.out.println("Enter the seater Fare for bus");
											int seaterFare = Integer.parseInt(scan.nextLine());
											System.out.println("Enter the total seat for bus");
											int totalSeat = Integer.parseInt(scan.nextLine());
											BusModel busmodel = new BusModel(operatorId, busCategory, fromCity, toCity,
													depTimeDate, arrTimeDate, sleeperFare, seaterFare, totalSeat);
											busDao.insertBus(busmodel);
											break;
										case 2:
											// System.out.println("----------------To add operator----------------------");
											System.out.println("Enter the operator name");
											String operatorId11 = scan.nextLine();
											System.out.println("Enter the operator Email");
											String operatorEmail = scan.nextLine();
											System.out.println("Enter the operator contact");
											long operatorContact = Long.parseLong(scan.nextLine());
											System.out.println("Enter the operator age");
											int operatorAge = Integer.parseInt(scan.nextLine());
											OperatorModel operatorModel1 = new OperatorModel(operatorId11,
													operatorEmail, operatorContact, operatorAge);
											operatorDao.insertOperator(operatorModel1);

											break;
										case 3:
											// System.out.println("----------------To update
											// admin----------------------");
											System.out.println("AdminID: " + adminmodel.getAdminEmail());
											System.out.println("update the admin name");
											String adminName = scan.nextLine();
											System.out.println("update the admin contact");
											long adminContact = Long.parseLong(scan.nextLine());
											System.out.println("update the admin password");
											String adminPassword = scan.nextLine();
											AdminModel adminModel = new AdminModel(adminName, adminContact,
													adminPassword, adminmodel.getAdminEmail());
											adminDao.updateAdmin(adminModel);
											break;
										case 4:
											// System.out.println("----------------To update bus----------------------");
											System.out.println("Enter the bus id to update the particular bus");
											int updateBusId = Integer.parseInt(scan.nextLine());
											System.out.println("Enter operator Id");
											int updateOperatorId = Integer.parseInt(scan.nextLine());
											System.out.println("Enter the Bus category");
											String updateBusCategory = scan.nextLine();
											System.out.println("Enter the from city");
											String updateFromCity = scan.nextLine();
											System.out.println("Enter the to city");
											String updateToCity = scan.nextLine();
											System.out.println("Enter the Departure date and time");
											String updateDepDate = scan.nextLine();
											LocalDateTime departureTimeDate = LocalDateTime.parse(updateDepDate,
													format);
											System.out.println("Enter the Arrival date and time");
											String updateArrDate = scan.nextLine();
											LocalDateTime arrivalTimeDate = LocalDateTime.parse(updateArrDate, format);
											System.out.println("Enter the sleeper Fare for bus");
											int updateSleeperFare = Integer.parseInt(scan.nextLine());
											System.out.println("Enter the seater Fare for bus");
											int updateSeaterFare = Integer.parseInt(scan.nextLine());
											System.out.println("Enter the total seat for bus");
											int updateTotalSeat = Integer.parseInt(scan.nextLine());
											System.out.println("Enter the bus status");
											String updateStatus = scan.nextLine();
											BusModel busModel = new BusModel(updateBusId, updateOperatorId,
													updateBusCategory, updateFromCity, updateToCity, departureTimeDate,
													arrivalTimeDate, updateSleeperFare, updateSeaterFare,
													updateTotalSeat, updateStatus);
											busDao.updateBus(busModel);
											break;
										case 5:
											// System.out.println("----------------To update operator----------------------");
											System.out.println("Enter the operator Id");
											int operatorId1 = Integer.parseInt(scan.nextLine());
											System.out.println("Enter the operator name");
											String operatorName1 = scan.nextLine();
											System.out.println("Enter the operator Email");
											String operatorEmail1 = scan.nextLine();
											System.out.println("Enter the operator contact");
											long operatorContact1 = Long.parseLong(scan.nextLine());
											System.out.println("Enter the operator age");
											int operatorAge1 = Integer.parseInt(scan.nextLine());
											OperatorModel operatorModel2 = new OperatorModel(operatorId1, operatorName1,
													operatorEmail1, operatorContact1, operatorAge1);
											operatorDao.updateOperator(operatorModel2);
											break;
										case 6:
											// System.out.println("--------------Booking list----------------");
											List<BookedTicketsModel> bookingList = bookTicketsDao.showlistAdmin();
											for (int i = 0; i < bookingList.size(); i++) {
												System.out.println(bookingList.get(i).toStringAdmin());
											}
											break;
										case 7:
											// System.out.println("----------------To show buslist----------------------");
											List<BusModel> listbus = busDao.viewAllBus();
											for (int i = 0; i < listbus.size(); i++) {
												System.out.println(listbus.get(i));
											}
											break;
										case 8:
											// System.out.println("----------------To show operatorlist----------------------");
											List<OperatorModel> listoperator = operatorDao.viewOperator();
											for (int i = 0; i < listoperator.size(); i++) {
												System.out.println(listoperator.get(i));
											}
											break;
										case 9:
											// System.out.println("----------------To show userlist----------------------");
											List<UserModel> listUser = userDao.viewUserDetails();
											for (int i = 0; i < listUser.size(); i++) {
												System.out.println(listUser.get(i));
											}
											break;
										case 10:
											// System.out.println("----------------To Delete bus----------------------");

											break;
										case 11:
											// System.out.println("----------------To Delete operator----------------------");
											System.out.println("Enter the operator id");
											int operatorId2 = scan.nextInt();
										    //OperatorModel operatorModel=operatorDao.getOperatorById(operatorId2);
											boolean deleteop = operatorDao.deleteOperator(operatorId2);
											if (deleteop == true) {
												System.out.println("Operator Details Successfully deleted");
											} else {
												System.out.println("please enter correct ID");
											}
											
											break;
										case 12:
											// System.out.println("----------------To exit----------------------");
											System.out.println("Thank you for visit us");
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
							System.out
									.println("Oops!! You have exceeded more than 3 times please do login after 5 min");
							System.exit(num);
						} else {
							System.out.println("Invalid adminId");
						}
					} // admin closing

					else if (contact.endsWith("admin@gmail.com") == false && contact.matches("[0-9]+") == false) {
						System.out.println("invalid login id");
					}
					// if USER is login with contact number
					else {
						boolean userloginflag;
						long num21 = Long.parseLong(contact);
						userloginflag = userDao.checkUser(num21);
						if (userloginflag) {
							//to get a object using contact
							UserModel userModel = userDao.loginUser(Long.parseLong(contact));
							
							// user password verification
							do {
								if (userModel.getUserPassword().equals(pass)) {
									System.out.println("welcome " + userModel.getUserName());

									// switch case for user to perform
									do {
										System.out.println(
												"--------------------click the Number to perform the action-------------------");
										System.out.println("1. To update profile ");
										System.out.println("2. To search a bus:  ");
										System.out.println("3. TO find Invoice :  ");
										System.out.println("4. To Cancel My Ticket : ");
										System.out.println("5. To update wallet (credit) : ");
										System.out.println("6. View Balance in Wallet");
										System.out.println("7. Users booked List : ");
										System.out.println("8. To Delete my profile");
										System.out.println("9. Exit");
										int userchoice = scan.nextInt();
										scan.nextLine();
										switch (userchoice) {

										case 1:
											System.out.println("------------------To Update Profile-------------------");
											System.out.println("LoginID: " + userModel.getUserContact());
											System.out.println("Enter the user_name ");
											String userName1 = scan.nextLine();
											System.out.println("Enter the user_age ");
											int userAge1 = Integer.parseInt(scan.nextLine());
											System.out.println("Enter the user_email ");
											String userEmail1 = scan.nextLine();

											long userContact1 = userModel.getUserContact();

											System.out.println("Enter the user_gender");
											String userGender1 = scan.nextLine();
											System.out.println("Enter the user_password");
											String userPassword1 = scan.nextLine();

											UserModel usermodule1 = new UserModel(userName1, userAge1, userEmail1,
													userContact1, userGender1, userPassword1);
											userDao.updateUser(usermodule1);
											break;
										case 2:
											// System.out.println("------------------To search bus-------------------");
											System.out.println("Enter the date to departure a bus");
											String givenDate = scan.nextLine();
											LocalDate givenDepartureDate = LocalDate.parse(givenDate, formatDate);
											System.out.println("Enter from location");
											String fromLocation = scan.nextLine();
											System.out.println("Enter to location");
											String toLocation = scan.nextLine();
											
											//filter according to date 
											List<BusModel> listFilterBus = busDao.searchhBus(givenDepartureDate,fromLocation, toLocation);
											for (int i = 0; i < listFilterBus.size(); i++) {
												System.out.println(listFilterBus.get(i));
											}

											// booking ticket
											System.out.println("Enter the bus Id to have a ride to your loved place");
											int bookBusId = Integer.parseInt(scan.nextLine());
											
											//to find the bus is having seat availability or not
											BusModel busModel = busDao.findBusDetailsUsingID(bookBusId);
											if(busModel.getTotalseat()>0) {
											
											//to fetch only date 
											LocalDateTime date = busModel.getDeparture();
											LocalDate departureDate = date.toLocalDate();

											// to find operator
											//OperatorModel bookOperatorModel = operatorDao.getOperatorById(busModel.getoperatorId());
											System.out.println("Enter the No for class : sleeper or seater");
											System.out.println("----------------------------------------");
											System.out.println("click-->    1.sleeper \t 2.seater");
											int bookClassChoice = Integer.parseInt(scan.nextLine());
											String bookClass;
											int ticketPrice;
											if (bookClassChoice == 1) {
												bookClass = "Sleeper";
												ticketPrice = busModel.getSleeperFare();
											} else {
												bookClass = "Seater";
												ticketPrice = busModel.getSeaterFare();
											}

											System.out.println("Enter the ticket count you want:");
											int bookTicketCount = Integer.parseInt(scan.nextLine());
											System.out.println("Enter the seat No (1-10)for SEATER \t (11-13)for SLEEPER");
											
											int[] array = new int[bookTicketCount];
											for (int i = 0; i < array.length; i++) {
												array[i] = Integer.parseInt(scan.nextLine());
											}
											String bookSeatNo = "";
											for (int i = 0; i < array.length; i++) {
												bookSeatNo += array[i] + " ";
											}

											// to find total price
											int bookTotalPrice = bookTicketCount * ticketPrice;
											System.out.println("Your total price for travel is : " + bookTotalPrice);
											// to get current object
											userModel = userDao.getUserDetailsById(userModel.getUserId());
											System.out.println("Current balance in your wallet is : " + userModel.getUserWallet());

											System.out.println("-----------Type yes for booking confirmation---------");
											String confirmation = scan.nextLine().toLowerCase();

											try {
												if (confirmation.equals("yes")) {
													// to get current object
													userModel = userDao.getUserDetailsById(userModel.getUserId());
													// to check whether wallet is having that much amount to book
													if (userModel.getUserWallet() >= bookTotalPrice) {
														String paymentStatus="successfull";
														
														//to reduce seat according to seat count given by user
														busModel = busDao.findBusDetailsUsingID(bookBusId);
														int reducedBusSeat=busModel.getTotalseat()-bookTicketCount;
														busModel.setTotalseat(reducedBusSeat);											///////
														busDao.updateSeatCount(busModel);
														
														
														bookTicketModel = new BookedTicketsModel(userModel, busModel,departureDate, bookTicketCount,
																bookClass, bookSeatNo,bookTotalPrice,paymentStatus);
														
														//insert all info to booking table 
														boolean result = bookTicketsDao.insertBookedTickets(userModel,busModel, bookTicketModel);
														int currentBookingNumber;

														if (result == true) {
															// to reduce wallet amount according to ticket amount
															int updatedBalanceAfterBooking = userModel.getUserWallet()- bookTotalPrice;
															userDao.updateWallet(updatedBalanceAfterBooking,userModel.getUserContact());
															System.out.println("---------------Booked successfully-----------------");
														} else { //
															System.out.println("Money is Not updated...something went wrong");
														}
														currentBookingNumber = bookTicketsDao.findBookingId(userModel,bookTicketModel);
														System.out.println("Your booking Ticket number is : "+ currentBookingNumber);
														System.out.println("please remember your Ticket number for further purpose");
													}

													else {
														System.out.println("Insufficient balance....please recharge your wallet");

														System.out.println("Press 9 to recharge your wallet now");
														int rechargeWalletChoiceAfterInsufficient = scan.nextInt();
														if (rechargeWalletChoiceAfterInsufficient == 9) {
															// System.out.println("Your current Balance is : "+userModel.getUserWallet());
															System.out.println(
																	"Enter the amount to be add to your wallet");
															int addedAmountInBooking = scan.nextInt();
															int totalAmountInBooking = addedAmountInBooking+ userModel.getUserWallet();

															// to update added amount to the wallet
															userModel = userDao.getUserDetailsById(userModel.getUserId());
															
															// userModel.setUserWallet(totalAmountInBooking);
															boolean resultWallet = userDao.updateWallet(totalAmountInBooking, userModel.getUserContact());
															if (resultWallet == true) {
																System.out.println("update successfully");
																// System.out.println("Your current balance is : "+userModel.getUserWallet());
															} else {
																System.out.println("please give correct value (not booked)");
																
															}
														}
													}
												}
												// if yes was not typed this will return
												else {
													System.out.println(
															"Booking was not confirmed...Hurry up!! Only few seats are left");
												}
											} catch (Exception e) {
												System.out.println("The entered value is incorrect");
											}
											}
											else {
												System.out.println( bookBusId +" seats are not available...please go for other options");
											}
//										\u000d
											break;

										case 3:
											System.out.println("-------------------Invoice---------------------");
											BookedTicketsModel bookedTicketsModel = null;
											System.out.println("Enter the Ticket Number");
											int bookingTicketNumber = (scan.nextInt());
											bookedTicketsModel = bookTicketsDao.findBookedTicketsDetails(bookingTicketNumber);
											busModel = busDao.findBusDetailsUsingID(bookedTicketsModel.getBusModel().getBusId());
											
											System.out.println("TicketNumber    : " + bookingTicketNumber);
											System.out.println("Name            : " + userModel.getUserName());
											System.out.println("Date of Journey : " + busModel.getDeparture());
											System.out.println("Source          : " + busModel.getFromCity());
											System.out.println("Destination     : " + busModel.getToCity());
											System.out.println("Seat Category   : " + bookedTicketsModel.getSeatCategory());
											System.out.println("Seat NO         : " + bookedTicketsModel.getSeatNo());
											System.out.println("Total Price     : " + bookedTicketsModel.getTotalPrice());
											System.out.println("Payment status  : " + bookedTicketsModel.getPaymentStatus());
											
											break;

										case 4:
											System.out.println("--------------Cancel Ticket---------------");
											System.out.println("Enter your TicketNumber");
											int cancelTicketNumber;
											try {
												cancelTicketNumber = scan.nextInt();
												bookedTicketsModel = bookTicketsDao.findBookedTicketsDetails(cancelTicketNumber);
												//refund process
												int amountRefund = userModel.getUserWallet()+ bookedTicketsModel.getTotalPrice();
												System.out.println("The ticket amount " + bookedTicketsModel.getTotalPrice()+ " is refunded to your wallet successfully");
												userDao.updateWallet(amountRefund, userModel.getUserContact());
												
												// to update refund amount to the wallet
												userModel = userDao.getUserDetailsById(userModel.getUserId());
												
												//to update (+) bus seats according to user booking
												busModel = busDao.findBusDetailsUsingID(bookedTicketsModel.getBusModel().getBusId());
												int addedBusSeat= bookedTicketsModel.getBusModel().getTotalseat()+bookedTicketsModel.getTicketCount();
												busModel.setTotalseat(addedBusSeat);											
												busDao.updateSeatCount(busModel);
												
												
												// userModel.setUserWallet(amountRefund);
												boolean cancelResult = bookTicketsDao.cancelTicket(userModel,bookedTicketsModel);
												if (cancelResult == true) {
													System.out.println("Ticket successfully Cancelled");
													System.out.println("Your current Available balance is : "+ userModel.getUserWallet());
												} else {
													System.out.println("Ticket cancel process failed");
												}
											} catch (Exception e) {
												System.out.println("Please Enter correct Ticket Number");
											}
											break;
										case 5:
											System.out.println("-----------To update wallet---------------");
											System.out.println("Your current Available Balance in "
													+ userModel.getUserContact() + "is : " + userModel.getUserWallet());
											System.out.println("press 1 to add amount in your wallet");
											int walletChoice = scan.nextInt();
											if (walletChoice == 1) {
												System.out.println("Enter the amount to be credit in your wallet: ");
												int toAddBalance = scan.nextInt();
												int updatedWallet = userModel.getUserWallet() + toAddBalance;
												boolean resultWallet = userDao.updateWallet(updatedWallet,userModel.getUserContact());
												if (resultWallet == true) {
													System.out.println("update successfully");
													System.out.println("Your current balance is : " + updatedWallet);
												} else {
													System.out.println("Money is Not updated...something went wrong");
												}
											} else {
												System.out.println("enter correct choice");
											}
											break;
										case 6:
											// System.out.println("-------------To view Balance------------------");
											userModel = userDao.getUserDetailsById(userModel.getUserId());
											System.out.println("Available Balance : " + userModel.getUserWallet());
											break;
										case 7:
											System.out.println("--------users booked List--------------------");
											List<BookedTicketsModel> bookedList = bookTicketsDao.getBookingDetailsForCurrentUser(userModel);
											for (int i = 0; i < bookedList.size(); i++) {

												System.out.println(bookedList.get(i).toStringUser());
											}
											break;

										case 8:
											// System.out.println("----------------To Delete user----------------------");
											System.out.println(
													"Do you want to delete your account....to confirm type <yes> or type <no>");
											try {
												String confirmDelete = scan.nextLine().toLowerCase();
												if (confirmDelete.equals("yes")) {
													userDao.deleteUser(userModel);
													System.exit(0);
												} else if (confirmDelete.equals("no")) {
													System.out.println("Your account is not deleted");
												}
											} catch (Exception e) {
												System.out.println("please type correct one to delete");
											}
											break;
										case 9:
											System.exit(0);
											break;
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
							} while (userModel.getUserPassword() != (pass) && num != 3);
							System.out
									.println("Oops!! You have exceeded more than 3 times please do login after 5 min");
							System.exit(num);
						} else {
							System.out.println("Invalid LoginID");
						}
					} // user else
					break;
					
				
				case 2:
					System.out.println("------------------- Register Here!! -------------");

					boolean flagname = true; // name
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
					
					 // age details
					System.out.println("Enter the user_age ");
					int userAge = Integer.parseInt(scan.nextLine());

					// email details
					boolean flagemail = true; 
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

					 // contact details
					boolean flagContact = true;
					String userContactNumber;
					long userContact = 0;
					do {
						System.out.println("Enter the user_contact ");
						userContactNumber = scan.nextLine();
						if (userContactNumber.matches("[6-9][0-9]{9}")) {
							userContact = Long.parseLong(userContactNumber);
							
							int OTPRegister = (int) Math.floor((Math.random()*(100000)));
							System.out.println("OTP for register : "+OTPRegister);
							System.out.println("The OTP has send to your Registered Mobile Number....please enter it");
							int userGivenOTP=Integer.parseInt(scan.nextLine());
							if(userGivenOTP==OTPRegister) {
								flagContact = false;
							//to check user is already register or not
							boolean checkUser=userDao.checkAlreadyUserWhileRegister(userContact);
							if(checkUser==true) {
								userDao.reAddUser(userContact);
								System.out.println("Your Account is Activated now...please go to the login page");
								flagContact = false;
								System.exit(0);
							}
							}
							else {
								System.out.println("please enter correct OTP");
							}
						} else {
							System.out.println(
									"contact must be start with 6-9 and it should contain 10 numbers and it does not allow space and char");
						}
					} while (flagContact);

					 // gender
					System.out.println("Enter the user_gender (male or female)");
					String userGender = scan.nextLine();

					// password
					boolean userpass = true; 
					String userPassword = null;
					do {
						System.out.println("Enter the user_password");
						System.out.println(
								"Password must have 7-15 char \t" + "should contain atlease one upper and lower case \t"
										+ "atleast one number and special char");
						userPassword = scan.nextLine();

						if (userPassword.matches("(?=.*\\d)(?=.*[@#$%!^()_+])(?=.*[a-z])(?=.*[A-Z]).{7,15}")) {
							userpass = false;
						} else {
							System.out.println("please enter valid type password");
						}
					} while (userpass);

					UserModel userModel = new UserModel(userName, userAge, userEmail, userContact, userGender,userPassword);
					userDao.registrationUser(userModel);
					System.out.println("Your login Id is : " + userModel.getUserContact());
					System.out.println(" ");
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

//invoice sample
//show all travel booked details for user

//System.out.println("-------------------Invoice---------------------");	
//BookedTicketsModel bookedTicketsModel=null;
////BusModel busModel=null;
//int bookingTicketNumber=bookTicketsDao.findBookingId(userModel);
//bookedTicketsModel=bookTicketsDao.findBookedTicketsDetails(userModel);
//busModel=busDao.getBusById(bookedTicketsModel.getBusModel().getBusId());
//System.out.println("TicketNumber    : " +bookingTicketNumber );
//System.out.println("Name            : " +userModel.getUserName());
//System.out.println("Date of Journey : " +busModel.getDeparture());
//System.out.println("Source          : " +busModel.getFromCity());
//System.out.println("Destination     : " +busModel.getToCity());
//System.out.println("Seat NO         : " +bookedTicketsModel.getSeatNo());
//System.out.println("Total Price     : " +bookedTicketsModel.getTotalPrice());
//break;

//case 13:
////System.out.println("----------------To Delete admin----------------------");
//
//break;
