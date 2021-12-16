CREATE TABLE BUS_DETAILS (
  BUS_ID int GENERATED ALWAYS AS IDENTITY START WITH 1,
  OPERATOR_ID int NOT NULL,
  BUS_NAME varchar(50) NOT NULL,
  BUS_FEATURES varchar(50) NOT NULL,
  BUS_CATAGORY varchar(20),
  DEPARTURE_DATE date NOT NULL,
  FROM_CITY varchar(100) NOT NULL,
  TO_CITY varchar(100) NOT NULL,
  DEPARTURE_TIME timestamp NOT NULL,
  ARRIVAL_TIME timestamp NOT NULL,
  TOTAL_SEAT int NOT NULL,
  PRICE int NOT NULL,

  CONSTRAINT pk_busid PRIMARY KEY (Bus_Id),
  CONSTRAINT fk_bus_operatorid FOREIGN KEY (Operator_Id) REFERENCES bus_operators (Operator_Id)
) ;




CREATE TABLE USER_DETAILS (
  USER_ID int GENERATED ALWAYS AS IDENTITY START WITH 1,
  USER_NAME varchar(40) NOT NULL,
  USER_AGE int NOT NULL,
  USER_EMAIL varchar(30) NOT NULL ,
  USER_CONTACT number(10) NOT NULL,
  USER_GENDER varchar(30) NOT NULL,
  USER_PASSWORD varchar(50) NOT NULL ,
  
  CONSTRAINT pk_userid PRIMARY KEY (user_id),
  CONSTRAINT unique_user UNIQUE (user_email, user_password)
);



CREATE TABLE BUS_OPERATORS (
  OPERATOR_ID int GENERATED ALWAYS AS IDENTITY START WITH 1,
  OPERATOR_NAME varchar(40) NOT NULL,
  OPERATOR_EMAIL varchar(40) NULL,
  OPERATOR_CONTACT number(10) NOT NULL,
  OPERATOR_AGE int NOT NULL, 
  
  CONSTRAINT pk_operatorid PRIMARY KEY (Operator_Id)
) ;


CREATE TABLE BOOKED_TICKETS (
  BOOKING_ID int GENERATED ALWAYS AS IDENTITY START WITH 10000,
  USER_ID int NOT NULL,
  BUS_ID int NOT NULL,
  OPERATOR_ID int NOT NULL,
  FROM_CITY varchar(100) NOT NULL,
  TO_CITY varchar(100) NOT NULL,
  BOOKING_DATE date DEFAULT sysdate,
  DEPARTURE_DATE date NOT NULL,
  TICKET_COUNT int NOT NULL,
  SEAT_NO int NOT NULL,
  BUS_CATEGORY varchar(20), 
  BOOKING_STATUS varchar(30),
  TOTAL_PRICE int,

  
  CONSTRAINT pk_bookingid PRIMARY KEY (Booking_Id),
  CONSTRAINT fk_booking_userid FOREIGN KEY (user_Id) REFERENCES user_details (user_Id) ,
  CONSTRAINT fk_booking_operatorid FOREIGN KEY (operator_Id) REFERENCES bus_operators (operator_Id) ,
  CONSTRAINT fk_booking_busid FOREIGN KEY (bus_Id) REFERENCES bus_details (bus_Id) 
);



CREATE TABLE ADMIN_DETAILS (
 ADMIN_ID int GENERATED ALWAYS AS IDENTITY START WITH 1,
 ADMIN_NAME varchar(50) NOT NULL,
 ADMIN_PASSWORD varchar(50) NOT NULL ,
 ADMIN_EMAIL varchar(50) NOT NULL,
 
 CONSTRAINT pk_adminid primary key (Admin_Id),
 CONSTRAINT unique_admin UNIQUE (Admin_Email)
 );

insert into admin_details (ADMIN_NAME,ADMIN_PASSWORD,ADMIN_EMAIL) values ('abdul','abdul','abduladmin@gmail.com');
commit;
desc user_details;

drop table bus_operators;

select * from user_details;
select * from bus_operators;
select  * from bus_details;
select * from ticket_bookings;
select * from admin_details;







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

