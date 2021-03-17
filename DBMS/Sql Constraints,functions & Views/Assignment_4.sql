/*
creating database
*/
create database zipCodes;
use zipCodes;

/*
creating required tables
*/
create table states(
    id int primary key AUTO_INCREMENT,
    name varchar(20)
);


create table cities(
    id int primary key AUTO_INCREMENT,
    name varchar(20),
    stateId int,
    foreign key (stateId)
        references states (id)
);


create table zipcodes(
    zipcode int primary key,
    cityId int,
    foreign key (cityId)
        references cities(id)
);

/*
inserting data in states table
*/

insert into states(name) values("Rajasthan");
insert into states(name) values("Gujrat");
insert into states(name) values("Maharashtra");

/*
inserting data in cities table
*/
insert into cities(name,stateId) values("jaipur",1);
insert into cities(name,stateId) values("udaipur",1);
insert into cities(name,stateId) values("banswara",1);
insert into cities(name,stateId) values("ahemdabad",2);
insert into cities(name,stateId) values("surat",2);
insert into cities(name,stateId) values("rajkot",2);
insert into cities(name,stateId) values("mumbai",3);
insert into cities(name,stateId) values("pune",3);

/*
inserting data in zipCodes table
*/
insert into zipCodes(zipcode,cityId) values(302001,1);
insert into zipCodes(zipcode,cityId) values(313001,2);
insert into zipCodes(zipcode,cityId) values(327001,3);
insert into zipCodes(zipcode,cityId) values(380001,4);
insert into zipCodes(zipcode,cityId) values(395003,5);
insert into zipCodes(zipcode,cityId) values(360001,6);
insert into zipCodes(zipcode,cityId) values(400008,7);
insert into zipCodes(zipcode,cityId) values(411001,8);

/*
return Zip Code, City Names and
States ordered by State Name and City Name.
*/
select 
    zc.zipcode, c.name as city_name, s.name as state_name
from
    zipCodes zc,
    cities c,
    states s
where
    zc.cityId = c.id and c.stateId = s.id order by state_name and city_name;
