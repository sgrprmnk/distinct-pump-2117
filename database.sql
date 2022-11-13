==========Customer Table==============
create table Customer
(
id int primary key auto_increment,
username varchar(20),
password varchar(20),
 sourceOfTravel varchar(20) ,
 destinationOfTravel varchar(20)
);
+++++++++++++++++++++++
============Admin Table===============
create table Admin
(
id int primary key auto_increment,
username varchar(20),
password varchar(20)
);
++++++++++++++++++++++++
===========Bus Table==================
create table Bus
(
busId int primary key,
busName varchar(20),
busRoute varchar(20),
busType varchar(20),
seats int,
sourceTravel varchar(20),
destinationTravel varchar(20)
);
++++++++++++++++++++++++++
============Bus_Booking Table=============
create table bus_booking
(
busId int,
id int,
conid int,
constraint fk_busId foreign key(busId) references bus(busId),
constraint fk_user foreign key(id) references Customer(id),
constraint fk_con foreign key(id) references Contact(id)
);
+++++++++++++++++++++
=============Contact Table=======================
create table Contact
(
id int primary key auto_increment,
name varchar(20),
phone varchar(12)
);
