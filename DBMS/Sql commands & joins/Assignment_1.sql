create database eCommerce;
use eCommerce;
/*
creating all the required tables
*/
create table user(
    userID int primary key AUTO_INCREMENT,
    name char(30),
    contactNo bigint(10) unique,
    email varchar(20) unique,
    DOB date,
    admin bool
);
create table addresses(
    userID int,
    address varchar(100),
    foreign key (userID)
        references user (userID)
);
create table parentCategories(
    parentCatId int primary key AUTO_INCREMENT,
    parentcategoryName varchar(20)
);
create table categories(
    categoryID int primary key AUTO_INCREMENT,
    categoryName varchar(20),
    parentCatId int,
    foreign key(parentCatId) references categories(categoryId)
);

create table products(
    productID int AUTO_INCREMENT,
    name varchar(20),
    price float(25),
    description varchar(200),
    quantity int,
    addedOn timestamp NOT NULL,
    categoryID int,
    sales int,
    foreign key (categoryID)
        references categories (categoryID),
    primary key (productID)
);
create table orders(
    orderID int not null primary key AUTO_INCREMENT,
    userID int,
    orderDate timestamp,
    orderTotal float,
    foreign key (userID)
        references user (userID)
);
create table orderDetails(
    orderID int,
    shipped bool,
    cancelled bool,
    returned bool,
    productID int,
    foreign key (orderID)
        references orders (orderID),
    foreign key (productID)
        references products (productID)
);

create table images(
    productID int,
    image BLOB,
    foreign key (productID)
        references products (productID)
);



/*
setting constraint check false before deletion of products table because it has child tables
and after deleting set contraint to true again
*/
set FOREIGN_KEY_CHECKS = 0;
drop table products;
set FOREIGN_KEY_CHECKS = 1;



/*
creating products table again 
*/
create table products(
    productID int AUTO_INCREMENT,
    name varchar(20),
    price float(25),
    description varchar(200),
    quantity int,
    addedOn timestamp NOT NULL,
    categoryID int,
    foreign key (categoryID)
        references categories (categoryID),
    sales int,
    primary key (productID)
);
