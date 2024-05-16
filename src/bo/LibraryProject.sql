drop database if exists LibraryProject;

create database LibraryProject;

use LibraryProject;

create table Cohort(
chId int primary key auto_increment,
chName varchar(100)
);
insert into Cohort(chName) values('Drama'), ('Biography'), ('Sci-Fi');

CREATE TABLE Book(
    bId int primary key auto_increment,
    bTitle varchar(255),
    bAuthor varchar(255),
    bPages varchar(255),
    chId int,
    foreign key (chId) references Cohort(chId)
);

CREATE TABLE Person(
    pID int primary key auto_increment,
    name varchar(255),
    username varchar(255),
    password varchar(255),
    address varchar(255),
    email varchar(255),
    role int
);

CREATE TABLE Staff(
    stfId int primary key auto_increment,
    pID int,
    foreign key(pID) references Person(pID)
);
# PERSON RELATION MAINTENANCE #
insert into Person(Name, Username, Password, Role) values('Mr. A', 'aaccount', 'apass', 1);
update Person set Password = 'tbxFJIcpxUW6jSIlRuPfrzwWj8iQYRohETEo+sUPjvI=' where pId = 1;
insert into Person(name, username, password, role) values ('Mr. B', 'testmember', 'testmember', 2);
update Person set password = 'MxmebBk7gAiyOEzBL4kdci9gOD/iZU9UttWHFPswnzU=' where pId = 2;
select * from Person;

# PERSON RELATION MAINTENCE DONE #

CREATE TABLE Loan(
    LID int primary key auto_increment,
    cOut int, 
    cIn int
);

CREATE TABLE Member(
    mID int primary key auto_increment,
    pID int,
    LID int,
    foreign key(LID) references Loan(LID),
    foreign key(pID) references Person(pID)
);

CREATE TABLE Copy(
    cID int primary key auto_increment,
    bID int,
    foreign key(bID) references Book(bID)
);

CREATE TABLE Shelf(
    sID int primary key auto_increment
);

CREATE TABLE Location(
    sID int,
    cID int,
    Genre int,
    foreign key(sID) references Shelf(sID),
    foreign key(cID) references Copy(cID),
    foreign key(Genre) references Cohort(chID)
);

CREATE TABLE CopyInLoan(
    cID int,
    LID int,
    foreign key(cID) references Copy(cID),
    foreign key(LID) references Loan(LID)
); 
select * from Person;