CREATE TABLE BUSES (
  BUS_ID int generated always as identity start with 1,
  OPERATOR_ID int NOT NULL,
  BUS_NAME varchar(50) NOT NULL,
  BUS_FEATURES varchar(50) NOT NULL,
  BUS_CATEGORY varchar(20),
  BUS_DATE date NOT NULL,
  FROM_CITY varchar(100) NOT NULL,
  TO_CITY varchar(100) NOT NULL,
  START_TIME timestamp NOT NULL,
  END_TIME timestamp NOT NULL,
  TOTAL_SEAT int NOT NULL,
  TOTAL_PRICE int NOT NULL,

  CONSTRAINT pk_busid PRIMARY KEY (Bus_Id),
  CONSTRAINT fk_bus_operatorid FOREIGN KEY (Operator_Id) REFERENCES bus_operators (Operator_Id)
) ;

drop table buses;


CREATE TABLE USERS (
  USER_ID int generated always as identity start with 1,
  USER_NAME varchar(40) NOT NULL,
  USER_AGE int NOT NULL,
  USER_EMAIL varchar(30) NOT NULL ,
  USER_CONTACT varchar(30) NOT NULL,
  USER_GENDER varchar(30) NOT NULL,
  USER_PASSWORD varchar(50) NOT NULL ,
  USER_WALLET int ,
  
  CONSTRAINT pk_userid PRIMARY KEY (user_id),
  CONSTRAINT unique_user UNIQUE (user_email,user_contact)
);

drop table users;

CREATE TABLE BUS_OPERATORS (
  OPERATOR_ID int generated always as identity start with 1,
  OPERATOR_NAME varchar(40) NOT NULL,
  OPERATOR_EMAIL varchar(40) NOT NULL UNIQUE,
  OPERATOR_CONTACT varchar(30) NOT NULL,
  OPERATOR_AGE int NOT NULL, 
  OPERATOR_DESC varchar(100) NOT NULL,
  
  CONSTRAINT pk_operatorid PRIMARY KEY (Operator_Id)
) ;

drop table bus_operators;

CREATE TABLE TICKET_BOOKINGS (
  BOOKING_ID int generated always as identity start with 10001,  --(booking pnr number)
  USER_ID int NOT NULL,
  BUS_ID int NOT NULL,
  OPERATOR_ID int NOT NULL,
  FROM_CITY varchar(100) NOT NULL,
  TO_CITY varchar(100) NOT NULL,
  BOOKING_DATE date NOT NULL,
  TICKET_COUNT int NOT NULL,
  SEAT_NO int NOT NULL,
  FREIGHT_NO int ,
  BUS_CATAGORY varchar(20), 
  PRICE int,
  

  
  CONSTRAINT pk_bookingid PRIMARY KEY (Booking_Id),
  CONSTRAINT fk_booking_userid FOREIGN KEY (user_Id) REFERENCES users (user_Id) ,
  CONSTRAINT fk_booking_operatorid FOREIGN KEY (operator_Id) REFERENCES bus_operators (operator_Id) ,
  CONSTRAINT fk_booking_busid FOREIGN KEY (bus_Id) REFERENCES buses (bus_Id) 
);

drop table TICKET_BOOKINGS;

CREATE TABLE ADMINS (
 ADMIN_ID int generated always as identity start with 1,
 ADMIN_NAME varchar(128) NOT NULL,
 ADMIN_PASSWORD varchar(128) NOT NULL ,
 ADMIN_EMAIL varchar(128) NOT NULL,
 
 CONSTRAINT pk_adminid primary key (Admin_Id),
 CONSTRAINT unique_admin UNIQUE (Admin_Email)
 );


INSERT INTO admins (admin_name,admin_password,admin_email) values ('Abdul','abdul','abduladmin@gmail.com');
INSERT INTO admins (admin_name,admin_password,admin_email) values ('Afridi','afridi','afridiadmin@gmail.com');

select * from admins;
drop table admins;



desc buses;
commit;

select * from users;
select  * from buses;
select * from bus_operators;
select * from ticketbookings;
select * from admins;
commit;
commit;

drop table bus;
drop table users;
drop table busoperators;
drop table ticketBookings;




  


--
--For agents table

-- CREATE TABLE AGENTS (
--  AGENT_ID varchar(20),
--  AGENT_NAME varchar(128) NOT NULL,
--  AGENT_EMAIL varchar(128) NOT NULL,
--  AGENT_PASSWORD varchar(100) NOT NULL,
--  AGENT_ADDRESS varchar(128) NOT NULL,
--  AGENT_CONTACT int NOT NULL,
--  
--   CONSTRAINT pk_agentid primary key (Agent_Id)
--);


--
----bookinghistory
--CREATE TABLE TRAVELSCHEDULE (  
--  travelscheduleid varchar(128) DEFAULT NULL,
--  UserId varchar(20) DEFAULT NULL,
--  BusId varchar(20) DEFAULT NULL,
--  OperatorId varchar(20) DEFAULT NULL,
--Starting_point varchar(50) DEFAULT NULL,
--Destination varchar(50) DEFAULT NULL,
--  DepartureDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
--  DepartureTime time NOT NULL,
--  fare_amount float NOT NULL,
--  
--   CONSTRAINT travsche_usid_2 FOREIGN KEY (userId) REFERENCES user (userId) ,
--   CONSTRAINT travsche_buid_2 FOREIGN KEY (BusId) REFERENCES bus (BusId) ,
--   CONSTRAINT travsche_opid_2 FOREIGN KEY (OperatorId) REFERENCES busoperator (OperatorId)
--) 
--
--




--
--CREATE TABLE PAYMENT (
--  PaymentId varchar(20) NOT NULL,
--  BookingId varchar(20) DEFAULT NULL,
--  TotalAmount int(6) DEFAULT NULL,
--  amount_paid int(10) DEFAULT NULL,
--  UserId varchar(20) DEFAULT NULL,
--  PaymentDate DATE NOT NULL DEFAULT SYSDATE,
--  TotalSeats int(3) DEFAULT NULL,
----  Status varchar(10) DEFAULT 'NOT PAID',
--
--  PRIMARY KEY (PaymentId),
--  CONSTRAINT payment_usid_2 FOREIGN KEY (userId) REFERENCES user (userId) ,
--  CONSTRAINT payment_bid_1 FOREIGN KEY (BookingId) REFERENCES booking (BookingId),
--) 
