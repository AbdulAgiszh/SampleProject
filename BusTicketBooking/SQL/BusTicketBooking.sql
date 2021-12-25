CREATE TABLE BUS_DETAILS (
  BUS_ID int GENERATED ALWAYS AS IDENTITY START WITH 1000,
  OPERATOR_ID int ,
  BUS_CATEGORY varchar(20),
  FROM_CITY varchar(100) NOT NULL,
  TO_CITY varchar(100) NOT NULL,
  DEPARTURE timestamp NOT NULL,
  ARRIVAL timestamp NOT NULL,
  SLEEPER_FARE int NULL,
  SEATER_FARE int NULL,
  TOTAL_SEAT int NOT NULL,
  STATUS varchar(50) DEFAULT 'Available',

  CONSTRAINT pk_busid PRIMARY KEY (Bus_Id),
  CONSTRAINT fk_bus_operatorid FOREIGN KEY (Operator_Id) REFERENCES bus_operators (Operator_Id)
) ;
commit;

desc bus_details;


CREATE TABLE USER_DETAILS (
  USER_ID int GENERATED ALWAYS AS IDENTITY START WITH 1,
  USER_NAME varchar(40) NOT NULL,
  USER_AGE int NOT NULL,
  USER_EMAIL varchar(30) NOT NULL ,
  USER_CONTACT int NOT NULL,
  USER_GENDER varchar(30) NOT NULL,
  USER_PASSWORD varchar(50) NOT NULL ,
  USER_WALLET int DEFAULT 0,
  USER_STATUS varchar(50) DEFAULT 'Active',
  
  CONSTRAINT pk_userid PRIMARY KEY (user_id),
  CONSTRAINT unique_user UNIQUE (user_email,user_contact)
);
commit;
updat

CREATE TABLE BUS_OPERATORS (
  OPERATOR_ID int GENERATED ALWAYS AS IDENTITY START WITH 1,
  OPERATOR_NAME varchar(40) NOT NULL,
  OPERATOR_EMAIL varchar(40) NULL,
  OPERATOR_CONTACT int NOT NULL,
  OPERATOR_AGE int NOT NULL, 
  
  CONSTRAINT pk_operatorid PRIMARY KEY (Operator_Id)
) ;


CREATE TABLE BOOKED_TICKETS (
  BOOKING_ID int GENERATED ALWAYS AS IDENTITY START WITH 10000,
  USER_ID int NOT NULL,
  BUS_ID int NOT NULL,
  BOOKING_DATE date DEFAULT sysdate,
  DEPARTURE_DATE date ,
  TICKET_COUNT int NOT NULL,
  SEAT_CATEGORY varchar(50),
  SEAT_NO varchar(50) NOT NULL,
  BOOKING_STATUS varchar(30) DEFAULT 'confirmed',
  TOTAL_PRICE int,
  PAYMENT_STATUS varchar(50),

  CONSTRAINT pk_bookingid PRIMARY KEY (Booking_Id),
  CONSTRAINT fk_booking_userid FOREIGN KEY (user_Id) REFERENCES user_details (user_Id) ,
  CONSTRAINT fk_booking_busid FOREIGN KEY (bus_Id) REFERENCES bus_details (bus_Id) 
);


 

commit;

CREATE TABLE ADMIN_DETAILS (
 ADMIN_ID int GENERATED ALWAYS AS IDENTITY START WITH 1,
 ADMIN_NAME varchar(50) NOT NULL,
 ADMIN_CONTACT int NOT NULL,
 ADMIN_PASSWORD varchar(50) NOT NULL ,
 ADMIN_EMAIL varchar(50) NOT NULL,
 
 CONSTRAINT pk_adminid primary key (Admin_Id),
 CONSTRAINT unique_admin UNIQUE (Admin_Email)
 );
 







--insert into admin_details (ADMIN_NAME,ADMIN_CONTACT,ADMIN_PASSWORD,ADMIN_EMAIL) values ('abdul',6381151931,'abdul','abduladmin@gmail.com');
--insert into bus_details (bus_catagory, from_city, to_city, departure, arrival,sleeper_fare, seater_fare, total_seat) values ('super','trichy','bangalore',to_timestamp ( '21-12-2020 12:12', 'DD-MM-YYYY HH24:MI' ),to_timestamp ( '21-12-2020 23:11', 'DD-MM-YYYY HH24:MI' ),234,555,10);

commit;

select * from bus_details where to_char(departure,'dd-mm-yyyy')='24-12-2021' and from_city='Madurai' and to_city='Chennai';
select booking_id from booked_tickets where user_id=21 and booking_date='23-12-21';
commit;
drop table user_details cascade constraints;

select * from user_details;
select * from bus_operators;
select  * from bus_details;
select * from user_details where user_contact=7373639018 and user_status='Inactive';
select * from booked_tickets;


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

